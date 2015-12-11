// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.c.a.b.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, js, ep

public final class ig extends es
    implements a, SafeParcelable
{

    private static final HashMap A;
    public static final js CREATOR = new js();
    final Set a;
    final int b;
    String c;
    a d;
    String e;
    String f;
    int g;
    b h;
    String i;
    String j;
    int k;
    String l;
    c m;
    boolean n;
    String o;
    d p;
    String q;
    int r;
    List s;
    List t;
    int u;
    int v;
    String w;
    String x;
    List y;
    boolean z;

    public ig()
    {
        b = 2;
        a = new HashSet();
    }

    ig(Set set, int i1, String s1, a a1, String s2, String s3, int j1, 
            b b1, String s4, String s5, int k1, String s6, c c1, boolean flag, 
            String s7, d d1, String s8, int l1, List list, List list1, int i2, 
            int j2, String s9, String s10, List list2, boolean flag1)
    {
        a = set;
        b = i1;
        c = s1;
        d = a1;
        e = s2;
        f = s3;
        g = j1;
        h = b1;
        i = s4;
        j = s5;
        k = k1;
        l = s6;
        m = c1;
        n = flag;
        o = s7;
        p = d1;
        q = s8;
        r = l1;
        s = list;
        t = list1;
        u = i2;
        v = j2;
        w = s9;
        x = s10;
        y = list2;
        z = flag1;
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
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(a1.f()).toString());

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return d;

        case 4: // '\004'
            return e;

        case 5: // '\005'
            return f;

        case 6: // '\006'
            return Integer.valueOf(g);

        case 7: // '\007'
            return h;

        case 8: // '\b'
            return i;

        case 9: // '\t'
            return j;

        case 12: // '\f'
            return Integer.valueOf(k);

        case 14: // '\016'
            return l;

        case 15: // '\017'
            return m;

        case 16: // '\020'
            return Boolean.valueOf(n);

        case 18: // '\022'
            return o;

        case 19: // '\023'
            return p;

        case 20: // '\024'
            return q;

        case 21: // '\025'
            return Integer.valueOf(r);

        case 22: // '\026'
            return s;

        case 23: // '\027'
            return t;

        case 24: // '\030'
            return Integer.valueOf(u);

        case 25: // '\031'
            return Integer.valueOf(v);

        case 26: // '\032'
            return w;

        case 27: // '\033'
            return x;

        case 28: // '\034'
            return y;

        case 29: // '\035'
            return Boolean.valueOf(z);
        }
    }

    public final HashMap b()
    {
        return A;
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
            if (!(obj instanceof ig))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (ig)obj;
            es.a a1;
label1:
            do
            {
                for (Iterator iterator = A.values().iterator(); iterator.hasNext();)
                {
                    a1 = (es.a)iterator.next();
                    if (!a(a1))
                    {
                        continue label1;
                    }
                    if (((ig) (obj)).a(a1))
                    {
                        if (!b(a1).equals(((ig) (obj)).b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((ig) (obj)).a(a1));
            return false;
        }
        return true;
    }

    public final int hashCode()
    {
        Iterator iterator = A.values().iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            es.a a1 = (es.a)iterator.next();
            if (a(a1))
            {
                int j1 = a1.f();
                i1 = b(a1).hashCode() + (i1 + j1);
            }
        } while (true);
        return i1;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.internal.js.a(this, parcel, i1);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        A = hashmap;
        hashmap.put("aboutMe", es.a.d("aboutMe", 2));
        A.put("ageRange", com.google.android.gms.internal.es.a.a("ageRange", 3, com/google/android/gms/internal/ig$a));
        A.put("birthday", es.a.d("birthday", 4));
        A.put("braggingRights", es.a.d("braggingRights", 5));
        A.put("circledByCount", com.google.android.gms.internal.es.a.a("circledByCount", 6));
        A.put("cover", com.google.android.gms.internal.es.a.a("cover", 7, com/google/android/gms/internal/ig$b));
        A.put("currentLocation", es.a.d("currentLocation", 8));
        A.put("displayName", es.a.d("displayName", 9));
        A.put("gender", com.google.android.gms.internal.es.a.a("gender", 12, (new ep()).a("male", 0).a("female", 1).a("other", 2)));
        A.put("id", es.a.d("id", 14));
        A.put("image", com.google.android.gms.internal.es.a.a("image", 15, com/google/android/gms/internal/ig$c));
        A.put("isPlusUser", es.a.c("isPlusUser", 16));
        A.put("language", es.a.d("language", 18));
        A.put("name", com.google.android.gms.internal.es.a.a("name", 19, com/google/android/gms/internal/ig$d));
        A.put("nickname", es.a.d("nickname", 20));
        A.put("objectType", com.google.android.gms.internal.es.a.a("objectType", 21, (new ep()).a("person", 0).a("page", 1)));
        A.put("organizations", es.a.b("organizations", 22, com/google/android/gms/internal/ig$f));
        A.put("placesLived", es.a.b("placesLived", 23, com/google/android/gms/internal/ig$g));
        A.put("plusOneCount", com.google.android.gms.internal.es.a.a("plusOneCount", 24));
        A.put("relationshipStatus", com.google.android.gms.internal.es.a.a("relationshipStatus", 25, (new ep()).a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8)));
        A.put("tagline", es.a.d("tagline", 26));
        A.put("url", es.a.d("url", 27));
        A.put("urls", es.a.b("urls", 28, com/google/android/gms/internal/ig$h));
        A.put("verified", es.a.c("verified", 29));
    }
}
