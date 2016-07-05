package org.akatsuki.itachi.mapper;

import org.akatsuki.itachi.meta.CloudSong;
import org.apache.ibatis.annotations.*;

/**
 * @author long.yl.
 * @Date 2016/7/1
 */
public interface CloudSongMapper {

    @Insert("insert into TB_Content_Song(title, duration, lyrics, tag, singerId)"
            + " values (#{title}, #{duration}, #{lyrics}, #{tag}, #{singerId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(CloudSong obj);

    @Select("select * from TB_Content_CloudSong where id =  #{id}")
    @Options(useCache = false)
    CloudSong getById(@Param("id") long id);
}
