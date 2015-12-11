// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.streaming.spotify;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.server.request.streaming.spotify:
//            SpotifyPlaylistUris

public static class 
{

    private final List uris = new ArrayList();

    public static  spotifyPlaylistUris()
    {
        return new <init>();
    }

    public SpotifyPlaylistUris build()
    {
        return new SpotifyPlaylistUris(this, null);
    }

    public <init> withUris(List list)
    {
        uris.clear();
        uris.addAll(list);
        return this;
    }


    public ()
    {
    }
}
