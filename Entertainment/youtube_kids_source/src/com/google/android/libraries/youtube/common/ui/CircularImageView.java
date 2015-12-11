// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.common.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import blw;

public class CircularImageView extends ImageView
{

    private blw a;
    private blw b;

    public CircularImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (a != null)
        {
            a.a(i, j);
        }
        if (b != null)
        {
            b.a(i, j);
        }
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        if (drawable == null)
        {
            super.setBackgroundDrawable(null);
            return;
        }
        if (b == null)
        {
            b = new blw(drawable, getMeasuredWidth(), getMeasuredHeight());
        } else
        {
            b.a(drawable);
        }
        super.setBackgroundDrawable(b);
    }

    public void setImageDrawable(Drawable drawable)
    {
        if (drawable == null)
        {
            super.setImageDrawable(null);
            return;
        }
        if (a == null)
        {
            a = new blw(drawable, getMeasuredWidth(), getMeasuredHeight());
        } else
        {
            a.a(drawable);
        }
        super.setImageDrawable(a);
    }
}
