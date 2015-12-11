// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class A extends Enum
{

    private static final Artists $VALUES[];
    public static final Artists Albums;
    public static final Artists Artists;
    public static final Artists Playlists;
    public static final Artists Stations;
    public static final Artists Tracks;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetHeavyRotation_type, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        Albums = new <init>("Albums", 0);
        Stations = new <init>("Stations", 1);
        Playlists = new <init>("Playlists", 2);
        Tracks = new <init>("Tracks", 3);
        Artists = new <init>("Artists", 4);
        $VALUES = (new .VALUES[] {
            Albums, Stations, Playlists, Tracks, Artists
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
