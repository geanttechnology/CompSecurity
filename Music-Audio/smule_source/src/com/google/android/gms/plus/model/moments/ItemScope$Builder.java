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

public class Entity
{

    private String mName;
    private String zzAV;
    private String zzAX;
    private String zzGM;
    private String zzaAa;
    private String zzaAb;
    private String zzaAc;
    private ItemScopeEntity zzaAd;
    private String zzaAe;
    private String zzaAf;
    private String zzaAg;
    private ItemScopeEntity zzaAh;
    private ItemScopeEntity zzaAi;
    private ItemScopeEntity zzaAj;
    private List zzaAk;
    private String zzaAl;
    private String zzaAm;
    private String zzaAn;
    private String zzaAo;
    private ItemScopeEntity zzaAp;
    private String zzaAq;
    private String zzaAr;
    private String zzaAs;
    private ItemScopeEntity zzaAt;
    private String zzaAu;
    private String zzaAv;
    private String zzaAw;
    private String zzaAx;
    private String zzadH;
    private double zzapL;
    private double zzapM;
    private final Set zzazD = new HashSet();
    private ItemScopeEntity zzazE;
    private List zzazF;
    private ItemScopeEntity zzazG;
    private String zzazH;
    private String zzazI;
    private String zzazJ;
    private List zzazK;
    private int zzazL;
    private List zzazM;
    private ItemScopeEntity zzazN;
    private List zzazO;
    private String zzazP;
    private String zzazQ;
    private ItemScopeEntity zzazR;
    private String zzazS;
    private String zzazT;
    private List zzazU;
    private String zzazV;
    private String zzazW;
    private String zzazX;
    private String zzazY;
    private String zzazZ;
    private String zzql;

    public ItemScope build()
    {
        return new ItemScopeEntity(zzazD, zzazE, zzazF, zzazG, zzazH, zzazI, zzazJ, zzazK, zzazL, zzazM, zzazN, zzazO, zzazP, zzazQ, zzazR, zzazS, zzazT, zzql, zzazU, zzazV, zzazW, zzazX, zzadH, zzazY, zzazZ, zzaAa, zzaAb, zzaAc, zzaAd, zzaAe, zzaAf, zzGM, zzaAg, zzaAh, zzapL, zzaAi, zzapM, mName, zzaAj, zzaAk, zzaAl, zzaAm, zzaAn, zzaAo, zzaAp, zzaAq, zzaAr, zzaAs, zzaAt, zzaAu, zzaAv, zzAV, zzAX, zzaAw, zzaAx);
    }

    public zzaAx setAbout(ItemScope itemscope)
    {
        zzazE = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(2));
        return this;
    }

    public zzazD setAdditionalName(List list)
    {
        zzazF = list;
        zzazD.add(Integer.valueOf(3));
        return this;
    }

    public zzazD setAddress(ItemScope itemscope)
    {
        zzazG = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(4));
        return this;
    }

    public zzazD setAddressCountry(String s)
    {
        zzazH = s;
        zzazD.add(Integer.valueOf(5));
        return this;
    }

    public zzazD setAddressLocality(String s)
    {
        zzazI = s;
        zzazD.add(Integer.valueOf(6));
        return this;
    }

    public zzazD setAddressRegion(String s)
    {
        zzazJ = s;
        zzazD.add(Integer.valueOf(7));
        return this;
    }

    public zzazD setAssociated_media(List list)
    {
        zzazK = list;
        zzazD.add(Integer.valueOf(8));
        return this;
    }

    public zzazD setAttendeeCount(int i)
    {
        zzazL = i;
        zzazD.add(Integer.valueOf(9));
        return this;
    }

    public zzazD setAttendees(List list)
    {
        zzazM = list;
        zzazD.add(Integer.valueOf(10));
        return this;
    }

    public zzazD setAudio(ItemScope itemscope)
    {
        zzazN = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(11));
        return this;
    }

    public zzazD setAuthor(List list)
    {
        zzazO = list;
        zzazD.add(Integer.valueOf(12));
        return this;
    }

    public zzazD setBestRating(String s)
    {
        zzazP = s;
        zzazD.add(Integer.valueOf(13));
        return this;
    }

    public zzazD setBirthDate(String s)
    {
        zzazQ = s;
        zzazD.add(Integer.valueOf(14));
        return this;
    }

    public zzazD setByArtist(ItemScope itemscope)
    {
        zzazR = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(15));
        return this;
    }

    public zzazD setCaption(String s)
    {
        zzazS = s;
        zzazD.add(Integer.valueOf(16));
        return this;
    }

    public zzazD setContentSize(String s)
    {
        zzazT = s;
        zzazD.add(Integer.valueOf(17));
        return this;
    }

    public zzazD setContentUrl(String s)
    {
        zzql = s;
        zzazD.add(Integer.valueOf(18));
        return this;
    }

    public zzazD setContributor(List list)
    {
        zzazU = list;
        zzazD.add(Integer.valueOf(19));
        return this;
    }

    public zzazD setDateCreated(String s)
    {
        zzazV = s;
        zzazD.add(Integer.valueOf(20));
        return this;
    }

    public zzazD setDateModified(String s)
    {
        zzazW = s;
        zzazD.add(Integer.valueOf(21));
        return this;
    }

    public zzazD setDatePublished(String s)
    {
        zzazX = s;
        zzazD.add(Integer.valueOf(22));
        return this;
    }

    public zzazD setDescription(String s)
    {
        zzadH = s;
        zzazD.add(Integer.valueOf(23));
        return this;
    }

    public zzazD setDuration(String s)
    {
        zzazY = s;
        zzazD.add(Integer.valueOf(24));
        return this;
    }

    public zzazD setEmbedUrl(String s)
    {
        zzazZ = s;
        zzazD.add(Integer.valueOf(25));
        return this;
    }

    public zzazD setEndDate(String s)
    {
        zzaAa = s;
        zzazD.add(Integer.valueOf(26));
        return this;
    }

    public zzazD setFamilyName(String s)
    {
        zzaAb = s;
        zzazD.add(Integer.valueOf(27));
        return this;
    }

    public zzazD setGender(String s)
    {
        zzaAc = s;
        zzazD.add(Integer.valueOf(28));
        return this;
    }

    public zzazD setGeo(ItemScope itemscope)
    {
        zzaAd = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(29));
        return this;
    }

    public zzazD setGivenName(String s)
    {
        zzaAe = s;
        zzazD.add(Integer.valueOf(30));
        return this;
    }

    public zzazD setHeight(String s)
    {
        zzaAf = s;
        zzazD.add(Integer.valueOf(31));
        return this;
    }

    public zzazD setId(String s)
    {
        zzGM = s;
        zzazD.add(Integer.valueOf(32));
        return this;
    }

    public zzazD setImage(String s)
    {
        zzaAg = s;
        zzazD.add(Integer.valueOf(33));
        return this;
    }

    public zzazD setInAlbum(ItemScope itemscope)
    {
        zzaAh = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(34));
        return this;
    }

    public zzazD setLatitude(double d)
    {
        zzapL = d;
        zzazD.add(Integer.valueOf(36));
        return this;
    }

    public zzazD setLocation(ItemScope itemscope)
    {
        zzaAi = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(37));
        return this;
    }

    public zzazD setLongitude(double d)
    {
        zzapM = d;
        zzazD.add(Integer.valueOf(38));
        return this;
    }

    public zzazD setName(String s)
    {
        mName = s;
        zzazD.add(Integer.valueOf(39));
        return this;
    }

    public zzazD setPartOfTVSeries(ItemScope itemscope)
    {
        zzaAj = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(40));
        return this;
    }

    public zzazD setPerformers(List list)
    {
        zzaAk = list;
        zzazD.add(Integer.valueOf(41));
        return this;
    }

    public zzazD setPlayerType(String s)
    {
        zzaAl = s;
        zzazD.add(Integer.valueOf(42));
        return this;
    }

    public zzazD setPostOfficeBoxNumber(String s)
    {
        zzaAm = s;
        zzazD.add(Integer.valueOf(43));
        return this;
    }

    public zzazD setPostalCode(String s)
    {
        zzaAn = s;
        zzazD.add(Integer.valueOf(44));
        return this;
    }

    public zzazD setRatingValue(String s)
    {
        zzaAo = s;
        zzazD.add(Integer.valueOf(45));
        return this;
    }

    public zzazD setReviewRating(ItemScope itemscope)
    {
        zzaAp = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(46));
        return this;
    }

    public zzazD setStartDate(String s)
    {
        zzaAq = s;
        zzazD.add(Integer.valueOf(47));
        return this;
    }

    public zzazD setStreetAddress(String s)
    {
        zzaAr = s;
        zzazD.add(Integer.valueOf(48));
        return this;
    }

    public zzazD setText(String s)
    {
        zzaAs = s;
        zzazD.add(Integer.valueOf(49));
        return this;
    }

    public zzazD setThumbnail(ItemScope itemscope)
    {
        zzaAt = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(50));
        return this;
    }

    public zzazD setThumbnailUrl(String s)
    {
        zzaAu = s;
        zzazD.add(Integer.valueOf(51));
        return this;
    }

    public zzazD setTickerSymbol(String s)
    {
        zzaAv = s;
        zzazD.add(Integer.valueOf(52));
        return this;
    }

    public zzazD setType(String s)
    {
        zzAV = s;
        zzazD.add(Integer.valueOf(53));
        return this;
    }

    public zzazD setUrl(String s)
    {
        zzAX = s;
        zzazD.add(Integer.valueOf(54));
        return this;
    }

    public zzazD setWidth(String s)
    {
        zzaAw = s;
        zzazD.add(Integer.valueOf(55));
        return this;
    }

    public zzazD setWorstRating(String s)
    {
        zzaAx = s;
        zzazD.add(Integer.valueOf(56));
        return this;
    }

    public Entity()
    {
    }
}
