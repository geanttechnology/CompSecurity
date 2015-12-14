// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            GlideBitmapDrawable

public class GlideBitmapDrawableResource extends DrawableResource
{

    private final BitmapPool bitmapPool;

    public GlideBitmapDrawableResource(GlideBitmapDrawable glidebitmapdrawable, BitmapPool bitmappool)
    {
        super(glidebitmapdrawable);
        bitmapPool = bitmappool;
    }

    public int getSize()
    {
        return Util.getBitmapByteSize(((GlideBitmapDrawable)drawable).getBitmap());
    }

    public void recycle()
    {
        bitmapPool.put(((GlideBitmapDrawable)drawable).getBitmap());
    }
}
