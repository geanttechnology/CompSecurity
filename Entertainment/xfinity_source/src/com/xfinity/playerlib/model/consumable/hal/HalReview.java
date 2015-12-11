// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;

public class HalReview
    implements HalParseable
{

    private int commonSenseMediaTargetAge;
    private String provider;
    private int rottenTomatoesCriticScore;
    private int rottenTomatoesFanScore;

    public HalReview()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (HalReview)obj;
            if (commonSenseMediaTargetAge != ((HalReview) (obj)).commonSenseMediaTargetAge)
            {
                return false;
            }
            if (rottenTomatoesCriticScore != ((HalReview) (obj)).rottenTomatoesCriticScore)
            {
                return false;
            }
            if (rottenTomatoesFanScore != ((HalReview) (obj)).rottenTomatoesFanScore)
            {
                return false;
            }
            if (!provider.equals(((HalReview) (obj)).provider))
            {
                return false;
            }
        }
        return true;
    }

    public int getCommonSenseMediaTargetAge()
    {
        return commonSenseMediaTargetAge;
    }

    public String getProvider()
    {
        return provider;
    }

    public int getRottenTomatoesCriticScore()
    {
        return rottenTomatoesCriticScore;
    }

    public int getRottenTomatoesFanScore()
    {
        return rottenTomatoesFanScore;
    }

    public int hashCode()
    {
        return ((provider.hashCode() * 31 + rottenTomatoesFanScore) * 31 + rottenTomatoesCriticScore) * 31 + commonSenseMediaTargetAge;
    }

    public boolean isCommonSenseMedia()
    {
        return provider != null && provider.equals("CSM");
    }

    public boolean isRottenTomatoes()
    {
        return provider != null && provider.equals("RT");
    }

    public boolean isRottenTomatoesCriticFresh()
    {
        return rottenTomatoesCriticScore >= 60;
    }

    public boolean isRottenTomatoesFanFresh()
    {
        return rottenTomatoesFanScore >= 60;
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        provider = microdatapropertyresolver.fetchString("provider");
        com.comcast.cim.microdata.model.MicrodataItem microdataitem = microdatapropertyresolver.fetchItem("attributes");
        if (microdataitem != null)
        {
            microdatapropertyresolver = microdatapropertyresolver.copy(microdataitem);
            rottenTomatoesFanScore = microdatapropertyresolver.fetchOptionalInt("urnrtfanSummaryScore", -1);
            rottenTomatoesCriticScore = microdatapropertyresolver.fetchOptionalInt("urnrtcriticSummaryScore", -1);
            commonSenseMediaTargetAge = microdatapropertyresolver.fetchOptionalInt("urncsmtargetAge", -1);
        }
    }
}
