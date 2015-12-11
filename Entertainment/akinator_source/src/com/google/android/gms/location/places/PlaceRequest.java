// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.location.places:
//            zzk, PlaceFilter

public final class PlaceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    static final long zzaGv;
    private final int mPriority;
    final int mVersionCode;
    private final long zzaEE;
    private final long zzaEj;
    private final PlaceFilter zzaGw;

    public PlaceRequest(int i, PlaceFilter placefilter, long l, int j, long l1)
    {
        mVersionCode = i;
        zzaGw = placefilter;
        zzaEE = l;
        mPriority = j;
        zzaEj = l1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceRequest))
            {
                return false;
            }
            obj = (PlaceRequest)obj;
            if (!zzw.equal(zzaGw, ((PlaceRequest) (obj)).zzaGw) || zzaEE != ((PlaceRequest) (obj)).zzaEE || mPriority != ((PlaceRequest) (obj)).mPriority || zzaEj != ((PlaceRequest) (obj)).zzaEj)
            {
                return false;
            }
        }
        return true;
    }

    public long getExpirationTime()
    {
        return zzaEj;
    }

    public long getInterval()
    {
        return zzaEE;
    }

    public int getPriority()
    {
        return mPriority;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaGw, Long.valueOf(zzaEE), Integer.valueOf(mPriority), Long.valueOf(zzaEj)
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("filter", zzaGw).zzg("interval", Long.valueOf(zzaEE)).zzg("priority", Integer.valueOf(mPriority)).zzg("expireAt", Long.valueOf(zzaEj)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

    public PlaceFilter zzwO()
    {
        return zzaGw;
    }

    static 
    {
        zzaGv = TimeUnit.HOURS.toMillis(1L);
    }
}
