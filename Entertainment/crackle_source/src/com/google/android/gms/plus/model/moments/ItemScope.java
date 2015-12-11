// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.ib;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope
    extends Freezable
{
    public static class Builder
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

        public Builder setAbout(ItemScope itemscope)
        {
            Er = (ib)itemscope;
            Eq.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List list)
        {
            Es = list;
            Eq.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope itemscope)
        {
            Et = (ib)itemscope;
            Eq.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String s)
        {
            Eu = s;
            Eq.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String s)
        {
            Ev = s;
            Eq.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String s)
        {
            Ew = s;
            Eq.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List list)
        {
            Ex = list;
            Eq.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int i)
        {
            Ey = i;
            Eq.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List list)
        {
            Ez = list;
            Eq.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope itemscope)
        {
            EA = (ib)itemscope;
            Eq.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List list)
        {
            EB = list;
            Eq.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String s)
        {
            EC = s;
            Eq.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String s)
        {
            ED = s;
            Eq.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope itemscope)
        {
            EE = (ib)itemscope;
            Eq.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String s)
        {
            EF = s;
            Eq.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String s)
        {
            EG = s;
            Eq.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String s)
        {
            EH = s;
            Eq.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List list)
        {
            EI = list;
            Eq.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String s)
        {
            EJ = s;
            Eq.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String s)
        {
            EK = s;
            Eq.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String s)
        {
            EL = s;
            Eq.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String s)
        {
            sJ = s;
            Eq.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String s)
        {
            EM = s;
            Eq.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String s)
        {
            EN = s;
            Eq.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String s)
        {
            EO = s;
            Eq.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String s)
        {
            EP = s;
            Eq.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String s)
        {
            EQ = s;
            Eq.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope itemscope)
        {
            ER = (ib)itemscope;
            Eq.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String s)
        {
            ES = s;
            Eq.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String s)
        {
            ET = s;
            Eq.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String s)
        {
            uS = s;
            Eq.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String s)
        {
            EU = s;
            Eq.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope itemscope)
        {
            EV = (ib)itemscope;
            Eq.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double d)
        {
            xw = d;
            Eq.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope itemscope)
        {
            EW = (ib)itemscope;
            Eq.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double d)
        {
            xx = d;
            Eq.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String s)
        {
            mName = s;
            Eq.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope itemscope)
        {
            EX = (ib)itemscope;
            Eq.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List list)
        {
            EY = list;
            Eq.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String s)
        {
            EZ = s;
            Eq.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String s)
        {
            Fa = s;
            Eq.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String s)
        {
            Fb = s;
            Eq.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String s)
        {
            Fc = s;
            Eq.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope itemscope)
        {
            Fd = (ib)itemscope;
            Eq.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String s)
        {
            Fe = s;
            Eq.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String s)
        {
            Ff = s;
            Eq.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String s)
        {
            Fg = s;
            Eq.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope itemscope)
        {
            Fh = (ib)itemscope;
            Eq.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String s)
        {
            Fi = s;
            Eq.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String s)
        {
            Fj = s;
            Eq.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String s)
        {
            AI = s;
            Eq.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String s)
        {
            iH = s;
            Eq.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String s)
        {
            Fk = s;
            Eq.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String s)
        {
            Fl = s;
            Eq.add(Integer.valueOf(56));
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
