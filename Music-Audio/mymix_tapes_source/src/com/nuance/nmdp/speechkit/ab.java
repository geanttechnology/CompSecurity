// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import a;
import ax;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            Vocalizer, x, aa, SpeechError

final class ab extends a
    implements Vocalizer
{

    private aa b;
    private Vocalizer.Listener c;
    private final x d;

    public ab(x x1, String s, String s1, Vocalizer.Listener listener, Object obj)
    {
        super(obj);
        c = listener;
        d = x1;
        ax.a(new Runnable(s, s1) {

            private String a;
            private String b;
            private ab c;

            public final void run()
            {
                ab.a(c, new aa(ab.a(c).c(), a, b, ab.b(c)));
            }

            
            {
                c = ab.this;
                a = s;
                b = s1;
                super();
            }
        });
    }

    private Vocalizer.Listener a()
    {
        Vocalizer.Listener listener;
        synchronized (a)
        {
            listener = c;
        }
        return listener;
    }

    static aa a(ab ab1, aa aa)
    {
        ab1.b = aa;
        return aa;
    }

    static x a(ab ab1)
    {
        return ab1.d;
    }

    static void a(ab ab1, Runnable runnable)
    {
        ab1.a(runnable);
    }

    static Vocalizer.Listener b(ab ab1)
    {
        return ab1. new Vocalizer.Listener() {

            final ab a;

            public final void onSpeakingBegin(Vocalizer vocalizer, String s, Object obj)
            {
                ab.a(a, new Runnable(this, s, obj) {

                    private String a;
                    private Object b;
                    private _cls2 c;

                    public final void run()
                    {
                        ab.c(c.a).onSpeakingBegin(c.a, a, b);
                    }

            
            {
                c = _pcls2;
                a = s;
                b = obj;
                super();
            }
                });
            }

            public final void onSpeakingDone(Vocalizer vocalizer, String s, SpeechError speecherror, Object obj)
            {
                ab.b(a, new Runnable(this, s, speecherror, obj) {

                    private String a;
                    private SpeechError b;
                    private Object c;
                    private _cls2 d;

                    public final void run()
                    {
                        ab.c(d.a).onSpeakingDone(d.a, a, b, c);
                    }

            
            {
                d = _pcls2;
                a = s;
                b = speecherror;
                c = obj;
                super();
            }
                });
            }

            
            {
                a = ab.this;
                super();
            }
        };
    }

    static void b(ab ab1, Runnable runnable)
    {
        ab1.a(runnable);
    }

    static Vocalizer.Listener c(ab ab1)
    {
        return ab1.a();
    }

    static aa d(ab ab1)
    {
        return ab1.b;
    }

    public final void cancel()
    {
        d.e();
        ax.a(new Runnable() {

            private ab a;

            public final void run()
            {
                ab.d(a).cancel();
            }

            
            {
                a = ab.this;
                super();
            }
        });
    }

    public final void setLanguage(String s)
    {
        d.e();
        x.a(s, "language");
        ax.a(new Runnable(s) {

            private String a;
            private ab b;

            public final void run()
            {
                ab.d(b).setLanguage(a);
            }

            
            {
                b = ab.this;
                a = s;
                super();
            }
        });
    }

    public final void setListener(Vocalizer.Listener listener)
    {
        x.a(listener, "listener");
        synchronized (a)
        {
            c = listener;
        }
    }

    public final void setVoice(String s)
    {
        d.e();
        x.a(s, "voice");
        ax.a(new Runnable(s) {

            private String a;
            private ab b;

            public final void run()
            {
                ab.d(b).setVoice(a);
            }

            
            {
                b = ab.this;
                a = s;
                super();
            }
        });
    }

    public final void speakMarkupString(String s, Object obj)
    {
        d.e();
        x.a(s, "text");
        ax.a(new Runnable(s, obj) {

            private String a;
            private Object b;
            private ab c;

            public final void run()
            {
                ab.d(c).speakMarkupString(a, b);
            }

            
            {
                c = ab.this;
                a = s;
                b = obj;
                super();
            }
        });
    }

    public final void speakString(String s, Object obj)
    {
        d.e();
        x.a(s, "text");
        ax.a(new Runnable(s, obj) {

            private String a;
            private Object b;
            private ab c;

            public final void run()
            {
                ab.d(c).speakString(a, b);
            }

            
            {
                c = ab.this;
                a = s;
                b = obj;
                super();
            }
        });
    }
}
