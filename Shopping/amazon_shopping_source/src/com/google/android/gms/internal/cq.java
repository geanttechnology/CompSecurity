// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

// Referenced classes of package com.google.android.gms.internal:
//            cp, dg, cz, db

public final class cq
    implements SafeParcelable
{

    public static final cp CREATOR = new cp();
    public final dg kX;
    public final cz kZ;
    public final db oT;
    public final Context oU;
    public final int versionCode;

    cq(int i, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3)
    {
        versionCode = i;
        kX = (dg)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder));
        kZ = (cz)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder1));
        oT = (db)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder2));
        oU = (Context)e.e(com.google.android.gms.dynamic.d.a.ag(ibinder3));
    }

    IBinder bd()
    {
        return e.h(kX).asBinder();
    }

    IBinder be()
    {
        return e.h(kZ).asBinder();
    }

    IBinder bf()
    {
        return e.h(oT).asBinder();
    }

    IBinder bg()
    {
        return e.h(oU).asBinder();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        cp.a(this, parcel, i);
    }

}
