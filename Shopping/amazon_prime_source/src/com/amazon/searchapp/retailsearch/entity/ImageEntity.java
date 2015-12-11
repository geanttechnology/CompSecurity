// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Image;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ImageEntity extends RetailSearchEntity
    implements Image
{

    private String altText;
    private String hiresUrl;
    private String url;
    private String videoUrl;

    public ImageEntity()
    {
    }

    public String getAltText()
    {
        return altText;
    }

    public String getHiresUrl()
    {
        return hiresUrl;
    }

    public String getUrl()
    {
        return url;
    }

    public String getVideoUrl()
    {
        return videoUrl;
    }

    public void setAltText(String s)
    {
        altText = s;
    }

    public void setHiresUrl(String s)
    {
        hiresUrl = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setVideoUrl(String s)
    {
        videoUrl = s;
    }
}
