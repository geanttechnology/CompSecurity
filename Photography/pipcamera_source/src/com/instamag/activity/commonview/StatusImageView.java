// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.fotoable.comlib.ui.RecyclingImageView;

public class StatusImageView extends RecyclingImageView
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
        color = getResources().getColor(0x7f0b0086);
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
    }

    public StatusImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        color = getResources().getColor(0x7f0b0086);
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
    }

    public StatusImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        color = getResources().getColor(0x7f0b0086);
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
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
            rf.left = lineWidth / 2;
            rf.top = lineWidth / 2;
            rf.bottom = getHeight() - lineWidth / 2;
            rf.right = getWidth() - lineWidth / 2;
            if ((double)getResources().getDisplayMetrics().density > 2.5D)
            {
                lineWidth = 8;
            }
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
