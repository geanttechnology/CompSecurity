// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;


public class ArbitraryMetadata
{
    public static class Builder
    {

        public String key;
        public String value;

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
            return builder.value;
        }

        public Builder()
        {
        }
    }


    public final String key;
    public final String value;

    private ArbitraryMetadata(Builder builder)
    {
        key = Builder.a(builder);
        value = Builder.b(builder);
    }

}
