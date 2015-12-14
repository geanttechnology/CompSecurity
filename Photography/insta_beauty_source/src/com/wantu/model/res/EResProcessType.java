// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;


public final class EResProcessType extends Enum
{

    private static final EResProcessType $VALUES[];
    public static final EResProcessType ORIGIN;
    public static final EResProcessType OTHER;

    private EResProcessType(String s, int i)
    {
        super(s, i);
    }

    public static EResProcessType valueOf(String s)
    {
        return (EResProcessType)Enum.valueOf(com/wantu/model/res/EResProcessType, s);
    }

    public static EResProcessType[] values()
    {
        return (EResProcessType[])$VALUES.clone();
    }

    static 
    {
        ORIGIN = new EResProcessType("ORIGIN", 0);
        OTHER = new EResProcessType("OTHER", 1);
        $VALUES = (new EResProcessType[] {
            ORIGIN, OTHER
        });
    }
}
