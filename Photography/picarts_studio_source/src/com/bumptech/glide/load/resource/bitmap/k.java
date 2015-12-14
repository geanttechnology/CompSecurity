// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;


// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            DownsampleStrategy

final class k extends DownsampleStrategy
{

    private k()
    {
    }

    k(byte byte0)
    {
        this();
    }

    public final float a(int i, int j, int l, int i1)
    {
        i = Math.min(j / i1, i / l);
        if (i == 0)
        {
            return 1.0F;
        } else
        {
            return 1.0F / (float)Integer.highestOneBit(i);
        }
    }

    public final DownsampleStrategy.SampleSizeRounding a()
    {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }
}
