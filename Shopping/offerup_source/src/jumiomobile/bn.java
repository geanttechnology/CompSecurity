// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package jumiomobile:
//            bm, bj, bl

public class bn
    implements Serializable
{

    private static final Pattern a = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?");
    private static final Pattern b = Pattern.compile("^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*");
    private static final Pattern c = Pattern.compile("^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?");
    private static final Pattern d = Pattern.compile("^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$");
    private static final Pattern e = Pattern.compile("^(.*)$");
    private static final Pattern f = Pattern.compile("^:(\\d{1,5})$");
    private static final String j[] = {
        "http", "https", "ftp"
    };
    private static final bn k = new bn();
    private final long g;
    private final Set h;
    private final bm i;

    public bn()
    {
        this(null);
    }

    public bn(String as[])
    {
        this(as, 0L);
    }

    public bn(String as[], long l)
    {
        this(as, null, l);
    }

    public bn(String as[], bm bm1, long l)
    {
        g = l;
        if (a(1L))
        {
            h = Collections.EMPTY_SET;
        } else
        {
            String as1[] = as;
            if (as == null)
            {
                as1 = j;
            }
            h = new HashSet(as1.length);
            int i1 = 0;
            while (i1 < as1.length) 
            {
                h.add(as1[i1].toLowerCase(Locale.ENGLISH));
                i1++;
            }
        }
        i = bm1;
    }

    private boolean a(long l)
    {
        return (g & l) > 0L;
    }

    private boolean b(long l)
    {
        return (g & l) == 0L;
    }

    protected int a(String s, String s1)
    {
        int i1 = 0;
        int l = 0;
        do
        {
            if (l == -1)
            {
                break;
            }
            int j1 = s1.indexOf(s, l);
            l = j1;
            if (j1 >= 0)
            {
                l = j1 + 1;
                i1++;
            }
        } while (true);
        return i1;
    }

    public boolean a(String s)
    {
        String s1;
        if (s != null)
        {
            if ((s = a.matcher(s)).matches() && b(s1 = s.group(2)))
            {
                String s2 = s.group(4);
                if (("file".equals(s1) && "".equals(s2) || c(s2)) && d(s.group(5)) && e(s.group(7)) && f(s.group(9)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean b(String s)
    {
        while (s == null || !b.matcher(s).matches() || b(1L) && !h.contains(s.toLowerCase(Locale.ENGLISH))) 
        {
            return false;
        }
        return true;
    }

    protected boolean c(String s)
    {
        if (s != null)
        {
            if (i != null && i.a(s))
            {
                return true;
            }
            s = bj.g(s);
            s = c.matcher(s);
            if (s.matches())
            {
                String s1 = s.group(1);
                if (bj.a(a(8L)).a(s1) || bl.a().a(s1))
                {
                    String s2 = s.group(2);
                    if (s2 == null || f.matcher(s2).matches())
                    {
                        s = s.group(3);
                        if (s == null || s.trim().length() <= 0)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    protected boolean d(String s)
    {
        if (s != null && d.matcher(s).matches())
        {
            int l = a("//", s);
            if (!b(2L) || l <= 0)
            {
                int i1 = a("/", s);
                int j1 = a("..", s);
                if (j1 <= 0 || i1 - l - 1 > j1)
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean e(String s)
    {
        if (s == null)
        {
            return true;
        } else
        {
            return e.matcher(s).matches();
        }
    }

    protected boolean f(String s)
    {
        if (s == null)
        {
            return true;
        } else
        {
            return b(4L);
        }
    }

}
