// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.amazon.gallery.foundation.utils.math.MathUtils;

public class OverlayView extends View
{
    public static interface SizeChangedListener
    {

        public abstract void sizeChanged(int i, int j, int k, int l);
    }


    private int aspectX;
    private int aspectY;
    private RectF cropRectScreenSpace;
    private boolean isCircleCrop;
    private Paint paint;
    private Path path;
    private SizeChangedListener sizeChangedListener;

    public OverlayView(Context context)
    {
        this(context, null, 0);
    }

    public OverlayView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public OverlayView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        paint = new Paint(1);
        if (getBackground() instanceof ColorDrawable)
        {
            context = (ColorDrawable)getBackground();
            paint.setColor(context.getColor());
            setBackgroundColor(0);
        }
    }

    public void enableCircleCrop()
    {
        isCircleCrop = true;
        aspectX = 1;
        aspectY = 1;
    }

    RectF getCropRect()
    {
        return cropRectScreenSpace;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (path != null)
        {
            canvas.drawPath(path, paint);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        RectF rectf = new RectF(0.0F, 0.0F, i, j);
        cropRectScreenSpace = MathUtils.scaleToFit(aspectX, aspectY, rectf, false);
        path = new Path();
        path.setFillType(android.graphics.Path.FillType.WINDING);
        path.addRect(0.0F, 0.0F, i, j, android.graphics.Path.Direction.CCW);
        if (isCircleCrop)
        {
            path.addCircle(cropRectScreenSpace.centerX(), cropRectScreenSpace.centerY(), Math.min(i, j) / 2, android.graphics.Path.Direction.CW);
        } else
        {
            path.addRect(cropRectScreenSpace, android.graphics.Path.Direction.CW);
        }
        if (sizeChangedListener != null)
        {
            sizeChangedListener.sizeChanged(i, j, k, l);
        }
    }

    public void setAspectRatio(int i, int j)
    {
        aspectX = i;
        aspectY = j;
    }

    public void setSizeChangedListener(SizeChangedListener sizechangedlistener)
    {
        sizeChangedListener = sizechangedlistener;
    }
}
