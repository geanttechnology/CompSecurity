// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            SI

public class SummariesPriceBlockResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SI si;

    public SummariesPriceBlockResponse()
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
