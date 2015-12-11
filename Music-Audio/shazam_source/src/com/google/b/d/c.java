// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c
    implements Closeable, Flushable
{

    private static final String d[];
    private static final String e[];
    public boolean a;
    public boolean b;
    public boolean c;
    private final Writer f;
    private int g[];
    private int h;
    private String i;
    private String j;
    private String k;

    public c(Writer writer)
    {
        g = new int[32];
        h = 0;
        a(6);
        j = ":";
        c = true;
        if (writer == null)
        {
            throw new NullPointerException("out == null");
        } else
        {
            f = writer;
            return;
        }
    }

    private int a()
    {
        if (h == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            return g[h - 1];
        }
    }

    private c a(int l, int i1, String s)
    {
        int j1 = a();
        if (j1 != i1 && j1 != l)
        {
            throw new IllegalStateException("Nesting problem.");
        }
        if (k != null)
        {
            throw new IllegalStateException((new StringBuilder("Dangling name: ")).append(k).toString());
        }
        h = h - 1;
        if (j1 == i1)
        {
            h();
        }
        f.write(s);
        return this;
    }

    private c a(int l, String s)
    {
        b(true);
        a(l);
        f.write(s);
        return this;
    }

    private void a(int l)
    {
        if (h == g.length)
        {
            int ai[] = new int[h * 2];
            System.arraycopy(g, 0, ai, 0, h);
            g = ai;
        }
        int ai1[] = g;
        int i1 = h;
        h = i1 + 1;
        ai1[i1] = l;
    }

    private void b(int l)
    {
        g[h - 1] = l;
    }

    private void b(boolean flag)
    {
        switch (a())
        {
        case 3: // '\003'
        case 5: // '\005'
        default:
            throw new IllegalStateException("Nesting problem.");

        case 7: // '\007'
            if (!a)
            {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            // fall through

        case 6: // '\006'
            if (!a && !flag)
            {
                throw new IllegalStateException("JSON must start with an array or an object.");
            } else
            {
                b(7);
                return;
            }

        case 1: // '\001'
            b(2);
            h();
            return;

        case 2: // '\002'
            f.append(',');
            h();
            return;

        case 4: // '\004'
            f.append(j);
            b(5);
            return;
        }
    }

    private void d(String s)
    {
        String s1;
        int l;
        int i1;
        int j1;
        int k1;
        char c1;
        i1 = 0;
        String as[];
        String s2;
        if (b)
        {
            as = e;
        } else
        {
            as = d;
        }
        f.write("\"");
        k1 = s.length();
        l = 0;
        if (l >= k1)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        c1 = s.charAt(l);
        if (c1 >= '\200') goto _L2; else goto _L1
_L1:
        s2 = as[c1];
        s1 = s2;
        if (s2 != null) goto _L4; else goto _L3
_L3:
        j1 = i1;
_L6:
        l++;
        i1 = j1;
        break MISSING_BLOCK_LABEL_32;
_L2:
        if (c1 != '\u2028')
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = "\\u2028";
_L4:
        if (i1 < l)
        {
            f.write(s, i1, l - i1);
        }
        f.write(s1);
        j1 = l + 1;
        if (true) goto _L6; else goto _L5
_L5:
        j1 = i1;
        if (c1 != '\u2029') goto _L6; else goto _L7
_L7:
        s1 = "\\u2029";
          goto _L4
        if (i1 < k1)
        {
            f.write(s, i1, k1 - i1);
        }
        f.write("\"");
        return;
    }

    private void g()
    {
        if (k != null)
        {
            int l = a();
            if (l == 5)
            {
                f.write(44);
            } else
            if (l != 3)
            {
                throw new IllegalStateException("Nesting problem.");
            }
            h();
            b(4);
            d(k);
            k = null;
        }
    }

    private void h()
    {
        if (i != null)
        {
            f.write("\n");
            int l = 1;
            int i1 = h;
            while (l < i1) 
            {
                f.write(i);
                l++;
            }
        }
    }

    public c a(double d1)
    {
        if (Double.isNaN(d1) || Double.isInfinite(d1))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(d1).toString());
        } else
        {
            g();
            b(false);
            f.append(Double.toString(d1));
            return this;
        }
    }

    public c a(long l)
    {
        g();
        b(false);
        f.write(Long.toString(l));
        return this;
    }

    public c a(Number number)
    {
        if (number == null)
        {
            return f();
        }
        g();
        String s = number.toString();
        if (!a && (s.equals("-Infinity") || s.equals("Infinity") || s.equals("NaN")))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(number).toString());
        } else
        {
            b(false);
            f.append(s);
            return this;
        }
    }

    public c a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        if (k != null)
        {
            throw new IllegalStateException();
        }
        if (h == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            k = s;
            return this;
        }
    }

    public c a(boolean flag)
    {
        g();
        b(false);
        Writer writer = f;
        String s;
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        writer.write(s);
        return this;
    }

    public c b()
    {
        g();
        return a(1, "[");
    }

    public c b(String s)
    {
        if (s == null)
        {
            return f();
        } else
        {
            g();
            b(false);
            d(s);
            return this;
        }
    }

    public c c()
    {
        return a(1, 2, "]");
    }

    public final void c(String s)
    {
        if (s.length() == 0)
        {
            i = null;
            j = ":";
            return;
        } else
        {
            i = s;
            j = ": ";
            return;
        }
    }

    public void close()
    {
        f.close();
        int l = h;
        if (l > 1 || l == 1 && g[l - 1] != 7)
        {
            throw new IOException("Incomplete document");
        } else
        {
            h = 0;
            return;
        }
    }

    public c d()
    {
        g();
        return a(3, "{");
    }

    public c e()
    {
        return a(3, 5, "}");
    }

    public c f()
    {
label0:
        {
            if (k != null)
            {
                if (!c)
                {
                    break label0;
                }
                g();
            }
            b(false);
            f.write("null");
            return this;
        }
        k = null;
        return this;
    }

    public void flush()
    {
        if (h == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            f.flush();
            return;
        }
    }

    static 
    {
        d = new String[128];
        for (int l = 0; l <= 31; l++)
        {
            d[l] = String.format("\\u%04x", new Object[] {
                Integer.valueOf(l)
            });
        }

        d[34] = "\\\"";
        d[92] = "\\\\";
        d[9] = "\\t";
        d[8] = "\\b";
        d[10] = "\\n";
        d[13] = "\\r";
        d[12] = "\\f";
        String as[] = (String[])d.clone();
        e = as;
        as[60] = "\\u003c";
        e[62] = "\\u003e";
        e[38] = "\\u0026";
        e[61] = "\\u003d";
        e[39] = "\\u0027";
    }
}
