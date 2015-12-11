// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import ti;

// Referenced classes of package com.google.android.gms.internal:
//            bj

public final class av
    implements SafeParcelable
{

    public static final ti CREATOR = new ti();
    public final int a;
    public final long b;
    public final Bundle c;
    public final int d;
    public final List e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final bj j;
    public final Location k;
    public final String l;
    public final Bundle m;

    public av(int i1, long l1, Bundle bundle, int j1, List list, boolean flag, 
            int k1, boolean flag1, String s, bj bj, Location location, String s1, Bundle bundle1)
    {
        a = i1;
        b = l1;
        c = bundle;
        d = j1;
        e = list;
        f = flag;
        g = k1;
        h = flag1;
        i = s;
        j = bj;
        k = location;
        l = s1;
        m = bundle1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        ti.a(this, parcel, i1);
    }

}
