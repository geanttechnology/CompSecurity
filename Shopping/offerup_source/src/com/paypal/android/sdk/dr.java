// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.paypal.android.sdk:
//            cw, ew, cx

public final class dr
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cw();
    private ew a;
    private String b;
    private cx c;

    public dr()
    {
    }

    public dr(Parcel parcel)
    {
        a = (ew)parcel.readParcelable(com/paypal/android/sdk/ew.getClassLoader());
        b = parcel.readString();
        c = (cx)parcel.readSerializable();
    }

    public final ew a()
    {
        return a;
    }

    public final void a(cx cx1)
    {
        c = cx1;
    }

    public final void a(ew ew1)
    {
        a = ew1;
    }

    public final void a(String s)
    {
        b = s;
    }

    public final String b()
    {
        return b;
    }

    public final cx c()
    {
        return c;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, 0);
        parcel.writeString(b);
        parcel.writeSerializable(c);
    }

}
