// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawableResource;

// Referenced classes of package com.bumptech.glide.load.resource.transcode:
//            ResourceTranscoder

public class GlideBitmapDrawableTranscoder
    implements ResourceTranscoder
{

    private final BitmapPool bitmapPool;
    private final Resources resources;

    public GlideBitmapDrawableTranscoder(Resources resources1, BitmapPool bitmappool)
    {
        resources = resources1;
        bitmapPool = bitmappool;
    }

    public String getId()
    {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public Resource transcode(Resource resource)
    {
        return new GlideBitmapDrawableResource(new GlideBitmapDrawable(resources, (Bitmap)resource.get()), bitmapPool);
    }
}
