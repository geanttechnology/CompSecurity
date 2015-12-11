// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Sparkle;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SparkleEntity extends RetailSearchEntity
    implements Sparkle
{

    private String altText;
    private List description;
    private String id;
    private Image image;
    private List title;
    private String type;
    private String url;

    public SparkleEntity()
    {
    }

    public String getAltText()
    {
        return altText;
    }

    public List getDescription()
    {
        return description;
    }

    public String getId()
    {
        return id;
    }

    public Image getImage()
    {
        return image;
    }

    public List getTitle()
    {
        return title;
    }

    public String getType()
    {
        return type;
    }

    public String getUrl()
    {
        return url;
    }

    public void setAltText(String s)
    {
        altText = s;
    }

    public void setDescription(List list)
    {
        description = list;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setImage(Image image1)
    {
        image = image1;
    }

    public void setTitle(List list)
    {
        title = list;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
