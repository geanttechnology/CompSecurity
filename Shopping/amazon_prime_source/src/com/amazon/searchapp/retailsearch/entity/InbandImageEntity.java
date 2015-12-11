// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.InbandImage;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class InbandImageEntity extends RetailSearchEntity
    implements InbandImage
{

    private String base64EncodedImage;
    private String contentType;
    private String url;

    public InbandImageEntity()
    {
    }

    public String getBase64EncodedImage()
    {
        return base64EncodedImage;
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getUrl()
    {
        return url;
    }

    public void setBase64EncodedImage(String s)
    {
        base64EncodedImage = s;
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
