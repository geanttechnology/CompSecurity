// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.blueshirt;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.SI;
import gu;
import java.io.Serializable;

public class TimeSlotResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SI si;

    public TimeSlotResponse()
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
