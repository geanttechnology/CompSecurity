// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiComposeView, TTieZhiInfoView

class a
    implements android.view.OnScaleGestureListener
{

    final TTieZhiComposeView a;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.setNewScale(scalegesturedetector.getScaleFactor());
            TTieZhiComposeView.access$000(a, a.selecTieZhiInfoView);
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.invalidate();
        }
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.invalidate();
        }
    }

    reListener(TTieZhiComposeView ttiezhicomposeview)
    {
        a = ttiezhicomposeview;
        super();
    }
}
