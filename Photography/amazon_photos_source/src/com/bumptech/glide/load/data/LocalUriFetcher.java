// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.data:
//            DataFetcher

public abstract class LocalUriFetcher
    implements DataFetcher
{

    private final Context context;
    private Object data;
    private final Uri uri;

    public LocalUriFetcher(Context context1, Uri uri1)
    {
        context = context1.getApplicationContext();
        uri = uri1;
    }

    public void cancel()
    {
    }

    public void cleanup()
    {
        if (data == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        close(data);
_L1:
        return;
        IOException ioexception;
        ioexception;
        if (Log.isLoggable("LocalUriFetcher", 2))
        {
            Log.v("LocalUriFetcher", "failed to close data", ioexception);
            return;
        }
          goto _L1
    }

    protected abstract void close(Object obj)
        throws IOException;

    public String getId()
    {
        return uri.toString();
    }

    public final Object loadData(Priority priority)
        throws Exception
    {
        priority = context.getContentResolver();
        data = loadResource(uri, priority);
        return data;
    }

    protected abstract Object loadResource(Uri uri1, ContentResolver contentresolver)
        throws FileNotFoundException;
}
