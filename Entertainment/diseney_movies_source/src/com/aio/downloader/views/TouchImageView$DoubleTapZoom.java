// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.animation.AccelerateDecelerateInterpolator;

// Referenced classes of package com.aio.downloader.views:
//            TouchImageView

private class endTouch
    implements Runnable
{

    private static final float ZOOM_TIME = 500F;
    private float bitmapX;
    private float bitmapY;
    private PointF endTouch;
    private AccelerateDecelerateInterpolator interpolator;
    private long startTime;
    private PointF startTouch;
    private float startZoom;
    private boolean stretchImageToSuper;
    private float targetZoom;
    final TouchImageView this$0;

    private double calculateDeltaScale(float f)
    {
        return (double)(startZoom + (targetZoom - startZoom) * f) / (double)TouchImageView.access$5(TouchImageView.this);
    }

    private float interpolate()
    {
        float f = Math.min(1.0F, (float)(System.currentTimeMillis() - startTime) / 500F);
        return interpolator.getInterpolation(f);
    }

    private void translateImageToCenterTouchPosition(float f)
    {
        float f1 = startTouch.x;
        float f2 = endTouch.x;
        float f3 = startTouch.x;
        float f4 = startTouch.y;
        float f5 = endTouch.y;
        float f6 = startTouch.y;
        PointF pointf = TouchImageView.access$22(TouchImageView.this, bitmapX, bitmapY);
        TouchImageView.access$16(TouchImageView.this).postTranslate((f1 + (f2 - f3) * f) - pointf.x, (f4 + (f5 - f6) * f) - pointf.y);
    }

    public void run()
    {
        float f = interpolate();
        double d = calculateDeltaScale(f);
        TouchImageView.access$20(TouchImageView.this, d, bitmapX, bitmapY, stretchImageToSuper);
        translateImageToCenterTouchPosition(f);
        TouchImageView.access$23(TouchImageView.this);
        setImageMatrix(TouchImageView.access$16(TouchImageView.this));
        if (TouchImageView.access$19(TouchImageView.this) != null)
        {
            TouchImageView.access$19(TouchImageView.this).onMove();
        }
        if (f < 1.0F)
        {
            TouchImageView.access$3(TouchImageView.this, this);
            return;
        } else
        {
            TouchImageView.access$10(TouchImageView.this, this._fld0);
            return;
        }
    }

    r(float f, float f1, float f2, boolean flag)
    {
        this$0 = TouchImageView.this;
        super();
        interpolator = new AccelerateDecelerateInterpolator();
        TouchImageView.access$10(TouchImageView.this, ZOOM);
        startTime = System.currentTimeMillis();
        startZoom = TouchImageView.access$5(TouchImageView.this);
        targetZoom = f;
        stretchImageToSuper = flag;
        PointF pointf = TouchImageView.access$21(TouchImageView.this, f1, f2, false);
        bitmapX = pointf.x;
        bitmapY = pointf.y;
        startTouch = TouchImageView.access$22(TouchImageView.this, bitmapX, bitmapY);
        endTouch = new PointF(TouchImageView.access$11(TouchImageView.this) / 2, TouchImageView.access$14(TouchImageView.this) / 2);
    }
}
