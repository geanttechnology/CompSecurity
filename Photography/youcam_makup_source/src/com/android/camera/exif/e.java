// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import android.util.Log;
import android.util.SparseIntArray;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.TreeMap;

// Referenced classes of package com.android.camera.exif:
//            c, a, ExifInvalidFormatException, g, 
//            h, l, j, f, 
//            n

class e
{

    private static final Charset a = Charset.forName("US-ASCII");
    private static final short s;
    private static final short t;
    private static final short u;
    private static final short v;
    private static final short w;
    private static final short x;
    private static final short y;
    private final a b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private j g;
    private h h;
    private j i;
    private j j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private byte o[];
    private int p;
    private int q;
    private final c r;
    private final TreeMap z = new TreeMap();

    private e(InputStream inputstream, int i1, c c1)
    {
        d = 0;
        e = 0;
        l = false;
        n = 0;
        if (inputstream == null)
        {
            throw new IOException("Null argument inputStream to ExifParser");
        }
        r = c1;
        l = a(inputstream);
        b = new a(inputstream);
        c = i1;
        if (l)
        {
            q();
            long l1 = b.f();
            if (l1 > 0x7fffffffL)
            {
                throw new ExifInvalidFormatException((new StringBuilder()).append("Invalid offset ").append(l1).toString());
            }
            p = (int)l1;
            f = 0;
            if (b(0) || o())
            {
                a(0, l1);
                if (l1 != 8L)
                {
                    o = new byte[(int)l1 - 8];
                    a(o);
                    return;
                }
            }
        }
    }

    protected static e a(InputStream inputstream, c c1)
    {
        return new e(inputstream, 63, c1);
    }

    private void a(int i1, long l1)
    {
        z.put(Integer.valueOf((int)l1), new g(i1, b(i1)));
    }

    private void a(long l1)
    {
        z.put(Integer.valueOf((int)l1), new h(3));
    }

    private boolean a(int i1, int j1)
    {
        j1 = r.b().get(j1);
        if (j1 == 0)
        {
            return false;
        } else
        {
            return com.android.camera.exif.c.d(j1, i1);
        }
    }

    private boolean a(InputStream inputstream)
    {
        boolean flag1 = false;
        inputstream = new a(inputstream);
        if (inputstream.c() != -40)
        {
            throw new ExifInvalidFormatException("Invalid JPEG format");
        }
        short word0 = inputstream.c();
        do
        {
            int i1;
label0:
            {
                boolean flag = flag1;
                if (word0 != -39)
                {
                    flag = flag1;
                    if (!com.android.camera.exif.l.a(word0))
                    {
                        int j1 = inputstream.d();
                        i1 = j1;
                        if (word0 != -31)
                        {
                            break label0;
                        }
                        i1 = j1;
                        if (j1 < 8)
                        {
                            break label0;
                        }
                        int k1 = inputstream.e();
                        short word1 = inputstream.c();
                        j1 -= 6;
                        i1 = j1;
                        if (k1 != 0x45786966)
                        {
                            break label0;
                        }
                        i1 = j1;
                        if (word1 != 0)
                        {
                            break label0;
                        }
                        q = inputstream.a();
                        m = j1;
                        n = q + m;
                        flag = true;
                    }
                }
                return flag;
            }
            if (i1 < 2 || (long)(i1 - 2) != inputstream.skip(i1 - 2))
            {
                Log.w("ExifParser", "Invalid JPEG format.");
                return false;
            }
            word0 = inputstream.c();
        } while (true);
    }

    private void b(int i1, long l1)
    {
        z.put(Integer.valueOf((int)l1), new h(4, i1));
    }

    private boolean b(int i1)
    {
        boolean flag = true;
        i1;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 51
    //                   2 62
    //                   3 85
    //                   4 73;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        flag = false;
_L8:
        return flag;
_L2:
        if ((c & 1) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if ((c & 2) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ((c & 4) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if ((c & 8) == 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if ((c & 0x10) == 0)
        {
            return false;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void c(int i1)
    {
        b.b(i1);
        for (; !z.isEmpty() && ((Integer)z.firstKey()).intValue() < i1; z.pollFirstEntry()) { }
    }

    private void c(j j1)
    {
        int i1 = 0;
        if (j1.e() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        short word0;
        int k1;
        word0 = j1.b();
        k1 = j1.a();
        if (word0 == s && a(k1, c.C))
        {
            if (b(2) || b(3))
            {
                a(2, j1.e(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (word0 == t && a(k1, c.D))
        {
            if (b(4))
            {
                a(4, j1.e(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (word0 == u && a(k1, c.am))
        {
            if (b(3))
            {
                a(3, j1.e(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (word0 == v && a(k1, c.E))
        {
            if (n())
            {
                a(j1.e(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (word0 == w && a(k1, c.F))
        {
            if (n())
            {
                j = j1;
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (word0 != x || !a(k1, c.i))
        {
            break; /* Loop/switch isn't completed */
        }
        if (n())
        {
            if (j1.f())
            {
                while (i1 < j1.e()) 
                {
                    if (j1.c() == 3)
                    {
                        b(i1, j1.e(i1));
                    } else
                    {
                        b(i1, j1.e(i1));
                    }
                    i1++;
                }
            } else
            {
                z.put(Integer.valueOf(j1.k()), new f(j1, false));
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (word0 != y || !a(k1, c.m) || !n() || !j1.f()) goto _L1; else goto _L4
_L4:
        i = j1;
        return;
    }

    private boolean n()
    {
        return (c & 0x20) != 0;
    }

    private boolean o()
    {
        f;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 34
    //                   1 68
    //                   2 73;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        if (b(2) || b(4) || b(3) || b(1))
        {
            return true;
        }
          goto _L1
_L3:
        return n();
_L4:
        return b(3);
    }

    private j p()
    {
        boolean flag = true;
        short word0 = b.c();
        short word1 = b.c();
        long l1 = b.f();
        if (l1 > 0x7fffffffL)
        {
            throw new ExifInvalidFormatException("Number of component is larger then Integer.MAX_VALUE");
        }
        if (!com.android.camera.exif.j.a(word1))
        {
            Log.w("ExifParser", String.format("Tag %04x: Invalid data type %d", new Object[] {
                Short.valueOf(word0), Short.valueOf(word1)
            }));
            b.skip(4L);
            return null;
        }
        int i1 = (int)l1;
        int k1 = f;
        j j1;
        if ((int)l1 == 0)
        {
            flag = false;
        }
        j1 = new j(word0, word1, i1, k1, flag);
        i1 = j1.d();
        if (i1 > 4)
        {
            long l2 = b.f();
            if (l2 > 0x7fffffffL)
            {
                throw new ExifInvalidFormatException("offset is larger then Integer.MAX_VALUE");
            }
            if (l2 < (long)p && word1 == 7)
            {
                byte abyte0[] = new byte[(int)l1];
                System.arraycopy(o, (int)l2 - 8, abyte0, 0, (int)l1);
                j1.a(abyte0);
                return j1;
            } else
            {
                j1.g((int)l2);
                return j1;
            }
        } else
        {
            boolean flag1 = j1.l();
            j1.a(false);
            b(j1);
            j1.a(flag1);
            b.skip(4 - i1);
            j1.g(b.a() - 4);
            return j1;
        }
    }

    private void q()
    {
        short word0 = b.c();
        if (18761 == word0)
        {
            b.a(ByteOrder.LITTLE_ENDIAN);
        } else
        if (19789 == word0)
        {
            b.a(ByteOrder.BIG_ENDIAN);
        } else
        {
            throw new ExifInvalidFormatException("Invalid TIFF header");
        }
        if (b.c() != 42)
        {
            throw new ExifInvalidFormatException("Invalid TIFF header");
        } else
        {
            return;
        }
    }

    protected int a()
    {
        byte byte0 = 1;
        if (l) goto _L2; else goto _L1
_L1:
        byte0 = 5;
_L4:
        return byte0;
_L2:
        int j1;
        int k1;
        j1 = b.a();
        k1 = d + 2 + e * 12;
        if (j1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        g = p();
        if (g == null)
        {
            return a();
        }
        if (k)
        {
            c(g);
            return 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (j1 == k1)
        {
            if (f == 0)
            {
                long l1 = i();
                if ((b(1) || n()) && l1 != 0L)
                {
                    a(1, l1);
                }
            } else
            {
                f f1;
                IOException ioexception;
                int i1;
                if (z.size() > 0)
                {
                    i1 = ((Integer)z.firstEntry().getKey()).intValue() - b.a();
                } else
                {
                    i1 = 4;
                }
                if (i1 < 4)
                {
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid size of link to next IFD: ").append(i1).toString());
                } else
                {
                    long l2 = i();
                    if (l2 != 0L)
                    {
                        Log.w("ExifParser", (new StringBuilder()).append("Invalid link to next IFD: ").append(l2).toString());
                    }
                }
            }
        }
        do
        {
            if (z.size() == 0)
            {
                break;
            }
            java.util.Map.Entry entry = z.pollFirstEntry();
            Object obj = entry.getValue();
            try
            {
                c(((Integer)entry.getKey()).intValue());
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                Log.w("ExifParser", (new StringBuilder()).append("Failed to skip to data at: ").append(entry.getKey()).append(" for ").append(obj.getClass().getName()).append(", the file may be broken.").toString());
                continue;
            }
            if (obj instanceof g)
            {
                f = ((g)obj).a;
                e = b.d();
                d = ((Integer)entry.getKey()).intValue();
                if (e * 12 + d + 2 > m)
                {
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid size of IFD ").append(f).toString());
                    return 5;
                }
                k = o();
                if (((g)obj).b)
                {
                    return 0;
                }
                b();
            } else
            {
                if (obj instanceof h)
                {
                    h = (h)obj;
                    return h.b;
                }
                f1 = (f)obj;
                g = f1.a;
                if (g.c() != 7)
                {
                    b(g);
                    c(g);
                }
                if (f1.b)
                {
                    return 2;
                }
            }
        } while (true);
        return 5;
    }

    protected int a(byte abyte0[])
    {
        return b.read(abyte0);
    }

    protected String a(int i1)
    {
        return a(i1, a);
    }

    protected String a(int i1, Charset charset)
    {
        if (i1 > 0)
        {
            return b.a(i1, charset);
        } else
        {
            return "";
        }
    }

    protected void a(j j1)
    {
        if (j1.k() >= b.a())
        {
            z.put(Integer.valueOf(j1.k()), new f(j1, true));
        }
    }

    protected void b()
    {
        int i1 = d;
        int k1 = e * 12 + (i1 + 2);
        i1 = b.a();
        if (i1 <= k1)
        {
            if (k)
            {
                do
                {
                    if (i1 >= k1)
                    {
                        break;
                    }
                    g = p();
                    int j1 = i1 + 12;
                    i1 = j1;
                    if (g != null)
                    {
                        c(g);
                        i1 = j1;
                    }
                } while (true);
            } else
            {
                c(k1);
            }
            long l1 = i();
            if (f == 0 && (b(1) || n()) && l1 > 0L)
            {
                a(1, l1);
                return;
            }
        }
    }

    protected void b(j j1)
    {
        int k1 = 0;
        int l1 = 0;
        boolean flag = false;
        int i1 = 0;
        short word0 = j1.c();
        if (word0 == 2 || word0 == 7 || word0 == 1)
        {
            int i2 = j1.e();
            if (z.size() > 0 && ((Integer)z.firstEntry().getKey()).intValue() < i2 + b.a())
            {
                Object obj = z.firstEntry().getValue();
                if (obj instanceof h)
                {
                    Log.w("ExifParser", (new StringBuilder()).append("Thumbnail overlaps value for tag: \n").append(j1.toString()).toString());
                    obj = z.pollFirstEntry();
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid thumbnail offset: ").append(((java.util.Map.Entry) (obj)).getKey()).toString());
                } else
                {
                    int j2;
                    if (obj instanceof g)
                    {
                        Log.w("ExifParser", (new StringBuilder()).append("Ifd ").append(((g)obj).a).append(" overlaps value for tag: \n").append(j1.toString()).toString());
                    } else
                    if (obj instanceof f)
                    {
                        Log.w("ExifParser", (new StringBuilder()).append("Tag value for tag: \n").append(((f)obj).a.toString()).append(" overlaps value for tag: \n").append(j1.toString()).toString());
                    }
                    j2 = ((Integer)z.firstEntry().getKey()).intValue() - b.a();
                    Log.w("ExifParser", (new StringBuilder()).append("Invalid size of tag: \n").append(j1.toString()).append(" setting count to: ").append(j2).toString());
                    j1.c(j2);
                }
            }
        }
        n an1[];
        switch (j1.c())
        {
        case 6: // '\006'
        case 8: // '\b'
        default:
            return;

        case 1: // '\001'
        case 7: // '\007'
            byte abyte0[] = new byte[j1.e()];
            a(abyte0);
            j1.a(abyte0);
            return;

        case 2: // '\002'
            j1.a(a(j1.e()));
            return;

        case 4: // '\004'
            long al[] = new long[j1.e()];
            for (k1 = al.length; i1 < k1; i1++)
            {
                al[i1] = i();
            }

            j1.a(al);
            return;

        case 5: // '\005'
            n an[] = new n[j1.e()];
            l1 = an.length;
            for (i1 = k1; i1 < l1; i1++)
            {
                an[i1] = j();
            }

            j1.a(an);
            return;

        case 3: // '\003'
            int ai[] = new int[j1.e()];
            k1 = ai.length;
            for (i1 = l1; i1 < k1; i1++)
            {
                ai[i1] = h();
            }

            j1.a(ai);
            return;

        case 9: // '\t'
            int ai1[] = new int[j1.e()];
            k1 = ai1.length;
            for (i1 = ((flag) ? 1 : 0); i1 < k1; i1++)
            {
                ai1[i1] = k();
            }

            j1.a(ai1);
            return;

        case 10: // '\n'
            an1 = new n[j1.e()];
            k1 = an1.length;
            i1 = 0;
            break;
        }
        for (; i1 < k1; i1++)
        {
            an1[i1] = l();
        }

        j1.a(an1);
    }

    protected j c()
    {
        return g;
    }

    protected int d()
    {
        return f;
    }

    protected int e()
    {
        return h.a;
    }

    protected int f()
    {
        if (i == null)
        {
            return 0;
        } else
        {
            return (int)i.e(0);
        }
    }

    protected int g()
    {
        if (j == null)
        {
            return 0;
        } else
        {
            return (int)j.e(0);
        }
    }

    protected int h()
    {
        return b.c() & 0xffff;
    }

    protected long i()
    {
        return (long)k() & 0xffffffffL;
    }

    protected n j()
    {
        return new n(i(), i());
    }

    protected int k()
    {
        return b.e();
    }

    protected n l()
    {
        int i1 = k();
        int j1 = k();
        return new n(i1, j1);
    }

    protected ByteOrder m()
    {
        return b.b();
    }

    static 
    {
        s = com.android.camera.exif.c.a(c.C);
        t = com.android.camera.exif.c.a(c.D);
        u = com.android.camera.exif.c.a(c.am);
        v = com.android.camera.exif.c.a(c.E);
        w = com.android.camera.exif.c.a(c.F);
        x = com.android.camera.exif.c.a(c.i);
        y = com.android.camera.exif.c.a(c.m);
    }
}
