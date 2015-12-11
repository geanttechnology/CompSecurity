// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            hg, ee

public final class hf
    implements SafeParcelable
{

    public static final hg CREATOR = new hg();
    public final String Bf;
    public final String Bg;
    public final String Bh;
    public final List Bi;
    public final String name;
    public final int versionCode;

    public hf(int i, String s, String s1, String s2, String s3, List list)
    {
        versionCode = i;
        name = s;
        Bf = s1;
        Bg = s2;
        Bh = s3;
        Bi = list;
    }

    public int describeContents()
    {
        hg hg1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hf))
            {
                return false;
            }
            obj = (hf)obj;
            if (!ee.equal(name, ((hf) (obj)).name) || !ee.equal(Bf, ((hf) (obj)).Bf) || !ee.equal(Bg, ((hf) (obj)).Bg) || !ee.equal(Bh, ((hf) (obj)).Bh) || !ee.equal(Bi, ((hf) (obj)).Bi))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            name, Bf, Bg, Bh
        });
    }

    public String toString()
    {
        return ee.e(this).a("name", name).a("address", Bf).a("internationalPhoneNumber", Bg).a("regularOpenHours", Bh).a("attributions", Bi).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hg hg1 = CREATOR;
        hg.a(this, parcel, i);
    }

}
