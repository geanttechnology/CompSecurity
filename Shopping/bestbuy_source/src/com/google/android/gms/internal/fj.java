// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import aam;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class fj
    implements SafeParcelable
{

    public static final aam CREATOR = new aam();
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
    public final long n;
    public final String o;
    public final boolean p;
    public final String q;
    public final String r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;

    public fj(int i1)
    {
        this(10, null, null, null, i1, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, false);
    }

    public fj(int i1, long l1)
    {
        this(10, null, null, null, i1, null, -1L, false, -1L, null, l1, -1, null, -1L, null, false, null, null, false, false, false, false);
    }

    public fj(int i1, String s1, String s2, List list, int j1, List list1, long l1, boolean flag, long l2, List list2, long l3, 
            int k1, String s3, long l4, String s4, boolean flag1, String s5, 
            String s6, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        a = i1;
        b = s1;
        c = s2;
        if (list != null)
        {
            s1 = Collections.unmodifiableList(list);
        } else
        {
            s1 = null;
        }
        d = s1;
        e = j1;
        if (list1 != null)
        {
            s1 = Collections.unmodifiableList(list1);
        } else
        {
            s1 = null;
        }
        f = s1;
        g = l1;
        h = flag;
        i = l2;
        if (list2 != null)
        {
            s1 = Collections.unmodifiableList(list2);
        } else
        {
            s1 = null;
        }
        j = s1;
        k = l3;
        l = k1;
        m = s3;
        n = l4;
        o = s4;
        p = flag1;
        q = s5;
        r = s6;
        s = flag2;
        t = flag3;
        u = flag4;
        v = flag5;
    }

    public fj(String s1, String s2, List list, List list1, long l1, boolean flag, 
            long l2, List list2, long l3, int i1, String s3, 
            long l4, String s4, String s5, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4)
    {
        this(10, s1, s2, list, -2, list1, l1, flag, l2, list2, l3, i1, s3, l4, s4, false, null, s5, flag1, flag2, flag3, flag4);
    }

    public fj(String s1, String s2, List list, List list1, long l1, boolean flag, 
            long l2, List list2, long l3, int i1, String s3, 
            long l4, String s4, boolean flag1, String s5, String s6, boolean flag2, 
            boolean flag3, boolean flag4, boolean flag5)
    {
        this(10, s1, s2, list, -2, list1, l1, flag, l2, list2, l3, i1, s3, l4, s4, flag1, s5, s6, flag2, flag3, flag4, flag5);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        aam.a(this, parcel, i1);
    }

}
