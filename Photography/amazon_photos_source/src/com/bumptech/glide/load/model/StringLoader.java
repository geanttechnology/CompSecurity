// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelLoader

public class StringLoader
    implements ModelLoader
{

    private final ModelLoader uriLoader;

    public StringLoader(ModelLoader modelloader)
    {
        uriLoader = modelloader;
    }

    private static Uri toFileUri(String s)
    {
        return Uri.fromFile(new File(s));
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((String)obj, i, j);
    }

    public DataFetcher getResourceFetcher(String s, int i, int j)
    {
        if (!s.startsWith("/")) goto _L2; else goto _L1
_L1:
        Uri uri = toFileUri(s);
_L4:
        return uriLoader.getResourceFetcher(uri, i, j);
_L2:
        Uri uri1 = Uri.parse(s);
        uri = uri1;
        if (uri1.getScheme() == null)
        {
            uri = toFileUri(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
