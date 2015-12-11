// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.target.ui.util.q;

public class HackyDrawerLayout extends DrawerLayout
{

    private static final String TAG = com/target/ui/view/HackyDrawerLayout.getSimpleName();

    public HackyDrawerLayout(Context context)
    {
        super(context);
    }

    public HackyDrawerLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public HackyDrawerLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            q.a(TAG, motionevent.toString());
            return false;
        }
        return flag;
    }

}
