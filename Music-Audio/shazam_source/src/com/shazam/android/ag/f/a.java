// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.f;

import com.shazam.android.persistence.n.b;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.model.streaming.SubscriptionType;
import com.shazam.n.m;
import com.shazam.o.k;
import com.shazam.server.response.streaming.spotify.SpotifyTokenExchange;
import java.util.Map;

public final class a
    implements SpotifyConnectionState
{

    private final b a;
    private final m b;

    public a(b b1, m m1)
    {
        a = b1;
        b = m1;
    }

    public final void a(SubscriptionType subscriptiontype)
    {
        a.b("pk_spotify_subscription_type", subscriptiontype.name());
    }

    public final void a(SpotifyTokenExchange spotifytokenexchange)
    {
        a.b("pk_spotify_access_token", spotifytokenexchange.accessToken);
        a.b("pk_spotify_refresh_token_type", spotifytokenexchange.tokenType);
        a.a("pk_spotify_refresh_token_expires", b.a() + (long)(spotifytokenexchange.expiresIn * 1000));
    }

    public final void a(String s)
    {
        a.b("pk_spotify_user_id", s);
    }

    public final boolean a()
    {
        return com.shazam.b.e.a.c(a.a("pk_spotify_access_token", null));
    }

    public final void b()
    {
        a.i("pk_spotify_access_token");
        a.i("pk_spotify_refresh_token_type");
        a.i("pk_spotify_refresh_token_expires");
        a.i("pk_spotify_refresh_token");
        a.i("pk_spotify_user_id");
        a.i("pk_spotify_playlist_id");
    }

    public final void b(String s)
    {
        a.b("pk_spotify_playlist_id", s);
    }

    public final String c()
    {
        return a.h("pk_spotify_access_token");
    }

    public final void c(String s)
    {
        a.b("pk_spotify_refresh_token", s);
    }

    public final String d()
    {
        return a.h("pk_spotify_user_id");
    }

    public final Map e()
    {
        return k.a("Authorization", (new StringBuilder()).append(a.h("pk_spotify_refresh_token_type")).append(" ").append(c()).toString());
    }

    public final String f()
    {
        return a.h("pk_spotify_playlist_id");
    }

    public final SubscriptionType g()
    {
        return SubscriptionType.from(a.h("pk_spotify_subscription_type"));
    }

    public final long h()
    {
        return a.f("pk_spotify_refresh_token_expires");
    }

    public final String i()
    {
        return a.h("pk_spotify_refresh_token");
    }
}
