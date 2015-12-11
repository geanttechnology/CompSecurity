// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AudienceRating;
import com.amazon.searchapp.retailsearch.model.Availability;
import com.amazon.searchapp.retailsearch.model.BestSeller;
import com.amazon.searchapp.retailsearch.model.DynamicProductContent;
import com.amazon.searchapp.retailsearch.model.Hidden;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Merchant;
import com.amazon.searchapp.retailsearch.model.Movie;
import com.amazon.searchapp.retailsearch.model.NewerVersion;
import com.amazon.searchapp.retailsearch.model.NonPrimeOffer;
import com.amazon.searchapp.retailsearch.model.PantryBoxFill;
import com.amazon.searchapp.retailsearch.model.Points;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.Ratings;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.TradeIn;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ProductEntity extends RetailSearchEntity
    implements Product
{

    private List actors;
    private String ageRange;
    private List altImages;
    private String asin;
    private AudienceRating audienceRating;
    private List authors;
    private Availability availability;
    private BestSeller bestSeller;
    private String brandName;
    private String byLine;
    private boolean closedCaption;
    private List directors;
    private DynamicProductContent dynamicContent;
    private String group;
    private boolean heroASIN;
    private Hidden hidden;
    private boolean hideAdultProduct;
    private String htmlMessage;
    private List icons;
    private Image image;
    private List imageGallery;
    private String issueInfo;
    private Link link;
    private Merchant merchant;
    private Movie movie;
    private NewerVersion newerVersion;
    private NonPrimeOffer nonPrimeOffer;
    private String offerId;
    private PantryBoxFill pantryBoxFill;
    private Points points;
    private int position;
    private Prices prices;
    private List promotions;
    private Ratings ratings;
    private String releaseDate;
    private Shipping shipping;
    private String synopsis;
    private String title;
    private TradeIn tradeIn;
    private String truncatedTitle;
    private String tvSeasonAsin;
    private String type;
    private String typeName;
    private String unsupportedMessage;
    private List variations;

    public ProductEntity()
    {
    }

    public List getActors()
    {
        return actors;
    }

    public String getAgeRange()
    {
        return ageRange;
    }

    public List getAltImages()
    {
        return altImages;
    }

    public String getAsin()
    {
        return asin;
    }

    public AudienceRating getAudienceRating()
    {
        return audienceRating;
    }

    public List getAuthors()
    {
        return authors;
    }

    public Availability getAvailability()
    {
        return availability;
    }

    public BestSeller getBestSeller()
    {
        return bestSeller;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public String getByLine()
    {
        return byLine;
    }

    public boolean getClosedCaption()
    {
        return closedCaption;
    }

    public List getDirectors()
    {
        return directors;
    }

    public DynamicProductContent getDynamicContent()
    {
        return dynamicContent;
    }

    public String getGroup()
    {
        return group;
    }

    public boolean getHeroASIN()
    {
        return heroASIN;
    }

    public Hidden getHidden()
    {
        return hidden;
    }

    public boolean getHideAdultProduct()
    {
        return hideAdultProduct;
    }

    public String getHtmlMessage()
    {
        return htmlMessage;
    }

    public List getIcons()
    {
        return icons;
    }

    public Image getImage()
    {
        return image;
    }

    public List getImageGallery()
    {
        return imageGallery;
    }

    public String getIssueInfo()
    {
        return issueInfo;
    }

    public Link getLink()
    {
        return link;
    }

    public Merchant getMerchant()
    {
        return merchant;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public NewerVersion getNewerVersion()
    {
        return newerVersion;
    }

    public NonPrimeOffer getNonPrimeOffer()
    {
        return nonPrimeOffer;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public PantryBoxFill getPantryBoxFill()
    {
        return pantryBoxFill;
    }

    public Points getPoints()
    {
        return points;
    }

    public int getPosition()
    {
        return position;
    }

    public Prices getPrices()
    {
        return prices;
    }

    public List getPromotions()
    {
        return promotions;
    }

    public Ratings getRatings()
    {
        return ratings;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public Shipping getShipping()
    {
        return shipping;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public String getTitle()
    {
        return title;
    }

    public TradeIn getTradeIn()
    {
        return tradeIn;
    }

    public String getTruncatedTitle()
    {
        return truncatedTitle;
    }

    public String getTvSeasonAsin()
    {
        return tvSeasonAsin;
    }

    public String getType()
    {
        return type;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public String getUnsupportedMessage()
    {
        return unsupportedMessage;
    }

    public List getVariations()
    {
        return variations;
    }

    public void setActors(List list)
    {
        actors = list;
    }

    public void setAgeRange(String s)
    {
        ageRange = s;
    }

    public void setAltImages(List list)
    {
        altImages = list;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setAudienceRating(AudienceRating audiencerating)
    {
        audienceRating = audiencerating;
    }

    public void setAuthors(List list)
    {
        authors = list;
    }

    public void setAvailability(Availability availability1)
    {
        availability = availability1;
    }

    public void setBestSeller(BestSeller bestseller)
    {
        bestSeller = bestseller;
    }

    public void setBrandName(String s)
    {
        brandName = s;
    }

    public void setByLine(String s)
    {
        byLine = s;
    }

    public void setClosedCaption(boolean flag)
    {
        closedCaption = flag;
    }

    public void setDirectors(List list)
    {
        directors = list;
    }

    public void setDynamicContent(DynamicProductContent dynamicproductcontent)
    {
        dynamicContent = dynamicproductcontent;
    }

    public void setGroup(String s)
    {
        group = s;
    }

    public void setHeroASIN(boolean flag)
    {
        heroASIN = flag;
    }

    public void setHidden(Hidden hidden1)
    {
        hidden = hidden1;
    }

    public void setHideAdultProduct(boolean flag)
    {
        hideAdultProduct = flag;
    }

    public void setHtmlMessage(String s)
    {
        htmlMessage = s;
    }

    public void setIcons(List list)
    {
        icons = list;
    }

    public void setImage(Image image1)
    {
        image = image1;
    }

    public void setImageGallery(List list)
    {
        imageGallery = list;
    }

    public void setIssueInfo(String s)
    {
        issueInfo = s;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setMerchant(Merchant merchant1)
    {
        merchant = merchant1;
    }

    public void setMovie(Movie movie1)
    {
        movie = movie1;
    }

    public void setNewerVersion(NewerVersion newerversion)
    {
        newerVersion = newerversion;
    }

    public void setNonPrimeOffer(NonPrimeOffer nonprimeoffer)
    {
        nonPrimeOffer = nonprimeoffer;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setPantryBoxFill(PantryBoxFill pantryboxfill)
    {
        pantryBoxFill = pantryboxfill;
    }

    public void setPoints(Points points1)
    {
        points = points1;
    }

    public void setPosition(int i)
    {
        position = i;
    }

    public void setPrices(Prices prices1)
    {
        prices = prices1;
    }

    public void setPromotions(List list)
    {
        promotions = list;
    }

    public void setRatings(Ratings ratings1)
    {
        ratings = ratings1;
    }

    public void setReleaseDate(String s)
    {
        releaseDate = s;
    }

    public void setShipping(Shipping shipping1)
    {
        shipping = shipping1;
    }

    public void setSynopsis(String s)
    {
        synopsis = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setTradeIn(TradeIn tradein)
    {
        tradeIn = tradein;
    }

    public void setTruncatedTitle(String s)
    {
        truncatedTitle = s;
    }

    public void setTvSeasonAsin(String s)
    {
        tvSeasonAsin = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setTypeName(String s)
    {
        typeName = s;
    }

    public void setUnsupportedMessage(String s)
    {
        unsupportedMessage = s;
    }

    public void setVariations(List list)
    {
        variations = list;
    }
}
