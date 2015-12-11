// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.a.b;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            a

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final com.google.android.gms.maps.a CREATOR = new com.google.android.gms.maps.a();
    final int a;
    Boolean b;
    Boolean c;
    int d;
    CameraPosition e;
    Boolean f;
    Boolean g;
    Boolean h;
    Boolean i;
    Boolean j;
    Boolean k;

    public GoogleMapOptions()
    {
        d = -1;
        a = 1;
    }

    GoogleMapOptions(int l, byte byte0, byte byte1, int i1, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7)
    {
        d = -1;
        a = l;
        b = com.google.android.gms.maps.a.a.a(byte0);
        c = com.google.android.gms.maps.a.a.a(byte1);
        d = i1;
        e = cameraposition;
        f = com.google.android.gms.maps.a.a.a(byte2);
        g = com.google.android.gms.maps.a.a.a(byte3);
        h = com.google.android.gms.maps.a.a.a(byte4);
        i = com.google.android.gms.maps.a.a.a(byte5);
        j = com.google.android.gms.maps.a.a.a(byte6);
        k = com.google.android.gms.maps.a.a.a(byte7);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int l)
    {
        if (com.google.android.gms.maps.a.b.a())
        {
            int i1 = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, a);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, com.google.android.gms.maps.a.a.a(b));
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, com.google.android.gms.maps.a.a.a(c));
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 4, d);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, e, l, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, com.google.android.gms.maps.a.a.a(f));
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, com.google.android.gms.maps.a.a.a(g));
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, com.google.android.gms.maps.a.a.a(h));
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 9, com.google.android.gms.maps.a.a.a(i));
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 10, com.google.android.gms.maps.a.a.a(j));
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 11, com.google.android.gms.maps.a.a.a(k));
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, i1);
            return;
        } else
        {
            a(this, parcel, l);
            return;
        }
    }

}
