// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;

import java.util.List;

// Referenced classes of package com.shazam.server.legacy.track:
//            AddOnIcon, Link

public class AddOn
{

    private String actionsJson;
    private String announcementJson;
    private Boolean autoLaunch;
    private String biographyArtistId;
    private String copyright;
    private String followJson;
    private AddOnIcon icon;
    private String id;
    private List intentUris;
    private Link link;
    private String lyricPlay;
    private String lyrics;
    private String moduleBeacons;
    private String moduleDecorator;
    private String moduleFacebookAd;
    private String moduleImage;
    private String moduleOrder;
    private String moduleSize;
    private String moduleStyle;
    private String moduleTitle;
    private String providerName;
    private String screenName;
    private String shareJson;
    private String trackJson;
    private String typeId;
    private String typeName;
    private String writers;

    private AddOn()
    {
    }

    private AddOn(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        id = Builder.access._mth000(builder);
        providerName = Builder.access._mth100(builder);
        typeId = Builder.access._mth200(builder);
        typeName = Builder.access._mth300(builder);
        screenName = Builder.access._mth400(builder);
        autoLaunch = Builder.access._mth500(builder);
        intentUris = Builder.access._mth600(builder);
        icon = Builder.access._mth700(builder);
        lyrics = Builder.access._mth800(builder);
        copyright = Builder.access._mth900(builder);
        writers = Builder.access._mth1000(builder);
        link = Builder.access._mth1100(builder);
        moduleOrder = Builder.access._mth1200(builder);
        moduleTitle = Builder.access._mth1300(builder);
        lyricPlay = Builder.access._mth1400(builder);
        biographyArtistId = Builder.access._mth1500(builder);
        moduleSize = Builder.access._mth1600(builder);
        moduleImage = Builder.access._mth1700(builder);
        actionsJson = Builder.access._mth1800(builder);
        moduleStyle = Builder.access._mth1900(builder);
        moduleDecorator = Builder.access._mth2000(builder);
        moduleBeacons = Builder.access._mth2100(builder);
        moduleFacebookAd = Builder.access._mth2200(builder);
        trackJson = Builder.access._mth2300(builder);
        announcementJson = builder.announcementJson;
        followJson = Builder.access._mth2400(builder);
        shareJson = Builder.access._mth2500(builder);
    }

    AddOn(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getActionsJson()
    {
        return actionsJson;
    }

    public String getAnnouncementJson()
    {
        return announcementJson;
    }

    public Boolean getAutoLaunch()
    {
        return autoLaunch;
    }

    public String getBiographyArtistId()
    {
        return biographyArtistId;
    }

    public String getCopyright()
    {
        return copyright;
    }

    public String getFollowJson()
    {
        return followJson;
    }

    public AddOnIcon getIcon()
    {
        return icon;
    }

    public String getId()
    {
        return id;
    }

    public List getIntentUris()
    {
        return intentUris;
    }

    public Link getLink()
    {
        return link;
    }

    public String getLyricPlay()
    {
        return lyricPlay;
    }

    public String getLyrics()
    {
        return lyrics;
    }

    public String getModuleBeacons()
    {
        return moduleBeacons;
    }

    public String getModuleDecorator()
    {
        return moduleDecorator;
    }

    public String getModuleFacebookAd()
    {
        return moduleFacebookAd;
    }

    public String getModuleImage()
    {
        return moduleImage;
    }

    public String getModuleOrder()
    {
        return moduleOrder;
    }

    public String getModuleSize()
    {
        return moduleSize;
    }

    public String getModuleStyle()
    {
        return moduleStyle;
    }

    public String getModuleTitle()
    {
        return moduleTitle;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public String getShareJson()
    {
        return shareJson;
    }

    public String getTrackJson()
    {
        return trackJson;
    }

    public String getTypeId()
    {
        return typeId;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public String getWriters()
    {
        return writers;
    }
}
