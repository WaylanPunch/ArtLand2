// Tags Input
$('#mediaTags').tagsInput({
    width: '100%',
    height: '38px',
    defaultText: '文件标签'
});

//Initialize Select2 Elements
$('.select2').select2()

$(function () {

    new AjaxUpload('#mediaCoverImage', {
        action: '/admin/upload/file',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.resultCode == 200) {
                $("#mediaCoverImage").attr("src", r.data.fileAbsoluteUri);
                $("#mediaCoverImage").attr("style", "width: inherit;display:block;");

                $("#mediaDimension").val(r.data.fileDimension);
                $("#mediaFormat").val(r.data.fileContentType);
                $("#mediaSize").val(r.data.fileSize);
                return false;
            } else {
                alert("error");
            }
        }
    });
});

$('#confirmButton').click(function () {
    var mediaId = $('#mediaId').val();
    var mediaTitle = $('#mediaTitle').val();
    var mediaSubUrl = $('#mediaSubUrl').val();
    var mediaCategoryId = $('#mediaCategoryId').val();
    var mediaTags = $('#mediaTags').val();
    var mediaDescription = $('#mediaDescription').text();
    var mediaLicense = $('#mediaLicense').text();
    var mediaStatus = $("input[name='mediaStatus']:checked").val();
    var enableComment = $("input[name='enableComment']:checked").val();
    var mediaCoverImage = $('#mediaCoverImage')[0].src;

    var mediaDimension = $('#mediaDimension').val();
    var mediaFormat = $('#mediaFormat').val();
    var mediaSize = $('#mediaSize').val();

    if (isNull(mediaTitle)) {
        swal("请输入文件标题", {
            icon: "error",
        });
        return;
    }
    if (!validLength(mediaTitle, 150)) {
        swal("标题过长", {
            icon: "error",
        });
        return;
    }
    if (!validLength(mediaSubUrl, 150)) {
        swal("路径过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(mediaCategoryId)) {
        swal("请选择文件分类", {
            icon: "error",
        });
        return;
    }
    if (isNull(mediaTags)) {
        swal("请输入文件标签", {
            icon: "error",
        });
        return;
    }
    if (!validLength(mediaTags, 150)) {
        swal("标签过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(mediaDescription)) {
        swal("请输入文件描述内容", {
            icon: "error",
        });
        return;
    }
    if (!validLength(mediaDescription, 500)) {
        swal("文件描述内容过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(mediaLicense)) {
        swal("请输入文件许可", {
            icon: "error",
        });
        return;
    }
    if (!validLength(mediaLicense, 500)) {
        swal("文件许可过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(mediaCoverImage) || mediaCoverImage.indexOf('upload') != -1) {
        swal("文件不能为空", {
            icon: "error",
        });
        return;
    }


    var url = '/admin/medias/save';
    var swlMessage = '上传成功';
    var data = {
        "mediaTitle": mediaTitle,
        "mediaSubUrl": mediaSubUrl,
        "mediaCategoryId": mediaCategoryId,
        "mediaTags": mediaTags,
        "mediaDescription": mediaDescription,
        "mediaLicense": mediaLicense,
        "mediaCoverImage": mediaCoverImage,
        "mediaStatus": mediaStatus,
        "enableComment": enableComment,
        "mediaDimension": mediaDimension,
        "mediaFormat": mediaFormat,
        "mediaSize": mediaSize
    };
    if (mediaId > 0) {
        url = '/admin/medias/update';
        swlMessage = '修改成功';
        data = {
            "mediaId": mediaId,
            "mediaTitle": mediaTitle,
            "mediaSubUrl": mediaSubUrl,
            "mediaCategoryId": mediaCategoryId,
            "mediaTags": mediaTags,
            "mediaDescription": mediaDescription,
            "mediaLicense": mediaLicense,
            "mediaCoverImage": mediaCoverImage,
            "mediaStatus": mediaStatus,
            "enableComment": enableComment
        };
    }
    //console.log(data);
    $.ajax({
        type: 'POST',//方法类型
        url: url,
        data: data,
        success: function (result) {
            if (result.resultCode == 200) {
                $('#articleModal').modal('hide');
                swal({
                    title: swlMessage,
                    type: 'success',
                    showCancelButton: false,
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: '返回文件列表',
                    confirmButtonClass: 'btn btn-success',
                    buttonsStyling: false
                }).then(function () {
                    window.location.href = "/admin/medias";
                })
            }
            else {
                $('#articleModal').modal('hide');
                swal(result.message, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});

$('#cancelButton').click(function () {
    window.location.href = "/admin/medias";
});

