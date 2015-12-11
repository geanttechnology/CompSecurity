// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpoffers;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpoffers:
//            SIOffers

public class PDPOffersParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SIOffers si;

    public PDPOffersParent()
    {
    }

    public SIOffers getSi()
    {
        return si;
    }

    public void setSi(SIOffers sioffers)
    {
        si = sioffers;
    }
}
