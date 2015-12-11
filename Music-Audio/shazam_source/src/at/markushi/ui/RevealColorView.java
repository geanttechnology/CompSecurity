// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package at.markushi.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import at.markushi.ui.a.a;

public class RevealColorView extends ViewGroup
{

    private View a;
    private int b;
    private ShapeDrawable c;
    private ViewPropertyAnimator d;

    public RevealColorView(Context context)
    {
        this(context, null);
    }

    public RevealColorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RevealColorView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (isInEditMode())
        {
            return;
        }
        a = new View(context);
        addView(a);
        c = new ShapeDrawable(new OvalShape());
        context = a;
        attributeset = c;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            context.setBackground(attributeset);
        } else
        {
            context.setBackgroundDrawable(attributeset);
        }
        a.setVisibility(4);
    }

    private float a(int i, int j)
    {
        float f2 = (float)getWidth() / 2.0F;
        float f1 = (float)getHeight() / 2.0F;
        float f = (float)Math.sqrt(f2 * f2 + f1 * f1);
        f2 -= i;
        f1 -= j;
        return ((float)Math.sqrt(f2 * f2 + f1 * f1) / f) * 0.5F + 0.5F;
    }

    static View a(RevealColorView revealcolorview)
    {
        return revealcolorview.a;
    }

    private static ViewPropertyAnimator a(ViewPropertyAnimator viewpropertyanimator)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            viewpropertyanimator.withLayer();
        }
        viewpropertyanimator.setInterpolator(at.markushi.ui.a.a.a());
        return viewpropertyanimator;
    }

    private static void a(View view, int i, int j, float f)
    {
        int k = view.getWidth() / 2;
        int l = view.getHeight() / 2;
        view.setTranslationX(i - k);
        view.setTranslationY(j - l);
        view.setPivotX(k);
        view.setPivotY(l);
        view.setScaleX(f);
        view.setScaleY(f);
    }

    public final void a(int i, int j, int k, long l, android.animation.Animator.AnimatorListener animatorlistener)
    {
        if (k == b)
        {
            return;
        }
        b = k;
        if (d != null)
        {
            d.cancel();
        }
        c.getPaint().setColor(k);
        a.setVisibility(0);
        float f = 0.0F / (float)a.getHeight();
        float f1 = a(i, j) * 8F;
        a(a, i, j, f);
        d = a.animate().scaleX(f1).scaleY(f1).setDuration(l).setListener(new android.animation.Animator.AnimatorListener(animatorlistener, k) {

            final android.animation.Animator.AnimatorListener a;
            final int b;
            final RevealColorView c;

            public final void onAnimationCancel(Animator animator)
            {
                if (a != null)
                {
                    a.onAnimationCancel(animator);
                }
            }

            public final void onAnimationEnd(Animator animator)
            {
                c.setBackgroundColor(b);
                at.markushi.ui.RevealColorView.a(c).setVisibility(4);
                if (a != null)
                {
                    a.onAnimationEnd(animator);
                }
            }

            public final void onAnimationRepeat(Animator animator)
            {
                if (a != null)
                {
                    a.onAnimationRepeat(animator);
                }
            }

            public final void onAnimationStart(Animator animator)
            {
                if (a != null)
                {
                    a.onAnimationStart(animator);
                }
            }

            
            {
                c = RevealColorView.this;
                a = animatorlistener;
                b = i;
                super();
            }
        });
        a(d);
        d.start();
    }

    public final void b(int i, int j, int k, long l, android.animation.Animator.AnimatorListener animatorlistener)
    {
        b = 0;
        if (d != null)
        {
            d.cancel();
        }
        a.setVisibility(0);
        setBackgroundColor(k);
        float f = a(i, j);
        float f1 = 0.0F / (float)a.getWidth();
        a(a, i, j, f * 8F);
        d = a.animate().scaleX(f1).scaleY(f1).setDuration(l).setListener(new android.animation.Animator.AnimatorListener(animatorlistener) {

            final android.animation.Animator.AnimatorListener a;
            final RevealColorView b;

            public final void onAnimationCancel(Animator animator)
            {
                if (a != null)
                {
                    a.onAnimationCancel(animator);
                }
            }

            public final void onAnimationEnd(Animator animator)
            {
                at.markushi.ui.RevealColorView.a(b).setVisibility(4);
                if (a != null)
                {
                    a.onAnimationEnd(animator);
                }
            }

            public final void onAnimationRepeat(Animator animator)
            {
                if (a != null)
                {
                    a.onAnimationRepeat(animator);
                }
            }

            public final void onAnimationStart(Animator animator)
            {
                if (a != null)
                {
                    a.onAnimationStart(animator);
                }
            }

            
            {
                b = RevealColorView.this;
                a = animatorlistener;
                super();
            }
        });
        a(d);
        d.start();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        a.layout(i, j, a.getMeasuredWidth() + i, a.getMeasuredHeight() + j);
    }

    protected void onMeasure(int i, int j)
    {
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(i, j);
        i = android.view.View.MeasureSpec.makeMeasureSpec((int)(((float)Math.sqrt(i * i + j * j) * 2.0F) / 8F), 0x40000000);
        a.measure(i, i);
    }
}
