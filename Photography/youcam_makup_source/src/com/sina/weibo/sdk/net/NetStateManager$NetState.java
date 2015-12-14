// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;


public final class  extends Enum
{

    private static final NOWAY ENUM$VALUES[];
    public static final NOWAY Mobile;
    public static final NOWAY NOWAY;
    public static final NOWAY WIFI;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sina/weibo/sdk/net/NetStateManager$NetState, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        Mobile = new <init>("Mobile", 0);
        WIFI = new <init>("WIFI", 1);
        NOWAY = new <init>("NOWAY", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            Mobile, WIFI, NOWAY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
