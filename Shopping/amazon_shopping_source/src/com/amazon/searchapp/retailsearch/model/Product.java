// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            AudienceRating, Availability, BestSeller, DynamicProductContent, 
//            Hidden, Image, Link, Merchant, 
//            Movie, NewerVersion, NonPrimeOffer, PantryBoxFill, 
//            Points, Prices, Ratings, Shipping, 
//            TradeIn

public interface Product
{

    public abstract List getActors();

    public abstract String getAgeRange();

    public abstract List getAltImages();

    public abstract String getAsin();

    public abstract AudienceRating getAudienceRating();

    public abstract List getAuthors();

    public abstract Availability getAvailability();

    public abstract BestSeller getBestSeller();

    public abstract String getBrandName();

    public abstract String getByLine();

    public abstract boolean getClosedCaption();

    public abstract List getDirectors();

    public abstract DynamicProductContent getDynamicContent();

    public abstract String getGroup();

    public abstract boolean getHeroASIN();

    public abstract Hidden getHidden();

    public abstract boolean getHideAdultProduct();

    public abstract String getHtmlMessage();

    public abstract List getIcons();

    public abstract Image getImage();

    public abstract List getImageGallery();

    public abstract String getIssueInfo();

    public abstract Link getLink();

    public abstract Merchant getMerchant();

    public abstract Movie getMovie();

    public abstract NewerVersion getNewerVersion();

    public abstract NonPrimeOffer getNonPrimeOffer();

    public abstract String getOfferId();

    public abstract PantryBoxFill getPantryBoxFill();

    public abstract Points getPoints();

    public abstract int getPosition();

    public abstract Prices getPrices();

    public abstract List getPromotions();

    public abstract Ratings getRatings();

    public abstract String getReleaseDate();

    public abstract Shipping getShipping();

    public abstract String getSynopsis();

    public abstract String getTitle();

    public abstract TradeIn getTradeIn();

    public abstract String getTruncatedTitle();

    public abstract String getTvSeasonAsin();

    public abstract String getType();

    public abstract String getTypeName();

    public abstract String getUnsupportedMessage();

    public abstract List getVariations();
}
