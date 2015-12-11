// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class FeatureStateResponse
{

    private List featureStates;
    private String sessionId;

    public FeatureStateResponse()
    {
    }

    public List getFeatureStates()
    {
        return featureStates;
    }

    public void setFeatureStates(List list)
    {
        featureStates = list;
    }

    public void setSessionId(String s)
    {
        sessionId = s;
    }
}
