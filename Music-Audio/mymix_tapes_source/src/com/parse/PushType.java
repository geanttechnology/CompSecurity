// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


final class PushType extends Enum
{

    private static final PushType $VALUES[];
    public static final PushType GCM;
    public static final PushType NONE;
    public static final PushType PPNS;
    private final String pushType;

    private PushType(String s, int i, String s1)
    {
        super(s, i);
        pushType = s1;
    }

    static PushType fromString(String s)
    {
        if ("none".equals(s))
        {
            return NONE;
        }
        if ("ppns".equals(s))
        {
            return PPNS;
        }
        if ("gcm".equals(s))
        {
            return GCM;
        } else
        {
            return null;
        }
    }

    public static PushType valueOf(String s)
    {
        return (PushType)Enum.valueOf(com/parse/PushType, s);
    }

    public static PushType[] values()
    {
        return (PushType[])$VALUES.clone();
    }

    public String toString()
    {
        return pushType;
    }

    static 
    {
        NONE = new PushType("NONE", 0, "none");
        PPNS = new PushType("PPNS", 1, "ppns");
        GCM = new PushType("GCM", 2, "gcm");
        $VALUES = (new PushType[] {
            NONE, PPNS, GCM
        });
    }
}
