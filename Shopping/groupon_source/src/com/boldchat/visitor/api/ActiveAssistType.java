// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


public final class ActiveAssistType extends Enum
{

    private static final ActiveAssistType $VALUES[];
    public static final ActiveAssistType Cobrowse;
    public static final ActiveAssistType Screenshare;
    public static final ActiveAssistType Unknown;

    private ActiveAssistType(String s, int i)
    {
        super(s, i);
    }

    public static ActiveAssistType getActiveAssistType(String s)
    {
        ActiveAssistType aactiveassisttype[] = values();
        int j = aactiveassisttype.length;
        for (int i = 0; i < j; i++)
        {
            ActiveAssistType activeassisttype = aactiveassisttype[i];
            if (s.equals(activeassisttype.name().toLowerCase()))
            {
                return activeassisttype;
            }
        }

        return Unknown;
    }

    public static ActiveAssistType valueOf(String s)
    {
        return (ActiveAssistType)Enum.valueOf(com/boldchat/visitor/api/ActiveAssistType, s);
    }

    public static ActiveAssistType[] values()
    {
        return (ActiveAssistType[])$VALUES.clone();
    }

    static 
    {
        Screenshare = new ActiveAssistType("Screenshare", 0);
        Cobrowse = new ActiveAssistType("Cobrowse", 1);
        Unknown = new ActiveAssistType("Unknown", 2);
        $VALUES = (new ActiveAssistType[] {
            Screenshare, Cobrowse, Unknown
        });
    }
}
