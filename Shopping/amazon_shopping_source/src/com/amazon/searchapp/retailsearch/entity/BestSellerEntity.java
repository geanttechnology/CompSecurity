// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.BestSeller;
import com.amazon.searchapp.retailsearch.model.Link;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class BestSellerEntity extends RetailSearchEntity
    implements BestSeller
{

    private String badgeAssetId;
    private String label;
    private Link link;
    private String node;
    private int rank;

    public BestSellerEntity()
    {
    }

    public String getBadgeAssetId()
    {
        return badgeAssetId;
    }

    public String getLabel()
    {
        return label;
    }

    public Link getLink()
    {
        return link;
    }

    public String getNode()
    {
        return node;
    }

    public int getRank()
    {
        return rank;
    }

    public void setBadgeAssetId(String s)
    {
        badgeAssetId = s;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setNode(String s)
    {
        node = s;
    }

    public void setRank(int i)
    {
        rank = i;
    }
}
