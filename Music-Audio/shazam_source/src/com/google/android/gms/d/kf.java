// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class kf
{
    public static final class a
    {

        public final Map a;
        public final h.a b;

        public final String toString()
        {
            return (new StringBuilder("Properties: ")).append(Collections.unmodifiableMap(a)).append(" pushAfterEvaluate: ").append(b).toString();
        }

        private a(Map map, h.a a1)
        {
            a = map;
            b = a1;
        }

        a(Map map, h.a a1, byte byte0)
        {
            this(map, a1);
        }
    }

    public static final class b
    {

        final Map a;
        h.a b;

        private b()
        {
            a = new HashMap();
        }

        b(byte byte0)
        {
            this();
        }
    }

    public static final class c
    {

        public final List a;
        public final Map b;
        public final String c;
        private final int d;

        public final String toString()
        {
            return (new StringBuilder("Rules: ")).append(a).append("  Macros: ").append(b).toString();
        }

        private c(List list, Map map, String s, int i)
        {
            a = Collections.unmodifiableList(list);
            b = Collections.unmodifiableMap(map);
            c = s;
            d = i;
        }

        c(List list, Map map, String s, int i, byte byte0)
        {
            this(list, map, s, i);
        }
    }

    public static final class d
    {

        final List a;
        final Map b;
        String c;
        int d;

        private d()
        {
            a = new ArrayList();
            b = new HashMap();
            c = "";
            d = 0;
        }

        d(byte byte0)
        {
            this();
        }
    }

    public static final class e
    {

        public final List a;
        public final List b;
        public final List c;
        public final List d;
        public final List e;
        public final List f;
        private final List g;
        private final List h;
        private final List i;
        private final List j;

        public final String toString()
        {
            return (new StringBuilder("Positive predicates: ")).append(a).append("  Negative predicates: ").append(b).append("  Add tags: ").append(c).append("  Remove tags: ").append(d).append("  Add macros: ").append(e).append("  Remove macros: ").append(f).toString();
        }

        private e(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
                List list7, List list8, List list9)
        {
            a = Collections.unmodifiableList(list);
            b = Collections.unmodifiableList(list1);
            c = Collections.unmodifiableList(list2);
            d = Collections.unmodifiableList(list3);
            e = Collections.unmodifiableList(list4);
            f = Collections.unmodifiableList(list5);
            g = Collections.unmodifiableList(list6);
            h = Collections.unmodifiableList(list7);
            i = Collections.unmodifiableList(list8);
            j = Collections.unmodifiableList(list9);
        }

        e(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
                List list7, List list8, List list9, byte byte0)
        {
            this(list, list1, list2, list3, list4, list5, list6, list7, list8, list9);
        }
    }

    public static final class f
    {

        final List a;
        final List b;
        final List c;
        final List d;
        final List e;
        final List f;
        final List g;
        final List h;
        final List i;
        final List j;

        private f()
        {
            a = new ArrayList();
            b = new ArrayList();
            c = new ArrayList();
            d = new ArrayList();
            e = new ArrayList();
            f = new ArrayList();
            g = new ArrayList();
            h = new ArrayList();
            i = new ArrayList();
            j = new ArrayList();
        }

        f(byte byte0)
        {
            this();
        }
    }

    public static final class g extends Exception
    {

        public g(String s)
        {
            super(s);
        }
    }


    public static h.a a(h.a a1)
    {
        h.a a2 = new h.a();
        a2.a = a1.a;
        a2.k = (int[])a1.k.clone();
        if (a1.l)
        {
            a2.l = a1.l;
        }
        return a2;
    }
}
