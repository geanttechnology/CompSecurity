// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class CalendarCellView extends TextView
{

    private static final int STATE_CURRENT_MONTH[];
    private static final int STATE_HIGHLIGHTED[];
    private static final int STATE_RANGE_FIRST[];
    private static final int STATE_RANGE_LAST[];
    private static final int STATE_RANGE_MIDDLE[];
    private static final int STATE_SELECTABLE[];
    private static final int STATE_TODAY[];
    private boolean isCurrentMonth;
    private boolean isHighlighted;
    private boolean isSelectable;
    private boolean isToday;
    private MonthCellDescriptor.RangeState rangeState;

    public CalendarCellView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isSelectable = false;
        isCurrentMonth = false;
        isToday = false;
        isHighlighted = false;
        rangeState = MonthCellDescriptor.RangeState.NONE;
    }

    public boolean isCurrentMonth()
    {
        return isCurrentMonth;
    }

    protected int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 5);
        if (isSelectable)
        {
            mergeDrawableStates(ai, STATE_SELECTABLE);
        }
        if (isCurrentMonth)
        {
            mergeDrawableStates(ai, STATE_CURRENT_MONTH);
        }
        if (isToday)
        {
            mergeDrawableStates(ai, STATE_TODAY);
        }
        if (isHighlighted)
        {
            mergeDrawableStates(ai, STATE_HIGHLIGHTED);
        }
        if (rangeState == MonthCellDescriptor.RangeState.FIRST)
        {
            mergeDrawableStates(ai, STATE_RANGE_FIRST);
        } else
        {
            if (rangeState == MonthCellDescriptor.RangeState.MIDDLE)
            {
                mergeDrawableStates(ai, STATE_RANGE_MIDDLE);
                return ai;
            }
            if (rangeState == MonthCellDescriptor.RangeState.LAST)
            {
                mergeDrawableStates(ai, STATE_RANGE_LAST);
                return ai;
            }
        }
        return ai;
    }

    public void setCurrentMonth(boolean flag)
    {
        isCurrentMonth = flag;
        refreshDrawableState();
    }

    public void setHighlighted(boolean flag)
    {
        isHighlighted = flag;
        refreshDrawableState();
    }

    public void setRangeState(MonthCellDescriptor.RangeState rangestate)
    {
        rangeState = rangestate;
        refreshDrawableState();
    }

    public void setSelectable(boolean flag)
    {
        isSelectable = flag;
        refreshDrawableState();
    }

    public void setToday(boolean flag)
    {
        isToday = flag;
        refreshDrawableState();
    }

    static 
    {
        STATE_SELECTABLE = (new int[] {
            R.attr.state_selectable
        });
        STATE_CURRENT_MONTH = (new int[] {
            R.attr.state_current_month
        });
        STATE_TODAY = (new int[] {
            R.attr.state_today
        });
        STATE_HIGHLIGHTED = (new int[] {
            R.attr.state_highlighted
        });
        STATE_RANGE_FIRST = (new int[] {
            R.attr.state_range_first
        });
        STATE_RANGE_MIDDLE = (new int[] {
            R.attr.state_range_middle
        });
        STATE_RANGE_LAST = (new int[] {
            R.attr.state_range_last
        });
    }
}
