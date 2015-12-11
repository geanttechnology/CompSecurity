// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
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
//            DrawableReadyListener

public class ImageCache
{
    public static class ImageGetterAsyncTask extends AsyncTask
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
            synchronized (ImageCache.locker)
            {
                if (android.os.Build.VERSION.SDK_INT >= 12 && ImageCache.cache != null)
                {
                    ImageCache.cache.put(source, drawable);
                }
            }
            ArrayList arraylist;
            synchronized (ImageCache.activeListeners)
            {
                arraylist = (ArrayList)ImageCache.activeListeners.remove(source);
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

        public ImageGetterAsyncTask()
        {
            source = null;
        }
    }


    private static HashMap activeListeners = new HashMap();
    private static LruCache cache = null;
    private static Object locker = new Object();

    public static Drawable getImage(String s, DrawableReadyListener drawablereadylistener, Context context)
    {
        ArrayList arraylist = null;
        Object obj = locker;
        obj;
        JVM INSTR monitorenter ;
        Drawable drawable = arraylist;
        if (android.os.Build.VERSION.SDK_INT < 12) goto _L2; else goto _L1
_L1:
        if (cache != null) goto _L4; else goto _L3
_L3:
        cache = new LruCache(context.getResources().getInteger(com.boldchat.sdk.R.integer.bc_image_cache_max));
        drawable = arraylist;
_L2:
        obj;
        JVM INSTR monitorexit ;
        if (drawable != null) goto _L6; else goto _L5
_L5:
        boolean flag = false;
        context = activeListeners;
        context;
        JVM INSTR monitorenter ;
        arraylist = (ArrayList)activeListeners.get(s);
        if (arraylist != null) goto _L8; else goto _L7
_L7:
        flag = true;
        arraylist = new ArrayList(2);
        arraylist.add(drawablereadylistener);
        activeListeners.put(s, arraylist);
_L12:
        context;
        JVM INSTR monitorexit ;
        if (!flag) goto _L6; else goto _L9
_L9:
        Log.d("BOLD", (new StringBuilder()).append("Fetching image ").append(s).toString());
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L11; else goto _L10
_L10:
        (new ImageGetterAsyncTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] {
            s
        });
_L6:
        return drawable;
_L4:
        drawable = (Drawable)cache.get(s);
        continue; /* Loop/switch isn't completed */
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L8:
        arraylist.add(drawablereadylistener);
          goto _L12
        s;
        context;
        JVM INSTR monitorexit ;
        throw s;
_L11:
        (new ImageGetterAsyncTask()).execute(new String[] {
            s
        });
        return drawable;
        if (true) goto _L2; else goto _L13
_L13:
    }




}
