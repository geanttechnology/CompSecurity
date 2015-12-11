// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.rdio;


public class RdioLegacyCredentials
{
    public static class Builder
    {

        public String accessToken;
        public String accessTokenSecret;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.accessToken;
        }

        static String b(Builder builder)
        {
            return builder.accessTokenSecret;
        }

        public Builder()
        {
        }
    }


    public final String accessToken;
    private final String accessTokenSecret;

    private RdioLegacyCredentials(Builder builder)
    {
        accessToken = Builder.a(builder);
        accessTokenSecret = Builder.b(builder);
    }

}
