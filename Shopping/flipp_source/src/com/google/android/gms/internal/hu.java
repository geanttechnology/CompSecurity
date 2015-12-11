// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            jo, gw, gy

public class hu
    implements SafeParcelable
{

    public static final jo CREATOR = new jo();
    final int a;
    final String b;
    final String c[];
    final String d[];
    final String e[];
    final String f;
    final String g;
    final String h;
    final String i;

    hu(int j, String s, String as[], String as1[], String as2[], String s1, String s2, 
            String s3, String s4)
    {
        a = j;
        b = s;
        c = as;
        d = as1;
        e = as2;
        f = s1;
        g = s2;
        h = s3;
        i = s4;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof hu)
        {
            if (a == ((hu) (obj = (hu)obj)).a && gw.a(b, ((hu) (obj)).b) && Arrays.equals(c, ((hu) (obj)).c) && Arrays.equals(d, ((hu) (obj)).d) && Arrays.equals(e, ((hu) (obj)).e) && gw.a(f, ((hu) (obj)).f) && gw.a(g, ((hu) (obj)).g) && gw.a(h, ((hu) (obj)).h) && gw.a(i, ((hu) (obj)).i))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(a), b, c, d, e, f, g, h, i
        });
    }

    public String toString()
    {
        return gw.a(this).a("versionCode", Integer.valueOf(a)).a("accountName", b).a("requestedScopes", c).a("visibleActivities", d).a("requiredFeatures", e).a("packageNameForAuth", f).a("callingPackageName", g).a("applicationName", h).toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        jo.a(this, parcel);
    }

}
