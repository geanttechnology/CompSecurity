// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;


public final class  extends Enum
{

    private static final EXPORT $VALUES[];
    public static final EXPORT DRAW;
    public static final EXPORT EXPORT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/ads/SocialinAdManager$PicsArtInterstitialType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAW = new <init>("DRAW", 0);
        EXPORT = new <init>("EXPORT", 1);
        $VALUES = (new .VALUES[] {
            DRAW, EXPORT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
