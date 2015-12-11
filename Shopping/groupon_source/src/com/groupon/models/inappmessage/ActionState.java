// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.inappmessage;


public final class ActionState extends Enum
{

    private static final ActionState $VALUES[];
    public static final ActionState CLICKED;
    public static final ActionState CLOSED;
    public static final ActionState DISMISSED;
    public static final ActionState FAILED_CLICKED;
    public static final ActionState FAILED_DISMISSED;
    public static final ActionState START;

    private ActionState(String s, int i)
    {
        super(s, i);
    }

    public static ActionState valueOf(String s)
    {
        return (ActionState)Enum.valueOf(com/groupon/models/inappmessage/ActionState, s);
    }

    public static ActionState[] values()
    {
        return (ActionState[])$VALUES.clone();
    }

    static 
    {
        START = new ActionState("START", 0);
        CLICKED = new ActionState("CLICKED", 1);
        DISMISSED = new ActionState("DISMISSED", 2);
        FAILED_CLICKED = new ActionState("FAILED_CLICKED", 3);
        FAILED_DISMISSED = new ActionState("FAILED_DISMISSED", 4);
        CLOSED = new ActionState("CLOSED", 5);
        $VALUES = (new ActionState[] {
            START, CLICKED, DISMISSED, FAILED_CLICKED, FAILED_DISMISSED, CLOSED
        });
    }
}
