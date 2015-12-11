// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

private static class isRaODeal
{

    private final int index;
    private final boolean isRaODeal;
    private final String nstChannel;
    private final String productType;
    private final String remoteId;

    public int getIndex()
    {
        return index;
    }

    public String getNstChannel()
    {
        return nstChannel;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getRemoteId()
    {
        return remoteId;
    }

    public boolean isRaODeal()
    {
        return isRaODeal;
    }


    public (String s, String s1, int i, String s2, boolean flag)
    {
        nstChannel = s;
        remoteId = s1;
        index = i;
        productType = s2;
        isRaODeal = flag;
    }
}
