// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

// Referenced classes of package jumiomobile:
//            bg, mx, my, mz

public class mw extends View
{

    private AnimatorSet a;
    private AnimatorSet b;
    private Paint c;
    private Paint d;
    private RectF e;
    private boolean f;
    private Paint g;
    private int h;
    private int i;

    public mw(Context context)
    {
        super(context);
        f = true;
        int j = bg.a(context, 3);
        c = new Paint();
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(j);
        c.setColor(0xb3ffffff);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setAntiAlias(true);
        d = new Paint();
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeWidth(j);
        d.setColor(0xb35e760a);
        d.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        d.setAntiAlias(true);
        a = a(30, 15, 30, 60, 0xb3ffffff, 0xb35e760a, 300);
        b = a(15, 30, 60, 30, 0xb35e760a, 0xb3ffffff, 200);
        g = c;
        h = 0;
        i = 0;
        a(false);
    }

    static int a(mw mw1, int j)
    {
        mw1.h = j;
        return j;
    }

    private AnimatorSet a(int j, int k, int l, int i1, int j1, int k1, int l1)
    {
        ValueAnimator valueanimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] {
            PropertyValuesHolder.ofInt("startAngle", new int[] {
                j, k
            })
        });
        valueanimator.setDuration(l1);
        valueanimator.addUpdateListener(new mx(this));
        ValueAnimator valueanimator1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] {
            PropertyValuesHolder.ofInt("sweepAngle", new int[] {
                l, i1
            })
        });
        valueanimator1.setDuration(l1);
        valueanimator1.addUpdateListener(new my(this));
        ValueAnimator valueanimator2 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] {
            PropertyValuesHolder.ofInt("color", new int[] {
                j1, k1
            })
        });
        valueanimator2.setEvaluator(new ArgbEvaluator());
        valueanimator2.setDuration(l1);
        valueanimator2.addUpdateListener(new mz(this));
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            valueanimator2, valueanimator, valueanimator1
        });
        return animatorset;
    }

    static Paint a(mw mw1)
    {
        return mw1.g;
    }

    static int b(mw mw1, int j)
    {
        mw1.i = j;
        return j;
    }

    public void a(boolean flag)
    {
        if (f == flag)
        {
            return;
        }
        f = flag;
        if (flag)
        {
            if (b.isRunning())
            {
                b.cancel();
            }
            a.start();
            return;
        }
        if (a.isRunning())
        {
            a.cancel();
        }
        b.start();
    }

    public void onDraw(Canvas canvas)
    {
        canvas.drawArc(e, h + 0, i, false, g);
        canvas.drawArc(e, h + 90, i, false, g);
        canvas.drawArc(e, h + 180, i, false, g);
        canvas.drawArc(e, h + 270, i, false, g);
        super.onDraw(canvas);
    }

    protected void onMeasure(int j, int k)
    {
        float f1 = 0.0F;
        super.onMeasure(j, k);
        j = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        k = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        float f2;
        if ((float)j / (float)k < 0.7616F)
        {
            f2 = (float)(k - Math.round((float)j / 0.7616F)) / 2.0F;
        } else
        {
            f1 = (float)(j - Math.round((float)k * 0.7616F)) / 2.0F;
            f2 = 0.0F;
        }
        e = new RectF((float)(getPaddingLeft() + 0) + f1, (float)getPaddingTop() + f2, (float)(getMeasuredWidth() - getPaddingRight()) - f1, (float)(getMeasuredHeight() - getPaddingBottom()) - f2);
    }
}
