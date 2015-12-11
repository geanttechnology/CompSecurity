// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            PassiveGestureListener

public class GestureListenerLayout extends LinearLayout
{

    private GestureDetector gestureDetector;
    private boolean isDownValid;

    public GestureListenerLayout(Context context)
    {
        super(context);
        isDownValid = false;
    }

    public GestureListenerLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isDownValid = false;
    }

    public GestureListenerLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        isDownValid = false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (gestureDetector != null)
        {
            if (motionevent.getAction() == 0)
            {
                isDownValid = PassiveGestureListener.isDownInRange(motionevent, getContext().getResources().getDisplayMetrics());
                return isDownValid;
            }
            if (isDownValid)
            {
                return gestureDetector.onTouchEvent(motionevent);
            } else
            {
                return false;
            }
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (gestureDetector != null)
        {
            if (motionevent.getAction() == 0)
            {
                isDownValid = PassiveGestureListener.isDownInRange(motionevent, getContext().getResources().getDisplayMetrics());
                return isDownValid;
            }
            if (isDownValid)
            {
                return gestureDetector.onTouchEvent(motionevent);
            } else
            {
                return false;
            }
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setGestureListener(GestureDetector gesturedetector)
    {
        gestureDetector = gesturedetector;
    }
}
