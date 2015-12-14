// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import a;
import ac;
import ax;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            j, x, p, Prompt

abstract class s extends a
    implements j
{

    private p b;
    private final x c;
    private float d;
    private Runnable e;
    private String f;
    private final Object g = new Object();

    public s(x x1, String s1, int i, String s2, String s3, Object obj)
    {
        super(obj);
        c = x1;
        d = 0.0F;
        f = s3;
        e = new Runnable(s1, i, s2) {

            private String a;
            private int b;
            private String c;
            private s d;

            public final void run()
            {
                boolean flag1 = true;
                s s4 = d;
                s s5 = d;
                m m = s.a(d).c();
                String s6 = a;
                boolean flag;
                if (b == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (b != 2)
                {
                    flag1 = false;
                }
                s.a(s4, s5.a(m, s6, flag, flag1, c, s.b(d), d. new ac() {

                    private s a;

                    public final void a(float f1)
                    {
                        synchronized (s.c(a))
                        {
                            s.a(a, f1);
                        }
                    }

            
            {
                a = s.this;
                super();
            }
                }));
            }

            
            {
                d = s.this;
                a = s2;
                b = i;
                c = s3;
                super();
            }
        };
    }

    static float a(s s1, float f1)
    {
        s1.d = f1;
        return f1;
    }

    static p a(s s1, p p)
    {
        s1.b = p;
        return p;
    }

    static x a(s s1)
    {
        return s1.c;
    }

    static String b(s s1)
    {
        return s1.f;
    }

    static Object c(s s1)
    {
        return s1.g;
    }

    static p d(s s1)
    {
        return s1.b;
    }

    protected abstract p a(m m, String s1, boolean flag, boolean flag1, String s2, String s3, ac ac);

    protected final void a()
    {
        if (e != null)
        {
            ax.a(e);
            e = null;
        }
    }

    public void cancel()
    {
        c.e();
        ax.a(new Runnable() {

            private s a;

            public final void run()
            {
                s.d(a).f();
            }

            
            {
                a = s.this;
                super();
            }
        });
    }

    public float getAudioLevel()
    {
        float f1;
        synchronized (g)
        {
            f1 = d;
        }
        return f1;
    }

    public void setPrompt(int i, Prompt prompt)
    {
        c.e();
        ax.a(new Runnable(i, prompt) {

            private int a;
            private Prompt b;
            private s c;

            public final void run()
            {
                s.d(c).a(a, b);
            }

            
            {
                c = s.this;
                a = i;
                b = prompt;
                super();
            }
        });
    }

    public void start()
    {
        c.e();
        ax.a(new Runnable() {

            private s a;

            public final void run()
            {
                s.d(a).d();
            }

            
            {
                a = s.this;
                super();
            }
        });
    }

    public void stopRecording()
    {
        c.e();
        ax.a(new Runnable() {

            private s a;

            public final void run()
            {
                s.d(a).e();
            }

            
            {
                a = s.this;
                super();
            }
        });
    }
}
