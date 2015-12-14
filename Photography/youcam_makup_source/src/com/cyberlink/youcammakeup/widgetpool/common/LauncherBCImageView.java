// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LauncherBCImageView extends ImageView
{

    public LauncherBCImageView(Context context)
    {
        super(context);
    }

    public LauncherBCImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public LauncherBCImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void a(Drawable drawable)
    {
        float f1 = 0.0F;
        if (drawable == null)
        {
            return;
        }
        int i = drawable.getIntrinsicWidth();
        int j = drawable.getIntrinsicHeight();
        drawable = getImageMatrix();
        int k = getWidth() - getPaddingLeft() - getPaddingRight();
        int l = getHeight() - getPaddingTop() - getPaddingBottom();
        float f;
        float f2;
        if (i * l > k * j)
        {
            f = (float)l / (float)j;
            f2 = ((float)k - (float)i * f) * 0.5F;
        } else
        {
            f1 = (float)k / (float)i;
            float f3 = l;
            float f4 = j;
            f = f1;
            f2 = 0.0F;
            f1 = (f3 - f4 * f1) * 0.5F * 0.5F;
        }
        drawable.setScale(f, f);
        drawable.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        setImageMatrix(drawable);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        a(getDrawable());
        super.onSizeChanged(i, j, k, l);
    }

    public void setImageDrawable(Drawable drawable)
    {
        a(drawable);
        super.setImageDrawable(drawable);
    }
}
