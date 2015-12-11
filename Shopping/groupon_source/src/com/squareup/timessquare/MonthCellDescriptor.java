// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import java.util.Date;

class MonthCellDescriptor
{
    public static final class RangeState extends Enum
    {

        private static final RangeState $VALUES[];
        public static final RangeState FIRST;
        public static final RangeState LAST;
        public static final RangeState MIDDLE;
        public static final RangeState NONE;

        public static RangeState valueOf(String s)
        {
            return (RangeState)Enum.valueOf(com/squareup/timessquare/MonthCellDescriptor$RangeState, s);
        }

        public static RangeState[] values()
        {
            return (RangeState[])$VALUES.clone();
        }

        static 
        {
            NONE = new RangeState("NONE", 0);
            FIRST = new RangeState("FIRST", 1);
            MIDDLE = new RangeState("MIDDLE", 2);
            LAST = new RangeState("LAST", 3);
            $VALUES = (new RangeState[] {
                NONE, FIRST, MIDDLE, LAST
            });
        }

        private RangeState(String s, int i)
        {
            super(s, i);
        }
    }


    private final Date date;
    private final boolean isCurrentMonth;
    private boolean isHighlighted;
    private final boolean isSelectable;
    private boolean isSelected;
    private final boolean isToday;
    private RangeState rangeState;
    private final int value;

    MonthCellDescriptor(Date date1, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, int i, 
            RangeState rangestate)
    {
        date = date1;
        isCurrentMonth = flag;
        isSelectable = flag1;
        isHighlighted = flag4;
        isSelected = flag2;
        isToday = flag3;
        value = i;
        rangeState = rangestate;
    }

    public Date getDate()
    {
        return date;
    }

    public RangeState getRangeState()
    {
        return rangeState;
    }

    public int getValue()
    {
        return value;
    }

    public boolean isCurrentMonth()
    {
        return isCurrentMonth;
    }

    boolean isHighlighted()
    {
        return isHighlighted;
    }

    public boolean isSelectable()
    {
        return isSelectable;
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    public boolean isToday()
    {
        return isToday;
    }

    void setHighlighted(boolean flag)
    {
        isHighlighted = flag;
    }

    public void setRangeState(RangeState rangestate)
    {
        rangeState = rangestate;
    }

    public void setSelected(boolean flag)
    {
        isSelected = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append("MonthCellDescriptor{date=").append(date).append(", value=").append(value).append(", isCurrentMonth=").append(isCurrentMonth).append(", isSelected=").append(isSelected).append(", isToday=").append(isToday).append(", isSelectable=").append(isSelectable).append(", isHighlighted=").append(isHighlighted).append(", rangeState=").append(rangeState).append('}').toString();
    }
}
