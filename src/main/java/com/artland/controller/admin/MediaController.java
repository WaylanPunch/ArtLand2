package com.artland.controller.admin;

import com.artland.config.Constants;

import com.artland.service.CategoryService;
import com.artland.util.PageQueryUtil;
import com.artland.util.Result;
import com.artland.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Controller
@RequestMapping("/admin")
public class MediaController {

	@Autowired
	private MediaService mediaService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/medias/transfer")
	public String edit(HttpServletRequest request) {
		request.setAttribute("path", "transfer");
		request.setAttribute("categories", categoryService.getAllCategories());
		return "admin/transfer";
	}

	@GetMapping("/medias")
	public String list(HttpServletRequest request) {
		request.setAttribute("path", "medias");
		return "admin/medias";
	}

}
