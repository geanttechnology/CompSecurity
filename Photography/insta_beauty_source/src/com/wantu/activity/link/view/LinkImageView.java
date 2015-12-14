// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LinkImageView extends ImageView
{

    private Rect mBounds;
    private Paint mHighlightPaint;

    public LinkImageView(Context context)
    {
        super(context);
        mBounds = new Rect();
        init();
    }

    public LinkImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mBounds = new Rect();
        init();
    }

    public LinkImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        mBounds = new Rect();
    }

    protected void init()
    {
        mHighlightPaint = new Paint(1);
        int i = (int)getContext().getResources().getDimension(0x7f080032);
        mHighlightPaint.setStrokeWidth(i);
        mHighlightPaint.setColor(Color.parseColor("#0773bc"));
        mHighlightPaint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isSelected())
        {
            int i = (int)getContext().getResources().getDimension(0x7f080031);
            mBounds.set(0, 0, getWidth(), getHeight());
            mBounds.inset(i, i);
            canvas.drawRect(mBounds, mHighlightPaint);
        }
    }
}
