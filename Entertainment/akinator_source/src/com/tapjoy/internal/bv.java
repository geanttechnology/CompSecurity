// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            bu, cq, bx, bz, 
//            cb

public final class bv extends bu
{

    public static final bu.a a = new bu.a() {

        public final bu a(Reader reader)
        {
            return new bv(reader);
        }

        public final bu a(String s1)
        {
            return new bv(new StringReader(s1));
        }

    };
    private final cq b = new cq();
    private final Reader c;
    private boolean d;
    private final char e[] = new char[1024];
    private int f;
    private int g;
    private int h;
    private int i;
    private final List j = new ArrayList();
    private bz k;
    private String l;
    private String m;
    private int n;
    private int o;
    private boolean p;

    public bv(Reader reader)
    {
        d = false;
        f = 0;
        g = 0;
        h = 1;
        i = 1;
        a(bx.f);
        p = false;
        if (reader == null)
        {
            throw new NullPointerException("in == null");
        } else
        {
            c = reader;
            return;
        }
    }

    private void A()
    {
        if (!d)
        {
            throw d("Use JsonReader.setLenient(true) to accept malformed JSON");
        } else
        {
            return;
        }
    }

    private void B()
    {
        int i1;
        do
        {
            if (f >= g && !a(1))
            {
                break;
            }
            char ac[] = e;
            i1 = f;
            f = i1 + 1;
            i1 = ac[i1];
        } while (i1 != '\r' && i1 != '\n');
    }

    private bz a(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        b(bx.b);
_L4:
        switch (z())
        {
        default:
            f = f - 1;
            return w();

        case 93: // ']'
            if (flag)
            {
                v();
                bz bz2 = bz.b;
                k = bz2;
                return bz2;
            }
            // fall through

        case 44: // ','
        case 59: // ';'
            A();
            f = f - 1;
            m = "null";
            bz bz3 = bz.i;
            k = bz3;
            return bz3;
        }
_L2:
        switch (z())
        {
        default:
            throw d("Unterminated array");

        case 93: // ']'
            v();
            bz bz1 = bz.b;
            k = bz1;
            return bz1;

        case 59: // ';'
            A();
            break;

        case 44: // ','
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String a(char c1)
    {
        Object obj = null;
_L12:
        int i1 = f;
_L9:
        char c2;
        Object obj1;
        int j1;
        do
        {
            if (f >= g)
            {
                break MISSING_BLOCK_LABEL_383;
            }
            char ac[] = e;
            j1 = f;
            f = j1 + 1;
            j1 = ac[j1];
            if (j1 == c1)
            {
                if (p)
                {
                    return "skipped!";
                }
                if (obj == null)
                {
                    return b.a(e, i1, f - i1 - 1);
                } else
                {
                    ((StringBuilder) (obj)).append(e, i1, f - i1 - 1);
                    return ((StringBuilder) (obj)).toString();
                }
            }
        } while (j1 != '\\');
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new StringBuilder();
        }
        ((StringBuilder) (obj1)).append(e, i1, f - i1 - 1);
        if (f == g && !a(1))
        {
            throw d("Unterminated escape sequence");
        }
        obj = e;
        i1 = f;
        f = i1 + 1;
        c2 = obj[i1];
        c2;
        JVM INSTR lookupswitch 6: default 268
    //                   98: 359
    //                   102: 377
    //                   110: 365
    //                   114: 371
    //                   116: 353
    //                   117: 287;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L3:
        break MISSING_BLOCK_LABEL_377;
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break; /* Loop/switch isn't completed */
_L10:
        ((StringBuilder) (obj1)).append(c2);
        i1 = f;
        obj = obj1;
        if (true) goto _L9; else goto _L8
_L8:
        if (f + 4 > g && !a(4))
        {
            throw d("Unterminated escape sequence");
        }
        obj = b.a(e, f, 4);
        f = f + 4;
        c2 = (char)Integer.parseInt(((String) (obj)), 16);
          goto _L10
_L6:
        c2 = '\t';
          goto _L10
_L2:
        c2 = '\b';
          goto _L10
_L4:
        c2 = '\n';
          goto _L10
_L5:
        c2 = '\r';
          goto _L10
        c2 = '\f';
          goto _L10
        Object obj2 = obj;
        if (obj == null)
        {
            obj2 = new StringBuilder();
        }
        ((StringBuilder) (obj2)).append(e, i1, f - i1);
        obj = obj2;
        if (!a(1))
        {
            throw d("Unterminated string");
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void a(bx bx1)
    {
        j.add(bx1);
    }

    private void a(bz bz1)
    {
        l();
        if (k != bz1)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(bz1).append(" but was ").append(l()).toString());
        } else
        {
            u();
            return;
        }
    }

    private boolean a(int i1)
    {
        boolean flag1 = false;
        int j1 = 0;
        while (j1 < f) 
        {
            if (e[j1] == '\n')
            {
                h = h + 1;
                i = 1;
            } else
            {
                i = i + 1;
            }
            j1++;
        }
        boolean flag;
        if (g != f)
        {
            g = g - f;
            System.arraycopy(e, f, e, 0, g);
        } else
        {
            g = 0;
        }
        f = 0;
        do
        {
            int k1 = c.read(e, g, e.length - g);
            flag = flag1;
            if (k1 == -1)
            {
                break;
            }
            g = k1 + g;
            if (h == 1 && i == 1 && g > 0 && e[0] == '\uFEFF')
            {
                f = f + 1;
                i = i - 1;
            }
            if (g < i1)
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    private bz b(boolean flag)
    {
        if (flag)
        {
            switch (z())
            {
            default:
                f = f - 1;
                do
                {
                    int i1 = z();
                    bz bz1;
                    switch (i1)
                    {
                    default:
                        A();
                        f = f - 1;
                        l = c(false);
                        if (l.length() == 0)
                        {
                            throw d("Expected name");
                        }
                        break;

                    case 39: // '\''
                        A();
                        // fall through

                    case 34: // '"'
                        l = a((char)i1);
                        break;
                    }
                    b(bx.d);
                    bz1 = bz.e;
                    k = bz1;
                    return bz1;
                } while (true);

            case 125: // '}'
                v();
                bz1 = bz.d;
                k = bz1;
                return bz1;
            }
        } else
        {
            switch (z())
            {
            default:
                throw d("Unterminated object");

            case 125: // '}'
                v();
                bz1 = bz.d;
                k = bz1;
                return bz1;

            case 44: // ','
            case 59: // ';'
                break;
            }
            continue;
        }
    }

    private void b(bx bx1)
    {
        j.set(j.size() - 1, bx1);
    }

    private String c(boolean flag)
    {
        Object obj;
        Object obj2;
        int i1;
        obj2 = null;
        n = -1;
        o = 0;
        i1 = 0;
        obj = null;
_L2:
        Object obj1;
        int j1;
        if (f + i1 < g)
        {
            obj1 = obj;
            j1 = i1;
            switch (e[f + i1])
            {
            default:
                i1++;
                continue; /* Loop/switch isn't completed */

            case 35: // '#'
            case 47: // '/'
            case 59: // ';'
            case 61: // '='
            case 92: // '\\'
                A();
                j1 = i1;
                obj1 = obj;
                break;

            case 9: // '\t'
            case 10: // '\n'
            case 12: // '\f'
            case 13: // '\r'
            case 32: // ' '
            case 44: // ','
            case 58: // ':'
            case 91: // '['
            case 93: // ']'
            case 123: // '{'
            case 125: // '}'
                break;
            }
        } else
        if (i1 < e.length)
        {
            if (a(i1 + 1))
            {
                continue; /* Loop/switch isn't completed */
            }
            e[g] = '\0';
            obj1 = obj;
            j1 = i1;
        } else
        {
label0:
            {
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = new StringBuilder();
                }
                ((StringBuilder) (obj1)).append(e, f, i1);
                o = o + i1;
                f = i1 + f;
                if (a(1))
                {
                    break label0;
                }
                j1 = 0;
            }
        }
        if (flag && obj1 == null)
        {
            n = f;
            obj = obj2;
        } else
        if (p)
        {
            obj = "skipped!";
        } else
        if (obj1 == null)
        {
            obj = b.a(e, f, j1);
        } else
        {
            ((StringBuilder) (obj1)).append(e, f, j1);
            obj = ((StringBuilder) (obj1)).toString();
        }
        o = o + j1;
        f = f + j1;
        return ((String) (obj));
        i1 = 0;
        obj = obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private IOException d(String s1)
    {
        throw new cb((new StringBuilder()).append(s1).append(" at line ").append(x()).append(" column ").append(y()).toString());
    }

    private bz u()
    {
        l();
        bz bz1 = k;
        k = null;
        m = null;
        l = null;
        return bz1;
    }

    private bx v()
    {
        return (bx)j.remove(j.size() - 1);
    }

    private bz w()
    {
        int i1 = z();
        switch (i1)
        {
        default:
            f = f - 1;
            m = c(true);
            if (o == 0)
            {
                throw d("Expected literal value");
            }
            break;

        case 123: // '{'
            a(bx.c);
            bz bz1 = bz.c;
            k = bz1;
            return bz1;

        case 91: // '['
            a(bx.a);
            bz bz2 = bz.a;
            k = bz2;
            return bz2;

        case 39: // '\''
            A();
            // fall through

        case 34: // '"'
            m = a((char)i1);
            bz bz3 = bz.f;
            k = bz3;
            return bz3;
        }
        if (n == -1) goto _L2; else goto _L1
_L1:
        if (o != 4 || 'n' != e[n] && 'N' != e[n] || 'u' != e[n + 1] && 'U' != e[n + 1] || 'l' != e[n + 2] && 'L' != e[n + 2] || 'l' != e[n + 3] && 'L' != e[n + 3]) goto _L4; else goto _L3
_L3:
        Object obj;
        m = "null";
        obj = bz.i;
_L12:
        k = ((bz) (obj));
        if (k == bz.f)
        {
            A();
        }
        return k;
_L4:
        if (o == 4 && ('t' == e[n] || 'T' == e[n]) && ('r' == e[n + 1] || 'R' == e[n + 1]) && ('u' == e[n + 2] || 'U' == e[n + 2]) && ('e' == e[n + 3] || 'E' == e[n + 3]))
        {
            m = "true";
            obj = bz.h;
            continue; /* Loop/switch isn't completed */
        }
        if (o == 5 && ('f' == e[n] || 'F' == e[n]) && ('a' == e[n + 1] || 'A' == e[n + 1]) && ('l' == e[n + 2] || 'L' == e[n + 2]) && ('s' == e[n + 3] || 'S' == e[n + 3]) && ('e' == e[n + 4] || 'E' == e[n + 4]))
        {
            m = "false";
            obj = bz.h;
            continue; /* Loop/switch isn't completed */
        }
        m = b.a(e, n, o);
        obj = e;
        int j2 = n;
        int k2 = o;
        int j1 = obj[j2];
        int k1;
        int l1;
        int i2;
        if (j1 == 45)
        {
            k1 = j2 + 1;
            j1 = obj[k1];
        } else
        {
            k1 = j2;
        }
        if (j1 != 48) goto _L6; else goto _L5
_L5:
        j1 = k1 + 1;
        k1 = obj[j1];
_L8:
        i2 = k1;
        l1 = j1;
        if (k1 == 46)
        {
            k1 = j1 + 1;
            j1 = obj[k1];
            do
            {
                i2 = j1;
                l1 = k1;
                if (j1 < 48)
                {
                    break;
                }
                i2 = j1;
                l1 = k1;
                if (j1 > 57)
                {
                    break;
                }
                k1++;
                j1 = obj[k1];
            } while (true);
        }
        break MISSING_BLOCK_LABEL_840;
_L6:
        if (j1 < 49 || j1 > 57)
        {
            break MISSING_BLOCK_LABEL_833;
        }
        i2 = k1 + 1;
        l1 = obj[i2];
_L10:
        k1 = l1;
        j1 = i2;
        if (l1 < 48) goto _L8; else goto _L7
_L7:
        k1 = l1;
        j1 = i2;
        if (l1 > 57) goto _L8; else goto _L9
_L9:
        i2++;
        l1 = obj[i2];
          goto _L10
        obj = bz.f;
        continue; /* Loop/switch isn't completed */
label0:
        {
label1:
            {
                if (i2 != 101)
                {
                    k1 = l1;
                    if (i2 != 69)
                    {
                        break label0;
                    }
                }
                l1++;
                i2 = obj[l1];
                if (i2 != '+')
                {
                    k1 = i2;
                    j1 = l1;
                    if (i2 != '-')
                    {
                        break label1;
                    }
                }
                j1 = l1 + 1;
                k1 = obj[j1];
            }
            if (k1 >= 48 && k1 <= 57)
            {
                j1++;
                l1 = obj[j1];
                do
                {
                    k1 = j1;
                    if (l1 < '0')
                    {
                        break;
                    }
                    k1 = j1;
                    if (l1 > '9')
                    {
                        break;
                    }
                    j1++;
                    l1 = obj[j1];
                } while (true);
            } else
            {
                obj = bz.f;
                continue; /* Loop/switch isn't completed */
            }
        }
        if (k1 == j2 + k2)
        {
            obj = bz.g;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        obj = bz.f;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private int x()
    {
        int j1 = h;
        for (int i1 = 0; i1 < f;)
        {
            int k1 = j1;
            if (e[i1] == '\n')
            {
                k1 = j1 + 1;
            }
            i1++;
            j1 = k1;
        }

        return j1;
    }

    private int y()
    {
        int i1 = i;
        int j1 = 0;
        while (j1 < f) 
        {
            if (e[j1] == '\n')
            {
                i1 = 1;
            } else
            {
                i1++;
            }
            j1++;
        }
        return i1;
    }

    private int z()
    {
_L19:
        int i1;
        if (f >= g && !a(1))
        {
            break; /* Loop/switch isn't completed */
        }
        char ac[] = e;
        i1 = f;
        f = i1 + 1;
        i1 = ac[i1];
        i1;
        JVM INSTR lookupswitch 6: default 100
    //                   9: 0
    //                   10: 0
    //                   13: 0
    //                   32: 0
    //                   35: 305
    //                   47: 102;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L4
_L2:
        continue; /* Loop/switch isn't completed */
_L1:
        return i1;
_L4:
        if (f == g && !a(1)) goto _L1; else goto _L5
_L5:
        A();
        e[f];
        JVM INSTR lookupswitch 2: default 160
    //                   42: 162
    //                   47: 288;
           goto _L6 _L7 _L8
_L6:
        return i1;
_L7:
        f = f + 1;
_L17:
        if (f + "*/".length() > g && !a("*/".length())) goto _L10; else goto _L9
_L9:
        i1 = 0;
_L15:
        if (i1 >= "*/".length()) goto _L12; else goto _L11
_L11:
        if (e[f + i1] != "*/".charAt(i1)) goto _L14; else goto _L13
_L13:
        i1++;
          goto _L15
_L12:
        boolean flag = true;
          goto _L16
_L14:
        f = f + 1;
          goto _L17
_L10:
        flag = false;
_L16:
        if (!flag)
        {
            throw d("Unterminated comment");
        }
        f = f + 2;
        continue; /* Loop/switch isn't completed */
          goto _L17
_L8:
        f = f + 1;
        B();
        continue; /* Loop/switch isn't completed */
_L3:
        A();
        B();
        if (true) goto _L19; else goto _L18
_L18:
        throw new EOFException("End of input");
    }

    public final void close()
    {
        m = null;
        k = null;
        j.clear();
        j.add(bx.h);
        c.close();
    }

    public final void g()
    {
        a(bz.a);
    }

    public final void h()
    {
        a(bz.b);
    }

    public final void i()
    {
        a(bz.c);
    }

    public final void j()
    {
        a(bz.d);
    }

    public final boolean k()
    {
        l();
        return k != bz.d && k != bz.b;
    }

    public final bz l()
    {
        if (k == null) goto _L2; else goto _L1
_L1:
        bz bz1 = k;
_L14:
        return bz1;
_L2:
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[bx.values().length];
                try
                {
                    a[bx.f.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[bx.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[bx.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[bx.c.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[bx.d.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[bx.e.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[bx.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[bx.h.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[((bx)j.get(j.size() - 1)).ordinal()];
        JVM INSTR tableswitch 1 8: default 92
    //                   1 100
    //                   2 173
    //                   3 179
    //                   4 185
    //                   5 191
    //                   6 291
    //                   7 297
    //                   8 329;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        throw new AssertionError();
_L4:
        b(bx.g);
        bz bz3 = w();
        bz1 = bz3;
        if (!d)
        {
            bz1 = bz3;
            if (k != bz.a)
            {
                bz1 = bz3;
                if (k != bz.c)
                {
                    throw new IOException((new StringBuilder("Expected JSON document to start with '[' or '{' but was ")).append(k).toString());
                }
            }
        }
          goto _L12
_L5:
        return a(true);
_L6:
        return a(false);
_L7:
        return b(true);
_L8:
        switch (z())
        {
        case 59: // ';'
        case 60: // '<'
        default:
            throw d("Expected ':'");

        case 61: // '='
            A();
            if ((f < g || a(1)) && e[f] == '>')
            {
                f = f + 1;
            }
            // fall through

        case 58: // ':'
            b(bx.e);
            return w();
        }
_L9:
        return b(false);
_L12:
        if (true) goto _L14; else goto _L13
_L13:
_L10:
        try
        {
            bz1 = w();
            if (!d)
            {
                throw d("Expected EOF");
            }
        }
        catch (EOFException eofexception)
        {
            bz bz2 = bz.j;
            k = bz2;
            return bz2;
        }
          goto _L14
_L11:
        throw new IllegalStateException("JsonReader is closed");
    }

    public final String m()
    {
        l();
        if (k != bz.e)
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(l()).toString());
        } else
        {
            String s1 = l;
            u();
            return s1;
        }
    }

    public final String n()
    {
        l();
        if (k != bz.f && k != bz.g)
        {
            throw new IllegalStateException((new StringBuilder("Expected a string but was ")).append(l()).toString());
        } else
        {
            String s1 = m;
            u();
            return s1;
        }
    }

    public final boolean o()
    {
        l();
        if (k != bz.h)
        {
            throw new IllegalStateException((new StringBuilder("Expected a boolean but was ")).append(k).toString());
        }
        boolean flag;
        if (m == "true")
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u();
        return flag;
    }

    public final void p()
    {
        l();
        if (k != bz.i)
        {
            throw new IllegalStateException((new StringBuilder("Expected null but was ")).append(k).toString());
        } else
        {
            u();
            return;
        }
    }

    public final double q()
    {
        l();
        if (k != bz.f && k != bz.g)
        {
            throw new IllegalStateException((new StringBuilder("Expected a double but was ")).append(k).toString());
        } else
        {
            double d1 = Double.parseDouble(m);
            u();
            return d1;
        }
    }

    public final long r()
    {
        l();
        if (k != bz.f && k != bz.g)
        {
            throw new IllegalStateException((new StringBuilder("Expected a long but was ")).append(k).toString());
        }
        long l1;
        try
        {
            l1 = Long.parseLong(m);
        }
        catch (NumberFormatException numberformatexception)
        {
            double d1 = Double.parseDouble(m);
            long l2 = (long)d1;
            l1 = l2;
            if ((double)l2 != d1)
            {
                throw new NumberFormatException(m);
            }
        }
        u();
        return l1;
    }

    public final int s()
    {
        l();
        if (k != bz.f && k != bz.g)
        {
            throw new IllegalStateException((new StringBuilder("Expected an int but was ")).append(k).toString());
        }
        int i1;
        try
        {
            i1 = Integer.parseInt(m);
        }
        catch (NumberFormatException numberformatexception)
        {
            double d1 = Double.parseDouble(m);
            int j1 = (int)d1;
            i1 = j1;
            if ((double)j1 != d1)
            {
                throw new NumberFormatException(m);
            }
        }
        u();
        return i1;
    }

    public final void t()
    {
        int j1;
        l();
        if (k == bz.b || k == bz.d)
        {
            throw new IllegalStateException((new StringBuilder("Expected a value but was ")).append(k).toString());
        }
        p = true;
        j1 = 0;
_L5:
        bz bz1 = u();
        if (bz1 == bz.a) goto _L2; else goto _L1
_L1:
        bz bz2 = bz.c;
        if (bz1 != bz2) goto _L3; else goto _L2
_L2:
        int i1 = j1 + 1;
_L8:
        j1 = i1;
        if (i1 != 0) goto _L5; else goto _L4
_L4:
        p = false;
        return;
_L3:
        if (bz1 == bz.b) goto _L7; else goto _L6
_L6:
        bz2 = bz.d;
        i1 = j1;
        if (bz1 != bz2) goto _L8; else goto _L7
_L7:
        i1 = j1 - 1;
          goto _L8
        Exception exception;
        exception;
        p = false;
        throw exception;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(getClass().getSimpleName()).append(" near ");
        StringBuilder stringbuilder1 = new StringBuilder();
        int i1 = Math.min(f, 20);
        stringbuilder1.append(e, f - i1, i1);
        i1 = Math.min(g - f, 20);
        stringbuilder1.append(e, f, i1);
        return stringbuilder.append(stringbuilder1).toString();
    }

}
