// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelLoader, AssetUriParser, GlideUrl

public abstract class UriLoader
    implements ModelLoader
{

    private final Context context;
    private final ModelLoader urlLoader;

    public UriLoader(Context context1, ModelLoader modelloader)
    {
        context = context1;
        urlLoader = modelloader;
    }

    private static boolean isLocalUri(String s)
    {
        return "file".equals(s) || "content".equals(s) || "android.resource".equals(s);
    }

    protected abstract DataFetcher getAssetPathFetcher(Context context1, String s);

    protected abstract DataFetcher getLocalUriFetcher(Context context1, Uri uri);

    public final DataFetcher getResourceFetcher(Uri uri, int i, int j)
    {
        Object obj;
        String s;
        s = uri.getScheme();
        obj = null;
        if (!isLocalUri(s)) goto _L2; else goto _L1
_L1:
        if (!AssetUriParser.isAssetUri(uri)) goto _L4; else goto _L3
_L3:
        DataFetcher datafetcher;
        uri = AssetUriParser.toAssetPath(uri);
        datafetcher = getAssetPathFetcher(context, uri);
_L6:
        return datafetcher;
_L4:
        return getLocalUriFetcher(context, uri);
_L2:
        datafetcher = obj;
        if (urlLoader == null) goto _L6; else goto _L5
_L5:
        if ("http".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        datafetcher = obj;
        if (!"https".equals(s)) goto _L6; else goto _L7
_L7:
        return urlLoader.getResourceFetcher(new GlideUrl(uri.toString()), i, j);
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((Uri)obj, i, j);
    }
}
