// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            gj, kq

public final class gi
{

    private static final char a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List g;
    private final String h;

    private gi(gj gj1)
    {
        b = gj1.a;
        c = e(gj1.b);
        d = e(gj1.c);
        e = gj1.d;
        f = gj1.a();
        a(gj1.f);
        List list;
        if (gj1.g != null)
        {
            list = a(gj1.g);
        } else
        {
            list = null;
        }
        g = list;
        if (gj1.h != null)
        {
            e(gj1.h);
        }
        h = gj1.toString();
    }

    gi(gj gj1, byte byte0)
    {
        this(gj1);
    }

    static int a(char c1)
    {
        if (c1 >= '0' && c1 <= '9')
        {
            return c1 - 48;
        }
        if (c1 >= 'a' && c1 <= 'f')
        {
            return (c1 - 97) + 10;
        }
        if (c1 >= 'A' && c1 <= 'F')
        {
            return (c1 - 65) + 10;
        } else
        {
            return -1;
        }
    }

    public static int a(String s)
    {
        if (s.equals("http"))
        {
            return 80;
        }
        return !s.equals("https") ? -1 : 443;
    }

    static int a(String s, int i1, int j1, String s1)
    {
        return b(s, i1, j1, s1);
    }

    static String a(gi gi1)
    {
        return gi1.b;
    }

    static String a(String s, int i1, int j1)
    {
        int k1 = i1;
_L11:
        if (k1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s.charAt(k1) != '%') goto _L2; else goto _L1
_L1:
        kq kq1;
        kq1 = new kq();
        kq1.a(s, i1, k1);
        i1 = k1;
_L9:
        if (i1 >= j1) goto _L4; else goto _L3
_L3:
        k1 = s.codePointAt(i1);
        if (k1 != 37 || i1 + 2 >= j1) goto _L6; else goto _L5
_L5:
        int l1;
        int i2;
        l1 = a(s.charAt(i1 + 1));
        i2 = a(s.charAt(i1 + 2));
        if (l1 == -1 || i2 == -1) goto _L6; else goto _L7
_L7:
        kq1.b((l1 << 4) + i2);
        i1 += 2;
_L8:
        i1 += Character.charCount(k1);
        continue; /* Loop/switch isn't completed */
_L6:
        kq1.a(k1);
        if (true) goto _L8; else goto _L4
_L4:
        return kq1.k();
        if (true) goto _L9; else goto _L2
_L2:
        k1++;
        if (true) goto _L11; else goto _L10
_L10:
        return s.substring(i1, j1);
    }

    static String a(String s, int i1, int j1, String s1, boolean flag, boolean flag1)
    {
        int k1 = i1;
_L7:
        Object obj;
        kq kq3;
        int l1;
        if (k1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = s.codePointAt(k1);
        if (l1 >= 32 && l1 < 127 && s1.indexOf(l1) == -1 && (l1 != 37 || flag) && (!flag1 || l1 != 43))
        {
            break MISSING_BLOCK_LABEL_355;
        }
        kq3 = new kq();
        kq3.a(s, i1, k1);
        i1 = k1;
        obj = null;
_L2:
        kq kq2;
label0:
        {
            if (i1 >= j1)
            {
                break MISSING_BLOCK_LABEL_349;
            }
            k1 = s.codePointAt(i1);
            if (flag)
            {
                kq2 = obj;
                if (k1 == 9)
                {
                    break label0;
                }
                kq2 = obj;
                if (k1 == 10)
                {
                    break label0;
                }
                kq2 = obj;
                if (k1 == 12)
                {
                    break label0;
                }
                kq2 = obj;
                if (k1 == 13)
                {
                    break label0;
                }
            }
            if (!flag1 || k1 != 43)
            {
                break; /* Loop/switch isn't completed */
            }
            String s2;
            if (flag)
            {
                s2 = "%20";
            } else
            {
                s2 = "%2B";
            }
            kq3.a(s2);
            kq2 = obj;
        }
_L4:
        i1 = Character.charCount(k1) + i1;
        obj = kq2;
        if (true) goto _L2; else goto _L1
_L1:
        kq kq1;
        if (k1 >= 32 && k1 < 127 && s1.indexOf(k1) == -1 && (k1 != 37 || flag))
        {
            break MISSING_BLOCK_LABEL_334;
        }
        kq1 = obj;
        if (obj == null)
        {
            kq1 = new kq();
        }
        kq1.a(k1);
_L5:
        kq2 = kq1;
        if (kq1.c()) goto _L4; else goto _L3
_L3:
        l1 = kq1.d() & 0xff;
        kq3.b(37);
        kq3.b(a[l1 >> 4 & 0xf]);
        kq3.b(a[l1 & 0xf]);
          goto _L5
        kq3.a(k1);
        kq2 = obj;
          goto _L4
        return kq3.k();
        k1 += Character.charCount(l1);
        if (true) goto _L7; else goto _L6
_L6:
        return s.substring(i1, j1);
    }

    static String a(String s, String s1)
    {
        return a(s, 0, s.length(), s1, true, true);
    }

    private static List a(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (String)iterator.next();
            if (list != null)
            {
                list = e(list);
            } else
            {
                list = null;
            }
            arraylist.add(list);
        }
        return Collections.unmodifiableList(arraylist);
    }

    static void a(StringBuilder stringbuilder, List list)
    {
        int j1 = list.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            stringbuilder.append('/');
            stringbuilder.append((String)list.get(i1));
        }

    }

    private static int b(String s, int i1, int j1, String s1)
    {
        do
        {
label0:
            {
                int k1 = j1;
                if (i1 < j1)
                {
                    if (s1.indexOf(s.charAt(i1)) == -1)
                    {
                        break label0;
                    }
                    k1 = i1;
                }
                return k1;
            }
            i1++;
        } while (true);
    }

    static String b(gi gi1)
    {
        return gi1.e;
    }

    static List b(String s)
    {
        ArrayList arraylist = new ArrayList();
        int i1 = 0;
        while (i1 <= s.length()) 
        {
            int k1 = s.indexOf('&', i1);
            int j1 = k1;
            if (k1 == -1)
            {
                j1 = s.length();
            }
            k1 = s.indexOf('=', i1);
            if (k1 == -1 || k1 > j1)
            {
                arraylist.add(s.substring(i1, j1));
                arraylist.add(null);
            } else
            {
                arraylist.add(s.substring(i1, k1));
                arraylist.add(s.substring(k1 + 1, j1));
            }
            i1 = j1 + 1;
        }
        return arraylist;
    }

    static void b(StringBuilder stringbuilder, List list)
    {
        int j1 = list.size();
        for (int i1 = 0; i1 < j1; i1 += 2)
        {
            String s = (String)list.get(i1);
            String s1 = (String)list.get(i1 + 1);
            if (i1 > 0)
            {
                stringbuilder.append('&');
            }
            stringbuilder.append(s);
            if (s1 != null)
            {
                stringbuilder.append('=');
                stringbuilder.append(s1);
            }
        }

    }

    static int c(gi gi1)
    {
        return gi1.f;
    }

    public static gi d(String s)
    {
        return (new gj()).a(null, s);
    }

    private static String e(String s)
    {
        return a(s, 0, s.length());
    }

    public final URL a()
    {
        URL url;
        try
        {
            url = new URL(h);
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public final URI b()
    {
        URI uri;
        try
        {
            uri = new URI(h);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IllegalStateException((new StringBuilder("not valid as a java.net.URI: ")).append(h).toString());
        }
        return uri;
    }

    public final gi c(String s)
    {
        return (new gj()).a(this, s);
    }

    public final String c()
    {
        return b;
    }

    public final boolean d()
    {
        return b.equals("https");
    }

    public final String e()
    {
        if (c.isEmpty())
        {
            return "";
        } else
        {
            int i1 = b.length() + 3;
            int j1 = b(h, i1, h.length(), ":@");
            return h.substring(i1, j1);
        }
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof gi) && ((gi)obj).h.equals(h);
    }

    public final String f()
    {
        if (d.isEmpty())
        {
            return "";
        } else
        {
            int i1 = h.indexOf(':', b.length() + 3);
            int j1 = h.indexOf('@');
            return h.substring(i1 + 1, j1);
        }
    }

    public final String g()
    {
        return e;
    }

    public final int h()
    {
        return f;
    }

    public final int hashCode()
    {
        return h.hashCode();
    }

    public final String i()
    {
        int i1 = h.indexOf('/', b.length() + 3);
        int j1 = b(h, i1, h.length(), "?#");
        return h.substring(i1, j1);
    }

    public final List j()
    {
        int i1 = h.indexOf('/', b.length() + 3);
        int j1 = b(h, i1, h.length(), "?#");
        ArrayList arraylist = new ArrayList();
        while (i1 < j1) 
        {
            int k1 = i1 + 1;
            i1 = b(h, k1, j1, "/");
            arraylist.add(h.substring(k1, i1));
        }
        return arraylist;
    }

    public final String k()
    {
        if (g == null)
        {
            return null;
        } else
        {
            int i1 = h.indexOf('?') + 1;
            int j1 = b(h, i1 + 1, h.length(), "#");
            return h.substring(i1, j1);
        }
    }

    public final String l()
    {
        if (g == null)
        {
            return null;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            b(stringbuilder, g);
            return stringbuilder.toString();
        }
    }

    public final String toString()
    {
        return h;
    }

}
