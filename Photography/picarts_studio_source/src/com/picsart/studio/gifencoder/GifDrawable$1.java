// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;


// Referenced classes of package com.picsart.studio.gifencoder:
//            d, GifDrawable, GifInfoHandle

final class b extends d
{

    private GifDrawable b;

    public final void a()
    {
        if (b.mNativeInfoHandle.reset())
        {
            b.start();
        }
    }

    (GifDrawable gifdrawable, GifDrawable gifdrawable1)
    {
        b = gifdrawable;
        super(gifdrawable1);
    }
}
