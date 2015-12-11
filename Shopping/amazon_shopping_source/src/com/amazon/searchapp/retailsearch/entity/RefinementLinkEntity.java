// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.RefinementLink;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RefinementLinkEntity extends RetailSearchEntity
    implements RefinementLink
{

    private boolean availability;
    private String browseUrl;
    private List categories;
    private long count;
    private String id;
    private boolean selected;
    private List styleText;
    private String text;
    private String url;

    public RefinementLinkEntity()
    {
    }

    public boolean getAvailability()
    {
        return availability;
    }

    public String getBrowseUrl()
    {
        return browseUrl;
    }

    public List getCategories()
    {
        return categories;
    }

    public long getCount()
    {
        return count;
    }

    public String getId()
    {
        return id;
    }

    public boolean getSelected()
    {
        return selected;
    }

    public List getStyleText()
    {
        return styleText;
    }

    public String getText()
    {
        return text;
    }

    public String getUrl()
    {
        return url;
    }

    public void setAvailability(boolean flag)
    {
        availability = flag;
    }

    public void setBrowseUrl(String s)
    {
        browseUrl = s;
    }

    public void setCategories(List list)
    {
        categories = list;
    }

    public void setCount(long l)
    {
        count = l;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setStyleText(List list)
    {
        styleText = list;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
