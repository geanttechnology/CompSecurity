// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.v.g.a;

import com.shazam.android.an.b.ae;
import com.shazam.android.k.e.t;
import com.shazam.h.i;
import com.shazam.model.Factory;
import com.shazam.model.spotify.SpotifyConnectionState;

public final class a
    implements Factory
{

    private final i a;
    private final ae b;
    private final SpotifyConnectionState c;

    public a(i i, ae ae, SpotifyConnectionState spotifyconnectionstate)
    {
        a = i;
        b = ae;
        c = spotifyconnectionstate;
    }

    public final Object create(Object obj)
    {
        obj = (String)obj;
        return new t(a, b, c, ((String) (obj)));
    }
}
