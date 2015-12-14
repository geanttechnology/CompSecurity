// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifDrawable

public class GifDrawableResource extends DrawableResource
{

    public GifDrawableResource(GifDrawable gifdrawable)
    {
        super(gifdrawable);
    }

    public int getSize()
    {
        int i = ((GifDrawable)drawable).getData().length;
        return Util.getBitmapByteSize(((GifDrawable)drawable).getFirstFrame()) + i;
    }

    public void recycle()
    {
        ((GifDrawable)drawable).stop();
        ((GifDrawable)drawable).recycle();
    }
}
