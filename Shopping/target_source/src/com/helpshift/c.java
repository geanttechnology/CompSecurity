// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, s, e, x, 
//            f, v

public class c
{
    private static class a
    {

        private static final c a = new c(v.a());

        static c a()
        {
            return a;
        }

    }


    private static final TimeUnit a;
    private static f h;
    private final BlockingQueue b = new LinkedBlockingQueue();
    private final BlockingQueue c = new LinkedBlockingQueue();
    private final ThreadPoolExecutor d;
    private Handler e;
    private l f;
    private s g;

    public c(Context context)
    {
        d = new ThreadPoolExecutor(5, 5, 1L, a, c);
        f = new l(context);
        g = f.a;
        e = new Handler(Looper.getMainLooper()) {

            final c a;

            public void handleMessage(Message message)
            {
                e e1 = (e)message.obj;
                message.what;
                JVM INSTR tableswitch -1 5: default 56
            //                           -1 213
            //                           0 56
            //                           1 61
            //                           2 97
            //                           3 128
            //                           4 159
            //                           5 62;
                   goto _L1 _L2 _L1 _L3 _L4 _L5 _L6 _L7
_L1:
                super.handleMessage(message);
_L3:
                return;
_L7:
                if (c.d() == null) goto _L3; else goto _L8
_L8:
                c.d().a(e1.f(), message.arg1, e1.h(), e1.i(), e1.j());
                return;
_L4:
                if (c.d() == null) goto _L3; else goto _L9
_L9:
                c.d().a(message.arg1, e1.h(), e1.i(), e1.j());
                return;
_L5:
                if (c.d() == null) goto _L3; else goto _L10
_L10:
                c.d().b(message.arg1, e1.h(), e1.i(), e1.j());
                return;
_L6:
                c.a(a, e1.h());
                if (c.d() != null)
                {
                    c.d().a(e1.g(), message.arg1, e1.h(), e1.i(), e1.j());
                }
                a.a(e1);
                return;
_L2:
                if (c.d() != null)
                {
                    c.d().c(message.arg1, e1.h(), e1.i(), e1.j());
                }
                a.a(e1);
                return;
            }

            
            {
                a = c.this;
                super(looper);
            }
        };
    }

    public static c a()
    {
        com/helpshift/c;
        JVM INSTR monitorenter ;
        c c1 = a.a();
        com/helpshift/c;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public static e a(JSONObject jsonobject, int i, String s1, String s2, int j)
    {
        e e1;
        a().g.o(s1, s2);
        e e2 = (e)a().b.poll();
        e1 = e2;
        if (e2 == null)
        {
            e1 = new e();
        }
        e1.a(a(), jsonobject, i, s1, s2, j);
        jsonobject = a().e();
        if (!jsonobject.has(s1))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        e1.a(new File(jsonobject.getString(s1)));
_L1:
        if (e1.a() == 0 || e1.a() == 2)
        {
            a().d.execute(e1.k());
            return e1;
        } else
        {
            a().a(e1, e1.a(), i);
            return e1;
        }
        try
        {
            a().a(s1, e1.d().getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            x.b("HelpShiftDebug", "Exception JSON", jsonobject);
        }
          goto _L1
    }

    static void a(c c1, String s1)
    {
        c1.a(s1);
    }

    public static void a(f f1)
    {
        h = f1;
    }

    private void a(String s1)
    {
        g.A(s1);
    }

    private void a(String s1, String s2)
    {
        g.k(s1, s2);
    }

    public static void b()
    {
        h = null;
    }

    public static f c()
    {
        return h;
    }

    static f d()
    {
        return h;
    }

    private JSONObject e()
    {
        return g.R();
    }

    void a(e e1)
    {
        e1.l();
        b.offer(e1);
    }

    public void a(e e1, int i, int j)
    {
        switch (i)
        {
        default:
            e.obtainMessage(i, j, 0, e1).sendToTarget();
            return;

        case 2: // '\002'
            e.obtainMessage(i, j, 0, e1).sendToTarget();
            return;

        case 3: // '\003'
            e.obtainMessage(i, j, 0, e1).sendToTarget();
            return;

        case 4: // '\004'
            e.obtainMessage(i, j, 0, e1).sendToTarget();
            return;

        case 5: // '\005'
            e.obtainMessage(i, j, 0, e1).sendToTarget();
            break;
        }
    }

    static 
    {
        a = TimeUnit.SECONDS;
    }
}
