// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zza, zzu

public class AutocompletePredictionEntity
    implements SafeParcelable
{
    public static class SubstringEntity
        implements SafeParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new zzu();
        final int mLength;
        final int mOffset;
        final int zzCY;

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof SubstringEntity))
                {
                    return false;
                }
                obj = (SubstringEntity)obj;
                if (!zzt.equal(Integer.valueOf(mOffset), Integer.valueOf(((SubstringEntity) (obj)).mOffset)) || !zzt.equal(Integer.valueOf(mLength), Integer.valueOf(((SubstringEntity) (obj)).mLength)))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return zzt.hashCode(new Object[] {
                Integer.valueOf(mOffset), Integer.valueOf(mLength)
            });
        }

        public String toString()
        {
            return zzt.zzt(this).zzg("offset", Integer.valueOf(mOffset)).zzg("length", Integer.valueOf(mLength)).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzu.zza(this, parcel, i);
        }


        public SubstringEntity(int i, int j, int k)
        {
            zzCY = i;
            mOffset = j;
            mLength = k;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int zzCY;
    final List zzaAe;
    final int zzaAf;
    final String zzakM;
    final String zzazK;
    final List zzazo;

    AutocompletePredictionEntity(int i, String s, String s1, List list, List list1, int j)
    {
        zzCY = i;
        zzakM = s;
        zzazK = s1;
        zzazo = list;
        zzaAe = list1;
        zzaAf = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof AutocompletePredictionEntity))
            {
                return false;
            }
            obj = (AutocompletePredictionEntity)obj;
            if (!zzt.equal(zzakM, ((AutocompletePredictionEntity) (obj)).zzakM) || !zzt.equal(zzazK, ((AutocompletePredictionEntity) (obj)).zzazK) || !zzt.equal(zzazo, ((AutocompletePredictionEntity) (obj)).zzazo) || !zzt.equal(zzaAe, ((AutocompletePredictionEntity) (obj)).zzaAe) || !zzt.equal(Integer.valueOf(zzaAf), Integer.valueOf(((AutocompletePredictionEntity) (obj)).zzaAf)))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            zzakM, zzazK, zzazo, zzaAe, Integer.valueOf(zzaAf)
        });
    }

    public String toString()
    {
        return zzt.zzt(this).zzg("description", zzakM).zzg("placeId", zzazK).zzg("placeTypes", zzazo).zzg("substrings", zzaAe).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
