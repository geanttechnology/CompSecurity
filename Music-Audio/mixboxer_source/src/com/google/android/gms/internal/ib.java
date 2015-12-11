// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, ic

public final class ib extends es
    implements SafeParcelable, ItemScope
{

    public static final ic CREATOR = new ic();
    private static final HashMap Ep;
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
    private final Set Eq;
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
    private final int kg;
    private String mName;
    private String sJ;
    private String uS;
    private double xw;
    private double xx;

    public ib()
    {
        kg = 1;
        Eq = new HashSet();
    }

    ib(Set set, int i, ib ib1, List list, ib ib2, String s, String s1, 
            String s2, List list1, int j, List list2, ib ib3, List list3, String s3, 
            String s4, ib ib4, String s5, String s6, String s7, List list4, String s8, 
            String s9, String s10, String s11, String s12, String s13, String s14, String s15, 
            String s16, ib ib5, String s17, String s18, String s19, String s20, ib ib6, 
            double d, ib ib7, double d1, String s21, ib ib8, 
            List list5, String s22, String s23, String s24, String s25, ib ib9, String s26, 
            String s27, String s28, ib ib10, String s29, String s30, String s31, String s32, 
            String s33, String s34)
    {
        Eq = set;
        kg = i;
        Er = ib1;
        Es = list;
        Et = ib2;
        Eu = s;
        Ev = s1;
        Ew = s2;
        Ex = list1;
        Ey = j;
        Ez = list2;
        EA = ib3;
        EB = list3;
        EC = s3;
        ED = s4;
        EE = ib4;
        EF = s5;
        EG = s6;
        EH = s7;
        EI = list4;
        EJ = s8;
        EK = s9;
        EL = s10;
        sJ = s11;
        EM = s12;
        EN = s13;
        EO = s14;
        EP = s15;
        EQ = s16;
        ER = ib5;
        ES = s17;
        ET = s18;
        uS = s19;
        EU = s20;
        EV = ib6;
        xw = d;
        EW = ib7;
        xx = d1;
        mName = s21;
        EX = ib8;
        EY = list5;
        EZ = s22;
        Fa = s23;
        Fb = s24;
        Fc = s25;
        Fd = ib9;
        Fe = s26;
        Ff = s27;
        Fg = s28;
        Fh = ib10;
        Fi = s29;
        Fj = s30;
        AI = s31;
        iH = s32;
        Fk = s33;
        Fl = s34;
    }

    public ib(Set set, ib ib1, List list, ib ib2, String s, String s1, String s2, 
            List list1, int i, List list2, ib ib3, List list3, String s3, String s4, 
            ib ib4, String s5, String s6, String s7, List list4, String s8, String s9, 
            String s10, String s11, String s12, String s13, String s14, String s15, String s16, 
            ib ib5, String s17, String s18, String s19, String s20, ib ib6, double d, ib ib7, double d1, String s21, ib ib8, List list5, 
            String s22, String s23, String s24, String s25, ib ib9, String s26, String s27, 
            String s28, ib ib10, String s29, String s30, String s31, String s32, String s33, 
            String s34)
    {
        Eq = set;
        kg = 1;
        Er = ib1;
        Es = list;
        Et = ib2;
        Eu = s;
        Ev = s1;
        Ew = s2;
        Ex = list1;
        Ey = i;
        Ez = list2;
        EA = ib3;
        EB = list3;
        EC = s3;
        ED = s4;
        EE = ib4;
        EF = s5;
        EG = s6;
        EH = s7;
        EI = list4;
        EJ = s8;
        EK = s9;
        EL = s10;
        sJ = s11;
        EM = s12;
        EN = s13;
        EO = s14;
        EP = s15;
        EQ = s16;
        ER = ib5;
        ES = s17;
        ET = s18;
        uS = s19;
        EU = s20;
        EV = ib6;
        xw = d;
        EW = ib7;
        xx = d1;
        mName = s21;
        EX = ib8;
        EY = list5;
        EZ = s22;
        Fa = s23;
        Fb = s24;
        Fc = s25;
        Fd = ib9;
        Fe = s26;
        Ff = s27;
        Fg = s28;
        Fh = ib10;
        Fi = s29;
        Fj = s30;
        AI = s31;
        iH = s32;
        Fk = s33;
        Fl = s34;
    }

    protected Object V(String s)
    {
        return null;
    }

    protected boolean W(String s)
    {
        return false;
    }

    protected boolean a(es.a a1)
    {
        return Eq.contains(Integer.valueOf(a1.cq()));
    }

    protected Object b(es.a a1)
    {
        switch (a1.cq())
        {
        case 35: // '#'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.cq()).toString());

        case 2: // '\002'
            return Er;

        case 3: // '\003'
            return Es;

        case 4: // '\004'
            return Et;

        case 5: // '\005'
            return Eu;

        case 6: // '\006'
            return Ev;

        case 7: // '\007'
            return Ew;

        case 8: // '\b'
            return Ex;

        case 9: // '\t'
            return Integer.valueOf(Ey);

        case 10: // '\n'
            return Ez;

        case 11: // '\013'
            return EA;

        case 12: // '\f'
            return EB;

        case 13: // '\r'
            return EC;

        case 14: // '\016'
            return ED;

        case 15: // '\017'
            return EE;

        case 16: // '\020'
            return EF;

        case 17: // '\021'
            return EG;

        case 18: // '\022'
            return EH;

        case 19: // '\023'
            return EI;

        case 20: // '\024'
            return EJ;

        case 21: // '\025'
            return EK;

        case 22: // '\026'
            return EL;

        case 23: // '\027'
            return sJ;

        case 24: // '\030'
            return EM;

        case 25: // '\031'
            return EN;

        case 26: // '\032'
            return EO;

        case 27: // '\033'
            return EP;

        case 28: // '\034'
            return EQ;

        case 29: // '\035'
            return ER;

        case 30: // '\036'
            return ES;

        case 31: // '\037'
            return ET;

        case 32: // ' '
            return uS;

        case 33: // '!'
            return EU;

        case 34: // '"'
            return EV;

        case 36: // '$'
            return Double.valueOf(xw);

        case 37: // '%'
            return EW;

        case 38: // '&'
            return Double.valueOf(xx);

        case 39: // '\''
            return mName;

        case 40: // '('
            return EX;

        case 41: // ')'
            return EY;

        case 42: // '*'
            return EZ;

        case 43: // '+'
            return Fa;

        case 44: // ','
            return Fb;

        case 45: // '-'
            return Fc;

        case 46: // '.'
            return Fd;

        case 47: // '/'
            return Fe;

        case 48: // '0'
            return Ff;

        case 49: // '1'
            return Fg;

        case 50: // '2'
            return Fh;

        case 51: // '3'
            return Fi;

        case 52: // '4'
            return Fj;

        case 53: // '5'
            return AI;

        case 54: // '6'
            return iH;

        case 55: // '7'
            return Fk;

        case 56: // '8'
            return Fl;
        }
    }

    public HashMap cj()
    {
        return Ep;
    }

    public int describeContents()
    {
        ic ic1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof ib))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (ib)obj;
            es.a a1;
label1:
            do
            {
                for (Iterator iterator = Ep.values().iterator(); iterator.hasNext();)
                {
                    a1 = (es.a)iterator.next();
                    if (!a(a1))
                    {
                        continue label1;
                    }
                    if (((ib) (obj)).a(a1))
                    {
                        if (!b(a1).equals(((ib) (obj)).b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((ib) (obj)).a(a1));
            return false;
        }
        return true;
    }

    Set fa()
    {
        return Eq;
    }

    ib fb()
    {
        return Er;
    }

    ib fc()
    {
        return Et;
    }

    List fd()
    {
        return Ex;
    }

    List fe()
    {
        return Ez;
    }

    ib ff()
    {
        return EA;
    }

    List fg()
    {
        return EB;
    }

    ib fh()
    {
        return EE;
    }

    List fi()
    {
        return EI;
    }

    ib fj()
    {
        return ER;
    }

    ib fk()
    {
        return EV;
    }

    ib fl()
    {
        return EW;
    }

    ib fm()
    {
        return EX;
    }

    List fn()
    {
        return EY;
    }

    ib fo()
    {
        return Fd;
    }

    ib fp()
    {
        return Fh;
    }

    public ib fq()
    {
        return this;
    }

    public Object freeze()
    {
        return fq();
    }

    public ItemScope getAbout()
    {
        return Er;
    }

    public List getAdditionalName()
    {
        return Es;
    }

    public ItemScope getAddress()
    {
        return Et;
    }

    public String getAddressCountry()
    {
        return Eu;
    }

    public String getAddressLocality()
    {
        return Ev;
    }

    public String getAddressRegion()
    {
        return Ew;
    }

    public List getAssociated_media()
    {
        return (ArrayList)Ex;
    }

    public int getAttendeeCount()
    {
        return Ey;
    }

    public List getAttendees()
    {
        return (ArrayList)Ez;
    }

    public ItemScope getAudio()
    {
        return EA;
    }

    public List getAuthor()
    {
        return (ArrayList)EB;
    }

    public String getBestRating()
    {
        return EC;
    }

    public String getBirthDate()
    {
        return ED;
    }

    public ItemScope getByArtist()
    {
        return EE;
    }

    public String getCaption()
    {
        return EF;
    }

    public String getContentSize()
    {
        return EG;
    }

    public String getContentUrl()
    {
        return EH;
    }

    public List getContributor()
    {
        return (ArrayList)EI;
    }

    public String getDateCreated()
    {
        return EJ;
    }

    public String getDateModified()
    {
        return EK;
    }

    public String getDatePublished()
    {
        return EL;
    }

    public String getDescription()
    {
        return sJ;
    }

    public String getDuration()
    {
        return EM;
    }

    public String getEmbedUrl()
    {
        return EN;
    }

    public String getEndDate()
    {
        return EO;
    }

    public String getFamilyName()
    {
        return EP;
    }

    public String getGender()
    {
        return EQ;
    }

    public ItemScope getGeo()
    {
        return ER;
    }

    public String getGivenName()
    {
        return ES;
    }

    public String getHeight()
    {
        return ET;
    }

    public String getId()
    {
        return uS;
    }

    public String getImage()
    {
        return EU;
    }

    public ItemScope getInAlbum()
    {
        return EV;
    }

    public double getLatitude()
    {
        return xw;
    }

    public ItemScope getLocation()
    {
        return EW;
    }

    public double getLongitude()
    {
        return xx;
    }

    public String getName()
    {
        return mName;
    }

    public ItemScope getPartOfTVSeries()
    {
        return EX;
    }

    public List getPerformers()
    {
        return (ArrayList)EY;
    }

    public String getPlayerType()
    {
        return EZ;
    }

    public String getPostOfficeBoxNumber()
    {
        return Fa;
    }

    public String getPostalCode()
    {
        return Fb;
    }

    public String getRatingValue()
    {
        return Fc;
    }

    public ItemScope getReviewRating()
    {
        return Fd;
    }

    public String getStartDate()
    {
        return Fe;
    }

    public String getStreetAddress()
    {
        return Ff;
    }

    public String getText()
    {
        return Fg;
    }

    public ItemScope getThumbnail()
    {
        return Fh;
    }

    public String getThumbnailUrl()
    {
        return Fi;
    }

    public String getTickerSymbol()
    {
        return Fj;
    }

    public String getType()
    {
        return AI;
    }

    public String getUrl()
    {
        return iH;
    }

    int getVersionCode()
    {
        return kg;
    }

    public String getWidth()
    {
        return Fk;
    }

    public String getWorstRating()
    {
        return Fl;
    }

    public boolean hasAbout()
    {
        return Eq.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName()
    {
        return Eq.contains(Integer.valueOf(3));
    }

    public boolean hasAddress()
    {
        return Eq.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry()
    {
        return Eq.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality()
    {
        return Eq.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion()
    {
        return Eq.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media()
    {
        return Eq.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount()
    {
        return Eq.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees()
    {
        return Eq.contains(Integer.valueOf(10));
    }

    public boolean hasAudio()
    {
        return Eq.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor()
    {
        return Eq.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating()
    {
        return Eq.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate()
    {
        return Eq.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist()
    {
        return Eq.contains(Integer.valueOf(15));
    }

    public boolean hasCaption()
    {
        return Eq.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize()
    {
        return Eq.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl()
    {
        return Eq.contains(Integer.valueOf(18));
    }

    public boolean hasContributor()
    {
        return Eq.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated()
    {
        return Eq.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified()
    {
        return Eq.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished()
    {
        return Eq.contains(Integer.valueOf(22));
    }

    public boolean hasDescription()
    {
        return Eq.contains(Integer.valueOf(23));
    }

    public boolean hasDuration()
    {
        return Eq.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl()
    {
        return Eq.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate()
    {
        return Eq.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName()
    {
        return Eq.contains(Integer.valueOf(27));
    }

    public boolean hasGender()
    {
        return Eq.contains(Integer.valueOf(28));
    }

    public boolean hasGeo()
    {
        return Eq.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName()
    {
        return Eq.contains(Integer.valueOf(30));
    }

    public boolean hasHeight()
    {
        return Eq.contains(Integer.valueOf(31));
    }

    public boolean hasId()
    {
        return Eq.contains(Integer.valueOf(32));
    }

    public boolean hasImage()
    {
        return Eq.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum()
    {
        return Eq.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude()
    {
        return Eq.contains(Integer.valueOf(36));
    }

    public boolean hasLocation()
    {
        return Eq.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude()
    {
        return Eq.contains(Integer.valueOf(38));
    }

    public boolean hasName()
    {
        return Eq.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries()
    {
        return Eq.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers()
    {
        return Eq.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType()
    {
        return Eq.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber()
    {
        return Eq.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode()
    {
        return Eq.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue()
    {
        return Eq.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating()
    {
        return Eq.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate()
    {
        return Eq.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress()
    {
        return Eq.contains(Integer.valueOf(48));
    }

    public boolean hasText()
    {
        return Eq.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail()
    {
        return Eq.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl()
    {
        return Eq.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol()
    {
        return Eq.contains(Integer.valueOf(52));
    }

    public boolean hasType()
    {
        return Eq.contains(Integer.valueOf(53));
    }

    public boolean hasUrl()
    {
        return Eq.contains(Integer.valueOf(54));
    }

    public boolean hasWidth()
    {
        return Eq.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating()
    {
        return Eq.contains(Integer.valueOf(56));
    }

    public int hashCode()
    {
        Iterator iterator = Ep.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            es.a a1 = (es.a)iterator.next();
            if (a(a1))
            {
                int j = a1.cq();
                i = b(a1).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ic ic1 = CREATOR;
        ic.a(this, parcel, i);
    }

    static 
    {
        Ep = new HashMap();
        Ep.put("about", es.a.a("about", 2, com/google/android/gms/internal/ib));
        Ep.put("additionalName", es.a.h("additionalName", 3));
        Ep.put("address", es.a.a("address", 4, com/google/android/gms/internal/ib));
        Ep.put("addressCountry", es.a.g("addressCountry", 5));
        Ep.put("addressLocality", es.a.g("addressLocality", 6));
        Ep.put("addressRegion", es.a.g("addressRegion", 7));
        Ep.put("associated_media", es.a.b("associated_media", 8, com/google/android/gms/internal/ib));
        Ep.put("attendeeCount", es.a.d("attendeeCount", 9));
        Ep.put("attendees", es.a.b("attendees", 10, com/google/android/gms/internal/ib));
        Ep.put("audio", es.a.a("audio", 11, com/google/android/gms/internal/ib));
        Ep.put("author", es.a.b("author", 12, com/google/android/gms/internal/ib));
        Ep.put("bestRating", es.a.g("bestRating", 13));
        Ep.put("birthDate", es.a.g("birthDate", 14));
        Ep.put("byArtist", es.a.a("byArtist", 15, com/google/android/gms/internal/ib));
        Ep.put("caption", es.a.g("caption", 16));
        Ep.put("contentSize", es.a.g("contentSize", 17));
        Ep.put("contentUrl", es.a.g("contentUrl", 18));
        Ep.put("contributor", es.a.b("contributor", 19, com/google/android/gms/internal/ib));
        Ep.put("dateCreated", es.a.g("dateCreated", 20));
        Ep.put("dateModified", es.a.g("dateModified", 21));
        Ep.put("datePublished", es.a.g("datePublished", 22));
        Ep.put("description", es.a.g("description", 23));
        Ep.put("duration", es.a.g("duration", 24));
        Ep.put("embedUrl", es.a.g("embedUrl", 25));
        Ep.put("endDate", es.a.g("endDate", 26));
        Ep.put("familyName", es.a.g("familyName", 27));
        Ep.put("gender", es.a.g("gender", 28));
        Ep.put("geo", es.a.a("geo", 29, com/google/android/gms/internal/ib));
        Ep.put("givenName", es.a.g("givenName", 30));
        Ep.put("height", es.a.g("height", 31));
        Ep.put("id", es.a.g("id", 32));
        Ep.put("image", es.a.g("image", 33));
        Ep.put("inAlbum", es.a.a("inAlbum", 34, com/google/android/gms/internal/ib));
        Ep.put("latitude", es.a.e("latitude", 36));
        Ep.put("location", es.a.a("location", 37, com/google/android/gms/internal/ib));
        Ep.put("longitude", es.a.e("longitude", 38));
        Ep.put("name", es.a.g("name", 39));
        Ep.put("partOfTVSeries", es.a.a("partOfTVSeries", 40, com/google/android/gms/internal/ib));
        Ep.put("performers", es.a.b("performers", 41, com/google/android/gms/internal/ib));
        Ep.put("playerType", es.a.g("playerType", 42));
        Ep.put("postOfficeBoxNumber", es.a.g("postOfficeBoxNumber", 43));
        Ep.put("postalCode", es.a.g("postalCode", 44));
        Ep.put("ratingValue", es.a.g("ratingValue", 45));
        Ep.put("reviewRating", es.a.a("reviewRating", 46, com/google/android/gms/internal/ib));
        Ep.put("startDate", es.a.g("startDate", 47));
        Ep.put("streetAddress", es.a.g("streetAddress", 48));
        Ep.put("text", es.a.g("text", 49));
        Ep.put("thumbnail", es.a.a("thumbnail", 50, com/google/android/gms/internal/ib));
        Ep.put("thumbnailUrl", es.a.g("thumbnailUrl", 51));
        Ep.put("tickerSymbol", es.a.g("tickerSymbol", 52));
        Ep.put("type", es.a.g("type", 53));
        Ep.put("url", es.a.g("url", 54));
        Ep.put("width", es.a.g("width", 55));
        Ep.put("worstRating", es.a.g("worstRating", 56));
    }
}
