package org.akatsuki.itachi.service;

import org.akatsuki.itachi.meta.CloudSong;

/**
 * Created by long.yl on 2016/7/4.
 */
public interface CloudSongService {
    boolean addCloudSong(CloudSong song);
    CloudSong getCloudSongById(long id);
}
