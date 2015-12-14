// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.touchview;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.touchview:
//            TouchImageView

class b extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    final TouchImageView a;

    private b(TouchImageView touchimageview)
    {
        a = touchimageview;
        super();
    }

    b(TouchImageView touchimageview, TouchImageView._cls1 _pcls1)
    {
        this(touchimageview);
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = (float)Math.min(Math.max(0.95F, scalegesturedetector.getScaleFactor()), 1.05D);
        float f1 = a.t;
        TouchImageView touchimageview = a;
        touchimageview.t = touchimageview.t * f;
        if (a.t > a.v)
        {
            a.t = a.v;
            f = a.v / f1;
        } else
        if (a.t < a.u)
        {
            a.t = a.u;
            f = a.u / f1;
        }
        a.f = a.l * a.t - a.l - a.d * 2.0F * a.t;
        a.g = a.m * a.t - a.m - a.e * 2.0F * a.t;
        if (a.h * a.t <= a.l || a.i * a.t <= a.m)
        {
            a.a.postScale(f, f, a.l / 2.0F, a.m / 2.0F);
            if (f < 1.0F)
            {
                a.a.getValues(a.q);
                f1 = a.q[2];
                float f3 = a.q[5];
                if (f < 1.0F)
                {
                    if ((float)Math.round(a.h * a.t) < a.l)
                    {
                        if (f3 < -a.g)
                        {
                            a.a.postTranslate(0.0F, -(a.g + f3));
                        } else
                        if (f3 > 0.0F)
                        {
                            a.a.postTranslate(0.0F, -f3);
                        }
                    } else
                    if (f1 < -a.f)
                    {
                        a.a.postTranslate(-(f1 + a.f), 0.0F);
                    } else
                    if (f1 > 0.0F)
                    {
                        a.a.postTranslate(-f1, 0.0F);
                    }
                }
            }
        } else
        {
            a.a.postScale(f, f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
            a.a.getValues(a.q);
            float f2 = a.q[2];
            float f4 = a.q[5];
            if (f < 1.0F)
            {
                if (f2 < -a.f)
                {
                    a.a.postTranslate(-(f2 + a.f), 0.0F);
                } else
                if (f2 > 0.0F)
                {
                    a.a.postTranslate(-f2, 0.0F);
                }
                if (f4 < -a.g)
                {
                    a.a.postTranslate(0.0F, -(a.g + f4));
                } else
                if (f4 > 0.0F)
                {
                    a.a.postTranslate(0.0F, -f4);
                }
            }
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        a.c = 2;
        return true;
    }
}
