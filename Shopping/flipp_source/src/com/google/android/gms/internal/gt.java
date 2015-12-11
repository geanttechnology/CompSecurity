// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            ja, gw, gy

public final class gt
    implements SafeParcelable
{

    public static final ja CREATOR = new ja();
    final int a;
    final int b;
    final List c;
    final String d;
    final String e;
    final boolean f;
    private final Set g;

    gt(int i, int j, List list, String s, String s1, boolean flag)
    {
        a = i;
        b = j;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        c = list;
        list = s;
        if (s == null)
        {
            list = "";
        }
        d = list;
        list = s1;
        if (s1 == null)
        {
            list = "";
        }
        e = list;
        f = flag;
        if (c.isEmpty())
        {
            g = Collections.emptySet();
            return;
        } else
        {
            g = Collections.unmodifiableSet(new HashSet(c));
            return;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof gt))
            {
                return false;
            }
            obj = (gt)obj;
            if (b != ((gt) (obj)).b || !g.equals(((gt) (obj)).g) || d != ((gt) (obj)).d || e != ((gt) (obj)).e || f != ((gt) (obj)).f)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(b), g, d, e, Boolean.valueOf(f)
        });
    }

    public final String toString()
    {
        return gw.a(this).a("maxResults", Integer.valueOf(b)).a("types", g).a("nameQuery", d).a("textQuery", e).a("isOpenNowRequired", Boolean.valueOf(f)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ja.a(this, parcel);
    }

}
