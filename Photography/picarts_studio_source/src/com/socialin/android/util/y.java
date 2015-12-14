// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;

// Referenced classes of package com.socialin.android.util:
//            z

public final class y
    implements android.support.v7.widget.RecyclerView.OnItemTouchListener
{

    private z a;
    private GestureDetector b;

    public y(Context context, z z1)
    {
        a = z1;
        b = new GestureDetector(context, new _cls1());
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
        android.view.View view = recyclerview.findChildViewUnder(motionevent.getX(), motionevent.getY());
        if (view != null && a != null && b.onTouchEvent(motionevent))
        {
            a.a(recyclerview.getChildPosition(view));
            return true;
        } else
        {
            return false;
        }
    }

    public final void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
    }

    /* member class not found */
    class _cls1 {}

}
