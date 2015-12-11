// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.rdio;


public class RdioPlaylistInfo
{
    public static class Builder
    {

        public String key;
        public String url;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.key;
        }

        static String b(Builder builder)
        {
            return builder.url;
        }

        public final RdioPlaylistInfo b()
        {
            return new RdioPlaylistInfo(this, null);
        }

        public Builder()
        {
        }
    }


    public final String key;
    public final String url;

    private RdioPlaylistInfo(Builder builder)
    {
        key = Builder.a(builder);
        url = Builder.b(builder);
    }

    RdioPlaylistInfo(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
