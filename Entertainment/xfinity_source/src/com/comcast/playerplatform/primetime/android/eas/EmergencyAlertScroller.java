// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class EmergencyAlertScroller extends HorizontalScrollView
{

    public EmergencyAlertScroller(Context context)
    {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return false;
    }
}
