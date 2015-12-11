// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class FeatureExperience
{

    private Integer cacheStamp;
    private String featureName;
    private String treatment;

    public FeatureExperience()
    {
    }

    public Integer getCacheStamp()
    {
        return cacheStamp;
    }

    public String getFeatureName()
    {
        return featureName;
    }

    public String getTreatment()
    {
        return treatment;
    }

    public void setCacheStamp(Integer integer)
    {
        cacheStamp = integer;
    }

    public void setFeatureName(String s)
    {
        featureName = s;
    }

    public void setTreatment(String s)
    {
        treatment = s;
    }
}
