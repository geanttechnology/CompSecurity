// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;


// Referenced classes of package com.facebook.imagepipeline.memory:
//            BitmapCounter

public class BitmapCounterProvider
{

    private static final long KB = 1024L;
    public static final int MAX_BITMAP_COUNT = 384;
    public static final int MAX_BITMAP_TOTAL_SIZE = getMaxSizeHardCap();
    private static final long MB = 0x100000L;

    public BitmapCounterProvider()
    {
    }

    public static BitmapCounter get()
    {
        return new BitmapCounter(384, MAX_BITMAP_TOTAL_SIZE);
    }

    private static int getMaxSizeHardCap()
    {
        int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 0x7fffffffL);
        if ((long)i > 0x1000000L)
        {
            return (i / 4) * 3;
        } else
        {
            return i / 2;
        }
    }

}
