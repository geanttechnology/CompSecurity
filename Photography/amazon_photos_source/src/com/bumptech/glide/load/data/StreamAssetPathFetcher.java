// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.data:
//            AssetPathFetcher

public class StreamAssetPathFetcher extends AssetPathFetcher
{

    public StreamAssetPathFetcher(AssetManager assetmanager, String s)
    {
        super(assetmanager, s);
    }

    protected void close(InputStream inputstream)
        throws IOException
    {
        inputstream.close();
    }

    protected volatile void close(Object obj)
        throws IOException
    {
        close((InputStream)obj);
    }

    protected InputStream loadResource(AssetManager assetmanager, String s)
        throws IOException
    {
        return assetmanager.open(s);
    }

    protected volatile Object loadResource(AssetManager assetmanager, String s)
        throws IOException
    {
        return loadResource(assetmanager, s);
    }
}
