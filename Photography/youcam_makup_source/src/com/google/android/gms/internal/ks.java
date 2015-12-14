// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hy, kt, hv

public final class ks extends hy
    implements SafeParcelable, Person
{

    public static final kt CREATOR = new kt();
    private static final HashMap acr;
    private String Ar;
    private String Ln;
    private final Set acs;
    private String adA;
    private int adB;
    private List adC;
    private List adD;
    private int adE;
    private int adF;
    private String adG;
    private List adH;
    private boolean adI;
    private String adq;
    private a adr;
    private String ads;
    private String adt;
    private int adu;
    private b adv;
    private String adw;
    private c adx;
    private boolean ady;
    private d adz;
    private int ml;
    private String qY;
    private String xG;
    private final int xM;

    public ks()
    {
        xM = 2;
        acs = new HashSet();
    }

    public ks(String s, String s1, c c, int j, String s2)
    {
        xM = 2;
        acs = new HashSet();
        Ln = s;
        acs.add(Integer.valueOf(9));
        xG = s1;
        acs.add(Integer.valueOf(14));
        adx = c;
        acs.add(Integer.valueOf(15));
        adB = j;
        acs.add(Integer.valueOf(21));
        qY = s2;
        acs.add(Integer.valueOf(27));
    }

    ks(Set set, int j, String s, a a1, String s1, String s2, int k, 
            b b1, String s3, String s4, int l, String s5, c c, boolean flag, 
            String s6, d d, String s7, int i1, List list, List list1, int j1, 
            int k1, String s8, String s9, List list2, boolean flag1)
    {
        acs = set;
        xM = j;
        adq = s;
        adr = a1;
        ads = s1;
        adt = s2;
        adu = k;
        adv = b1;
        adw = s3;
        Ln = s4;
        ml = l;
        xG = s5;
        adx = c;
        ady = flag;
        Ar = s6;
        adz = d;
        adA = s7;
        adB = i1;
        adC = list;
        adD = list1;
        adE = j1;
        adF = k1;
        adG = s8;
        qY = s9;
        adH = list2;
        adI = flag1;
    }

    public static ks i(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.bG(parcel);
        parcel.recycle();
        return abyte0;
    }

    protected boolean a(hy.a a1)
    {
        return acs.contains(Integer.valueOf(a1.fN()));
    }

    protected Object aF(String s)
    {
        return null;
    }

    protected boolean aG(String s)
    {
        return false;
    }

    protected Object b(hy.a a1)
    {
        switch (a1.fN())
        {
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(a1.fN()).toString());

        case 2: // '\002'
            return adq;

        case 3: // '\003'
            return adr;

        case 4: // '\004'
            return ads;

        case 5: // '\005'
            return adt;

        case 6: // '\006'
            return Integer.valueOf(adu);

        case 7: // '\007'
            return adv;

        case 8: // '\b'
            return adw;

        case 9: // '\t'
            return Ln;

        case 12: // '\f'
            return Integer.valueOf(ml);

        case 14: // '\016'
            return xG;

        case 15: // '\017'
            return adx;

        case 16: // '\020'
            return Boolean.valueOf(ady);

        case 18: // '\022'
            return Ar;

        case 19: // '\023'
            return adz;

        case 20: // '\024'
            return adA;

        case 21: // '\025'
            return Integer.valueOf(adB);

        case 22: // '\026'
            return adC;

        case 23: // '\027'
            return adD;

        case 24: // '\030'
            return Integer.valueOf(adE);

        case 25: // '\031'
            return Integer.valueOf(adF);

        case 26: // '\032'
            return adG;

        case 27: // '\033'
            return qY;

        case 28: // '\034'
            return adH;

        case 29: // '\035'
            return Boolean.valueOf(adI);
        }
    }

    public int describeContents()
    {
        kt kt1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof ks))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (ks)obj;
            hy.a a1;
label1:
            do
            {
                for (Iterator iterator = acr.values().iterator(); iterator.hasNext();)
                {
                    a1 = (hy.a)iterator.next();
                    if (!a(a1))
                    {
                        continue label1;
                    }
                    if (((ks) (obj)).a(a1))
                    {
                        if (!b(a1).equals(((ks) (obj)).b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((ks) (obj)).a(a1));
            return false;
        }
        return true;
    }

    public HashMap fG()
    {
        return acr;
    }

    public Object freeze()
    {
        return kM();
    }

    public String getAboutMe()
    {
        return adq;
    }

    public com.google.android.gms.plus.model.people.Person.AgeRange getAgeRange()
    {
        return adr;
    }

    public String getBirthday()
    {
        return ads;
    }

    public String getBraggingRights()
    {
        return adt;
    }

    public int getCircledByCount()
    {
        return adu;
    }

    public com.google.android.gms.plus.model.people.Person.Cover getCover()
    {
        return adv;
    }

    public String getCurrentLocation()
    {
        return adw;
    }

    public String getDisplayName()
    {
        return Ln;
    }

    public int getGender()
    {
        return ml;
    }

    public String getId()
    {
        return xG;
    }

    public com.google.android.gms.plus.model.people.Person.Image getImage()
    {
        return adx;
    }

    public String getLanguage()
    {
        return Ar;
    }

    public com.google.android.gms.plus.model.people.Person.Name getName()
    {
        return adz;
    }

    public String getNickname()
    {
        return adA;
    }

    public int getObjectType()
    {
        return adB;
    }

    public List getOrganizations()
    {
        return (ArrayList)adC;
    }

    public List getPlacesLived()
    {
        return (ArrayList)adD;
    }

    public int getPlusOneCount()
    {
        return adE;
    }

    public int getRelationshipStatus()
    {
        return adF;
    }

    public String getTagline()
    {
        return adG;
    }

    public String getUrl()
    {
        return qY;
    }

    public List getUrls()
    {
        return (ArrayList)adH;
    }

    int getVersionCode()
    {
        return xM;
    }

    public boolean hasAboutMe()
    {
        return acs.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange()
    {
        return acs.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday()
    {
        return acs.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights()
    {
        return acs.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount()
    {
        return acs.contains(Integer.valueOf(6));
    }

    public boolean hasCover()
    {
        return acs.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation()
    {
        return acs.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName()
    {
        return acs.contains(Integer.valueOf(9));
    }

    public boolean hasGender()
    {
        return acs.contains(Integer.valueOf(12));
    }

    public boolean hasId()
    {
        return acs.contains(Integer.valueOf(14));
    }

    public boolean hasImage()
    {
        return acs.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser()
    {
        return acs.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage()
    {
        return acs.contains(Integer.valueOf(18));
    }

    public boolean hasName()
    {
        return acs.contains(Integer.valueOf(19));
    }

    public boolean hasNickname()
    {
        return acs.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType()
    {
        return acs.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations()
    {
        return acs.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived()
    {
        return acs.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount()
    {
        return acs.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus()
    {
        return acs.contains(Integer.valueOf(25));
    }

    public boolean hasTagline()
    {
        return acs.contains(Integer.valueOf(26));
    }

    public boolean hasUrl()
    {
        return acs.contains(Integer.valueOf(27));
    }

    public boolean hasUrls()
    {
        return acs.contains(Integer.valueOf(28));
    }

    public boolean hasVerified()
    {
        return acs.contains(Integer.valueOf(29));
    }

    public int hashCode()
    {
        Iterator iterator = acr.values().iterator();
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            hy.a a1 = (hy.a)iterator.next();
            if (a(a1))
            {
                int k = a1.fN();
                j = b(a1).hashCode() + (j + k);
            }
        } while (true);
        return j;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public boolean isPlusUser()
    {
        return ady;
    }

    public boolean isVerified()
    {
        return adI;
    }

    a kF()
    {
        return adr;
    }

    b kG()
    {
        return adv;
    }

    c kH()
    {
        return adx;
    }

    d kI()
    {
        return adz;
    }

    List kJ()
    {
        return adC;
    }

    List kK()
    {
        return adD;
    }

    List kL()
    {
        return adH;
    }

    public ks kM()
    {
        return this;
    }

    Set kk()
    {
        return acs;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        kt kt1 = CREATOR;
        kt.a(this, parcel, j);
    }

    static 
    {
        acr = new HashMap();
        acr.put("aboutMe", hy.a.j("aboutMe", 2));
        acr.put("ageRange", hy.a.a("ageRange", 3, com/google/android/gms/internal/ks$a));
        acr.put("birthday", hy.a.j("birthday", 4));
        acr.put("braggingRights", hy.a.j("braggingRights", 5));
        acr.put("circledByCount", hy.a.g("circledByCount", 6));
        acr.put("cover", hy.a.a("cover", 7, com/google/android/gms/internal/ks$b));
        acr.put("currentLocation", hy.a.j("currentLocation", 8));
        acr.put("displayName", hy.a.j("displayName", 9));
        acr.put("gender", hy.a.a("gender", 12, (new hv()).f("male", 0).f("female", 1).f("other", 2), false));
        acr.put("id", hy.a.j("id", 14));
        acr.put("image", hy.a.a("image", 15, com/google/android/gms/internal/ks$c));
        acr.put("isPlusUser", hy.a.i("isPlusUser", 16));
        acr.put("language", hy.a.j("language", 18));
        acr.put("name", hy.a.a("name", 19, com/google/android/gms/internal/ks$d));
        acr.put("nickname", hy.a.j("nickname", 20));
        acr.put("objectType", hy.a.a("objectType", 21, (new hv()).f("person", 0).f("page", 1), false));
        acr.put("organizations", hy.a.b("organizations", 22, com/google/android/gms/internal/ks$f));
        acr.put("placesLived", hy.a.b("placesLived", 23, com/google/android/gms/internal/ks$g));
        acr.put("plusOneCount", hy.a.g("plusOneCount", 24));
        acr.put("relationshipStatus", hy.a.a("relationshipStatus", 25, (new hv()).f("single", 0).f("in_a_relationship", 1).f("engaged", 2).f("married", 3).f("its_complicated", 4).f("open_relationship", 5).f("widowed", 6).f("in_domestic_partnership", 7).f("in_civil_union", 8), false));
        acr.put("tagline", hy.a.j("tagline", 26));
        acr.put("url", hy.a.j("url", 27));
        acr.put("urls", hy.a.b("urls", 28, com/google/android/gms/internal/ks$h));
        acr.put("verified", hy.a.i("verified", 29));
    }
}
