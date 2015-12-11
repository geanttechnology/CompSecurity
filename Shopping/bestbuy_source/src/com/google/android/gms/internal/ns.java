// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import adw;
import afl;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            nu

public final class ns
    implements SafeParcelable
{

    public static final afl CREATOR = new afl();
    private final int a;
    private final int b;
    private final int c;
    private final nu d;

    public ns(int i, int j, int k, nu nu1)
    {
        a = i;
        b = j;
        c = k;
        d = nu1;
    }

    public int a()
    {
        return a;
    }

    public int b()
    {
        return b;
    }

    public int c()
    {
        return c;
    }

    public nu d()
    {
        return d;
    }

    public int describeContents()
    {
        afl afl1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ns))
            {
                return false;
            }
            obj = (ns)obj;
            if (b != ((ns) (obj)).b || c != ((ns) (obj)).c || !d.equals(((ns) (obj)).d))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            Integer.valueOf(b), Integer.valueOf(c)
        });
    }

    public String toString()
    {
        return adv.a(this).a("transitionTypes", Integer.valueOf(b)).a("loiteringTimeMillis", Integer.valueOf(c)).a("placeFilter", d).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        afl afl1 = CREATOR;
        afl.a(this, parcel, i);
    }

}
