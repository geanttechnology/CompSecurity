// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import adw;
import afo;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            nu

public final class ny
    implements SafeParcelable
{

    public static final afo CREATOR = new afo();
    public static final long a;
    public final int b;
    private final nu c;
    private final long d;
    private final int e;

    public ny(int i, nu nu, long l, int j)
    {
        b = i;
        c = nu;
        d = l;
        e = j;
    }

    public nu a()
    {
        return c;
    }

    public long b()
    {
        return d;
    }

    public int c()
    {
        return e;
    }

    public int describeContents()
    {
        afo afo1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ny))
            {
                return false;
            }
            obj = (ny)obj;
            if (!adv.a(c, ((ny) (obj)).c) || d != ((ny) (obj)).d || e != ((ny) (obj)).e)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            c, Long.valueOf(d), Integer.valueOf(e)
        });
    }

    public String toString()
    {
        return adv.a(this).a("filter", c).a("interval", Long.valueOf(d)).a("priority", Integer.valueOf(e)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        afo afo1 = CREATOR;
        afo.a(this, parcel, i);
    }

    static 
    {
        a = TimeUnit.HOURS.toMillis(1L);
    }
}
