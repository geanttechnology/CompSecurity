// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.p;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.List;

// Referenced classes of package myobfuscated.p:
//            d, c

public final class e
{

    public final byte a[] = new byte[256];
    public ByteBuffer b;
    public d c;
    public int d;

    public e()
    {
        d = 0;
    }

    private int[] a(int i)
    {
        int ai[];
        byte abyte0[];
        int k;
        k = 0;
        ai = null;
        abyte0 = new byte[i * 3];
        int ai1[];
        b.get(abyte0);
        ai1 = new int[256];
        int j = 0;
        do
        {
            ai = ai1;
            if (j >= i)
            {
                break;
            }
            int i1 = k + 1;
            byte byte0 = abyte0[k];
            int l = i1 + 1;
            i1 = abyte0[i1];
            k = l + 1;
            ai1[j] = (byte0 & 0xff) << 16 | 0xff000000 | (i1 & 0xff) << 8 | abyte0[l] & 0xff;
            j++;
        } while (true);
        break MISSING_BLOCK_LABEL_132;
        BufferUnderflowException bufferunderflowexception;
        bufferunderflowexception;
        Log.isLoggable("GifHeaderParser", 3);
        c.b = 1;
        return ai;
    }

    private void d()
    {
        do
        {
            f();
        } while (d > 0 && !c());
    }

    private void e()
    {
        int i;
        do
        {
            i = g();
            b.position(b.position() + i);
        } while (i > 0);
    }

    private int f()
    {
        int i;
        int l;
        l = 0;
        i = 0;
        d = g();
        if (d <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L3:
        int k;
        k = j;
        l = i;
        if (i >= d)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        j = d - i;
        k = j;
        b.get(a, i, j);
        i += j;
        if (true) goto _L3; else goto _L2
        Exception exception;
        exception;
        if (Log.isLoggable("GifHeaderParser", 3))
        {
            (new StringBuilder("Error Reading Block n: ")).append(i).append(" count: ").append(k).append(" blockSize: ").append(d);
        }
        c.b = 1;
        l = i;
_L2:
        return l;
    }

    private int g()
    {
        byte byte0;
        try
        {
            byte0 = b.get();
        }
        catch (Exception exception)
        {
            c.b = 1;
            return 0;
        }
        return byte0 & 0xff;
    }

    public final void a()
    {
        boolean flag = false;
        do
        {
            if (flag || c() || c.c > 0x7fffffff)
            {
                break;
            }
            switch (g())
            {
            default:
                c.b = 1;
                continue;

            case 44: // ','
                if (c.d == null)
                {
                    c.d = new c();
                }
                c.d.a = b.getShort();
                c.d.b = b.getShort();
                c.d.c = b.getShort();
                c.d.d = b.getShort();
                int k = g();
                c c1;
                boolean flag1;
                int l;
                boolean flag2;
                if ((k & 0x80) != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                l = (int)Math.pow(2D, (k & 7) + 1);
                c1 = c.d;
                if ((k & 0x40) != 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                c1.e = flag2;
                if (flag1)
                {
                    c.d.k = a(l);
                } else
                {
                    c.d.k = null;
                }
                c.d.j = b.position();
                g();
                e();
                if (!c())
                {
                    d d1 = c;
                    d1.c = d1.c + 1;
                    c.e.add(c.d);
                }
                continue;

            case 33: // '!'
                switch (g())
                {
                default:
                    e();
                    break;

                case 249: 
                    c.d = new c();
                    g();
                    int i = g();
                    c.d.g = (i & 0x1c) >> 2;
                    if (c.d.g == 0)
                    {
                        c.d.g = 1;
                    }
                    c c2 = c.d;
                    short word0;
                    boolean flag3;
                    if ((i & 1) != 0)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    c2.f = flag3;
                    word0 = b.getShort();
                    i = word0;
                    if (word0 < 2)
                    {
                        i = 10;
                    }
                    c.d.i = i * 10;
                    c.d.h = g();
                    g();
                    break;

                case 255: 
                    f();
                    String s = "";
                    for (int j = 0; j < 11; j++)
                    {
                        s = (new StringBuilder()).append(s).append((char)a[j]).toString();
                    }

                    if (s.equals("NETSCAPE2.0"))
                    {
                        d();
                    } else
                    {
                        e();
                    }
                    break;

                case 254: 
                    e();
                    break;

                case 1: // '\001'
                    e();
                    break;
                }
                break;

            case 59: // ';'
                flag = true;
                break;
            }
        } while (true);
    }

    public final void b()
    {
        boolean flag = true;
        String s = "";
        for (int i = 0; i < 6; i++)
        {
            s = (new StringBuilder()).append(s).append((char)g()).toString();
        }

        if (!s.startsWith("GIF"))
        {
            c.b = 1;
        } else
        {
            c.f = b.getShort();
            c.g = b.getShort();
            int j = g();
            d d1 = c;
            if ((j & 0x80) == 0)
            {
                flag = false;
            }
            d1.h = flag;
            c.i = 2 << (j & 7);
            c.j = g();
            g();
            if (c.h && !c())
            {
                c.a = a(c.i);
                c.k = c.a[c.j];
                return;
            }
        }
    }

    public final boolean c()
    {
        return c.b != 0;
    }
}
