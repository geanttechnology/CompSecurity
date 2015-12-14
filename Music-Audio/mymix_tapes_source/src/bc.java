// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class bc
{

    private final by a;
    private final az b;
    private final df c;
    private z d;
    private final Object e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Object j;
    private final Object k;

    public bc(df df, Object obj, Object obj1, az az1)
    {
        a = new by() {

            private boolean a;
            private bc b;

            private void a()
            {
                synchronized (bc.a(b))
                {
                    bc.b(b);
                    if (bc.c(b))
                    {
                        bc.a(b).notify();
                        bc.d(b);
                    }
                }
            }

            public final void a(String s)
            {
                if (s == "BUFFER_PLAYED")
                {
                    if (!a)
                    {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(b, "First audio buffer played");
                        bc.f(b).b(bc.e(b));
                        a = true;
                    }
                } else
                if (s != "BUFFERING")
                {
                    if (s == "STARTED")
                    {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(b, "Audio playback started");
                        return;
                    }
                    if (s == "STOPPED")
                    {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(b, "Audio playback stopped");
                        a();
                        bc.f(b).c(bc.e(b));
                        return;
                    }
                    if (s == "PLAYBACK_ERROR")
                    {
                        com.nuance.nmdp.speechkit.recognitionresult.b.c(b, "Audio playback error");
                        a();
                        bc.f(b).a(bc.e(b));
                        return;
                    }
                }
            }

            
            {
                b = bc.this;
                super();
                a = false;
            }
        };
        b = az1;
        c = df;
        e = obj;
        f = false;
        g = false;
        h = false;
        i = false;
        j = new Object();
        k = obj1;
        obj1 = new ay();
        ((ay) (obj1)).a(new cz("Android_Context", k, cz.a.a));
        df = a;
        obj = c;
        obj1 = ((ay) (obj1)).f();
        az1 = bh.a;
        if (df == null)
        {
            try
            {
                throw new NullPointerException("NMSPAudioPlaybackListener can not be null!");
            }
            // Misplaced declaration of an exception variable
            catch (df df)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error creating player", df);
            }
            d = null;
            return;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        throw new NullPointerException("Manager can not be null!");
        d = new dd(df, ((df) (obj)), ((java.util.Vector) (obj1)), az1);
        return;
    }

    static Object a(bc bc1)
    {
        return bc1.j;
    }

    static boolean b(bc bc1)
    {
        bc1.h = true;
        return true;
    }

    static boolean c(bc bc1)
    {
        return bc1.i;
    }

    static boolean d(bc bc1)
    {
        bc1.i = false;
        return false;
    }

    static Object e(bc bc1)
    {
        return bc1.e;
    }

    static az f(bc bc1)
    {
        return bc1.b;
    }

    public final void a()
    {
        if (!f)
        {
            if (d != null)
            {
                f = true;
                try
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Starting audio player");
                    d.a();
                    return;
                }
                catch (Throwable throwable)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting player", throwable);
                }
            }
        } else
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Player already started");
        }
        b.a(e);
    }

    public final void b()
    {
        if (!f || g) goto _L2; else goto _L1
_L1:
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        g = true;
        Object obj = j;
        obj;
        JVM INSTR monitorenter ;
        if (h) goto _L4; else goto _L3
_L3:
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Stopping audio player");
        d.a_();
        i = true;
_L6:
        boolean flag = h;
        if (flag) goto _L4; else goto _L5
_L5:
        j.wait();
          goto _L6
        Object obj1;
        obj1;
          goto _L6
        obj1;
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error stopping player", ((Throwable) (obj1)));
        h = true;
_L4:
        obj;
        JVM INSTR monitorexit ;
_L2:
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        b.a(e);
        return;
          goto _L6
    }

    public final z c()
    {
        return d;
    }
}
