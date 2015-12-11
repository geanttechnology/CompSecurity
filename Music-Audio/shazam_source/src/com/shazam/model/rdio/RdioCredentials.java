// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.rdio;


public class RdioCredentials
{
    public static class Builder
    {

        public String accessToken;
        public Long expirationTime;
        public String refreshToken;

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
            return builder.refreshToken;
        }

        static Long c(Builder builder)
        {
            return builder.expirationTime;
        }

        public final RdioCredentials b()
        {
            return new RdioCredentials(this);
        }

        public Builder()
        {
        }
    }


    public final String accessToken;
    public final Long expirationTime;
    public final String refreshToken;

    private RdioCredentials(Builder builder)
    {
        accessToken = Builder.a(builder);
        refreshToken = Builder.b(builder);
        expirationTime = Builder.c(builder);
    }

}
