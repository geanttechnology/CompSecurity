// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package android.support.v7:
//            d, h, c, e

class g
    implements d
{
    static class a
        implements android.animation.Animator.AnimatorListener
    {

        final c a;
        final h b;

        public void onAnimationCancel(Animator animator)
        {
            a.onAnimationCancel(b);
        }

        public void onAnimationEnd(Animator animator)
        {
            a.onAnimationEnd(b);
        }

        public void onAnimationRepeat(Animator animator)
        {
            a.onAnimationRepeat(b);
        }

        public void onAnimationStart(Animator animator)
        {
            a.onAnimationStart(b);
        }

        public a(c c1, h h)
        {
            a = c1;
            b = h;
        }
    }

    static class b
        implements h
    {

        final Animator a;

        public void a()
        {
            a.start();
        }

        public void a(long l)
        {
            a.setDuration(l);
        }

        public void a(c c1)
        {
            a.addListener(new a(c1, this));
        }

        public void a(e e)
        {
            if (a instanceof ValueAnimator)
            {
                ((ValueAnimator)a).addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(this, e) {

                    final e a;
                    final b b;

                    public void onAnimationUpdate(ValueAnimator valueanimator)
                    {
                        a.onAnimationUpdate(b);
                    }

            
            {
                b = b1;
                a = e1;
                super();
            }
                });
            }
        }

        public void a(View view)
        {
            a.setTarget(view);
        }

        public void b()
        {
            a.cancel();
        }

        public float c()
        {
            return ((ValueAnimator)a).getAnimatedFraction();
        }

        public b(Animator animator)
        {
            a = animator;
        }
    }


    g()
    {
    }

    public h a()
    {
        return new b(ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        }));
    }
}
