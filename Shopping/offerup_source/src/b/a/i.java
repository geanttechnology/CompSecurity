// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package b.a:
//            k, j, a

final class i
{

    private static final Pattern a = Pattern.compile("(\\d{1,4})-(\\d\\d)-(\\d\\d)|(\\d{1,4})-(\\d\\d)|(\\d{1,4})");
    private static final Integer b = Integer.valueOf("9");
    private static final Pattern c = Pattern.compile("(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)\\.(\\d{1,9})|(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)|(\\d\\d)\\:(\\d\\d)|(\\d\\d)");
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Integer h;
    private Integer i;
    private Integer j;

    i()
    {
    }

    private static transient String a(Matcher matcher, int ai[])
    {
        int i1 = ai.length;
        String s = null;
        int l = 0;
        String s1;
        do
        {
            s1 = s;
            if (l >= i1)
            {
                break;
            }
            s = matcher.group(ai[l]);
            s1 = s;
            if (s != null)
            {
                break;
            }
            l++;
        } while (true);
        return s1;
    }

    private void b(String s)
    {
        Matcher matcher = a.matcher(s);
        if (matcher.matches())
        {
            s = a(matcher, new int[] {
                1, 4, 6
            });
            if (s != null)
            {
                d = Integer.valueOf(s);
            }
            s = a(matcher, new int[] {
                2, 5
            });
            if (s != null)
            {
                e = Integer.valueOf(s);
            }
            s = a(matcher, new int[] {
                3
            });
            if (s != null)
            {
                f = Integer.valueOf(s);
            }
            return;
        } else
        {
            throw new k((new StringBuilder("Unexpected format for date:")).append(s).toString());
        }
    }

    private void c(String s)
    {
        Matcher matcher = c.matcher(s);
        if (matcher.matches())
        {
            s = a(matcher, new int[] {
                1, 5, 8, 10
            });
            if (s != null)
            {
                g = Integer.valueOf(s);
            }
            s = a(matcher, new int[] {
                2, 6, 9
            });
            if (s != null)
            {
                h = Integer.valueOf(s);
            }
            s = a(matcher, new int[] {
                3, 7
            });
            if (s != null)
            {
                i = Integer.valueOf(s);
            }
            s = a(matcher, new int[] {
                4
            });
            if (s != null)
            {
                for (s = new StringBuilder(s); s.length() < b.intValue(); s.append("0")) { }
                j = Integer.valueOf(s.toString());
            }
            return;
        } else
        {
            throw new k((new StringBuilder("Unexpected format for time:")).append(s).toString());
        }
    }

    final a a(String s)
    {
        boolean flag2 = true;
        if (s == null)
        {
            throw new NullPointerException("DateTime string is null");
        }
        s = s.trim();
        j j1 = new j(this, (byte)0);
        int l = s.indexOf(" ");
        if (l == -1)
        {
            l = s.indexOf("T");
        }
        boolean flag1;
        if (l > 0 && l < s.length())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            j1.a = s.substring(0, l);
            j1.b = s.substring(l + 1);
        } else
        {
            boolean flag;
            boolean flag3;
            if (s.length() >= 2)
            {
                flag3 = ":".equals(s.substring(2, 3));
            } else
            {
                flag3 = false;
            }
            if (flag3)
            {
                j1.b = s;
            } else
            {
                j1.a = s;
            }
        }
        if (j1.a != null && j1.b != null)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (!l) goto _L2; else goto _L1
_L1:
        b(j1.a);
        c(j1.b);
_L4:
        return new a(d, e, f, g, h, i, j);
_L2:
        if (j1.b == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b(j1.a);
        } else
        {
            if (j1.a == null)
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                c(j1.b);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
