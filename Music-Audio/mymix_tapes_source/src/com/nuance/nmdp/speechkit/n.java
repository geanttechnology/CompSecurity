// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ac;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            s, NluRecognizer, x, p, 
//            m, GenericRecognition, SpeechError

final class n extends s
    implements NluRecognizer
{

    private NluRecognizer.Listener b;
    private final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary c;

    public n(x x1, String s1, int i, String s2, String s3, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, NluRecognizer.Listener listener, 
            Object obj)
    {
        super(x1, s1, i, s2, s3, obj);
        synchronized (a)
        {
            b = listener;
        }
        c = dictionary;
        a();
    }

    static NluRecognizer.Listener a(n n1)
    {
        return n1.b;
    }

    static void a(n n1, Runnable runnable)
    {
        n1.a(runnable);
    }

    static void b(n n1, Runnable runnable)
    {
        n1.a(runnable);
    }

    static void c(n n1, Runnable runnable)
    {
        n1.a(runnable);
    }

    static void d(n n1, Runnable runnable)
    {
        n1.a(runnable);
    }

    protected final p a(m m, String s1, boolean flag, boolean flag1, String s2, String s3, ac ac)
    {
        return new m(m, s1, flag, flag1, s2, s3, c, ac) {

            final n a;

            protected final void a(SpeechError speecherror)
            {
                n.a(a, new Runnable(this, speecherror) {

                    private SpeechError a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (n.a(b.a) != null)
                        {
                            n.a(b.a).onError(b.a, a);
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
                obj = (GenericRecognition)obj;
                n.d(a, new Runnable(this, ((GenericRecognition) (obj))) {

                    private GenericRecognition a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (n.a(b.a) != null)
                        {
                            n.a(b.a).onResults(b.a, a);
                        }
                    }

            
            {
                b = _pcls1;
                a = genericrecognition;
                super();
            }
                });
            }

            protected final void b()
            {
                n.b(a, new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
                        if (n.a(a.a) != null)
                        {
                            n.a(a.a).onRecordingBegin(a.a);
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
                n.c(a, new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
                        if (n.a(a.a) != null)
                        {
                            n.a(a.a).onRecordingDone(a.a);
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = n.this;
                super(m1, s1, flag, flag1, s2, s3, dictionary, ac);
            }
        };
    }

    public final void setListener(NluRecognizer.Listener listener)
    {
        x.a(listener, "listener");
        synchronized (a)
        {
            b = listener;
        }
    }
}
