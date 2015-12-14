// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
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
    implements ItemScope
{

    public static final zza CREATOR = new zza();
    private static final HashMap zzaLS;
    String mName;
    final int mVersionCode;
    String zzF;
    String zzFz;
    double zzaBD;
    double zzaBE;
    final Set zzaLT;
    ItemScopeEntity zzaLU;
    List zzaLV;
    ItemScopeEntity zzaLW;
    String zzaLX;
    String zzaLY;
    String zzaLZ;
    List zzaMA;
    String zzaMB;
    String zzaMC;
    String zzaMD;
    String zzaME;
    ItemScopeEntity zzaMF;
    String zzaMG;
    String zzaMH;
    String zzaMI;
    ItemScopeEntity zzaMJ;
    String zzaMK;
    String zzaML;
    String zzaMM;
    String zzaMN;
    List zzaMa;
    int zzaMb;
    List zzaMc;
    ItemScopeEntity zzaMd;
    List zzaMe;
    String zzaMf;
    String zzaMg;
    ItemScopeEntity zzaMh;
    String zzaMi;
    String zzaMj;
    List zzaMk;
    String zzaMl;
    String zzaMm;
    String zzaMn;
    String zzaMo;
    String zzaMp;
    String zzaMq;
    String zzaMr;
    String zzaMs;
    ItemScopeEntity zzaMt;
    String zzaMu;
    String zzaMv;
    String zzaMw;
    ItemScopeEntity zzaMx;
    ItemScopeEntity zzaMy;
    ItemScopeEntity zzaMz;
    String zzaoB;
    String zzsV;
    String zzwj;

    public ItemScopeEntity()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
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
        zzaLT = set;
        mVersionCode = i;
        zzaLU = itemscopeentity;
        zzaLV = list;
        zzaLW = itemscopeentity1;
        zzaLX = s;
        zzaLY = s1;
        zzaLZ = s2;
        zzaMa = list1;
        zzaMb = j;
        zzaMc = list2;
        zzaMd = itemscopeentity2;
        zzaMe = list3;
        zzaMf = s3;
        zzaMg = s4;
        zzaMh = itemscopeentity3;
        zzaMi = s5;
        zzaMj = s6;
        zzsV = s7;
        zzaMk = list4;
        zzaMl = s8;
        zzaMm = s9;
        zzaMn = s10;
        zzaoB = s11;
        zzaMo = s12;
        zzaMp = s13;
        zzaMq = s14;
        zzaMr = s15;
        zzaMs = s16;
        zzaMt = itemscopeentity4;
        zzaMu = s17;
        zzaMv = s18;
        zzwj = s19;
        zzaMw = s20;
        zzaMx = itemscopeentity5;
        zzaBD = d;
        zzaMy = itemscopeentity6;
        zzaBE = d1;
        mName = s21;
        zzaMz = itemscopeentity7;
        zzaMA = list5;
        zzaMB = s22;
        zzaMC = s23;
        zzaMD = s24;
        zzaME = s25;
        zzaMF = itemscopeentity8;
        zzaMG = s26;
        zzaMH = s27;
        zzaMI = s28;
        zzaMJ = itemscopeentity9;
        zzaMK = s29;
        zzaML = s30;
        zzFz = s31;
        zzF = s32;
        zzaMM = s33;
        zzaMN = s34;
    }

    public ItemScopeEntity(Set set, ItemScopeEntity itemscopeentity, List list, ItemScopeEntity itemscopeentity1, String s, String s1, String s2, 
            List list1, int i, List list2, ItemScopeEntity itemscopeentity2, List list3, String s3, String s4, 
            ItemScopeEntity itemscopeentity3, String s5, String s6, String s7, List list4, String s8, String s9, 
            String s10, String s11, String s12, String s13, String s14, String s15, String s16, 
            ItemScopeEntity itemscopeentity4, String s17, String s18, String s19, String s20, ItemScopeEntity itemscopeentity5, double d, ItemScopeEntity itemscopeentity6, double d1, String s21, ItemScopeEntity itemscopeentity7, List list5, 
            String s22, String s23, String s24, String s25, ItemScopeEntity itemscopeentity8, String s26, String s27, 
            String s28, ItemScopeEntity itemscopeentity9, String s29, String s30, String s31, String s32, String s33, 
            String s34)
    {
        zzaLT = set;
        mVersionCode = 1;
        zzaLU = itemscopeentity;
        zzaLV = list;
        zzaLW = itemscopeentity1;
        zzaLX = s;
        zzaLY = s1;
        zzaLZ = s2;
        zzaMa = list1;
        zzaMb = i;
        zzaMc = list2;
        zzaMd = itemscopeentity2;
        zzaMe = list3;
        zzaMf = s3;
        zzaMg = s4;
        zzaMh = itemscopeentity3;
        zzaMi = s5;
        zzaMj = s6;
        zzsV = s7;
        zzaMk = list4;
        zzaMl = s8;
        zzaMm = s9;
        zzaMn = s10;
        zzaoB = s11;
        zzaMo = s12;
        zzaMp = s13;
        zzaMq = s14;
        zzaMr = s15;
        zzaMs = s16;
        zzaMt = itemscopeentity4;
        zzaMu = s17;
        zzaMv = s18;
        zzwj = s19;
        zzaMw = s20;
        zzaMx = itemscopeentity5;
        zzaBD = d;
        zzaMy = itemscopeentity6;
        zzaBE = d1;
        mName = s21;
        zzaMz = itemscopeentity7;
        zzaMA = list5;
        zzaMB = s22;
        zzaMC = s23;
        zzaMD = s24;
        zzaME = s25;
        zzaMF = itemscopeentity8;
        zzaMG = s26;
        zzaMH = s27;
        zzaMI = s28;
        zzaMJ = itemscopeentity9;
        zzaMK = s29;
        zzaML = s30;
        zzFz = s31;
        zzF = s32;
        zzaMM = s33;
        zzaMN = s34;
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
                for (Iterator iterator = zzaLS.values().iterator(); iterator.hasNext();)
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

    public Object freeze()
    {
        return zzyU();
    }

    public ItemScope getAbout()
    {
        return zzaLU;
    }

    public List getAdditionalName()
    {
        return zzaLV;
    }

    public ItemScope getAddress()
    {
        return zzaLW;
    }

    public String getAddressCountry()
    {
        return zzaLX;
    }

    public String getAddressLocality()
    {
        return zzaLY;
    }

    public String getAddressRegion()
    {
        return zzaLZ;
    }

    public List getAssociated_media()
    {
        return (ArrayList)zzaMa;
    }

    public int getAttendeeCount()
    {
        return zzaMb;
    }

    public List getAttendees()
    {
        return (ArrayList)zzaMc;
    }

    public ItemScope getAudio()
    {
        return zzaMd;
    }

    public List getAuthor()
    {
        return (ArrayList)zzaMe;
    }

    public String getBestRating()
    {
        return zzaMf;
    }

    public String getBirthDate()
    {
        return zzaMg;
    }

    public ItemScope getByArtist()
    {
        return zzaMh;
    }

    public String getCaption()
    {
        return zzaMi;
    }

    public String getContentSize()
    {
        return zzaMj;
    }

    public String getContentUrl()
    {
        return zzsV;
    }

    public List getContributor()
    {
        return (ArrayList)zzaMk;
    }

    public String getDateCreated()
    {
        return zzaMl;
    }

    public String getDateModified()
    {
        return zzaMm;
    }

    public String getDatePublished()
    {
        return zzaMn;
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public String getDuration()
    {
        return zzaMo;
    }

    public String getEmbedUrl()
    {
        return zzaMp;
    }

    public String getEndDate()
    {
        return zzaMq;
    }

    public String getFamilyName()
    {
        return zzaMr;
    }

    public String getGender()
    {
        return zzaMs;
    }

    public ItemScope getGeo()
    {
        return zzaMt;
    }

    public String getGivenName()
    {
        return zzaMu;
    }

    public String getHeight()
    {
        return zzaMv;
    }

    public String getId()
    {
        return zzwj;
    }

    public String getImage()
    {
        return zzaMw;
    }

    public ItemScope getInAlbum()
    {
        return zzaMx;
    }

    public double getLatitude()
    {
        return zzaBD;
    }

    public ItemScope getLocation()
    {
        return zzaMy;
    }

    public double getLongitude()
    {
        return zzaBE;
    }

    public String getName()
    {
        return mName;
    }

    public ItemScope getPartOfTVSeries()
    {
        return zzaMz;
    }

    public List getPerformers()
    {
        return (ArrayList)zzaMA;
    }

    public String getPlayerType()
    {
        return zzaMB;
    }

    public String getPostOfficeBoxNumber()
    {
        return zzaMC;
    }

    public String getPostalCode()
    {
        return zzaMD;
    }

    public String getRatingValue()
    {
        return zzaME;
    }

    public ItemScope getReviewRating()
    {
        return zzaMF;
    }

    public String getStartDate()
    {
        return zzaMG;
    }

    public String getStreetAddress()
    {
        return zzaMH;
    }

    public String getText()
    {
        return zzaMI;
    }

    public ItemScope getThumbnail()
    {
        return zzaMJ;
    }

    public String getThumbnailUrl()
    {
        return zzaMK;
    }

    public String getTickerSymbol()
    {
        return zzaML;
    }

    public String getType()
    {
        return zzFz;
    }

    public String getUrl()
    {
        return zzF;
    }

    public String getWidth()
    {
        return zzaMM;
    }

    public String getWorstRating()
    {
        return zzaMN;
    }

    public boolean hasAbout()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName()
    {
        return zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasAddress()
    {
        return zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry()
    {
        return zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality()
    {
        return zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion()
    {
        return zzaLT.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media()
    {
        return zzaLT.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount()
    {
        return zzaLT.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees()
    {
        return zzaLT.contains(Integer.valueOf(10));
    }

    public boolean hasAudio()
    {
        return zzaLT.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor()
    {
        return zzaLT.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating()
    {
        return zzaLT.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate()
    {
        return zzaLT.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist()
    {
        return zzaLT.contains(Integer.valueOf(15));
    }

    public boolean hasCaption()
    {
        return zzaLT.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize()
    {
        return zzaLT.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl()
    {
        return zzaLT.contains(Integer.valueOf(18));
    }

    public boolean hasContributor()
    {
        return zzaLT.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated()
    {
        return zzaLT.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified()
    {
        return zzaLT.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished()
    {
        return zzaLT.contains(Integer.valueOf(22));
    }

    public boolean hasDescription()
    {
        return zzaLT.contains(Integer.valueOf(23));
    }

    public boolean hasDuration()
    {
        return zzaLT.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl()
    {
        return zzaLT.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate()
    {
        return zzaLT.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName()
    {
        return zzaLT.contains(Integer.valueOf(27));
    }

    public boolean hasGender()
    {
        return zzaLT.contains(Integer.valueOf(28));
    }

    public boolean hasGeo()
    {
        return zzaLT.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName()
    {
        return zzaLT.contains(Integer.valueOf(30));
    }

    public boolean hasHeight()
    {
        return zzaLT.contains(Integer.valueOf(31));
    }

    public boolean hasId()
    {
        return zzaLT.contains(Integer.valueOf(32));
    }

    public boolean hasImage()
    {
        return zzaLT.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum()
    {
        return zzaLT.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude()
    {
        return zzaLT.contains(Integer.valueOf(36));
    }

    public boolean hasLocation()
    {
        return zzaLT.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude()
    {
        return zzaLT.contains(Integer.valueOf(38));
    }

    public boolean hasName()
    {
        return zzaLT.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries()
    {
        return zzaLT.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers()
    {
        return zzaLT.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType()
    {
        return zzaLT.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber()
    {
        return zzaLT.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode()
    {
        return zzaLT.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue()
    {
        return zzaLT.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating()
    {
        return zzaLT.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate()
    {
        return zzaLT.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress()
    {
        return zzaLT.contains(Integer.valueOf(48));
    }

    public boolean hasText()
    {
        return zzaLT.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail()
    {
        return zzaLT.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl()
    {
        return zzaLT.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol()
    {
        return zzaLT.contains(Integer.valueOf(52));
    }

    public boolean hasType()
    {
        return zzaLT.contains(Integer.valueOf(53));
    }

    public boolean hasUrl()
    {
        return zzaLT.contains(Integer.valueOf(54));
    }

    public boolean hasWidth()
    {
        return zzaLT.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating()
    {
        return zzaLT.contains(Integer.valueOf(56));
    }

    public int hashCode()
    {
        Iterator iterator = zzaLS.values().iterator();
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
                int j = field.zzpi();
                i = zzb(field).hashCode() + (i + j);
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
        zza zza1 = CREATOR;
        com.google.android.gms.plus.internal.model.moments.zza.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        return zzaLT.contains(Integer.valueOf(field.zzpi()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        switch (field.zzpi())
        {
        case 35: // '#'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzpi()).toString());

        case 2: // '\002'
            return zzaLU;

        case 3: // '\003'
            return zzaLV;

        case 4: // '\004'
            return zzaLW;

        case 5: // '\005'
            return zzaLX;

        case 6: // '\006'
            return zzaLY;

        case 7: // '\007'
            return zzaLZ;

        case 8: // '\b'
            return zzaMa;

        case 9: // '\t'
            return Integer.valueOf(zzaMb);

        case 10: // '\n'
            return zzaMc;

        case 11: // '\013'
            return zzaMd;

        case 12: // '\f'
            return zzaMe;

        case 13: // '\r'
            return zzaMf;

        case 14: // '\016'
            return zzaMg;

        case 15: // '\017'
            return zzaMh;

        case 16: // '\020'
            return zzaMi;

        case 17: // '\021'
            return zzaMj;

        case 18: // '\022'
            return zzsV;

        case 19: // '\023'
            return zzaMk;

        case 20: // '\024'
            return zzaMl;

        case 21: // '\025'
            return zzaMm;

        case 22: // '\026'
            return zzaMn;

        case 23: // '\027'
            return zzaoB;

        case 24: // '\030'
            return zzaMo;

        case 25: // '\031'
            return zzaMp;

        case 26: // '\032'
            return zzaMq;

        case 27: // '\033'
            return zzaMr;

        case 28: // '\034'
            return zzaMs;

        case 29: // '\035'
            return zzaMt;

        case 30: // '\036'
            return zzaMu;

        case 31: // '\037'
            return zzaMv;

        case 32: // ' '
            return zzwj;

        case 33: // '!'
            return zzaMw;

        case 34: // '"'
            return zzaMx;

        case 36: // '$'
            return Double.valueOf(zzaBD);

        case 37: // '%'
            return zzaMy;

        case 38: // '&'
            return Double.valueOf(zzaBE);

        case 39: // '\''
            return mName;

        case 40: // '('
            return zzaMz;

        case 41: // ')'
            return zzaMA;

        case 42: // '*'
            return zzaMB;

        case 43: // '+'
            return zzaMC;

        case 44: // ','
            return zzaMD;

        case 45: // '-'
            return zzaME;

        case 46: // '.'
            return zzaMF;

        case 47: // '/'
            return zzaMG;

        case 48: // '0'
            return zzaMH;

        case 49: // '1'
            return zzaMI;

        case 50: // '2'
            return zzaMJ;

        case 51: // '3'
            return zzaMK;

        case 52: // '4'
            return zzaML;

        case 53: // '5'
            return zzFz;

        case 54: // '6'
            return zzF;

        case 55: // '7'
            return zzaMM;

        case 56: // '8'
            return zzaMN;
        }
    }

    public Map zzpb()
    {
        return zzyT();
    }

    public HashMap zzyT()
    {
        return zzaLS;
    }

    public ItemScopeEntity zzyU()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("about", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("about", 2, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("additionalName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzn("additionalName", 3));
        zzaLS.put("address", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("address", 4, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("addressCountry", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("addressCountry", 5));
        zzaLS.put("addressLocality", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("addressLocality", 6));
        zzaLS.put("addressRegion", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("addressRegion", 7));
        zzaLS.put("associated_media", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("associated_media", 8, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("attendeeCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("attendeeCount", 9));
        zzaLS.put("attendees", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("attendees", 10, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("audio", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("audio", 11, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("author", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("author", 12, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("bestRating", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("bestRating", 13));
        zzaLS.put("birthDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("birthDate", 14));
        zzaLS.put("byArtist", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("byArtist", 15, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("caption", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("caption", 16));
        zzaLS.put("contentSize", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("contentSize", 17));
        zzaLS.put("contentUrl", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("contentUrl", 18));
        zzaLS.put("contributor", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("contributor", 19, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("dateCreated", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("dateCreated", 20));
        zzaLS.put("dateModified", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("dateModified", 21));
        zzaLS.put("datePublished", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("datePublished", 22));
        zzaLS.put("description", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("description", 23));
        zzaLS.put("duration", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("duration", 24));
        zzaLS.put("embedUrl", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("embedUrl", 25));
        zzaLS.put("endDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("endDate", 26));
        zzaLS.put("familyName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("familyName", 27));
        zzaLS.put("gender", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("gender", 28));
        zzaLS.put("geo", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("geo", 29, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("givenName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("givenName", 30));
        zzaLS.put("height", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("height", 31));
        zzaLS.put("id", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("id", 32));
        zzaLS.put("image", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("image", 33));
        zzaLS.put("inAlbum", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("inAlbum", 34, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("latitude", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("latitude", 36));
        zzaLS.put("location", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("location", 37, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("longitude", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("longitude", 38));
        zzaLS.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("name", 39));
        zzaLS.put("partOfTVSeries", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("partOfTVSeries", 40, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("performers", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("performers", 41, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("playerType", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("playerType", 42));
        zzaLS.put("postOfficeBoxNumber", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("postOfficeBoxNumber", 43));
        zzaLS.put("postalCode", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("postalCode", 44));
        zzaLS.put("ratingValue", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("ratingValue", 45));
        zzaLS.put("reviewRating", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("reviewRating", 46, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("startDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("startDate", 47));
        zzaLS.put("streetAddress", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("streetAddress", 48));
        zzaLS.put("text", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("text", 49));
        zzaLS.put("thumbnail", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("thumbnail", 50, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("thumbnailUrl", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("thumbnailUrl", 51));
        zzaLS.put("tickerSymbol", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("tickerSymbol", 52));
        zzaLS.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("type", 53));
        zzaLS.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("url", 54));
        zzaLS.put("width", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("width", 55));
        zzaLS.put("worstRating", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("worstRating", 56));
    }
}
