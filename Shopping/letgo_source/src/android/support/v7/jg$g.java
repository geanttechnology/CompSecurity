// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.util.Log;
import com.facebook.s;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            jg, jh, jv, kb

static class _cls1
{

    private static final Object a = new Object();
    private static boolean b = false;
    private static boolean c = false;
    private static Map d;
    private static final Runnable e = new Runnable() {

        public void run()
        {
            jg.g.a(jg.g());
        }

    };

    private static jh a(Context context, _cls1 _pcls1)
    {
        b(context);
        jh jh1 = (jh)d.get(_pcls1);
        context = jh1;
        if (jh1 == null)
        {
            context = new jh();
            d.put(_pcls1, context);
        }
        return context;
    }

    private static void a()
    {
        if (!b)
        {
            b = true;
            jg.i().schedule(e, 30L, TimeUnit.SECONDS);
        }
    }

    static void a(Context context)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = b;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedsessioninfo", 0)));
        context = objectoutputstream;
        objectoutputstream.writeObject(d);
        context = objectoutputstream;
        b = false;
        context = objectoutputstream;
        jv.a(s.e, "AppEvents", "App session info saved");
        kb.a(objectoutputstream);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        objectoutputstream = null;
_L4:
        context = objectoutputstream;
        Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
        kb.a(objectoutputstream);
          goto _L1
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        Exception exception;
        exception;
        context = null;
_L3:
        kb.a(context);
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        exception1;
          goto _L4
    }

    static void a(Context context, toString tostring, jg jg1, long l)
    {
        synchronized (a)
        {
            a(context, tostring).a(jg1, l);
            a();
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void a(Context context, a a1, jg jg1, long l, String s1)
    {
        synchronized (a)
        {
            a(context, a1).a(jg1, l, s1);
            a();
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static void b(Context context)
    {
        Object obj1 = null;
        Object obj2 = a;
        obj2;
        JVM INSTR monitorenter ;
        boolean flag = c;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        Object obj = new ObjectInputStream(context.openFileInput("AppEventsLogger.persistedsessioninfo"));
        obj1 = obj;
        d = (HashMap)((ObjectInputStream) (obj)).readObject();
        obj1 = obj;
        jv.a(s.e, "AppEvents", "App session info loaded");
        kb.a(((java.io.Closeable) (obj)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (d == null)
        {
            d = new HashMap();
        }
        c = true;
        b = false;
_L1:
        obj2;
        JVM INSTR monitorexit ;
        return;
_L4:
        kb.a(((java.io.Closeable) (obj)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (d == null)
        {
            d = new HashMap();
        }
        c = true;
        b = false;
          goto _L1
        context;
        obj2;
        JVM INSTR monitorexit ;
        throw context;
        Exception exception;
        exception;
        obj = null;
_L3:
        obj1 = obj;
        Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception.toString()).toString());
        kb.a(((java.io.Closeable) (obj)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (d == null)
        {
            d = new HashMap();
        }
        c = true;
        b = false;
          goto _L1
_L2:
        kb.a(((java.io.Closeable) (obj1)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (d == null)
        {
            d = new HashMap();
        }
        c = true;
        b = false;
        throw obj;
        obj;
          goto _L2
        exception;
          goto _L3
        obj1;
          goto _L4
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = ((FileNotFoundException) (obj1));
          goto _L4
        filenotfoundexception;
        obj1 = null;
          goto _L2
    }

}
