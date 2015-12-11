// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            GestureInterceptable

public class GestureInterceptorLinearLayout extends LinearLayout
    implements GestureInterceptable
{

    private GestureDetector gestureDetector;

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (gestureDetector != null)
        {
            return gestureDetector.onTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (gestureDetector != null)
        {
            gestureDetector.onTouchEvent(motionevent);
        }
        return true;
    }

    public void setGestureListener(android.view.GestureDetector.SimpleOnGestureListener simpleongesturelistener)
    {
        if (simpleongesturelistener != null)
        {
            gestureDetector = new GestureDetector(simpleongesturelistener);
            return;
        } else
        {
            gestureDetector = null;
            return;
        }
    }
}
