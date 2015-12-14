// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.UriLoader;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.model.stream:
//            StreamModelLoader

public class StreamUriLoader extends UriLoader
    implements StreamModelLoader
{
    public static class Factory
        implements ModelLoaderFactory
    {

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new StreamUriLoader(context, genericloaderfactory.buildModelLoader(com/bumptech/glide/load/model/GlideUrl, java/io/InputStream));
        }

        public void teardown()
        {
        }

        public Factory()
        {
        }
    }


    public StreamUriLoader(Context context, ModelLoader modelloader)
    {
        super(context, modelloader);
    }

    protected DataFetcher getAssetPathFetcher(Context context, String s)
    {
        return new StreamAssetPathFetcher(context.getApplicationContext().getAssets(), s);
    }

    protected DataFetcher getLocalUriFetcher(Context context, Uri uri)
    {
        return new StreamLocalUriFetcher(context, uri);
    }
}
