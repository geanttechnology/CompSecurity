// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package netswipe:
//            dg, dd, de

public class df
{

    final StringBuilder a;
    private final List b;
    private final String c;

    public df()
    {
        a = new StringBuilder();
        b = new ArrayList();
        c = null;
    }

    df(int j)
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

    private void a(dg dg1)
    {
        b.set(b.size() - 1, dg1);
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

    private dg f()
        throws JSONException
    {
        if (b.isEmpty())
        {
            throw new JSONException("Nesting problem");
        } else
        {
            return (dg)b.get(b.size() - 1);
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
        throws JSONException
    {
        dg dg1 = f();
        if (dg1 == dg.e)
        {
            a.append(',');
        } else
        if (dg1 != dg.c)
        {
            throw new JSONException("Nesting problem");
        }
        g();
        a(dg.d);
    }

    private void i()
        throws JSONException
    {
        if (!b.isEmpty())
        {
            Object obj = f();
            if (obj == dg.a)
            {
                a(dg.b);
                g();
                return;
            }
            if (obj == dg.b)
            {
                a.append(',');
                g();
                return;
            }
            if (obj == dg.d)
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
                a(dg.e);
                return;
            }
            if (obj != dg.f)
            {
                throw new JSONException("Nesting problem");
            }
        }
    }

    public df a()
        throws JSONException
    {
        return a(dg.a, "[");
    }

    public df a(Object obj)
        throws JSONException
    {
        if (b.isEmpty())
        {
            throw new JSONException("Nesting problem");
        }
        if (obj instanceof dd)
        {
            ((dd)obj).a(this);
            return this;
        }
        if (obj instanceof de)
        {
            ((de)obj).a(this);
            return this;
        }
        i();
        if (obj == null || (obj instanceof Boolean) || obj == de.NULL)
        {
            a.append(obj);
            return this;
        }
        if (obj instanceof Number)
        {
            a.append(de.numberToString((Number)obj));
            return this;
        }
        if (obj instanceof char[])
        {
            a((char[])(char[])obj);
            return this;
        } else
        {
            b(obj.toString());
            return this;
        }
    }

    public df a(String s)
        throws JSONException
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

    df a(dg dg1, String s)
        throws JSONException
    {
        if (b.isEmpty() && a.length() > 0)
        {
            throw new JSONException("Nesting problem: multiple top-level roots");
        } else
        {
            i();
            b.add(dg1);
            a.append(s);
            return this;
        }
    }

    df a(dg dg1, dg dg2, String s)
        throws JSONException
    {
        dg dg3 = f();
        if (dg3 != dg2 && dg3 != dg1)
        {
            throw new JSONException("Nesting problem");
        }
        b.remove(b.size() - 1);
        if (dg3 == dg2)
        {
            g();
        }
        a.append(s);
        return this;
    }

    public df b()
        throws JSONException
    {
        return a(dg.a, dg.b, "]");
    }

    public df c()
        throws JSONException
    {
        return a(dg.c, "{");
    }

    public df d()
        throws JSONException
    {
        return a(dg.c, dg.e, "}");
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
            return null;
        } else
        {
            return a.toString();
        }
    }
}
