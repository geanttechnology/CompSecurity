// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            BiddingDataManager

protected static final class url
{

    public final int lruSize;
    public final String url;

    public String toString()
    {
        return (new StringBuilder()).append("ImageRequestParams [lruSize=").append(lruSize).append(", url=").append(url).append("]").toString();
    }

    public (int i, String s)
    {
        if (BiddingDataManager.access$100())
        {
            lruSize = 0;
        } else
        {
            lruSize = i;
        }
        url = s;
    }
}
