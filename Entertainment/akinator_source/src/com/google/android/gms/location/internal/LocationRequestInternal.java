// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzm

public class LocationRequestInternal
    implements SafeParcelable
{

    public static final zzm CREATOR = new zzm();
    static final List zzaFD = Collections.emptyList();
    String mTag;
    private final int mVersionCode;
    boolean zzaFE;
    boolean zzaFF;
    boolean zzaFG;
    List zzaFH;
    boolean zzaFI;
    LocationRequest zzasN;

    LocationRequestInternal(int i, LocationRequest locationrequest, boolean flag, boolean flag1, boolean flag2, List list, String s, 
            boolean flag3)
    {
        mVersionCode = i;
        zzasN = locationrequest;
        zzaFE = flag;
        zzaFF = flag1;
        zzaFG = flag2;
        zzaFH = list;
        mTag = s;
        zzaFI = flag3;
    }

    public static LocationRequestInternal zza(String s, LocationRequest locationrequest)
    {
        return new LocationRequestInternal(1, locationrequest, false, true, true, zzaFD, s, false);
    }

    public static LocationRequestInternal zzb(LocationRequest locationrequest)
    {
        return zza(null, locationrequest);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof LocationRequestInternal)
        {
            if (zzw.equal(zzasN, ((LocationRequestInternal) (obj = (LocationRequestInternal)obj)).zzasN) && zzaFE == ((LocationRequestInternal) (obj)).zzaFE && zzaFF == ((LocationRequestInternal) (obj)).zzaFF && zzaFG == ((LocationRequestInternal) (obj)).zzaFG && zzaFI == ((LocationRequestInternal) (obj)).zzaFI && zzw.equal(zzaFH, ((LocationRequestInternal) (obj)).zzaFH))
            {
                return true;
            }
        }
        return false;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzasN.hashCode();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(zzasN.toString());
        if (mTag != null)
        {
            stringbuilder.append(" tag=").append(mTag);
        }
        stringbuilder.append(" nlpDebug=").append(zzaFE);
        stringbuilder.append(" trigger=").append(zzaFG);
        stringbuilder.append(" restorePIListeners=").append(zzaFF);
        stringbuilder.append(" hideAppOps=").append(zzaFI);
        stringbuilder.append(" clients=").append(zzaFH);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

}
