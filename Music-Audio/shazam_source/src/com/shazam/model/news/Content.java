// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;


// Referenced classes of package com.shazam.model.news:
//            Image, Overlays

public class Content
{
    public static class Builder
    {

        public String attribution;
        public String body;
        public String context;
        public String headline;
        public Image image;
        public Overlays overlays;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.attribution;
        }

        static String b(Builder builder)
        {
            return builder.headline;
        }

        static String c(Builder builder)
        {
            return builder.body;
        }

        static String d(Builder builder)
        {
            return builder.context;
        }

        static Image e(Builder builder)
        {
            return builder.image;
        }

        static Overlays f(Builder builder)
        {
            return builder.overlays;
        }

        public Builder()
        {
        }
    }


    public String attribution;
    public String body;
    public String context;
    public String headline;
    public Image image;
    private Overlays overlays;

    private Content()
    {
    }

    private Content(Builder builder)
    {
        attribution = Builder.a(builder);
        headline = Builder.b(builder);
        body = Builder.c(builder);
        context = Builder.d(builder);
        image = Builder.e(builder);
        overlays = Builder.f(builder);
    }

}
