// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.streaming.spotify;

import java.util.ArrayList;
import java.util.List;

public class SpotifyPlaylistUris
{
    public static class Builder
    {

        private final List uris = new ArrayList();

        public static Builder spotifyPlaylistUris()
        {
            return new Builder();
        }

        public SpotifyPlaylistUris build()
        {
            return new SpotifyPlaylistUris(this, null);
        }

        public Builder withUris(List list)
        {
            uris.clear();
            uris.addAll(list);
            return this;
        }


        public Builder()
        {
        }
    }


    public final List uris;

    private SpotifyPlaylistUris(Builder builder)
    {
        uris = builder.uris;
    }

    SpotifyPlaylistUris(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
