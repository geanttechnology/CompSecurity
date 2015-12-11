// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.rtm:
//            RtmContent

public static class 
    implements Serializable
{

    public int adSizeHeight;
    public int adSizeWidth;
    public String adUnitId;
    public URL externalLink;
    public String externalLinkName;
    public String formattedPriceString;
    public String formattedStrikethroughPrice;
    public boolean isPla;
    public ArrayList parameters;
    public String ppid;
    public String retailerName;
    public String shippingInfo;
    public String subTitle;
    public URL thumbnailURL;
    public String title;
    public String trackingClickID;
    public URL trackingURL;
    public boolean userTargeted;

    public ()
    {
    }
}
