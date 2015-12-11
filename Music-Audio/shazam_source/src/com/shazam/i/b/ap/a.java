// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ap;

import com.shazam.android.an.a.d;
import com.shazam.android.k.f.p;
import com.shazam.android.w.b.b;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.o.c.c;
import com.shazam.model.facebook.FacebookConnectionState;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.social.ConnectionState;
import com.shazam.model.spotify.SpotifyConnectionState;

public final class a
{

    private static final d a = new d(f.a());
    private static final com.shazam.android.ag.f.a b = new com.shazam.android.ag.f.a(f.a(), com.shazam.i.b.at.a.a());
    private static final com.shazam.android.u.f c = new com.shazam.android.u.f(f.a(), com.shazam.i.b.o.c.c.a(), new p());
    private static final b d = new b(f.a());

    public static RdioConnectionState a()
    {
        return a;
    }

    public static SpotifyConnectionState b()
    {
        return b;
    }

    public static FacebookConnectionState c()
    {
        return c;
    }

    public static ConnectionState d()
    {
        return d;
    }

}
