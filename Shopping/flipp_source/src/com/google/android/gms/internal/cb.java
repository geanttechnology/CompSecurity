// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            dn

public final class cb
    implements SafeParcelable
{

    public static final dn CREATOR = new dn();
    public final int a;
    public final String b;
    public final String c;
    public final List d;
    public final int e;
    public final List f;
    public final long g;
    public final boolean h;
    public final long i;
    public final List j;
    public final long k;
    public final int l;
    public final String m;

    public cb(int i1)
    {
        this(2, null, null, null, i1, null, -1L, false, -1L, null, -1L, -1, null);
    }

    cb(int i1, String s, String s1, List list, int j1, List list1, long l1, boolean flag, long l2, List list2, long l3, 
            int k1, String s2)
    {
        a = i1;
        b = s;
        c = s1;
        if (list != null)
        {
            s = Collections.unmodifiableList(list);
        } else
        {
            s = null;
        }
        d = s;
        e = j1;
        if (list1 != null)
        {
            s = Collections.unmodifiableList(list1);
        } else
        {
            s = null;
        }
        f = s;
        g = l1;
        h = flag;
        i = l2;
        if (list2 != null)
        {
            s = Collections.unmodifiableList(list2);
        } else
        {
            s = null;
        }
        j = s;
        k = l3;
        l = k1;
        m = s2;
    }

    public cb(String s, String s1, List list, List list1, long l1, boolean flag, 
            List list2, long l2, int i1, String s2)
    {
        this(2, s, s1, list, -2, list1, l1, flag, -1L, list2, l2, i1, s2);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        dn.a(this, parcel);
    }

}
