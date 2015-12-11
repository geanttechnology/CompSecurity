// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location:
//            b

public class a
    implements SafeParcelable
{

    public static final b CREATOR = new b();
    private final int kg;
    private final PendingIntent xr;

    public a(int i, PendingIntent pendingintent)
    {
        kg = i;
        xr = pendingintent;
    }

    public PendingIntent dB()
    {
        return xr;
    }

    public int describeContents()
    {
        b b1 = CREATOR;
        return 0;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        b b1 = CREATOR;
        b.a(this, parcel, i);
    }

}
