// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final TracksAndAlbums $VALUES[];
    public static final TracksAndAlbums Artists;
    public static final TracksAndAlbums Labels;
    public static final TracksAndAlbums Playlists;
    public static final TracksAndAlbums Stations;
    public static final TracksAndAlbums TracksAndAlbums;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$GetFavorites_types, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Artists = new <init>("Artists", 0);
        Labels = new <init>("Labels", 1);
        Playlists = new <init>("Playlists", 2);
        Stations = new <init>("Stations", 3);
        TracksAndAlbums = new <init>("TracksAndAlbums", 4);
        $VALUES = (new .VALUES[] {
            Artists, Labels, Playlists, Stations, TracksAndAlbums
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
