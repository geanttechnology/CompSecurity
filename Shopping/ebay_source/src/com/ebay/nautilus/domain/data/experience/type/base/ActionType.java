// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;


public final class ActionType extends Enum
{

    private static final ActionType $VALUES[];
    public static final ActionType NAV;
    public static final ActionType OPERATION;
    public static final ActionType UNKNOWN;
    public static final ActionType WEBVIEW;

    private ActionType(String s, int i)
    {
        super(s, i);
    }

    public static ActionType valueOf(String s)
    {
        return (ActionType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/type/base/ActionType, s);
    }

    public static ActionType[] values()
    {
        return (ActionType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new ActionType("UNKNOWN", 0);
        NAV = new ActionType("NAV", 1);
        OPERATION = new ActionType("OPERATION", 2);
        WEBVIEW = new ActionType("WEBVIEW", 3);
        $VALUES = (new ActionType[] {
            UNKNOWN, NAV, OPERATION, WEBVIEW
        });
    }
}
