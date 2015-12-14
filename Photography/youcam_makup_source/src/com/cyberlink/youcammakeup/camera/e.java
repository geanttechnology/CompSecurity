// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl, ah, m

public class e
{

    final CameraCtrl a;
    private final int b = 0;
    private final int c[] = {
        0, 0x7f0208f1, 0x7f0208f2, 0x7f0208f3
    };
    private Handler d;
    private int e;
    private boolean f;
    private Runnable g;
    private Runnable h;

    public e(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
        d = new Handler();
        e = 0;
        f = false;
        g = new Runnable() {

            final e a;

            public void run()
            {
                if (e.a(a) > 0)
                {
                    CameraCtrl.F(a.a).setImageResource(e.b(a)[e.a(a)]);
                    e.c(a).postDelayed(this, 1000L);
                    CameraCtrl.G(a.a).a(2);
                    e.d(a);
                    return;
                }
                CameraCtrl.F(a.a).setImageResource(0);
                if (e.e(a))
                {
                    e.a(a, false);
                    try
                    {
                        CameraCtrl.q(a.a).autoFocus(CameraCtrl.H(a.a));
                        return;
                    }
                    catch (Exception exception)
                    {
                        CameraCtrl.H(a.a).onAutoFocus(false, CameraCtrl.q(a.a));
                    }
                    return;
                } else
                {
                    a.c();
                    return;
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
        h = new Runnable() {

            final e a;

            public void run()
            {
                CameraCtrl.I(a.a).setSelected(false);
                CameraCtrl.a(a.a, true);
                CameraCtrl.a(false);
            }

            
            {
                a = e.this;
                super();
            }
        };
    }

    static int a(e e1)
    {
        return e1.e;
    }

    static boolean a(e e1, boolean flag)
    {
        e1.f = flag;
        return flag;
    }

    static int[] b(e e1)
    {
        return e1.c;
    }

    static Handler c(e e1)
    {
        return e1.d;
    }

    static int d(e e1)
    {
        int i = e1.e;
        e1.e = i - 1;
        return i;
    }

    static boolean e(e e1)
    {
        return e1.f;
    }

    public void a()
    {
        d.removeCallbacks(g);
        d.removeCallbacks(h);
        CameraCtrl.F(a).setImageResource(0);
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    public void b()
    {
        a();
        e = 3;
        g.run();
    }

    public void c()
    {
        CameraCtrl.G(a).a(0);
        (new AsyncTask() {

            final e a;

            protected transient Void a(Void avoid[])
            {
                CameraCtrl.J(a.a);
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                a = e.this;
                super();
            }
        }).execute(new Void[0]);
    }
}
