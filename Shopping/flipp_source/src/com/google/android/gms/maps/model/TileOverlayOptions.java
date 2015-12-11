// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.model.a.a;
import com.google.android.gms.maps.model.a.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            l, k, m

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final l CREATOR = new l();
    final int a;
    boolean b;
    float c;
    boolean d;
    private a e;
    private m f;

    public TileOverlayOptions()
    {
        b = true;
        d = true;
        a = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f1, boolean flag1)
    {
        b = true;
        d = true;
        a = i;
        e = com.google.android.gms.maps.model.a.b.a(ibinder);
        if (e == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new k(this);
        }
        f = ibinder;
        b = flag;
        c = f1;
        d = flag1;
    }

    static a a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.e;
    }

    final IBinder a()
    {
        return e.asBinder();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (com.google.android.gms.maps.a.b.a())
        {
            i = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, a);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, a());
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, b);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, c);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, i);
            return;
        } else
        {
            com.google.android.gms.maps.model.l.a(this, parcel);
            return;
        }
    }

}
