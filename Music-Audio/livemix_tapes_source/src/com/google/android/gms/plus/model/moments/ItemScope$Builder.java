// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.model.moments:
//            ItemScope

public static class Entity
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

    public zzaMN setAbout(ItemScope itemscope)
    {
        zzaLU = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(2));
        return this;
    }

    public zzaLT setAdditionalName(List list)
    {
        zzaLV = list;
        zzaLT.add(Integer.valueOf(3));
        return this;
    }

    public zzaLT setAddress(ItemScope itemscope)
    {
        zzaLW = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(4));
        return this;
    }

    public zzaLT setAddressCountry(String s)
    {
        zzaLX = s;
        zzaLT.add(Integer.valueOf(5));
        return this;
    }

    public zzaLT setAddressLocality(String s)
    {
        zzaLY = s;
        zzaLT.add(Integer.valueOf(6));
        return this;
    }

    public zzaLT setAddressRegion(String s)
    {
        zzaLZ = s;
        zzaLT.add(Integer.valueOf(7));
        return this;
    }

    public zzaLT setAssociated_media(List list)
    {
        zzaMa = list;
        zzaLT.add(Integer.valueOf(8));
        return this;
    }

    public zzaLT setAttendeeCount(int i)
    {
        zzaMb = i;
        zzaLT.add(Integer.valueOf(9));
        return this;
    }

    public zzaLT setAttendees(List list)
    {
        zzaMc = list;
        zzaLT.add(Integer.valueOf(10));
        return this;
    }

    public zzaLT setAudio(ItemScope itemscope)
    {
        zzaMd = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(11));
        return this;
    }

    public zzaLT setAuthor(List list)
    {
        zzaMe = list;
        zzaLT.add(Integer.valueOf(12));
        return this;
    }

    public zzaLT setBestRating(String s)
    {
        zzaMf = s;
        zzaLT.add(Integer.valueOf(13));
        return this;
    }

    public zzaLT setBirthDate(String s)
    {
        zzaMg = s;
        zzaLT.add(Integer.valueOf(14));
        return this;
    }

    public zzaLT setByArtist(ItemScope itemscope)
    {
        zzaMh = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(15));
        return this;
    }

    public zzaLT setCaption(String s)
    {
        zzaMi = s;
        zzaLT.add(Integer.valueOf(16));
        return this;
    }

    public zzaLT setContentSize(String s)
    {
        zzaMj = s;
        zzaLT.add(Integer.valueOf(17));
        return this;
    }

    public zzaLT setContentUrl(String s)
    {
        zzsV = s;
        zzaLT.add(Integer.valueOf(18));
        return this;
    }

    public zzaLT setContributor(List list)
    {
        zzaMk = list;
        zzaLT.add(Integer.valueOf(19));
        return this;
    }

    public zzaLT setDateCreated(String s)
    {
        zzaMl = s;
        zzaLT.add(Integer.valueOf(20));
        return this;
    }

    public zzaLT setDateModified(String s)
    {
        zzaMm = s;
        zzaLT.add(Integer.valueOf(21));
        return this;
    }

    public zzaLT setDatePublished(String s)
    {
        zzaMn = s;
        zzaLT.add(Integer.valueOf(22));
        return this;
    }

    public zzaLT setDescription(String s)
    {
        zzaoB = s;
        zzaLT.add(Integer.valueOf(23));
        return this;
    }

    public zzaLT setDuration(String s)
    {
        zzaMo = s;
        zzaLT.add(Integer.valueOf(24));
        return this;
    }

    public zzaLT setEmbedUrl(String s)
    {
        zzaMp = s;
        zzaLT.add(Integer.valueOf(25));
        return this;
    }

    public zzaLT setEndDate(String s)
    {
        zzaMq = s;
        zzaLT.add(Integer.valueOf(26));
        return this;
    }

    public zzaLT setFamilyName(String s)
    {
        zzaMr = s;
        zzaLT.add(Integer.valueOf(27));
        return this;
    }

    public zzaLT setGender(String s)
    {
        zzaMs = s;
        zzaLT.add(Integer.valueOf(28));
        return this;
    }

    public zzaLT setGeo(ItemScope itemscope)
    {
        zzaMt = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(29));
        return this;
    }

    public zzaLT setGivenName(String s)
    {
        zzaMu = s;
        zzaLT.add(Integer.valueOf(30));
        return this;
    }

    public zzaLT setHeight(String s)
    {
        zzaMv = s;
        zzaLT.add(Integer.valueOf(31));
        return this;
    }

    public zzaLT setId(String s)
    {
        zzwj = s;
        zzaLT.add(Integer.valueOf(32));
        return this;
    }

    public zzaLT setImage(String s)
    {
        zzaMw = s;
        zzaLT.add(Integer.valueOf(33));
        return this;
    }

    public zzaLT setInAlbum(ItemScope itemscope)
    {
        zzaMx = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(34));
        return this;
    }

    public zzaLT setLatitude(double d)
    {
        zzaBD = d;
        zzaLT.add(Integer.valueOf(36));
        return this;
    }

    public zzaLT setLocation(ItemScope itemscope)
    {
        zzaMy = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(37));
        return this;
    }

    public zzaLT setLongitude(double d)
    {
        zzaBE = d;
        zzaLT.add(Integer.valueOf(38));
        return this;
    }

    public zzaLT setName(String s)
    {
        mName = s;
        zzaLT.add(Integer.valueOf(39));
        return this;
    }

    public zzaLT setPartOfTVSeries(ItemScope itemscope)
    {
        zzaMz = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(40));
        return this;
    }

    public zzaLT setPerformers(List list)
    {
        zzaMA = list;
        zzaLT.add(Integer.valueOf(41));
        return this;
    }

    public zzaLT setPlayerType(String s)
    {
        zzaMB = s;
        zzaLT.add(Integer.valueOf(42));
        return this;
    }

    public zzaLT setPostOfficeBoxNumber(String s)
    {
        zzaMC = s;
        zzaLT.add(Integer.valueOf(43));
        return this;
    }

    public zzaLT setPostalCode(String s)
    {
        zzaMD = s;
        zzaLT.add(Integer.valueOf(44));
        return this;
    }

    public zzaLT setRatingValue(String s)
    {
        zzaME = s;
        zzaLT.add(Integer.valueOf(45));
        return this;
    }

    public zzaLT setReviewRating(ItemScope itemscope)
    {
        zzaMF = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(46));
        return this;
    }

    public zzaLT setStartDate(String s)
    {
        zzaMG = s;
        zzaLT.add(Integer.valueOf(47));
        return this;
    }

    public zzaLT setStreetAddress(String s)
    {
        zzaMH = s;
        zzaLT.add(Integer.valueOf(48));
        return this;
    }

    public zzaLT setText(String s)
    {
        zzaMI = s;
        zzaLT.add(Integer.valueOf(49));
        return this;
    }

    public zzaLT setThumbnail(ItemScope itemscope)
    {
        zzaMJ = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(50));
        return this;
    }

    public zzaLT setThumbnailUrl(String s)
    {
        zzaMK = s;
        zzaLT.add(Integer.valueOf(51));
        return this;
    }

    public zzaLT setTickerSymbol(String s)
    {
        zzaML = s;
        zzaLT.add(Integer.valueOf(52));
        return this;
    }

    public zzaLT setType(String s)
    {
        zzFz = s;
        zzaLT.add(Integer.valueOf(53));
        return this;
    }

    public zzaLT setUrl(String s)
    {
        zzF = s;
        zzaLT.add(Integer.valueOf(54));
        return this;
    }

    public zzaLT setWidth(String s)
    {
        zzaMM = s;
        zzaLT.add(Integer.valueOf(55));
        return this;
    }

    public zzaLT setWorstRating(String s)
    {
        zzaMN = s;
        zzaLT.add(Integer.valueOf(56));
        return this;
    }

    public Entity()
    {
    }
}
