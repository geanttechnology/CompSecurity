// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.plus.internal:
//            zzh, PlusCommonExtras

public class PlusSession
    implements SafeParcelable
{

    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private final String zzQE;
    private final String zzWq;
    private final String zzaLA;
    private final String zzaLB;
    private final String zzaLC;
    private final PlusCommonExtras zzaLD;
    private final String zzaLx[];
    private final String zzaLy[];
    private final String zzaLz[];

    PlusSession(int i, String s, String as[], String as1[], String as2[], String s1, String s2, 
            String s3, String s4, PlusCommonExtras pluscommonextras)
    {
        mVersionCode = i;
        zzQE = s;
        zzaLx = as;
        zzaLy = as1;
        zzaLz = as2;
        zzaLA = s1;
        zzaLB = s2;
        zzWq = s3;
        zzaLC = s4;
        zzaLD = pluscommonextras;
    }

    public PlusSession(String s, String as[], String as1[], String as2[], String s1, String s2, String s3, 
            PlusCommonExtras pluscommonextras)
    {
        mVersionCode = 1;
        zzQE = s;
        zzaLx = as;
        zzaLy = as1;
        zzaLz = as2;
        zzaLA = s1;
        zzaLB = s2;
        zzWq = s3;
        zzaLC = null;
        zzaLD = pluscommonextras;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PlusSession)
        {
            if (mVersionCode == ((PlusSession) (obj = (PlusSession)obj)).mVersionCode && zzw.equal(zzQE, ((PlusSession) (obj)).zzQE) && Arrays.equals(zzaLx, ((PlusSession) (obj)).zzaLx) && Arrays.equals(zzaLy, ((PlusSession) (obj)).zzaLy) && Arrays.equals(zzaLz, ((PlusSession) (obj)).zzaLz) && zzw.equal(zzaLA, ((PlusSession) (obj)).zzaLA) && zzw.equal(zzaLB, ((PlusSession) (obj)).zzaLB) && zzw.equal(zzWq, ((PlusSession) (obj)).zzWq) && zzw.equal(zzaLC, ((PlusSession) (obj)).zzaLC) && zzw.equal(zzaLD, ((PlusSession) (obj)).zzaLD))
            {
                return true;
            }
        }
        return false;
    }

    public String getAccountName()
    {
        return zzQE;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(mVersionCode), zzQE, zzaLx, zzaLy, zzaLz, zzaLA, zzaLB, zzWq, zzaLC, zzaLD
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("versionCode", Integer.valueOf(mVersionCode)).zzg("accountName", zzQE).zzg("requestedScopes", zzaLx).zzg("visibleActivities", zzaLy).zzg("requiredFeatures", zzaLz).zzg("packageNameForAuth", zzaLA).zzg("callingPackageName", zzaLB).zzg("applicationName", zzWq).zzg("extra", zzaLD.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public String zzml()
    {
        return zzWq;
    }

    public String[] zzyL()
    {
        return zzaLx;
    }

    public String[] zzyM()
    {
        return zzaLy;
    }

    public String[] zzyN()
    {
        return zzaLz;
    }

    public String zzyO()
    {
        return zzaLA;
    }

    public String zzyP()
    {
        return zzaLB;
    }

    public String zzyQ()
    {
        return zzaLC;
    }

    public PlusCommonExtras zzyR()
    {
        return zzaLD;
    }

    public Bundle zzyS()
    {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(com/google/android/gms/plus/internal/PlusCommonExtras.getClassLoader());
        zzaLD.zzA(bundle);
        return bundle;
    }

}
