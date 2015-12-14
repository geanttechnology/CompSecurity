// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.VideoView;
import xl;

public class BeautyVideoView extends VideoView
{

    xl mTouchListener;

    public BeautyVideoView(Context context)
    {
        super(context);
    }

    public BeautyVideoView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BeautyVideoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        mTouchListener.a();
        return super.onTouchEvent(motionevent);
    }

    public void setVideoViewTouchListener(xl xl1)
    {
        mTouchListener = xl1;
    }
}
