// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.d;
import com.pf.common.utility.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            k, c, d, b

public abstract class a
{

    private List a;
    private Map b;
    private ViewFlipper c;
    private View d;
    private int e;
    private boolean f;
    private boolean g;
    private Activity h;
    private View i;
    private com.cyberlink.youcammakeup.b.d j;

    public a(Activity activity, View view)
    {
        e = 0;
        f = false;
        g = false;
        j = null;
        h = activity;
        i = view;
        c = (ViewFlipper)view.findViewById(b());
        d = view.findViewById(c());
    }

    private k a(boolean flag, float f1, float f2, float f3, boolean flag1)
    {
        if (t())
        {
            return null;
        }
        k k1 = new k(f1, f2, f3, flag1, r());
        if (flag)
        {
            k1.setStartOffset(e());
            k1.setInterpolator(new DecelerateInterpolator());
        } else
        {
            k1.setInterpolator(new AccelerateInterpolator());
        }
        k1.setDuration(e());
        return k1;
    }

    private void a(Activity activity, View view)
    {
        a(activity, view, u());
        if (e > 1)
        {
            c.setAutoStart(true);
            c.setFlipInterval(d());
        }
    }

    private void a(Activity activity, View view, List list)
    {
        view = new c(this, activity, view);
        d.setOnTouchListener(view);
        view = activity.getLayoutInflater();
        b = new HashMap();
        a(activity, ((LayoutInflater) (view)), list);
    }

    static boolean a(a a1)
    {
        return a1.g;
    }

    static int b(a a1)
    {
        return a1.e;
    }

    static ViewFlipper c(a a1)
    {
        return a1.c;
    }

    static Map d(a a1)
    {
        return a1.b;
    }

    static View e(a a1)
    {
        return a1.d;
    }

    static com.cyberlink.youcammakeup.b.d f(a a1)
    {
        return a1.j;
    }

    private List u()
    {
        if (a == null)
        {
            a = o();
        }
        return a;
    }

    protected View a(LayoutInflater layoutinflater, int i1, int j1)
    {
        TextView textview;
label0:
        {
            layoutinflater = layoutinflater.inflate(f(), null);
            layoutinflater.findViewById(g()).setBackgroundResource(i1);
            textview = (TextView)layoutinflater.findViewById(h());
            if (textview != null)
            {
                if (j1 != 0)
                {
                    break label0;
                }
                textview.setText("");
            }
            return layoutinflater;
        }
        textview.setText(j1);
        return layoutinflater;
    }

    protected final View a(LayoutInflater layoutinflater, int i1, int j1, Runnable runnable)
    {
        layoutinflater = a(layoutinflater, i1, j1);
        b.put(layoutinflater, runnable);
        c.addView(layoutinflater, i());
        e = e + 1;
        return layoutinflater;
    }

    protected View a(LayoutInflater layoutinflater, Bitmap bitmap, String s1)
    {
label0:
        {
            layoutinflater = layoutinflater.inflate(f(), null);
            View view = layoutinflater.findViewById(g());
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                view.setBackground(new BitmapDrawable(Globals.d().getResources(), bitmap));
            } else
            {
                view.setBackgroundDrawable(new BitmapDrawable(Globals.d().getResources(), bitmap));
            }
            bitmap = (TextView)layoutinflater.findViewById(h());
            if (bitmap != null)
            {
                if (s1 != null)
                {
                    break label0;
                }
                bitmap.setText("");
            }
            return layoutinflater;
        }
        bitmap.setText(s1);
        return layoutinflater;
    }

    protected final View a(LayoutInflater layoutinflater, Bitmap bitmap, String s1, Runnable runnable)
    {
        layoutinflater = a(layoutinflater, bitmap, s1);
        b.put(layoutinflater, runnable);
        c.addView(layoutinflater, i());
        e = e + 1;
        return layoutinflater;
    }

    protected View a(LayoutInflater layoutinflater, b b1)
    {
        return layoutinflater.inflate(f(), null);
    }

    protected final View a(LayoutInflater layoutinflater, b b1, Runnable runnable)
    {
        layoutinflater = a(layoutinflater, b1);
        b.put(layoutinflater, runnable);
        c.addView(layoutinflater, i());
        e = e + 1;
        return layoutinflater;
    }

    protected Animation a(boolean flag)
    {
        if (flag)
        {
            return a(true, 90F, 0.0F, 0.0F, false);
        } else
        {
            return a(true, -90F, 0.0F, 0.0F, false);
        }
    }

    public void a()
    {
        a(h, i);
    }

    protected abstract void a(Activity activity, LayoutInflater layoutinflater, List list);

    protected abstract void a(View view);

    protected int b()
    {
        return 0x7f0c0137;
    }

    protected Animation b(boolean flag)
    {
        if (flag)
        {
            return a(false, 0.0F, -90F, 0.0F, true);
        } else
        {
            return a(false, 0.0F, 90F, 0.0F, true);
        }
    }

    protected void b(View view)
    {
    }

    protected int c()
    {
        return 0x7f0c0136;
    }

    protected Animation c(boolean flag)
    {
        if (flag)
        {
            return a(true, -90F, 0.0F, 0.0F, false);
        } else
        {
            return a(true, 90F, 0.0F, 0.0F, false);
        }
    }

    protected int d()
    {
        return 3000;
    }

    protected Animation d(boolean flag)
    {
        if (flag)
        {
            return a(false, 0.0F, 90F, 0.0F, true);
        } else
        {
            return a(false, 0.0F, -90F, 0.0F, true);
        }
    }

    protected long e()
    {
        return 200L;
    }

    protected abstract int f();

    protected abstract int g();

    protected abstract int h();

    protected android.view.ViewGroup.LayoutParams i()
    {
        return new android.view.ViewGroup.LayoutParams(-1, -1);
    }

    public void j()
    {
        f = true;
        if (g || e == 1)
        {
            return;
        } else
        {
            c.startFlipping();
            b(c.getCurrentView());
            return;
        }
    }

    public void k()
    {
        f = false;
        if (g)
        {
            return;
        } else
        {
            c.stopFlipping();
            return;
        }
    }

    protected boolean l()
    {
        return f;
    }

    protected void m()
    {
        if (!g && !h.isFinishing() && i != null)
        {
            e = 0;
            c.stopFlipping();
            c.setInAnimation(null);
            c.setOutAnimation(null);
            c.setOnTouchListener(null);
            c.removeAllViews();
            b.clear();
            b = null;
            a.clear();
            a = null;
            a(h, i);
            if (l())
            {
                j();
                return;
            }
        }
    }

    public void n()
    {
        int i1;
        i1 = 0;
        k();
        if (g)
        {
            return;
        }
        int j1;
        h = null;
        i = null;
        e = 0;
        c.stopFlipping();
        c.setInAnimation(null);
        c.setOutAnimation(null);
        c.setOnTouchListener(null);
        j1 = c.getChildCount();
_L8:
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        View view = c.getChildAt(i1).findViewById(g());
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L4; else goto _L3
_L3:
        view.setBackground(null);
          goto _L5
_L4:
        Exception exception;
        view.setBackgroundDrawable(null);
          goto _L5
_L6:
        g = true;
        return;
_L2:
        try
        {
            c.removeAllViews();
            c = null;
            b.clear();
            b = null;
            a.clear();
            a = null;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.pf.common.utility.m.e("BigBangBaseCtrl", com.cyberlink.youcammakeup.utility.d.a(exception));
        }
        if (true) goto _L6; else goto _L5
_L5:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected abstract List o();

    protected abstract int p();

    protected boolean q()
    {
        return true;
    }

    protected boolean r()
    {
        return false;
    }

    protected boolean s()
    {
        return false;
    }

    protected boolean t()
    {
        return false;
    }
}
