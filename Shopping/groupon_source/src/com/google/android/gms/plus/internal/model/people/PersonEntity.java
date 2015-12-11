// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.people.Person;
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
    {

        public static final zzb CREATOR = new zzb();
        private static final HashMap zzaHP;
        final int zzCY;
        final Set zzaHQ;
        int zzaJh;
        int zzaJi;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzb zzb1 = CREATOR;
            com.google.android.gms.plus.internal.model.people.zzb.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return Integer.valueOf(zzaJh);

            case 3: // '\003'
                return Integer.valueOf(zzaJi);
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
            zzaHP.put("max", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("max", 2));
            zzaHP.put("min", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("min", 3));
        }

        public AgeRangeEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        AgeRangeEntity(Set set, int i, int j, int k)
        {
            zzaHQ = set;
            zzCY = i;
            zzaJh = j;
            zzaJi = k;
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse
    {

        public static final zzc CREATOR = new zzc();
        private static final HashMap zzaHP;
        final int zzCY;
        final Set zzaHQ;
        CoverInfoEntity zzaJj;
        CoverPhotoEntity zzaJk;
        int zzaJl;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzc zzc1 = CREATOR;
            zzc.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return zzaJj;

            case 3: // '\003'
                return zzaJk;

            case 4: // '\004'
                return Integer.valueOf(zzaJl);
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
            zzaHP.put("coverInfo", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("coverInfo", 2, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverInfoEntity));
            zzaHP.put("coverPhoto", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("coverPhoto", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverPhotoEntity));
            zzaHP.put("layout", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("layout", 4, (new StringToIntConverter()).zzh("banner", 0), false));
        }

        public CoverEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        CoverEntity(Set set, int i, CoverInfoEntity coverinfoentity, CoverPhotoEntity coverphotoentity, int j)
        {
            zzaHQ = set;
            zzCY = i;
            zzaJj = coverinfoentity;
            zzaJk = coverphotoentity;
            zzaJl = j;
        }
    }

    public static final class CoverEntity.CoverInfoEntity extends FastSafeParcelableJsonResponse
    {

        public static final zzd CREATOR = new zzd();
        private static final HashMap zzaHP;
        final int zzCY;
        final Set zzaHQ;
        int zzaJm;
        int zzaJn;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzd zzd1 = CREATOR;
            zzd.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return Integer.valueOf(zzaJm);

            case 3: // '\003'
                return Integer.valueOf(zzaJn);
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
            zzaHP.put("leftImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("leftImageOffset", 2));
            zzaHP.put("topImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("topImageOffset", 3));
        }

        public CoverEntity.CoverInfoEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        CoverEntity.CoverInfoEntity(Set set, int i, int j, int k)
        {
            zzaHQ = set;
            zzCY = i;
            zzaJm = j;
            zzaJn = k;
        }
    }

    public static final class CoverEntity.CoverPhotoEntity extends FastSafeParcelableJsonResponse
    {

        public static final zze CREATOR = new zze();
        private static final HashMap zzaHP;
        final int zzCY;
        String zzF;
        final Set zzaHQ;
        int zznM;
        int zznN;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zze zze1 = CREATOR;
            zze.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return Integer.valueOf(zznN);

            case 3: // '\003'
                return zzF;

            case 4: // '\004'
                return Integer.valueOf(zznM);
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
            zzaHP.put("height", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("height", 2));
            zzaHP.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("url", 3));
            zzaHP.put("width", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("width", 4));
        }

        public CoverEntity.CoverPhotoEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        CoverEntity.CoverPhotoEntity(Set set, int i, int j, String s, int k)
        {
            zzaHQ = set;
            zzCY = i;
            zznN = j;
            zzF = s;
            zznM = k;
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse
    {

        public static final zzf CREATOR = new zzf();
        private static final HashMap zzaHP;
        final int zzCY;
        String zzF;
        final Set zzaHQ;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzf zzf1 = CREATOR;
            zzf.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return zzF;
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
            zzaHP.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("url", 2));
        }

        public ImageEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        ImageEntity(Set set, int i, String s)
        {
            zzaHQ = set;
            zzCY = i;
            zzF = s;
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse
    {

        public static final zzg CREATOR = new zzg();
        private static final HashMap zzaHP;
        final int zzCY;
        final Set zzaHQ;
        String zzaIo;
        String zzaIr;
        String zzaJo;
        String zzaJp;
        String zzaJq;
        String zzaJr;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzg zzg1 = CREATOR;
            zzg.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return zzaIo;

            case 3: // '\003'
                return zzaJo;

            case 4: // '\004'
                return zzaIr;

            case 5: // '\005'
                return zzaJp;

            case 6: // '\006'
                return zzaJq;

            case 7: // '\007'
                return zzaJr;
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
            zzaHP.put("familyName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("familyName", 2));
            zzaHP.put("formatted", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("formatted", 3));
            zzaHP.put("givenName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("givenName", 4));
            zzaHP.put("honorificPrefix", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("honorificPrefix", 5));
            zzaHP.put("honorificSuffix", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("honorificSuffix", 6));
            zzaHP.put("middleName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("middleName", 7));
        }

        public NameEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        NameEntity(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                String s5)
        {
            zzaHQ = set;
            zzCY = i;
            zzaIo = s;
            zzaJo = s1;
            zzaIr = s2;
            zzaJp = s3;
            zzaJq = s4;
            zzaJr = s5;
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse
    {

        public static final zzh CREATOR = new zzh();
        private static final HashMap zzaHP;
        String mName;
        final int zzCY;
        int zzSq;
        final Set zzaHQ;
        String zzaID;
        String zzaIn;
        String zzaJs;
        String zzaJt;
        boolean zzaJu;
        String zzadv;
        String zzakM;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzh zzh1 = CREATOR;
            zzh.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return zzaJs;

            case 3: // '\003'
                return zzakM;

            case 4: // '\004'
                return zzaIn;

            case 5: // '\005'
                return zzaJt;

            case 6: // '\006'
                return mName;

            case 7: // '\007'
                return Boolean.valueOf(zzaJu);

            case 8: // '\b'
                return zzaID;

            case 9: // '\t'
                return zzadv;

            case 10: // '\n'
                return Integer.valueOf(zzSq);
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
            zzaHP.put("department", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("department", 2));
            zzaHP.put("description", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("description", 3));
            zzaHP.put("endDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("endDate", 4));
            zzaHP.put("location", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("location", 5));
            zzaHP.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("name", 6));
            zzaHP.put("primary", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("primary", 7));
            zzaHP.put("startDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("startDate", 8));
            zzaHP.put("title", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("title", 9));
            zzaHP.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("type", 10, (new StringToIntConverter()).zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        OrganizationsEntity(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                boolean flag, String s5, String s6, int j)
        {
            zzaHQ = set;
            zzCY = i;
            zzaJs = s;
            zzakM = s1;
            zzaIn = s2;
            zzaJt = s3;
            mName = s4;
            zzaJu = flag;
            zzaID = s5;
            zzadv = s6;
            zzSq = j;
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse
    {

        public static final zzi CREATOR = new zzi();
        private static final HashMap zzaHP;
        String mValue;
        final int zzCY;
        final Set zzaHQ;
        boolean zzaJu;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzi zzi1 = CREATOR;
            zzi.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 2: // '\002'
                return Boolean.valueOf(zzaJu);

            case 3: // '\003'
                return mValue;
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
            zzaHP.put("primary", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("primary", 2));
            zzaHP.put("value", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("value", 3));
        }

        public PlacesLivedEntity()
        {
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        PlacesLivedEntity(Set set, int i, boolean flag, String s)
        {
            zzaHQ = set;
            zzCY = i;
            zzaJu = flag;
            mValue = s;
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse
    {

        public static final zzj CREATOR = new zzj();
        private static final HashMap zzaHP;
        String mValue;
        final int zzCY;
        int zzSq;
        String zzaEH;
        final Set zzaHQ;
        private final int zzaJv;

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
                    for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
            zzj zzj1 = CREATOR;
            zzj.zza(this, parcel, i);
        }

        protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.zzot())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

            case 5: // '\005'
                return zzaEH;

            case 6: // '\006'
                return Integer.valueOf(zzSq);

            case 4: // '\004'
                return mValue;
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

        public int zzxS()
        {
            return 4;
        }

        static 
        {
            zzaHP = new HashMap();
            zzaHP.put("label", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("label", 5));
            zzaHP.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("type", 6, (new StringToIntConverter()).zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh("profile", 3).zzh("other", 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzaHP.put("value", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("value", 4));
        }

        public UrlsEntity()
        {
            zzaJv = 4;
            zzCY = 1;
            zzaHQ = new HashSet();
        }

        UrlsEntity(Set set, int i, String s, int j, String s1, int k)
        {
            zzaJv = 4;
            zzaHQ = set;
            zzCY = i;
            zzaEH = s;
            zzSq = j;
            mValue = s1;
        }
    }


    public static final zza CREATOR = new zza();
    private static final HashMap zzaHP;
    final int zzCY;
    String zzF;
    String zzKI;
    String zzRA;
    final Set zzaHQ;
    String zzaIO;
    AgeRangeEntity zzaIP;
    String zzaIQ;
    String zzaIR;
    int zzaIS;
    CoverEntity zzaIT;
    String zzaIU;
    ImageEntity zzaIV;
    boolean zzaIW;
    NameEntity zzaIX;
    String zzaIY;
    int zzaIZ;
    List zzaJa;
    List zzaJb;
    int zzaJc;
    int zzaJd;
    String zzaJe;
    List zzaJf;
    boolean zzaJg;
    String zzadI;
    int zzsC;

    public PersonEntity()
    {
        zzCY = 1;
        zzaHQ = new HashSet();
    }

    PersonEntity(Set set, int i, String s, AgeRangeEntity agerangeentity, String s1, String s2, int j, 
            CoverEntity coverentity, String s3, String s4, int k, String s5, ImageEntity imageentity, boolean flag, 
            String s6, NameEntity nameentity, String s7, int l, List list, List list1, int i1, 
            int j1, String s8, String s9, List list2, boolean flag1)
    {
        zzaHQ = set;
        zzCY = i;
        zzaIO = s;
        zzaIP = agerangeentity;
        zzaIQ = s1;
        zzaIR = s2;
        zzaIS = j;
        zzaIT = coverentity;
        zzaIU = s3;
        zzadI = s4;
        zzsC = k;
        zzKI = s5;
        zzaIV = imageentity;
        zzaIW = flag;
        zzRA = s6;
        zzaIX = nameentity;
        zzaIY = s7;
        zzaIZ = l;
        zzaJa = list;
        zzaJb = list1;
        zzaJc = i1;
        zzaJd = j1;
        zzaJe = s8;
        zzF = s9;
        zzaJf = list2;
        zzaJg = flag1;
    }

    public static PersonEntity zzp(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.zzfM(parcel);
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
                for (Iterator iterator = zzaHP.values().iterator(); iterator.hasNext();)
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
        com.google.android.gms.plus.internal.model.people.zza.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        return zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        switch (field.zzot())
        {
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzot()).toString());

        case 2: // '\002'
            return zzaIO;

        case 3: // '\003'
            return zzaIP;

        case 4: // '\004'
            return zzaIQ;

        case 5: // '\005'
            return zzaIR;

        case 6: // '\006'
            return Integer.valueOf(zzaIS);

        case 7: // '\007'
            return zzaIT;

        case 8: // '\b'
            return zzaIU;

        case 9: // '\t'
            return zzadI;

        case 12: // '\f'
            return Integer.valueOf(zzsC);

        case 14: // '\016'
            return zzKI;

        case 15: // '\017'
            return zzaIV;

        case 16: // '\020'
            return Boolean.valueOf(zzaIW);

        case 18: // '\022'
            return zzRA;

        case 19: // '\023'
            return zzaIX;

        case 20: // '\024'
            return zzaIY;

        case 21: // '\025'
            return Integer.valueOf(zzaIZ);

        case 22: // '\026'
            return zzaJa;

        case 23: // '\027'
            return zzaJb;

        case 24: // '\030'
            return Integer.valueOf(zzaJc);

        case 25: // '\031'
            return Integer.valueOf(zzaJd);

        case 26: // '\032'
            return zzaJe;

        case 27: // '\033'
            return zzF;

        case 28: // '\034'
            return zzaJf;

        case 29: // '\035'
            return Boolean.valueOf(zzaJg);
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
        zzaHP.put("aboutMe", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("aboutMe", 2));
        zzaHP.put("ageRange", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("ageRange", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$AgeRangeEntity));
        zzaHP.put("birthday", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("birthday", 4));
        zzaHP.put("braggingRights", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("braggingRights", 5));
        zzaHP.put("circledByCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("circledByCount", 6));
        zzaHP.put("cover", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("cover", 7, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity));
        zzaHP.put("currentLocation", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("currentLocation", 8));
        zzaHP.put("displayName", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("displayName", 9));
        zzaHP.put("gender", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("gender", 12, (new StringToIntConverter()).zzh("male", 0).zzh("female", 1).zzh("other", 2), false));
        zzaHP.put("id", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("id", 14));
        zzaHP.put("image", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("image", 15, com/google/android/gms/plus/internal/model/people/PersonEntity$ImageEntity));
        zzaHP.put("isPlusUser", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("isPlusUser", 16));
        zzaHP.put("language", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("language", 18));
        zzaHP.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("name", 19, com/google/android/gms/plus/internal/model/people/PersonEntity$NameEntity));
        zzaHP.put("nickname", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("nickname", 20));
        zzaHP.put("objectType", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("objectType", 21, (new StringToIntConverter()).zzh("person", 0).zzh("page", 1), false));
        zzaHP.put("organizations", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("organizations", 22, com/google/android/gms/plus/internal/model/people/PersonEntity$OrganizationsEntity));
        zzaHP.put("placesLived", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("placesLived", 23, com/google/android/gms/plus/internal/model/people/PersonEntity$PlacesLivedEntity));
        zzaHP.put("plusOneCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzi("plusOneCount", 24));
        zzaHP.put("relationshipStatus", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("relationshipStatus", 25, (new StringToIntConverter()).zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzaHP.put("tagline", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("tagline", 26));
        zzaHP.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzl("url", 27));
        zzaHP.put("urls", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzb("urls", 28, com/google/android/gms/plus/internal/model/people/PersonEntity$UrlsEntity));
        zzaHP.put("verified", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzk("verified", 29));
    }
}
