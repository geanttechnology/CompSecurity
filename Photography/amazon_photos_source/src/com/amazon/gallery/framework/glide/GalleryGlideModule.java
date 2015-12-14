// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import android.content.Context;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import java.io.InputStream;

public class GalleryGlideModule
    implements GlideModule
{

    public GalleryGlideModule()
    {
    }

    public void applyOptions(Context context, GlideBuilder glidebuilder)
    {
    }

    public void registerComponents(Context context, Glide glide)
    {
        glide.register(com/amazon/gallery/framework/model/media/MediaItem, java/io/InputStream, new GalleryModelLoader.MediaItemFactory());
        glide.register(com/amazon/gallery/framework/model/tags/Tag, java/io/InputStream, new GalleryModelLoader.TagFactory());
    }
}
