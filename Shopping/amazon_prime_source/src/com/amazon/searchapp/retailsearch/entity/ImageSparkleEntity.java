// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AppIntent;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.ImageSparkle;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ImageSparkleEntity extends RetailSearchEntity
    implements ImageSparkle
{

    private AppIntent action;
    private String altText;
    private String id;
    private Image image;
    private String url;

    public ImageSparkleEntity()
    {
    }

    public AppIntent getAction()
    {
        return action;
    }

    public String getAltText()
    {
        return altText;
    }

    public String getId()
    {
        return id;
    }

    public Image getImage()
    {
        return image;
    }

    public String getUrl()
    {
        return url;
    }

    public void setAction(AppIntent appintent)
    {
        action = appintent;
    }

    public void setAltText(String s)
    {
        altText = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setImage(Image image1)
    {
        image = image1;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
