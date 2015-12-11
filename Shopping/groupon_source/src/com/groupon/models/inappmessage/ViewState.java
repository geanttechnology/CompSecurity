// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.inappmessage;


public final class ViewState extends Enum
{

    private static final ViewState $VALUES[];
    public static final ViewState CLOSED;
    public static final ViewState FAILED_VIEWED;
    public static final ViewState START;
    public static final ViewState VIEWED;

    private ViewState(String s, int i)
    {
        super(s, i);
    }

    public static ViewState valueOf(String s)
    {
        return (ViewState)Enum.valueOf(com/groupon/models/inappmessage/ViewState, s);
    }

    public static ViewState[] values()
    {
        return (ViewState[])$VALUES.clone();
    }

    static 
    {
        START = new ViewState("START", 0);
        VIEWED = new ViewState("VIEWED", 1);
        FAILED_VIEWED = new ViewState("FAILED_VIEWED", 2);
        CLOSED = new ViewState("CLOSED", 3);
        $VALUES = (new ViewState[] {
            START, VIEWED, FAILED_VIEWED, CLOSED
        });
    }
}
