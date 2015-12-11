// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


public final class EndedReason extends Enum
{

    private static final EndedReason $VALUES[];
    public static final EndedReason Disconnected;
    public static final EndedReason Operator;
    public static final EndedReason Unknown;
    public static final EndedReason Visitor;

    private EndedReason(String s, int i)
    {
        super(s, i);
    }

    public static EndedReason getEndedReason(String s)
    {
        EndedReason aendedreason[] = values();
        int j = aendedreason.length;
        for (int i = 0; i < j; i++)
        {
            EndedReason endedreason = aendedreason[i];
            if (s.equals(endedreason.name().toLowerCase()))
            {
                return endedreason;
            }
        }

        return Unknown;
    }

    public static EndedReason valueOf(String s)
    {
        return (EndedReason)Enum.valueOf(com/boldchat/visitor/api/EndedReason, s);
    }

    public static EndedReason[] values()
    {
        return (EndedReason[])$VALUES.clone();
    }

    static 
    {
        Unknown = new EndedReason("Unknown", 0);
        Operator = new EndedReason("Operator", 1);
        Visitor = new EndedReason("Visitor", 2);
        Disconnected = new EndedReason("Disconnected", 3);
        $VALUES = (new EndedReason[] {
            Unknown, Operator, Visitor, Disconnected
        });
    }
}
