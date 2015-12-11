// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal.model.people:
//            zza

public final class PersonEntity extends FastSafeParcelableJsonResponse
    implements Person
{

    public static final zza CREATOR = new zza();
    private static final HashMap zzazC;
    String zzAX;
    String zzGM;
    String zzMf;
    String zzWF;
    String zzaAB;
    AgeRangeEntity zzaAC;
    String zzaAD;
    String zzaAE;
    int zzaAF;
    CoverEntity zzaAG;
    String zzaAH;
    ImageEntity zzaAI;
    boolean zzaAJ;
    NameEntity zzaAK;
    String zzaAL;
    int zzaAM;
    List zzaAN;
    List zzaAO;
    int zzaAP;
    int zzaAQ;
    String zzaAR;
    List zzaAS;
    boolean zzaAT;
    final Set zzazD;
    int zzqm;
    final int zzzH;

    public PersonEntity()
    {
        zzzH = 1;
        zzazD = new HashSet();
    }

    public PersonEntity(String s, String s1, ImageEntity imageentity, int i, String s2)
    {
        zzzH = 1;
        zzazD = new HashSet();
        zzWF = s;
        zzazD.add(Integer.valueOf(9));
        zzGM = s1;
        zzazD.add(Integer.valueOf(14));
        zzaAI = imageentity;
        zzazD.add(Integer.valueOf(15));
        zzaAM = i;
        zzazD.add(Integer.valueOf(21));
        zzAX = s2;
        zzazD.add(Integer.valueOf(27));
    }

    PersonEntity(Set set, int i, String s, AgeRangeEntity agerangeentity, String s1, String s2, int j, 
            CoverEntity coverentity, String s3, String s4, int k, String s5, ImageEntity imageentity, boolean flag, 
            String s6, NameEntity nameentity, String s7, int l, List list, List list1, int i1, 
            int j1, String s8, String s9, List list2, boolean flag1)
    {
        zzazD = set;
        zzzH = i;
        zzaAB = s;
        zzaAC = agerangeentity;
        zzaAD = s1;
        zzaAE = s2;
        zzaAF = j;
        zzaAG = coverentity;
        zzaAH = s3;
        zzWF = s4;
        zzqm = k;
        zzGM = s5;
        zzaAI = imageentity;
        zzaAJ = flag;
        zzMf = s6;
        zzaAK = nameentity;
        zzaAL = s7;
        zzaAM = l;
        zzaAN = list;
        zzaAO = list1;
        zzaAP = i1;
        zzaAQ = j1;
        zzaAR = s8;
        zzAX = s9;
        zzaAS = list2;
        zzaAT = flag1;
    }

    public static PersonEntity zzl(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.zzeU(parcel);
        parcel.recycle();
        return abyte0;
    }

    public int describeContents()
    {
        zza zza1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof PersonEntity))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (PersonEntity)obj;
            com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
            do
            {
                for (Iterator iterator = zzazC.values().iterator(); iterator.hasNext();)
                {
                    field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                    if (!zza(field))
                    {
                        continue label1;
                    }
                    if (((PersonEntity) (obj)).zza(field))
                    {
                        if (!zzb(field).equals(((PersonEntity) (obj)).zzb(field)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((PersonEntity) (obj)).zza(field));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzvP();
    }

    public String getAboutMe()
    {
        return zzaAB;
    }

    public com.google.android.gms.plus.model.people.Person.AgeRange getAgeRange()
    {
        return zzaAC;
    }

    public String getBirthday()
    {
        return zzaAD;
    }

    public String getBraggingRights()
    {
        return zzaAE;
    }

    public int getCircledByCount()
    {
        return zzaAF;
    }

    public com.google.android.gms.plus.model.people.Person.Cover getCover()
    {
        return zzaAG;
    }

    public String getCurrentLocation()
    {
        return zzaAH;
    }

    public String getDisplayName()
    {
        return zzWF;
    }

    public int getGender()
    {
        return zzqm;
    }

    public String getId()
    {
        return zzGM;
    }

    public com.google.android.gms.plus.model.people.Person.Image getImage()
    {
        return zzaAI;
    }

    public String getLanguage()
    {
        return zzMf;
    }

    public com.google.android.gms.plus.model.people.Person.Name getName()
    {
        return zzaAK;
    }

    public String getNickname()
    {
        return zzaAL;
    }

    public int getObjectType()
    {
        return zzaAM;
    }

    public List getOrganizations()
    {
        return (ArrayList)zzaAN;
    }

    public List getPlacesLived()
    {
        return (ArrayList)zzaAO;
    }

    public int getPlusOneCount()
    {
        return zzaAP;
    }

    public int getRelationshipStatus()
    {
        return zzaAQ;
    }

    public String getTagline()
    {
        return zzaAR;
    }

    public String getUrl()
    {
        return zzAX;
    }

    public List getUrls()
    {
        return (ArrayList)zzaAS;
    }

    public boolean hasAboutMe()
    {
        return zzazD.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange()
    {
        return zzazD.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday()
    {
        return zzazD.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights()
    {
        return zzazD.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount()
    {
        return zzazD.contains(Integer.valueOf(6));
    }

    public boolean hasCover()
    {
        return zzazD.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation()
    {
        return zzazD.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName()
    {
        return zzazD.contains(Integer.valueOf(9));
    }

    public boolean hasGender()
    {
        return zzazD.contains(Integer.valueOf(12));
    }

    public boolean hasId()
    {
        return zzazD.contains(Integer.valueOf(14));
    }

    public boolean hasImage()
    {
        return zzazD.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser()
    {
        return zzazD.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage()
    {
        return zzazD.contains(Integer.valueOf(18));
    }

    public boolean hasName()
    {
        return zzazD.contains(Integer.valueOf(19));
    }

    public boolean hasNickname()
    {
        return zzazD.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType()
    {
        return zzazD.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations()
    {
        return zzazD.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived()
    {
        return zzazD.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount()
    {
        return zzazD.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus()
    {
        return zzazD.contains(Integer.valueOf(25));
    }

    public boolean hasTagline()
    {
        return zzazD.contains(Integer.valueOf(26));
    }

    public boolean hasUrl()
    {
        return zzazD.contains(Integer.valueOf(27));
    }

    public boolean hasUrls()
    {
        return zzazD.contains(Integer.valueOf(28));
    }

    public boolean hasVerified()
    {
        return zzazD.contains(Integer.valueOf(29));
    }

    public int hashCode()
    {
        Iterator iterator = zzazC.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
            if (zza(field))
            {
                int j = field.zzmF();
                i = zzb(field).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public boolean isPlusUser()
    {
        return zzaAJ;
    }

    public boolean isVerified()
    {
        return zzaAT;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza zza1 = CREATOR;
        com.google.android.gms.plus.internal.model.people.zza.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        return zzazD.contains(Integer.valueOf(field.zzmF()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        switch (field.zzmF())
        {
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzmF()).toString());

        case 2: // '\002'
            return zzaAB;

        case 3: // '\003'
            return zzaAC;

        case 4: // '\004'
            return zzaAD;

        case 5: // '\005'
            return zzaAE;

        case 6: // '\006'
            return Integer.valueOf(zzaAF);

        case 7: // '\007'
            return zzaAG;

        case 8: // '\b'
            return zzaAH;

        case 9: // '\t'
            return zzWF;

        case 12: // '\f'
            return Integer.valueOf(zzqm);

        case 14: // '\016'
            return zzGM;

        case 15: // '\017'
            return zzaAI;

        case 16: // '\020'
            return Boolean.valueOf(zzaAJ);

        case 18: // '\022'
            return zzMf;

        case 19: // '\023'
            return zzaAK;

        case 20: // '\024'
            return zzaAL;

        case 21: // '\025'
            return Integer.valueOf(zzaAM);

        case 22: // '\026'
            return zzaAN;

        case 23: // '\027'
            return zzaAO;

        case 24: // '\030'
            return Integer.valueOf(zzaAP);

        case 25: // '\031'
            return Integer.valueOf(zzaAQ);

        case 26: // '\032'
            return zzaAR;

        case 27: // '\033'
            return zzAX;

        case 28: // '\034'
            return zzaAS;

        case 29: // '\035'
            return Boolean.valueOf(zzaAT);
        }
    }

    public Map zzmy()
    {
        return zzvL();
    }

    public HashMap zzvL()
    {
        return zzazC;
    }

    public PersonEntity zzvP()
    {
        return this;
    }

    static 
    {
        zzazC = new HashMap();
        zzazC.put("aboutMe", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("aboutMe", 2));
        zzazC.put("ageRange", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("ageRange", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$AgeRangeEntity));
        zzazC.put("birthday", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("birthday", 4));
        zzazC.put("braggingRights", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("braggingRights", 5));
        zzazC.put("circledByCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzh("circledByCount", 6));
        zzazC.put("cover", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("cover", 7, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity));
        zzazC.put("currentLocation", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("currentLocation", 8));
        zzazC.put("displayName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("displayName", 9));
        zzazC.put("gender", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("gender", 12, (new StringToIntConverter()).zzg("male", 0).zzg("female", 1).zzg("other", 2), false));
        zzazC.put("id", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("id", 14));
        zzazC.put("image", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("image", 15, com/google/android/gms/plus/internal/model/people/PersonEntity$ImageEntity));
        zzazC.put("isPlusUser", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("isPlusUser", 16));
        zzazC.put("language", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("language", 18));
        zzazC.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("name", 19, com/google/android/gms/plus/internal/model/people/PersonEntity$NameEntity));
        zzazC.put("nickname", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("nickname", 20));
        zzazC.put("objectType", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("objectType", 21, (new StringToIntConverter()).zzg("person", 0).zzg("page", 1), false));
        zzazC.put("organizations", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("organizations", 22, com/google/android/gms/plus/internal/model/people/PersonEntity$OrganizationsEntity));
        zzazC.put("placesLived", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("placesLived", 23, com/google/android/gms/plus/internal/model/people/PersonEntity$PlacesLivedEntity));
        zzazC.put("plusOneCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzh("plusOneCount", 24));
        zzazC.put("relationshipStatus", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("relationshipStatus", 25, (new StringToIntConverter()).zzg("single", 0).zzg("in_a_relationship", 1).zzg("engaged", 2).zzg("married", 3).zzg("its_complicated", 4).zzg("open_relationship", 5).zzg("widowed", 6).zzg("in_domestic_partnership", 7).zzg("in_civil_union", 8), false));
        zzazC.put("tagline", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("tagline", 26));
        zzazC.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("url", 27));
        zzazC.put("urls", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("urls", 28, com/google/android/gms/plus/internal/model/people/PersonEntity$UrlsEntity));
        zzazC.put("verified", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("verified", 29));
    }
}
