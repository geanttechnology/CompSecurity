// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.boldchat.sdk.utils:
//            ImageCache, DrawableReadyListener

public static class source extends AsyncTask
{

    String source;

    private InputStream fetch(String s)
        throws MalformedURLException, IOException
    {
        return (new DefaultHttpClient()).execute(new HttpGet(s)).getEntity().getContent();
    }

    protected transient Drawable doInBackground(String as[])
    {
        source = as[0];
        return fetchDrawable(source);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    public Drawable fetchDrawable(String s)
    {
        Drawable drawable;
        try
        {
            drawable = Drawable.createFromStream(fetch(s), "src");
        }
        catch (Exception exception)
        {
            Log.i("BOLD", (new StringBuilder()).append("Failed to fetch image ").append(s).toString(), exception);
            return null;
        }
        return drawable;
    }

    protected void onPostExecute(Drawable drawable)
    {
        synchronized (ImageCache.access$000())
        {
            if (android.os._fld0 >= 12 && ImageCache.access$100() != null)
            {
                ImageCache.access$100().put(source, drawable);
            }
        }
        ArrayList arraylist;
        synchronized (ImageCache.access$200())
        {
            arraylist = (ArrayList)ImageCache.access$200().remove(source);
        }
        if (arraylist != null)
        {
            for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext();)
            {
                DrawableReadyListener drawablereadylistener = (DrawableReadyListener)((Iterator) (obj)).next();
                if (drawable != null)
                {
                    drawablereadylistener.onDrawableReady(source, drawable);
                } else
                {
                    drawablereadylistener.onDrawableLoadFailed(source);
                }
            }

        }
        break MISSING_BLOCK_LABEL_125;
        drawable;
        obj;
        JVM INSTR monitorexit ;
        throw drawable;
        drawable;
        obj;
        JVM INSTR monitorexit ;
        throw drawable;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Drawable)obj);
    }

    public ()
    {
        source = null;
    }
}
