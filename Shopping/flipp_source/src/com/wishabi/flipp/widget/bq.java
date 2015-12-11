// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.wishabi.flipp.widget:
//            FlyerViewGroup, dw, bt

final class bq
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    float a;
    float b;
    final FlyerViewGroup c;

    bq(FlyerViewGroup flyerviewgroup)
    {
        c = flyerviewgroup;
        super();
    }

    public final boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getFocusX();
        float f1 = scalegesturedetector.getFocusY();
        float f2 = scalegesturedetector.getFocusX() / (float)c.getWidth();
        float f3 = scalegesturedetector.getFocusY() / (float)c.getHeight();
        float f4 = scalegesturedetector.getFocusX() / FlyerViewGroup.a(c);
        float f5 = c.getScrollX();
        float f6 = scalegesturedetector.getFocusY() / FlyerViewGroup.a(c);
        float f7 = c.getScrollY();
        float f8 = FlyerViewGroup.a(c);
        c.setZoomScale(scalegesturedetector.getScaleFactor() * FlyerViewGroup.a(c));
        if (f8 != FlyerViewGroup.a(c))
        {
            FlyerViewGroup.b(c).setZooming(true);
        }
        f8 = (a - f) / FlyerViewGroup.a(c);
        float f9 = (b - f1) / FlyerViewGroup.a(c);
        int i = (int)((f4 + f5 + f8) - (f2 * (float)c.getWidth()) / FlyerViewGroup.a(c));
        int j = (int)((f6 + f7 + f9) - (f3 * (float)c.getHeight()) / FlyerViewGroup.a(c));
        c.scrollTo((int)Math.max(0.0F, Math.min(i, (float)FlyerViewGroup.c(c) - (float)c.getWidth() / FlyerViewGroup.a(c))), (int)Math.max(0.0F, Math.min(j, (float)FlyerViewGroup.d(c) - (float)c.getHeight() / FlyerViewGroup.a(c))));
        if (FlyerViewGroup.e(c) != null)
        {
            FlyerViewGroup.e(c).a(c);
        }
        a = f;
        b = f1;
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        a = scalegesturedetector.getFocusX();
        b = scalegesturedetector.getFocusY();
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        FlyerViewGroup.b(c).setZooming(false);
        if (FlyerViewGroup.e(c) != null)
        {
            FlyerViewGroup.e(c).a();
        }
    }
}
