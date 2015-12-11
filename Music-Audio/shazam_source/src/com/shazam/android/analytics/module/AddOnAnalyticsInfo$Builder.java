// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.module;

import com.shazam.android.k.f.r;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.share.ShareStyle;

// Referenced classes of package com.shazam.android.analytics.module:
//            AddOnAnalyticsInfo

public static class 
{

    private String artistId;
    private String beaconKey;
    private String campaign;
    private String cardType;
    private String eventId;
    private String providerName;
    private String requestId;
    private String screenName;
    private ScreenOrigin screenOrigin;
    private ShareStyle shareStyle;
    private r shazamUri;
    private String tagId;
    private String tagResultVersion;
    private String trackCategory;
    private String trackId;
    private String uuid;

    static String a( )
    {
        return .trackId;
    }

    public static trackId addOnAnalyticsInfo()
    {
        return new <init>();
    }

    public static <init> addOnAnalyticsInfo(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        <init> <init>1 = addOnAnalyticsInfo();
        <init>1.trackId = AddOnAnalyticsInfo.a(addonanalyticsinfo);
        <init>1.beaconKey = AddOnAnalyticsInfo.b(addonanalyticsinfo);
        <init>1.campaign = AddOnAnalyticsInfo.c(addonanalyticsinfo);
        <init>1.trackCategory = AddOnAnalyticsInfo.d(addonanalyticsinfo);
        <init>1.providerName = AddOnAnalyticsInfo.e(addonanalyticsinfo);
        <init>1.shazamUri = AddOnAnalyticsInfo.f(addonanalyticsinfo);
        <init>1.screenOrigin = AddOnAnalyticsInfo.g(addonanalyticsinfo);
        <init>1.eventId = AddOnAnalyticsInfo.h(addonanalyticsinfo);
        <init>1.screenName = AddOnAnalyticsInfo.i(addonanalyticsinfo);
        <init>1.tagResultVersion = AddOnAnalyticsInfo.j(addonanalyticsinfo);
        <init>1.cardType = AddOnAnalyticsInfo.k(addonanalyticsinfo);
        <init>1.uuid = AddOnAnalyticsInfo.l(addonanalyticsinfo);
        <init>1.artistId = AddOnAnalyticsInfo.m(addonanalyticsinfo);
        <init>1.tagId = AddOnAnalyticsInfo.n(addonanalyticsinfo);
        <init>1.requestId = AddOnAnalyticsInfo.o(addonanalyticsinfo);
        <init>1.shareStyle = AddOnAnalyticsInfo.p(addonanalyticsinfo);
        return <init>1;
    }

    static String b(shareStyle sharestyle)
    {
        return sharestyle.beaconKey;
    }

    static String c(beaconKey beaconkey)
    {
        return beaconkey.campaign;
    }

    static String d(campaign campaign1)
    {
        return campaign1.trackCategory;
    }

    static String e(trackCategory trackcategory)
    {
        return trackcategory.providerName;
    }

    static r f(providerName providername)
    {
        return providername.shazamUri;
    }

    static ScreenOrigin g(shazamUri shazamuri)
    {
        return shazamuri.screenOrigin;
    }

    static String h(screenOrigin screenorigin)
    {
        return screenorigin.eventId;
    }

    static String i(eventId eventid)
    {
        return eventid.screenName;
    }

    static String j(screenName screenname)
    {
        return screenname.tagResultVersion;
    }

    static String k(tagResultVersion tagresultversion)
    {
        return tagresultversion.cardType;
    }

    static String l(cardType cardtype)
    {
        return cardtype.uuid;
    }

    static String m(uuid uuid1)
    {
        return uuid1.artistId;
    }

    static String n(artistId artistid)
    {
        return artistid.tagId;
    }

    static String o(tagId tagid)
    {
        return tagid.requestId;
    }

    static ShareStyle p(requestId requestid)
    {
        return requestid.shareStyle;
    }

    public AddOnAnalyticsInfo build()
    {
        return new AddOnAnalyticsInfo(this, (byte)0);
    }

    public shareStyle withArtistId(String s)
    {
        artistId = s;
        return this;
    }

    public artistId withBeaconKey(String s)
    {
        beaconKey = s;
        return this;
    }

    public beaconKey withCampaign(String s)
    {
        campaign = s;
        return this;
    }

    public campaign withCardType(String s)
    {
        cardType = s;
        return this;
    }

    public cardType withEventId(String s)
    {
        eventId = s;
        return this;
    }

    public eventId withProviderName(String s)
    {
        providerName = s;
        return this;
    }

    public providerName withRequestId(String s)
    {
        requestId = s;
        return this;
    }

    public requestId withScreenName(String s)
    {
        screenName = s;
        return this;
    }

    public screenName withScreenOrigin(ScreenOrigin screenorigin)
    {
        screenOrigin = screenorigin;
        return this;
    }

    public screenOrigin withShareStyle(ShareStyle sharestyle)
    {
        shareStyle = sharestyle;
        return this;
    }

    public shareStyle withShazamUri(r r)
    {
        shazamUri = r;
        return this;
    }

    public shazamUri withTagId(String s)
    {
        tagId = s;
        return this;
    }

    public tagId withTagResultVersion(String s)
    {
        tagResultVersion = s;
        return this;
    }

    public tagResultVersion withTrackCategory(String s)
    {
        trackCategory = s;
        return this;
    }

    public trackCategory withTrackId(String s)
    {
        trackId = s;
        return this;
    }

    public trackId withUuid(String s)
    {
        uuid = s;
        return this;
    }

    public ()
    {
    }
}
