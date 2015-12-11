// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RevealImageView extends ImageView
{

    private float mPercent;
    private Rect mRect;

    public RevealImageView(Context context)
    {
        super(context);
        mRect = new Rect();
        a(context, null);
    }

    public RevealImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRect = new Rect();
        a(context, attributeset);
    }

    public RevealImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRect = new Rect();
        a(context, attributeset);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            mPercent = 1.0F;
            return;
        }
        context = context.obtainStyledAttributes(attributeset, com.target.ui.a.a.RevealImageView);
        float f = context.getFloat(0, 1.0F);
        if (f < 0.0F || f > 1.0F)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(String.valueOf(f)).append(" is not a valid percent.  Please enter a value between zero and one, inclusive.").toString());
        } else
        {
            mPercent = f;
            context.recycle();
            return;
        }
    }

    public float getPercent()
    {
        return mPercent;
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.getClipBounds(mRect);
        int i = Math.round((float)mRect.height() * mPercent);
        mRect.bottom = i + mRect.top;
        canvas.translate(0.0F, mRect.exactCenterY() - (float)(canvas.getHeight() / 2));
        canvas.clipRect(mRect);
        super.onDraw(canvas);
    }
}
