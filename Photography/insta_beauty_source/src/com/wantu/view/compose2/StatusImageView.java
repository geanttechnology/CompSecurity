// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view.compose2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class StatusImageView extends ImageView
{

    Bitmap bitmap;
    private int color;
    private boolean isSelected;
    int lineWidth;
    Paint paint;
    RectF rf;

    public StatusImageView(Context context)
    {
        super(context);
        color = 0xff0000ff;
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
        color = getContext().getResources().getColor(0x7f0c0095);
    }

    public StatusImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        color = 0xff0000ff;
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
        color = getContext().getResources().getColor(0x7f0c0095);
    }

    public StatusImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        color = 0xff0000ff;
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
        color = getContext().getResources().getColor(0x7f0c0095);
    }

    public void clear()
    {
        setImageBitmap(null);
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
        }
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isSelected)
        {
            if (bitmap != null)
            {
                int l = bitmap.getHeight();
                int k = bitmap.getWidth();
                int j = getHeight();
                int i = getWidth();
                float f = (float)l / (float)j;
                float f1 = (float)k / (float)i;
                RectF rectf;
                if (f <= f1)
                {
                    f = f1;
                }
                l = (int)((float)l / f);
                k = (int)((float)k / f);
                j = (j - l) / 2;
                i = (i - k) / 2;
                rf.left = i;
                rf.right = getWidth() - i;
                rf.top = j;
                rf.bottom = getHeight() - j;
            } else
            {
                rf.left = 0.0F;
                rf.right = getWidth();
                rf.top = 0.0F;
                rf.bottom = getHeight();
            }
            rectf = rf;
            rectf.left = rectf.left + (float)(lineWidth / 2);
            rectf = rf;
            rectf.top = rectf.top + (float)(lineWidth / 2);
            rectf = rf;
            rectf.bottom = rectf.bottom - (float)(lineWidth / 2);
            rectf = rf;
            rectf.right = rectf.right - (float)(lineWidth / 2);
            paint.setColor(color);
            paint.setStrokeWidth(lineWidth);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawRect(rf, paint);
        }
    }

    public void setImageBitmap(Bitmap bitmap1)
    {
        bitmap = bitmap1;
        super.setImageBitmap(bitmap1);
    }

    public void setIsSelected(boolean flag)
    {
        isSelected = flag;
        invalidate();
    }
}
