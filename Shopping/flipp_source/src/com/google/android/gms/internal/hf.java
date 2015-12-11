// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            jl, gw, gy

public final class hf
    implements SafeParcelable
{

    public static final jl CREATOR = new jl();
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final List f;

    public hf(int i, String s, String s1, String s2, String s3, List list)
    {
        a = i;
        b = s;
        c = s1;
        d = s2;
        e = s3;
        f = list;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hf))
            {
                return false;
            }
            obj = (hf)obj;
            if (!gw.a(b, ((hf) (obj)).b) || !gw.a(c, ((hf) (obj)).c) || !gw.a(d, ((hf) (obj)).d) || !gw.a(e, ((hf) (obj)).e) || !gw.a(f, ((hf) (obj)).f))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, c, d, e
        });
    }

    public final String toString()
    {
        return gw.a(this).a("name", b).a("address", c).a("internationalPhoneNumber", d).a("regularOpenHours", e).a("attributions", f).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        jl.a(this, parcel);
    }

}
