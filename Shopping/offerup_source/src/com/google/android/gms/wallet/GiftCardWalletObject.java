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
    CommonWalletObject zzbcC;
    String zzbcD;
    String zzbcE;
    long zzbcF;
    String zzbcG;
    long zzbcH;
    String zzbcI;

    GiftCardWalletObject()
    {
        zzbcC = CommonWalletObject.zzEI().zzEJ();
        mVersionCode = 1;
    }

    GiftCardWalletObject(int i, CommonWalletObject commonwalletobject, String s, String s1, String s2, long l, 
            String s3, long l1, String s4)
    {
        zzbcC = CommonWalletObject.zzEI().zzEJ();
        mVersionCode = i;
        zzbcC = commonwalletobject;
        zzbcD = s;
        pin = s1;
        zzbcF = l;
        zzbcG = s3;
        zzbcH = l1;
        zzbcI = s4;
        zzbcE = s2;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getId()
    {
        return zzbcC.getId();
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
