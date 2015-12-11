// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.a.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            j

public final class Tile
    implements SafeParcelable
{

    public static final j CREATOR = new j();
    final int a;
    public final int b;
    public final int c;
    public final byte d[];

    public Tile()
    {
        this(1, -1, -1, null);
    }

    Tile(int i, int k, int l, byte abyte0[])
    {
        a = i;
        b = k;
        c = l;
        d = abyte0;
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
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 2, b);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 3, c);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, d);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, i);
            return;
        } else
        {
            j.a(this, parcel);
            return;
        }
    }

}
