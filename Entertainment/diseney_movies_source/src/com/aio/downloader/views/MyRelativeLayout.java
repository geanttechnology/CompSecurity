// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

// Referenced classes of package com.aio.downloader.views:
//            DragLayout

public class MyRelativeLayout extends RelativeLayout
{

    private DragLayout dl;

    public MyRelativeLayout(Context context)
    {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public MyRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (dl.getStatus() != DragLayout.Status.Close)
        {
            return true;
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (dl.getStatus() != DragLayout.Status.Close)
        {
            if (motionevent.getAction() == 1)
            {
                dl.close();
            }
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setDragLayout(DragLayout draglayout)
    {
        dl = draglayout;
    }
}
