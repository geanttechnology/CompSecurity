// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.ScaleGestureDetector;
import android.view.View;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PhotoViewerActivity

class  extends android.view.impleOnScaleGestureListener
{

    final PhotoViewerActivity a;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        UICImageView uicimageview = (UICImageView)PhotoViewerActivity.h(a);
        if (uicimageview == null) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f7;
        f1 = (6F * (float)uicimageview.getBitmapWidth()) / (float)uicimageview.getWidth();
        f = scalegesturedetector.getScaleFactor();
        f1 = Math.max(1.0F, Math.min(PhotoViewerActivity.h(a).getScaleX() * f, f1));
        scalegesturedetector = new float[2];
        scalegesturedetector;
        scalegesturedetector[0] = 0.0F;
        scalegesturedetector[1] = 0.0F;
        f2 = uicimageview.getTop();
        f5 = PhotoViewerActivity.i(a) * f1;
        f7 = PhotoViewerActivity.j(a) * f1;
        Math.abs(PhotoViewerActivity.i(a) - f5);
        Math.abs(PhotoViewerActivity.j(a) - f7);
        f3 = uicimageview.getTranslationX();
        f4 = uicimageview.getTranslationY();
        if (PhotoViewerActivity.k(a) != 0.0F) goto _L4; else goto _L3
_L3:
        scalegesturedetector[0] = PhotoViewerActivity.i(a) - f5;
        scalegesturedetector[1] = PhotoViewerActivity.j(a) - f7;
_L6:
        if (scalegesturedetector[0] > 0.0F)
        {
            scalegesturedetector[0] = 0.0F;
        }
        if (scalegesturedetector[1] > f2)
        {
            scalegesturedetector[1] = f2;
        }
        PhotoViewerActivity.a(a, f1);
        uicimageview.setScaleX(f1);
        uicimageview.setScaleY(f1);
        uicimageview.setTranslationX(scalegesturedetector[0]);
        uicimageview.setTranslationY(scalegesturedetector[1]);
_L2:
        return true;
_L4:
        float f6 = PhotoViewerActivity.i(a) * Math.abs(PhotoViewerActivity.l(a) - f1);
        float f8 = PhotoViewerActivity.j(a) * Math.abs(PhotoViewerActivity.l(a) - f1);
        if (f > 1.0F)
        {
            scalegesturedetector[0] = f3 - f6;
            scalegesturedetector[1] = f4 - f8;
        } else
        {
            scalegesturedetector[0] = f3 + f6;
            scalegesturedetector[1] = f4 + f8;
        }
        if (f1 == 1.0F)
        {
            scalegesturedetector[0] = 0.0F;
            scalegesturedetector[1] = 0.0F;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        UICImageView uicimageview = (UICImageView)PhotoViewerActivity.h(a);
        float f = (6F * (float)uicimageview.getBitmapWidth()) / (float)uicimageview.getWidth();
        f = Math.max(1.0F, Math.min(scalegesturedetector.getScaleFactor() * PhotoViewerActivity.h(a).getScaleX(), f));
        PhotoViewerActivity.a(a, f);
        float f1 = uicimageview.getX();
        float f2 = uicimageview.getY();
        float f3 = uicimageview.getTranslationX();
        float f4 = scalegesturedetector.getFocusX();
        float f5 = scalegesturedetector.getFocusY();
        PhotoViewerActivity.b(a, f4 - f1);
        PhotoViewerActivity.c(a, f5 - f2);
        PhotoViewerActivity.d(a, f);
        PhotoViewerActivity.e(a, f);
        PhotoViewerActivity.f(a, f3);
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
    }

    (PhotoViewerActivity photovieweractivity)
    {
        a = photovieweractivity;
        super();
    }
}
