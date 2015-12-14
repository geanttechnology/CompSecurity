// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;


// Referenced classes of package com.picsart.studio.gifencoder:
//            d, GifDrawable, GifInfoHandle, b

final class b extends d
{

    private int b;
    private GifDrawable c;

    public final void a()
    {
        c.mNativeInfoHandle.seekToTime(b, c.mBuffer);
        a.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
    }

    (GifDrawable gifdrawable, GifDrawable gifdrawable1, int i)
    {
        c = gifdrawable;
        b = i;
        super(gifdrawable1);
    }
}
