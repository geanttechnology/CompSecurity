// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import com.ebay.nautilus.kernel.util.StreamUtil;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JsonPersistenceMapper
    implements CacheManager.PersitenceMapper
{

    private final Gson mapper;

    protected JsonPersistenceMapper(Gson gson)
    {
        mapper = gson;
    }

    public static JsonPersistenceMapper create(Gson gson)
    {
        return new JsonPersistenceMapper(gson);
    }

    public void deflateCached(OutputStream outputstream, Object obj)
        throws IOException
    {
        outputstream = StreamUtil.streamToWriter(outputstream, "UTF-8");
        mapper.toJson(obj, outputstream);
        StreamUtil.closeQuietly(outputstream);
        return;
        obj;
        throw new IOException(((Throwable) (obj)));
        obj;
        StreamUtil.closeQuietly(outputstream);
        throw obj;
    }

    public Object inflateCached(InputStream inputstream, Class class1)
        throws IOException
    {
        inputstream = StreamUtil.streamToReader(inputstream, "UTF-8");
        class1 = ((Class) (mapper.fromJson(inputstream, class1)));
        StreamUtil.closeQuietly(inputstream);
        return class1;
        class1;
        throw new IOException(class1);
        class1;
        StreamUtil.closeQuietly(inputstream);
        throw class1;
    }
}
