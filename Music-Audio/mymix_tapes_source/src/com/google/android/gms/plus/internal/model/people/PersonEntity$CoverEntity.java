// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal.model.people:
//            PersonEntity, zzc, zzd, zze

public static final class zzaNo extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.onResponse
{
    public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
    {

        public static final zzd CREATOR = new zzd();
        private static final HashMap zzaLS;
        final int mVersionCode;
        final Set zzaLT;
        int zzaNp;
        int zzaNq;

        public int describeContents()
        {
            zzd zzd1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof CoverInfoEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverInfoEntity)obj;
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
                        if (((CoverInfoEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((CoverInfoEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverInfoEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzza();
        }

        public int getLeftImageOffset()
        {
            return zzaNp;
        }

        public int getTopImageOffset()
        {
            return zzaNq;
        }

        public boolean hasLeftImageOffset()
        {
            return zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasTopImageOffset()
        {
            return zzaLT.contains(Integer.valueOf(3));
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
            zzd zzd1 = CREATOR;
            zzd.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzpi())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzpi()).toString());

            case 2: // '\002'
                return Integer.valueOf(zzaNp);

            case 3: // '\003'
                return Integer.valueOf(zzaNq);
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

        public CoverInfoEntity zzza()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("leftImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("leftImageOffset", 2));
            zzaLS.put("topImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("topImageOffset", 3));
        }

        public CoverInfoEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        CoverInfoEntity(Set set, int i, int j, int k)
        {
            zzaLT = set;
            mVersionCode = i;
            zzaNp = j;
            zzaNq = k;
        }
    }

    public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
    {

        public static final zze CREATOR = new zze();
        private static final HashMap zzaLS;
        final int mVersionCode;
        String zzF;
        final Set zzaLT;
        int zznP;
        int zznQ;

        public int describeContents()
        {
            zze zze1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof CoverPhotoEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverPhotoEntity)obj;
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
                        if (((CoverPhotoEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((CoverPhotoEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverPhotoEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzzb();
        }

        public int getHeight()
        {
            return zznQ;
        }

        public String getUrl()
        {
            return zzF;
        }

        public int getWidth()
        {
            return zznP;
        }

        public boolean hasHeight()
        {
            return zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasUrl()
        {
            return zzaLT.contains(Integer.valueOf(3));
        }

        public boolean hasWidth()
        {
            return zzaLT.contains(Integer.valueOf(4));
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
            zze zze1 = CREATOR;
            zze.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzpi())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzpi()).toString());

            case 2: // '\002'
                return Integer.valueOf(zznQ);

            case 3: // '\003'
                return zzF;

            case 4: // '\004'
                return Integer.valueOf(zznP);
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

        public CoverPhotoEntity zzzb()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("height", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("height", 2));
            zzaLS.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("url", 3));
            zzaLS.put("width", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("width", 4));
        }

        public CoverPhotoEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        CoverPhotoEntity(Set set, int i, int j, String s, int k)
        {
            zzaLT = set;
            mVersionCode = i;
            zznQ = j;
            zzF = s;
            zznP = k;
        }
    }


    public static final zzc CREATOR = new zzc();
    private static final HashMap zzaLS;
    final int mVersionCode;
    final Set zzaLT;
    CoverInfoEntity zzaNm;
    CoverPhotoEntity zzaNn;
    int zzaNo;

    public int describeContents()
    {
        zzc zzc1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof CREATOR))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (CREATOR)obj;
            com.google.android.gms.common.server.response.ity ity;
label1:
            do
            {
                for (Iterator iterator = zzaLS.values().iterator(); iterator.hasNext();)
                {
                    ity = (com.google.android.gms.common.server.response.ity.zzaLS)iterator.next();
                    if (!zza(ity))
                    {
                        continue label1;
                    }
                    if (((zza) (obj)).zza(ity))
                    {
                        if (!zzb(ity).equals(((zzb) (obj)).zzb(ity)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((zzb) (obj)).zza(ity));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzyZ();
    }

    public com.google.android.gms.plus.model.people.erEntity getCoverInfo()
    {
        return zzaNm;
    }

    public com.google.android.gms.plus.model.people.erEntity getCoverPhoto()
    {
        return zzaNn;
    }

    public int getLayout()
    {
        return zzaNo;
    }

    public boolean hasCoverInfo()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasCoverPhoto()
    {
        return zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasLayout()
    {
        return zzaLT.contains(Integer.valueOf(4));
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
            com.google.android.gms.common.server.response.ity ity = (com.google.android.gms.common.server.response.ity.zzaLS)iterator.next();
            if (zza(ity))
            {
                int j = ity.pi();
                i = zzb(ity).hashCode() + (i + j);
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
        zzc zzc1 = CREATOR;
        zzc.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.ity ity)
    {
        return zzaLT.contains(Integer.valueOf(ity.pi()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.ity ity)
    {
        switch (ity.pi())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(ity.pi()).toString());

        case 2: // '\002'
            return zzaNm;

        case 3: // '\003'
            return zzaNn;

        case 4: // '\004'
            return Integer.valueOf(zzaNo);
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

    public zzaLS zzyZ()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("coverInfo", com.google.android.gms.common.server.response.a("coverInfo", 2, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverInfoEntity));
        zzaLS.put("coverPhoto", com.google.android.gms.common.server.response.a("coverPhoto", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverPhotoEntity));
        zzaLS.put("layout", com.google.android.gms.common.server.response.a("layout", 4, (new StringToIntConverter()).zzi("banner", 0), false));
    }

    public CoverPhotoEntity()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    CoverPhotoEntity(Set set, int i, CoverInfoEntity coverinfoentity, CoverPhotoEntity coverphotoentity, int j)
    {
        zzaLT = set;
        mVersionCode = i;
        zzaNm = coverinfoentity;
        zzaNn = coverphotoentity;
        zzaNo = j;
    }
}
