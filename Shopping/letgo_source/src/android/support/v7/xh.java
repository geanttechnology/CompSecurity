// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            lt, ado

public class xh
{
    public static class a
    {

        private final Map a;
        private final lv.a b;

        public static b a()
        {
            return new b();
        }

        public void a(String s, lv.a a1)
        {
            a.put(s, a1);
        }

        public Map b()
        {
            return Collections.unmodifiableMap(a);
        }

        public lv.a c()
        {
            return b;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Properties: ").append(b()).append(" pushAfterEvaluate: ").append(b).toString();
        }

        private a(Map map, lv.a a1)
        {
            a = map;
            b = a1;
        }

    }

    public static class b
    {

        private final Map a;
        private lv.a b;

        public a a()
        {
            return new a(a, b);
        }

        public b a(lv.a a1)
        {
            b = a1;
            return this;
        }

        public b a(String s, lv.a a1)
        {
            a.put(s, a1);
            return this;
        }

        private b()
        {
            a = new HashMap();
        }

    }

    public static class c
    {

        private final List a;
        private final Map b;
        private final String c;
        private final int d;

        public static d a()
        {
            return new d();
        }

        public List b()
        {
            return a;
        }

        public String c()
        {
            return c;
        }

        public Map d()
        {
            return b;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Rules: ").append(b()).append("  Macros: ").append(b).toString();
        }

        private c(List list, Map map, String s, int i)
        {
            a = Collections.unmodifiableList(list);
            b = Collections.unmodifiableMap(map);
            c = s;
            d = i;
        }

    }

    public static class d
    {

        private final List a;
        private final Map b;
        private String c;
        private int d;

        public c a()
        {
            return new c(a, b, c, d);
        }

        public d a(int i)
        {
            d = i;
            return this;
        }

        public d a(a a1)
        {
            String s = ado.a((lv.a)a1.b().get(lt.bk.toString()));
            List list = (List)b.get(s);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                b.put(s, obj);
            }
            ((List) (obj)).add(a1);
            return this;
        }

        public d a(e e1)
        {
            a.add(e1);
            return this;
        }

        public d a(String s)
        {
            c = s;
            return this;
        }

        private d()
        {
            a = new ArrayList();
            b = new HashMap();
            c = "";
            d = 0;
        }

    }

    public static class e
    {

        private final List a;
        private final List b;
        private final List c;
        private final List d;
        private final List e;
        private final List f;
        private final List g;
        private final List h;
        private final List i;
        private final List j;

        public static f a()
        {
            return new f();
        }

        public List b()
        {
            return a;
        }

        public List c()
        {
            return b;
        }

        public List d()
        {
            return c;
        }

        public List e()
        {
            return d;
        }

        public List f()
        {
            return e;
        }

        public List g()
        {
            return g;
        }

        public List h()
        {
            return h;
        }

        public List i()
        {
            return i;
        }

        public List j()
        {
            return j;
        }

        public List k()
        {
            return f;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Positive predicates: ").append(b()).append("  Negative predicates: ").append(c()).append("  Add tags: ").append(d()).append("  Remove tags: ").append(e()).append("  Add macros: ").append(f()).append("  Remove macros: ").append(k()).toString();
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

    }

    public static class f
    {

        private final List a;
        private final List b;
        private final List c;
        private final List d;
        private final List e;
        private final List f;
        private final List g;
        private final List h;
        private final List i;
        private final List j;

        public e a()
        {
            return new e(a, b, c, d, e, f, g, h, i, j);
        }

        public f a(a a1)
        {
            a.add(a1);
            return this;
        }

        public f a(String s)
        {
            i.add(s);
            return this;
        }

        public f b(a a1)
        {
            b.add(a1);
            return this;
        }

        public f b(String s)
        {
            j.add(s);
            return this;
        }

        public f c(a a1)
        {
            c.add(a1);
            return this;
        }

        public f c(String s)
        {
            g.add(s);
            return this;
        }

        public f d(a a1)
        {
            d.add(a1);
            return this;
        }

        public f d(String s)
        {
            h.add(s);
            return this;
        }

        public f e(a a1)
        {
            e.add(a1);
            return this;
        }

        public f f(a a1)
        {
            f.add(a1);
            return this;
        }

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

    }

    public static class g extends Exception
    {

        public g(String s)
        {
            super(s);
        }
    }


    public static lv.a a(lv.a a1)
    {
        lv.a a2 = new lv.a();
        a2.a = a1.a;
        a2.k = (int[])a1.k.clone();
        if (a1.l)
        {
            a2.l = a1.l;
        }
        return a2;
    }
}
