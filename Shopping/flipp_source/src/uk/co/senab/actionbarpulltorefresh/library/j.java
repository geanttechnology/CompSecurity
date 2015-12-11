// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import uk.co.senab.actionbarpulltorefresh.library.a.a;
import uk.co.senab.actionbarpulltorefresh.library.a.b;
import uk.co.senab.actionbarpulltorefresh.library.b.c;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            m, h, e, l, 
//            c, f, k

public final class j
{

    f a;
    b b;
    Activity c;
    View d;
    a e;
    final int f;
    float g;
    float h;
    boolean i;
    boolean j;
    boolean k;
    View l;
    final WeakHashMap m = new WeakHashMap();
    final boolean n;
    final Rect o = new Rect();
    private e p;
    private final float q;
    private float r;
    private float s;
    private final int t;
    private final boolean u;
    private boolean v;
    private final int w[] = new int[2];
    private final Runnable x = new m(this);

    protected j(Activity activity, h h1)
    {
        v = false;
        if (activity == null)
        {
            throw new IllegalArgumentException("activity cannot be null");
        }
        h h2 = h1;
        if (h1 == null)
        {
            Log.i("PullToRefreshAttacher", "Given null options so using default options.");
            h2 = new h();
        }
        c = activity;
        q = h2.d;
        n = h2.e;
        t = h2.f;
        u = h2.g;
        if (h2.a != null)
        {
            h1 = h2.a;
        } else
        {
            h1 = new l(this);
        }
        p = h1;
        if (h2.c != null)
        {
            h1 = h2.c;
        } else
        {
            h1 = new uk.co.senab.actionbarpulltorefresh.library.c();
        }
        a = h1;
        f = ViewConfiguration.get(activity).getScaledTouchSlop();
        h1 = (ViewGroup)activity.getWindow().getDecorView();
        d = LayoutInflater.from(p.a(activity)).inflate(h2.b, h1, false);
        if (d == null)
        {
            throw new IllegalArgumentException("Must supply valid layout id for header.");
        } else
        {
            d.setVisibility(4);
            a.a(activity, d);
            h1.post(new k(this, h1));
            return;
        }
    }

    private boolean a(boolean flag)
    {
        return !j && (!flag || b != null);
    }

    private void e()
    {
        android.view.WindowManager.LayoutParams layoutparams;
        View view;
        view = d;
        c.getWindow().getDecorView().getWindowVisibleDisplayFrame(o);
        layoutparams = null;
        if (!(view.getLayoutParams() instanceof android.view.WindowManager.LayoutParams)) goto _L2; else goto _L1
_L1:
        layoutparams = (android.view.WindowManager.LayoutParams)view.getLayoutParams();
_L4:
        if (layoutparams != null && layoutparams.y != o.top)
        {
            layoutparams.y = o.top;
            c.getWindowManager().updateViewLayout(view, layoutparams);
        }
        a.e();
        return;
_L2:
        if (view.getTag() instanceof android.view.WindowManager.LayoutParams)
        {
            layoutparams = (android.view.WindowManager.LayoutParams)view.getTag();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void f()
    {
        j = false;
        if (u)
        {
            d.removeCallbacks(x);
        }
        a.f();
    }

    final float a(View view)
    {
        return (float)view.getHeight() * q;
    }

    final void a()
    {
        if (v)
        {
            return;
        }
        View view = d;
        if (view.getWindowToken() != null)
        {
            c.getWindowManager().removeViewImmediate(view);
        }
        m.clear();
        c = null;
        d = null;
        e = null;
        p = null;
        a = null;
        v = true;
    }

    final void a(boolean flag, boolean flag1)
    {
        if (!d() && j != flag)
        {
            b();
            if (flag && a(flag1))
            {
                j = true;
                if (flag1 && b != null)
                {
                    b.a();
                }
                a.b();
                e();
                if (u)
                {
                    if (t > 0)
                    {
                        d.postDelayed(x, t);
                        return;
                    } else
                    {
                        d.post(x);
                        return;
                    }
                }
            } else
            {
                f();
                return;
            }
        }
    }

    final boolean a(MotionEvent motionevent)
    {
        float f1;
        float f2;
        if (j)
        {
            return false;
        }
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 52
    //                   0 140
    //                   1 368
    //                   2 57
    //                   3 368;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        return i;
_L4:
        if (!i && r > 0.0F)
        {
            float f3 = f2 - r;
            if (f3 > f1 - s && f3 > (float)f)
            {
                i = true;
                e();
                h = f2;
            } else
            if (f3 < (float)(-f))
            {
                b();
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Iterator iterator;
        if (!a(true))
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator = m.keySet().iterator();
_L6:
        View view;
        boolean flag;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        view = (View)iterator.next();
        if (!view.isShown() || !m.containsKey(view))
        {
            break; /* Loop/switch isn't completed */
        }
        view.getLocationOnScreen(w);
        int i1 = w[0];
        int j1 = w[1];
        o.set(i1, j1, view.getWidth() + i1, view.getHeight() + j1);
        i1 = (int)motionevent.getRawX();
        j1 = (int)motionevent.getRawY();
        if (!o.contains(i1, j1))
        {
            break; /* Loop/switch isn't completed */
        }
        c c1 = (c)m.get(view);
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        float f4 = i1 - o.left;
        i1 = o.top;
        flag = c1.a(view, f4);
_L7:
        if (flag)
        {
            s = f1;
            r = f2;
            l = view;
        }
        if (true) goto _L6; else goto _L5
_L5:
        flag = false;
          goto _L7
          goto _L6
_L3:
        b();
        if (true) goto _L1; else goto _L8
_L8:
    }

    final void b()
    {
        i = false;
        k = false;
        h = -1F;
        g = -1F;
        r = -1F;
    }

    final void c()
    {
        if (!j)
        {
            f();
        }
    }

    final boolean d()
    {
        if (v)
        {
            Log.i("PullToRefreshAttacher", "PullToRefreshAttacher is destroyed.");
        }
        return v;
    }
}
