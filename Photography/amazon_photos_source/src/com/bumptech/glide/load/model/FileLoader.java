// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelLoader

public class FileLoader
    implements ModelLoader
{

    private final ModelLoader uriLoader;

    public FileLoader(ModelLoader modelloader)
    {
        uriLoader = modelloader;
    }

    public DataFetcher getResourceFetcher(File file, int i, int j)
    {
        return uriLoader.getResourceFetcher(Uri.fromFile(file), i, j);
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((File)obj, i, j);
    }
}
