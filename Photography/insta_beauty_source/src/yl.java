// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ScaleGestureDetector;

class yl
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    final yk a;

    yl(yk yk1)
    {
        a = yk1;
        super();
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        a.a.a(scalegesturedetector.getScaleFactor(), scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
    }
}
