// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

// Referenced classes of package com.google.android.gms.wallet:
//            zzn

public final class OfferWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzn();
    private final int mVersionCode;
    CommonWalletObject zzaWv;
    String zzaXu;
    String zzhL;

    OfferWalletObject()
    {
        mVersionCode = 3;
    }

    OfferWalletObject(int i, String s, String s1, CommonWalletObject commonwalletobject)
    {
        mVersionCode = i;
        zzaXu = s1;
        if (i < 3)
        {
            zzaWv = CommonWalletObject.zzCn().zzfu(s).zzCo();
            return;
        } else
        {
            zzaWv = commonwalletobject;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String getId()
    {
        return zzaWv.getId();
    }

    public String getRedemptionCode()
    {
        return zzaXu;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

}
