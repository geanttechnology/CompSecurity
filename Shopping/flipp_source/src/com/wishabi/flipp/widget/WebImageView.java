// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.a.b.ad;
import com.a.b.aq;

public class WebImageView extends ImageView
{

    protected String a;
    protected boolean b;

    public WebImageView(Context context)
    {
        this(context, null);
    }

    public WebImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public WebImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void a()
    {
        ad.a(getContext()).a(a).a(this, null);
    }

    protected void onDraw(Canvas canvas)
    {
        if (!b)
        {
            super.onDraw(canvas);
        } else
        {
            Drawable drawable = getDrawable();
            if (drawable != null)
            {
                int i = drawable.getIntrinsicWidth();
                int j = drawable.getIntrinsicHeight();
                float f = (float)getWidth() / (float)i;
                float f1 = (float)getHeight() / (float)j;
                if (f <= f1)
                {
                    f = f1;
                }
                canvas.scale(f, f);
                drawable.draw(canvas);
                return;
            }
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        setImageDrawable(null);
        if (a != null)
        {
            a();
        }
    }

    public void setImageUrl(String s)
    {
        if ((a != null || s != null) && (a == null || s == null || !a.equals(s)))
        {
            a = s;
            setImageDrawable(null);
            if (s != null)
            {
                a();
                return;
            }
        }
    }

    public void setTopLeftCrop(boolean flag)
    {
        b = flag;
    }
}
