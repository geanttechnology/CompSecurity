// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;


// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            Downsampler

static final class  extends Downsampler
{

    public String getId()
    {
        return "AT_MOST.com.bumptech.glide.load.data.bitmap";
    }

    protected int getSampleSize(int i, int j, int k, int l)
    {
        return Math.max(j / l, i / k);
    }

    ()
    {
    }
}
