// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class FixedPositionListView extends ListView
    implements android.widget.AbsListView.OnScrollListener
{
    public static interface OnPositionChangedListener
    {

        public abstract void onStartScroll();

        public abstract void onStopScroll(int i);
    }


    private int currentPosition;
    private int listOffset;
    private OnPositionChangedListener onPositionChangedListener;
    private boolean scrolling;

    public FixedPositionListView(Context context)
    {
        this(context, null);
    }

    public FixedPositionListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FixedPositionListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        listOffset = 1;
        setOnScrollListener(this);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(final AbsListView view, final int visiblePosition)
    {
        boolean flag = true;
        switch (visiblePosition)
        {
        default:
            return;

        case 0: // '\0'
            if (scrolling)
            {
                View view1 = view.getChildAt(0);
                if (Math.abs(view1.getTop()) > Math.abs(view1.getBottom()))
                {
                    visiblePosition = ((flag) ? 1 : 0);
                } else
                {
                    visiblePosition = 0;
                }
                if (visiblePosition != 0)
                {
                    visiblePosition = view.getFirstVisiblePosition() + listOffset;
                } else
                {
                    visiblePosition = view.getFirstVisiblePosition();
                }
                view.post(new Runnable() {

                    final FixedPositionListView this$0;
                    final int val$selectedPosition;
                    final AbsListView val$view;
                    final int val$visiblePosition;

                    public void run()
                    {
                        view.smoothScrollToPositionFromTop(visiblePosition, 0);
                        if (onPositionChangedListener != null)
                        {
                            onPositionChangedListener.onStopScroll(selectedPosition);
                        }
                        currentPosition = selectedPosition;
                    }

            
            {
                this$0 = FixedPositionListView.this;
                view = abslistview;
                visiblePosition = i;
                selectedPosition = j;
                super();
            }
                });
            }
            scrolling = false;
            return;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        if (onPositionChangedListener != null)
        {
            onPositionChangedListener.onStartScroll();
        }
        scrolling = true;
    }

    public void setListOffset(int i)
    {
        listOffset = i;
    }

    public void setOnPositionChangedListener(OnPositionChangedListener onpositionchangedlistener)
    {
        onPositionChangedListener = onpositionchangedlistener;
    }

    public void setSelectionAndScrollToPosition(int i)
    {
        smoothScrollToPosition(Math.abs(currentPosition - i));
        setSelection(i);
    }

    public void setSelectionFromTop(int i, int j)
    {
        super.setSelectionFromTop(i - listOffset, j);
        currentPosition = i;
        if (onPositionChangedListener != null)
        {
            onPositionChangedListener.onStopScroll(currentPosition);
        }
    }



/*
    static int access$102(FixedPositionListView fixedpositionlistview, int i)
    {
        fixedpositionlistview.currentPosition = i;
        return i;
    }

*/
}
