// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.OutputStream;

public class NullResourceEncoder
    implements ResourceEncoder
{

    private static final NullResourceEncoder NULL_ENCODER = new NullResourceEncoder();

    public NullResourceEncoder()
    {
    }

    public static NullResourceEncoder get()
    {
        return NULL_ENCODER;
    }

    public boolean encode(Resource resource, OutputStream outputstream)
    {
        return false;
    }

    public volatile boolean encode(Object obj, OutputStream outputstream)
    {
        return encode((Resource)obj, outputstream);
    }

    public String getId()
    {
        return "";
    }

}
