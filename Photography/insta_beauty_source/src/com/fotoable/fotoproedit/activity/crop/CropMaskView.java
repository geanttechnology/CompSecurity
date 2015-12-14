// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CropMaskView extends View
{

    private Rect clearrect;
    private Paint mPaint;
    private int viewH;
    private int viewW;

    public CropMaskView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        clearrect = new Rect();
        viewH = 0;
        viewW = 0;
        init();
    }

    private void init()
    {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(0x7f0c0092));
        mPaint.setStrokeWidth(4F);
        clearrect.set(0, 0, 100, 100);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Bitmap bitmap = Bitmap.createBitmap(viewW, viewH, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(bitmap);
        canvas1.drawARGB(160, 63, 63, 63);
        mPaint.setColor(0);
        mPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        canvas1.drawRect(clearrect, mPaint);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, new Paint());
    }

    protected void onMeasure(int i, int j)
    {
        viewW = android.view.View.MeasureSpec.getSize(i);
        viewH = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(viewW, viewH);
        super.onMeasure(i, j);
    }

    public void setClearRect(Rect rect)
    {
        clearrect.set(rect);
        invalidate();
    }
}
