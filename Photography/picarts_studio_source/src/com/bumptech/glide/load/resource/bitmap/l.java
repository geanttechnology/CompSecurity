// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;


// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            DownsampleStrategy

final class l extends DownsampleStrategy
{

    private l()
    {
    }

    l(byte byte0)
    {
        this();
    }

    public final float a(int i, int j, int k, int i1)
    {
        boolean flag = true;
        i = (int)Math.ceil(Math.max((float)j / (float)i1, (float)i / (float)k));
        j = Math.max(1, Integer.highestOneBit(i));
        if (j < i)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        return 1.0F / (float)(j << i);
    }

    public final DownsampleStrategy.SampleSizeRounding a()
    {
        return DownsampleStrategy.SampleSizeRounding.MEMORY;
    }
}
