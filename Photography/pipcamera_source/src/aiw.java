// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.util.Log;
import android.view.ScaleGestureDetector;
import wantu.sephiroth.android.library.imagezoom.RotateZoomMoveImageViewTouch;

public class aiw extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    final RotateZoomMoveImageViewTouch a;

    private aiw(RotateZoomMoveImageViewTouch rotatezoommoveimageviewtouch)
    {
        a = rotatezoommoveimageviewtouch;
        super();
    }

    public aiw(RotateZoomMoveImageViewTouch rotatezoommoveimageviewtouch, wantu.sephiroth.android.library.imagezoom.RotateZoomMoveImageViewTouch._cls1 _pcls1)
    {
        this(rotatezoommoveimageviewtouch);
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getScaleFactor();
        float f1 = a.saveScale;
        RotateZoomMoveImageViewTouch rotatezoommoveimageviewtouch = a;
        rotatezoommoveimageviewtouch.saveScale = rotatezoommoveimageviewtouch.saveScale * f;
        int i;
        int j;
        if (a.saveScale > a.maxScale)
        {
            a.saveScale = a.maxScale;
            f = a.maxScale / f1;
        } else
        if (a.saveScale < a.minScale)
        {
            a.saveScale = a.minScale;
            f = a.minScale / f1;
        }
        if (a.origWidth * a.saveScale <= (float)a.viewWidth || a.origHeight * a.saveScale <= (float)a.viewHeight)
        {
            a.matrix.postScale(f, f, a.viewWidth / 2, a.viewHeight / 2);
        } else
        {
            a.matrix.postScale(f, f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
        }
        i = (int)(a.origWidth * a.saveScale);
        j = (int)(a.origHeight * a.saveScale);
        if (i > 0 && j > 0)
        {
            Log.d("scalewidth-- ", (new StringBuilder()).append("").append(i).toString());
            Log.d("scaleheight-- ", (new StringBuilder()).append("").append(j).toString());
            scalegesturedetector = new android.widget.FrameLayout.LayoutParams(i, j);
            a.setLayoutParams(scalegesturedetector);
        }
        a.fixTrans();
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        a.mode = 2;
        return true;
    }
}
