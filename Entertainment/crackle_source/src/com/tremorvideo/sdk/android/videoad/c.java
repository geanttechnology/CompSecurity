// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Intent;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            a, ad, n, az, 
//            aw, x, w, bv, 
//            Playvideo

public class c extends a
{

    private az a;
    private boolean b;
    private boolean e;
    private n f;

    public c(a.a a1, Activity activity, n n1)
    {
        super(a1, activity);
        f = n1;
        if (ad.b(c))
        {
            ad.c(c);
        }
        a = n1.s();
        b = false;
        e = false;
        d.a(a.a(aw.b.k));
        a1 = n1.s();
        activity = a1.a(aw.b.l);
        a1 = a1.a(aw.b.n);
        activity = activity.h();
        n1 = new ArrayList();
        n1.add(new x(activity, aw.b.l.b()));
        a1 = new w(c, new android.view.View.OnClickListener(activity) {

            final String a;
            final c b;

            public void onClick(View view)
            {
                if (view.getTag().equals(a))
                {
                    c.a(b);
                    return;
                } else
                {
                    c.b(b);
                    return;
                }
            }

            
            {
                b = c.this;
                a = s;
                super();
            }
        }, n1, f.q(), true, a1.h(), e());
        n1 = bv.a(a.d());
        activity = new ImageView(c);
        activity.setImageBitmap(n1);
        activity.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        activity.setFocusable(false);
        n1 = new FrameLayout(c);
        n1.addView(activity, new android.widget.FrameLayout.LayoutParams(-1, -1));
        activity = new android.widget.FrameLayout.LayoutParams(-2, -2);
        activity.gravity = 80;
        n1.addView(a1.d(), activity);
        c.setContentView(n1);
        if (a.a() > 0)
        {
            ad.d((new StringBuilder()).append("Skip Time MS: ").append(a.a()).toString());
            n1.postDelayed(new Runnable() {

                final c a;

                public void run()
                {
                    if (!c.c(a) && !c.d(a))
                    {
                        c.b(a);
                    }
                }

            
            {
                a = c.this;
                super();
            }
            }, a.a());
        }
    }

    static void a(c c1)
    {
        c1.g();
    }

    static void b(c c1)
    {
        c1.f();
    }

    static boolean c(c c1)
    {
        return c1.e;
    }

    static boolean d(c c1)
    {
        return c1.b;
    }

    private int e()
    {
        return ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    private void f()
    {
        this;
        JVM INSTR monitorenter ;
        if (!e)
        {
            e = true;
            d.a(a.a(aw.b.n));
            d.a(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        if (!b && !e)
        {
            d.a(a.a(aw.b.l));
            b = true;
            Intent intent = new Intent(c, com/tremorvideo/sdk/android/videoad/Playvideo);
            intent.putExtra("tremorVideoType", "webview");
            intent.putExtra("tremorVideoURL", a.b());
            c.startActivityForResult(intent, 32);
            d.a(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a()
    {
        if (b)
        {
            d.a(a.a(aw.b.m));
            d.a(this);
        }
    }

    public boolean a(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            f();
            return true;
        } else
        {
            return super.a(i, keyevent);
        }
    }

    public a.b n()
    {
        return a.b.a;
    }
}
