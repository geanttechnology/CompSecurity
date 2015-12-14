// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.Encoder;
import java.io.OutputStream;

public class NullEncoder
    implements Encoder
{

    private static final NullEncoder NULL_ENCODER = new NullEncoder();

    public NullEncoder()
    {
    }

    public static Encoder get()
    {
        return NULL_ENCODER;
    }

    public boolean encode(Object obj, OutputStream outputstream)
    {
        return false;
    }

    public String getId()
    {
        return "";
    }

}
