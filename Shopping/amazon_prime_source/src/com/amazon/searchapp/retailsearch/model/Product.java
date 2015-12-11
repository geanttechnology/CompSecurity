// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            AirstreamProduct, AudienceRating, Availability, BestSeller, 
//            NativeBadge, Decorations, DynamicProductContent, Hidden, 
//            Image, Link, Merchant, Movie, 
//            NewerVersion, NonPrimeOffer, PantryBoxFill, Points, 
//            Prices, Ratings, Shipping, TopNewRelease, 
//            TradeIn

public interface Product
{

    public abstract List getActionButtons();

    public abstract List getActors();

    public abstract String getAgeRange();

    public abstract AirstreamProduct getAirstream();

    public abstract List getAltImages();

    public abstract String getAsin();

    public abstract AudienceRating getAudienceRating();

    public abstract List getAuthors();

    public abstract Availability getAvailability();

    public abstract BestSeller getBestSeller();

    public abstract String getBrandName();

    public abstract String getByLine();

    public abstract boolean getClosedCaption();

    public abstract NativeBadge getCoupon();

    public abstract Decorations getDecorations();

    public abstract List getDescription();

    public abstract List getDirectors();

    public abstract DynamicProductContent getDynamicContent();

    public abstract String getGroup();

    public abstract NativeBadge getHeaderBadge();

    public abstract boolean getHeroASIN();

    public abstract Hidden getHidden();

    public abstract boolean getHideAdultProduct();

    public abstract String getHtmlMessage();

    public abstract List getIcons();

    public abstract Image getImage();

    public abstract List getImageGallery();

    public abstract List getInbandImages();

    public abstract String getIssueInfo();

    public abstract Link getLink();

    public abstract Merchant getMerchant();

    public abstract String getMerchantSku();

    public abstract Movie getMovie();

    public abstract NewerVersion getNewerVersion();

    public abstract NonPrimeOffer getNonPrimeOffer();

    public abstract int getNumVisibleOffers();

    public abstract String getOfferId();

    public abstract List getOffers();

    public abstract boolean getOneClickBuyable();

    public abstract PantryBoxFill getPantryBoxFill();

    public abstract String getParentAsin();

    public abstract Points getPoints();

    public abstract int getPosition();

    public abstract Prices getPrices();

    public abstract List getPromotions();

    public abstract String getPurchasedDate();

    public abstract Ratings getRatings();

    public abstract String getReleaseDate();

    public abstract Shipping getShipping();

    public abstract boolean getSims();

    public abstract String getSynopsis();

    public abstract String getTitle();

    public abstract TopNewRelease getTopNewRelease();

    public abstract TradeIn getTradeIn();

    public abstract String getTruncatedTitle();

    public abstract String getTvSeasonAsin();

    public abstract String getType();

    public abstract String getTypeName();

    public abstract String getUnsupportedMessage();

    public abstract List getVariations();

    public abstract void setActionButtons(List list);

    public abstract void setActors(List list);

    public abstract void setAgeRange(String s);

    public abstract void setAirstream(AirstreamProduct airstreamproduct);

    public abstract void setAltImages(List list);

    public abstract void setAsin(String s);

    public abstract void setAudienceRating(AudienceRating audiencerating);

    public abstract void setAuthors(List list);

    public abstract void setAvailability(Availability availability);

    public abstract void setBestSeller(BestSeller bestseller);

    public abstract void setBrandName(String s);

    public abstract void setByLine(String s);

    public abstract void setClosedCaption(boolean flag);

    public abstract void setCoupon(NativeBadge nativebadge);

    public abstract void setDecorations(Decorations decorations);

    public abstract void setDescription(List list);

    public abstract void setDirectors(List list);

    public abstract void setDynamicContent(DynamicProductContent dynamicproductcontent);

    public abstract void setGroup(String s);

    public abstract void setHeaderBadge(NativeBadge nativebadge);

    public abstract void setHeroASIN(boolean flag);

    public abstract void setHidden(Hidden hidden);

    public abstract void setHideAdultProduct(boolean flag);

    public abstract void setHtmlMessage(String s);

    public abstract void setIcons(List list);

    public abstract void setImage(Image image);

    public abstract void setImageGallery(List list);

    public abstract void setInbandImages(List list);

    public abstract void setIssueInfo(String s);

    public abstract void setLink(Link link);

    public abstract void setMerchant(Merchant merchant);

    public abstract void setMerchantSku(String s);

    public abstract void setMovie(Movie movie);

    public abstract void setNewerVersion(NewerVersion newerversion);

    public abstract void setNonPrimeOffer(NonPrimeOffer nonprimeoffer);

    public abstract void setNumVisibleOffers(int i);

    public abstract void setOfferId(String s);

    public abstract void setOffers(List list);

    public abstract void setOneClickBuyable(boolean flag);

    public abstract void setPantryBoxFill(PantryBoxFill pantryboxfill);

    public abstract void setParentAsin(String s);

    public abstract void setPoints(Points points);

    public abstract void setPosition(int i);

    public abstract void setPrices(Prices prices);

    public abstract void setPromotions(List list);

    public abstract void setPurchasedDate(String s);

    public abstract void setRatings(Ratings ratings);

    public abstract void setReleaseDate(String s);

    public abstract void setShipping(Shipping shipping);

    public abstract void setSims(boolean flag);

    public abstract void setSynopsis(String s);

    public abstract void setTitle(String s);

    public abstract void setTopNewRelease(TopNewRelease topnewrelease);

    public abstract void setTradeIn(TradeIn tradein);

    public abstract void setTruncatedTitle(String s);

    public abstract void setTvSeasonAsin(String s);

    public abstract void setType(String s);

    public abstract void setTypeName(String s);

    public abstract void setUnsupportedMessage(String s);

    public abstract void setVariations(List list);
}
