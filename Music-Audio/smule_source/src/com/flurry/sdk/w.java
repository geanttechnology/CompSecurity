// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.AdViewType;
import com.flurry.android.impl.ads.protocol.v13.NativeAdInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            o, aw, co, d, 
//            av, cq, ap, ch

public class w extends o
{

    private static final String a = com/flurry/sdk/w.getSimpleName();
    private GestureDetector b;
    private a c;
    private List d;
    private List e;
    private boolean f;
    private WeakReference g;
    private Rect h;
    private int i;

    public w(Context context, String s1)
    {
        super(context, null, s1);
        d = null;
        e = null;
        f = false;
        g = new WeakReference(null);
        h = new Rect();
        i = 0;
        b = new GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener() {

            final w a;

            public boolean onDown(MotionEvent motionevent)
            {
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                motionevent = (View)w.a(a).get();
                if (motionevent != null)
                {
                    Log.i(w.z(), (new StringBuilder()).append("On item clicked").append(motionevent.getClass()).toString());
                    w.b(a);
                    w.c(a);
                }
                return false;
            }

            
            {
                a = w.this;
                super();
            }
        });
        c = a.a;
    }

    private void A()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Log.i(a, "Impression logged");
        co.a(aw.Q, Collections.emptyMap(), e(), this, k(), 0);
        f = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void B()
    {
        this;
        JVM INSTR monitorenter ;
        Log.i(a, "Click logged");
        co.a(aw.h, Collections.emptyMap(), e(), this, k(), 0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static WeakReference a(w w1)
    {
        return w1.g;
    }

    private void b(View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            view.setOnTouchListener(new android.view.View.OnTouchListener() {

                final w a;

                public boolean onTouch(View view1, MotionEvent motionevent)
                {
                    w.d(a).onTouchEvent(motionevent);
                    return true;
                }

            
            {
                a = w.this;
                super();
            }
            });
            return;
        }
    }

    static void b(w w1)
    {
        w1.A();
    }

    static void c(w w1)
    {
        w1.B();
    }

    static GestureDetector d(w w1)
    {
        return w1.b;
    }

    static String z()
    {
        return a;
    }

    public void a()
    {
        super.a();
    }

    public void a(View view)
    {
        w();
        g = new WeakReference(view);
    }

    protected void a(d d1)
    {
label0:
        {
            super.a(d1);
            if (d.a.a.equals(d1.b))
            {
                d1 = n();
                if (d1 != null)
                {
                    break label0;
                }
                cq.a(this, av.d);
            }
            return;
        }
        d1 = d1.a();
        if (d1 == null)
        {
            cq.a(this, av.f);
            return;
        }
        if (!AdViewType.NATIVE.equals(((AdUnit) (d1)).adViewType))
        {
            cq.a(this, av.w);
            return;
        }
        p();
        this;
        JVM INSTR monitorenter ;
        c = a.b;
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public void a(List list)
    {
        d = list;
    }

    protected void r()
    {
        super.r();
        View view;
        if (a.b.equals(c))
        {
            if ((view = (View)g.get()) != null)
            {
                b(view);
                if (!f)
                {
                    long l;
                    if (view.getGlobalVisibleRect(h))
                    {
                        l = h.width() * h.height();
                    } else
                    {
                        l = 0L;
                    }
                    if (l > 0L)
                    {
                        int j;
                        int k;
                        long l1;
                        if (h.top == 0 && h.left == 0)
                        {
                            j = 1;
                        } else
                        {
                            j = 0;
                        }
                        k = view.getWidth();
                        l1 = view.getHeight() * k;
                        if ((float)l >= (float)l1 * 0.5F && j == 0)
                        {
                            j = i + 1;
                            i = j;
                            if (j >= 10)
                            {
                                A();
                                return;
                            }
                        } else
                        {
                            i = 0;
                            return;
                        }
                    } else
                    {
                        i = 0;
                        return;
                    }
                }
            }
        }
    }

    public List s()
    {
        return d;
    }

    public List t()
    {
        return e;
    }

    public boolean u()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.b.equals(c);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void v()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(c)) goto _L2; else goto _L1
_L1:
        h().a(this, i(), j());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (a.b.equals(c))
        {
            cq.a(this);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void w()
    {
        View view = (View)g.get();
        if (view != null)
        {
            view.setOnTouchListener(null);
            g.clear();
        }
    }

    public int x()
    {
        if (!a.b.equals(c))
        {
            return 0;
        } else
        {
            return k().h().style;
        }
    }

    public List y()
    {
        if (!a.b.equals(c))
        {
            return Collections.emptyList();
        } else
        {
            return new ArrayList(k().i());
        }
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/flurry/sdk/w$a, s1);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("INIT", 0);
            b = new a("READY", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }

}
