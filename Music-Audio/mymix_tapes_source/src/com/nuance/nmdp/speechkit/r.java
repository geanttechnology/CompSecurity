// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ac;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            s, Recognizer, x, p, 
//            q, Recognition, SpeechError

final class r extends s
    implements Recognizer
{

    private Recognizer.Listener b;

    public r(x x1, String s1, int i, String s2, Recognizer.Listener listener, Object obj)
    {
        super(x1, s1, i, s2, null, obj);
        synchronized (a)
        {
            b = listener;
        }
        a();
    }

    static Recognizer.Listener a(r r1)
    {
        return r1.b;
    }

    static void a(r r1, Runnable runnable)
    {
        r1.a(runnable);
    }

    static void b(r r1, Runnable runnable)
    {
        r1.a(runnable);
    }

    static void c(r r1, Runnable runnable)
    {
        r1.a(runnable);
    }

    static void d(r r1, Runnable runnable)
    {
        r1.a(runnable);
    }

    protected final p a(m m, String s1, boolean flag, boolean flag1, String s2, String s3, ac ac)
    {
        return new q(m, s1, flag, flag1, s2, ac) {

            final r a;

            protected final void a(SpeechError speecherror)
            {
                r.a(a, new Runnable(this, speecherror) {

                    private SpeechError a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (r.a(b.a) != null)
                        {
                            r.a(b.a).onError(b.a, a);
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
                r.d(a, new Runnable(this, ((Recognition) (obj))) {

                    private Recognition a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (r.a(b.a) != null)
                        {
                            r.a(b.a).onResults(b.a, a);
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
                r.b(a, new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
                        if (r.a(a.a) != null)
                        {
                            r.a(a.a).onRecordingBegin(a.a);
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
                r.c(a, new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
                        if (r.a(a.a) != null)
                        {
                            r.a(a.a).onRecordingDone(a.a);
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = r.this;
                super(m, s1, flag, flag1, s2, ac);
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
