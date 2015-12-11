// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mftd;


public final class MftdMessageType extends Enum
{

    private static final MftdMessageType $VALUES[];
    public static final MftdMessageType alert;
    public static final MftdMessageType announcement;
    public static final MftdMessageType info;
    public static final MftdMessageType undefined;

    private MftdMessageType(String s, int i)
    {
        super(s, i);
    }

    public static MftdMessageType valueOf(String s)
    {
        return (MftdMessageType)Enum.valueOf(com/ebay/common/model/mftd/MftdMessageType, s);
    }

    public static MftdMessageType[] values()
    {
        return (MftdMessageType[])$VALUES.clone();
    }

    static 
    {
        undefined = new MftdMessageType("undefined", 0);
        alert = new MftdMessageType("alert", 1);
        announcement = new MftdMessageType("announcement", 2);
        info = new MftdMessageType("info", 3);
        $VALUES = (new MftdMessageType[] {
            undefined, alert, announcement, info
        });
    }
}
