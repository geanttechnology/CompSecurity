// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v7.lk;
import android.support.v7.ll;
import android.support.v7.re;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zza, zzk, zzj

public final class GInAppPurchaseManagerInfoParcel
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    public final int versionCode;
    public final re zzBJ;
    public final Context zzBK;
    public final zzj zzBL;
    public final zzk zzqw;

    GInAppPurchaseManagerInfoParcel(int i, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3)
    {
        versionCode = i;
        zzqw = (zzk)ll.a(android.support.v7.lk.a.a(ibinder));
        zzBJ = (re)ll.a(android.support.v7.lk.a.a(ibinder1));
        zzBK = (Context)ll.a(android.support.v7.lk.a.a(ibinder2));
        zzBL = (zzj)ll.a(android.support.v7.lk.a.a(ibinder3));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzk1, re re1, zzj zzj1)
    {
        versionCode = 2;
        zzBK = context;
        zzqw = zzk1;
        zzBJ = re1;
        zzBL = zzj1;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel ginapppurchasemanagerinfoparcel)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", ginapppurchasemanagerinfoparcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent)
    {
        try
        {
            intent = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            intent.setClassLoader(com/google/android/gms/ads/internal/purchase/GInAppPurchaseManagerInfoParcel.getClassLoader());
            intent = (GInAppPurchaseManagerInfoParcel)intent.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.ads.internal.purchase.zza.zza(this, parcel, i);
    }

    IBinder zzfc()
    {
        return ll.a(zzBL).asBinder();
    }

    IBinder zzfd()
    {
        return ll.a(zzqw).asBinder();
    }

    IBinder zzfe()
    {
        return ll.a(zzBJ).asBinder();
    }

    IBinder zzff()
    {
        return ll.a(zzBK).asBinder();
    }

}
