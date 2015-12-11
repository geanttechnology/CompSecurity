// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.TopNewRelease;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class TopNewReleaseEntity extends RetailSearchEntity
    implements TopNewRelease
{

    private String badgeAssetId;
    private String badgeLabel;
    private String category;
    private String listId;
    private Link listLink;
    private int rank;

    public TopNewReleaseEntity()
    {
    }

    public String getBadgeAssetId()
    {
        return badgeAssetId;
    }

    public String getBadgeLabel()
    {
        return badgeLabel;
    }

    public String getCategory()
    {
        return category;
    }

    public String getListId()
    {
        return listId;
    }

    public Link getListLink()
    {
        return listLink;
    }

    public int getRank()
    {
        return rank;
    }

    public void setBadgeAssetId(String s)
    {
        badgeAssetId = s;
    }

    public void setBadgeLabel(String s)
    {
        badgeLabel = s;
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setListId(String s)
    {
        listId = s;
    }

    public void setListLink(Link link)
    {
        listLink = link;
    }

    public void setRank(int i)
    {
        rank = i;
    }
}
