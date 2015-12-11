// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.stats:
//            a

public final class ConnectionEvent
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    final int a;
    final long b;
    int c;
    final String d;
    final String e;
    final String f;
    final String g;
    final String h;
    final String i;
    final long j;
    final long k;
    private long l;

    ConnectionEvent(int i1, long l1, int j1, String s, String s1, String s2, 
            String s3, String s4, String s5, long l2, long l3)
    {
        a = i1;
        b = l1;
        c = j1;
        d = s;
        e = s1;
        f = s2;
        g = s3;
        l = -1L;
        h = s4;
        i = s5;
        j = l2;
        k = l3;
    }

    public ConnectionEvent(long l1, int i1, String s, String s1, String s2, String s3, 
            String s4, String s5, long l2, long l3)
    {
        this(1, l1, i1, s, s1, s2, s3, s4, s5, l2, l3);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.common.stats.a.a(this, parcel);
    }

}
