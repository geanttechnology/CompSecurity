// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

// Referenced classes of package com.google.android.gms.location.places:
//            zzk

public class PlaceReport
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    private final String mTag;
    final int zzCY;
    private final String zzazK;
    private final String zzazL;

    PlaceReport(int i, String s, String s1, String s2)
    {
        zzCY = i;
        zzazK = s;
        mTag = s1;
        zzazL = s2;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PlaceReport)
        {
            if (zzt.equal(zzazK, ((PlaceReport) (obj = (PlaceReport)obj)).zzazK) && zzt.equal(mTag, ((PlaceReport) (obj)).mTag) && zzt.equal(zzazL, ((PlaceReport) (obj)).zzazL))
            {
                return true;
            }
        }
        return false;
    }

    public String getPlaceId()
    {
        return zzazK;
    }

    public String getSource()
    {
        return zzazL;
    }

    public String getTag()
    {
        return mTag;
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            zzazK, mTag, zzazL
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzt.zza zza = zzt.zzt(this);
        zza.zzg("placeId", zzazK);
        zza.zzg("tag", mTag);
        if (!"unknown".equals(zzazL))
        {
            zza.zzg("source", zzazL);
        }
        return zza.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}
