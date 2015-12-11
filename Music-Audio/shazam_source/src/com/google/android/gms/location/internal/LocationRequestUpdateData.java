// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.k;
import com.google.android.gms.location.l;

// Referenced classes of package com.google.android.gms.location.internal:
//            k, LocationRequestInternal

public class LocationRequestUpdateData
    implements SafeParcelable
{

    public static final com.google.android.gms.location.internal.k CREATOR = new com.google.android.gms.location.internal.k();
    final int a;
    int b;
    LocationRequestInternal c;
    l d;
    PendingIntent e;
    k f;

    LocationRequestUpdateData(int i, int j, LocationRequestInternal locationrequestinternal, IBinder ibinder, PendingIntent pendingintent, IBinder ibinder1)
    {
        Object obj = null;
        super();
        a = i;
        b = j;
        c = locationrequestinternal;
        if (ibinder == null)
        {
            locationrequestinternal = null;
        } else
        {
            locationrequestinternal = com.google.android.gms.location.l.a.a(ibinder);
        }
        d = locationrequestinternal;
        e = pendingintent;
        if (ibinder1 == null)
        {
            locationrequestinternal = obj;
        } else
        {
            locationrequestinternal = com.google.android.gms.location.k.a.a(ibinder1);
        }
        f = locationrequestinternal;
    }

    public static LocationRequestUpdateData a(k k1)
    {
        return new LocationRequestUpdateData(1, 2, null, null, null, k1.asBinder());
    }

    public static LocationRequestUpdateData a(l l1)
    {
        return new LocationRequestUpdateData(1, 2, null, l1.asBinder(), null, null);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        k.a(this, parcel, i);
    }

}
