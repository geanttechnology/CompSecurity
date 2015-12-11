// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import android.net.Uri;
import java.util.List;

public class Playlist
{
    public static class Builder
    {

        public List items;
        public Uri playlistUri;
        public String title;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.title;
        }

        static List b(Builder builder)
        {
            return builder.items;
        }

        static Uri c(Builder builder)
        {
            return builder.playlistUri;
        }

        public final Playlist b()
        {
            return new Playlist(this, null);
        }

        public Builder()
        {
        }
    }


    public List items;
    public Uri playerlistUri;
    public String title;

    private Playlist()
    {
    }

    private Playlist(Builder builder)
    {
        title = Builder.a(builder);
        items = Builder.b(builder);
        playerlistUri = Builder.c(builder);
    }

    Playlist(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
