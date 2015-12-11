// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            ae, af, w, j, 
//            aj, ag, ad, ax, 
//            bk

public final class az extends ae
{
    private final class a extends ag
    {

        final az a;

        public final bk a()
        {
            return b().a();
        }

        final ae d()
        {
            return a;
        }

        final ad f()
        {
            return new ax(this, az.a(a));
        }

        public final Iterator iterator()
        {
            return b().a();
        }

        private a()
        {
            a = az.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b extends af
    {

        private final af c;

        final af a()
        {
            return c;
        }

        b(af af1, af af2)
        {
            super(af1);
            c = af2;
        }

        b(Object obj, Object obj1, af af1)
        {
            super(obj, obj1);
            c = af1;
        }
    }


    private final transient af a[];
    private final transient af b[];
    private final transient int c;

    public az(int i, af.a aa[])
    {
        a = new af[i];
        int k = w.b(i);
        b = new af[k];
        c = k - 1;
        k = 0;
        while (k < i) 
        {
            Object obj = aa[k];
            Object obj1 = ((af.a) (obj)).getKey();
            int l = w.a(obj1.hashCode());
            l = c & l;
            af af1 = b[l];
            if (af1 != null)
            {
                obj = new b(((af) (obj)), af1);
            }
            b[l] = ((af) (obj));
            a[k] = ((af) (obj));
            a(obj1, ((af) (obj)), af1);
            k++;
        }
    }

    az(java.util.Map.Entry aentry[])
    {
        int k = aentry.length;
        a = new af[k];
        int i = w.b(k);
        b = new af[i];
        c = i - 1;
        i = 0;
        while (i < k) 
        {
            Object obj = aentry[i];
            Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
            obj = ((java.util.Map.Entry) (obj)).getValue();
            j.a(obj1, obj);
            int l = w.a(obj1.hashCode());
            l = c & l;
            af af1 = b[l];
            if (af1 == null)
            {
                obj = new af.a(obj1, obj);
            } else
            {
                obj = new b(obj1, obj, af1);
            }
            b[l] = ((af) (obj));
            a[i] = ((af) (obj));
            a(obj1, ((af) (obj)), af1);
            i++;
        }
    }

    private static void a(Object obj, af af1, af af2)
    {
        boolean flag;
        for (; af2 != null; af2 = af2.a())
        {
            if (!obj.equals(af2.getKey()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                obj = String.valueOf(String.valueOf("key"));
                af1 = String.valueOf(String.valueOf(af1));
                af2 = String.valueOf(String.valueOf(af2));
                throw new IllegalArgumentException((new StringBuilder(((String) (obj)).length() + 34 + af1.length() + af2.length())).append("Multiple entries with same ").append(((String) (obj))).append(": ").append(af1).append(" and ").append(af2).toString());
            }
        }

    }

    static af[] a(az az1)
    {
        return az1.a;
    }

    final aj c()
    {
        return new a((byte)0);
    }

    final boolean e()
    {
        return false;
    }

    public final Object get(Object obj)
    {
        if (obj != null)
        {
            int i = w.a(obj.hashCode());
            int k = c;
            af af1 = b[i & k];
            while (af1 != null) 
            {
                if (obj.equals(af1.getKey()))
                {
                    return af1.getValue();
                }
                af1 = af1.a();
            }
        }
        return null;
    }

    public final int size()
    {
        return a.length;
    }
}
