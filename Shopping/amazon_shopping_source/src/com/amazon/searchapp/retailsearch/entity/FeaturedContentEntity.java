// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.FeaturedContent;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class FeaturedContentEntity extends RetailSearchEntity
    implements FeaturedContent
{

    private List content;
    private String description;
    private int position;
    private int priority;
    private String style;
    private String title;

    public FeaturedContentEntity()
    {
    }

    public List getContent()
    {
        return content;
    }

    public String getDescription()
    {
        return description;
    }

    public int getPosition()
    {
        return position;
    }

    public int getPriority()
    {
        return priority;
    }

    public String getStyle()
    {
        return style;
    }

    public String getTitle()
    {
        return title;
    }

    public void setContent(List list)
    {
        content = list;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setPosition(int i)
    {
        position = i;
    }

    public void setPriority(int i)
    {
        priority = i;
    }

    public void setStyle(String s)
    {
        style = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
