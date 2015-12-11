// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.d.a.a.a;
import com.d.a.a.b;
import com.d.a.a.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.d.a:
//            b, a, c

public class d
{

    private ViewGroup a;
    private int b;
    private Random c;
    private com.d.a.c d;
    private ArrayList e;
    private ArrayList f;
    private long g;
    private long h;
    private float i;
    private int j;
    private long k;
    private List l;
    private List m;
    private ValueAnimator n;
    private float o;
    private int p[];
    private int q;
    private int r;
    private int s;
    private int t;

    public d(Activity activity, int i1, int j1, long l1)
    {
        this(activity, i1, activity.getResources().getDrawable(j1), l1, 0x1020002);
    }

    private d(Activity activity, int i1, long l1, int j1)
    {
        h = 0L;
        c = new Random();
        a = (ViewGroup)activity.findViewById(j1);
        l = new ArrayList();
        m = new ArrayList();
        b = i1;
        f = new ArrayList();
        e = new ArrayList();
        g = l1;
        p = new int[2];
        a.getLocationInWindow(p);
        o = activity.getResources().getDisplayMetrics().xdpi / 160F;
    }

    public d(Activity activity, int i1, Drawable drawable, long l1, int j1)
    {
        boolean flag1;
        flag1 = false;
        boolean flag = false;
        this(activity, i1, l1, j1);
        if (!(drawable instanceof BitmapDrawable))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        activity = ((BitmapDrawable)drawable).getBitmap();
        i1 = ((flag) ? 1 : 0);
_L3:
        if (i1 < b) goto _L2; else goto _L1
_L1:
        return;
_L2:
        e.add(new com.d.a.b(activity));
        i1++;
          goto _L3
        if (drawable instanceof AnimationDrawable)
        {
            activity = (AnimationDrawable)drawable;
            i1 = ((flag1) ? 1 : 0);
            while (i1 < b) 
            {
                e.add(new com.d.a.a(activity));
                i1++;
            }
        }
          goto _L1
    }

    private void a()
    {
        a.removeView(d);
        d = null;
        a.postInvalidate();
        e.addAll(f);
    }

    private void a(int i1)
    {
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        long l1;
        return;
_L2:
        if ((l1 = h / 1000L / (long)i1) != 0L)
        {
            long l2 = h / l1;
            i1 = 1;
            while ((long)i1 <= l1) 
            {
                b((long)i1 * l2 + 1L);
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(int i1, int j1)
    {
        j = 0;
        i = (float)i1 / 1000F;
        d = new com.d.a.c(a.getContext());
        a.addView(d);
        d.a(f);
        a(i1);
        k = j1;
        a(((Interpolator) (new LinearInterpolator())), (long)j1 + g);
    }

    private void a(long l1)
    {
        com.d.a.b b1 = (com.d.a.b)e.remove(0);
        b1.a();
        int i1 = 0;
        do
        {
            if (i1 >= m.size())
            {
                i1 = c(q, r);
                int j1 = c(s, t);
                b1.a(g, i1, j1);
                b1.a(l1, l);
                f.add(b1);
                j = j + 1;
                return;
            }
            ((a)m.get(i1)).a(b1, c);
            i1++;
        } while (true);
    }

    private void a(View view, int i1)
    {
        int ai[] = new int[2];
        view.getLocationInWindow(ai);
        if (b(i1, 3))
        {
            q = ai[0] - p[0];
            r = q;
        } else
        if (b(i1, 5))
        {
            q = (ai[0] + view.getWidth()) - p[0];
            r = q;
        } else
        if (b(i1, 1))
        {
            q = (ai[0] + view.getWidth() / 2) - p[0];
            r = q;
        } else
        {
            q = ai[0] - p[0];
            r = (ai[0] + view.getWidth()) - p[0];
        }
        if (b(i1, 48))
        {
            s = ai[1] - p[1];
            t = s;
            return;
        }
        if (b(i1, 80))
        {
            s = (ai[1] + view.getHeight()) - p[1];
            t = s;
            return;
        }
        if (b(i1, 16))
        {
            s = (ai[1] + view.getHeight() / 2) - p[1];
            t = s;
            return;
        } else
        {
            s = ai[1] - p[1];
            t = (ai[1] + view.getHeight()) - p[1];
            return;
        }
    }

    private void a(Interpolator interpolator, long l1)
    {
        n = ValueAnimator.ofInt(new int[] {
            0, (int)l1
        });
        n.setDuration(l1);
        n.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final d a;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                int i1 = ((Integer)valueanimator.getAnimatedValue()).intValue();
                com.d.a.d.a(a, i1);
            }

            
            {
                a = d.this;
                super();
            }
        });
        n.addListener(new android.animation.Animator.AnimatorListener() {

            final d a;

            public void onAnimationCancel(Animator animator)
            {
                com.d.a.d.a(a);
            }

            public void onAnimationEnd(Animator animator)
            {
                com.d.a.d.a(a);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = d.this;
                super();
            }
        });
        n.setInterpolator(interpolator);
        n.start();
    }

    static void a(d d1)
    {
        d1.a();
    }

    static void a(d d1, long l1)
    {
        d1.b(l1);
    }

    private void b(long l1)
    {
_L3:
        if ((k > 0L && l1 < k || k == -1L) && !e.isEmpty() && (float)j < i * (float)l1) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L4:
        if (i1 >= f.size())
        {
            d.postInvalidate();
            return;
        }
        break MISSING_BLOCK_LABEL_86;
_L2:
        a(l1);
          goto _L3
        int j1 = i1;
        if (!((com.d.a.b)f.get(i1)).a(l1))
        {
            com.d.a.b b1 = (com.d.a.b)f.remove(i1);
            j1 = i1 - 1;
            e.add(b1);
        }
        i1 = j1 + 1;
          goto _L4
    }

    private boolean b(int i1, int j1)
    {
        return (i1 & j1) == j1;
    }

    private int c(int i1, int j1)
    {
        if (i1 == j1)
        {
            return i1;
        } else
        {
            return i1 + c.nextInt(j1 - i1);
        }
    }

    public float a(float f1)
    {
        return o * f1;
    }

    public d a(float f1, float f2)
    {
        m.add(new com.d.a.a.d(a(f1), a(f2), 0, 360));
        return this;
    }

    public d a(long l1, Interpolator interpolator)
    {
        l.add(new com.d.a.b.a(255, 0, g - l1, g, interpolator));
        return this;
    }

    public void a(View view, int i1, int j1, int k1)
    {
        a(view, i1);
        a(j1, k1);
    }

    public d b(float f1)
    {
        m.add(new b(f1, f1));
        return this;
    }

    public d b(float f1, float f2)
    {
        m.add(new c(f1, f2));
        return this;
    }

    public d c(float f1, float f2)
    {
        m.add(new b(f1, f2));
        return this;
    }
}
