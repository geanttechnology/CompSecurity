// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.android.an.k;
import com.shazam.android.an.l;
import com.shazam.b.e.a;
import com.shazam.model.rdio.RdioCallback;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.rdio.RdioPlaylistInfo;
import com.shazam.server.response.streaming.rdio.RdioPlaylist;
import com.shazam.server.response.streaming.rdio.RdioUserPlaylists;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.an.a:
//            o

public final class h
    implements k, RdioCallback
{

    private final o a;
    private final RdioConnectionState b;
    private final String c;
    private l d;

    public h(o o1, RdioConnectionState rdioconnectionstate, String s)
    {
        a = o1;
        b = rdioconnectionstate;
        c = s;
    }

    public final void a(l l1)
    {
        d = l1;
        a.a(this);
    }

    public final void a(Object obj)
    {
        Iterator iterator = ((RdioUserPlaylists)obj).owned.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_139;
            }
            obj = (RdioPlaylist)iterator.next();
        } while (!c.equals(((RdioPlaylist) (obj)).name));
_L1:
        Object obj1 = com.shazam.model.rdio.RdioPlaylistInfo.Builder.a();
        obj1.key = ((RdioPlaylist) (obj)).key;
        obj1.url = ((RdioPlaylist) (obj)).url;
        obj1 = ((com.shazam.model.rdio.RdioPlaylistInfo.Builder) (obj1)).b();
        boolean flag;
        if (com.shazam.b.e.a.a(((RdioPlaylistInfo) (obj1)).key) || com.shazam.b.e.a.a(((RdioPlaylistInfo) (obj1)).url))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            HashSet hashset = new HashSet();
            hashset.addAll(((RdioPlaylist) (obj)).trackKeys);
            b.a(((RdioPlaylistInfo) (obj1)));
            d.a(hashset);
            return;
        } else
        {
            d.e();
            return;
        }
        obj = RdioPlaylist.EMPTY;
          goto _L1
    }

    public final void a(String s)
    {
        d.f();
    }
}
