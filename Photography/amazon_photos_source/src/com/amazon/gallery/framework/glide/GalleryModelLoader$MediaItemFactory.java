// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

// Referenced classes of package com.amazon.gallery.framework.glide:
//            GalleryModelLoader, MediaItemModelFetcher

public static class 
    implements ModelLoaderFactory
{

    public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
    {
        return new GalleryModelLoader(new MediaItemModelFetcher(context));
    }

    public void teardown()
    {
    }

    public ()
    {
    }
}
