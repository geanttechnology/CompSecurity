// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.plus.internal:
//            zzf

public class PlusCommonExtras
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    private final int mVersionCode;
    private String zzaLu;
    private String zzaLv;

    public PlusCommonExtras()
    {
        mVersionCode = 1;
        zzaLu = "";
        zzaLv = "";
    }

    PlusCommonExtras(int i, String s, String s1)
    {
        mVersionCode = i;
        zzaLu = s;
        zzaLv = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PlusCommonExtras)
        {
            if (mVersionCode == ((PlusCommonExtras) (obj = (PlusCommonExtras)obj)).mVersionCode && zzw.equal(zzaLu, ((PlusCommonExtras) (obj)).zzaLu) && zzw.equal(zzaLv, ((PlusCommonExtras) (obj)).zzaLv))
            {
                return true;
            }
        }
        return false;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(mVersionCode), zzaLu, zzaLv
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("versionCode", Integer.valueOf(mVersionCode)).zzg("Gpsrc", zzaLu).zzg("ClientCallingPackage", zzaLv).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    public void zzA(Bundle bundle)
    {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzc.zza(this));
    }

    public String zzyJ()
    {
        return zzaLu;
    }

    public String zzyK()
    {
        return zzaLv;
    }

}
