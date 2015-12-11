// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

// Referenced classes of package com.bitstrips.imoji.services:
//            FloaterService

private class params
    implements android.view.erTouchListener
{

    private static final int MOVE_THRESHOLD = 10;
    private int counter;
    private float initialTouchX;
    private float initialTouchY;
    private int initialX;
    private int initialY;
    private boolean moved;
    private final android.view.erTouchListener.moved params;
    final FloaterService this$0;

    private void handleDown(MotionEvent motionevent)
    {
        counter = 0;
        initialX = params.params;
        initialY = params.params;
        initialTouchX = motionevent.getRawX();
        initialTouchY = motionevent.getRawY();
    }

    private void handleMove(MotionEvent motionevent)
    {
        counter = counter + 1;
        params.params = initialX + (int)(motionevent.getRawX() - initialTouchX);
        params.params = initialY + (int)(motionevent.getRawY() - initialTouchY);
        FloaterService.access$300(FloaterService.this).updateViewLayout(FloaterService.access$200(FloaterService.this), params);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            moved = false;
            handleDown(motionevent);
            return false;

        case 1: // '\001'
            if (!moved)
            {
                view.performClick();
            }
            return moved;

        case 2: // '\002'
            handleMove(motionevent);
            break;
        }
        boolean flag;
        if (counter > 10)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        moved = flag;
        return false;
    }

    public (android.view.erTouchListener ertouchlistener)
    {
        this$0 = FloaterService.this;
        super();
        moved = false;
        params = ertouchlistener;
    }
}
