// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            eu

public final class cu
    implements SafeParcelable
{

    public static final eu CREATOR = new eu();
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    public cu()
    {
        this(1, "afma-sdk-a-v4242000.4242000.0", 0x40ba50, 0x40ba50, true);
    }

    cu(int i, String s, int j, int k, boolean flag)
    {
        a = i;
        b = s;
        c = j;
        d = k;
        e = flag;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        eu.a(this, parcel);
    }

}
