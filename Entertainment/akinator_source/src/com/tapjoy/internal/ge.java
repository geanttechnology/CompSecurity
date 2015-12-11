// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.tapjoy.internal:
//            fu, cv, y, fx, 
//            bg, fr

public class ge
    implements fu
{

    private static final ge a = new ge() {

        public final void a(String s)
        {
        }

        public final void a(String s, fr fr)
        {
        }

        public final void b(String s)
        {
        }

        public final void b(String s, fr fr)
        {
        }

        public final void c(String s)
        {
        }

        public final void d(String s)
        {
        }

    };
    private final fu b;
    private final bg c;

    private ge()
    {
        b = null;
        c = null;
    }

    ge(byte byte0)
    {
        this();
    }

    private ge(fu fu1)
    {
        b = fu1;
        fu1 = Looper.myLooper();
        if (fu1 != null)
        {
            cv.a(fu1);
            if (fu1 == Looper.getMainLooper())
            {
                fu1 = y.a();
            } else
            {
                fu1 = new Handler(fu1);
            }
        } else
        {
            fu1 = null;
        }
        if (fu1 != null)
        {
            c = y.a(fu1);
            fu1.getLooper();
            return;
        }
        if (Thread.currentThread() == fx.b())
        {
            c = fx.a;
            return;
        } else
        {
            c = y.a(y.a());
            return;
        }
    }

    static fu a(ge ge1)
    {
        return ge1.b;
    }

    static ge a(fu fu1)
    {
        boolean flag;
        if (!(fu1 instanceof ge))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException();
        }
        if (fu1 != null)
        {
            return new ge(fu1);
        } else
        {
            return a;
        }
    }

    public void a(String s)
    {
        c.a(new Runnable(s) {

            final String a;
            final ge b;

            public final void run()
            {
                ge.a(b).a(a);
            }

            
            {
                b = ge.this;
                a = s;
                super();
            }
        });
    }

    public void a(String s, fr fr)
    {
        c.a(new Runnable(s, fr) {

            final String a;
            final fr b;
            final ge c;

            public final void run()
            {
                ge.a(c).a(a, b);
            }

            
            {
                c = ge.this;
                a = s;
                b = fr;
                super();
            }
        });
    }

    public void b(String s)
    {
        c.a(new Runnable(s) {

            final String a;
            final ge b;

            public final void run()
            {
                ge.a(b).b(a);
            }

            
            {
                b = ge.this;
                a = s;
                super();
            }
        });
    }

    public void b(String s, fr fr)
    {
        c.a(new Runnable(s, fr) {

            final String a;
            final fr b;
            final ge c;

            public final void run()
            {
                ge.a(c).b(a, b);
            }

            
            {
                c = ge.this;
                a = s;
                b = fr;
                super();
            }
        });
    }

    public void c(String s)
    {
        c.a(new Runnable(s) {

            final String a;
            final ge b;

            public final void run()
            {
                ge.a(b).c(a);
            }

            
            {
                b = ge.this;
                a = s;
                super();
            }
        });
    }

    public void d(String s)
    {
        c.a(new Runnable(s) {

            final String a;
            final ge b;

            public final void run()
            {
                ge.a(b).d(a);
            }

            
            {
                b = ge.this;
                a = s;
                super();
            }
        });
    }

}
