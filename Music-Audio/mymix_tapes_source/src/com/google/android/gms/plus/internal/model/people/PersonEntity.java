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
//            zza, zzb, zzc, zzd, 
//            zze, zzf, zzg, zzh, 
//            zzi, zzj

public final class PersonEntity extends FastSafeParcelableJsonResponse
    implements Person
{
    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.AgeRange
    {

        public static final zzb CREATOR = new zzb();
        private static final HashMap zzaLS;
        final int mVersionCode;
        final Set zzaLT;
        int zzaNk;
        int zzaNl;

        public int describeContents()
        {
            zzb zzb1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof AgeRangeEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (AgeRangeEntity)obj;
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
                        if (((AgeRangeEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((AgeRangeEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((AgeRangeEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzyY();
        }

        public int getMax()
        {
            return zzaNk;
        }

        public int getMin()
        {
            return zzaNl;
        }

        public boolean hasMax()
        {
            return zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasMin()
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
            zzb zzb1 = CREATOR;
            com.google.android.gms.plus.internal.model.people.zzb.zza(this, parcel, i);
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
                return Integer.valueOf(zzaNk);

            case 3: // '\003'
                return Integer.valueOf(zzaNl);
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

        public AgeRangeEntity zzyY()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("max", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("max", 2));
            zzaLS.put("min", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("min", 3));
        }

        public AgeRangeEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        AgeRangeEntity(Set set, int i, int j, int k)
        {
            zzaLT = set;
            mVersionCode = i;
            zzaNk = j;
            zzaNl = k;
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.Cover
    {

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
                if (!(obj instanceof CoverEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverEntity)obj;
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
                        if (((CoverEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((CoverEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzyZ();
        }

        public com.google.android.gms.plus.model.people.Person.Cover.CoverInfo getCoverInfo()
        {
            return zzaNm;
        }

        public com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto getCoverPhoto()
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
            zzc zzc1 = CREATOR;
            zzc.zza(this, parcel, i);
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

        public CoverEntity zzyZ()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("coverInfo", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("coverInfo", 2, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverInfoEntity));
            zzaLS.put("coverPhoto", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("coverPhoto", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverPhotoEntity));
            zzaLS.put("layout", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("layout", 4, (new StringToIntConverter()).zzi("banner", 0), false));
        }

        public CoverEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        CoverEntity(Set set, int i, CoverInfoEntity coverinfoentity, CoverPhotoEntity coverphotoentity, int j)
        {
            zzaLT = set;
            mVersionCode = i;
            zzaNm = coverinfoentity;
            zzaNn = coverphotoentity;
            zzaNo = j;
        }
    }

    public static final class CoverEntity.CoverInfoEntity extends FastSafeParcelableJsonResponse
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
                if (!(obj instanceof CoverEntity.CoverInfoEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverEntity.CoverInfoEntity)obj;
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
                        if (((CoverEntity.CoverInfoEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((CoverEntity.CoverInfoEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverEntity.CoverInfoEntity) (obj)).zza(field));
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

        public CoverEntity.CoverInfoEntity zzza()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("leftImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("leftImageOffset", 2));
            zzaLS.put("topImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("topImageOffset", 3));
        }

        public CoverEntity.CoverInfoEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        CoverEntity.CoverInfoEntity(Set set, int i, int j, int k)
        {
            zzaLT = set;
            mVersionCode = i;
            zzaNp = j;
            zzaNq = k;
        }
    }

    public static final class CoverEntity.CoverPhotoEntity extends FastSafeParcelableJsonResponse
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
                if (!(obj instanceof CoverEntity.CoverPhotoEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverEntity.CoverPhotoEntity)obj;
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
                        if (((CoverEntity.CoverPhotoEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((CoverEntity.CoverPhotoEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverEntity.CoverPhotoEntity) (obj)).zza(field));
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

        public CoverEntity.CoverPhotoEntity zzzb()
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

        public CoverEntity.CoverPhotoEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        CoverEntity.CoverPhotoEntity(Set set, int i, int j, String s, int k)
        {
            zzaLT = set;
            mVersionCode = i;
            zznQ = j;
            zzF = s;
            zznP = k;
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.Image
    {

        public static final zzf CREATOR = new zzf();
        private static final HashMap zzaLS;
        final int mVersionCode;
        String zzF;
        final Set zzaLT;

        public int describeContents()
        {
            zzf zzf1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof ImageEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (ImageEntity)obj;
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
                        if (((ImageEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((ImageEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((ImageEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzzc();
        }

        public String getUrl()
        {
            return zzF;
        }

        public boolean hasUrl()
        {
            return zzaLT.contains(Integer.valueOf(2));
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
            zzf zzf1 = CREATOR;
            zzf.zza(this, parcel, i);
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
                return zzF;
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

        public ImageEntity zzzc()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("url", 2));
        }

        public ImageEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        public ImageEntity(String s)
        {
            zzaLT = new HashSet();
            mVersionCode = 1;
            zzF = s;
            zzaLT.add(Integer.valueOf(2));
        }

        ImageEntity(Set set, int i, String s)
        {
            zzaLT = set;
            mVersionCode = i;
            zzF = s;
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.Name
    {

        public static final zzg CREATOR = new zzg();
        private static final HashMap zzaLS;
        final int mVersionCode;
        final Set zzaLT;
        String zzaMr;
        String zzaMu;
        String zzaNr;
        String zzaNs;
        String zzaNt;
        String zzaNu;

        public int describeContents()
        {
            zzg zzg1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof NameEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (NameEntity)obj;
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
                        if (((NameEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((NameEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((NameEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzzd();
        }

        public String getFamilyName()
        {
            return zzaMr;
        }

        public String getFormatted()
        {
            return zzaNr;
        }

        public String getGivenName()
        {
            return zzaMu;
        }

        public String getHonorificPrefix()
        {
            return zzaNs;
        }

        public String getHonorificSuffix()
        {
            return zzaNt;
        }

        public String getMiddleName()
        {
            return zzaNu;
        }

        public boolean hasFamilyName()
        {
            return zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted()
        {
            return zzaLT.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName()
        {
            return zzaLT.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix()
        {
            return zzaLT.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix()
        {
            return zzaLT.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName()
        {
            return zzaLT.contains(Integer.valueOf(7));
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
            zzg zzg1 = CREATOR;
            zzg.zza(this, parcel, i);
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
                return zzaMr;

            case 3: // '\003'
                return zzaNr;

            case 4: // '\004'
                return zzaMu;

            case 5: // '\005'
                return zzaNs;

            case 6: // '\006'
                return zzaNt;

            case 7: // '\007'
                return zzaNu;
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

        public NameEntity zzzd()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("familyName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("familyName", 2));
            zzaLS.put("formatted", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("formatted", 3));
            zzaLS.put("givenName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("givenName", 4));
            zzaLS.put("honorificPrefix", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("honorificPrefix", 5));
            zzaLS.put("honorificSuffix", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("honorificSuffix", 6));
            zzaLS.put("middleName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("middleName", 7));
        }

        public NameEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        NameEntity(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                String s5)
        {
            zzaLT = set;
            mVersionCode = i;
            zzaMr = s;
            zzaNr = s1;
            zzaMu = s2;
            zzaNs = s3;
            zzaNt = s4;
            zzaNu = s5;
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.Organizations
    {

        public static final zzh CREATOR = new zzh();
        private static final HashMap zzaLS;
        String mName;
        final int mVersionCode;
        int zzUS;
        final Set zzaLT;
        String zzaMG;
        String zzaMq;
        String zzaNv;
        String zzaNw;
        boolean zzaNx;
        String zzagU;
        String zzaoB;

        public int describeContents()
        {
            zzh zzh1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof OrganizationsEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (OrganizationsEntity)obj;
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
                        if (((OrganizationsEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((OrganizationsEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((OrganizationsEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzze();
        }

        public String getDepartment()
        {
            return zzaNv;
        }

        public String getDescription()
        {
            return zzaoB;
        }

        public String getEndDate()
        {
            return zzaMq;
        }

        public String getLocation()
        {
            return zzaNw;
        }

        public String getName()
        {
            return mName;
        }

        public String getStartDate()
        {
            return zzaMG;
        }

        public String getTitle()
        {
            return zzagU;
        }

        public int getType()
        {
            return zzUS;
        }

        public boolean hasDepartment()
        {
            return zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasDescription()
        {
            return zzaLT.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate()
        {
            return zzaLT.contains(Integer.valueOf(4));
        }

        public boolean hasLocation()
        {
            return zzaLT.contains(Integer.valueOf(5));
        }

        public boolean hasName()
        {
            return zzaLT.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary()
        {
            return zzaLT.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate()
        {
            return zzaLT.contains(Integer.valueOf(8));
        }

        public boolean hasTitle()
        {
            return zzaLT.contains(Integer.valueOf(9));
        }

        public boolean hasType()
        {
            return zzaLT.contains(Integer.valueOf(10));
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

        public boolean isPrimary()
        {
            return zzaNx;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzh zzh1 = CREATOR;
            zzh.zza(this, parcel, i);
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
                return zzaNv;

            case 3: // '\003'
                return zzaoB;

            case 4: // '\004'
                return zzaMq;

            case 5: // '\005'
                return zzaNw;

            case 6: // '\006'
                return mName;

            case 7: // '\007'
                return Boolean.valueOf(zzaNx);

            case 8: // '\b'
                return zzaMG;

            case 9: // '\t'
                return zzagU;

            case 10: // '\n'
                return Integer.valueOf(zzUS);
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

        public OrganizationsEntity zzze()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("department", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("department", 2));
            zzaLS.put("description", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("description", 3));
            zzaLS.put("endDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("endDate", 4));
            zzaLS.put("location", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("location", 5));
            zzaLS.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("name", 6));
            zzaLS.put("primary", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("primary", 7));
            zzaLS.put("startDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("startDate", 8));
            zzaLS.put("title", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("title", 9));
            zzaLS.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("type", 10, (new StringToIntConverter()).zzi("work", 0).zzi("school", 1), false));
        }

        public OrganizationsEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        OrganizationsEntity(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                boolean flag, String s5, String s6, int j)
        {
            zzaLT = set;
            mVersionCode = i;
            zzaNv = s;
            zzaoB = s1;
            zzaMq = s2;
            zzaNw = s3;
            mName = s4;
            zzaNx = flag;
            zzaMG = s5;
            zzagU = s6;
            zzUS = j;
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.PlacesLived
    {

        public static final zzi CREATOR = new zzi();
        private static final HashMap zzaLS;
        String mValue;
        final int mVersionCode;
        final Set zzaLT;
        boolean zzaNx;

        public int describeContents()
        {
            zzi zzi1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof PlacesLivedEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (PlacesLivedEntity)obj;
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
                        if (((PlacesLivedEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((PlacesLivedEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((PlacesLivedEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzzf();
        }

        public String getValue()
        {
            return mValue;
        }

        public boolean hasPrimary()
        {
            return zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasValue()
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

        public boolean isPrimary()
        {
            return zzaNx;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzi zzi1 = CREATOR;
            zzi.zza(this, parcel, i);
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
                return Boolean.valueOf(zzaNx);

            case 3: // '\003'
                return mValue;
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

        public PlacesLivedEntity zzzf()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("primary", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("primary", 2));
            zzaLS.put("value", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("value", 3));
        }

        public PlacesLivedEntity()
        {
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        PlacesLivedEntity(Set set, int i, boolean flag, String s)
        {
            zzaLT = set;
            mVersionCode = i;
            zzaNx = flag;
            mValue = s;
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.model.people.Person.Urls
    {

        public static final zzj CREATOR = new zzj();
        private static final HashMap zzaLS;
        String mValue;
        final int mVersionCode;
        int zzUS;
        String zzaID;
        final Set zzaLT;
        private final int zzaNy;

        public int describeContents()
        {
            zzj zzj1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof UrlsEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (UrlsEntity)obj;
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
                        if (((UrlsEntity) (obj)).zza(field))
                        {
                            if (!zzb(field).equals(((UrlsEntity) (obj)).zzb(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((UrlsEntity) (obj)).zza(field));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzzh();
        }

        public String getLabel()
        {
            return zzaID;
        }

        public int getType()
        {
            return zzUS;
        }

        public String getValue()
        {
            return mValue;
        }

        public boolean hasLabel()
        {
            return zzaLT.contains(Integer.valueOf(5));
        }

        public boolean hasType()
        {
            return zzaLT.contains(Integer.valueOf(6));
        }

        public boolean hasValue()
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
            zzj zzj1 = CREATOR;
            zzj.zza(this, parcel, i);
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

            case 5: // '\005'
                return zzaID;

            case 6: // '\006'
                return Integer.valueOf(zzUS);

            case 4: // '\004'
                return mValue;
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

        public int zzzg()
        {
            return 4;
        }

        public UrlsEntity zzzh()
        {
            return this;
        }

        static 
        {
            zzaLS = new HashMap();
            zzaLS.put("label", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("label", 5));
            zzaLS.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("type", 6, (new StringToIntConverter()).zzi("home", 0).zzi("work", 1).zzi("blog", 2).zzi("profile", 3).zzi("other", 4).zzi("otherProfile", 5).zzi("contributor", 6).zzi("website", 7), false));
            zzaLS.put("value", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("value", 4));
        }

        public UrlsEntity()
        {
            zzaNy = 4;
            mVersionCode = 1;
            zzaLT = new HashSet();
        }

        UrlsEntity(Set set, int i, String s, int j, String s1, int k)
        {
            zzaNy = 4;
            zzaLT = set;
            mVersionCode = i;
            zzaID = s;
            zzUS = j;
            mValue = s1;
        }
    }

    public static class zza
    {

        public static int zzek(String s)
        {
            if (s.equals("person"))
            {
                return 0;
            }
            if (s.equals("page"))
            {
                return 1;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unknown objectType string: ").append(s).toString());
            }
        }
    }


    public static final com.google.android.gms.plus.internal.model.people.zza CREATOR = new com.google.android.gms.plus.internal.model.people.zza();
    private static final HashMap zzaLS;
    final int mVersionCode;
    String zzF;
    String zzUc;
    final Set zzaLT;
    String zzaMR;
    AgeRangeEntity zzaMS;
    String zzaMT;
    String zzaMU;
    int zzaMV;
    CoverEntity zzaMW;
    String zzaMX;
    ImageEntity zzaMY;
    boolean zzaMZ;
    NameEntity zzaNa;
    String zzaNb;
    int zzaNc;
    List zzaNd;
    List zzaNe;
    int zzaNf;
    int zzaNg;
    String zzaNh;
    List zzaNi;
    boolean zzaNj;
    String zzahh;
    int zzsW;
    String zzwj;

    public PersonEntity()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    public PersonEntity(String s, String s1, ImageEntity imageentity, int i, String s2)
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
        zzahh = s;
        zzaLT.add(Integer.valueOf(9));
        zzwj = s1;
        zzaLT.add(Integer.valueOf(14));
        zzaMY = imageentity;
        zzaLT.add(Integer.valueOf(15));
        zzaNc = i;
        zzaLT.add(Integer.valueOf(21));
        zzF = s2;
        zzaLT.add(Integer.valueOf(27));
    }

    PersonEntity(Set set, int i, String s, AgeRangeEntity agerangeentity, String s1, String s2, int j, 
            CoverEntity coverentity, String s3, String s4, int k, String s5, ImageEntity imageentity, boolean flag, 
            String s6, NameEntity nameentity, String s7, int l, List list, List list1, int i1, 
            int j1, String s8, String s9, List list2, boolean flag1)
    {
        zzaLT = set;
        mVersionCode = i;
        zzaMR = s;
        zzaMS = agerangeentity;
        zzaMT = s1;
        zzaMU = s2;
        zzaMV = j;
        zzaMW = coverentity;
        zzaMX = s3;
        zzahh = s4;
        zzsW = k;
        zzwj = s5;
        zzaMY = imageentity;
        zzaMZ = flag;
        zzUc = s6;
        zzaNa = nameentity;
        zzaNb = s7;
        zzaNc = l;
        zzaNd = list;
        zzaNe = list1;
        zzaNf = i1;
        zzaNg = j1;
        zzaNh = s8;
        zzF = s9;
        zzaNi = list2;
        zzaNj = flag1;
    }

    public static PersonEntity zzp(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.zzfV(parcel);
        parcel.recycle();
        return abyte0;
    }

    public int describeContents()
    {
        com.google.android.gms.plus.internal.model.people.zza zza1 = CREATOR;
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
                for (Iterator iterator = zzaLS.values().iterator(); iterator.hasNext();)
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
        return zzyX();
    }

    public String getAboutMe()
    {
        return zzaMR;
    }

    public com.google.android.gms.plus.model.people.Person.AgeRange getAgeRange()
    {
        return zzaMS;
    }

    public String getBirthday()
    {
        return zzaMT;
    }

    public String getBraggingRights()
    {
        return zzaMU;
    }

    public int getCircledByCount()
    {
        return zzaMV;
    }

    public com.google.android.gms.plus.model.people.Person.Cover getCover()
    {
        return zzaMW;
    }

    public String getCurrentLocation()
    {
        return zzaMX;
    }

    public String getDisplayName()
    {
        return zzahh;
    }

    public int getGender()
    {
        return zzsW;
    }

    public String getId()
    {
        return zzwj;
    }

    public com.google.android.gms.plus.model.people.Person.Image getImage()
    {
        return zzaMY;
    }

    public String getLanguage()
    {
        return zzUc;
    }

    public com.google.android.gms.plus.model.people.Person.Name getName()
    {
        return zzaNa;
    }

    public String getNickname()
    {
        return zzaNb;
    }

    public int getObjectType()
    {
        return zzaNc;
    }

    public List getOrganizations()
    {
        return (ArrayList)zzaNd;
    }

    public List getPlacesLived()
    {
        return (ArrayList)zzaNe;
    }

    public int getPlusOneCount()
    {
        return zzaNf;
    }

    public int getRelationshipStatus()
    {
        return zzaNg;
    }

    public String getTagline()
    {
        return zzaNh;
    }

    public String getUrl()
    {
        return zzF;
    }

    public List getUrls()
    {
        return (ArrayList)zzaNi;
    }

    public boolean hasAboutMe()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange()
    {
        return zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday()
    {
        return zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights()
    {
        return zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount()
    {
        return zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasCover()
    {
        return zzaLT.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation()
    {
        return zzaLT.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName()
    {
        return zzaLT.contains(Integer.valueOf(9));
    }

    public boolean hasGender()
    {
        return zzaLT.contains(Integer.valueOf(12));
    }

    public boolean hasId()
    {
        return zzaLT.contains(Integer.valueOf(14));
    }

    public boolean hasImage()
    {
        return zzaLT.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser()
    {
        return zzaLT.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage()
    {
        return zzaLT.contains(Integer.valueOf(18));
    }

    public boolean hasName()
    {
        return zzaLT.contains(Integer.valueOf(19));
    }

    public boolean hasNickname()
    {
        return zzaLT.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType()
    {
        return zzaLT.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations()
    {
        return zzaLT.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived()
    {
        return zzaLT.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount()
    {
        return zzaLT.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus()
    {
        return zzaLT.contains(Integer.valueOf(25));
    }

    public boolean hasTagline()
    {
        return zzaLT.contains(Integer.valueOf(26));
    }

    public boolean hasUrl()
    {
        return zzaLT.contains(Integer.valueOf(27));
    }

    public boolean hasUrls()
    {
        return zzaLT.contains(Integer.valueOf(28));
    }

    public boolean hasVerified()
    {
        return zzaLT.contains(Integer.valueOf(29));
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

    public boolean isPlusUser()
    {
        return zzaMZ;
    }

    public boolean isVerified()
    {
        return zzaNj;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.plus.internal.model.people.zza zza1 = CREATOR;
        com.google.android.gms.plus.internal.model.people.zza.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        return zzaLT.contains(Integer.valueOf(field.zzpi()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        switch (field.zzpi())
        {
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzpi()).toString());

        case 2: // '\002'
            return zzaMR;

        case 3: // '\003'
            return zzaMS;

        case 4: // '\004'
            return zzaMT;

        case 5: // '\005'
            return zzaMU;

        case 6: // '\006'
            return Integer.valueOf(zzaMV);

        case 7: // '\007'
            return zzaMW;

        case 8: // '\b'
            return zzaMX;

        case 9: // '\t'
            return zzahh;

        case 12: // '\f'
            return Integer.valueOf(zzsW);

        case 14: // '\016'
            return zzwj;

        case 15: // '\017'
            return zzaMY;

        case 16: // '\020'
            return Boolean.valueOf(zzaMZ);

        case 18: // '\022'
            return zzUc;

        case 19: // '\023'
            return zzaNa;

        case 20: // '\024'
            return zzaNb;

        case 21: // '\025'
            return Integer.valueOf(zzaNc);

        case 22: // '\026'
            return zzaNd;

        case 23: // '\027'
            return zzaNe;

        case 24: // '\030'
            return Integer.valueOf(zzaNf);

        case 25: // '\031'
            return Integer.valueOf(zzaNg);

        case 26: // '\032'
            return zzaNh;

        case 27: // '\033'
            return zzF;

        case 28: // '\034'
            return zzaNi;

        case 29: // '\035'
            return Boolean.valueOf(zzaNj);
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

    public PersonEntity zzyX()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("aboutMe", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("aboutMe", 2));
        zzaLS.put("ageRange", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("ageRange", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$AgeRangeEntity));
        zzaLS.put("birthday", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("birthday", 4));
        zzaLS.put("braggingRights", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("braggingRights", 5));
        zzaLS.put("circledByCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("circledByCount", 6));
        zzaLS.put("cover", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("cover", 7, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity));
        zzaLS.put("currentLocation", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("currentLocation", 8));
        zzaLS.put("displayName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("displayName", 9));
        zzaLS.put("gender", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("gender", 12, (new StringToIntConverter()).zzi("male", 0).zzi("female", 1).zzi("other", 2), false));
        zzaLS.put("id", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("id", 14));
        zzaLS.put("image", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("image", 15, com/google/android/gms/plus/internal/model/people/PersonEntity$ImageEntity));
        zzaLS.put("isPlusUser", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("isPlusUser", 16));
        zzaLS.put("language", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("language", 18));
        zzaLS.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("name", 19, com/google/android/gms/plus/internal/model/people/PersonEntity$NameEntity));
        zzaLS.put("nickname", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("nickname", 20));
        zzaLS.put("objectType", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("objectType", 21, (new StringToIntConverter()).zzi("person", 0).zzi("page", 1), false));
        zzaLS.put("organizations", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("organizations", 22, com/google/android/gms/plus/internal/model/people/PersonEntity$OrganizationsEntity));
        zzaLS.put("placesLived", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("placesLived", 23, com/google/android/gms/plus/internal/model/people/PersonEntity$PlacesLivedEntity));
        zzaLS.put("plusOneCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzj("plusOneCount", 24));
        zzaLS.put("relationshipStatus", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("relationshipStatus", 25, (new StringToIntConverter()).zzi("single", 0).zzi("in_a_relationship", 1).zzi("engaged", 2).zzi("married", 3).zzi("its_complicated", 4).zzi("open_relationship", 5).zzi("widowed", 6).zzi("in_domestic_partnership", 7).zzi("in_civil_union", 8), false));
        zzaLS.put("tagline", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("tagline", 26));
        zzaLS.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("url", 27));
        zzaLS.put("urls", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("urls", 28, com/google/android/gms/plus/internal/model/people/PersonEntity$UrlsEntity));
        zzaLS.put("verified", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("verified", 29));
    }
}
