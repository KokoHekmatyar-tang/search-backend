package com.tang.search.datasource;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Component;

/**
 * 视频数据源
 *
 */
@Component
public class VideoDataSource implements DataSource<Object> {

    @Override
    public Page<Object> doSearch(String searchText, long pageNum, long pageSize) {
        return null;
    }
}
