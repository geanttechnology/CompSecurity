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
//            AddOn, Actions

public static class FeedCard
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

    static Follow A(FeedCard feedcard)
    {
        return feedcard.follow;
    }

    static ShareData B(follow follow1)
    {
        return follow1.shareData;
    }

    static AlternativeTrack C(shareData sharedata)
    {
        return sharedata.alternativeTrack;
    }

    public static alternativeTrack a()
    {
        return new <init>();
    }

    public static <init> a(AddOn addon)
    {
        <init> <init>1 = new <init>();
        <init>1.id = AddOn.C(addon);
        <init>1.typeId = AddOn.B(addon);
        <init>1.typeName = AddOn.A(addon);
        <init>1.iconURL = AddOn.z(addon);
        <init>1.iconVersion = AddOn.y(addon);
        <init>1 = <init>1.a(AddOn.x(addon));
        <init>1.providerName = AddOn.w(addon);
        <init>1.autoLaunch = AddOn.v(addon);
        <init>1.screenName = AddOn.u(addon);
        <init>1.extra = AddOn.t(addon);
        <init>1.moduleOrder = AddOn.s(addon);
        <init>1.moduleTitle = AddOn.r(addon);
        <init>1.moduleStyle = AddOn.q(addon);
        <init>1.moduleSize = AddOn.p(addon);
        <init>1.lyrics = AddOn.o(addon);
        <init>1.writers = AddOn.n(addon);
        <init>1.copyright = AddOn.m(addon);
        <init>1.lyricPlay = AddOn.l(addon);
        <init>1.biographyArtistId = AddOn.k(addon);
        <init>1.moduleImage = AddOn.j(addon);
        <init>1.actions = AddOn.i(addon);
        <init>1.moduleDecorator = AddOn.h(addon);
        <init>1.moduleBeacons = AddOn.g(addon);
        <init>1.moduleFacebookAd = AddOn.f(addon);
        <init>1.sponsoredNewsCard = AddOn.e(addon);
        <init>1.trackId = AddOn.d(addon);
        <init>1.follow = AddOn.c(addon);
        <init>1.shareData = AddOn.b(addon);
        <init>1.alternativeTrack = AddOn.a(addon);
        return <init>1;
    }

    static String a(alternativeTrack alternativetrack)
    {
        return alternativetrack.id;
    }

    static String b(id id1)
    {
        return id1.typeId;
    }

    static String c(typeId typeid)
    {
        return typeid.typeName;
    }

    static String d(typeName typename)
    {
        return typename.iconURL;
    }

    static String e(iconURL iconurl)
    {
        return iconurl.iconVersion;
    }

    static List f(iconVersion iconversion)
    {
        return iconversion.intents;
    }

    static String g(intents intents1)
    {
        return intents1.providerName;
    }

    static boolean h(providerName providername)
    {
        return providername.autoLaunch;
    }

    static String i(autoLaunch autolaunch)
    {
        return autolaunch.screenName;
    }

    static String j(screenName screenname)
    {
        return screenname.extra;
    }

    static String k(extra extra1)
    {
        return extra1.moduleOrder;
    }

    static String l(moduleOrder moduleorder)
    {
        return moduleorder.moduleTitle;
    }

    static String m(moduleTitle moduletitle)
    {
        return moduletitle.lyrics;
    }

    static String n(lyrics lyrics1)
    {
        return lyrics1.writers;
    }

    static String o(writers writers1)
    {
        return writers1.copyright;
    }

    static LyricPlay p(copyright copyright1)
    {
        return copyright1.lyricPlay;
    }

    static String q(lyricPlay lyricplay)
    {
        return lyricplay.biographyArtistId;
    }

    static String r(biographyArtistId biographyartistid)
    {
        return biographyartistid.moduleSize;
    }

    static String s(moduleSize modulesize)
    {
        return modulesize.moduleImage;
    }

    static String t(moduleImage moduleimage)
    {
        return moduleimage.moduleStyle;
    }

    static Actions u(moduleStyle modulestyle)
    {
        return modulestyle.actions;
    }

    static String v(actions actions1)
    {
        return actions1.moduleDecorator;
    }

    static String w(moduleDecorator moduledecorator)
    {
        return moduledecorator.moduleBeacons;
    }

    static String x(moduleBeacons modulebeacons)
    {
        return modulebeacons.moduleFacebookAd;
    }

    static String y(moduleFacebookAd modulefacebookad)
    {
        return modulefacebookad.trackId;
    }

    static SponsoredFeedCard z(trackId trackid)
    {
        return trackid.sponsoredNewsCard;
    }

    public final sponsoredNewsCard a(List list)
    {
        intents.addAll(list);
        return this;
    }

    public final AddOn b()
    {
        return new AddOn(this);
    }

    public FeedCard()
    {
    }
}
