// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayPersistenceMapper
    implements CacheManager.PersitenceMapper
{

    private static final ByteArrayPersistenceMapper instance = new ByteArrayPersistenceMapper();

    private ByteArrayPersistenceMapper()
    {
    }

    public static ByteArrayPersistenceMapper get()
    {
        return instance;
    }

    public void deflateCached(OutputStream outputstream, Object obj)
        throws IOException
    {
        outputstream.write((byte[])(byte[])obj);
    }

    public Object inflateCached(InputStream inputstream, Class class1)
        throws IOException
    {
        return StreamUtil.streamToBytes(inputstream);
    }

}
