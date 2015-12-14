// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, MMLog, VideoAd, AdCache, 
//            DTOCachedVideo, CachedAd

class PreCacheWorker extends Thread
{

    private static boolean a;
    private DTOCachedVideo b[];
    private Context c;
    private String d;
    private volatile boolean e;

    private PreCacheWorker(DTOCachedVideo adtocachedvideo[], Context context, String s)
    {
        e = false;
        b = adtocachedvideo;
        d = s;
        c = context.getApplicationContext();
    }

    static Context a(PreCacheWorker precacheworker)
    {
        return precacheworker.c;
    }

    static void a(DTOCachedVideo adtocachedvideo[], Context context, String s)
    {
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        if (!a)
        {
            a = true;
            (new PreCacheWorker(adtocachedvideo, context, s)).start();
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        return;
        adtocachedvideo;
        throw adtocachedvideo;
    }

    static boolean b(PreCacheWorker precacheworker)
    {
        precacheworker.e = true;
        return true;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        if (b == null) goto _L2; else goto _L1
_L1:
        DTOCachedVideo adtocachedvideo[];
        int j;
        adtocachedvideo = b;
        j = adtocachedvideo.length;
        int i = 0;
_L20:
        if (i >= j) goto _L2; else goto _L3
_L3:
        DTOCachedVideo dtocachedvideo = adtocachedvideo[i];
        Object obj = (new HttpGetRequest()).a(null);
        if (obj != null) goto _L5; else goto _L4
_L4:
        MMLog.b("PreCacheWorker", "Pre cache worker: HTTP response is null");
          goto _L6
_L5:
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj != null) goto _L8; else goto _L7
_L7:
        MMLog.b("PreCacheWorker", "Pre cache worker: Null HTTP entity");
          goto _L6
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        a = false;
        if (!e && !TextUtils.isEmpty(d) && b == null)
        {
            MMSDK.Event.a(d);
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        MMLog.b("PreCacheWorker", String.format("Pre cache worker HTTP error: %s", new Object[] {
            obj
        }));
          goto _L6
_L8:
        if (((HttpEntity) (obj)).getContentLength() != 0L) goto _L10; else goto _L9
_L9:
        MMLog.b("PreCacheWorker", "Pre cache worker: Millennial ad return failed. Zero content length returned.");
          goto _L6
_L10:
        Object obj1 = ((HttpEntity) (obj)).getContentType();
        if (obj1 == null) goto _L6; else goto _L11
_L11:
        obj1 = ((Header) (obj1)).getValue();
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        boolean flag = ((String) (obj1)).equalsIgnoreCase("application/json");
        if (!flag) goto _L13; else goto _L14
_L14:
        obj = HttpGetRequest.a(((HttpEntity) (obj)).getContent());
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L16; else goto _L15
_L15:
        obj = new VideoAd(((String) (obj)));
_L18:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = ((VideoAd) (obj)).isValid();
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_254;
_L17:
        ((InterruptedException) (obj)).printStackTrace();
        MMLog.a("PreCacheWorker", "Pre cache worker interrupted: ", ((Throwable) (obj)));
        break; /* Loop/switch isn't completed */
        obj;
        ((IllegalStateException) (obj)).printStackTrace();
        MMLog.b("PreCacheWorker", "Pre cache worker: Millennial ad return failed. Invalid response data.");
        break; /* Loop/switch isn't completed */
        obj;
        ((IOException) (obj)).printStackTrace();
        MMLog.b("PreCacheWorker", "Pre cache worker: Millennial ad return failed. Invalid response data.");
        break; /* Loop/switch isn't completed */
        obj.downloadPriority = 1;
        if (AdCache.a(c, null, ((CachedAd) (obj)), new AdCache.AdCacheTaskListener(dtocachedvideo) {

        private PreCacheWorker a;

        public void downloadCompleted(CachedAd cachedad, boolean flag1)
        {
            this;
            JVM INSTR monitorenter ;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_26;
            }
            AdCache.a(PreCacheWorker.a(a), cachedad);
            PreCacheWorker.b(a);
            MMSDK.Event.a(null);
            notify();
            this;
            JVM INSTR monitorexit ;
            return;
            cachedad;
            throw cachedad;
        }

        public void downloadStart(CachedAd cachedad)
        {
            MMSDK.Event.a(null);
        }

            
            {
                a = PreCacheWorker.this;
                super();
            }
    }))
        {
            wait();
            break; /* Loop/switch isn't completed */
        }
        try
        {
            MMSDK.Event.a(null);
            MMSDK.Event.a(null);
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        if (true) goto _L17; else goto _L13
_L13:
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).startsWith("video/") && !TextUtils.isEmpty(null))
        {
            MMSDK.Event.a(null);
            AdCache.a(null, (new StringBuilder()).append(null).append("video.dat").toString(), c);
            MMSDK.Event.a(null);
        }
        break; /* Loop/switch isn't completed */
_L2:
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        a = false;
        if (!e && !TextUtils.isEmpty(d) && b == null)
        {
            MMSDK.Event.a(d);
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw obj;
_L16:
        obj = null;
        if (true) goto _L18; else goto _L6
_L6:
        i++;
        if (true) goto _L20; else goto _L19
_L19:
    }
}
