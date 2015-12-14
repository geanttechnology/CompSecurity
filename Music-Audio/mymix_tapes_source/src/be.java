// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class be
{

    private static final ay a = new ay();
    private final ay.a b;
    private final bb c;
    private ca d;
    private final Object e;
    private final bz f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private final Object k;
    private final Object l;

    public be(df df, boolean flag, boolean flag1, Object obj, Object obj1, bb bb1)
    {
        f = new bz() {

            private int a;
            private boolean b;
            private be c;

            private void a()
            {
                synchronized (be.b(c))
                {
                    be.c(c);
                    if (be.d(c))
                    {
                        be.b(c).notify();
                        be.e(c);
                    }
                }
            }

            public final void a(ca ca1, String s, Object obj2)
            {
                if (ca1 == be.f(c)) goto _L2; else goto _L1
_L1:
                com.nuance.nmdp.speechkit.recognitionresult.b.b(c, (new StringBuilder()).append("Event ").append(s).append(" received for invalid recorder").toString());
_L4:
                return;
_L2:
                if (s != "BUFFER_RECORDED")
                {
                    break; /* Loop/switch isn't completed */
                }
                if (obj2 instanceof Float)
                {
                    ca1 = be.h(c);
                    be.g(c);
                    ca1.a(((Float)obj2).floatValue());
                    return;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (s == "STARTED")
                {
                    b = true;
                    ca1 = be.h(c);
                    be.g(c);
                    ca1.a();
                    return;
                }
                if (s == "STOPPED")
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(c, "Recorder stopped");
                    a();
                    ca1 = be.h(c);
                    be.g(c);
                    ca1.a(a);
                    return;
                }
                if (s != "RECORD_ERROR")
                {
                    break; /* Loop/switch isn't completed */
                }
                com.nuance.nmdp.speechkit.recognitionresult.b.c(c, "Recorder error");
                a = 4;
                if (!b)
                {
                    a();
                    ca1 = be.h(c);
                    be.g(c);
                    ca1.a(a);
                    return;
                }
                if (true) goto _L4; else goto _L5
_L5:
                if (s == "END_OF_SPEECH")
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(c, "Recorder event (end of speech)");
                    a = 2;
                    return;
                }
                if (s == "CAPTURE_TIMEOUT")
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(c, "Recorder event (timeout)");
                    a = 3;
                    return;
                }
                if (true) goto _L4; else goto _L6
_L6:
            }

            
            {
                c = be.this;
                super();
                a = 0;
                b = false;
            }
        };
        c = bb1;
        e = obj;
        g = false;
        h = false;
        j = false;
        i = false;
        k = new Object();
        l = obj1;
        if (a.c() == 0)
        {
            obj = null;
        } else
        {
            obj = a.e().d();
        }
        b = ((ay.a) (obj));
        obj1 = new ay();
        if (b != null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        ((ay) (obj1)).a(new cz("ep.enable", "TRUE".getBytes(), cz.a.a));
_L2:
        ((ay) (obj1)).a(new cz("USE_ENERGY_LEVEL", "TRUE".getBytes(), cz.a.a));
        ((ay) (obj1)).a(new cz("Android_Context", l, cz.a.a));
        obj = f;
        obj1 = ((ay) (obj1)).f();
        bb1 = bg.a;
        if (obj == null)
        {
            try
            {
                throw new NullPointerException("NMSPAudioRecordListener can not be null!");
            }
            // Misplaced declaration of an exception variable
            catch (df df)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error creating recorder", df);
            }
            d = null;
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (flag1)
        {
            ((ay) (obj1)).a(new cz("ep.enable", "TRUE".getBytes(), cz.a.a));
            ((ay) (obj1)).a(new cz("ep.VadLongUtterance", "TRUE".getBytes(), cz.a.a));
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (df != null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        throw new NullPointerException("Manager can not be null!");
        d = new de(((bz) (obj)), df, ((java.util.Vector) (obj1)), bb1);
        return;
    }

    static ay.a a(be be1)
    {
        return be1.b;
    }

    static Object b(be be1)
    {
        return be1.k;
    }

    static ay c()
    {
        return null;
    }

    static boolean c(be be1)
    {
        be1.i = true;
        return true;
    }

    static boolean d(be be1)
    {
        return be1.j;
    }

    static boolean e(be be1)
    {
        be1.j = false;
        return false;
    }

    static ca f(be be1)
    {
        return be1.d;
    }

    static Object g(be be1)
    {
        return be1.e;
    }

    static bb h(be be1)
    {
        return be1.c;
    }

    public final void a()
    {
        bb bb1;
        Object obj;
        if (!g)
        {
            g = true;
            if (d != null)
            {
                try
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Starting recorder");
                    d.f();
                    return;
                }
                catch (Throwable throwable)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting recorder", throwable);
                }
            }
        } else
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Recorder already started");
        }
        bb1 = c;
        obj = e;
        bb1.a(4);
    }

    public final void a(cx cx)
    {
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Capturing audio from recorder");
        if (b == null)
        {
            d.a(cx);
            return;
        } else
        {
            d.a(new cx(cx) {

                final be a;
                private cx b;

                public final void a(byte abyte0[], int i1, int j1, boolean flag)
                    throws dc
                {
                    if (be.a(a) != null) goto _L2; else goto _L1
_L1:
                    b.a(abyte0, i1, j1, flag);
_L4:
                    abyte0 = a;
                    be.c();
                    return;
_L2:
                    if (be.a(a).a())
                    {
                        abyte0 = (byte[])(byte[])be.a(a).b();
                        if (!be.a(a).a())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        b.a(abyte0, 0, abyte0.length, flag);
                        if (flag)
                        {
                            ax.a(new Runnable(this) {

                                private _cls1 a;

                                public final void run()
                                {
                                    a.a.b();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = be.this;
                b = cx1;
                super();
            }
            });
            return;
        }
    }

    public final void b()
    {
        if (!g || h)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        h = true;
        if (d == null) goto _L2; else goto _L1
_L1:
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        if (i) goto _L4; else goto _L3
_L3:
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Stopping recorder");
        d.g();
        j = true;
_L5:
        boolean flag = i;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        k.wait();
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error stopping recorder", ((Throwable) (obj1)));
        i = true;
        obj;
        JVM INSTR monitorexit ;
_L2:
        com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Can't stop recorder because it wasn't started");
        obj = c;
        Object obj2 = e;
        ((bb) (obj)).a(4);
        return;
        obj2;
        throw obj2;
    }

}
