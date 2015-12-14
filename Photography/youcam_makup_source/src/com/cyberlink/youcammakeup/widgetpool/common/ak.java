// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            SliderValueText

class ak extends android.view.GestureDetector.SimpleOnGestureListener
{

    final SliderValueText a;

    ak(SliderValueText slidervaluetext)
    {
        a = slidervaluetext;
        super();
    }

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        if (SliderValueText.a(a).booleanValue())
        {
            a.a();
            return true;
        } else
        {
            return false;
        }
    }
}
