// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public final class  extends Enum
{

    public static final UNKNOWN INTERNAL_ERROR;
    public static final UNKNOWN NETWORK_ERROR;
    public static final UNKNOWN UNKNOWN;
    private static final UNKNOWN a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/youtube/player/YouTubeThumbnailLoader$ErrorReason, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 0);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        a = (new a[] {
            NETWORK_ERROR, INTERNAL_ERROR, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
