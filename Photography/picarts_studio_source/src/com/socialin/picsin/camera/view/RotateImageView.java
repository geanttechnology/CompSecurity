// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class RotateImageView extends ImageView
{

    private int a;
    private int b;
    private int c;
    private boolean d;
    private long e;
    private long f;

    public RotateImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        b = 0;
        c = 0;
        d = false;
        e = 0L;
        f = 0L;
    }

    protected void onDraw(Canvas canvas)
    {
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            Rect rect = drawable.getBounds();
            int j = rect.right - rect.left;
            int k = rect.bottom - rect.top;
            if (j != 0 && k != 0)
            {
                if (a != c)
                {
                    long l2 = AnimationUtils.currentAnimationTimeMillis();
                    if (l2 < f)
                    {
                        int i = (int)(l2 - e);
                        int l = b;
                        int i1;
                        int j1;
                        int k1;
                        int l1;
                        int i2;
                        if (!d)
                        {
                            i = -i;
                        }
                        i = (i * 180) / 1000 + l;
                        if (i >= 0)
                        {
                            i %= 360;
                        } else
                        {
                            i = i % 360 + 360;
                        }
                        a = i;
                        invalidate();
                    } else
                    {
                        a = c;
                    }
                }
                i = getPaddingLeft();
                l = getPaddingTop();
                i1 = getPaddingRight();
                j1 = getPaddingBottom();
                k1 = getWidth();
                l1 = getHeight();
                i2 = canvas.getSaveCount();
                canvas.translate(i + (k1 - i - i1) / 2, l + (l1 - l - j1) / 2);
                canvas.rotate(-a);
                canvas.translate(-j / 2, -k / 2);
                drawable.draw(canvas);
                canvas.restoreToCount(i2);
                return;
            }
        }
    }

    public void setDegree(int i)
    {
        if (i >= 0)
        {
            i %= 360;
        } else
        {
            i = i % 360 + 360;
        }
        if (i == c)
        {
            return;
        }
        c = i;
        b = a;
        e = AnimationUtils.currentAnimationTimeMillis();
        i = c - a;
        long l;
        boolean flag;
        if (i < 0)
        {
            i += 360;
        }
        if (i > 180)
        {
            i -= 360;
        }
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        l = e;
        f = (long)((Math.abs(i) * 1000) / 180) + l;
        invalidate();
    }
}
