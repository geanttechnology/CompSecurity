// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

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
    private final int f;
    private final int g;
    private final String h;
    private final PendingIntent i;

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

    private String h()
    {
        if (h != null)
        {
            return h;
        } else
        {
            return com.google.android.gms.common.api.b.a(g);
        }
    }

    public Status a()
    {
        return this;
    }

    public void a(Activity activity, int j)
        throws android.content.IntentSender.SendIntentException
    {
        if (!e())
        {
            return;
        } else
        {
            activity.startIntentSenderForResult(i.getIntentSender(), j, null, 0, 0, 0);
            return;
        }
    }

    PendingIntent b()
    {
        return i;
    }

    public String c()
    {
        return h;
    }

    int d()
    {
        return f;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean e()
    {
        return i != null;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (f == ((Status) (obj = (Status)obj)).f && g == ((Status) (obj)).g && w.a(h, ((Status) (obj)).h) && w.a(i, ((Status) (obj)).i))
            {
                return true;
            }
        }
        return false;
    }

    public boolean f()
    {
        return g <= 0;
    }

    public int g()
    {
        return g;
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            Integer.valueOf(f), Integer.valueOf(g), h, i
        });
    }

    public String toString()
    {
        return w.a(this).a("statusCode", h()).a("resolution", i).toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        t.a(this, parcel, j);
    }

}
