// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;


// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            DownsampleStrategy

final class o extends DownsampleStrategy
{

    private o()
    {
    }

    o(byte byte0)
    {
        this();
    }

    public final float a(int i, int j, int k, int l)
    {
        return 1.0F;
    }

    public final DownsampleStrategy.SampleSizeRounding a()
    {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }
}
