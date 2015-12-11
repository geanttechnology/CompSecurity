// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.listener;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import com.groupon.activity.Carousel;

public class OnRecyclerItemTouchListener
    implements android.support.v7.widget.RecyclerView.OnItemTouchListener
{

    private Carousel carousel;

    public OnRecyclerItemTouchListener(Carousel carousel1)
    {
        carousel = carousel1;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        case 2: // '\002'
        default:
            return false;

        case 0: // '\0'
            carousel.doSetTabSwipingEnabled(false);
            return false;

        case 1: // '\001'
        case 3: // '\003'
            carousel.doSetTabSwipingEnabled(true);
            break;
        }
        return false;
    }

    public void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
    }
}
