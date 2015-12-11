// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package b.a:
//            h, g, f, a

final class e
{

    private static final Pattern i = Pattern.compile("\\|[^\\|]*\\|");
    private static final Pattern j = Pattern.compile("f{1,9}");
    private static final List k;
    private final String a;
    private final Locale b;
    private Collection c;
    private Collection d;
    private final Map e;
    private final Map f;
    private final Map g;
    private final f h;

    e(String s)
    {
        e = new LinkedHashMap();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        a = s;
        b = null;
        h = null;
        c();
    }

    e(String s, Locale locale)
    {
        e = new LinkedHashMap();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        a = s;
        b = locale;
        h = null;
        c();
    }

    private h a(int l)
    {
        h h1 = null;
        Iterator iterator = c.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            h h2 = (h)iterator.next();
            if (h2.a == l)
            {
                h1 = h2;
            }
        } while (true);
        return h1;
    }

    private String a(Integer integer)
    {
        for (integer = a(integer); integer.length() < 9; integer = (new StringBuilder("0")).append(integer).toString()) { }
        return integer;
    }

    private static String a(Object obj)
    {
        String s = "";
        if (obj != null)
        {
            s = String.valueOf(obj);
        }
        return s;
    }

    private static String a(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int l = 1; l <= s.length(); l++)
        {
            stringbuilder.append("@");
        }

        return stringbuilder.toString();
    }

    private void a()
    {
        g g1;
        for (Matcher matcher = i.matcher(a); matcher.find(); d.add(g1))
        {
            g1 = new g((byte)0);
            g1.a = matcher.start();
            g1.b = matcher.end() - 1;
        }

    }

    private String b()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int l = 0;
        while (l < a.length()) 
        {
            String s = a.substring(l, l + 1);
            h h1 = a(l);
            int i1;
            if (h1 != null)
            {
                stringbuilder.append(h1.c);
                i1 = h1.b;
            } else
            {
                i1 = l;
                if (!"|".equals(s))
                {
                    stringbuilder.append(s);
                    i1 = l;
                }
            }
            l = i1 + 1;
        }
        return stringbuilder.toString();
    }

    private String b(Integer integer)
    {
label0:
        {
            Object obj = "";
            if (integer != null)
            {
                if (b == null)
                {
                    break label0;
                }
                if (!e.containsKey(b))
                {
                    obj = new ArrayList();
                    SimpleDateFormat simpledateformat = new SimpleDateFormat("MMMM", b);
                    for (int l = 0; l <= 11; l++)
                    {
                        GregorianCalendar gregoriancalendar = new GregorianCalendar();
                        gregoriancalendar.set(1, 2000);
                        gregoriancalendar.set(2, l);
                        gregoriancalendar.set(5, 15);
                        ((List) (obj)).add(simpledateformat.format(gregoriancalendar.getTime()));
                    }

                    e.put(b, obj);
                }
                obj = (String)((List)e.get(b)).get(integer.intValue() - 1);
            }
            return ((String) (obj));
        }
        throw new IllegalArgumentException((new StringBuilder("Your date pattern requires either a Locale, or your own custom localizations for text:")).append(b.a.f.a(a)).toString());
    }

    private static String b(String s)
    {
        String s1 = s;
        if (b.a.f.a(s))
        {
            s1 = s;
            if (s.length() == 1)
            {
                s1 = (new StringBuilder("0")).append(s).toString();
            }
        }
        return s1;
    }

    private void b(a a1)
    {
        String s;
        Iterator iterator1;
        s = a;
        iterator1 = k.iterator();
_L5:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        String s3;
        Matcher matcher;
        s3 = (String)iterator1.next();
        matcher = Pattern.compile(s3).matcher(s);
_L4:
        h h1;
        int l;
        if (!matcher.find())
        {
            continue; /* Loop/switch isn't completed */
        }
        h1 = new h((byte)0);
        h1.a = matcher.start();
        h1.b = matcher.end() - 1;
        Iterator iterator = d.iterator();
        g g1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_959;
            }
            g1 = (g)iterator.next();
        } while (g1.a > h1.a || h1.a > g1.b);
        l = 1;
_L6:
        if (l == 0)
        {
            Object obj = matcher.group();
            if ("YYYY".equals(obj))
            {
                obj = a(a1.b());
            } else
            if ("YY".equals(obj))
            {
                String s1 = a(a1.b());
                obj = "";
                if (b.a.f.a(s1))
                {
                    obj = s1.substring(2);
                }
            } else
            if ("MMMM".equals(obj))
            {
                obj = b(Integer.valueOf(a1.c().intValue()));
            } else
            if ("MMM".equals(obj))
            {
                obj = c(b(Integer.valueOf(a1.c().intValue())));
            } else
            if ("MM".equals(obj))
            {
                obj = b(a(a1.c()));
            } else
            if ("M".equals(obj))
            {
                obj = a(a1.c());
            } else
            if ("DD".equals(obj))
            {
                obj = b(a(a1.d()));
            } else
            if ("D".equals(obj))
            {
                obj = a(a1.d());
            } else
            if ("WWWW".equals(obj))
            {
                obj = c(Integer.valueOf(a1.i().intValue()));
            } else
            if ("WWW".equals(obj))
            {
                obj = c(c(Integer.valueOf(a1.i().intValue())));
            } else
            if ("hh".equals(obj))
            {
                obj = b(a(a1.e()));
            } else
            if ("h".equals(obj))
            {
                obj = a(a1.e());
            } else
            if ("h12".equals(obj))
            {
                obj = a(d(a1.e()));
            } else
            if ("hh12".equals(obj))
            {
                obj = b(a(d(a1.e())));
            } else
            if ("a".equals(obj))
            {
                Integer integer = Integer.valueOf(a1.e().intValue());
                obj = "";
                if (integer != null)
                {
                    if (b != null)
                    {
                        if (!g.containsKey(b))
                        {
                            obj = new ArrayList();
                            ((List) (obj)).add(e(Integer.valueOf(6)));
                            ((List) (obj)).add(e(Integer.valueOf(18)));
                            g.put(b, obj);
                        }
                        if (integer.intValue() < 12)
                        {
                            obj = (String)((List)g.get(b)).get(0);
                        } else
                        {
                            obj = (String)((List)g.get(b)).get(1);
                        }
                    } else
                    {
                        throw new IllegalArgumentException((new StringBuilder("Your date pattern requires either a Locale, or your own custom localizations for text:")).append(b.a.f.a(a)).toString());
                    }
                }
            } else
            if ("mm".equals(obj))
            {
                obj = b(a(a1.f()));
            } else
            if ("m".equals(obj))
            {
                obj = a(a1.f());
            } else
            if ("ss".equals(obj))
            {
                obj = b(a(a1.g()));
            } else
            if ("s".equals(obj))
            {
                obj = a(a1.g());
            } else
            if (((String) (obj)).startsWith("f"))
            {
                if (j.matcher(((CharSequence) (obj))).matches())
                {
                    String s2 = a(a1.h());
                    l = ((String) (obj)).length();
                    obj = s2;
                    if (b.a.f.a(s2))
                    {
                        obj = s2;
                        if (s2.length() >= l)
                        {
                            obj = s2.substring(0, l);
                        }
                    }
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder("Unknown token in date formatting pattern: ")).append(((String) (obj))).toString());
                }
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Unknown token in date formatting pattern: ")).append(((String) (obj))).toString());
            }
            h1.c = ((String) (obj));
            c.add(h1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = s.replace(s3, a(s3));
          goto _L5
_L2:
        return;
        l = 0;
          goto _L6
    }

    private String c(Integer integer)
    {
label0:
        {
            Object obj = "";
            if (integer != null)
            {
                if (b == null)
                {
                    break label0;
                }
                if (!f.containsKey(b))
                {
                    obj = new ArrayList();
                    SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE", b);
                    for (int l = 8; l <= 14; l++)
                    {
                        GregorianCalendar gregoriancalendar = new GregorianCalendar();
                        gregoriancalendar.set(1, 2009);
                        gregoriancalendar.set(2, 1);
                        gregoriancalendar.set(5, l);
                        ((List) (obj)).add(simpledateformat.format(gregoriancalendar.getTime()));
                    }

                    f.put(b, obj);
                }
                obj = (String)((List)f.get(b)).get(integer.intValue() - 1);
            }
            return ((String) (obj));
        }
        throw new IllegalArgumentException((new StringBuilder("Your date pattern requires either a Locale, or your own custom localizations for text:")).append(b.a.f.a(a)).toString());
    }

    private static String c(String s)
    {
        String s1 = s;
        if (b.a.f.a(s))
        {
            s1 = s;
            if (s.length() >= 3)
            {
                s1 = s.substring(0, 3);
            }
        }
        return s1;
    }

    private void c()
    {
        if (!b.a.f.a(a))
        {
            throw new IllegalArgumentException("DateTime format has no content.");
        } else
        {
            return;
        }
    }

    private static Integer d(Integer integer)
    {
        Integer integer1 = integer;
        if (integer != null)
        {
            if (integer.intValue() == 0)
            {
                integer1 = Integer.valueOf(12);
            } else
            {
                integer1 = integer;
                if (integer.intValue() > 12)
                {
                    return Integer.valueOf(integer.intValue() - 12);
                }
            }
        }
        return integer1;
    }

    private String e(Integer integer)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("a", b);
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.set(1, 2000);
        gregoriancalendar.set(2, 6);
        gregoriancalendar.set(5, 15);
        gregoriancalendar.set(11, integer.intValue());
        return simpledateformat.format(gregoriancalendar.getTime());
    }

    final String a(a a1)
    {
        d = new ArrayList();
        c = new ArrayList();
        a();
        b(a1);
        return b();
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        k = arraylist;
        arraylist.add("YYYY");
        k.add("YY");
        k.add("MMMM");
        k.add("MMM");
        k.add("MM");
        k.add("M");
        k.add("DD");
        k.add("D");
        k.add("WWWW");
        k.add("WWW");
        k.add("hh12");
        k.add("h12");
        k.add("hh");
        k.add("h");
        k.add("mm");
        k.add("m");
        k.add("ss");
        k.add("s");
        k.add("a");
        k.add("fffffffff");
        k.add("ffffffff");
        k.add("fffffff");
        k.add("ffffff");
        k.add("fffff");
        k.add("ffff");
        k.add("fff");
        k.add("ff");
        k.add("f");
    }
}
