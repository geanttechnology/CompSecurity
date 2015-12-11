// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.k;
import com.shazam.android.k.a.a;
import com.shazam.android.k.f;
import com.shazam.f.a.i;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylist;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylistTrack;
import com.shazam.server.response.streaming.spotify.SpotifyTrack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.an.b:
//            n, m

public final class l
    implements n, k
{

    private final f a;
    private final m b;
    private final String c;
    private final SpotifyConnectionState d;
    private com.shazam.android.an.l e;

    public l(f f1, m m1, String s, SpotifyConnectionState spotifyconnectionstate)
    {
        a = f1;
        b = m1;
        c = s;
        d = spotifyconnectionstate;
    }

    public final void a()
    {
        e.f();
    }

    public final void a(com.shazam.android.an.l l1)
    {
        e = l1;
        Iterator iterator = ((List)a.a()).iterator();
_L2:
        SpotifyPlaylist spotifyplaylist;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_88;
            }
            spotifyplaylist = (SpotifyPlaylist)iterator.next();
        } while (spotifyplaylist == null);
        if (!c.equals(spotifyplaylist.name)) goto _L2; else goto _L1
_L1:
        d.b(spotifyplaylist.id);
        b.a(this, spotifyplaylist.id);
        return;
        try
        {
            l1.e();
            return;
        }
        catch (a a1) { }
        catch (i j) { }
        l1.f();
        return;
    }

    public final void a(List list)
    {
        HashSet hashset = new HashSet();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (SpotifyPlaylistTrack)iterator.next();
            if (((SpotifyPlaylistTrack) (list)).track == null)
            {
                list = SpotifyTrack.EMPTY;
            } else
            {
                list = ((SpotifyPlaylistTrack) (list)).track;
            }
            hashset.add(((SpotifyTrack) (list)).uri);
        }
        e.a(hashset);
    }
}
