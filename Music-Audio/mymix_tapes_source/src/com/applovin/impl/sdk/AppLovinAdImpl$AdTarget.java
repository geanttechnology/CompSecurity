// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;


public final class  extends Enum
{

    public static final ACTIVITY_LANDSCAPE ACTIVITY_LANDSCAPE;
    public static final ACTIVITY_LANDSCAPE ACTIVITY_PORTRAIT;
    public static final ACTIVITY_LANDSCAPE DEFAULT;
    private static final ACTIVITY_LANDSCAPE a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/applovin/impl/sdk/AppLovinAdImpl$AdTarget, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        ACTIVITY_PORTRAIT = new <init>("ACTIVITY_PORTRAIT", 1);
        ACTIVITY_LANDSCAPE = new <init>("ACTIVITY_LANDSCAPE", 2);
        a = (new a[] {
            DEFAULT, ACTIVITY_PORTRAIT, ACTIVITY_LANDSCAPE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
