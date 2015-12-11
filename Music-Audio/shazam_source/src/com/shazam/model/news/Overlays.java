// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;


// Referenced classes of package com.shazam.model.news:
//            Image

public class Overlays
{
    public static class Builder
    {

        public Image image;
        public String subtitle;
        public String title;

        static Image a(Builder builder)
        {
            return builder.image;
        }

        public static Builder a()
        {
            return new Builder();
        }

        static String b(Builder builder)
        {
            return builder.title;
        }

        static String c(Builder builder)
        {
            return builder.subtitle;
        }

        public Builder()
        {
        }
    }


    private Image image;
    private String subtitle;
    private String title;

    private Overlays()
    {
    }

    private Overlays(Builder builder)
    {
        image = Builder.a(builder);
        title = Builder.b(builder);
        subtitle = Builder.c(builder);
    }

}
