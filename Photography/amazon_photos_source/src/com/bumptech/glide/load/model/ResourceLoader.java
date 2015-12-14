// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelLoader

public class ResourceLoader
    implements ModelLoader
{

    private final Resources resources;
    private final ModelLoader uriLoader;

    public ResourceLoader(Context context, ModelLoader modelloader)
    {
        this(context.getResources(), modelloader);
    }

    public ResourceLoader(Resources resources1, ModelLoader modelloader)
    {
        resources = resources1;
        uriLoader = modelloader;
    }

    public DataFetcher getResourceFetcher(Integer integer, int i, int j)
    {
        integer = Uri.parse((new StringBuilder()).append("android.resource://").append(resources.getResourcePackageName(integer.intValue())).append('/').append(resources.getResourceTypeName(integer.intValue())).append('/').append(resources.getResourceEntryName(integer.intValue())).toString());
        return uriLoader.getResourceFetcher(integer, i, j);
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((Integer)obj, i, j);
    }
}
