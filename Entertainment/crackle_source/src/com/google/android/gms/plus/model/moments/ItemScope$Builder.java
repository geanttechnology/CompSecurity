// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.internal.ib;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.model.moments:
//            ItemScope

public static class A
{

    private String AI;
    private ib EA;
    private List EB;
    private String EC;
    private String ED;
    private ib EE;
    private String EF;
    private String EG;
    private String EH;
    private List EI;
    private String EJ;
    private String EK;
    private String EL;
    private String EM;
    private String EN;
    private String EO;
    private String EP;
    private String EQ;
    private ib ER;
    private String ES;
    private String ET;
    private String EU;
    private ib EV;
    private ib EW;
    private ib EX;
    private List EY;
    private String EZ;
    private final Set Eq = new HashSet();
    private ib Er;
    private List Es;
    private ib Et;
    private String Eu;
    private String Ev;
    private String Ew;
    private List Ex;
    private int Ey;
    private List Ez;
    private String Fa;
    private String Fb;
    private String Fc;
    private ib Fd;
    private String Fe;
    private String Ff;
    private String Fg;
    private ib Fh;
    private String Fi;
    private String Fj;
    private String Fk;
    private String Fl;
    private String iH;
    private String mName;
    private String sJ;
    private String uS;
    private double xw;
    private double xx;

    public ItemScope build()
    {
        return new ib(Eq, Er, Es, Et, Eu, Ev, Ew, Ex, Ey, Ez, EA, EB, EC, ED, EE, EF, EG, EH, EI, EJ, EK, EL, sJ, EM, EN, EO, EP, EQ, ER, ES, ET, uS, EU, EV, xw, EW, xx, mName, EX, EY, EZ, Fa, Fb, Fc, Fd, Fe, Ff, Fg, Fh, Fi, Fj, AI, iH, Fk, Fl);
    }

    public Fl setAbout(ItemScope itemscope)
    {
        Er = (ib)itemscope;
        Eq.add(Integer.valueOf(2));
        return this;
    }

    public Eq setAdditionalName(List list)
    {
        Es = list;
        Eq.add(Integer.valueOf(3));
        return this;
    }

    public Eq setAddress(ItemScope itemscope)
    {
        Et = (ib)itemscope;
        Eq.add(Integer.valueOf(4));
        return this;
    }

    public Eq setAddressCountry(String s)
    {
        Eu = s;
        Eq.add(Integer.valueOf(5));
        return this;
    }

    public Eq setAddressLocality(String s)
    {
        Ev = s;
        Eq.add(Integer.valueOf(6));
        return this;
    }

    public Eq setAddressRegion(String s)
    {
        Ew = s;
        Eq.add(Integer.valueOf(7));
        return this;
    }

    public Eq setAssociated_media(List list)
    {
        Ex = list;
        Eq.add(Integer.valueOf(8));
        return this;
    }

    public Eq setAttendeeCount(int i)
    {
        Ey = i;
        Eq.add(Integer.valueOf(9));
        return this;
    }

    public Eq setAttendees(List list)
    {
        Ez = list;
        Eq.add(Integer.valueOf(10));
        return this;
    }

    public Eq setAudio(ItemScope itemscope)
    {
        EA = (ib)itemscope;
        Eq.add(Integer.valueOf(11));
        return this;
    }

    public Eq setAuthor(List list)
    {
        EB = list;
        Eq.add(Integer.valueOf(12));
        return this;
    }

    public Eq setBestRating(String s)
    {
        EC = s;
        Eq.add(Integer.valueOf(13));
        return this;
    }

    public Eq setBirthDate(String s)
    {
        ED = s;
        Eq.add(Integer.valueOf(14));
        return this;
    }

    public Eq setByArtist(ItemScope itemscope)
    {
        EE = (ib)itemscope;
        Eq.add(Integer.valueOf(15));
        return this;
    }

    public Eq setCaption(String s)
    {
        EF = s;
        Eq.add(Integer.valueOf(16));
        return this;
    }

    public Eq setContentSize(String s)
    {
        EG = s;
        Eq.add(Integer.valueOf(17));
        return this;
    }

    public Eq setContentUrl(String s)
    {
        EH = s;
        Eq.add(Integer.valueOf(18));
        return this;
    }

    public Eq setContributor(List list)
    {
        EI = list;
        Eq.add(Integer.valueOf(19));
        return this;
    }

    public Eq setDateCreated(String s)
    {
        EJ = s;
        Eq.add(Integer.valueOf(20));
        return this;
    }

    public Eq setDateModified(String s)
    {
        EK = s;
        Eq.add(Integer.valueOf(21));
        return this;
    }

    public Eq setDatePublished(String s)
    {
        EL = s;
        Eq.add(Integer.valueOf(22));
        return this;
    }

    public Eq setDescription(String s)
    {
        sJ = s;
        Eq.add(Integer.valueOf(23));
        return this;
    }

    public Eq setDuration(String s)
    {
        EM = s;
        Eq.add(Integer.valueOf(24));
        return this;
    }

    public Eq setEmbedUrl(String s)
    {
        EN = s;
        Eq.add(Integer.valueOf(25));
        return this;
    }

    public Eq setEndDate(String s)
    {
        EO = s;
        Eq.add(Integer.valueOf(26));
        return this;
    }

    public Eq setFamilyName(String s)
    {
        EP = s;
        Eq.add(Integer.valueOf(27));
        return this;
    }

    public Eq setGender(String s)
    {
        EQ = s;
        Eq.add(Integer.valueOf(28));
        return this;
    }

    public Eq setGeo(ItemScope itemscope)
    {
        ER = (ib)itemscope;
        Eq.add(Integer.valueOf(29));
        return this;
    }

    public Eq setGivenName(String s)
    {
        ES = s;
        Eq.add(Integer.valueOf(30));
        return this;
    }

    public Eq setHeight(String s)
    {
        ET = s;
        Eq.add(Integer.valueOf(31));
        return this;
    }

    public Eq setId(String s)
    {
        uS = s;
        Eq.add(Integer.valueOf(32));
        return this;
    }

    public Eq setImage(String s)
    {
        EU = s;
        Eq.add(Integer.valueOf(33));
        return this;
    }

    public Eq setInAlbum(ItemScope itemscope)
    {
        EV = (ib)itemscope;
        Eq.add(Integer.valueOf(34));
        return this;
    }

    public Eq setLatitude(double d)
    {
        xw = d;
        Eq.add(Integer.valueOf(36));
        return this;
    }

    public Eq setLocation(ItemScope itemscope)
    {
        EW = (ib)itemscope;
        Eq.add(Integer.valueOf(37));
        return this;
    }

    public Eq setLongitude(double d)
    {
        xx = d;
        Eq.add(Integer.valueOf(38));
        return this;
    }

    public Eq setName(String s)
    {
        mName = s;
        Eq.add(Integer.valueOf(39));
        return this;
    }

    public Eq setPartOfTVSeries(ItemScope itemscope)
    {
        EX = (ib)itemscope;
        Eq.add(Integer.valueOf(40));
        return this;
    }

    public Eq setPerformers(List list)
    {
        EY = list;
        Eq.add(Integer.valueOf(41));
        return this;
    }

    public Eq setPlayerType(String s)
    {
        EZ = s;
        Eq.add(Integer.valueOf(42));
        return this;
    }

    public Eq setPostOfficeBoxNumber(String s)
    {
        Fa = s;
        Eq.add(Integer.valueOf(43));
        return this;
    }

    public Eq setPostalCode(String s)
    {
        Fb = s;
        Eq.add(Integer.valueOf(44));
        return this;
    }

    public Eq setRatingValue(String s)
    {
        Fc = s;
        Eq.add(Integer.valueOf(45));
        return this;
    }

    public Eq setReviewRating(ItemScope itemscope)
    {
        Fd = (ib)itemscope;
        Eq.add(Integer.valueOf(46));
        return this;
    }

    public Eq setStartDate(String s)
    {
        Fe = s;
        Eq.add(Integer.valueOf(47));
        return this;
    }

    public Eq setStreetAddress(String s)
    {
        Ff = s;
        Eq.add(Integer.valueOf(48));
        return this;
    }

    public Eq setText(String s)
    {
        Fg = s;
        Eq.add(Integer.valueOf(49));
        return this;
    }

    public Eq setThumbnail(ItemScope itemscope)
    {
        Fh = (ib)itemscope;
        Eq.add(Integer.valueOf(50));
        return this;
    }

    public Eq setThumbnailUrl(String s)
    {
        Fi = s;
        Eq.add(Integer.valueOf(51));
        return this;
    }

    public Eq setTickerSymbol(String s)
    {
        Fj = s;
        Eq.add(Integer.valueOf(52));
        return this;
    }

    public Eq setType(String s)
    {
        AI = s;
        Eq.add(Integer.valueOf(53));
        return this;
    }

    public Eq setUrl(String s)
    {
        iH = s;
        Eq.add(Integer.valueOf(54));
        return this;
    }

    public Eq setWidth(String s)
    {
        Fk = s;
        Eq.add(Integer.valueOf(55));
        return this;
    }

    public Eq setWorstRating(String s)
    {
        Fl = s;
        Eq.add(Integer.valueOf(56));
        return this;
    }

    public A()
    {
    }
}
