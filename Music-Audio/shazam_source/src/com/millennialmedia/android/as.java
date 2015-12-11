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
//            w, t, al, VideoAd, 
//            a, r

class as extends Thread
{

    private static boolean a;
    private t b[];
    private Context c;
    private String d;
    private volatile boolean e;

    private as(t at[], Context context, String s)
    {
        e = false;
        b = at;
        d = s;
        c = context.getApplicationContext();
    }

    static Context a(as as1)
    {
        return as1.c;
    }

    static void a(t at[], Context context, String s)
    {
        com/millennialmedia/android/as;
        JVM INSTR monitorenter ;
        if (!a)
        {
            a = true;
            (new as(at, context, s)).start();
        }
        com/millennialmedia/android/as;
        JVM INSTR monitorexit ;
        return;
        at;
        throw at;
    }

    static boolean b(as as1)
    {
        as1.e = true;
        return true;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        if (b == null) goto _L2; else goto _L1
_L1:
        t at[];
        int j;
        at = b;
        j = at.length;
        int i = 0;
_L20:
        if (i >= j) goto _L2; else goto _L3
_L3:
        t t1 = at[i];
        Object obj = (new w()).a(t1.d);
        if (obj != null) goto _L5; else goto _L4
_L4:
        al.b();
          goto _L6
_L5:
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj != null) goto _L8; else goto _L7
_L7:
        al.b();
          goto _L6
        com/millennialmedia/android/as;
        JVM INSTR monitorenter ;
        a = false;
        if (!e && !TextUtils.isEmpty(d) && b == null)
        {
            an.a.a(d);
        }
        com/millennialmedia/android/as;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        String.format("Pre cache worker HTTP error: %s", new Object[] {
            obj
        });
        al.b();
          goto _L6
_L8:
        if (((HttpEntity) (obj)).getContentLength() != 0L) goto _L10; else goto _L9
_L9:
        al.b();
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
        obj = w.a(((HttpEntity) (obj)).getContent());
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L16; else goto _L15
_L15:
        obj = new VideoAd(((String) (obj)));
_L18:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = ((VideoAd) (obj)).b();
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_244;
_L17:
        ((InterruptedException) (obj)).printStackTrace();
        al.a("PreCacheWorker", "Pre cache worker interrupted: ", ((Throwable) (obj)));
        break; /* Loop/switch isn't completed */
        obj;
        ((IllegalStateException) (obj)).printStackTrace();
        al.b();
        break; /* Loop/switch isn't completed */
        obj;
        ((IOException) (obj)).printStackTrace();
        al.b();
        break; /* Loop/switch isn't completed */
        obj.f = 1;
        if (com.millennialmedia.android.a.a(c, null, ((r) (obj)), new a.a(t1) {

        final t a;
        final as b;

        public final void a()
        {
            an.a.a(a.a);
        }

        public final void a(r r, boolean flag1)
        {
            this;
            JVM INSTR monitorenter ;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            com.millennialmedia.android.a.a(as.a(b), r);
            as.b(b);
            an.a.a(a.c);
_L1:
            notify();
            this;
            JVM INSTR monitorexit ;
            return;
            an.a.a(a.b);
              goto _L1
            r;
            throw r;
        }

            
            {
                b = as.this;
                a = t1;
                super();
            }
    }))
        {
            wait();
            break; /* Loop/switch isn't completed */
        }
        try
        {
            an.a.a(t1.a);
            an.a.a(t1.b);
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
        if (!((String) (obj1)).startsWith("video/") || TextUtils.isEmpty(t1.e))
        {
            break; /* Loop/switch isn't completed */
        }
        an.a.a(t1.a);
        if (com.millennialmedia.android.a.a(t1.d, (new StringBuilder()).append(t1.e).append("video.dat").toString(), c))
        {
            an.a.a(t1.c);
            break; /* Loop/switch isn't completed */
        }
        an.a.a(t1.b);
        break; /* Loop/switch isn't completed */
_L2:
        com/millennialmedia/android/as;
        JVM INSTR monitorenter ;
        a = false;
        if (!e && !TextUtils.isEmpty(d) && b == null)
        {
            an.a.a(d);
        }
        com/millennialmedia/android/as;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        com/millennialmedia/android/as;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        com/millennialmedia/android/as;
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
