// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;


public class Image
{
    public static class Builder
    {

        public float aspectRatio;
        public String url;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.url;
        }

        static float b(Builder builder)
        {
            return builder.aspectRatio;
        }

        public Builder()
        {
        }
    }


    public float aspectRatio;
    public String url;

    private Image()
    {
    }

    private Image(Builder builder)
    {
        url = Builder.a(builder);
        aspectRatio = Builder.b(builder);
    }

}
