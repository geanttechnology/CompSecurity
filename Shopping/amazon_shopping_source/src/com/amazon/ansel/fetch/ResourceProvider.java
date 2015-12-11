// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;


// Referenced classes of package com.amazon.ansel.fetch:
//            LoaderGroup, ImageLoader, LoaderContext, ImageRequest, 
//            ResourceListener

public class ResourceProvider extends LoaderGroup
{

    public ResourceProvider(LoaderContext loadercontext)
    {
        super(loadercontext);
    }

    public ResourceProvider(LoaderGroup loadergroup)
    {
        super(loadergroup);
    }

    public void getImage(ImageRequest imagerequest, ResourceListener resourcelistener)
    {
        execute(new ImageLoader(getContext(), resourcelistener, 0L, imagerequest));
    }
}
