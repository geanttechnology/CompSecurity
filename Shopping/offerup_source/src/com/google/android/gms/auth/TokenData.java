// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

// Referenced classes of package com.google.android.gms.auth:
//            zzd

public class TokenData
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    private final Long zzRA;
    private final boolean zzRB;
    private final boolean zzRC;
    private final List zzRD;
    private final String zzRz;

    TokenData(int i, String s, Long long1, boolean flag, boolean flag1, List list)
    {
        mVersionCode = i;
        zzRz = zzx.zzcr(s);
        zzRA = long1;
        zzRB = flag;
        zzRC = flag1;
        zzRD = list;
    }

    public static TokenData zza(Bundle bundle, String s)
    {
        bundle.setClassLoader(com/google/android/gms/auth/TokenData.getClassLoader());
        bundle = bundle.getBundle(s);
        if (bundle == null)
        {
            return null;
        } else
        {
            bundle.setClassLoader(com/google/android/gms/auth/TokenData.getClassLoader());
            return (TokenData)bundle.getParcelable("TokenData");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof TokenData)
        {
            if (TextUtils.equals(zzRz, ((TokenData) (obj = (TokenData)obj)).zzRz) && zzw.equal(zzRA, ((TokenData) (obj)).zzRA) && zzRB == ((TokenData) (obj)).zzRB && zzRC == ((TokenData) (obj)).zzRC && zzw.equal(zzRD, ((TokenData) (obj)).zzRD))
            {
                return true;
            }
        }
        return false;
    }

    public String getToken()
    {
        return zzRz;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzRz, zzRA, Boolean.valueOf(zzRB), Boolean.valueOf(zzRC), zzRD
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    public Long zzlA()
    {
        return zzRA;
    }

    public boolean zzlB()
    {
        return zzRB;
    }

    public boolean zzlC()
    {
        return zzRC;
    }

    public List zzlD()
    {
        return zzRD;
    }

}
