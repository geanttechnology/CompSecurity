// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

// Referenced classes of package com.bumptech.glide.request.target:
//            BaseTarget, SizeReadyCallback

public abstract class SimpleTarget extends BaseTarget
{

    private final int height;
    private final int width;

    public SimpleTarget()
    {
        this(0x80000000, 0x80000000);
    }

    public SimpleTarget(int i, int j)
    {
        width = i;
        height = j;
    }

    public final void getSize(SizeReadyCallback sizereadycallback)
    {
        if (!Util.isValidDimensions(width, height))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ").append(width).append(" and height: ").append(height).append(", either provide dimensions in the constructor").append(" or call override()").toString());
        } else
        {
            sizereadycallback.onSizeReady(width, height);
            return;
        }
    }
}
