// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Looper;
import android.text.Editable;
import android.text.TextPaint;
import android.util.AttributeSet;

// Referenced classes of package com.braintreepayments.cardform.view:
//            b, d, e, f

public class c extends b
{

    protected boolean a;
    private TextPaint b;
    private ValueAnimator c;
    private ValueAnimator d;
    private ValueAnimator e;
    private ValueAnimator f;
    private float g;
    private int h;
    private int i;
    private int j;

    public c(Context context)
    {
        super(context);
        b = new TextPaint();
        g = -1F;
        d();
    }

    public c(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = new TextPaint();
        g = -1F;
        d();
    }

    public c(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        b = new TextPaint();
        g = -1F;
        d();
    }

    static float a(c c1, float f1)
    {
        c1.g = f1;
        return f1;
    }

    static int a(c c1, int k)
    {
        c1.h = k;
        return k;
    }

    static int b(c c1, int k)
    {
        c1.i = k;
        return k;
    }

    private void d()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        j = getText().length();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            float f1 = getTextSize();
            c = ValueAnimator.ofFloat(new float[] {
                1.75F * f1, f1
            });
            c.addUpdateListener(new d(this));
            c.setDuration(300L);
            e e1 = new e(this);
            d = ValueAnimator.ofInt(new int[] {
                getInactiveColor(), getFocusedColor()
            });
            d.setEvaluator(new ArgbEvaluator());
            d.addUpdateListener(e1);
            d.setDuration(300L);
            e = ValueAnimator.ofInt(new int[] {
                getFocusedColor(), getInactiveColor()
            });
            e.setEvaluator(new ArgbEvaluator());
            e.addUpdateListener(e1);
            e.setDuration(300L);
            f = ValueAnimator.ofInt(new int[] {
                0, 255
            });
            f.addUpdateListener(new f(this));
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (getText().length() > 0)
        {
            b.setColor(h);
            b.setTextSize((getPaint().getTextSize() * 3F) / 4F);
            b.setAlpha(i);
            canvas.drawText(getHint().toString(), 0.0F, g, b);
        }
    }

    protected void onFocusChanged(boolean flag, int k, Rect rect)
    {
label0:
        {
            super.onFocusChanged(flag, k, rect);
            if (android.os.Build.VERSION.SDK_INT >= 11 && Looper.myLooper() != null)
            {
                if (!flag)
                {
                    break label0;
                }
                d.start();
            }
            return;
        }
        e.start();
    }

    public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
    {
        super.onTextChanged(charsequence, k, l, i1);
        if (android.os.Build.VERSION.SDK_INT >= 14 && Looper.myLooper() != null && j == 0 && charsequence.length() > 0 && !c.isStarted())
        {
            c.start();
            d.start();
            f.start();
        }
        j = charsequence.length();
    }
}
