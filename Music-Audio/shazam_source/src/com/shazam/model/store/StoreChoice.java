// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;


// Referenced classes of package com.shazam.model.store:
//            StoreChoiceAction

public class StoreChoice
{
    public static class Builder
    {

        public String id;
        public String key;
        public String mapsTrackArtUrlPattern;
        public String menuIcon;
        public String name;
        public String newsFeedButtonUrl;
        public StoreChoiceAction storeChoiceAction;
        public String tagBarButtonUrl;
        public String trackViewButtonUrl;

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
            return builder.id;
        }

        static String c(Builder builder)
        {
            return builder.name;
        }

        static String d(Builder builder)
        {
            return builder.trackViewButtonUrl;
        }

        static String e(Builder builder)
        {
            return builder.newsFeedButtonUrl;
        }

        static String f(Builder builder)
        {
            return builder.menuIcon;
        }

        static String g(Builder builder)
        {
            return builder.mapsTrackArtUrlPattern;
        }

        static String h(Builder builder)
        {
            return builder.tagBarButtonUrl;
        }

        static StoreChoiceAction i(Builder builder)
        {
            return builder.storeChoiceAction;
        }

        public Builder()
        {
        }
    }


    public final String id;
    public final String key;
    public final String mapsTrackArtUrlPattern;
    public final String menuIcon;
    public final String name;
    public final String newsFeedButtonUrl;
    public final StoreChoiceAction storeChoiceAction;
    public final String tagBarButtonUrl;
    public final String trackViewButtonUrl;

    private StoreChoice(Builder builder)
    {
        key = Builder.a(builder);
        id = Builder.b(builder);
        name = Builder.c(builder);
        trackViewButtonUrl = Builder.d(builder);
        newsFeedButtonUrl = Builder.e(builder);
        menuIcon = Builder.f(builder);
        mapsTrackArtUrlPattern = Builder.g(builder);
        tagBarButtonUrl = Builder.h(builder);
        storeChoiceAction = Builder.i(builder);
    }

}
