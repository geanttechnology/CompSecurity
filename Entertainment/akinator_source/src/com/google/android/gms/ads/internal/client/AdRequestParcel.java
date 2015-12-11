// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzg, SearchAdRequestParcel

public final class AdRequestParcel
    implements SafeParcelable
{

    public static final zzg CREATOR = new zzg();
    public final Bundle extras;
    public final int versionCode;
    public final long zzsB;
    public final int zzsC;
    public final List zzsD;
    public final boolean zzsE;
    public final int zzsF;
    public final boolean zzsG;
    public final String zzsH;
    public final SearchAdRequestParcel zzsI;
    public final Location zzsJ;
    public final String zzsK;
    public final Bundle zzsL;
    public final Bundle zzsM;
    public final List zzsN;
    public final String zzsO;
    public final String zzsP;

    public AdRequestParcel(int i, long l, Bundle bundle, int j, List list, boolean flag, 
            int k, boolean flag1, String s, SearchAdRequestParcel searchadrequestparcel, Location location, String s1, Bundle bundle1, 
            Bundle bundle2, List list1, String s2, String s3)
    {
        versionCode = i;
        zzsB = l;
        Bundle bundle3 = bundle;
        if (bundle == null)
        {
            bundle3 = new Bundle();
        }
        extras = bundle3;
        zzsC = j;
        zzsD = list;
        zzsE = flag;
        zzsF = k;
        zzsG = flag1;
        zzsH = s;
        zzsI = searchadrequestparcel;
        zzsJ = location;
        zzsK = s1;
        zzsL = bundle1;
        zzsM = bundle2;
        zzsN = list1;
        zzsO = s2;
        zzsP = s3;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof AdRequestParcel)
        {
            if (versionCode == ((AdRequestParcel) (obj = (AdRequestParcel)obj)).versionCode && zzsB == ((AdRequestParcel) (obj)).zzsB && zzw.equal(extras, ((AdRequestParcel) (obj)).extras) && zzsC == ((AdRequestParcel) (obj)).zzsC && zzw.equal(zzsD, ((AdRequestParcel) (obj)).zzsD) && zzsE == ((AdRequestParcel) (obj)).zzsE && zzsF == ((AdRequestParcel) (obj)).zzsF && zzsG == ((AdRequestParcel) (obj)).zzsG && zzw.equal(zzsH, ((AdRequestParcel) (obj)).zzsH) && zzw.equal(zzsI, ((AdRequestParcel) (obj)).zzsI) && zzw.equal(zzsJ, ((AdRequestParcel) (obj)).zzsJ) && zzw.equal(zzsK, ((AdRequestParcel) (obj)).zzsK) && zzw.equal(zzsL, ((AdRequestParcel) (obj)).zzsL) && zzw.equal(zzsM, ((AdRequestParcel) (obj)).zzsM) && zzw.equal(zzsN, ((AdRequestParcel) (obj)).zzsN) && zzw.equal(zzsO, ((AdRequestParcel) (obj)).zzsO) && zzw.equal(zzsP, ((AdRequestParcel) (obj)).zzsP))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(versionCode), Long.valueOf(zzsB), extras, Integer.valueOf(zzsC), zzsD, Boolean.valueOf(zzsE), Integer.valueOf(zzsF), Boolean.valueOf(zzsG), zzsH, zzsI, 
            zzsJ, zzsK, zzsL, zzsM, zzsN, zzsO, zzsP
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
