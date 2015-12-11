// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.b.a.a;
import com.shazam.model.player.StreamingPlaylist;
import com.shazam.model.playlist.StreamingPlaylistType;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylist;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylistTracks;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class p
    implements a
{

    private final String a;

    public p(String s)
    {
        a = s;
    }

    private static StreamingPlaylist a(SpotifyPlaylist spotifyplaylist)
    {
        SpotifyPlaylistTracks spotifyplaylisttracks;
        com.shazam.model.player.StreamingPlaylist.Builder builder;
        if (spotifyplaylist.tracks == null)
        {
            spotifyplaylisttracks = SpotifyPlaylistTracks.EMPTY;
        } else
        {
            spotifyplaylisttracks = spotifyplaylist.tracks;
        }
        builder = com.shazam.model.player.StreamingPlaylist.Builder.a();
        builder.key = spotifyplaylist.id;
        builder.name = spotifyplaylist.name;
        builder.numberSongs = spotifyplaylisttracks.total;
        return builder.b();
    }

    public final Object a(Object obj)
    {
        Object obj1 = (List)obj;
        obj = com.shazam.i.e.a.a(0);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            SpotifyPlaylist spotifyplaylist = (SpotifyPlaylist)((Iterator) (obj1)).next();
            if (spotifyplaylist.collaborative)
            {
                arraylist.add(a(spotifyplaylist));
            } else
            {
                arraylist1.add(a(spotifyplaylist));
            }
        }

        ((Map) (obj)).put(StreamingPlaylistType.a(a), arraylist);
        ((Map) (obj)).put(StreamingPlaylistType.NONE, arraylist1);
        return com.shazam.model.playlist.CategorisedStreamingPlaylists.Builder.a().a(((Map) (obj))).b();
    }
}
