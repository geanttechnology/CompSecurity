// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class gestureDetector extends android.view.erViewTouchListener
    implements android.support.v7.widget.stener
{

    private final GestureDetector gestureDetector;
    private boolean isScrolling;
    final DepartmentFragment this$0;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
        return gestureDetector.onTouchEvent(motionevent);
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        View view = DepartmentFragment.access$200(DepartmentFragment.this);
        if (view != null)
        {
            int i = view.getHeight();
            if (i > 0 && f1 > 0.0F)
            {
                isScrolling = true;
                i = Math.max(i - (int)f1, 0);
                view.measure(0, 0);
                int j = view.getMeasuredHeight();
                (new isScrolling(DepartmentFragment.this, view, 0, j)).formation((float)i / (float)j, null);
                if (i == 0)
                {
                    motionevent1 = MotionEvent.obtain(motionevent1);
                    motionevent1.setAction(1);
                    DepartmentFragment.access$300(DepartmentFragment.this).dispatchTouchEvent(motionevent1);
                    motionevent = MotionEvent.obtain(motionevent);
                    motionevent.setLocation(motionevent1.getX(), motionevent1.getY());
                    DepartmentFragment.access$300(DepartmentFragment.this).dispatchTouchEvent(motionevent);
                    isScrolling = false;
                    DepartmentFragment.access$402(DepartmentFragment.this, false);
                }
                return true;
            }
        }
        return false;
    }

    public void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
        if (motionevent.getActionMasked() == 1 && isScrolling)
        {
            DepartmentFragment.access$402(DepartmentFragment.this, false);
            isScrolling = false;
            collapseView(DepartmentFragment.access$200(DepartmentFragment.this));
        }
        gestureDetector.onTouchEvent(motionevent);
    }

    public ()
    {
        this$0 = DepartmentFragment.this;
        super();
        isScrolling = false;
        gestureDetector = new GestureDetector(getBaseActivity(), this);
    }
}
