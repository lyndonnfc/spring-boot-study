package com.lyndon.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lyndon on 2018/4/26.
 */
@Service
public class RedisService {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setList(Object key,List<Object> value) {
        value.forEach(o -> redisTemplate.opsForList().leftPush(key,o));

    }

    public Boolean delKey(Object key) {
        return redisTemplate.delete(key);
    }

    public List getAllListByKey(Object key) {
        return redisTemplate.opsForList().range(key,0,-1);
    }




}
