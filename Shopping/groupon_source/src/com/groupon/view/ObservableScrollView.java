// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObservableScrollView extends ScrollView
{
    public static interface OnLayoutUpdatedListener
    {

        public abstract void onLayoutUpdated(boolean flag, int i, int j, int k, int l);
    }

    public static interface OnScrollChangedListener
    {

        public abstract void onScrollChanged(ObservableScrollView observablescrollview, int i, int j, int k, int l);
    }


    private float lastX;
    private float lastY;
    private OnLayoutUpdatedListener onLayoutUpdatedListener;
    private List onScrollChangedListeners;
    private boolean scrolledToBottom;
    private float xDistance;
    private float yDistance;

    public ObservableScrollView(Context context)
    {
        this(context, null, 0);
    }

    public ObservableScrollView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ObservableScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        onLayoutUpdatedListener = null;
        onScrollChangedListeners = new ArrayList();
    }

    public void addOnScrollChangedListener(OnScrollChangedListener onscrollchangedlistener)
    {
        onScrollChangedListeners.add(onscrollchangedlistener);
    }

    public OnLayoutUpdatedListener getOnLayoutUpdatedListener()
    {
        return onLayoutUpdatedListener;
    }

    public boolean isScrolledToBottom()
    {
        return scrolledToBottom;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 32
    //                   2 67;
           goto _L1 _L2 _L1 _L3
_L1:
        return super.onInterceptTouchEvent(motionevent);
_L2:
        yDistance = 0.0F;
        xDistance = 0.0F;
        lastX = motionevent.getX();
        lastY = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L3:
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        xDistance = xDistance + Math.abs(f - lastX);
        yDistance = yDistance + Math.abs(f1 - lastY);
        lastX = f;
        lastY = f1;
        if (xDistance > yDistance)
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (onLayoutUpdatedListener != null)
        {
            onLayoutUpdatedListener.onLayoutUpdated(flag, i, j, k, l);
        }
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        for (Iterator iterator = onScrollChangedListeners.iterator(); iterator.hasNext(); ((OnScrollChangedListener)iterator.next()).onScrollChanged(this, i, j, k, l)) { }
    }

    public void setOnLayoutUpdatedListener(OnLayoutUpdatedListener onlayoutupdatedlistener)
    {
        onLayoutUpdatedListener = onlayoutupdatedlistener;
    }

    public void setScrolledToBottom(boolean flag)
    {
        scrolledToBottom = flag;
    }
}
