// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.UrlLoader;
import java.io.InputStream;

public class StreamUrlLoader extends UrlLoader
{
    public static class Factory
        implements ModelLoaderFactory
    {

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new StreamUrlLoader(genericloaderfactory.buildModelLoader(com/bumptech/glide/load/model/GlideUrl, java/io/InputStream));
        }

        public void teardown()
        {
        }

        public Factory()
        {
        }
    }


    public StreamUrlLoader(ModelLoader modelloader)
    {
        super(modelloader);
    }
}
