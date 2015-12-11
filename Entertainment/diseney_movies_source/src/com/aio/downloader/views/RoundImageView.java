// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class RoundImageView extends ImageView
{

    private final Paint maskPaint;
    private float rect_adius;
    private final RectF roundRect;
    private final Paint zonePaint;

    public RoundImageView(Context context)
    {
        super(context);
        roundRect = new RectF();
        rect_adius = 60F;
        maskPaint = new Paint();
        zonePaint = new Paint();
        init();
    }

    public RoundImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        roundRect = new RectF();
        rect_adius = 60F;
        maskPaint = new Paint();
        zonePaint = new Paint();
        init();
    }

    private void init()
    {
        maskPaint.setAntiAlias(true);
        maskPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        zonePaint.setAntiAlias(true);
        zonePaint.setColor(0xfff4f3ef);
        float f = getResources().getDisplayMetrics().density;
        rect_adius = rect_adius * f;
    }

    public void draw(Canvas canvas)
    {
        canvas.saveLayer(roundRect, zonePaint, 31);
        canvas.drawRoundRect(roundRect, rect_adius, rect_adius, zonePaint);
        canvas.saveLayer(roundRect, maskPaint, 31);
        super.draw(canvas);
        canvas.restore();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        i = getWidth();
        j = getHeight();
        roundRect.set(0.0F, 0.0F, i, j);
    }

    public void setRectAdius(float f)
    {
        rect_adius = f;
        invalidate();
    }
}
