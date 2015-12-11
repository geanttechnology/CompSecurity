// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import java.io.Serializable;
import java.util.HashMap;

public class EPEvents
    implements Serializable
{

    private static final long serialVersionUID = 0xe908bcc744eccca1L;
    String airingId;
    String broadcastStartDate;
    String coverageType;
    private String defaultStartSessionUrl;
    String description;
    String endTime;
    String eventId;
    String eventName;
    String imageLarge;
    String imageMedium;
    String imageSmall;
    String leagueId;
    String leagueName;
    String networkId;
    String networkName;
    String networkResourceId;
    String parentalRating;
    String programinCode;
    String seekInSecond;
    String showName;
    String sport;
    String sportCode;
    String startTime;
    String type;

    public EPEvents(HashMap hashmap)
    {
        defaultStartSessionUrl = null;
        eventName = (String)hashmap.get("eventName");
        eventId = (String)hashmap.get("eventId");
        airingId = (String)hashmap.get("simulcastAiringId");
        type = (String)hashmap.get("eventType");
        showName = (String)hashmap.get("showName");
        broadcastStartDate = (String)hashmap.get("broadcastStartTime");
        startTime = (String)hashmap.get("startTime");
        endTime = (String)hashmap.get("endTime");
        imageLarge = (String)hashmap.get("imageLarge");
        imageMedium = (String)hashmap.get("imageMed");
        imageSmall = (String)hashmap.get("imageSmall");
        parentalRating = (String)hashmap.get("parentalRating");
        seekInSecond = (String)hashmap.get("seekInSeconds");
        networkId = (String)hashmap.get("networkCode");
        description = (String)hashmap.get("description");
        networkName = (String)hashmap.get("networkName");
        leagueId = (String)hashmap.get("league");
        leagueName = (String)hashmap.get("leagueName");
        sport = (String)hashmap.get("SPORT");
        sportCode = (String)hashmap.get("sportCode");
        programinCode = (String)hashmap.get("programingCode");
        coverageType = (String)hashmap.get("coverageType");
        defaultStartSessionUrl = (String)hashmap.get("defaultStartSessionUrl");
        networkResourceId = (String)hashmap.get("networkResourceId");
    }

    public String getAiringId()
    {
        return airingId;
    }

    public String getBroadcastStartDate()
    {
        return broadcastStartDate;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public String getEventDescription()
    {
        return description;
    }

    public String getEventId()
    {
        return eventId;
    }

    public String getEventName()
    {
        return eventName;
    }

    public String getImageLarge()
    {
        return imageLarge;
    }

    public String getImageMedium()
    {
        return imageMedium;
    }

    public String getImageSmall()
    {
        return imageSmall;
    }

    public String getLeague()
    {
        if (leagueId != null)
        {
            return leagueId;
        } else
        {
            return "";
        }
    }

    public String getLeagueName()
    {
        if (leagueName != null)
        {
            return leagueName;
        } else
        {
            return "";
        }
    }

    public String getNetworkId()
    {
        return networkId;
    }

    public String getNetworkName()
    {
        return networkName;
    }

    public String getNetworkResourceId()
    {
        return networkResourceId;
    }

    public String getParentalRating()
    {
        return parentalRating;
    }

    public String getSeekInSecond()
    {
        return seekInSecond;
    }

    public String getShowName()
    {
        return showName;
    }

    public String getSport()
    {
        if (sport != null)
        {
            return sport;
        } else
        {
            return "";
        }
    }

    public String getSportCode()
    {
        if (sportCode != null)
        {
            return sportCode;
        } else
        {
            return "";
        }
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getType()
    {
        return type;
    }

    public String getcoverageType()
    {
        if (coverageType != null)
        {
            return coverageType;
        } else
        {
            return "";
        }
    }

    public String getprogramingCode()
    {
        if (programinCode != null)
        {
            return programinCode;
        } else
        {
            return "";
        }
    }
}
