// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.stats:
//            g

public final class WakeLockEvent
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new g();
    final int a;
    final long b;
    int c;
    final String d;
    final int e;
    final List f;
    final String g;
    final long h;
    int i;
    final String j;
    final String k;
    final float l;
    private long m;

    WakeLockEvent(int i1, long l1, int j1, String s, int k1, List list, 
            String s1, long l2, int i2, String s2, String s3, float f1)
    {
        a = i1;
        b = l1;
        c = j1;
        d = s;
        j = s2;
        e = k1;
        m = -1L;
        f = list;
        g = s1;
        h = l2;
        i = i2;
        k = s3;
        l = f1;
    }

    public WakeLockEvent(long l1, int i1, String s, int j1, List list, String s1, 
            long l2, int k1, String s2, String s3, float f1)
    {
        this(1, l1, i1, s, j1, list, s1, l2, k1, s2, s3, f1);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.common.stats.g.a(this, parcel);
    }

}
