// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.mobile.android.spotlets.findfriends;


public final class  extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/spotify/mobile/android/spotlets/findfriends/FindFriendsViewManager$State, s);
    }

    public static [] values()
    {
        return ([])g.clone();
    }

    static 
    {
        a = new <init>("LOADING", 0);
        b = new <init>("EMPTY", 1);
        c = new <init>("ERROR", 2);
        d = new <init>("OFFLINE", 3);
        e = new <init>("DISPLAY_SOURCES_CONNECTED", 4);
        f = new <init>("DISPLAY_NO_SOURCES_CONNECTED", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
