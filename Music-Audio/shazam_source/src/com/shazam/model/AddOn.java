// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.model.follow.Follow;
import com.shazam.model.gimbal.AlternativeTrack;
import com.shazam.model.lyrics.LyricPlay;
import com.shazam.model.news.SponsoredFeedCard;
import com.shazam.model.share.ShareData;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.model:
//            Actions

public class AddOn
{
    public static class Builder
    {

        public Actions actions;
        public AlternativeTrack alternativeTrack;
        public boolean autoLaunch;
        public String biographyArtistId;
        public String copyright;
        public String extra;
        public Follow follow;
        public String iconURL;
        public String iconVersion;
        public String id;
        private final List intents = new ArrayList();
        public LyricPlay lyricPlay;
        public String lyrics;
        public String moduleBeacons;
        public String moduleDecorator;
        public String moduleFacebookAd;
        public String moduleImage;
        public String moduleOrder;
        public String moduleSize;
        public String moduleStyle;
        public String moduleTitle;
        public String providerName;
        public String screenName;
        public ShareData shareData;
        public SponsoredFeedCard sponsoredNewsCard;
        public String trackId;
        public String typeId;
        public String typeName;
        public String writers;

        static Follow A(Builder builder)
        {
            return builder.follow;
        }

        static ShareData B(Builder builder)
        {
            return builder.shareData;
        }

        static AlternativeTrack C(Builder builder)
        {
            return builder.alternativeTrack;
        }

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(AddOn addon)
        {
            Builder builder = new Builder();
            builder.id = AddOn.C(addon);
            builder.typeId = AddOn.B(addon);
            builder.typeName = AddOn.A(addon);
            builder.iconURL = AddOn.z(addon);
            builder.iconVersion = AddOn.y(addon);
            builder = builder.a(AddOn.x(addon));
            builder.providerName = AddOn.w(addon);
            builder.autoLaunch = AddOn.v(addon);
            builder.screenName = AddOn.u(addon);
            builder.extra = AddOn.t(addon);
            builder.moduleOrder = AddOn.s(addon);
            builder.moduleTitle = AddOn.r(addon);
            builder.moduleStyle = AddOn.q(addon);
            builder.moduleSize = AddOn.p(addon);
            builder.lyrics = AddOn.o(addon);
            builder.writers = AddOn.n(addon);
            builder.copyright = AddOn.m(addon);
            builder.lyricPlay = AddOn.l(addon);
            builder.biographyArtistId = AddOn.k(addon);
            builder.moduleImage = AddOn.j(addon);
            builder.actions = AddOn.i(addon);
            builder.moduleDecorator = AddOn.h(addon);
            builder.moduleBeacons = AddOn.g(addon);
            builder.moduleFacebookAd = AddOn.f(addon);
            builder.sponsoredNewsCard = AddOn.e(addon);
            builder.trackId = AddOn.d(addon);
            builder.follow = AddOn.c(addon);
            builder.shareData = AddOn.b(addon);
            builder.alternativeTrack = AddOn.a(addon);
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.id;
        }

        static String b(Builder builder)
        {
            return builder.typeId;
        }

        static String c(Builder builder)
        {
            return builder.typeName;
        }

        static String d(Builder builder)
        {
            return builder.iconURL;
        }

        static String e(Builder builder)
        {
            return builder.iconVersion;
        }

        static List f(Builder builder)
        {
            return builder.intents;
        }

        static String g(Builder builder)
        {
            return builder.providerName;
        }

        static boolean h(Builder builder)
        {
            return builder.autoLaunch;
        }

        static String i(Builder builder)
        {
            return builder.screenName;
        }

        static String j(Builder builder)
        {
            return builder.extra;
        }

        static String k(Builder builder)
        {
            return builder.moduleOrder;
        }

        static String l(Builder builder)
        {
            return builder.moduleTitle;
        }

        static String m(Builder builder)
        {
            return builder.lyrics;
        }

        static String n(Builder builder)
        {
            return builder.writers;
        }

        static String o(Builder builder)
        {
            return builder.copyright;
        }

        static LyricPlay p(Builder builder)
        {
            return builder.lyricPlay;
        }

        static String q(Builder builder)
        {
            return builder.biographyArtistId;
        }

        static String r(Builder builder)
        {
            return builder.moduleSize;
        }

        static String s(Builder builder)
        {
            return builder.moduleImage;
        }

        static String t(Builder builder)
        {
            return builder.moduleStyle;
        }

        static Actions u(Builder builder)
        {
            return builder.actions;
        }

        static String v(Builder builder)
        {
            return builder.moduleDecorator;
        }

        static String w(Builder builder)
        {
            return builder.moduleBeacons;
        }

        static String x(Builder builder)
        {
            return builder.moduleFacebookAd;
        }

        static String y(Builder builder)
        {
            return builder.trackId;
        }

        static SponsoredFeedCard z(Builder builder)
        {
            return builder.sponsoredNewsCard;
        }

        public final Builder a(List list)
        {
            intents.addAll(list);
            return this;
        }

        public final AddOn b()
        {
            return new AddOn(this);
        }

        public Builder()
        {
        }
    }


    public static final String ADDON_PROVIDER_ARTIST = "Follow";
    public static final String ADDON_PROVIDER_BIOGRAPHY = "ShazamBiography";
    public static final String ADDON_PROVIDER_DISCOGRAPHY = "ShazamDiscography";
    public static final String ADDON_PROVIDER_FACEBOOK_AD = "FacebookAdvert";
    public static final String ADDON_PROVIDER_FACEBOOK_AD_COLONY_ADVERT = "FacebookAdcolonyAdvert";
    public static final String ADDON_PROVIDER_LYRICS = "Lyrics";
    public static final String ADDON_PROVIDER_RDIO_LISTEN = "RdioListen";
    public static final String ADDON_PROVIDER_RECOMMENDATIONS = "Recommendations";
    public static final String ADDON_PROVIDER_SHARE = "Share";
    public static final String ADDON_PROVIDER_TOUR_INFO = "TourInfo";
    public static final String ADDON_PROVIDER_TRACK_ALTERNATIVE = "AlternativeResult";
    public static final String ADDON_PROVIDER_VIDEO = "Video";
    public Actions actions;
    public AlternativeTrack alternativeTrack;
    private boolean autoLaunch;
    private String biographyArtistId;
    public String copyright;
    public String extra;
    public Follow follow;
    private String iconURL;
    private String iconVersion;
    public String id;
    public List intents;
    public LyricPlay lyricPlay;
    public String lyrics;
    public String moduleBeacons;
    public String moduleDecorator;
    public String moduleFacebookAd;
    public String moduleImage;
    public String moduleOrder;
    public String moduleSize;
    public String moduleStyle;
    public String moduleTitle;
    public String providerName;
    private String screenName;
    public ShareData shareData;
    public SponsoredFeedCard sponsoredNewsCard;
    public String trackId;
    private String typeId;
    private String typeName;
    public String writers;

    private AddOn()
    {
    }

    public AddOn(Builder builder)
    {
        id = Builder.a(builder);
        typeId = Builder.b(builder);
        typeName = Builder.c(builder);
        iconURL = Builder.d(builder);
        iconVersion = Builder.e(builder);
        intents = Builder.f(builder);
        providerName = Builder.g(builder);
        autoLaunch = Builder.h(builder);
        screenName = Builder.i(builder);
        extra = Builder.j(builder);
        moduleOrder = Builder.k(builder);
        moduleTitle = Builder.l(builder);
        lyrics = Builder.m(builder);
        writers = Builder.n(builder);
        copyright = Builder.o(builder);
        lyricPlay = Builder.p(builder);
        biographyArtistId = Builder.q(builder);
        moduleSize = Builder.r(builder);
        moduleImage = Builder.s(builder);
        moduleStyle = Builder.t(builder);
        actions = Builder.u(builder);
        moduleDecorator = Builder.v(builder);
        moduleBeacons = Builder.w(builder);
        moduleFacebookAd = Builder.x(builder);
        trackId = Builder.y(builder);
        sponsoredNewsCard = Builder.z(builder);
        follow = Builder.A(builder);
        shareData = Builder.B(builder);
        alternativeTrack = Builder.C(builder);
    }

    static String A(AddOn addon)
    {
        return addon.typeName;
    }

    static String B(AddOn addon)
    {
        return addon.typeId;
    }

    static String C(AddOn addon)
    {
        return addon.id;
    }

    static AlternativeTrack a(AddOn addon)
    {
        return addon.alternativeTrack;
    }

    static ShareData b(AddOn addon)
    {
        return addon.shareData;
    }

    static Follow c(AddOn addon)
    {
        return addon.follow;
    }

    static String d(AddOn addon)
    {
        return addon.trackId;
    }

    static SponsoredFeedCard e(AddOn addon)
    {
        return addon.sponsoredNewsCard;
    }

    static String f(AddOn addon)
    {
        return addon.moduleFacebookAd;
    }

    static String g(AddOn addon)
    {
        return addon.moduleBeacons;
    }

    static String h(AddOn addon)
    {
        return addon.moduleDecorator;
    }

    static Actions i(AddOn addon)
    {
        return addon.actions;
    }

    static String j(AddOn addon)
    {
        return addon.moduleImage;
    }

    static String k(AddOn addon)
    {
        return addon.biographyArtistId;
    }

    static LyricPlay l(AddOn addon)
    {
        return addon.lyricPlay;
    }

    static String m(AddOn addon)
    {
        return addon.copyright;
    }

    static String n(AddOn addon)
    {
        return addon.writers;
    }

    static String o(AddOn addon)
    {
        return addon.lyrics;
    }

    static String p(AddOn addon)
    {
        return addon.moduleSize;
    }

    static String q(AddOn addon)
    {
        return addon.moduleStyle;
    }

    static String r(AddOn addon)
    {
        return addon.moduleTitle;
    }

    static String s(AddOn addon)
    {
        return addon.moduleOrder;
    }

    static String t(AddOn addon)
    {
        return addon.extra;
    }

    static String u(AddOn addon)
    {
        return addon.screenName;
    }

    static boolean v(AddOn addon)
    {
        return addon.autoLaunch;
    }

    static String w(AddOn addon)
    {
        return addon.providerName;
    }

    static List x(AddOn addon)
    {
        return addon.intents;
    }

    static String y(AddOn addon)
    {
        return addon.iconVersion;
    }

    static String z(AddOn addon)
    {
        return addon.iconURL;
    }
}
