// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


final class  extends Enum
{

    private static final AD $VALUES[];
    public static final AD AD;
    public static final AD EMPTY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/nativeads/NativeAdViewHelper$ViewType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EMPTY = new <init>("EMPTY", 0);
        AD = new <init>("AD", 1);
        $VALUES = (new .VALUES[] {
            EMPTY, AD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
