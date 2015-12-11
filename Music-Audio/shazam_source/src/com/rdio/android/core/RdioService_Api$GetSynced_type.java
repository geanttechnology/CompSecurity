// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Playlists $VALUES[];
    public static final Playlists Playlists;
    public static final Playlists TracksAndAlbums;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$GetSynced_type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TracksAndAlbums = new <init>("TracksAndAlbums", 0);
        Playlists = new <init>("Playlists", 1);
        $VALUES = (new .VALUES[] {
            TracksAndAlbums, Playlists
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
