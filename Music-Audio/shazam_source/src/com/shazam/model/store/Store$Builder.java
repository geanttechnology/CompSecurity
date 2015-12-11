// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import android.content.Intent;
import com.shazam.model.analytics.ScreenOrigin;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.model.store:
//            Store

public static class intents
{

    String beaconKey;
    public String blurredCoverArt;
    String campaign;
    String cardType;
    public String coverArt;
    String eventId;
    String iconUrl;
    public List intents;
    public String key;
    public String previewUrl;
    String providerName;
    String screenName;
    ScreenOrigin screenOrigin;
    String trackCategory;
    public String trackId;
    String trackStyle;
    public Intent validIntent;

    static ScreenOrigin a(intents intents1)
    {
        return intents1.screenOrigin;
    }

    public static screenOrigin a()
    {
        return new <init>();
    }

    public static <init> a(Store store)
    {
        <init> <init>1 = new <init>();
        <init>1.providerName = store.providerName;
        <init>1.beaconKey = store.beaconKey;
        <init>1.key = store.key;
        <init>1.campaign = store.campaign;
        <init>1.cardType = store.cardType;
        <init>1.iconUrl = store.iconUrl;
        <init>1.eventId = store.eventId;
        <init>1.intents = store.intents;
        <init>1.trackCategory = store.trackCategory;
        <init>1.trackId = store.trackId;
        <init>1.previewUrl = store.previewUrl;
        <init>1.coverArt = store.coverArt;
        <init>1.blurredCoverArt = store.blurredCoverArt;
        <init>1.screenOrigin = store.screenOrigin;
        <init>1.validIntent = store.validIntent;
        <init>1.trackStyle = store.trackStyle;
        return <init>1;
    }

    static String b(le le)
    {
        return le.trackId;
    }

    static String c(trackId trackid)
    {
        return trackid.iconUrl;
    }

    static String d(iconUrl iconurl)
    {
        return iconurl.providerName;
    }

    static String e(providerName providername)
    {
        return providername.trackCategory;
    }

    static String f(trackCategory trackcategory)
    {
        return trackcategory.eventId;
    }

    static List g(eventId eventid)
    {
        return eventid.intents;
    }

    static String h(intents intents1)
    {
        return intents1.cardType;
    }

    static Intent i(cardType cardtype)
    {
        return cardtype.validIntent;
    }

    static String j(validIntent validintent)
    {
        return validintent.beaconKey;
    }

    static String k(beaconKey beaconkey)
    {
        return beaconkey.campaign;
    }

    static String l(campaign campaign1)
    {
        return campaign1.key;
    }

    static String m(key key1)
    {
        return key1.previewUrl;
    }

    static String n(previewUrl previewurl)
    {
        return previewurl.coverArt;
    }

    static String o(coverArt coverart)
    {
        return coverart.blurredCoverArt;
    }

    static String p(blurredCoverArt blurredcoverart)
    {
        return blurredcoverart.screenName;
    }

    static String q(screenName screenname)
    {
        return screenname.trackStyle;
    }

    public final Store b()
    {
        return new Store(this, null);
    }

    public in()
    {
        intents = new ArrayList();
    }
}
