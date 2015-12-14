// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import android.content.Context;
import com.amazon.gallery.framework.model.Persistable;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

// Referenced classes of package com.amazon.gallery.framework.glide:
//            GalleryDataFetcher, ModelFetcher, MediaItemModelFetcher, TagModelFetcher

public class GalleryModelLoader
    implements ModelLoader
{
    public static class MediaItemFactory
        implements ModelLoaderFactory
    {

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new GalleryModelLoader(new MediaItemModelFetcher(context));
        }

        public void teardown()
        {
        }

        public MediaItemFactory()
        {
        }
    }

    public static class TagFactory
        implements ModelLoaderFactory
    {

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new GalleryModelLoader(new TagModelFetcher(context));
        }

        public void teardown()
        {
        }

        public TagFactory()
        {
        }
    }


    private final ModelFetcher modelFetcher;

    public GalleryModelLoader(ModelFetcher modelfetcher)
    {
        modelFetcher = modelfetcher;
    }

    public DataFetcher getResourceFetcher(Persistable persistable, int i, int j)
    {
        return new GalleryDataFetcher(modelFetcher, persistable, i, j);
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((Persistable)obj, i, j);
    }
}
