// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

class i extends g.e
{

    final ValueAnimator a = new ValueAnimator();

    i()
    {
    }

    public void a()
    {
        a.start();
    }

    public void a(float f, float f1)
    {
        a.setFloatValues(new float[] {
            f, f1
        });
    }

    public void a(int j)
    {
        a.setDuration(j);
    }

    public void a(int j, int k)
    {
        a.setIntValues(new int[] {
            j, k
        });
    }

    public void a(g.e.a a1)
    {
        a.addListener(new AnimatorListenerAdapter(a1) {

            final g.e.a a;
            final i b;

            public void onAnimationCancel(Animator animator)
            {
                a.c();
            }

            public void onAnimationEnd(Animator animator)
            {
                a.b();
            }

            public void onAnimationStart(Animator animator)
            {
                a.a();
            }

            
            {
                b = i.this;
                a = a1;
                super();
            }
        });
    }

    public void a(g.e.b b1)
    {
        a.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(b1) {

            final g.e.b a;
            final i b;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                a.a();
            }

            
            {
                b = i.this;
                a = b1;
                super();
            }
        });
    }

    public void a(Interpolator interpolator)
    {
        a.setInterpolator(interpolator);
    }

    public int b()
    {
        return ((Integer)a.getAnimatedValue()).intValue();
    }

    public void c()
    {
        a.cancel();
    }

    public float d()
    {
        return a.getAnimatedFraction();
    }
}
