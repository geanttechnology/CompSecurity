// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.b;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.ROI;
import com.cyberlink.youcammakeup.kernelctrl.c.c;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.w;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.b:
//            b, d

public class a extends Fragment
{

    public static String a = "CompareView";
    private b b;
    private long c;
    private ViewEngine d;
    private AsyncTask e;
    private Bitmap f;
    private Bitmap g;
    private c h;
    private Handler i;
    private boolean j;
    private android.view.View.OnTouchListener k;

    public a()
    {
        e = null;
        i = new Handler();
        j = false;
        k = new android.view.View.OnTouchListener() {

            final a a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = a.this;
                super();
            }
        };
    }

    static Bitmap a(a a1, Bitmap bitmap)
    {
        a1.f = bitmap;
        return bitmap;
    }

    static ImageBufferWrapper a(a a1)
    {
        return a1.f();
    }

    static void a(a a1, String s)
    {
        a1.a(s);
    }

    private void a(String s)
    {
        m.b("Compare", s);
    }

    private boolean a(Canvas canvas)
    {
        int i2 = -1;
        if (f == null)
        {
            m.b("RENDER", "get masterBitmap null");
            return false;
        }
        int l = f.getWidth();
        int i1 = f.getHeight();
        if (h.d == UIImageOrientation.g || h.d == UIImageOrientation.i || h.d == UIImageOrientation.f || h.d == UIImageOrientation.h)
        {
            float f1;
            float f2;
            float f3;
            float f4;
            float f5;
            Object obj;
            Object obj1;
            float af[];
            w w1;
            int j1;
            int k1;
            char c1;
            int l1;
            int j2;
            if (h.d == UIImageOrientation.g || h.d == UIImageOrientation.f)
            {
                c1 = 'Z';
            } else
            {
                c1 = '\u010E';
            }
            byte byte0;
            if (h.d == UIImageOrientation.f || h.d == UIImageOrientation.h)
            {
                l1 = 1;
                j1 = i1;
                k1 = l;
                j2 = c1;
            } else
            {
                i2 = 1;
                l1 = 1;
                j2 = c1;
                k1 = l;
                j1 = i1;
            }
        } else
        {
            if (h.d == UIImageOrientation.d)
            {
                c1 = '\264';
            } else
            {
                c1 = '\0';
            }
            if (h.d == UIImageOrientation.c)
            {
                byte0 = -1;
            } else
            {
                byte0 = 1;
            }
            j2 = c1;
            l1 = byte0;
            k1 = i1;
            j1 = l;
            if (h.d != UIImageOrientation.e)
            {
                i2 = 1;
                j2 = c1;
                l1 = byte0;
                k1 = i1;
                j1 = l;
            }
        }
        g = Bitmap.createBitmap(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
        obj = new Canvas(g);
        ((Canvas) (obj)).save();
        ((Canvas) (obj)).translate(j1 / 2, k1 / 2);
        ((Canvas) (obj)).rotate(j2);
        ((Canvas) (obj)).scale(l1, i2);
        obj1 = new Matrix();
        i1 = -j1;
        l = -k1;
        if (h.d == UIImageOrientation.g || h.d == UIImageOrientation.i || h.d == UIImageOrientation.f || h.d == UIImageOrientation.h)
        {
            i1 = -k1;
            l = -j1;
        }
        ((Matrix) (obj1)).postTranslate(i1 / 2, l / 2);
        ((Canvas) (obj)).drawBitmap(f, ((Matrix) (obj1)), null);
        ((Canvas) (obj)).restore();
        obj = new RectF();
        obj1 = new Paint();
        l = b.getWidth();
        i1 = b.getHeight();
        af = new float[9];
        h.j.getValues(af);
        f2 = af[0];
        f1 = (float)h.e * f2;
        f3 = f2 * (float)h.f;
        w1 = h.k;
        if (w1 == null)
        {
            f5 = -f1 / 2.0F;
            f4 = -f3 / 2.0F;
            f2 = f3;
            f3 = f1;
            f1 = f2;
        } else
        {
            if (f1 > (float)l && w1.c() < (float)l)
            {
                if (w1.a() > 0.0F)
                {
                    f1 = -l / 2;
                } else
                {
                    f1 = (float)(-l / 2) + ((float)l - w1.c());
                }
                f2 = f1;
            } else
            {
                f2 = -w1.c() / 2.0F;
            }
            if (f3 > (float)i1 && w1.d() < (float)i1)
            {
                if (w1.b() > 0.0F)
                {
                    f1 = -i1 / 2;
                } else
                {
                    f1 = (float)(-i1 / 2) + ((float)i1 - w1.d());
                }
            } else
            {
                f1 = -w1.d() / 2.0F;
            }
            f3 = w1.c();
            f5 = w1.d();
            f4 = f1;
            f1 = f5;
            f5 = f2;
        }
        canvas.translate((float)l / 2.0F, (float)i1 / 2.0F);
        ((Paint) (obj1)).setFilterBitmap(true);
        obj.left = f5;
        obj.top = f4;
        obj.right = f3 + f5;
        obj.bottom = f1 + f4;
        canvas.drawBitmap(g, null, ((RectF) (obj)), ((Paint) (obj1)));
        return true;
    }

    static boolean a(a a1, Canvas canvas)
    {
        return a1.a(canvas);
    }

    static Bitmap b(a a1)
    {
        return a1.f;
    }

    private void b()
    {
        d = ViewEngine.a();
        c = StatusManager.j().l();
        h = ((EditViewActivity)getActivity()).s();
    }

    static b c(a a1)
    {
        return a1.b;
    }

    private void c()
    {
        b.setOnTouchListener(k);
    }

    private void d()
    {
        if (e != null)
        {
            e.cancel(true);
            e = null;
        }
        if (f != null)
        {
            f.recycle();
            f = null;
        }
        if (g != null)
        {
            g.recycle();
            g = null;
        }
    }

    static boolean d(a a1)
    {
        return a1.j;
    }

    static Handler e(a a1)
    {
        return a1.i;
    }

    private void e()
    {
        b.setOnTouchListener(null);
    }

    private ImageBufferWrapper f()
    {
        Object obj2 = null;
        if (h == null)
        {
            a("can't get viewer info");
            return null;
        }
        Object obj;
        Object obj1;
        if (StatusManager.j().z())
        {
            obj1 = StatusManager.j().c(c);
            obj = ((d) (obj1)).g();
        } else
        {
            obj1 = StatusManager.j().c(c);
            obj = ((d) (obj1)).g();
        }
        obj1 = ((d) (obj1)).d();
        if (obj == null || obj1 == null)
        {
            a("compareState == null or currentState == null, they have not yet been initialized.");
            return null;
        }
        obj1 = ((SessionState) (obj)).b();
        w w1 = h.l;
        float f1;
        boolean flag;
        if (w1 != null && (Math.abs(w1.c() - h.m) > (float)2 || Math.abs(w1.d() - h.n) > (float)2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f1 = Math.min(h.m / (float)h.b, h.n / (float)h.c);
        if (w1 != null && flag)
        {
            obj = new ROI(0, 0, 0, 0, w1.e());
            ((ROI) (obj)).a((int)Math.floor(w1.a() / f1));
            ((ROI) (obj)).b((int)Math.floor(w1.b() / f1));
            ((ROI) (obj)).c((int)Math.floor(w1.c() / f1));
            ((ROI) (obj)).d((int)Math.floor(w1.d() / f1));
        } else
        {
            obj = null;
        }
        try
        {
            obj = d.a(((ImageBufferWrapper) (obj1)), f1, ((ROI) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            m.b(a, "", ((Throwable) (obj)));
            obj = obj2;
        }
        ((ImageBufferWrapper) (obj1)).m();
        return ((ImageBufferWrapper) (obj));
    }

    public void a()
    {
        j = true;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = new b(this, layoutinflater.getContext());
        b.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        b();
        c();
        if (h != null)
        {
            e = new com.cyberlink.youcammakeup.widgetpool.b.d(this);
            e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] {
                (Void)null
            });
        }
        return b;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        e();
        d();
        j = true;
    }

}
