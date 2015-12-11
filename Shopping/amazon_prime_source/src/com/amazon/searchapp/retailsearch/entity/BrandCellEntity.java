// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.BrandCell;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Link;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class BrandCellEntity extends RetailSearchEntity
    implements BrandCell
{

    private Image image;
    private Link link;
    private boolean selected;

    public BrandCellEntity()
    {
    }

    public Image getImage()
    {
        return image;
    }

    public Link getLink()
    {
        return link;
    }

    public boolean getSelected()
    {
        return selected;
    }

    public void setImage(Image image1)
    {
        image = image1;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }
}
