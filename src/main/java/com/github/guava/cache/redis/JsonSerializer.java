package com.github.guava.cache.redis;

/**
 * @author wasanthah
 */
public interface JsonSerializer {

    String serialize(final Object obj);

    <T> T deserialize(final String objectData);

    <T> T deserializeV(final String objectData, Class<T> vClass);
}
