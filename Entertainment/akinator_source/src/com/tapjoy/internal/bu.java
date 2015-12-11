// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.client.utils.URIUtils;

// Referenced classes of package com.tapjoy.internal:
//            br, bw, cc, bz, 
//            cp, bp, bv, ct, 
//            dd

public abstract class bu
    implements br, bw
{
    public static abstract class a
    {

        private static a a;

        public static a a()
        {
            a a2 = a;
            a a1 = a2;
            if (a2 == null)
            {
                a1 = bv.a;
                a = a1;
            }
            return a1;
        }

        public final bu a(InputStream inputstream)
        {
            return a(((Reader) (new InputStreamReader(inputstream, ct.c))));
        }

        public bu a(Reader reader)
        {
            return a(dd.a(reader));
        }

        public bu a(String s)
        {
            return a(((InputStream) (new ByteArrayInputStream(s.getBytes(ct.c.name())))));
        }

        public a()
        {
        }
    }


    private HashMap a;

    public bu()
    {
    }

    public static bu a(InputStream inputstream)
    {
        return a.a().a(inputstream);
    }

    private void a(List list)
    {
        g();
        for (; k(); list.add(v())) { }
        h();
    }

    public static bu b(String s)
    {
        return a.a().a(s);
    }

    private static URI d(String s)
    {
        try
        {
            s = new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new cc(s);
        }
        return s;
    }

    private boolean u()
    {
        if (l() == bz.i)
        {
            p();
            return true;
        } else
        {
            return false;
        }
    }

    private Object v()
    {
        bz bz1 = l();
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[bz.values().length];
                try
                {
                    a[bz.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[bz.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[bz.i.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[bz.h.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[bz.g.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[bz.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[bz1.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder("Expected a value but was ")).append(bz1).toString());

        case 1: // '\001'
            return d();

        case 2: // '\002'
            return e();

        case 3: // '\003'
            p();
            return null;

        case 4: // '\004'
            return Boolean.valueOf(o());

        case 5: // '\005'
            return new cp(n());

        case 6: // '\006'
            return n();
        }
    }

    public final Object a(bp bp1)
    {
        return bp1.a(this);
    }

    public final Object a(String s)
    {
        if (a != null)
        {
            return a.get(s);
        } else
        {
            return null;
        }
    }

    public final void a(String s, Object obj)
    {
        if (a == null)
        {
            a = new HashMap();
        }
        a.put(s, obj);
    }

    public final void a(List list, bp bp1)
    {
        g();
        for (; k(); list.add(bp1.a(this))) { }
        h();
    }

    public final void a(Map map)
    {
        i();
        for (; k(); map.put(m(), v())) { }
        j();
    }

    public final boolean a()
    {
        return l() == bz.c;
    }

    public final Object b(bp bp1)
    {
        if (u())
        {
            return null;
        } else
        {
            return bp1.a(this);
        }
    }

    public final boolean b()
    {
        return l() == bz.f;
    }

    public final String c()
    {
        if (u())
        {
            return null;
        } else
        {
            return n();
        }
    }

    public final String c(String s)
    {
        if (u())
        {
            return s;
        } else
        {
            return n();
        }
    }

    public final List d()
    {
        LinkedList linkedlist = new LinkedList();
        a(linkedlist);
        return linkedlist;
    }

    public final Map e()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        a(linkedhashmap);
        return linkedhashmap;
    }

    public final URL f()
    {
        URI uri = (URI)a("BASE_URI");
        if (uri != null)
        {
            return URIUtils.resolve(uri, d(n())).toURL();
        } else
        {
            return new URL(n());
        }
    }
}
