// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.material;


public final class I extends Enum
{

    private static final COMPOSE_43 $VALUES[];
    public static final COMPOSE_43 COMPOSE_11;
    public static final COMPOSE_43 COMPOSE_43;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/wantu/service/material/TComposeFreeStyleManager$FreeComposeType, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        COMPOSE_11 = new <init>("COMPOSE_11", 0);
        COMPOSE_43 = new <init>("COMPOSE_43", 1);
        $VALUES = (new .VALUES[] {
            COMPOSE_11, COMPOSE_43
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
