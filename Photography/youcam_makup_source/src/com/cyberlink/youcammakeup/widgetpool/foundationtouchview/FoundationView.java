// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.foundationtouchview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;
import com.pf.common.utility.m;

public class FoundationView extends View
    implements android.view.View.OnTouchListener
{

    private BeautyToolPanel a;
    private Bitmap b;
    private int c;
    private int d;
    private RectF e;
    private RectF f;
    private Vibrator g;
    private long h[] = {
        0L, 100L, 200L, 100L
    };
    private int i;
    private int j;
    private ValueAnimator k;
    private ValueAnimator l;
    private AnimatorSet m;
    private boolean n;
    private Handler o;
    private Runnable p = new Runnable() {

        final FoundationView a;

        public void run()
        {
            if (FoundationView.a(a) != null)
            {
                FoundationView.a(a).cancel();
            }
            FoundationView.b(a);
            if (FoundationView.c(a) != null)
            {
                FoundationView.c(a).g(false);
                FoundationView.c(a).f(true);
            }
            a.invalidate();
        }

            
            {
                a = FoundationView.this;
                super();
            }
    };
    private Runnable q = new Runnable() {

        final FoundationView a;

        public void run()
        {
            FoundationView.a(a, true);
            a.invalidate();
        }

            
            {
                a = FoundationView.this;
                super();
            }
    };
    private android.animation.ValueAnimator.AnimatorUpdateListener r = new android.animation.ValueAnimator.AnimatorUpdateListener() {

        final FoundationView a;

        public void onAnimationUpdate(ValueAnimator valueanimator)
        {
            valueanimator = (Float)valueanimator.getAnimatedValue();
            float f1 = ((1.0F - valueanimator.floatValue()) * (float)FoundationView.d(a)) / 2.0F;
            float f2 = ((1.0F - valueanimator.floatValue()) * (float)FoundationView.e(a)) / 2.0F;
            FoundationView.f(a).left = f1 + FoundationView.g(a).left;
            FoundationView.f(a).top = f2 + FoundationView.g(a).top;
            FoundationView.f(a).right = FoundationView.f(a).left + (float)FoundationView.d(a) * valueanimator.floatValue();
            RectF rectf = FoundationView.f(a);
            f1 = FoundationView.f(a).top;
            f2 = FoundationView.e(a);
            rectf.bottom = valueanimator.floatValue() * f2 + f1;
            a.invalidate();
        }

            
            {
                a = FoundationView.this;
                super();
            }
    };

    public FoundationView(Context context)
    {
        super(context);
        a = null;
        b = null;
        e = null;
        f = null;
        g = null;
        i = 3500;
        j = 1500;
        m = null;
        n = false;
        o = new Handler();
        b();
    }

    public FoundationView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = null;
        b = null;
        e = null;
        f = null;
        g = null;
        i = 3500;
        j = 1500;
        m = null;
        n = false;
        o = new Handler();
        b();
    }

    static Vibrator a(FoundationView foundationview)
    {
        return foundationview.g;
    }

    private void a(MotionEvent motionevent)
    {
        com.pf.common.utility.m.b("FoundationView", "onPointDown");
        while (a == null || !a.t() || c == 0 || d == 0 || Globals.d().i().a() && Globals.d().i().b()) 
        {
            return;
        }
        f.left = motionevent.getX() - (float)c / 2.0F;
        f.top = motionevent.getY() - (float)d / 2.0F;
        f.right = f.left + (float)c;
        f.bottom = f.top + (float)d;
        e = new RectF(f);
        n = false;
        invalidate();
        e();
        if (m != null)
        {
            m.start();
        }
        if (g != null && g.hasVibrator())
        {
            g.vibrate(h, -1);
        }
        a.S();
        o.removeCallbacks(q);
        o.removeCallbacks(p);
        o.postDelayed(q, j);
        o.postDelayed(p, i);
    }

    static boolean a(FoundationView foundationview, boolean flag)
    {
        foundationview.n = flag;
        return flag;
    }

    private void b()
    {
        if (isInEditMode())
        {
            return;
        }
        g = (Vibrator)Globals.d().getSystemService("vibrator");
        b = aa.a(getResources(), 0x7f020890);
        if (b != null)
        {
            c = b.getWidth();
            d = b.getHeight();
        }
        e = new RectF();
        f = new RectF();
        c();
        setOnTouchListener(this);
    }

    static void b(FoundationView foundationview)
    {
        foundationview.e();
    }

    static BeautyToolPanel c(FoundationView foundationview)
    {
        return foundationview.a;
    }

    private void c()
    {
        k = ValueAnimator.ofFloat(new float[] {
            1.5F, 1.0F, 1.2F, 0.8F
        });
        k.setDuration(300L);
        k.setInterpolator(null);
        k.addUpdateListener(r);
        l = ValueAnimator.ofFloat(new float[] {
            0.8F, 1.0F
        });
        l.setDuration(200L);
        l.setInterpolator(new BounceInterpolator());
        l.addUpdateListener(r);
        m = new AnimatorSet();
        m.playSequentially(new Animator[] {
            k, l
        });
    }

    static int d(FoundationView foundationview)
    {
        return foundationview.c;
    }

    private void d()
    {
        if (k != null)
        {
            k.removeAllUpdateListeners();
            k = null;
        }
        if (l != null)
        {
            l.removeAllUpdateListeners();
            l = null;
        }
        if (m != null)
        {
            m = null;
        }
    }

    static int e(FoundationView foundationview)
    {
        return foundationview.d;
    }

    private void e()
    {
        if (m != null)
        {
            m.cancel();
        }
    }

    static RectF f(FoundationView foundationview)
    {
        return foundationview.f;
    }

    static RectF g(FoundationView foundationview)
    {
        return foundationview.e;
    }

    public void a()
    {
        p.run();
        d();
        setOnTouchListener(null);
        aa.a(b);
        b = null;
        a = null;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        while (a == null || !a.t() || c == 0 || d == 0 || n || b == null || b.isRecycled()) 
        {
            return;
        }
        canvas.drawBitmap(b, null, f, null);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (a != null && a.t())
        {
            if (motionevent.getActionMasked() == 0)
            {
                a(motionevent);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void setToolPanel(Fragment fragment)
    {
        a = (BeautyToolPanel)fragment;
    }
}
