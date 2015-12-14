// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;

public class ResizeOptions
{

    public final int height;
    public final int width;

    public ResizeOptions(int i, int j)
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
        Preconditions.checkArgument(flag);
        if (j > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        width = i;
        height = j;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ResizeOptions))
            {
                return false;
            }
            obj = (ResizeOptions)obj;
            if (width != ((ResizeOptions) (obj)).width || height != ((ResizeOptions) (obj)).height)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return HashCodeUtil.hashCode(width, height);
    }

    public String toString()
    {
        return String.format((Locale)null, "%dx%d", new Object[] {
            Integer.valueOf(width), Integer.valueOf(height)
        });
    }
}
