// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

public class HttpUrlGlideUrlLoader
    implements ModelLoader
{
    public static class Factory
        implements ModelLoaderFactory
    {

        private final ModelCache modelCache = new ModelCache(500);

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new HttpUrlGlideUrlLoader(modelCache);
        }

        public void teardown()
        {
        }

        public Factory()
        {
        }
    }


    private final ModelCache modelCache;

    public HttpUrlGlideUrlLoader()
    {
        this(null);
    }

    public HttpUrlGlideUrlLoader(ModelCache modelcache)
    {
        modelCache = modelcache;
    }

    public DataFetcher getResourceFetcher(GlideUrl glideurl, int i, int j)
    {
        GlideUrl glideurl1 = glideurl;
        if (modelCache != null)
        {
            GlideUrl glideurl2 = (GlideUrl)modelCache.get(glideurl, 0, 0);
            glideurl1 = glideurl2;
            if (glideurl2 == null)
            {
                modelCache.put(glideurl, 0, 0, glideurl);
                glideurl1 = glideurl;
            }
        }
        return new HttpUrlFetcher(glideurl1);
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((GlideUrl)obj, i, j);
    }
}
