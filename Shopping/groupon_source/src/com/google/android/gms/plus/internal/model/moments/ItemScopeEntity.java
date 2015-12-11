// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal.model.moments:
//            zza

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse
{

    public static final zza CREATOR = new zza();
    private static final HashMap zzaHP;
    String mName;
    final int zzCY;
    String zzEl;
    String zzF;
    String zzKI;
    final Set zzaHQ;
    ItemScopeEntity zzaHR;
    List zzaHS;
    ItemScopeEntity zzaHT;
    String zzaHU;
    String zzaHV;
    String zzaHW;
    List zzaHX;
    int zzaHY;
    List zzaHZ;
    String zzaIA;
    String zzaIB;
    ItemScopeEntity zzaIC;
    String zzaID;
    String zzaIE;
    String zzaIF;
    ItemScopeEntity zzaIG;
    String zzaIH;
    String zzaII;
    String zzaIJ;
    String zzaIK;
    ItemScopeEntity zzaIa;
    List zzaIb;
    String zzaIc;
    String zzaId;
    ItemScopeEntity zzaIe;
    String zzaIf;
    String zzaIg;
    List zzaIh;
    String zzaIi;
    String zzaIj;
    String zzaIk;
    String zzaIl;
    String zzaIm;
    String zzaIn;
    String zzaIo;
    String zzaIp;
    ItemScopeEntity zzaIq;
    String zzaIr;
    String zzaIs;
    String zzaIt;
    ItemScopeEntity zzaIu;
    ItemScopeEntity zzaIv;
    ItemScopeEntity zzaIw;
    List zzaIx;
    String zzaIy;
    String zzaIz;
    String zzakM;
    double zzaxB;
    double zzaxC;
    String zzsB;

    public ItemScopeEntity()
    {
        zzCY = 1;
        zzaHQ = new HashSet();
    }

    ItemScopeEntity(Set set, int i, ItemScopeEntity itemscopeentity, List list, ItemScopeEntity itemscopeentity1, String s, String s1, 
            String s2, List list1, int j, List list2, ItemScopeEntity itemscopeentity2, List list3, String s3, 
            String s4, ItemScopeEntity itemscopeentity3, String s5, String s6, String s7, List list4, String s8, 
            String s9, String s10, String s11, String s12, String s13, String s14, String s15, 
            String s16, ItemScopeEntity itemscopeentity4, String s17, String s18, String s19, String s20, ItemScopeEntity itemscopeentity5, 
            double d, ItemScopeEntity itemscopeentity6, double d1, String s21, ItemScopeEntity itemscopeentity7, 
            List list5, String s22, String s23, String s24, String s25, ItemScopeEntity itemscopeentity8, String s26, 
            String s27, String s28, ItemScopeEntity itemscopeentity9, String s29, String s30, String s31, String s32, 
            String s33, String s34)
    {
        zzaHQ = set;
        zzCY = i;
        zzaHR = itemscopeentity;
        zzaHS = list;
        zzaHT = itemscopeentity1;
        zzaHU = s;
        zzaHV = s1;
        zzaHW = s2;
        zzaHX = list1;
        zzaHY = j;
        zzaHZ = list2;
        zzaIa = itemscopeentity2;
        zzaIb = list3;
        zzaIc = s3;
        zzaId = s4;
        zzaIe = itemscopeentity3;
        zzaIf = s5;
        zzaIg = s6;
        zzsB = s7;
        zzaIh = list4;
        zzaIi = s8;
        zzaIj = s9;
        zzaIk = s10;
        zzakM = s11;
        zzaIl = s12;
        zzaIm = s13;
        zzaIn = s14;
        zzaIo = s15;
        zzaIp = s16;
        zzaIq = itemscopeentity4;
        zzaIr = s17;
        zzaIs = s18;
        zzKI = s19;
        zzaIt = s20;
        zzaIu = itemscopeentity5;
        zzaxB = d;
        zzaIv = itemscopeentity6;
        zzaxC = d1;
        mName = s21;
        zzaIw = itemscopeentity7;
        zzaIx = list5;
        zzaIy = s22;
        zzaIz = s23;
        zzaIA = s24;
        zzaIB = s25;
        zzaIC = itemscopeentity8;
        zzaID = s26;
        zzaIE = s27;
        zzaIF = s28;
        zzaIG = itemscopeentity9;
        zzaIH = s29;
        zzaII = s30;
        zzEl = s31;
        zzF = s32;
        zzaIJ = s33;
        zzaIK = s34;
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
            if (!(obj instanceof ItemScopeEntity))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (ItemScopeEntity)obj;
            com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
            do
            {
                for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
                {
                    field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                    if (!zza(field))
                    {
                        continue label1;
                    }
                    if (((ItemScopeEntity) (obj)).zza(field))
                    {
                        if (!zzb(field).equals(((ItemScopeEntity) (obj)).zzb(field)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((ItemScopeEntity) (obj)).zza(field));
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        Iterator iterator = zzaHP.values().iterator();
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
                int j = field.zzot();
                i = zzb(field).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza zza1 = CREATOR;
        com.google.android.gms.plus.internal.model.moments.zza.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        return zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        switch (field.zzot())
        {
        case 35: // '#'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

        case 2: // '\002'
            return zzaHR;

        case 3: // '\003'
            return zzaHS;

        case 4: // '\004'
            return zzaHT;

        case 5: // '\005'
            return zzaHU;

        case 6: // '\006'
            return zzaHV;

        case 7: // '\007'
            return zzaHW;

        case 8: // '\b'
            return zzaHX;

        case 9: // '\t'
            return Integer.valueOf(zzaHY);

        case 10: // '\n'
            return zzaHZ;

        case 11: // '\013'
            return zzaIa;

        case 12: // '\f'
            return zzaIb;

        case 13: // '\r'
            return zzaIc;

        case 14: // '\016'
            return zzaId;

        case 15: // '\017'
            return zzaIe;

        case 16: // '\020'
            return zzaIf;

        case 17: // '\021'
            return zzaIg;

        case 18: // '\022'
            return zzsB;

        case 19: // '\023'
            return zzaIh;

        case 20: // '\024'
            return zzaIi;

        case 21: // '\025'
            return zzaIj;

        case 22: // '\026'
            return zzaIk;

        case 23: // '\027'
            return zzakM;

        case 24: // '\030'
            return zzaIl;

        case 25: // '\031'
            return zzaIm;

        case 26: // '\032'
            return zzaIn;

        case 27: // '\033'
            return zzaIo;

        case 28: // '\034'
            return zzaIp;

        case 29: // '\035'
            return zzaIq;

        case 30: // '\036'
            return zzaIr;

        case 31: // '\037'
            return zzaIs;

        case 32: // ' '
            return zzKI;

        case 33: // '!'
            return zzaIt;

        case 34: // '"'
            return zzaIu;

        case 36: // '$'
            return Double.valueOf(zzaxB);

        case 37: // '%'
            return zzaIv;

        case 38: // '&'
            return Double.valueOf(zzaxC);

        case 39: // '\''
            return mName;

        case 40: // '('
            return zzaIw;

        case 41: // ')'
            return zzaIx;

        case 42: // '*'
            return zzaIy;

        case 43: // '+'
            return zzaIz;

        case 44: // ','
            return zzaIA;

        case 45: // '-'
            return zzaIB;

        case 46: // '.'
            return zzaIC;

        case 47: // '/'
            return zzaID;

        case 48: // '0'
            return zzaIE;

        case 49: // '1'
            return zzaIF;

        case 50: // '2'
            return zzaIG;

        case 51: // '3'
            return zzaIH;

        case 52: // '4'
            return zzaII;

        case 53: // '5'
            return zzEl;

        case 54: // '6'
            return zzF;

        case 55: // '7'
            return zzaIJ;

        case 56: // '8'
            return zzaIK;
        }
    }

    public Map zzom()
    {
        return zzxF();
    }

    public HashMap zzxF()
    {
        return zzaHP;
    }

    static 
    {
        zzaHP = new HashMap();
        zzaHP.put("about", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("about", 2, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("additionalName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("additionalName", 3));
        zzaHP.put("address", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("address", 4, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("addressCountry", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("addressCountry", 5));
        zzaHP.put("addressLocality", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("addressLocality", 6));
        zzaHP.put("addressRegion", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("addressRegion", 7));
        zzaHP.put("associated_media", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("associated_media", 8, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("attendeeCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("attendeeCount", 9));
        zzaHP.put("attendees", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("attendees", 10, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("audio", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("audio", 11, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("author", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("author", 12, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("bestRating", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("bestRating", 13));
        zzaHP.put("birthDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("birthDate", 14));
        zzaHP.put("byArtist", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("byArtist", 15, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("caption", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("caption", 16));
        zzaHP.put("contentSize", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("contentSize", 17));
        zzaHP.put("contentUrl", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("contentUrl", 18));
        zzaHP.put("contributor", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("contributor", 19, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("dateCreated", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("dateCreated", 20));
        zzaHP.put("dateModified", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("dateModified", 21));
        zzaHP.put("datePublished", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("datePublished", 22));
        zzaHP.put("description", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("description", 23));
        zzaHP.put("duration", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("duration", 24));
        zzaHP.put("embedUrl", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("embedUrl", 25));
        zzaHP.put("endDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("endDate", 26));
        zzaHP.put("familyName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("familyName", 27));
        zzaHP.put("gender", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("gender", 28));
        zzaHP.put("geo", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("geo", 29, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("givenName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("givenName", 30));
        zzaHP.put("height", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("height", 31));
        zzaHP.put("id", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("id", 32));
        zzaHP.put("image", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("image", 33));
        zzaHP.put("inAlbum", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("inAlbum", 34, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("latitude", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("latitude", 36));
        zzaHP.put("location", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("location", 37, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("longitude", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("longitude", 38));
        zzaHP.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("name", 39));
        zzaHP.put("partOfTVSeries", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("partOfTVSeries", 40, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("performers", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("performers", 41, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("playerType", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("playerType", 42));
        zzaHP.put("postOfficeBoxNumber", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
        zzaHP.put("postalCode", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("postalCode", 44));
        zzaHP.put("ratingValue", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("ratingValue", 45));
        zzaHP.put("reviewRating", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("reviewRating", 46, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("startDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("startDate", 47));
        zzaHP.put("streetAddress", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("streetAddress", 48));
        zzaHP.put("text", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("text", 49));
        zzaHP.put("thumbnail", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("thumbnail", 50, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaHP.put("thumbnailUrl", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("thumbnailUrl", 51));
        zzaHP.put("tickerSymbol", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("tickerSymbol", 52));
        zzaHP.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("type", 53));
        zzaHP.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("url", 54));
        zzaHP.put("width", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("width", 55));
        zzaHP.put("worstRating", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("worstRating", 56));
    }
}
