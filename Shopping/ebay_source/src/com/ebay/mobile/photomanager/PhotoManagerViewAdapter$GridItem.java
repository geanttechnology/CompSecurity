// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import com.ebay.common.net.api.eps.GetImage;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerViewAdapter, PictureUrl

private class thumbUrl
    implements Comparable
{

    boolean enabled;
    boolean isAddButton;
    boolean isStockPhoto;
    int orderDisplay;
    final PhotoManagerViewAdapter this$0;
    String thumbUrl;
    String url;

    public int compareTo(thumbUrl thumburl)
    {
        if (thumburl.isAddButton)
        {
            return -1;
        }
        return !thumburl.isStockPhoto ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    ()
    {
        this$0 = PhotoManagerViewAdapter.this;
        super();
        isAddButton = false;
        isStockPhoto = false;
        enabled = true;
        orderDisplay = 0;
    }

    orderDisplay(PictureUrl pictureurl)
    {
        this$0 = PhotoManagerViewAdapter.this;
        super();
        isAddButton = false;
        isStockPhoto = false;
        enabled = true;
        orderDisplay = 0;
        url = pictureurl.url;
        enabled = pictureurl.enabled;
        isStockPhoto = pictureurl.stockPhoto;
        thumbUrl = GetImage.convertUrl(url, com.ebay.common.net.api.eps..url);
    }

    url(String s)
    {
        this$0 = PhotoManagerViewAdapter.this;
        super();
        isAddButton = false;
        isStockPhoto = false;
        enabled = true;
        orderDisplay = 0;
        url = s;
        thumbUrl = GetImage.convertUrl(s, com.ebay.common.net.api.eps..thumbUrl);
    }
}
