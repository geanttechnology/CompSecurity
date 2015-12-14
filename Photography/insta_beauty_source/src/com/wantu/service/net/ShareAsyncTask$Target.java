// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.net;


public final class  extends Enum
{

    private static final tencent $VALUES[];
    public static final tencent renren;
    public static final tencent sina;
    public static final tencent tencent;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/service/net/ShareAsyncTask$Target, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        sina = new <init>("sina", 0);
        renren = new <init>("renren", 1);
        tencent = new <init>("tencent", 2);
        $VALUES = (new .VALUES[] {
            sina, renren, tencent
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
