// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package jumiomobile:
//            y, z, aa

public class x
{

    final StringBuilder a;
    private final List b;
    private final String c;

    public x()
    {
        a = new StringBuilder();
        b = new ArrayList();
        c = null;
    }

    x(int j)
    {
        a = new StringBuilder();
        b = new ArrayList();
        char ac[] = new char[j];
        Arrays.fill(ac, ' ');
        c = new String(ac);
    }

    private void a(char c1)
    {
        switch (c1)
        {
        default:
            if (c1 <= '\037')
            {
                a.append(String.format("\\u%04x", new Object[] {
                    Integer.valueOf(c1)
                }));
                return;
            } else
            {
                a.append(c1);
                return;
            }

        case 34: // '"'
        case 47: // '/'
        case 92: // '\\'
            a.append('\\').append(c1);
            return;

        case 9: // '\t'
            a.append("\\t");
            return;

        case 8: // '\b'
            a.append("\\b");
            return;

        case 10: // '\n'
            a.append("\\n");
            return;

        case 13: // '\r'
            a.append("\\r");
            return;

        case 12: // '\f'
            a.append("\\f");
            return;
        }
    }

    private void a(y y1)
    {
        b.set(b.size() - 1, y1);
    }

    private void a(char ac[])
    {
        a.append("\"");
        int j = 0;
        for (int k = ac.length; j < k; j++)
        {
            a(ac[j]);
        }

        a.append("\"");
    }

    private void b(String s)
    {
        a.append("\"");
        int j = 0;
        for (int k = s.length(); j < k; j++)
        {
            a(s.charAt(j));
        }

        a.append("\"");
    }

    private y f()
    {
        if (b.isEmpty())
        {
            throw new JSONException("Nesting problem");
        } else
        {
            return (y)b.get(b.size() - 1);
        }
    }

    private void g()
    {
        if (c != null)
        {
            a.append("\n");
            int j = 0;
            while (j < b.size()) 
            {
                a.append(c);
                j++;
            }
        }
    }

    private void h()
    {
        y y1 = f();
        if (y1 == y.e)
        {
            a.append(',');
        } else
        if (y1 != y.c)
        {
            throw new JSONException("Nesting problem");
        }
        g();
        a(y.d);
    }

    private void i()
    {
        if (!b.isEmpty())
        {
            Object obj = f();
            if (obj == y.a)
            {
                a(y.b);
                g();
                return;
            }
            if (obj == y.b)
            {
                a.append(',');
                g();
                return;
            }
            if (obj == y.d)
            {
                StringBuilder stringbuilder = a;
                if (c == null)
                {
                    obj = ":";
                } else
                {
                    obj = ": ";
                }
                stringbuilder.append(((String) (obj)));
                a(y.e);
                return;
            }
            if (obj != y.f)
            {
                throw new JSONException("Nesting problem");
            }
        }
    }

    public x a()
    {
        return a(y.a, "[");
    }

    public x a(Object obj)
    {
        if (b.isEmpty())
        {
            throw new JSONException("Nesting problem");
        }
        if (obj instanceof z)
        {
            ((z)obj).a(this);
            return this;
        }
        if (obj instanceof aa)
        {
            ((aa)obj).a(this);
            return this;
        }
        i();
        if (obj == null || (obj instanceof Boolean) || obj == aa.NULL)
        {
            a.append(obj);
            return this;
        }
        if (obj instanceof Number)
        {
            a.append(aa.numberToString((Number)obj));
            return this;
        }
        if (obj instanceof char[])
        {
            a((char[])obj);
            return this;
        } else
        {
            b(obj.toString());
            return this;
        }
    }

    public x a(String s)
    {
        if (s == null)
        {
            throw new JSONException("Names must be non-null");
        } else
        {
            h();
            b(s);
            return this;
        }
    }

    x a(y y1, String s)
    {
        if (b.isEmpty() && a.length() > 0)
        {
            throw new JSONException("Nesting problem: multiple top-level roots");
        } else
        {
            i();
            b.add(y1);
            a.append(s);
            return this;
        }
    }

    x a(y y1, y y2, String s)
    {
        y y3 = f();
        if (y3 != y2 && y3 != y1)
        {
            throw new JSONException("Nesting problem");
        }
        b.remove(b.size() - 1);
        if (y3 == y2)
        {
            g();
        }
        a.append(s);
        return this;
    }

    public x b()
    {
        return a(y.a, y.b, "]");
    }

    public x c()
    {
        return a(y.c, "{");
    }

    public x d()
    {
        return a(y.c, y.e, "}");
    }

    public void e()
    {
        if (a != null && a.length() != 0)
        {
            for (int j = 0; j < a.length(); j++)
            {
                a.setCharAt(j, '\0');
            }

            a.delete(0, a.length());
        }
    }

    public String toString()
    {
        if (a.length() == 0)
        {
            return super.toString();
        } else
        {
            return a.toString();
        }
    }
}
