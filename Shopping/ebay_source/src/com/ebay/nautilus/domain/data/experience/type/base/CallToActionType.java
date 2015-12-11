// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;


public final class CallToActionType extends Enum
{

    private static final CallToActionType $VALUES[];
    public static final CallToActionType DEFAULT;
    public static final CallToActionType PRIMARY;
    public static final CallToActionType SECONDARY;
    public static final CallToActionType UNKNOWN;

    private CallToActionType(String s, int i)
    {
        super(s, i);
    }

    public static CallToActionType valueOf(String s)
    {
        return (CallToActionType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/type/base/CallToActionType, s);
    }

    public static CallToActionType[] values()
    {
        return (CallToActionType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new CallToActionType("UNKNOWN", 0);
        DEFAULT = new CallToActionType("DEFAULT", 1);
        PRIMARY = new CallToActionType("PRIMARY", 2);
        SECONDARY = new CallToActionType("SECONDARY", 3);
        $VALUES = (new CallToActionType[] {
            UNKNOWN, DEFAULT, PRIMARY, SECONDARY
        });
    }
}
