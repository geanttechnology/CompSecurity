// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;

// Referenced classes of package com.bumptech.glide.load.model.file_descriptor:
//            FileDescriptorModelLoader

public class FileDescriptorResourceLoader extends ResourceLoader
    implements FileDescriptorModelLoader
{
    public static class Factory
        implements ModelLoaderFactory
    {

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new FileDescriptorResourceLoader(context, genericloaderfactory.buildModelLoader(android/net/Uri, android/os/ParcelFileDescriptor));
        }

        public void teardown()
        {
        }

        public Factory()
        {
        }
    }


    public FileDescriptorResourceLoader(Context context, ModelLoader modelloader)
    {
        super(context, modelloader);
    }
}
