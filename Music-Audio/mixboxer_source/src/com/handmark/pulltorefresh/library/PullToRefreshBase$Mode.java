// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


public final class mIntValue extends Enum
{

    private static final PULL_FROM_END $VALUES[];
    public static final PULL_FROM_END BOTH;
    public static final PULL_FROM_END DISABLED;
    public static final PULL_FROM_END MANUAL_REFRESH_ONLY;
    public static PULL_FROM_END PULL_DOWN_TO_REFRESH;
    public static final PULL_FROM_END PULL_FROM_END;
    public static final PULL_FROM_END PULL_FROM_START;
    public static PULL_FROM_END PULL_UP_TO_REFRESH;
    private int mIntValue;

    static mIntValue getDefault()
    {
        return PULL_FROM_START;
    }

    static PULL_FROM_START mapIntToValue(int i)
    {
        PULL_FROM_START apull_from_start[] = values();
        int k = apull_from_start.length;
        for (int j = 0; j < k; j++)
        {
            PULL_FROM_START pull_from_start = apull_from_start[j];
            if (i == pull_from_start.getIntValue())
            {
                return pull_from_start;
            }
        }

        return getDefault();
    }

    public static getDefault valueOf(String s)
    {
        return (getDefault)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$Mode, s);
    }

    public static getDefault[] values()
    {
        return (getDefault[])$VALUES.clone();
    }

    final int getIntValue()
    {
        return mIntValue;
    }

    final boolean permitsPullToRefresh()
    {
        return this != DISABLED && this != MANUAL_REFRESH_ONLY;
    }

    public final boolean showFooterLoadingLayout()
    {
        return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
    }

    public final boolean showHeaderLoadingLayout()
    {
        return this == PULL_FROM_START || this == BOTH;
    }

    static 
    {
        DISABLED = new <init>("DISABLED", 0, 0);
        PULL_FROM_START = new <init>("PULL_FROM_START", 1, 1);
        PULL_FROM_END = new <init>("PULL_FROM_END", 2, 2);
        BOTH = new <init>("BOTH", 3, 3);
        MANUAL_REFRESH_ONLY = new <init>("MANUAL_REFRESH_ONLY", 4, 4);
        $VALUES = (new .VALUES[] {
            DISABLED, PULL_FROM_START, PULL_FROM_END, BOTH, MANUAL_REFRESH_ONLY
        });
        PULL_DOWN_TO_REFRESH = PULL_FROM_START;
        PULL_UP_TO_REFRESH = PULL_FROM_END;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        mIntValue = j;
    }
}
