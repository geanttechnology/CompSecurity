// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import android.graphics.Bitmap;
import com.amazon.ansel.fetch.tools.ref.ObjectReference;

// Referenced classes of package com.amazon.ansel.fetch:
//            UriLoader, LoaderContext, ImageRequest, ImageTask, 
//            ResourceListener, LoaderTask

public class ImageLoader extends UriLoader
{

    private final ImageRequest imageRequest;

    public ImageLoader(LoaderContext loadercontext, long l, ImageRequest imagerequest)
    {
        this(loadercontext, (ObjectReference)null, l, imagerequest);
    }

    public ImageLoader(LoaderContext loadercontext, ResourceListener resourcelistener, long l, ImageRequest imagerequest)
    {
        this(loadercontext, loadercontext.newResourceListenerReference(resourcelistener), l, imagerequest);
    }

    public ImageLoader(LoaderContext loadercontext, ObjectReference objectreference, long l, ImageRequest imagerequest)
    {
        super(loadercontext, android/graphics/Bitmap, objectreference, l, imagerequest.getUriRequest());
        imageRequest = imagerequest;
    }

    public ImageRequest getImageRequest()
    {
        return imageRequest;
    }

    public Object getResourceRequest()
    {
        return imageRequest;
    }

    public LoaderTask newLoaderTask()
    {
        return new ImageTask(getContext(), getResourceKey(), getPriority(), imageRequest);
    }
}
