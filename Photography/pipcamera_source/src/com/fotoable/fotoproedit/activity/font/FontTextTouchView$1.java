// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.util.Log;
import android.view.ScaleGestureDetector;
import hu;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextTouchView

class a
    implements android.view..OnScaleGestureListener
{

    final FontTextTouchView a;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getScaleFactor();
        Log.e("SCALE", (new StringBuilder()).append("scale:").append(f).toString());
        if (FontTextTouchView.access$000(a) != null)
        {
            FontTextTouchView.access$000(a).b();
            FontTextTouchView.access$000(a).a(f);
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        if (FontTextTouchView.access$000(a) != null)
        {
            FontTextTouchView.access$000(a).b();
        }
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        if (FontTextTouchView.access$000(a) != null)
        {
            FontTextTouchView.access$000(a).b();
        }
    }

    (FontTextTouchView fonttexttouchview)
    {
        a = fonttexttouchview;
        super();
    }
}
