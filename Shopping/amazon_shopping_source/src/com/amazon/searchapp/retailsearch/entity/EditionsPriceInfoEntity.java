// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AudienceRating;
import com.amazon.searchapp.retailsearch.model.Availability;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.KindleUnlimited;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Ratings;
import com.amazon.searchapp.retailsearch.model.Shipping;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class EditionsPriceInfoEntity extends RetailSearchEntity
    implements EditionsPriceInfo
{

    private String asin;
    private AudienceRating audienceRating;
    private Availability availability;
    private String issuePrice;
    private KindleUnlimited kindleUnlimited;
    private Link link;
    private String listPrice;
    private Link map;
    private Link marketplaceAnyPriceLink;
    private Link marketplaceCollectiblePriceLink;
    private List marketplaceLabel;
    private Link marketplaceNewPriceLink;
    private Link marketplaceRefurbishedPriceLink;
    private Link marketplaceUsedPriceLink;
    private long offerCount;
    private String postLinkText;
    private String preLinkText;
    private String price;
    private Ratings ratings;
    private Shipping shipping;
    private String unitPrice;

    public EditionsPriceInfoEntity()
    {
    }

    public String getAsin()
    {
        return asin;
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

    public KindleUnlimited getKindleUnlimited()
    {
        return kindleUnlimited;
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

    public Link getMarketplaceAnyPriceLink()
    {
        return marketplaceAnyPriceLink;
    }

    public Link getMarketplaceCollectiblePriceLink()
    {
        return marketplaceCollectiblePriceLink;
    }

    public List getMarketplaceLabel()
    {
        return marketplaceLabel;
    }

    public Link getMarketplaceNewPriceLink()
    {
        return marketplaceNewPriceLink;
    }

    public Link getMarketplaceRefurbishedPriceLink()
    {
        return marketplaceRefurbishedPriceLink;
    }

    public Link getMarketplaceUsedPriceLink()
    {
        return marketplaceUsedPriceLink;
    }

    public long getOfferCount()
    {
        return offerCount;
    }

    public String getPostLinkText()
    {
        return postLinkText;
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

    public String getUnitPrice()
    {
        return unitPrice;
    }

    public void setAsin(String s)
    {
        asin = s;
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

    public void setKindleUnlimited(KindleUnlimited kindleunlimited)
    {
        kindleUnlimited = kindleunlimited;
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

    public void setMarketplaceAnyPriceLink(Link link1)
    {
        marketplaceAnyPriceLink = link1;
    }

    public void setMarketplaceCollectiblePriceLink(Link link1)
    {
        marketplaceCollectiblePriceLink = link1;
    }

    public void setMarketplaceLabel(List list)
    {
        marketplaceLabel = list;
    }

    public void setMarketplaceNewPriceLink(Link link1)
    {
        marketplaceNewPriceLink = link1;
    }

    public void setMarketplaceRefurbishedPriceLink(Link link1)
    {
        marketplaceRefurbishedPriceLink = link1;
    }

    public void setMarketplaceUsedPriceLink(Link link1)
    {
        marketplaceUsedPriceLink = link1;
    }

    public void setOfferCount(long l)
    {
        offerCount = l;
    }

    public void setPostLinkText(String s)
    {
        postLinkText = s;
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

    public void setUnitPrice(String s)
    {
        unitPrice = s;
    }
}
