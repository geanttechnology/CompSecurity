// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common.api:
//            g, t, b

public final class Status
    implements g, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new t();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    final int f;
    final int g;
    final String h;
    final PendingIntent i;

    public Status(int j)
    {
        this(j, null);
    }

    Status(int j, int k, String s, PendingIntent pendingintent)
    {
        f = j;
        g = k;
        h = s;
        i = pendingintent;
    }

    public Status(int j, String s)
    {
        this(1, j, s, null);
    }

    public Status(int j, String s, PendingIntent pendingintent)
    {
        this(1, j, s, pendingintent);
    }

    public final Status a()
    {
        return this;
    }

    public final boolean b()
    {
        return g <= 0;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (f == ((Status) (obj = (Status)obj)).f && g == ((Status) (obj)).g && v.a(h, ((Status) (obj)).h) && v.a(i, ((Status) (obj)).i))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(f), Integer.valueOf(g), h, i
        });
    }

    public final String toString()
    {
        com.google.android.gms.common.internal.v.a a1 = v.a(this);
        String s;
        if (h != null)
        {
            s = h;
        } else
        {
            s = com.google.android.gms.common.api.b.a(g);
        }
        return a1.a("statusCode", s).a("resolution", i).toString();
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        t.a(this, parcel, j);
    }

}
