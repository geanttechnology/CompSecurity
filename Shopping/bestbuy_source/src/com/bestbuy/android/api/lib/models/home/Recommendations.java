// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;
import java.util.List;

public class Recommendations
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x7a236d10c11013f5L;
    private List recommendations;

    public Recommendations()
    {
    }

    public List getRecommendations()
    {
        return recommendations;
    }

    public void setRecommendations(List list)
    {
        recommendations = list;
    }
}
