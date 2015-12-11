// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.b;

import com.shazam.android.k.f.r;
import com.shazam.model.configuration.RdioConfiguration;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.details.AddAction;
import com.shazam.model.details.AddToListActionInfo;
import com.shazam.model.details.AddToListActions;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.spotify.SpotifyConnectionState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a
    implements AddToListActions
{

    private final r a;
    private final RdioConfiguration b;
    private final RdioConnectionState c;
    private final SpotifyConfiguration d;
    private final SpotifyConnectionState e;

    public a(RdioConfiguration rdioconfiguration, RdioConnectionState rdioconnectionstate, SpotifyConfiguration spotifyconfiguration, SpotifyConnectionState spotifyconnectionstate, r r1)
    {
        b = rdioconfiguration;
        c = rdioconnectionstate;
        d = spotifyconfiguration;
        e = spotifyconnectionstate;
        a = r1;
    }

    public final Collection a(AddToListActionInfo addtolistactioninfo)
    {
        ArrayList arraylist = new ArrayList(AddAction.values().length);
        com.shazam.android.k.f.b.a a1 = a.b;
        if (!a1.q || a1.equals(com.shazam.android.k.f.b.a.j))
        {
            arraylist.add(AddAction.ADD_TO_MY_TAGS);
        }
        if (b.a() && com.shazam.b.e.a.c(addtolistactioninfo.a(PlaybackProvider.RDIO)) && !e.a())
        {
            arraylist.add(AddAction.ADD_TO_RDIO_PLAYLIST);
        }
        if (d.a() && com.shazam.b.e.a.c(addtolistactioninfo.a(PlaybackProvider.SPOTIFY)) && !c.a())
        {
            arraylist.add(AddAction.ADD_TO_SPOTIFY_PLAYLIST);
        }
        return arraylist;
    }
}
