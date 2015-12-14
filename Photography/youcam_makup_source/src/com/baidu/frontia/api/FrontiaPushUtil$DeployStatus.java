// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia.api;


public final class  extends Enum
{

    public static final PRODUCTION DEVELOPE;
    public static final PRODUCTION PRODUCTION;
    private static final PRODUCTION a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/baidu/frontia/api/FrontiaPushUtil$DeployStatus, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        DEVELOPE = new <init>("DEVELOPE", 0);
        PRODUCTION = new <init>("PRODUCTION", 1);
        a = (new a[] {
            DEVELOPE, PRODUCTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
