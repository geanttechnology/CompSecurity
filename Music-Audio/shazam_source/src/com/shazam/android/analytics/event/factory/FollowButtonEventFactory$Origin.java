// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            FollowButtonEventFactory

public static final class value extends Enum
{

    private static final SEARCH $VALUES[];
    public static final SEARCH ARTIST;
    public static final SEARCH ARTIST_POST;
    public static final SEARCH FOLLOWING_LIST;
    public static final SEARCH JUST_JOINED;
    public static final SEARCH MODULE;
    public static final SEARCH SEARCH;
    private final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/shazam/android/analytics/event/factory/FollowButtonEventFactory$Origin, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public final String toString()
    {
        return value;
    }

    static 
    {
        MODULE = new <init>("MODULE", 0, "module");
        ARTIST = new <init>("ARTIST", 1, "artist");
        JUST_JOINED = new <init>("JUST_JOINED", 2, "justjoined");
        ARTIST_POST = new <init>("ARTIST_POST", 3, "artistpost");
        FOLLOWING_LIST = new <init>("FOLLOWING_LIST", 4, "followinglist");
        SEARCH = new <init>("SEARCH", 5, "search");
        $VALUES = (new .VALUES[] {
            MODULE, ARTIST, JUST_JOINED, ARTIST_POST, FOLLOWING_LIST, SEARCH
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
