// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.apps.youtube.core.player.overlay.DefaultOverflowOverlay;
import com.google.android.libraries.youtube.common.ui.TouchImageView;
import com.google.android.libraries.youtube.player.overlay.TimeBar;
import java.util.List;
import java.util.Map;

public final class so extends cva
    implements android.os.Handler.Callback, android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener, cuu, cuy
{

    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private cux H;
    private final FrameLayout I;
    boolean a;
    private cuw b;
    private final TimeBar c;
    private final TouchImageView d;
    private final TextView e;
    private final View f;
    private final View g;
    private final LinearLayout h;
    private final TouchImageView i;
    private final TouchImageView j;
    private final TouchImageView k;
    private final TextView l;
    private final TouchImageView m;
    private final TouchImageView n;
    private final TouchImageView o;
    private final TouchImageView p;
    private final TouchImageView q;
    private final TextView r;
    private final sv s;
    private final RelativeLayout t;
    private final ProgressBar u;
    private final TextView v;
    private ss w;
    private final cm x;
    private final Handler y;
    private cuv z;

    private void a(View view)
    {
        if (view.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        if (view != f) goto _L4; else goto _L3
_L3:
        view.startAnimation(null);
_L6:
        return;
_L4:
        if (view == g)
        {
            view.startAnimation(null);
            return;
        } else
        {
            view.startAnimation(null);
            return;
        }
_L2:
        if (H.f && !A)
        {
            c();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void b(View view)
    {
        if (view.getVisibility() == 0)
        {
            View view1;
            if (view != f)
            {
                view1 = g;
            }
            view.startAnimation(null);
        }
    }

    private void c()
    {
        h();
        A = true;
        g();
        if (b != null)
        {
            b.j();
        }
    }

    private void d()
    {
        if (C)
        {
            g();
            return;
        }
        h();
        A = false;
        g();
        if (b != null)
        {
            b.i();
        }
        f();
    }

    private void e()
    {
        d();
        if (!H.m)
        {
            b(c);
        }
        b(k);
        b(l);
        b(I);
        b(i);
        b(g);
        b(f);
        b(d);
        b(e);
        b(j);
        b(p);
        b(q);
        b(m);
        b(n);
        b(o);
        b(r);
    }

    private void f()
    {
        if ((z == cuv.b || z == cuv.d) && !A && !y.hasMessages(1) && !F)
        {
            y.sendEmptyMessageDelayed(1, 2500L);
        }
    }

    private void g()
    {
        y.removeMessages(2);
        cuv cuv1 = z;
        throw new NullPointerException();
    }

    private void h()
    {
        y.removeMessages(1);
        c.clearAnimation();
        d.clearAnimation();
        e.clearAnimation();
        g.clearAnimation();
        f.clearAnimation();
        k.clearAnimation();
        l.clearAnimation();
        I.clearAnimation();
        j.clearAnimation();
        p.clearAnimation();
        q.clearAnimation();
        n.clearAnimation();
        o.clearAnimation();
        m.clearAnimation();
        i.clearAnimation();
        r.clearAnimation();
    }

    private void m(boolean flag)
    {
        throw new NullPointerException();
    }

    public final void a()
    {
        s.a();
        w.d();
    }

    public final void a(int i1, int j1, int k1)
    {
        c.a(i1, j1, k1);
        x.a(i1, j1);
    }

    public final void a(cuv cuv1)
    {
        if (z != cuv1)
        {
            z = cuv1;
            g();
            if (cuv1 == cuv.g)
            {
                TimeBar timebar = c;
                timebar.h = 0;
                timebar.a();
            }
            if (cuv1 == cuv.c || cuv1 == cuv.g)
            {
                d();
            }
        }
        f();
    }

    public final void a(cuw cuw1)
    {
        b = cuw1;
    }

    public final void a(cux cux1)
    {
        H = cux1;
        Object obj = c;
        int i1 = cux1.h;
        ((TimeBar) (obj)).b.setColor(i1);
        ((TimeBar) (obj)).a();
        obj = c;
        obj.f = cux1.i;
        ((TimeBar) (obj)).a();
        obj = c;
        obj.d = cux1.n;
        ((TimeBar) (obj)).requestLayout();
        obj = c;
        boolean flag = cux1.j;
        obj.e = flag;
        if (!flag && ((TimeBar) (obj)).c)
        {
            if (((TimeBar) (obj)).a != null)
            {
                s s1 = ((TimeBar) (obj)).a;
                ((TimeBar) (obj)).b();
            }
            obj.c = false;
        }
        ((TimeBar) (obj)).requestLayout();
        c.g = cux1.o;
        obj = (android.widget.RelativeLayout.LayoutParams)h.getLayoutParams();
        if (cux1 == cux.c)
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        } else
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11, 0);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(0, d.getId());
        }
        h.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        g();
        w.a(cux1);
        f();
    }

    public final void a(String s1, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        char c1;
        if (flag)
        {
            obj = cuv.e;
        } else
        {
            obj = cuv.f;
        }
        z = ((cuv) (obj));
        obj = getContext();
        b.a(obj);
        if (((Context) (obj)).getResources().getConfiguration().touchscreen != 1)
        {
            c1 = '\001';
        } else
        {
            c1 = '\0';
        }
        if (c1 != 0)
        {
            obj = getContext().getString(0x7f0b00de);
        } else
        {
            obj = getContext().getString(0x7f0b00df);
        }
        obj1 = v;
        obj2 = String.valueOf(s1);
        if (flag)
        {
            s1 = String.valueOf(obj);
            if (s1.length() != 0)
            {
                s1 = "\n\n".concat(s1);
            } else
            {
                s1 = new String("\n\n");
            }
        } else
        {
            s1 = "";
        }
        s1 = String.valueOf(s1);
        if (s1.length() != 0)
        {
            s1 = ((String) (obj2)).concat(s1);
        } else
        {
            s1 = new String(((String) (obj2)));
        }
        ((TextView) (obj1)).setText(s1);
        s1 = getContext();
        obj = v;
        obj2 = v.getText();
        if (a.a(s1).isEnabled())
        {
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                c1 = '\b';
            } else
            {
                c1 = '\u4000';
            }
            obj1 = AccessibilityEvent.obtain(c1);
            ((AccessibilityEvent) (obj1)).getText().add(obj2);
            ((AccessibilityEvent) (obj1)).setEnabled(true);
            ((AccessibilityEvent) (obj1)).setClassName(obj.getClass().getName());
            ((AccessibilityEvent) (obj1)).setPackageName(s1.getPackageName());
            obj2 = fc.a(((AccessibilityEvent) (obj1)));
            ff.a.a(((ff) (obj2)).b, ((View) (obj)));
            a.a(s1).sendAccessibilityEvent(((AccessibilityEvent) (obj1)));
        }
        d();
    }

    public final void a(Map map)
    {
        if (c != null)
        {
            c.i = map;
        }
    }

    public final void a(boolean flag)
    {
        D = flag;
        g();
    }

    public final void a(String as[], int i1)
    {
        w.a(as, i1);
    }

    public final void b()
    {
        c.a(0, 0, 0);
    }

    public final void b(boolean flag)
    {
        E = flag;
        g();
    }

    public final void c(boolean flag)
    {
        c.setEnabled(flag);
    }

    public final void d(boolean flag)
    {
        w.b(flag);
    }

    public final void e(boolean flag)
    {
        d.setSelected(flag);
        TouchImageView touchimageview = d;
        Context context = getContext();
        int i1;
        if (flag)
        {
            i1 = 0x7f0b0135;
        } else
        {
            i1 = 0x7f0b0134;
        }
        touchimageview.setContentDescription(context.getText(i1));
        if (z == cuv.b)
        {
            h();
            m(true);
        }
    }

    public final void f(boolean flag)
    {
        w.a(flag);
    }

    public final void g(boolean flag)
    {
        w.c(flag);
    }

    public final cvd generateLayoutParams()
    {
        return new cvd(-1, -1, true);
    }

    public final View getView()
    {
        return this;
    }

    public final void h(boolean flag)
    {
        w.f(flag);
    }

    public final boolean handleMessage(Message message)
    {
        if (message.what == 1)
        {
            m(false);
            return true;
        }
        if (message.what == 2)
        {
            g();
            return true;
        } else
        {
            return false;
        }
    }

    public final void i(boolean flag)
    {
        G = flag;
        g();
    }

    public final void j(boolean flag)
    {
        B = flag;
        g();
    }

    public final void k(boolean flag)
    {
        F = flag;
        if (flag)
        {
            d();
            return;
        } else
        {
            g();
            return;
        }
    }

    public final void l(boolean flag)
    {
label0:
        {
            if (C != flag)
            {
                C = flag;
                if (!flag)
                {
                    break label0;
                }
                h();
                m(true);
            }
            return;
        }
        if (F || z.b())
        {
            e();
            return;
        } else
        {
            g();
            return;
        }
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (animation == null)
        {
            c();
        } else
        if (animation == null)
        {
            t.setVisibility(4);
            A = true;
            return;
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    public final void onClick(View view)
    {
        boolean flag = true;
        if (b == null) goto _L2; else goto _L1
_L1:
        if (view != n) goto _L4; else goto _L3
_L3:
        if (D && H.l)
        {
            m(true);
            b.e();
        }
_L2:
        return;
_L4:
        if (view != o)
        {
            break; /* Loop/switch isn't completed */
        }
        if (E && H.l)
        {
            m(true);
            b.f();
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (view != m)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (z == cuv.g)
        {
            b.d();
            return;
        }
        if (z == cuv.b)
        {
            b.b();
            return;
        }
        if (z == cuv.c)
        {
            b.a();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (view == p) goto _L2; else goto _L6
_L6:
        if (view == q)
        {
            b.h();
            return;
        }
        if (view == i)
        {
            if (w instanceof su)
            {
                LayoutInflater.from(getContext()).inflate(0x7f04002c, this);
                view = (DefaultOverflowOverlay)findViewById(0x7f100103);
                ((su)w).a(view);
                w = view;
            }
            w.a();
            t.startAnimation(null);
            return;
        }
        if (view == d)
        {
            view = b;
            if (d.isSelected())
            {
                flag = false;
            }
            view.a(flag);
            return;
        }
        if (view == r)
        {
            b.g();
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        h();
        return super.onInterceptTouchEvent(motionevent);
    }

    public final boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (!keyevent.isSystem()) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (i1 == 90 || i1 == 87 || i1 == 85 || i1 == 88 || i1 == 89 || i1 == 86 || i1 == 126 || i1 == 127 || i1 == 130 || i1 == 79 || i1 == 175)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L10:
        if (flag)
        {
            d();
        }
        if (z != cuv.e || !flag) goto _L5; else goto _L4
_L4:
        if (i1 == 20 || i1 == 21 || i1 == 22 || i1 == 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L5; else goto _L6
_L6:
        b.c();
_L8:
        return true;
_L3:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if (x.a(i1, keyevent) || super.onKeyDown(i1, keyevent)) goto _L8; else goto _L7
_L7:
        return false;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        return x.a(i1) || super.onKeyUp(i1, keyevent);
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        i1 = (int)((float)i1 * 0.1666667F);
        v.setPadding(i1, 10, i1, 10);
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!super.onTouchEvent(motionevent))
        {
            if (C)
            {
                return false;
            }
            if (motionevent.getAction() == 1)
            {
                if (z == cuv.e && b != null)
                {
                    b.c();
                    return true;
                }
                if (A)
                {
                    e();
                    return true;
                }
                if (!F)
                {
                    m(true);
                    return true;
                }
            }
        }
        return true;
    }
}
