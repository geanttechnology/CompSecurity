// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.paypal.android.sdk:
//            dg

public final class ed
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new dg();
    private String a;
    private String b;

    public ed(Parcel parcel)
    {
        a = parcel.readString();
        b = parcel.readString();
    }

    public ed(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public final String a()
    {
        return b;
    }

    public final String b()
    {
        return a;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(com/paypal/android/sdk/ed.getSimpleName()).append("(authCode:").append(a).append(", scope:").append(b).append(")").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(b);
    }

    static 
    {
        com/paypal/android/sdk/ed.getSimpleName();
    }
}
