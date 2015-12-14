// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ScaleGestureDetector;
import com.fotoable.shareinstagram.HandleBmpView;

public class auc
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    final HandleBmpView a;

    public auc(HandleBmpView handlebmpview)
    {
        a = handlebmpview;
        super();
    }

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
}
