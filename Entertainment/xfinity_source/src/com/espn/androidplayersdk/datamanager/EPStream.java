// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import java.io.Serializable;
import java.util.HashMap;

public class EPStream
    implements Serializable
{

    private static final long serialVersionUID = 0x9d2a08823fd46fccL;
    boolean adInsertionEnabled;
    String airingId;
    String alternatePlaybackUrl;
    String authorizationCookieName;
    String cdn;
    String domain;
    String eventId;
    String fwSyncTokenUrl;
    String maintainUrl;
    String networkId;
    String playbackUrl;
    String programChangeUrl;
    String resource;
    String token;
    String ttl;

    public EPStream(HashMap hashmap)
    {
        eventId = (String)hashmap.get("eventId");
        airingId = (String)hashmap.get("airingId");
        networkId = (String)hashmap.get("networkId");
        playbackUrl = (String)hashmap.get("playbackUrl");
        alternatePlaybackUrl = (String)hashmap.get("alternatePlaybackUrl");
        token = (String)hashmap.get("token");
        authorizationCookieName = (String)hashmap.get("authorizationCookieName");
        maintainUrl = (String)hashmap.get("maintainUrl");
        programChangeUrl = (String)hashmap.get("programChangeUrl");
        ttl = (String)hashmap.get("ttl");
        domain = (String)hashmap.get("domain");
        cdn = (String)hashmap.get("cdn");
        resource = (String)hashmap.get("resource");
        fwSyncTokenUrl = (String)hashmap.get("fwSyncTokenUrl");
        adInsertionEnabled = Boolean.parseBoolean((String)hashmap.get("adInsertionEnabled"));
    }

    public String getAiringId()
    {
        return airingId;
    }

    public String getAlternatePlaybackUrl()
    {
        return alternatePlaybackUrl;
    }

    public String getAuthCookieName()
    {
        return authorizationCookieName;
    }

    protected String getCdn()
    {
        return cdn;
    }

    protected String getCdnResource()
    {
        return resource;
    }

    public String getDomain()
    {
        return domain;
    }

    public String getEventId()
    {
        return eventId;
    }

    protected String getMaintainUrl()
    {
        return maintainUrl;
    }

    public String getNetworkId()
    {
        return networkId;
    }

    public String getPlaybackUrl()
    {
        return playbackUrl;
    }

    protected String getProgramChangeUrl()
    {
        return programChangeUrl;
    }

    public String getToken()
    {
        return token;
    }

    public String getTtl()
    {
        return ttl;
    }

    protected String getfwSyncTokenUrl()
    {
        return fwSyncTokenUrl;
    }

    protected boolean isAdInsertionEnabled()
    {
        return adInsertionEnabled;
    }
}
