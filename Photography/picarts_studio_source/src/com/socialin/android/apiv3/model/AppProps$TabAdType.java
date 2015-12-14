// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


public final class _cls9 extends Enum
{

    private static final NOTIFICATIONS $VALUES[];
    public static final NOTIFICATIONS ARTISTS;
    public static final NOTIFICATIONS EXPLORE;
    public static final NOTIFICATIONS NETWORK;
    public static final NOTIFICATIONS NOTIFICATIONS;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/socialin/android/apiv3/model/AppProps$TabAdType, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        NETWORK = new <init>("NETWORK", 0);
        EXPLORE = new <init>("EXPLORE", 1);
        ARTISTS = new <init>("ARTISTS", 2);
        NOTIFICATIONS = new <init>("NOTIFICATIONS", 3);
        $VALUES = (new .VALUES[] {
            NETWORK, EXPLORE, ARTISTS, NOTIFICATIONS
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
