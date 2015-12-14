// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.UriLoader;

// Referenced classes of package com.bumptech.glide.load.model.file_descriptor:
//            FileDescriptorModelLoader

public class FileDescriptorUriLoader extends UriLoader
    implements FileDescriptorModelLoader
{
    public static class Factory
        implements ModelLoaderFactory
    {

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new FileDescriptorUriLoader(context, genericloaderfactory.buildModelLoader(com/bumptech/glide/load/model/GlideUrl, android/os/ParcelFileDescriptor));
        }

        public void teardown()
        {
        }

        public Factory()
        {
        }
    }


    public FileDescriptorUriLoader(Context context, ModelLoader modelloader)
    {
        super(context, modelloader);
    }

    protected DataFetcher getAssetPathFetcher(Context context, String s)
    {
        return new FileDescriptorAssetPathFetcher(context.getApplicationContext().getAssets(), s);
    }

    protected DataFetcher getLocalUriFetcher(Context context, Uri uri)
    {
        return new FileDescriptorLocalUriFetcher(context, uri);
    }
}
