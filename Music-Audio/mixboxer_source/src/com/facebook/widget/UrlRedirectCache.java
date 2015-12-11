// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.content.Context;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

class UrlRedirectCache
{

    private static final String REDIRECT_CONTENT_TAG = (new StringBuilder()).append(TAG).append("_Redirect").toString();
    static final String TAG = com/facebook/widget/UrlRedirectCache.getSimpleName();
    private static volatile FileLruCache urlRedirectCache;

    UrlRedirectCache()
    {
    }

    static void cacheUrlRedirect(Context context, URL url, URL url1)
    {
        if (url == null || url1 == null)
        {
            return;
        }
        Context context1 = null;
        try
        {
            context = getCache(context).openPutStream(url.toString(), REDIRECT_CONTENT_TAG);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Utility.closeQuietly(context1);
            return;
        }
        finally
        {
            url1 = null;
        }
        context1 = context;
        context.write(url1.toString().getBytes());
        Utility.closeQuietly(context);
        return;
        url = context;
_L2:
        Utility.closeQuietly(url1);
        throw url;
        url;
        url1 = context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static FileLruCache getCache(Context context)
    {
        com/facebook/widget/UrlRedirectCache;
        JVM INSTR monitorenter ;
        if (urlRedirectCache == null)
        {
            urlRedirectCache = new FileLruCache(context.getApplicationContext(), TAG, new com.facebook.internal.FileLruCache.Limits());
        }
        context = urlRedirectCache;
        com/facebook/widget/UrlRedirectCache;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static URL getRedirectedUrl(Context context, URL url)
    {
        int i;
        i = 0;
        if (url == null)
        {
            return null;
        }
        url = url.toString();
        FileLruCache filelrucache = getCache(context);
        context = null;
_L6:
        Object obj = filelrucache.get(url, REDIRECT_CONTENT_TAG);
        if (obj == null) goto _L2; else goto _L1
_L1:
        url = new InputStreamReader(((java.io.InputStream) (obj)));
        context = new char[128];
        obj = new StringBuilder();
_L5:
        i = url.read(context, 0, context.length);
        if (i <= 0) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append(context, 0, i);
          goto _L5
        context;
_L11:
        Utility.closeQuietly(url);
        return null;
_L4:
        Utility.closeQuietly(url);
        obj = ((StringBuilder) (obj)).toString();
        context = url;
        i = 1;
        url = ((URL) (obj));
          goto _L6
_L2:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        url = new URL(url);
_L12:
        Utility.closeQuietly(context);
        return url;
        context;
        url = null;
_L10:
        Utility.closeQuietly(url);
        return null;
        url;
        context = null;
_L8:
        Utility.closeQuietly(context);
        throw url;
        Exception exception;
        exception;
        context = url;
        url = exception;
        continue; /* Loop/switch isn't completed */
        url;
        if (true) goto _L8; else goto _L7
_L7:
        context;
        continue; /* Loop/switch isn't completed */
        url;
        url = context;
        if (true) goto _L10; else goto _L9
_L9:
        context;
        url = null;
          goto _L11
        url;
        url = context;
          goto _L11
        url = null;
          goto _L12
    }

}
