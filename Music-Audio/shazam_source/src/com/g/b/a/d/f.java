// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.e;
import c.m;
import c.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.g.b.a.d:
//            d, h

final class f
{
    static final class a
    {

        final List a = new ArrayList();
        final e b;
        int c;
        int d;
        d e[];
        int f;
        int g;
        int h;

        private void c()
        {
            a.clear();
            Arrays.fill(e, null);
            f = e.length - 1;
            g = 0;
            h = 0;
        }

        static boolean c(int i)
        {
            return i >= 0 && i <= f.a().length - 1;
        }

        private int d()
        {
            return b.g() & 0xff;
        }

        private int d(int i)
        {
            int j = 0;
            boolean flag = false;
            if (i > 0)
            {
                j = e.length - 1;
                int k = i;
                i = ((flag) ? 1 : 0);
                for (; j >= f && k > 0; j--)
                {
                    k -= e[j].j;
                    h = h - e[j].j;
                    g = g - 1;
                    i++;
                }

                System.arraycopy(e, f + 1, e, f + 1 + i, g);
                f = f + i;
                j = i;
            }
            return j;
        }

        final int a(int i)
        {
            return f + 1 + i;
        }

        final int a(int i, int j)
        {
            i &= j;
            if (i < j)
            {
                return i;
            }
            i = 0;
            do
            {
                int k = d();
                if ((k & 0x80) != 0)
                {
                    j += (k & 0x7f) << i;
                    i += 7;
                } else
                {
                    return (k << i) + j;
                }
            } while (true);
        }

        final void a()
        {
label0:
            {
                if (d < h)
                {
                    if (d != 0)
                    {
                        break label0;
                    }
                    c();
                }
                return;
            }
            d(h - d);
        }

        final void a(d d1)
        {
            a.add(d1);
            int i = d1.j;
            if (i > d)
            {
                c();
                return;
            }
            d((h + i) - d);
            if (g + 1 > e.length)
            {
                d ad[] = new d[e.length * 2];
                System.arraycopy(e, 0, ad, e.length, e.length);
                f = e.length - 1;
                e = ad;
            }
            int j = f;
            f = j - 1;
            e[j] = d1;
            g = g + 1;
            h = i + h;
        }

        final c.f b()
        {
            int j = 0;
            int k = d();
            int i;
            if ((k & 0x80) == 128)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            k = a(k, 127);
            if (i != 0)
            {
                h h1 = com.g.b.a.d.h.a();
                byte abyte0[] = b.e(k);
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                h.a a1 = h1.a;
                k = 0;
                i = 0;
                h.a a3;
                int l;
                do
                {
                    l = i;
                    a3 = a1;
                    if (j >= abyte0.length)
                    {
                        break;
                    }
                    k = k << 8 | abyte0[j] & 0xff;
                    for (i += 8; i >= 8;)
                    {
                        a1 = a1.a[k >>> i - 8 & 0xff];
                        if (a1.a == null)
                        {
                            bytearrayoutputstream.write(a1.b);
                            i -= a1.c;
                            a1 = h1.a;
                        } else
                        {
                            i -= 8;
                        }
                    }

                    j++;
                } while (true);
                do
                {
                    if (l <= 0)
                    {
                        break;
                    }
                    h.a a2 = a3.a[k << 8 - l & 0xff];
                    if (a2.a != null || a2.c > l)
                    {
                        break;
                    }
                    bytearrayoutputstream.write(a2.b);
                    l -= a2.c;
                    a3 = h1.a;
                } while (true);
                return c.f.a(bytearrayoutputstream.toByteArray());
            } else
            {
                return b.c(k);
            }
        }

        final c.f b(int i)
        {
            if (c(i))
            {
                return f.a()[i].h;
            } else
            {
                return e[a(i - f.a().length)].h;
            }
        }

        a(s s)
        {
            e = new d[8];
            f = e.length - 1;
            g = 0;
            h = 0;
            c = 4096;
            d = 4096;
            b = m.a(s);
        }
    }

    static final class b
    {

        private final c a;

        private void a(int i, int j)
        {
            if (i < j)
            {
                a.b(i | 0);
                return;
            }
            a.b(j | 0);
            for (i -= j; i >= 128; i >>>= 7)
            {
                a.b(i & 0x7f | 0x80);
            }

            a.b(i);
        }

        private void a(c.f f1)
        {
            a(f1.c.length, 127);
            a.a(f1);
        }

        final void a(List list)
        {
            int j = list.size();
            int i = 0;
            while (i < j) 
            {
                c.f f1 = ((d)list.get(i)).h.c();
                Integer integer = (Integer)f.b().get(f1);
                if (integer != null)
                {
                    a(integer.intValue() + 1, 15);
                    a(((d)list.get(i)).i);
                } else
                {
                    a.b(0);
                    a(f1);
                    a(((d)list.get(i)).i);
                }
                i++;
            }
        }

        b(c c1)
        {
            a = c1;
        }
    }


    private static final d a[];
    private static final Map b;

    static c.f a(c.f f1)
    {
        int i = 0;
        for (int j = f1.c.length; i < j; i++)
        {
            byte byte0 = f1.c[i];
            if (byte0 >= 65 && byte0 <= 90)
            {
                throw new IOException((new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ")).append(f1.a()).toString());
            }
        }

        return f1;
    }

    static d[] a()
    {
        return a;
    }

    static Map b()
    {
        return b;
    }

    static 
    {
        int i = 0;
        a = (new d[] {
            new d(com.g.b.a.d.d.e, ""), new d(d.b, "GET"), new d(d.b, "POST"), new d(com.g.b.a.d.d.c, "/"), new d(com.g.b.a.d.d.c, "/index.html"), new d(d.d, "http"), new d(d.d, "https"), new d(d.a, "200"), new d(d.a, "204"), new d(d.a, "206"), 
            new d(d.a, "304"), new d(d.a, "400"), new d(d.a, "404"), new d(d.a, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), 
            new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), 
            new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), 
            new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), 
            new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), 
            new d("www-authenticate", "")
        });
        LinkedHashMap linkedhashmap = new LinkedHashMap(a.length);
        for (; i < a.length; i++)
        {
            if (!linkedhashmap.containsKey(a[i].h))
            {
                linkedhashmap.put(a[i].h, Integer.valueOf(i));
            }
        }

        b = Collections.unmodifiableMap(linkedhashmap);
    }
}
