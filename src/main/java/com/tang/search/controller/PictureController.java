package com.tang.search.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.tang.search.annotation.AuthCheck;
import com.tang.search.common.BaseResponse;
import com.tang.search.common.DeleteRequest;
import com.tang.search.common.ErrorCode;
import com.tang.search.common.ResultUtils;
import com.tang.search.constant.UserConstant;
import com.tang.search.exception.BusinessException;
import com.tang.search.exception.ThrowUtils;
import com.tang.search.model.dto.picture.PictureQueryRequest;
import com.tang.search.model.dto.post.PostAddRequest;
import com.tang.search.model.dto.post.PostEditRequest;
import com.tang.search.model.dto.post.PostQueryRequest;
import com.tang.search.model.dto.post.PostUpdateRequest;
import com.tang.search.model.entity.Picture;
import com.tang.search.model.entity.Post;
import com.tang.search.model.entity.User;
import com.tang.search.model.vo.PostVO;
import com.tang.search.service.PictureService;
import com.tang.search.service.PostService;
import com.tang.search.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图片接口
 *
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Resource
    private PictureService pictureService;

    /**
     * 分页获取列表（封装类）
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Picture>> listPictureByPage(@RequestBody PictureQueryRequest pictureQueryRequest,
                                                        HttpServletRequest request) {
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        String searchText = pictureQueryRequest.getSearchText();
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);
        return ResultUtils.success(picturePage);
    }


}
