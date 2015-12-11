// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class HeapResource
    implements Resource
{

    private final byte b[];

    public HeapResource(byte abyte0[])
    {
        b = abyte0;
    }

    public void dispose()
    {
    }

    byte[] getByteArray()
    {
        return b;
    }

    public InputStream getInputStream()
    {
        return new ByteArrayInputStream(b);
    }

    public long length()
    {
        return (long)b.length;
    }
}
