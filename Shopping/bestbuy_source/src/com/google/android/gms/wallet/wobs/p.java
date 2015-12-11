// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import atq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            l, n

public final class p
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atq();
    public String a;
    public String b;
    public l c;
    public n d;
    public n e;
    private final int f;

    p()
    {
        f = 1;
    }

    public p(int i, String s, String s1, l l, n n, n n1)
    {
        f = i;
        a = s;
        b = s1;
        c = l;
        d = n;
        e = n1;
    }

    public int a()
    {
        return f;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        atq.a(this, parcel, i);
    }

}
