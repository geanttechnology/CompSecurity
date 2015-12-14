// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ac;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            s, Recognizer, x, p, 
//            c, Recognition, SpeechError

final class d extends s
    implements Recognizer
{

    private Recognizer.Listener b;
    private final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence c;

    public d(x x1, String s1, int i, String s2, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence, Recognizer.Listener listener, Object obj)
    {
        super(x1, s1, i, s2, null, obj);
        synchronized (a)
        {
            b = listener;
        }
        c = sequence;
        a();
    }

    static Recognizer.Listener a(d d1)
    {
        return d1.b;
    }

    static void a(d d1, Runnable runnable)
    {
        d1.a(runnable);
    }

    static void b(d d1, Runnable runnable)
    {
        d1.a(runnable);
    }

    static void c(d d1, Runnable runnable)
    {
        d1.a(runnable);
    }

    static void d(d d1, Runnable runnable)
    {
        d1.a(runnable);
    }

    protected final p a(m m, String s1, boolean flag, boolean flag1, String s2, String s3, ac ac)
    {
        return new c(m, s1, flag, flag1, s2, c, ac) {

            final d a;

            protected final void a(SpeechError speecherror)
            {
                d.a(a, new Runnable(this, speecherror) {

                    private SpeechError a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (d.a(b.a) != null)
                        {
                            d.a(b.a).onError(b.a, a);
                        }
                    }

            
            {
                b = _pcls1;
                a = speecherror;
                super();
            }
                });
            }

            protected final void a(Object obj)
            {
                obj = (Recognition)obj;
                d.d(a, new Runnable(this, ((Recognition) (obj))) {

                    private Recognition a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (d.a(b.a) != null)
                        {
                            d.a(b.a).onResults(b.a, a);
                        }
                    }

            
            {
                b = _pcls1;
                a = recognition;
                super();
            }
                });
            }

            protected final void b()
            {
                d.b(a, new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
                        if (d.a(a.a) != null)
                        {
                            d.a(a.a).onRecordingBegin(a.a);
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            protected final void c()
            {
                d.c(a, new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
                        if (d.a(a.a) != null)
                        {
                            d.a(a.a).onRecordingDone(a.a);
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = d.this;
                super(m, s1, flag, flag1, s2, sequence, ac);
            }
        };
    }

    public final void setListener(Recognizer.Listener listener)
    {
        x.a(listener, "listener");
        synchronized (a)
        {
            b = listener;
        }
    }
}
