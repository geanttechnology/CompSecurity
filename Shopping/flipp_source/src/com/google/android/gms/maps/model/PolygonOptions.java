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
//            h

public final class PolygonOptions
    implements SafeParcelable
{

    public static final h CREATOR = new h();
    final int a;
    final List b;
    final List c;
    float d;
    int e;
    int f;
    float g;
    boolean h;
    boolean i;

    public PolygonOptions()
    {
        d = 10F;
        e = 0xff000000;
        f = 0;
        g = 0.0F;
        h = true;
        i = false;
        a = 1;
        b = new ArrayList();
        c = new ArrayList();
    }

    PolygonOptions(int j, List list, List list1, float f1, int k, int l, float f2, 
            boolean flag, boolean flag1)
    {
        d = 10F;
        e = 0xff000000;
        f = 0;
        g = 0.0F;
        h = true;
        i = false;
        a = j;
        b = list;
        c = list1;
        d = f1;
        e = k;
        f = l;
        g = f2;
        h = flag;
        i = flag1;
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
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, c);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, d);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 5, e);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 6, f);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, g);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, h);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 9, i);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, j);
            return;
        } else
        {
            com.google.android.gms.maps.model.h.a(this, parcel);
            return;
        }
    }

}
