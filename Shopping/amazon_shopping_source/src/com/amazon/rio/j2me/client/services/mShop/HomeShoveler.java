// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            UniversalLink

public class HomeShoveler
{

    private String clickStreamOrigin;
    private Integer displayType;
    private List items;
    private String itemsSubtitle;
    private UniversalLink moreLink;
    private String moreLinkText;
    private List seedItems;
    private String seedSubtitle;
    private String slotToken;
    private String title;

    public HomeShoveler()
    {
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public Integer getDisplayType()
    {
        return displayType;
    }

    public List getItems()
    {
        return items;
    }

    public UniversalLink getMoreLink()
    {
        return moreLink;
    }

    public String getMoreLinkText()
    {
        return moreLinkText;
    }

    public String getSlotToken()
    {
        return slotToken;
    }

    public String getTitle()
    {
        return title;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setDisplayType(Integer integer)
    {
        displayType = integer;
    }

    public void setItems(List list)
    {
        items = list;
    }

    public void setItemsSubtitle(String s)
    {
        itemsSubtitle = s;
    }

    public void setMoreLink(UniversalLink universallink)
    {
        moreLink = universallink;
    }

    public void setMoreLinkText(String s)
    {
        moreLinkText = s;
    }

    public void setSeedItems(List list)
    {
        seedItems = list;
    }

    public void setSeedSubtitle(String s)
    {
        seedSubtitle = s;
    }

    public void setSlotToken(String s)
    {
        slotToken = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
