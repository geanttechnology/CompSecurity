// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

// Referenced classes of package com.google.android.gms.wallet:
//            zzg

public final class GiftCardWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    final int mVersionCode;
    String pin;
    long zzaWA;
    String zzaWB;
    CommonWalletObject zzaWv;
    String zzaWw;
    String zzaWx;
    long zzaWy;
    String zzaWz;

    GiftCardWalletObject()
    {
        zzaWv = CommonWalletObject.zzCn().zzCo();
        mVersionCode = 1;
    }

    GiftCardWalletObject(int i, CommonWalletObject commonwalletobject, String s, String s1, String s2, long l, 
            String s3, long l1, String s4)
    {
        zzaWv = CommonWalletObject.zzCn().zzCo();
        mVersionCode = i;
        zzaWv = commonwalletobject;
        zzaWw = s;
        pin = s1;
        zzaWy = l;
        zzaWz = s3;
        zzaWA = l1;
        zzaWB = s4;
        zzaWx = s2;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getId()
    {
        return zzaWv.getId();
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
