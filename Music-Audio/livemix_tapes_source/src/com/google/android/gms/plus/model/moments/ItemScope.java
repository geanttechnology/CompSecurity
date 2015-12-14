// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope
    extends Freezable
{
    public static class Builder
    {

        private String mName;
        private String zzF;
        private String zzFz;
        private double zzaBD;
        private double zzaBE;
        private final Set zzaLT = new HashSet();
        private ItemScopeEntity zzaLU;
        private List zzaLV;
        private ItemScopeEntity zzaLW;
        private String zzaLX;
        private String zzaLY;
        private String zzaLZ;
        private List zzaMA;
        private String zzaMB;
        private String zzaMC;
        private String zzaMD;
        private String zzaME;
        private ItemScopeEntity zzaMF;
        private String zzaMG;
        private String zzaMH;
        private String zzaMI;
        private ItemScopeEntity zzaMJ;
        private String zzaMK;
        private String zzaML;
        private String zzaMM;
        private String zzaMN;
        private List zzaMa;
        private int zzaMb;
        private List zzaMc;
        private ItemScopeEntity zzaMd;
        private List zzaMe;
        private String zzaMf;
        private String zzaMg;
        private ItemScopeEntity zzaMh;
        private String zzaMi;
        private String zzaMj;
        private List zzaMk;
        private String zzaMl;
        private String zzaMm;
        private String zzaMn;
        private String zzaMo;
        private String zzaMp;
        private String zzaMq;
        private String zzaMr;
        private String zzaMs;
        private ItemScopeEntity zzaMt;
        private String zzaMu;
        private String zzaMv;
        private String zzaMw;
        private ItemScopeEntity zzaMx;
        private ItemScopeEntity zzaMy;
        private ItemScopeEntity zzaMz;
        private String zzaoB;
        private String zzsV;
        private String zzwj;

        public ItemScope build()
        {
            return new ItemScopeEntity(zzaLT, zzaLU, zzaLV, zzaLW, zzaLX, zzaLY, zzaLZ, zzaMa, zzaMb, zzaMc, zzaMd, zzaMe, zzaMf, zzaMg, zzaMh, zzaMi, zzaMj, zzsV, zzaMk, zzaMl, zzaMm, zzaMn, zzaoB, zzaMo, zzaMp, zzaMq, zzaMr, zzaMs, zzaMt, zzaMu, zzaMv, zzwj, zzaMw, zzaMx, zzaBD, zzaMy, zzaBE, mName, zzaMz, zzaMA, zzaMB, zzaMC, zzaMD, zzaME, zzaMF, zzaMG, zzaMH, zzaMI, zzaMJ, zzaMK, zzaML, zzFz, zzF, zzaMM, zzaMN);
        }

        public Builder setAbout(ItemScope itemscope)
        {
            zzaLU = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List list)
        {
            zzaLV = list;
            zzaLT.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope itemscope)
        {
            zzaLW = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String s)
        {
            zzaLX = s;
            zzaLT.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String s)
        {
            zzaLY = s;
            zzaLT.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String s)
        {
            zzaLZ = s;
            zzaLT.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List list)
        {
            zzaMa = list;
            zzaLT.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int i)
        {
            zzaMb = i;
            zzaLT.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List list)
        {
            zzaMc = list;
            zzaLT.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope itemscope)
        {
            zzaMd = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List list)
        {
            zzaMe = list;
            zzaLT.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String s)
        {
            zzaMf = s;
            zzaLT.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String s)
        {
            zzaMg = s;
            zzaLT.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope itemscope)
        {
            zzaMh = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String s)
        {
            zzaMi = s;
            zzaLT.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String s)
        {
            zzaMj = s;
            zzaLT.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String s)
        {
            zzsV = s;
            zzaLT.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List list)
        {
            zzaMk = list;
            zzaLT.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String s)
        {
            zzaMl = s;
            zzaLT.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String s)
        {
            zzaMm = s;
            zzaLT.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String s)
        {
            zzaMn = s;
            zzaLT.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String s)
        {
            zzaoB = s;
            zzaLT.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String s)
        {
            zzaMo = s;
            zzaLT.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String s)
        {
            zzaMp = s;
            zzaLT.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String s)
        {
            zzaMq = s;
            zzaLT.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String s)
        {
            zzaMr = s;
            zzaLT.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String s)
        {
            zzaMs = s;
            zzaLT.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope itemscope)
        {
            zzaMt = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String s)
        {
            zzaMu = s;
            zzaLT.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String s)
        {
            zzaMv = s;
            zzaLT.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String s)
        {
            zzwj = s;
            zzaLT.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String s)
        {
            zzaMw = s;
            zzaLT.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope itemscope)
        {
            zzaMx = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double d)
        {
            zzaBD = d;
            zzaLT.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope itemscope)
        {
            zzaMy = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double d)
        {
            zzaBE = d;
            zzaLT.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String s)
        {
            mName = s;
            zzaLT.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope itemscope)
        {
            zzaMz = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List list)
        {
            zzaMA = list;
            zzaLT.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String s)
        {
            zzaMB = s;
            zzaLT.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String s)
        {
            zzaMC = s;
            zzaLT.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String s)
        {
            zzaMD = s;
            zzaLT.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String s)
        {
            zzaME = s;
            zzaLT.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope itemscope)
        {
            zzaMF = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String s)
        {
            zzaMG = s;
            zzaLT.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String s)
        {
            zzaMH = s;
            zzaLT.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String s)
        {
            zzaMI = s;
            zzaLT.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope itemscope)
        {
            zzaMJ = (ItemScopeEntity)itemscope;
            zzaLT.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String s)
        {
            zzaMK = s;
            zzaLT.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String s)
        {
            zzaML = s;
            zzaLT.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String s)
        {
            zzFz = s;
            zzaLT.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String s)
        {
            zzF = s;
            zzaLT.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String s)
        {
            zzaMM = s;
            zzaLT.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String s)
        {
            zzaMN = s;
            zzaLT.add(Integer.valueOf(56));
            return this;
        }

        public Builder()
        {
        }
    }


    public abstract ItemScope getAbout();

    public abstract List getAdditionalName();

    public abstract ItemScope getAddress();

    public abstract String getAddressCountry();

    public abstract String getAddressLocality();

    public abstract String getAddressRegion();

    public abstract List getAssociated_media();

    public abstract int getAttendeeCount();

    public abstract List getAttendees();

    public abstract ItemScope getAudio();

    public abstract List getAuthor();

    public abstract String getBestRating();

    public abstract String getBirthDate();

    public abstract ItemScope getByArtist();

    public abstract String getCaption();

    public abstract String getContentSize();

    public abstract String getContentUrl();

    public abstract List getContributor();

    public abstract String getDateCreated();

    public abstract String getDateModified();

    public abstract String getDatePublished();

    public abstract String getDescription();

    public abstract String getDuration();

    public abstract String getEmbedUrl();

    public abstract String getEndDate();

    public abstract String getFamilyName();

    public abstract String getGender();

    public abstract ItemScope getGeo();

    public abstract String getGivenName();

    public abstract String getHeight();

    public abstract String getId();

    public abstract String getImage();

    public abstract ItemScope getInAlbum();

    public abstract double getLatitude();

    public abstract ItemScope getLocation();

    public abstract double getLongitude();

    public abstract String getName();

    public abstract ItemScope getPartOfTVSeries();

    public abstract List getPerformers();

    public abstract String getPlayerType();

    public abstract String getPostOfficeBoxNumber();

    public abstract String getPostalCode();

    public abstract String getRatingValue();

    public abstract ItemScope getReviewRating();

    public abstract String getStartDate();

    public abstract String getStreetAddress();

    public abstract String getText();

    public abstract ItemScope getThumbnail();

    public abstract String getThumbnailUrl();

    public abstract String getTickerSymbol();

    public abstract String getType();

    public abstract String getUrl();

    public abstract String getWidth();

    public abstract String getWorstRating();

    public abstract boolean hasAbout();

    public abstract boolean hasAdditionalName();

    public abstract boolean hasAddress();

    public abstract boolean hasAddressCountry();

    public abstract boolean hasAddressLocality();

    public abstract boolean hasAddressRegion();

    public abstract boolean hasAssociated_media();

    public abstract boolean hasAttendeeCount();

    public abstract boolean hasAttendees();

    public abstract boolean hasAudio();

    public abstract boolean hasAuthor();

    public abstract boolean hasBestRating();

    public abstract boolean hasBirthDate();

    public abstract boolean hasByArtist();

    public abstract boolean hasCaption();

    public abstract boolean hasContentSize();

    public abstract boolean hasContentUrl();

    public abstract boolean hasContributor();

    public abstract boolean hasDateCreated();

    public abstract boolean hasDateModified();

    public abstract boolean hasDatePublished();

    public abstract boolean hasDescription();

    public abstract boolean hasDuration();

    public abstract boolean hasEmbedUrl();

    public abstract boolean hasEndDate();

    public abstract boolean hasFamilyName();

    public abstract boolean hasGender();

    public abstract boolean hasGeo();

    public abstract boolean hasGivenName();

    public abstract boolean hasHeight();

    public abstract boolean hasId();

    public abstract boolean hasImage();

    public abstract boolean hasInAlbum();

    public abstract boolean hasLatitude();

    public abstract boolean hasLocation();

    public abstract boolean hasLongitude();

    public abstract boolean hasName();

    public abstract boolean hasPartOfTVSeries();

    public abstract boolean hasPerformers();

    public abstract boolean hasPlayerType();

    public abstract boolean hasPostOfficeBoxNumber();

    public abstract boolean hasPostalCode();

    public abstract boolean hasRatingValue();

    public abstract boolean hasReviewRating();

    public abstract boolean hasStartDate();

    public abstract boolean hasStreetAddress();

    public abstract boolean hasText();

    public abstract boolean hasThumbnail();

    public abstract boolean hasThumbnailUrl();

    public abstract boolean hasTickerSymbol();

    public abstract boolean hasType();

    public abstract boolean hasUrl();

    public abstract boolean hasWidth();

    public abstract boolean hasWorstRating();
}
