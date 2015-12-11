// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


public final class UnavailableReason extends Enum
{

    private static final UnavailableReason $VALUES[];
    public static final UnavailableReason NoOperators;
    public static final UnavailableReason OutsideHours;
    public static final UnavailableReason QueueFull;
    public static final UnavailableReason Unknown;
    public static final UnavailableReason Unsecure;
    public static final UnavailableReason VisitorBlocked;

    private UnavailableReason(String s, int i)
    {
        super(s, i);
    }

    public static UnavailableReason getUnavailableReason(String s)
    {
        s = s.replace("_", "");
        UnavailableReason aunavailablereason[] = values();
        int j = aunavailablereason.length;
        for (int i = 0; i < j; i++)
        {
            UnavailableReason unavailablereason = aunavailablereason[i];
            if (s.equals(unavailablereason.name().toLowerCase()))
            {
                return unavailablereason;
            }
        }

        return Unknown;
    }

    public static UnavailableReason valueOf(String s)
    {
        return (UnavailableReason)Enum.valueOf(com/boldchat/visitor/api/UnavailableReason, s);
    }

    public static UnavailableReason[] values()
    {
        return (UnavailableReason[])$VALUES.clone();
    }

    static 
    {
        QueueFull = new UnavailableReason("QueueFull", 0);
        NoOperators = new UnavailableReason("NoOperators", 1);
        VisitorBlocked = new UnavailableReason("VisitorBlocked", 2);
        OutsideHours = new UnavailableReason("OutsideHours", 3);
        Unknown = new UnavailableReason("Unknown", 4);
        Unsecure = new UnavailableReason("Unsecure", 5);
        $VALUES = (new UnavailableReason[] {
            QueueFull, NoOperators, VisitorBlocked, OutsideHours, Unknown, Unsecure
        });
    }
}
