// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

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
    private boolean isFix;
    private boolean isOnline;
    private boolean isSelected;
    int lineWidth;
    Bitmap onlineIconBitmap;
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
        isOnline = false;
        isFix = false;
        color = getContext().getResources().getColor(0x7f0b0084);
    }

    public StatusImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        color = 0xff0000ff;
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
        isOnline = false;
        isFix = false;
        color = getContext().getResources().getColor(0x7f0b0084);
    }

    public StatusImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        color = 0xff0000ff;
        isSelected = false;
        paint = new Paint();
        rf = new RectF();
        lineWidth = 4;
        isOnline = false;
        isFix = false;
        color = getContext().getResources().getColor(0x7f0b0084);
    }

    public void clear()
    {
        setImageBitmap(null);
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
        }
        setOnlineIconBitmap(null);
        if (onlineIconBitmap != null && !onlineIconBitmap.isRecycled())
        {
            onlineIconBitmap.recycle();
        }
    }

    public Bitmap getOnlineIconBitmap()
    {
        return onlineIconBitmap;
    }

    public boolean isFix()
    {
        return isFix;
    }

    public boolean isOnline()
    {
        return isOnline;
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
            rf.left = 0.0F;
            rf.right = getWidth();
            rf.top = 0.0F;
            rf.bottom = getHeight();
            RectF rectf = rf;
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
        if (isOnline && onlineIconBitmap != null && !onlineIconBitmap.isRecycled())
        {
            RectF rectf1 = new RectF(0.0F, 0.0F, onlineIconBitmap.getWidth() / 2, onlineIconBitmap.getHeight() / 2);
            canvas.drawBitmap(onlineIconBitmap, null, rectf1, paint);
        }
    }

    public void setFix(boolean flag)
    {
        isFix = flag;
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

    public void setOnline(boolean flag)
    {
        isOnline = flag;
    }

    public void setOnlineIconBitmap(Bitmap bitmap1)
    {
        onlineIconBitmap = bitmap1;
    }
}
