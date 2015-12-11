// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import java.util.ArrayList;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            b, p, n, o, 
//            q

class k extends b
{

    protected float b;
    protected int c;
    protected int d;
    private p.l e;
    private final p.a f;
    private final p.e g;
    private boolean h;
    private Runnable i;
    private Handler j;
    private final int k;
    private BroadcastReceiver l;
    private boolean m;

    public k(p p1, p.a a1, p.e e1)
    {
        super(p1);
        e = p.l.d;
        i = new Runnable() {

            final k a;

            public void run()
            {
                boolean flag = a.e();
                if (k.a(a) != flag)
                {
                    k.a(a, flag);
                    a.a().a(q.a(k.a(a)));
                }
                k.b(a).postDelayed(this, 3000L);
            }

            
            {
                a = k.this;
                super();
            }
        };
        j = new Handler();
        l = new BroadcastReceiver() {

            final k a;
            private int b;

            public void onReceive(Context context, Intent intent)
            {
                if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
                {
                    int j1 = k.c(a);
                    if (j1 != b)
                    {
                        b = j1;
                        k.a(a, b);
                    }
                }
            }

            
            {
                a = k.this;
                super();
            }
        };
        c = -1;
        d = -1;
        f = a1;
        g = e1;
        p1 = a().getContext();
        int i1;
        if (p1 instanceof Activity)
        {
            i1 = ((Activity)p1).getRequestedOrientation();
        } else
        {
            i1 = -1;
        }
        k = i1;
        f();
    }

    private void a(int i1)
    {
        g();
        a().a(n.a(c, d));
    }

    static void a(k k1, int i1)
    {
        k1.a(i1);
    }

    static boolean a(k k1)
    {
        return k1.h;
    }

    static boolean a(k k1, boolean flag)
    {
        k1.h = flag;
        return flag;
    }

    static Handler b(k k1)
    {
        return k1.j;
    }

    private void b(boolean flag)
    {
    }

    static int c(k k1)
    {
        return k1.i();
    }

    private void f()
    {
        e = p.l.a;
        g();
        h();
        a().getContext().registerReceiver(l, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    private void g()
    {
        int j1 = 0;
        Object obj = a().getContext();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)((Context) (obj)).getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        b = displaymetrics.density;
        int i1;
        int k1;
        int l1;
        if (obj instanceof Activity)
        {
            obj = ((Activity)obj).getWindow();
            Rect rect = new Rect();
            ((Window) (obj)).getDecorView().getWindowVisibleDisplayFrame(rect);
            j1 = rect.top;
            i1 = ((Window) (obj)).findViewById(0x1020002).getTop() - j1;
        } else
        {
            i1 = 0;
        }
        k1 = displaymetrics.widthPixels;
        l1 = displaymetrics.heightPixels;
        c = (int)((double)k1 * (160D / (double)displaymetrics.densityDpi));
        d = (int)((double)(l1 - j1 - i1) * (160D / (double)displaymetrics.densityDpi));
    }

    private void h()
    {
        j.removeCallbacks(i);
        j.post(i);
    }

    private int i()
    {
        return ((WindowManager)a().getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    protected void a(String s, int i1, int j1, boolean flag, boolean flag1)
    {
        if (f != p.a.b)
        {
            if (s != null && !URLUtil.isValidUrl(s))
            {
                a().a("expand", "URL passed to expand() was invalid.");
                return;
            }
            a(flag);
            b(flag1);
            e = p.l.c;
            a().a(o.a(e));
            if (a().h() != null)
            {
                a().h().a(a());
                return;
            }
        }
    }

    protected void a(boolean flag)
    {
        m = flag;
        p p1 = a();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (p1.k() != null)
        {
            p1.k().a(p1, flag);
        }
    }

    public void b()
    {
        j.removeCallbacks(i);
        a().getContext().unregisterReceiver(l);
_L1:
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if (!illegalargumentexception.getMessage().contains("Receiver not registered"))
        {
            throw illegalargumentexception;
        }
          goto _L1
    }

    protected void c()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(n.a(c, d));
        arraylist.add(q.a(h));
        a().a(arraylist);
        e = p.l.b;
        a().a(o.a(e));
    }

    protected void d()
    {
        a().setVisibility(4);
        e = p.l.d;
        if (a().i() != null)
        {
            a().i().a(a(), e);
        }
    }

    protected boolean e()
    {
        return true;
    }
}
