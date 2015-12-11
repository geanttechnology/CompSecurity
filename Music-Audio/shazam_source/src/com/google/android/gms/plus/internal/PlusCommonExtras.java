// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.plus.internal:
//            e

public class PlusCommonExtras
    implements SafeParcelable
{

    public static final e CREATOR = new e();
    final int a;
    String b;
    String c;

    public PlusCommonExtras()
    {
        a = 1;
        b = "";
        c = "";
    }

    PlusCommonExtras(int i, String s, String s1)
    {
        a = i;
        b = s;
        c = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PlusCommonExtras)
        {
            if (a == ((PlusCommonExtras) (obj = (PlusCommonExtras)obj)).a && v.a(b, ((PlusCommonExtras) (obj)).b) && v.a(c, ((PlusCommonExtras) (obj)).c))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(a), b, c
        });
    }

    public String toString()
    {
        return v.a(this).a("versionCode", Integer.valueOf(a)).a("Gpsrc", b).a("ClientCallingPackage", c).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        e.a(this, parcel);
    }

}
