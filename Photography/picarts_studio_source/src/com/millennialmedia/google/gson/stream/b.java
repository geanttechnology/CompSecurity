// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class b
    implements Closeable, Flushable
{

    private static final String a[];
    private static final String b[];
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    private final Writer h;
    private int i[];
    private int j;
    private String k;

    public b(Writer writer)
    {
        i = new int[32];
        j = 0;
        a(6);
        d = ":";
        g = true;
        if (writer == null)
        {
            throw new NullPointerException("out == null");
        } else
        {
            h = writer;
            return;
        }
    }

    private b a(int l, int i1, String s)
    {
        int j1 = f();
        if (j1 != i1 && j1 != l)
        {
            throw new IllegalStateException("Nesting problem.");
        }
        if (k != null)
        {
            throw new IllegalStateException((new StringBuilder("Dangling name: ")).append(k).toString());
        }
        j = j - 1;
        if (j1 == i1)
        {
            h();
        }
        h.write(s);
        return this;
    }

    private b a(int l, String s)
    {
        b(true);
        a(l);
        h.write(s);
        return this;
    }

    private void a(int l)
    {
        if (j == i.length)
        {
            int ai[] = new int[j * 2];
            System.arraycopy(i, 0, ai, 0, j);
            i = ai;
        }
        int ai1[] = i;
        int i1 = j;
        j = i1 + 1;
        ai1[i1] = l;
    }

    private void b(int l)
    {
        i[j - 1] = l;
    }

    private void b(boolean flag)
    {
        switch (f())
        {
        case 3: // '\003'
        case 5: // '\005'
        default:
            throw new IllegalStateException("Nesting problem.");

        case 7: // '\007'
            if (!e)
            {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            // fall through

        case 6: // '\006'
            if (!e && !flag)
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
            h.append(',');
            h();
            return;

        case 4: // '\004'
            h.append(d);
            b(5);
            return;
        }
    }

    private void c(String s)
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
        if (f)
        {
            as = b;
        } else
        {
            as = a;
        }
        h.write("\"");
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
            h.write(s, i1, l - i1);
        }
        h.write(s1);
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
            h.write(s, i1, k1 - i1);
        }
        h.write("\"");
        return;
    }

    private int f()
    {
        if (j == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            return i[j - 1];
        }
    }

    private void g()
    {
        if (k != null)
        {
            int l = f();
            if (l == 5)
            {
                h.write(44);
            } else
            if (l != 3)
            {
                throw new IllegalStateException("Nesting problem.");
            }
            h();
            b(4);
            c(k);
            k = null;
        }
    }

    private void h()
    {
        if (c != null)
        {
            h.write("\n");
            int l = 1;
            int i1 = j;
            while (l < i1) 
            {
                h.write(c);
                l++;
            }
        }
    }

    public b a()
    {
        g();
        return a(1, "[");
    }

    public b a(long l)
    {
        g();
        b(false);
        h.write(Long.toString(l));
        return this;
    }

    public b a(Number number)
    {
        if (number == null)
        {
            return e();
        }
        g();
        String s = number.toString();
        if (!e && (s.equals("-Infinity") || s.equals("Infinity") || s.equals("NaN")))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(number).toString());
        } else
        {
            b(false);
            h.append(s);
            return this;
        }
    }

    public b a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        if (k != null)
        {
            throw new IllegalStateException();
        }
        if (j == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            k = s;
            return this;
        }
    }

    public b a(boolean flag)
    {
        g();
        b(false);
        Writer writer = h;
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

    public b b()
    {
        return a(1, 2, "]");
    }

    public b b(String s)
    {
        if (s == null)
        {
            return e();
        } else
        {
            g();
            b(false);
            c(s);
            return this;
        }
    }

    public b c()
    {
        g();
        return a(3, "{");
    }

    public void close()
    {
        h.close();
        int l = j;
        if (l > 1 || l == 1 && i[l - 1] != 7)
        {
            throw new IOException("Incomplete document");
        } else
        {
            j = 0;
            return;
        }
    }

    public b d()
    {
        return a(3, 5, "}");
    }

    public b e()
    {
label0:
        {
            if (k != null)
            {
                if (!g)
                {
                    break label0;
                }
                g();
            }
            b(false);
            h.write("null");
            return this;
        }
        k = null;
        return this;
    }

    public void flush()
    {
        if (j == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            h.flush();
            return;
        }
    }

    static 
    {
        a = new String[128];
        for (int l = 0; l <= 31; l++)
        {
            a[l] = String.format("\\u%04x", new Object[] {
                Integer.valueOf(l)
            });
        }

        a[34] = "\\\"";
        a[92] = "\\\\";
        a[9] = "\\t";
        a[8] = "\\b";
        a[10] = "\\n";
        a[13] = "\\r";
        a[12] = "\\f";
        String as[] = (String[])a.clone();
        b = as;
        as[60] = "\\u003c";
        b[62] = "\\u003e";
        b[38] = "\\u0026";
        b[61] = "\\u003d";
        b[39] = "\\u0027";
    }
}
