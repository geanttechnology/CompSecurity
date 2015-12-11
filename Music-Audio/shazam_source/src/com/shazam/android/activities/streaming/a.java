// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.spotify.SpotifyConnectionState;

// Referenced classes of package com.shazam.android.activities.streaming:
//            e, b

public final class a
    implements e
{

    private final SpotifyConnectionState a;
    private final RdioConnectionState b;

    public a(SpotifyConnectionState spotifyconnectionstate, RdioConnectionState rdioconnectionstate)
    {
        a = spotifyconnectionstate;
        b = rdioconnectionstate;
    }

    public final b a()
    {
        b b1 = null;
        if (b.a())
        {
            b1 = b.a;
        } else
        if (a.a())
        {
            return b.b;
        }
        return b1;
    }
}
