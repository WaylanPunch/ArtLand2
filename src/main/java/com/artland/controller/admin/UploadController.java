package com.artland.controller.admin;

import com.artland.config.Constants;
import com.artland.util.ArtLandUtils;
import com.artland.util.Result;
import com.artland.util.ResultGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Controller
@RequestMapping("/admin")
public class UploadController {

	@PostMapping({"/upload/file"})
	@ResponseBody
	public Result upload(HttpServletRequest httpServletRequest, HttpSession session, @RequestParam("file") MultipartFile file) throws URISyntaxException {
		try {
			//获取当前登入的用户id
			int loginUserId = (int) session.getAttribute("loginUserId");

			//获取文件的原始名称
			String oldFileName = file.getOriginalFilename();

			//获取文件的后缀
			String fileExtension = "." + FilenameUtils.getExtension(oldFileName);
			//System.out.println("getName = " + FilenameUtils.getName(oldFileName));
			//System.out.println("getBaseName = " + FilenameUtils.getBaseName(oldFileName));

			String fileDimension = "";
			File tempFile = File.createTempFile(FilenameUtils.getBaseName(oldFileName), String.valueOf(System.currentTimeMillis())); // 创建临时文件
			FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
			BufferedImage bufferedImage = ImageIO.read(tempFile); // 通过临时文件获取图片流
			if (bufferedImage == null) {
				// 证明上传的文件不是图片，获取图片流失败，不进行下面的操作
			}
			int width = bufferedImage.getWidth(); // 通过图片流获取图片宽度
			int height = bufferedImage.getHeight(); // 通过图片流获取图片高度
			// 省略逻辑判断
			//System.out.println("width = " + width + ", height = " + height);
			fileDimension = width + "x" + height;


			//生成文件名称通用方法
			//生成新的文件名称
			String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "").substring(6) + fileExtension;

			//获取文件大小
			//long fileSize = file.getSize();
			String fileSize = String.format("%.1f", file.getSize() / 1024.0) + "KB";
			//System.out.println("fileSize = " + fileSize);
			//文件类型
			String fileContentType = file.getContentType();
			//System.out.println("fileContentType = " + fileContentType);

			//根据不同日期区分
			String dateDir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String fileFolderStr = Constants.FILE_UPLOAD_DIC + loginUserId + "\\" + dateDir + "\\";
			String fileFullPathStr = fileFolderStr + newFileName;
			File fileFolder = new File(fileFolderStr);
			//创建文件,文件全路径
			File fileFullPath = new File(fileFullPathStr);

			if (!fileFolder.exists()) {
				if (!fileFolder.mkdirs()) {//mkdir创建文件夹结果（不含父文件夹）,mkdirs创建文件夹结果（包含父文件夹）
					throw new IOException("文件夹创建失败,路径为：" + fileFolder);
				}
			}
			file.transferTo(fileFullPath);

			//创建文件URI路径
			String fileRelativeUri = loginUserId + "/" + dateDir + "/" + newFileName;
			String fileAbsoluteUri = ArtLandUtils.getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + fileRelativeUri;

			Map data = new HashMap();
			data.put("fileDimension", fileDimension);
			data.put("fileSize", fileSize);
			data.put("fileContentType", fileContentType);
			data.put("fileAbsoluteUri", fileAbsoluteUri);

			Result resultSuccess = ResultGenerator.genSuccessResult();
			resultSuccess.setData(data);
			return resultSuccess;
		} catch (IOException e) {
			e.printStackTrace();
			return ResultGenerator.genFailResult("文件上传失败");
		}
	}

}
