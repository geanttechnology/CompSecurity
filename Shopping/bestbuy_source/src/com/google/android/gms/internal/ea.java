// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ry;
import rz;
import sb;
import xs;
import yd;
import ye;
import yg;

public final class ea
    implements SafeParcelable
{

    public static final xs CREATOR = new xs();
    public final int a;
    public final ye b;
    public final yg c;
    public final Context d;
    public final yd e;

    public ea(int i, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3)
    {
        a = i;
        b = (ye)sb.a(rz.a(ibinder));
        c = (yg)sb.a(rz.a(ibinder1));
        d = (Context)sb.a(rz.a(ibinder2));
        e = (yd)sb.a(rz.a(ibinder3));
    }

    public ea(Context context, ye ye1, yg yg1, yd yd1)
    {
        a = 2;
        d = context;
        b = ye1;
        c = yg1;
        e = yd1;
    }

    public static ea a(Intent intent)
    {
        try
        {
            intent = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            intent.setClassLoader(com/google/android/gms/internal/ea.getClassLoader());
            intent = (ea)intent.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    public static void a(Intent intent, ea ea1)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", ea1);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public IBinder a()
    {
        return sb.a(e).asBinder();
    }

    public IBinder b()
    {
        return sb.a(b).asBinder();
    }

    public IBinder c()
    {
        return sb.a(c).asBinder();
    }

    public IBinder d()
    {
        return sb.a(d).asBinder();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        xs.a(this, parcel, i);
    }

}
