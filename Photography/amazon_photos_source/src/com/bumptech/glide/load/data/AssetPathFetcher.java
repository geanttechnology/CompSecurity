// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.data:
//            DataFetcher

public abstract class AssetPathFetcher
    implements DataFetcher
{

    private final AssetManager assetManager;
    private final String assetPath;
    private Object data;

    public AssetPathFetcher(AssetManager assetmanager, String s)
    {
        assetManager = assetmanager;
        assetPath = s;
    }

    public void cancel()
    {
    }

    public void cleanup()
    {
        if (data != null)
        {
            try
            {
                close(data);
                return;
            }
            catch (IOException ioexception)
            {
                if (Log.isLoggable("AssetUriFetcher", 2))
                {
                    Log.v("AssetUriFetcher", "Failed to close data", ioexception);
                    return;
                }
            }
        }
    }

    protected abstract void close(Object obj)
        throws IOException;

    public String getId()
    {
        return assetPath;
    }

    public Object loadData(Priority priority)
        throws Exception
    {
        data = loadResource(assetManager, assetPath);
        return data;
    }

    protected abstract Object loadResource(AssetManager assetmanager, String s)
        throws IOException;
}
