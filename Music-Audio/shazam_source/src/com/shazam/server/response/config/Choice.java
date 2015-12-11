// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.config:
//            StoreAction

public class Choice
    implements Serializable
{

    StoreAction actions;
    String id;
    String key;
    String mapsTrackArtUrlPattern;
    String menuicon;
    String name;
    String newsFeedButton;
    String tagBarButton;
    String trackViewButton;

    private Choice()
    {
    }

    private Choice(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        key = Builder.access._mth000(builder);
        id = Builder.access._mth100(builder);
        name = Builder.access._mth200(builder);
        trackViewButton = Builder.access._mth300(builder);
        newsFeedButton = Builder.access._mth400(builder);
        menuicon = Builder.access._mth500(builder);
        mapsTrackArtUrlPattern = Builder.access._mth600(builder);
        tagBarButton = Builder.access._mth700(builder);
        actions = Builder.access._mth800(builder);
    }

    Choice(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public StoreAction getActions()
    {
        if (actions != null)
        {
            return actions;
        } else
        {
            return StoreAction.Builder.storeAction().build();
        }
    }

    public String getId()
    {
        return id;
    }

    public String getKey()
    {
        return key;
    }

    public String getMapsTrackArtUrlPattern()
    {
        return mapsTrackArtUrlPattern;
    }

    public String getMenuicon()
    {
        return menuicon;
    }

    public String getName()
    {
        return name;
    }

    public String getNewsFeedButton()
    {
        return newsFeedButton;
    }

    public String getTagBarButton()
    {
        return tagBarButton;
    }

    public String getTrackViewButton()
    {
        return trackViewButton;
    }
}
