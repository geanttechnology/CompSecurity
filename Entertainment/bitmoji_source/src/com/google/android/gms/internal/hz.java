// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ia, ep

public final class hz
    implements SafeParcelable
{

    public static final ia CREATOR = new ia();
    public final String Ov;
    public final String Ow;
    public final String Ox;
    public final List Oy;
    public final String name;
    public final int versionCode;

    public hz(int i, String s, String s1, String s2, String s3, List list)
    {
        versionCode = i;
        name = s;
        Ov = s1;
        Ow = s2;
        Ox = s3;
        Oy = list;
    }

    public int describeContents()
    {
        ia ia1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hz))
            {
                return false;
            }
            obj = (hz)obj;
            if (!ep.equal(name, ((hz) (obj)).name) || !ep.equal(Ov, ((hz) (obj)).Ov) || !ep.equal(Ow, ((hz) (obj)).Ow) || !ep.equal(Ox, ((hz) (obj)).Ox) || !ep.equal(Oy, ((hz) (obj)).Oy))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            name, Ov, Ow, Ox
        });
    }

    public String toString()
    {
        return ep.e(this).a("name", name).a("address", Ov).a("internationalPhoneNumber", Ow).a("regularOpenHours", Ox).a("attributions", Oy).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ia ia1 = CREATOR;
        ia.a(this, parcel, i);
    }

}
