// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.view.ScaleGestureDetector;

// Referenced classes of package com.fotoable.shareinstagram:
//            HandleBmpView

class a
    implements android.view.ctor.OnScaleGestureListener
{

    final HandleBmpView a;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        HandleBmpView handlebmpview = a;
        handlebmpview.lastScale = handlebmpview.lastScale * a.newScale;
        a.newScale = scalegesturedetector.getScaleFactor();
        HandleBmpView.access$002(a, false);
        a.invalidate();
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        scalegesturedetector = a;
        scalegesturedetector.lastScale = ((HandleBmpView) (scalegesturedetector)).lastScale * a.newScale;
        a.newScale = 1.0F;
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        scalegesturedetector = a;
        scalegesturedetector.lastScale = ((HandleBmpView) (scalegesturedetector)).lastScale * a.newScale;
        a.newScale = 1.0F;
    }

    tureListener(HandleBmpView handlebmpview)
    {
        a = handlebmpview;
        super();
    }
}
