// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;

public class  extends Model
{

    public Integer height;
    public String url;
    public Integer width;

    public long b()
    {
        if (width == null || height == null)
        {
            return 0L;
        } else
        {
            return (long)(width.intValue() * height.intValue());
        }
    }

    public ()
    {
    }
}
