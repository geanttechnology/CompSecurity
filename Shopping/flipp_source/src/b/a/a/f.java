// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.b.t;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package b.a.a:
//            h, i, g, z, 
//            aa, c, l, a

public final class f
{

    private static final h a;
    private static volatile g b;
    private static volatile Map c;

    public static final long a()
    {
        return b.a();
    }

    public static final long a(z z1)
    {
        if (z1 == null)
        {
            return a();
        } else
        {
            return z1.a();
        }
    }

    public static final a a(a a1)
    {
        Object obj = a1;
        if (a1 == null)
        {
            obj = t.M();
        }
        return ((a) (obj));
    }

    public static final DateFormatSymbols a(Locale locale)
    {
        DateFormatSymbols dateformatsymbols;
        try
        {
            dateformatsymbols = (DateFormatSymbols)java/text/DateFormatSymbols.getMethod("getInstance", new Class[] {
                java/util/Locale
            }).invoke(null, new Object[] {
                locale
            });
        }
        catch (Exception exception)
        {
            return new DateFormatSymbols(locale);
        }
        return dateformatsymbols;
    }

    private static void a(Map map, String s, String s1)
    {
        try
        {
            map.put(s, i.a(s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return;
        }
    }

    public static final boolean a(aa aa1)
    {
        if (aa1 == null)
        {
            throw new IllegalArgumentException("Partial must not be null");
        }
        m m = null;
        for (int j = 0; j < 3; j++)
        {
            c c1 = aa1.c(j);
            if (j > 0 && c1.e().a() != m)
            {
                return false;
            }
            m = c1.d().a();
        }

        return true;
    }

    public static final a b(z z1)
    {
        if (z1 == null)
        {
            z1 = t.M();
        } else
        {
            a a1 = z1.b();
            z1 = a1;
            if (a1 == null)
            {
                return t.M();
            }
        }
        return z1;
    }

    public static final Map b()
    {
        return c;
    }

    static 
    {
        Object obj = new h();
        a = ((h) (obj));
        b = ((g) (obj));
        obj = new LinkedHashMap();
        ((Map) (obj)).put("UT", i.a);
        ((Map) (obj)).put("UTC", i.a);
        ((Map) (obj)).put("GMT", i.a);
        a(((Map) (obj)), "EST", "America/New_York");
        a(((Map) (obj)), "EDT", "America/New_York");
        a(((Map) (obj)), "CST", "America/Chicago");
        a(((Map) (obj)), "CDT", "America/Chicago");
        a(((Map) (obj)), "MST", "America/Denver");
        a(((Map) (obj)), "MDT", "America/Denver");
        a(((Map) (obj)), "PST", "America/Los_Angeles");
        a(((Map) (obj)), "PDT", "America/Los_Angeles");
        c = Collections.unmodifiableMap(((Map) (obj)));
    }
}
