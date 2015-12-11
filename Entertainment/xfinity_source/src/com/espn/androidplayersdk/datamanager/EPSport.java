// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import java.io.Serializable;

public class EPSport
    implements Serializable
{

    private static final long serialVersionUID = 0x3809c0b4bfa49d0cL;
    private String ShortName;
    private String abbre;
    private String id;
    private String leagueId;
    private String listingLink;
    private String name;
    private String topListingLink;
    private String type;
    private String vodLink;

    public EPSport(String s, String s1, String s2)
    {
        name = s;
        id = s1;
        abbre = s2;
    }

    protected EPSport(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        name = s;
        id = s1;
        abbre = s2;
        leagueId = s3;
        ShortName = s4;
        type = s5;
        vodLink = s6;
        listingLink = s7;
        topListingLink = s8;
    }

    public String getAbbreviation()
    {
        return abbre;
    }

    public String getId()
    {
        return id;
    }

    protected String getLeagueId()
    {
        return leagueId;
    }

    protected String getListingLink()
    {
        return listingLink;
    }

    public String getName()
    {
        return name;
    }

    public String getShortName()
    {
        return ShortName;
    }

    protected String getTopListingLink()
    {
        return topListingLink;
    }

    protected String getType()
    {
        return type;
    }

    protected String getVodLink()
    {
        return vodLink;
    }
}
