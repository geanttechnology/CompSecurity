// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


final class  extends Enum
{

    private static final PLAYED $VALUES[];
    public static final PLAYED LOADED;
    public static final PLAYED LOADING;
    public static final PLAYED PLAYED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/mobileads/AdRequestStatusMapping$LoadingStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOADING = new <init>("LOADING", 0);
        LOADED = new <init>("LOADED", 1);
        PLAYED = new <init>("PLAYED", 2);
        $VALUES = (new .VALUES[] {
            LOADING, LOADED, PLAYED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
