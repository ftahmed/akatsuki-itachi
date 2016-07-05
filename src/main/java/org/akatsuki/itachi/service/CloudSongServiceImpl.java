package org.akatsuki.itachi.service;

import org.akatsuki.itachi.mapper.CloudSongMapper;
import org.akatsuki.itachi.meta.CloudSong;
import org.akatsuki.itachi.unfinish.FromMaster;
import org.akatsuki.itachi.unfinish.FromSlaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by long.yl on 2016/7/4.
 */
@Component
public class CloudSongServiceImpl implements CloudSongService {

    @Autowired
    CloudSongMapper mapper;

    @Override
    @FromMaster
    public boolean addCloudSong(CloudSong song) {
//        DBContextHolder.setDBMaster();
        return mapper.add(song) > 0;
    }

    @Override
    @FromSlaver
    public CloudSong getCloudSongById(long id) {
//        DBContextHolder.setDBSlaver();
        return mapper.getById(id);
    }
}
