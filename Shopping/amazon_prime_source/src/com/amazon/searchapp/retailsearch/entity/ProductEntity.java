// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AirstreamProduct;
import com.amazon.searchapp.retailsearch.model.AudienceRating;
import com.amazon.searchapp.retailsearch.model.Availability;
import com.amazon.searchapp.retailsearch.model.BestSeller;
import com.amazon.searchapp.retailsearch.model.Decorations;
import com.amazon.searchapp.retailsearch.model.DynamicProductContent;
import com.amazon.searchapp.retailsearch.model.Hidden;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Merchant;
import com.amazon.searchapp.retailsearch.model.Movie;
import com.amazon.searchapp.retailsearch.model.NativeBadge;
import com.amazon.searchapp.retailsearch.model.NewerVersion;
import com.amazon.searchapp.retailsearch.model.NonPrimeOffer;
import com.amazon.searchapp.retailsearch.model.PantryBoxFill;
import com.amazon.searchapp.retailsearch.model.Points;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.Ratings;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.TopNewRelease;
import com.amazon.searchapp.retailsearch.model.TradeIn;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ProductEntity extends RetailSearchEntity
    implements Product
{

    private List actionButtons;
    private List actors;
    private String ageRange;
    private AirstreamProduct airstream;
    private List altImages;
    private String asin;
    private AudienceRating audienceRating;
    private List authors;
    private Availability availability;
    private BestSeller bestSeller;
    private String brandName;
    private String byLine;
    private boolean closedCaption;
    private NativeBadge coupon;
    private Decorations decorations;
    private List description;
    private List directors;
    private DynamicProductContent dynamicContent;
    private String group;
    private NativeBadge headerBadge;
    private boolean heroASIN;
    private Hidden hidden;
    private boolean hideAdultProduct;
    private String htmlMessage;
    private List icons;
    private Image image;
    private List imageGallery;
    private List inbandImages;
    private String issueInfo;
    private Link link;
    private Merchant merchant;
    private String merchantSku;
    private Movie movie;
    private NewerVersion newerVersion;
    private NonPrimeOffer nonPrimeOffer;
    private int numVisibleOffers;
    private String offerId;
    private List offers;
    private boolean oneClickBuyable;
    private PantryBoxFill pantryBoxFill;
    private String parentAsin;
    private Points points;
    private int position;
    private Prices prices;
    private List promotions;
    private String purchasedDate;
    private Ratings ratings;
    private String releaseDate;
    private Shipping shipping;
    private boolean sims;
    private String synopsis;
    private String title;
    private TopNewRelease topNewRelease;
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

    public List getActionButtons()
    {
        return actionButtons;
    }

    public List getActors()
    {
        return actors;
    }

    public String getAgeRange()
    {
        return ageRange;
    }

    public AirstreamProduct getAirstream()
    {
        return airstream;
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

    public NativeBadge getCoupon()
    {
        return coupon;
    }

    public Decorations getDecorations()
    {
        return decorations;
    }

    public List getDescription()
    {
        return description;
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

    public NativeBadge getHeaderBadge()
    {
        return headerBadge;
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

    public List getInbandImages()
    {
        return inbandImages;
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

    public String getMerchantSku()
    {
        return merchantSku;
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

    public int getNumVisibleOffers()
    {
        return numVisibleOffers;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public List getOffers()
    {
        return offers;
    }

    public boolean getOneClickBuyable()
    {
        return oneClickBuyable;
    }

    public PantryBoxFill getPantryBoxFill()
    {
        return pantryBoxFill;
    }

    public String getParentAsin()
    {
        return parentAsin;
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

    public String getPurchasedDate()
    {
        return purchasedDate;
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

    public boolean getSims()
    {
        return sims;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public String getTitle()
    {
        return title;
    }

    public TopNewRelease getTopNewRelease()
    {
        return topNewRelease;
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

    public void setActionButtons(List list)
    {
        actionButtons = list;
    }

    public void setActors(List list)
    {
        actors = list;
    }

    public void setAgeRange(String s)
    {
        ageRange = s;
    }

    public void setAirstream(AirstreamProduct airstreamproduct)
    {
        airstream = airstreamproduct;
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

    public void setCoupon(NativeBadge nativebadge)
    {
        coupon = nativebadge;
    }

    public void setDecorations(Decorations decorations1)
    {
        decorations = decorations1;
    }

    public void setDescription(List list)
    {
        description = list;
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

    public void setHeaderBadge(NativeBadge nativebadge)
    {
        headerBadge = nativebadge;
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

    public void setInbandImages(List list)
    {
        inbandImages = list;
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

    public void setMerchantSku(String s)
    {
        merchantSku = s;
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

    public void setNumVisibleOffers(int i)
    {
        numVisibleOffers = i;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setOffers(List list)
    {
        offers = list;
    }

    public void setOneClickBuyable(boolean flag)
    {
        oneClickBuyable = flag;
    }

    public void setPantryBoxFill(PantryBoxFill pantryboxfill)
    {
        pantryBoxFill = pantryboxfill;
    }

    public void setParentAsin(String s)
    {
        parentAsin = s;
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

    public void setPurchasedDate(String s)
    {
        purchasedDate = s;
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

    public void setSims(boolean flag)
    {
        sims = flag;
    }

    public void setSynopsis(String s)
    {
        synopsis = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setTopNewRelease(TopNewRelease topnewrelease)
    {
        topNewRelease = topnewrelease;
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
