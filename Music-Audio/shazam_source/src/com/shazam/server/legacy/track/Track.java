// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;

import com.shazam.server.legacy.Json;
import java.util.List;

// Referenced classes of package com.shazam.server.legacy.track:
//            AdvertisingInfo, CoverArt, GenreCategory, Label, 
//            Product, Link

public class Track
{

    private List addOns;
    private AdvertisingInfo advertisingInfo;
    private List artists;
    private String beaconKey;
    private String campaign;
    private String category;
    private CoverArt coverArt;
    private GenreCategory genreCategory;
    private Json json;
    private String key;
    private Label label;
    private List metadata;
    private String playWith;
    private Product product;
    private Link promoHd;
    private String released;
    private Json stores;
    private String style;
    private String subtitle;
    private String title;
    private String trackId;
    private String type;
    private Json urlParams;

    private Track()
    {
    }

    private Track(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        trackId = Builder.access._mth000(builder);
        type = Builder.access._mth100(builder);
        category = Builder.access._mth200(builder);
        title = Builder.access._mth300(builder);
        subtitle = Builder.access._mth400(builder);
        metadata = Builder.access._mth500(builder);
        promoHd = Builder.access._mth600(builder);
        label = Builder.access._mth700(builder);
        genreCategory = Builder.access._mth800(builder);
        artists = Builder.access._mth900(builder);
        product = Builder.access._mth1000(builder);
        coverArt = Builder.access._mth1100(builder);
        addOns = Builder.access._mth1200(builder);
        json = Builder.access._mth1300(builder);
        released = Builder.access._mth1400(builder);
        style = Builder.access._mth1500(builder);
        advertisingInfo = Builder.access._mth1600(builder);
        playWith = Builder.access._mth1700(builder);
        key = Builder.access._mth1800(builder);
        beaconKey = Builder.access._mth1900(builder);
        campaign = Builder.access._mth2000(builder);
        stores = Builder.access._mth2100(builder);
        urlParams = Builder.access._mth2200(builder);
    }

    Track(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getAddOns()
    {
        return addOns;
    }

    public AdvertisingInfo getAdvertisingInfo()
    {
        return advertisingInfo;
    }

    public List getArtists()
    {
        return artists;
    }

    public String getBeaconKey()
    {
        return beaconKey;
    }

    public String getCampaign()
    {
        return campaign;
    }

    public String getCategory()
    {
        return category;
    }

    public CoverArt getCoverArt()
    {
        return coverArt;
    }

    public GenreCategory getGenreCategory()
    {
        return genreCategory;
    }

    public Json getJson()
    {
        return json;
    }

    public String getKey()
    {
        return key;
    }

    public Label getLabel()
    {
        return label;
    }

    public List getMetadata()
    {
        return metadata;
    }

    public String getPlayWith()
    {
        return playWith;
    }

    public Product getProduct()
    {
        return product;
    }

    public Link getPromoHd()
    {
        return promoHd;
    }

    public String getReleased()
    {
        return released;
    }

    public Json getStores()
    {
        return stores;
    }

    public String getStyle()
    {
        return style;
    }

    public String getSubtitle()
    {
        return subtitle;
    }

    public String getTitle()
    {
        return title;
    }

    public String getTrackId()
    {
        return trackId;
    }

    public String getType()
    {
        return type;
    }

    public Json getUrlParams()
    {
        return urlParams;
    }
}
