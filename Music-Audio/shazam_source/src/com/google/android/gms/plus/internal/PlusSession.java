// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.plus.internal:
//            f, PlusCommonExtras

public class PlusSession
    implements SafeParcelable
{

    public static final f CREATOR = new f();
    final int a;
    final String b;
    final String c[];
    final String d[];
    final String e[];
    final String f;
    final String g;
    final String h;
    final String i;
    final PlusCommonExtras j;

    PlusSession(int k, String s, String as[], String as1[], String as2[], String s1, String s2, 
            String s3, String s4, PlusCommonExtras pluscommonextras)
    {
        a = k;
        b = s;
        c = as;
        d = as1;
        e = as2;
        f = s1;
        g = s2;
        h = s3;
        i = s4;
        j = pluscommonextras;
    }

    public PlusSession(String s, String as[], String as1[], String as2[], String s1, String s2, PlusCommonExtras pluscommonextras)
    {
        a = 1;
        b = s;
        c = as;
        d = as1;
        e = as2;
        f = s1;
        g = s2;
        h = null;
        i = null;
        j = pluscommonextras;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PlusSession)
        {
            if (a == ((PlusSession) (obj = (PlusSession)obj)).a && v.a(b, ((PlusSession) (obj)).b) && Arrays.equals(c, ((PlusSession) (obj)).c) && Arrays.equals(d, ((PlusSession) (obj)).d) && Arrays.equals(e, ((PlusSession) (obj)).e) && v.a(f, ((PlusSession) (obj)).f) && v.a(g, ((PlusSession) (obj)).g) && v.a(h, ((PlusSession) (obj)).h) && v.a(i, ((PlusSession) (obj)).i) && v.a(j, ((PlusSession) (obj)).j))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(a), b, c, d, e, f, g, h, i, j
        });
    }

    public String toString()
    {
        return v.a(this).a("versionCode", Integer.valueOf(a)).a("accountName", b).a("requestedScopes", c).a("visibleActivities", d).a("requiredFeatures", e).a("packageNameForAuth", f).a("callingPackageName", g).a("applicationName", h).a("extra", j.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        com.google.android.gms.plus.internal.f.a(this, parcel, k);
    }

}
