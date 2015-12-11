// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.b.a.d;
import com.shazam.b.c.a;
import com.shazam.h.k;
import com.shazam.h.l;
import com.shazam.j.b;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylist;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylistTracksPager;
import com.shazam.server.response.streaming.spotify.SpotifyUser;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

// Referenced classes of package com.shazam.android.an.b:
//            h, ae

public final class i
    implements h
{

    private final com.shazam.h.i a;
    private final SpotifyConnectionState b;
    private final SpotifyConfiguration c;
    private final b d;
    private final ae e;

    public i(com.shazam.h.i j, SpotifyConnectionState spotifyconnectionstate, SpotifyConfiguration spotifyconfiguration, b b1, ae ae1)
    {
        a = j;
        b = spotifyconnectionstate;
        c = spotifyconfiguration;
        d = b1;
        e = ae1;
    }

    private Object a(l l, Class class1)
    {
        return a.a(l, class1);
    }

    private com.shazam.h.l.a b()
    {
        e.a();
        return (new com.shazam.h.l.a()).a(b.e());
    }

    public final SpotifyPlaylist a(String s)
    {
        s = com.shazam.server.request.streaming.spotify.SpotifyPlaylistName.Builder.spotifyPlaylistName().withName(s).build();
        com.shazam.h.l.a a1 = b();
        a1.e = k.b;
        a1.a = com.shazam.b.c.a.a(c.a(b.d()));
        com.shazam.h.a.b.a a2 = com.shazam.h.a.b.a.a(d);
        a2.b = s;
        return (SpotifyPlaylist)a(a1.b(a2.a()).a(), com/shazam/server/response/streaming/spotify/SpotifyPlaylist);
    }

    public final SpotifyUser a()
    {
        com.shazam.h.l.a a1 = b();
        a1.e = k.a;
        a1.a = com.shazam.b.c.a.a(c.c());
        return (SpotifyUser)a(a1.a(), com/shazam/server/response/streaming/spotify/SpotifyUser);
    }

    public final void a(String s, List list)
    {
        com.shazam.b.a.d.a(list);
        Object obj;
        if (list instanceof RandomAccess)
        {
            list = new com.shazam.b.b.f.b(list);
        } else
        {
            list = new com.shazam.b.b.f.a(list);
        }
        for (list = list.iterator(); list.hasNext(); a.a(((l) (obj)), java/lang/Void))
        {
            obj = (List)list.next();
            obj = com.shazam.server.request.streaming.spotify.SpotifyPlaylistUris.Builder.spotifyPlaylistUris().withUris(((List) (obj))).build();
            com.shazam.h.l.a a1 = b();
            a1.e = k.b;
            a1.a = com.shazam.b.c.a.a(c.a(b.d(), s));
            com.shazam.h.a.b.a a2 = com.shazam.h.a.b.a.a(d);
            a2.b = obj;
            obj = a1.b(a2.a()).a();
            e.a();
        }

    }

    public final SpotifyPlaylistTracksPager b(String s)
    {
        com.shazam.h.l.a a1 = b();
        a1.e = k.a;
        a1.a = com.shazam.b.c.a.a(s);
        return (SpotifyPlaylistTracksPager)a(a1.a(), com/shazam/server/response/streaming/spotify/SpotifyPlaylistTracksPager);
    }
}
