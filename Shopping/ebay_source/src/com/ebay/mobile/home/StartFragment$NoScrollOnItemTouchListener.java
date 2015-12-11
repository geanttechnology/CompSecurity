// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

static class noScrollGestureDetector
    implements android.support.v7.widget.ollGestureDetector
{

    private static final android.view.istener.capturing noScrollGestureDetector = new android.view.GestureDetector.SimpleOnGestureListener() {

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return true;
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            return false;
        }

    };
    private boolean capturing;
    private final GestureDetector gestureDetector;
    private final WeakReference viewReference;

    public boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
        boolean flag;
        flag = false;
        recyclerview = (ViewGroup)viewReference.get();
        if (recyclerview == null)
        {
            return false;
        }
        if (gestureDetector.onTouchEvent(motionevent) || recyclerview.onInterceptTouchEvent(motionevent))
        {
            flag = true;
        }
        try
        {
            capturing = flag;
        }
        // Misplaced declaration of an exception variable
        catch (RecyclerView recyclerview) { }
        return capturing;
    }

    public void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
        for (recyclerview = (ViewGroup)viewReference.get(); recyclerview == null || !capturing;)
        {
            return;
        }

        recyclerview.onTouchEvent(motionevent);
    }


    _cls1(ViewGroup viewgroup)
    {
        capturing = false;
        viewReference = new WeakReference(viewgroup);
        gestureDetector = new GestureDetector(viewgroup.getContext(), noScrollGestureDetector);
    }
}
