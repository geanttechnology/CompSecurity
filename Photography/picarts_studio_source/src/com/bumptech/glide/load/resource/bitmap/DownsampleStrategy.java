// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;


// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            m, n, k, l, 
//            o

public abstract class DownsampleStrategy
{

    public static final DownsampleStrategy a = new m((byte)0);
    public static final DownsampleStrategy b = new n((byte)0);
    public static final DownsampleStrategy c = new k((byte)0);
    public static final DownsampleStrategy d = new l((byte)0);

    public DownsampleStrategy()
    {
    }

    public abstract float a(int i, int j, int i1, int j1);

    public abstract SampleSizeRounding a();

    static 
    {
        new o((byte)0);
    }
}
