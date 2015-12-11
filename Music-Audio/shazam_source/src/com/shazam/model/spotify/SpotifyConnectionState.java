// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.spotify;

import com.shazam.b.b;
import com.shazam.model.streaming.StreamingConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyTokenExchange;
import java.util.Map;

public interface SpotifyConnectionState
    extends StreamingConnectionState
{

    public static final SpotifyConnectionState NO_OP = (SpotifyConnectionState)com.shazam.b.b.a(com/shazam/model/spotify/SpotifyConnectionState);

    public abstract void a(SpotifyTokenExchange spotifytokenexchange);

    public abstract void a(String s);

    public abstract void b();

    public abstract void b(String s);

    public abstract String c();

    public abstract void c(String s);

    public abstract String d();

    public abstract Map e();

    public abstract long h();

    public abstract String i();

}
