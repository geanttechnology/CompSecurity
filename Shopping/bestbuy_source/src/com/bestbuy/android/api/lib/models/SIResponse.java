// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.SI;
import gu;

public class SIResponse
    implements gu
{

    private static final long serialVersionUID = 1L;
    private SI si;

    public SIResponse()
    {
    }

    public SI getSi()
    {
        return si;
    }

    public void setSi(SI si1)
    {
        si = si1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [si = ").append(si).append("]").toString();
    }
}
