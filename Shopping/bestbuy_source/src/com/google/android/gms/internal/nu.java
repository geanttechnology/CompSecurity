// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import adw;
import afm;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class nu
    implements SafeParcelable
{

    public static final afm CREATOR = new afm();
    public final int a;
    public final List b;
    public final List c;
    public final List d;
    private final String e;
    private final boolean f;
    private final Set g;
    private final Set h;
    private final Set i;

    public nu(int j, List list, String s, boolean flag, List list1, List list2)
    {
        a = j;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        b = list;
        list = s;
        if (s == null)
        {
            list = "";
        }
        e = list;
        f = flag;
        if (list1 == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list1);
        }
        c = list;
        if (list2 == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list2);
        }
        d = list;
        g = a(b);
        h = a(c);
        i = a(d);
    }

    private static Set a(List list)
    {
        if (list.isEmpty())
        {
            return Collections.emptySet();
        } else
        {
            return Collections.unmodifiableSet(new HashSet(list));
        }
    }

    public String a()
    {
        return e;
    }

    public boolean b()
    {
        return f;
    }

    public int describeContents()
    {
        afm afm1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof nu))
            {
                return false;
            }
            obj = (nu)obj;
            if (!g.equals(((nu) (obj)).g) || f != ((nu) (obj)).f || !h.equals(((nu) (obj)).h) || !i.equals(((nu) (obj)).i))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            g, Boolean.valueOf(f), h, i
        });
    }

    public String toString()
    {
        return adv.a(this).a("types", g).a("placeIds", i).a("requireOpenNow", Boolean.valueOf(f)).a("requestedUserDataTypes", h).toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        afm afm1 = CREATOR;
        afm.a(this, parcel, j);
    }

}
