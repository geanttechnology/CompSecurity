// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.c.a.a.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, jr, ib

public final class id extends es
    implements b, SafeParcelable
{

    public static final jr CREATOR = new jr();
    private static final HashMap h;
    final Set a;
    final int b;
    String c;
    ib d;
    String e;
    ib f;
    String g;

    public id()
    {
        b = 1;
        a = new HashSet();
    }

    id(Set set, int i, String s, ib ib1, String s1, ib ib2, String s2)
    {
        a = set;
        b = i;
        c = s;
        d = ib1;
        e = s1;
        f = ib2;
        g = s2;
    }

    public final Object a()
    {
        return this;
    }

    protected final boolean a(es.a a1)
    {
        return a.contains(Integer.valueOf(a1.f()));
    }

    protected final Object b(es.a a1)
    {
        switch (a1.f())
        {
        case 3: // '\003'
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(a1.f()).toString());

        case 2: // '\002'
            return c;

        case 4: // '\004'
            return d;

        case 5: // '\005'
            return e;

        case 6: // '\006'
            return f;

        case 7: // '\007'
            return g;
        }
    }

    public final HashMap b()
    {
        return h;
    }

    protected final Object c()
    {
        return null;
    }

    protected final boolean d()
    {
        return false;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof id))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (id)obj;
            es.a a1;
label1:
            do
            {
                for (Iterator iterator = h.values().iterator(); iterator.hasNext();)
                {
                    a1 = (es.a)iterator.next();
                    if (!a(a1))
                    {
                        continue label1;
                    }
                    if (((id) (obj)).a(a1))
                    {
                        if (!b(a1).equals(((id) (obj)).b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((id) (obj)).a(a1));
            return false;
        }
        return true;
    }

    public final int hashCode()
    {
        Iterator iterator = h.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            es.a a1 = (es.a)iterator.next();
            if (a(a1))
            {
                int j = a1.f();
                i = b(a1).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        jr.a(this, parcel, i);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        h = hashmap;
        hashmap.put("id", es.a.d("id", 2));
        h.put("result", es.a.a("result", 4, com/google/android/gms/internal/ib));
        h.put("startDate", es.a.d("startDate", 5));
        h.put("target", es.a.a("target", 6, com/google/android/gms/internal/ib));
        h.put("type", es.a.d("type", 7));
    }
}
