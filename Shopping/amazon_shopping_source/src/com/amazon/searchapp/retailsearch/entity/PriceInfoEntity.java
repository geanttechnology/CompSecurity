// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AudienceRating;
import com.amazon.searchapp.retailsearch.model.Availability;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Ratings;
import com.amazon.searchapp.retailsearch.model.Shipping;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PriceInfoEntity extends RetailSearchEntity
    implements PriceInfo
{

    private Link appLink;
    private AudienceRating audienceRating;
    private Availability availability;
    private String issuePrice;
    private Link link;
    private String listPrice;
    private Link map;
    private List marketplaceLabel;
    private long offerCount;
    private List postLinkStyleText;
    private String postLinkText;
    private List preLinkStyleText;
    private String preLinkText;
    private String price;
    private Ratings ratings;
    private Shipping shipping;
    private List styledLabel;
    private String unitPrice;

    public PriceInfoEntity()
    {
    }

    public Link getAppLink()
    {
        return appLink;
    }

    public AudienceRating getAudienceRating()
    {
        return audienceRating;
    }

    public Availability getAvailability()
    {
        return availability;
    }

    public String getIssuePrice()
    {
        return issuePrice;
    }

    public Link getLink()
    {
        return link;
    }

    public String getListPrice()
    {
        return listPrice;
    }

    public Link getMap()
    {
        return map;
    }

    public List getMarketplaceLabel()
    {
        return marketplaceLabel;
    }

    public long getOfferCount()
    {
        return offerCount;
    }

    public List getPostLinkStyleText()
    {
        return postLinkStyleText;
    }

    public String getPostLinkText()
    {
        return postLinkText;
    }

    public List getPreLinkStyleText()
    {
        return preLinkStyleText;
    }

    public String getPreLinkText()
    {
        return preLinkText;
    }

    public String getPrice()
    {
        return price;
    }

    public Ratings getRatings()
    {
        return ratings;
    }

    public Shipping getShipping()
    {
        return shipping;
    }

    public List getStyledLabel()
    {
        return styledLabel;
    }

    public String getUnitPrice()
    {
        return unitPrice;
    }

    public void setAppLink(Link link1)
    {
        appLink = link1;
    }

    public void setAudienceRating(AudienceRating audiencerating)
    {
        audienceRating = audiencerating;
    }

    public void setAvailability(Availability availability1)
    {
        availability = availability1;
    }

    public void setIssuePrice(String s)
    {
        issuePrice = s;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setListPrice(String s)
    {
        listPrice = s;
    }

    public void setMap(Link link1)
    {
        map = link1;
    }

    public void setMarketplaceLabel(List list)
    {
        marketplaceLabel = list;
    }

    public void setOfferCount(long l)
    {
        offerCount = l;
    }

    public void setPostLinkStyleText(List list)
    {
        postLinkStyleText = list;
    }

    public void setPostLinkText(String s)
    {
        postLinkText = s;
    }

    public void setPreLinkStyleText(List list)
    {
        preLinkStyleText = list;
    }

    public void setPreLinkText(String s)
    {
        preLinkText = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setRatings(Ratings ratings1)
    {
        ratings = ratings1;
    }

    public void setShipping(Shipping shipping1)
    {
        shipping = shipping1;
    }

    public void setStyledLabel(List list)
    {
        styledLabel = list;
    }

    public void setUnitPrice(String s)
    {
        unitPrice = s;
    }
}
