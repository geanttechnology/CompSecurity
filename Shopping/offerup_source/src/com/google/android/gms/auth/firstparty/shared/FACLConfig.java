// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.auth.firstparty.shared:
//            zza

public class FACLConfig
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    final int version;
    boolean zzTA;
    boolean zzTB;
    boolean zzTC;
    boolean zzTx;
    String zzTy;
    boolean zzTz;

    FACLConfig(int i, boolean flag, String s, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        version = i;
        zzTx = flag;
        zzTy = s;
        zzTz = flag1;
        zzTA = flag2;
        zzTB = flag3;
        zzTC = flag4;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof FACLConfig)
        {
            obj = (FACLConfig)obj;
            flag = flag1;
            if (zzTx == ((FACLConfig) (obj)).zzTx)
            {
                flag = flag1;
                if (TextUtils.equals(zzTy, ((FACLConfig) (obj)).zzTy))
                {
                    flag = flag1;
                    if (zzTz == ((FACLConfig) (obj)).zzTz)
                    {
                        flag = flag1;
                        if (zzTA == ((FACLConfig) (obj)).zzTA)
                        {
                            flag = flag1;
                            if (zzTB == ((FACLConfig) (obj)).zzTB)
                            {
                                flag = flag1;
                                if (zzTC == ((FACLConfig) (obj)).zzTC)
                                {
                                    flag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Boolean.valueOf(zzTx), zzTy, Boolean.valueOf(zzTz), Boolean.valueOf(zzTA), Boolean.valueOf(zzTB), Boolean.valueOf(zzTC)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
