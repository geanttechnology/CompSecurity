// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.android.camera.exif:
//            k, j, m, b, 
//            c, l

class d extends FilterOutputStream
{

    private b a;
    private int b;
    private int c;
    private int d;
    private byte e[];
    private ByteBuffer f;
    private final c g;

    protected d(OutputStream outputstream, c c1)
    {
        super(new BufferedOutputStream(outputstream, 0x10000));
        b = 0;
        e = new byte[1];
        f = ByteBuffer.allocate(4);
        g = c1;
    }

    private int a(int i, byte abyte0[], int i1, int j1)
    {
        int k1 = i - f.position();
        i = j1;
        if (j1 > k1)
        {
            i = k1;
        }
        f.put(abyte0, i1, i);
        return i;
    }

    private int a(k k1, int i)
    {
        int i1 = k1.d();
        k1 = k1.b();
        int i2 = k1.length;
        i1 = i + (i1 * 12 + 2 + 4);
        for (i = 0; i < i2;)
        {
            j j1 = k1[i];
            int l1 = i1;
            if (j1.d() > 4)
            {
                j1.g(i1);
                l1 = i1 + j1.d();
            }
            i++;
            i1 = l1;
        }

        return i1;
    }

    private void a()
    {
        if (a != null)
        {
            Object obj = b(a);
            b();
            int i = c();
            if (i + 8 > 65535)
            {
                throw new IOException("Exif header is too large (>64Kb)");
            }
            Object obj1 = new m(out);
            ((m) (obj1)).a(ByteOrder.BIG_ENDIAN);
            ((m) (obj1)).a((short)-31);
            ((m) (obj1)).a((short)(i + 8));
            ((m) (obj1)).a(0x45786966);
            ((m) (obj1)).a((short)0);
            if (a.e() == ByteOrder.BIG_ENDIAN)
            {
                ((m) (obj1)).a((short)19789);
            } else
            {
                ((m) (obj1)).a((short)18761);
            }
            ((m) (obj1)).a(a.e());
            ((m) (obj1)).a((short)42);
            ((m) (obj1)).a(8);
            b(((m) (obj1)));
            a(((m) (obj1)));
            obj = ((ArrayList) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                obj1 = (j)((Iterator) (obj)).next();
                a.a(((j) (obj1)));
            }
        }
    }

    static void a(j j1, m m1)
    {
        int i;
        int l1;
        int j2;
        l1 = 0;
        j2 = 0;
        i = 0;
        j1.c();
        JVM INSTR tableswitch 1 10: default 68
    //                   1 169
    //                   2 69
    //                   3 187
    //                   4 107
    //                   5 137
    //                   6 68
    //                   7 169
    //                   8 68
    //                   9 107
    //                   10 137;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L2 _L1 _L5 _L6
_L1:
        return;
_L3:
        byte abyte0[] = j1.j();
        if (abyte0.length == j1.e())
        {
            abyte0[abyte0.length - 1] = 0;
            m1.write(abyte0);
            return;
        } else
        {
            m1.write(abyte0);
            m1.write(0);
            return;
        }
_L5:
        l1 = j1.e();
        while (i < l1) 
        {
            m1.a((int)j1.e(i));
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        j2 = j1.e();
        int i1 = l1;
        while (i1 < j2) 
        {
            m1.a(j1.f(i1));
            i1++;
        }
        if (true) goto _L1; else goto _L2
_L2:
        byte abyte1[] = new byte[j1.e()];
        j1.b(abyte1);
        m1.write(abyte1);
        return;
_L4:
        int i2 = j1.e();
        int k1 = j2;
        while (k1 < i2) 
        {
            m1.a((short)(int)j1.e(k1));
            k1++;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void a(k k1, m m1)
    {
        boolean flag = false;
        j aj[] = k1.b();
        m1.a((short)aj.length);
        int j2 = aj.length;
        int i = 0;
        while (i < j2) 
        {
            j j1 = aj[i];
            m1.a(j1.b());
            m1.a(j1.c());
            m1.a(j1.e());
            if (j1.d() > 4)
            {
                m1.a(j1.k());
            } else
            {
                a(j1, m1);
                int k2 = j1.d();
                int l1 = 0;
                while (l1 < 4 - k2) 
                {
                    m1.write(0);
                    l1++;
                }
            }
            i++;
        }
        m1.a(k1.e());
        int i2 = aj.length;
        for (int i1 = ((flag) ? 1 : 0); i1 < i2; i1++)
        {
            k1 = aj[i1];
            if (k1.d() > 4)
            {
                a(((j) (k1)), m1);
            }
        }

    }

    private void a(m m1)
    {
        if (!a.b()) goto _L2; else goto _L1
_L1:
        m1.write(a.a());
_L4:
        return;
_L2:
        if (a.d())
        {
            int i = 0;
            while (i < a.c()) 
            {
                m1.write(a.a(i));
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ArrayList b(b b1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = b1.f().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            j j1 = (j)iterator.next();
            if (j1.h() == null && !com.android.camera.exif.c.a(j1.b()))
            {
                b1.b(j1.b(), j1.a());
                arraylist.add(j1);
            }
        } while (true);
        return arraylist;
    }

    private void b()
    {
        Object obj2 = a.b(0);
        k k1 = ((k) (obj2));
        if (obj2 == null)
        {
            k1 = new k(0);
            a.a(k1);
        }
        obj2 = g.e(c.C);
        if (obj2 == null)
        {
            throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(c.C).toString());
        }
        k1.a(((j) (obj2)));
        k k2 = a.b(2);
        obj2 = k2;
        if (k2 == null)
        {
            obj2 = new k(2);
            a.a(((k) (obj2)));
        }
        if (a.b(4) != null)
        {
            j j2 = g.e(c.D);
            if (j2 == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(c.D).toString());
            }
            k1.a(j2);
        }
        if (a.b(3) != null)
        {
            j j1 = g.e(c.am);
            if (j1 == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(c.am).toString());
            }
            ((k) (obj2)).a(j1);
        }
        obj2 = a.b(1);
        if (a.b())
        {
            Object obj = obj2;
            if (obj2 == null)
            {
                obj = new k(1);
                a.a(((k) (obj)));
            }
            obj2 = g.e(c.E);
            if (obj2 == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(c.E).toString());
            }
            ((k) (obj)).a(((j) (obj2)));
            obj2 = g.e(c.F);
            if (obj2 == null)
            {
                throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(c.F).toString());
            }
            ((j) (obj2)).d(a.a().length);
            ((k) (obj)).a(((j) (obj2)));
            ((k) (obj)).b(com.android.camera.exif.c.a(c.i));
            ((k) (obj)).b(com.android.camera.exif.c.a(c.m));
        } else
        {
            if (a.d())
            {
                Object obj1 = obj2;
                if (obj2 == null)
                {
                    obj1 = new k(1);
                    a.a(((k) (obj1)));
                }
                int i = a.c();
                obj2 = g.e(c.i);
                if (obj2 == null)
                {
                    throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(c.i).toString());
                }
                j j3 = g.e(c.m);
                if (j3 == null)
                {
                    throw new IOException((new StringBuilder()).append("No definition for crucial exif tag: ").append(c.m).toString());
                }
                long al[] = new long[i];
                for (int i1 = 0; i1 < a.c(); i1++)
                {
                    al[i1] = a.a(i1).length;
                }

                j3.a(al);
                ((k) (obj1)).a(((j) (obj2)));
                ((k) (obj1)).a(j3);
                ((k) (obj1)).b(com.android.camera.exif.c.a(c.E));
                ((k) (obj1)).b(com.android.camera.exif.c.a(c.F));
                return;
            }
            if (obj2 != null)
            {
                ((k) (obj2)).b(com.android.camera.exif.c.a(c.i));
                ((k) (obj2)).b(com.android.camera.exif.c.a(c.m));
                ((k) (obj2)).b(com.android.camera.exif.c.a(c.E));
                ((k) (obj2)).b(com.android.camera.exif.c.a(c.F));
                return;
            }
        }
    }

    private void b(m m1)
    {
        a(a.b(0), m1);
        a(a.b(2), m1);
        k k1 = a.b(3);
        if (k1 != null)
        {
            a(k1, m1);
        }
        k1 = a.b(4);
        if (k1 != null)
        {
            a(k1, m1);
        }
        if (a.b(1) != null)
        {
            a(a.b(1), m1);
        }
    }

    private int c()
    {
        k k1 = a.b(0);
        int i = a(k1, 8);
        k1.a(com.android.camera.exif.c.a(c.C)).d(i);
        k k2 = a.b(2);
        int i1 = a(k2, i);
        k k3 = a.b(3);
        i = i1;
        if (k3 != null)
        {
            k2.a(com.android.camera.exif.c.a(c.am)).d(i1);
            i = a(k3, i1);
        }
        k2 = a.b(4);
        i1 = i;
        if (k2 != null)
        {
            k1.a(com.android.camera.exif.c.a(c.D)).d(i);
            i1 = a(k2, i);
        }
        k2 = a.b(1);
        i = i1;
        if (k2 != null)
        {
            k1.a(i1);
            i = a(k2, i1);
        }
        if (a.b())
        {
            k2.a(com.android.camera.exif.c.a(c.E)).d(i);
            return a.a().length + i;
        }
        if (a.d())
        {
            long al[] = new long[a.c()];
            boolean flag = false;
            int j1 = i;
            for (i = ((flag) ? 1 : 0); i < a.c(); i++)
            {
                al[i] = j1;
                j1 += a.a(i).length;
            }

            k2.a(com.android.camera.exif.c.a(c.i)).a(al);
            return j1;
        } else
        {
            return i;
        }
    }

    protected void a(b b1)
    {
        a = b1;
    }

    public void write(int i)
    {
        e[0] = (byte)(i & 0xff);
        write(e);
    }

    public void write(byte abyte0[])
    {
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int i1)
    {
_L5:
        if (c <= 0 && d <= 0 && b == 2 || i1 <= 0) goto _L2; else goto _L1
_L1:
        int i2 = i;
        int j1 = i1;
        if (c > 0)
        {
            if (i1 > c)
            {
                j1 = c;
            } else
            {
                j1 = i1;
            }
            i1 -= j1;
            c = c - j1;
            i2 = i + j1;
            j1 = i1;
        }
        i = i2;
        i1 = j1;
        if (d > 0)
        {
            if (j1 > d)
            {
                i = d;
            } else
            {
                i = j1;
            }
            out.write(abyte0, i2, i);
            i1 = j1 - i;
            d = d - i;
            i = i2 + i;
        }
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        return;
_L4:
        b;
        JVM INSTR tableswitch 0 1: default 180
    //                   0 183
    //                   1 281;
           goto _L5 _L6 _L7
_L6:
        int k1 = a(2, abyte0, i, i1);
        i += k1;
        i1 -= k1;
        if (f.position() < 2) goto _L3; else goto _L8
_L8:
        f.rewind();
        if (f.getShort() != -40)
        {
            throw new IOException("Not a valid jpeg image, cannot write exif");
        }
        out.write(f.array(), 0, 2);
        b = 1;
        f.rewind();
        a();
          goto _L5
_L7:
        int l1 = a(4, abyte0, i, i1);
        i += l1;
        i1 -= l1;
        if (f.position() == 2 && f.getShort() == -39)
        {
            out.write(f.array(), 0, 2);
            f.rewind();
        }
        if (f.position() < 4) goto _L3; else goto _L9
_L9:
        f.rewind();
        short word0 = f.getShort();
        if (word0 == -31)
        {
            c = (f.getShort() & 0xffff) - 2;
            b = 2;
        } else
        if (!l.a(word0))
        {
            out.write(f.array(), 0, 4);
            d = (f.getShort() & 0xffff) - 2;
        } else
        {
            out.write(f.array(), 0, 4);
            b = 2;
        }
        f.rewind();
          goto _L5
_L2:
        if (i1 > 0)
        {
            out.write(abyte0, i, i1);
            return;
        }
          goto _L3
    }
}
