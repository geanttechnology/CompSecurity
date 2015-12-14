// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;
import java.net.URL;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelLoader, GlideUrl

public class UrlLoader
    implements ModelLoader
{

    private final ModelLoader glideUrlLoader;

    public UrlLoader(ModelLoader modelloader)
    {
        glideUrlLoader = modelloader;
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((URL)obj, i, j);
    }

    public DataFetcher getResourceFetcher(URL url, int i, int j)
    {
        return glideUrlLoader.getResourceFetcher(new GlideUrl(url), i, j);
    }
}
