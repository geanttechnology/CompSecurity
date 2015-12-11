// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class Feature
{

    private Integer cacheStamp;
    private String clientTreatmentPath;
    private String featureName;
    private Boolean sendTrigger;

    public Feature()
    {
    }

    public Integer getCacheStamp()
    {
        return cacheStamp;
    }

    public String getClientTreatmentPath()
    {
        return clientTreatmentPath;
    }

    public String getFeatureName()
    {
        return featureName;
    }

    public Boolean getSendTrigger()
    {
        return sendTrigger;
    }

    public void setCacheStamp(Integer integer)
    {
        cacheStamp = integer;
    }

    public void setClientTreatmentPath(String s)
    {
        clientTreatmentPath = s;
    }

    public void setFeatureName(String s)
    {
        featureName = s;
    }

    public void setSendTrigger(Boolean boolean1)
    {
        sendTrigger = boolean1;
    }
}
