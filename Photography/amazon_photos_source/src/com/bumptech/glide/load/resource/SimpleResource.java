// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;

public class SimpleResource
    implements Resource
{

    protected final Object data;

    public SimpleResource(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Data must not be null");
        } else
        {
            data = obj;
            return;
        }
    }

    public final Object get()
    {
        return data;
    }

    public final int getSize()
    {
        return 1;
    }

    public void recycle()
    {
    }
}
