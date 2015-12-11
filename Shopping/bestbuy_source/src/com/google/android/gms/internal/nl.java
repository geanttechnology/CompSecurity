// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import afh;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class nl
    implements SafeParcelable
{

    public static final afh CREATOR = new afh();
    public static final List a = Collections.emptyList();
    public LocationRequest b;
    public boolean c;
    public boolean d;
    public boolean e;
    public List f;
    public final String g;
    private final int h;

    public nl(int i, LocationRequest locationrequest, boolean flag, boolean flag1, boolean flag2, List list, String s)
    {
        h = i;
        b = locationrequest;
        c = flag;
        d = flag1;
        e = flag2;
        f = list;
        g = s;
    }

    public int a()
    {
        return h;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof nl)
        {
            if (adv.a(b, ((nl) (obj = (nl)obj)).b) && c == ((nl) (obj)).c && d == ((nl) (obj)).d && e == ((nl) (obj)).e && adv.a(f, ((nl) (obj)).f))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return b.hashCode();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(b.toString());
        stringbuilder.append(" requestNlpDebugInfo=");
        stringbuilder.append(c);
        stringbuilder.append(" restorePendingIntentListeners=");
        stringbuilder.append(d);
        stringbuilder.append(" triggerUpdate=");
        stringbuilder.append(e);
        stringbuilder.append(" clients=");
        stringbuilder.append(f);
        if (g != null)
        {
            stringbuilder.append(" tag=");
            stringbuilder.append(g);
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        afh.a(this, parcel, i);
    }

}
