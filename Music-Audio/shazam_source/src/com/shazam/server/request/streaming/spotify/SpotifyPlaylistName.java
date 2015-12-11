// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.streaming.spotify;


public class SpotifyPlaylistName
{
    public static class Builder
    {

        private String name;

        public static Builder spotifyPlaylistName()
        {
            return new Builder();
        }

        public SpotifyPlaylistName build()
        {
            return new SpotifyPlaylistName(this, null);
        }

        public Builder withName(String s)
        {
            name = s;
            return this;
        }


        public Builder()
        {
        }
    }


    public final String name;

    private SpotifyPlaylistName(Builder builder)
    {
        name = builder.name;
    }

    SpotifyPlaylistName(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
