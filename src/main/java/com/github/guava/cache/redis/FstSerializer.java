package com.github.guava.cache.redis;

import org.nustaq.serialization.FSTConfiguration;

/**
 * @author fanliwen
 */
public class FstSerializer implements Serializer {

    static FSTConfiguration singletonConf = FSTConfiguration.createDefaultConfiguration();

    public static FSTConfiguration getInstance() {
        return singletonConf;
    }

    @Override
    public byte[] serialize(Object obj) {
        return getInstance().asByteArray(obj);
    }

    @Override
    public <T> T deserialize(byte[] objectData) {
        return (T) getInstance().asObject(objectData);
    }
}
