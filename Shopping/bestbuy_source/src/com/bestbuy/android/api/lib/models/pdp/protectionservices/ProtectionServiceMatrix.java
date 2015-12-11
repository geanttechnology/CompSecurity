// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.protectionservices;

import java.util.List;

public class ProtectionServiceMatrix
{

    private static final long serialVersionUID = 1L;
    private List commonFeatures;
    private List conditionalFeatures;
    private List terms;

    public ProtectionServiceMatrix()
    {
    }

    public List getCommonFeatures()
    {
        return commonFeatures;
    }

    public List getConditionalFeatures()
    {
        return conditionalFeatures;
    }

    public List getTerms()
    {
        return terms;
    }

    public void setCommonFeatures(List list)
    {
        commonFeatures = list;
    }

    public void setConditionalFeatures(List list)
    {
        conditionalFeatures = list;
    }

    public void setTerms(List list)
    {
        terms = list;
    }
}
