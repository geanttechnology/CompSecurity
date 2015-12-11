// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.b.bk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            a, h, g

public final class GInAppPurchaseManagerInfoParcel
    implements SafeParcelable
{

    public static final com.google.android.gms.ads.internal.purchase.a CREATOR = new com.google.android.gms.ads.internal.purchase.a();
    public final int a;
    public final h b;
    public final bk c;
    public final Context d;
    public final g e;

    GInAppPurchaseManagerInfoParcel(int i, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3)
    {
        a = i;
        b = (h)com.google.android.gms.a.b.a(com.google.android.gms.a.a.a.a(ibinder));
        c = (bk)com.google.android.gms.a.b.a(com.google.android.gms.a.a.a.a(ibinder1));
        d = (Context)com.google.android.gms.a.b.a(com.google.android.gms.a.a.a.a(ibinder2));
        e = (g)com.google.android.gms.a.b.a(com.google.android.gms.a.a.a.a(ibinder3));
    }

    public static GInAppPurchaseManagerInfoParcel a(Intent intent)
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

    IBinder a()
    {
        return com.google.android.gms.a.b.a(e).asBinder();
    }

    IBinder b()
    {
        return com.google.android.gms.a.b.a(b).asBinder();
    }

    IBinder c()
    {
        return com.google.android.gms.a.b.a(c).asBinder();
    }

    IBinder d()
    {
        return com.google.android.gms.a.b.a(d).asBinder();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.ads.internal.purchase.a.a(this, parcel, i);
    }

}
