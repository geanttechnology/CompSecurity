// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;

// Referenced classes of package com.google.android.gms.internal:
//            bl, q, bn, cw, 
//            al, bq, cu, bj

public final class bm
    implements SafeParcelable
{

    public static final bl CREATOR = new bl();
    public final cu ej;
    public final bj gG;
    public final q gH;
    public final bn gI;
    public final cw gJ;
    public final al gK;
    public final String gL;
    public final boolean gM;
    public final String gN;
    public final bq gO;
    public final int gP;
    public final String go;
    public final int orientation;
    public final int versionCode;

    bm(int i, bj bj, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3, String s, 
            boolean flag, String s1, IBinder ibinder4, int j, int k, String s2, cu cu)
    {
        versionCode = i;
        gG = bj;
        gH = (q)c.b(com.google.android.gms.dynamic.b.a.E(ibinder));
        gI = (bn)c.b(com.google.android.gms.dynamic.b.a.E(ibinder1));
        gJ = (cw)c.b(com.google.android.gms.dynamic.b.a.E(ibinder2));
        gK = (al)c.b(com.google.android.gms.dynamic.b.a.E(ibinder3));
        gL = s;
        gM = flag;
        gN = s1;
        gO = (bq)c.b(com.google.android.gms.dynamic.b.a.E(ibinder4));
        orientation = j;
        gP = k;
        go = s2;
        ej = cu;
    }

    public bm(bj bj, q q1, bn bn1, bq bq1, cu cu)
    {
        versionCode = 1;
        gG = bj;
        gH = q1;
        gI = bn1;
        gJ = null;
        gK = null;
        gL = null;
        gM = false;
        gN = null;
        gO = bq1;
        orientation = -1;
        gP = 4;
        go = null;
        ej = cu;
    }

    public bm(q q1, bn bn1, al al1, bq bq1, cw cw1, boolean flag, int i, 
            String s, cu cu)
    {
        versionCode = 1;
        gG = null;
        gH = q1;
        gI = bn1;
        gJ = cw1;
        gK = al1;
        gL = null;
        gM = flag;
        gN = null;
        gO = bq1;
        orientation = i;
        gP = 3;
        go = s;
        ej = cu;
    }

    public bm(q q1, bn bn1, al al1, bq bq1, cw cw1, boolean flag, int i, 
            String s, String s1, cu cu)
    {
        versionCode = 1;
        gG = null;
        gH = q1;
        gI = bn1;
        gJ = cw1;
        gK = al1;
        gL = s1;
        gM = flag;
        gN = s;
        gO = bq1;
        orientation = i;
        gP = 3;
        go = null;
        ej = cu;
    }

    public bm(q q1, bn bn1, bq bq1, cw cw1, int i, cu cu)
    {
        versionCode = 1;
        gG = null;
        gH = q1;
        gI = bn1;
        gJ = cw1;
        gK = null;
        gL = null;
        gM = false;
        gN = null;
        gO = bq1;
        orientation = i;
        gP = 1;
        go = null;
        ej = cu;
    }

    public bm(q q1, bn bn1, bq bq1, cw cw1, boolean flag, int i, cu cu)
    {
        versionCode = 1;
        gG = null;
        gH = q1;
        gI = bn1;
        gJ = cw1;
        gK = null;
        gL = null;
        gM = flag;
        gN = null;
        gO = bq1;
        orientation = i;
        gP = 2;
        go = null;
        ej = cu;
    }

    public static bm a(Intent intent)
    {
        try
        {
            intent = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            intent.setClassLoader(com/google/android/gms/internal/bm.getClassLoader());
            intent = (bm)intent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    public static void a(Intent intent, bm bm1)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bm1);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder aa()
    {
        return c.h(gH).asBinder();
    }

    IBinder ab()
    {
        return c.h(gI).asBinder();
    }

    IBinder ac()
    {
        return c.h(gJ).asBinder();
    }

    IBinder ad()
    {
        return c.h(gK).asBinder();
    }

    IBinder ae()
    {
        return c.h(gO).asBinder();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        bl.a(this, parcel, i);
    }

}
