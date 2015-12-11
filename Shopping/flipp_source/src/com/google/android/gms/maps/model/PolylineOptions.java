// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.a.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            i

public final class PolylineOptions
    implements SafeParcelable
{

    public static final i CREATOR = new i();
    final int a;
    final List b;
    float c;
    int d;
    float e;
    boolean f;
    boolean g;

    public PolylineOptions()
    {
        c = 10F;
        d = 0xff000000;
        e = 0.0F;
        f = true;
        g = false;
        a = 1;
        b = new ArrayList();
    }

    PolylineOptions(int j, List list, float f1, int k, float f2, boolean flag, boolean flag1)
    {
        c = 10F;
        d = 0xff000000;
        e = 0.0F;
        f = true;
        g = false;
        a = j;
        b = list;
        c = f1;
        d = k;
        e = f2;
        f = flag;
        g = flag1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        if (com.google.android.gms.maps.a.b.a())
        {
            j = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, a);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 2, b, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, c);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 4, d);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, e);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, f);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, g);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, j);
            return;
        } else
        {
            i.a(this, parcel);
            return;
        }
    }

}
