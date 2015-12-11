// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ac;

import com.shazam.model.configuration.PlayWithConfiguration;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.server.response.config.Option;

public final class a
    implements SpotifyConfiguration
{

    private final PlayWithConfiguration a;

    public a(PlayWithConfiguration playwithconfiguration)
    {
        a = playwithconfiguration;
    }

    public final String a(String s)
    {
        return (new StringBuilder("https://api.spotify.com/v1/users/")).append(s).append("/playlists").toString();
    }

    public final String a(String s, String s1)
    {
        return (new StringBuilder()).append(a(s)).append("/").append(s1).append("/tracks").toString();
    }

    public final boolean a()
    {
        return a.b("spotify");
    }

    public final String b()
    {
        return a.a("spotify").getOauthswap();
    }

    public final String c()
    {
        return "https://api.spotify.com/v1/me";
    }

    public final String d()
    {
        return a.a("spotify").getOauthrefresh();
    }
}
