// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia;


public final class  extends Enum
{

    public static final DESC ASC;
    public static final DESC DESC;
    private static final DESC a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/baidu/frontia/FrontiaQuery$SortOrder, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        ASC = new <init>("ASC", 0);
        DESC = new <init>("DESC", 1);
        a = (new a[] {
            ASC, DESC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
