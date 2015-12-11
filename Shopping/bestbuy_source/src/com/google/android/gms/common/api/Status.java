// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import adv;
import adw;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ql;
import qt;
import qv;

public final class Status
    implements SafeParcelable, qt
{

    public static final qv CREATOR = new qv();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    private final int f;
    private final int g;
    private final String h;
    private final PendingIntent i;

    public Status(int j)
    {
        this(j, null);
    }

    public Status(int j, int k, String s, PendingIntent pendingintent)
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

    private String g()
    {
        if (h != null)
        {
            return h;
        } else
        {
            return ql.a(g);
        }
    }

    public PendingIntent a()
    {
        return i;
    }

    public Status b()
    {
        return this;
    }

    public String c()
    {
        return h;
    }

    public int d()
    {
        return f;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean e()
    {
        return g <= 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (f == ((Status) (obj = (Status)obj)).f && g == ((Status) (obj)).g && adv.a(h, ((Status) (obj)).h) && adv.a(i, ((Status) (obj)).i))
            {
                return true;
            }
        }
        return false;
    }

    public int f()
    {
        return g;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            Integer.valueOf(f), Integer.valueOf(g), h, i
        });
    }

    public String toString()
    {
        return adv.a(this).a("statusCode", g()).a("resolution", i).toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        qv.a(this, parcel, j);
    }

}
