// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils;

import org.apache.commons.lang3.Validate;

public class Dimension
{

    public final int h;
    public final int w;

    public Dimension(int i, int j)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Width must be positive.", new Object[0]);
        if (j > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Height must be positive.", new Object[0]);
        w = i;
        h = j;
    }

    public Dimension(int i, int j, double d)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Width must be positive.", new Object[0]);
        if (j > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Height must be positive.", new Object[0]);
        if (d > 0.0D)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "Scale must be positive.", new Object[0]);
        w = (int)((double)i * d);
        h = (int)((double)j * d);
    }

    public Dimension(Dimension dimension, double d)
    {
        this(dimension.w, dimension.h, d);
    }
}
