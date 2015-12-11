// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


public final class mIntValue extends Enum
{

    private static final OVERSCROLLING $VALUES[];
    public static final OVERSCROLLING MANUAL_REFRESHING;
    public static final OVERSCROLLING OVERSCROLLING;
    public static final OVERSCROLLING PULL_TO_REFRESH;
    public static final OVERSCROLLING REFRESHING;
    public static final OVERSCROLLING RELEASE_TO_REFRESH;
    public static final OVERSCROLLING RESET;
    private int mIntValue;

    static mIntValue mapIntToValue(int i)
    {
        mIntValue amintvalue[] = values();
        int k = amintvalue.length;
        for (int j = 0; j < k; j++)
        {
            mIntValue mintvalue = amintvalue[j];
            if (i == mintvalue.getIntValue())
            {
                return mintvalue;
            }
        }

        return RESET;
    }

    public static RESET valueOf(String s)
    {
        return (RESET)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$State, s);
    }

    public static RESET[] values()
    {
        return (RESET[])$VALUES.clone();
    }

    final int getIntValue()
    {
        return mIntValue;
    }

    static 
    {
        RESET = new <init>("RESET", 0, 0);
        PULL_TO_REFRESH = new <init>("PULL_TO_REFRESH", 1, 1);
        RELEASE_TO_REFRESH = new <init>("RELEASE_TO_REFRESH", 2, 2);
        REFRESHING = new <init>("REFRESHING", 3, 8);
        MANUAL_REFRESHING = new <init>("MANUAL_REFRESHING", 4, 9);
        OVERSCROLLING = new <init>("OVERSCROLLING", 5, 16);
        $VALUES = (new .VALUES[] {
            RESET, PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING, MANUAL_REFRESHING, OVERSCROLLING
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        mIntValue = j;
    }
}
