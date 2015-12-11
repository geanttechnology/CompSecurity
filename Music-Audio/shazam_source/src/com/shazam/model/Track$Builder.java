// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.model.advert.AdvertisingInfo;
import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.model:
//            Track, TrackCategory, TrackStyle, AddOn, 
//            Art, Genre, Label, TrackLayoutType

public static class DefaultStyle
{

    private final List addOns = new ArrayList();
    public AdvertisingInfo advertisingInfo;
    public String album;
    public Art art;
    public String artistName;
    public String beaconKey;
    public String campaign;
    public TrackCategory category;
    public Genre genre;
    public String id;
    public boolean isFull;
    public String json;
    public String key;
    public Label label;
    public final Map metadata = new LinkedHashMap();
    public String playWith;
    public String promoFullScreenUrl;
    public String released;
    public Stores stores;
    public Streams streams;
    public Genre subgenre;
    public String subtitle;
    public String title;
    public TrackLayoutType trackLayoutType;
    public TrackStyle trackStyle;
    public Map urlParams;

    public static DefaultStyle a()
    {
        return new <init>();
    }

    public static <init> a(Track track)
    {
        <init> <init>1 = new <init>();
        for (Iterator iterator = track.addOns.iterator(); iterator.hasNext(); <init>1.a((AddOn)iterator.next())) { }
        <init>1.album = track.album;
        <init>1.artistName = track.artistName;
        <init>1.art = track.art;
        <init>1.beaconKey = track.beaconKey;
        <init>1.campaign = track.campaign;
        <init>1.category = track.category;
        <init>1.isFull = track.isFull;
        <init>1.genre = track.genre;
        <init>1.id = track.id;
        <init>1.json = track.json;
        <init>1.key = track.key;
        <init>1.label = track.label;
        Map map = track.metadata;
        <init>1.metadata.putAll(map);
        <init>1.playWith = track.playWith;
        <init>1.streams = track.c();
        <init>1.promoFullScreenUrl = track.promoFullScreenUrl;
        <init>1.released = track.released;
        <init>1.trackStyle = track.trackStyle;
        <init>1.subgenre = track.subgenre;
        <init>1.subtitle = track.subtitle;
        <init>1.title = track.title;
        <init>1.trackLayoutType = track.trackLayoutType;
        <init>1.stores = track.stores;
        <init>1.urlParams = track.urlParams;
        return <init>1;
    }

    static String a(s s1)
    {
        return s1.id;
    }

    static boolean b(id id1)
    {
        return id1.isFull;
    }

    static String c(isFull isfull)
    {
        return isfull.subtitle;
    }

    static TrackCategory d(subtitle subtitle1)
    {
        return subtitle1.category;
    }

    static String e(category category1)
    {
        return category1.title;
    }

    static TrackLayoutType f(title title1)
    {
        return title1.trackLayoutType;
    }

    static Art g(trackLayoutType tracklayouttype)
    {
        return tracklayouttype.art;
    }

    static List h(art art1)
    {
        return art1.addOns;
    }

    static Label i(addOns addons)
    {
        return addons.label;
    }

    static String j(label label1)
    {
        return label1.album;
    }

    static Genre k(album album1)
    {
        return album1.genre;
    }

    static Genre l(genre genre1)
    {
        return genre1.subgenre;
    }

    static Map m(subgenre subgenre1)
    {
        return subgenre1.metadata;
    }

    static String n(metadata metadata1)
    {
        return metadata1.promoFullScreenUrl;
    }

    static String o(promoFullScreenUrl promofullscreenurl)
    {
        return promofullscreenurl.json;
    }

    static TrackStyle p(json json1)
    {
        return json1.trackStyle;
    }

    static AdvertisingInfo q(trackStyle trackstyle)
    {
        return trackstyle.advertisingInfo;
    }

    static String r(advertisingInfo advertisinginfo)
    {
        return advertisinginfo.playWith;
    }

    static String s(playWith playwith)
    {
        return playwith.key;
    }

    static String t(key key1)
    {
        return key1.beaconKey;
    }

    static String u(beaconKey beaconkey)
    {
        return beaconkey.campaign;
    }

    static Stores v(campaign campaign1)
    {
        return campaign1.stores;
    }

    static Map w(stores stores1)
    {
        return stores1.urlParams;
    }

    static Streams x(urlParams urlparams)
    {
        return urlparams.streams;
    }

    static String y(streams streams1)
    {
        return streams1.artistName;
    }

    public final artistName a(AddOn addon)
    {
        addOns.add(addon);
        return this;
    }

    public final Track b()
    {
        return new Track(this, null);
    }

    private .Streams()
    {
        category = TrackCategory.MUSIC;
        isFull = true;
        trackStyle = TrackStyle.getDefaultStyle();
    }
}
