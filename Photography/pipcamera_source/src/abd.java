// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class abd
    implements Closeable
{

    private static final Logger b = Logger.getLogger(abd.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private abe e;
    private abe f;
    private final byte g[] = new byte[16];

    public abd(File file)
    {
        if (!file.exists())
        {
            a(file);
        }
        c = b(file);
        e();
    }

    static int a(abd abd1, int i)
    {
        return abd1.b(i);
    }

    private static int a(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    private abe a(int i)
    {
        if (i == 0)
        {
            return abe.a;
        } else
        {
            c.seek(i);
            return new abe(i, c.readInt());
        }
    }

    static RandomAccessFile a(abd abd1)
    {
        return abd1.c;
    }

    static Object a(Object obj, String s)
    {
        return b(obj, s);
    }

    private void a(int i, int j, int k, int l)
    {
        a(g, new int[] {
            i, j, k, l
        });
        c.seek(0L);
        c.write(g);
    }

    private void a(int i, byte abyte0[], int j, int k)
    {
        i = b(i);
        if (i + k <= a)
        {
            c.seek(i);
            c.write(abyte0, j, k);
            return;
        } else
        {
            int l = a - i;
            c.seek(i);
            c.write(abyte0, j, l);
            c.seek(16L);
            c.write(abyte0, j + l, k - l);
            return;
        }
    }

    static void a(abd abd1, int i, byte abyte0[], int j, int k)
    {
        abd1.b(i, abyte0, j, k);
    }

    private static void a(File file)
    {
        RandomAccessFile randomaccessfile;
        File file1;
        file1 = new File((new StringBuilder()).append(file.getPath()).append(".tmp").toString());
        randomaccessfile = b(file1);
        randomaccessfile.setLength(4096L);
        randomaccessfile.seek(0L);
        byte abyte0[] = new byte[16];
        a(abyte0, new int[] {
            4096, 0, 0, 0
        });
        randomaccessfile.write(abyte0);
        randomaccessfile.close();
        if (!file1.renameTo(file))
        {
            throw new IOException("Rename failed!");
        } else
        {
            return;
        }
        file;
        randomaccessfile.close();
        throw file;
    }

    private static transient void a(byte abyte0[], int ai[])
    {
        int i = 0;
        int k = ai.length;
        int j = 0;
        for (; i < k; i++)
        {
            b(abyte0, j, ai[i]);
            j += 4;
        }

    }

    private int b(int i)
    {
        if (i < a)
        {
            return i;
        } else
        {
            return (i + 16) - a;
        }
    }

    private static RandomAccessFile b(File file)
    {
        return new RandomAccessFile(file, "rwd");
    }

    private static Object b(Object obj, String s)
    {
        if (obj == null)
        {
            throw new NullPointerException(s);
        } else
        {
            return obj;
        }
    }

    private void b(int i, byte abyte0[], int j, int k)
    {
        i = b(i);
        if (i + k <= a)
        {
            c.seek(i);
            c.readFully(abyte0, j, k);
            return;
        } else
        {
            int l = a - i;
            c.seek(i);
            c.readFully(abyte0, j, l);
            c.seek(16L);
            c.readFully(abyte0, j + l, k - l);
            return;
        }
    }

    private static void b(byte abyte0[], int i, int j)
    {
        abyte0[i] = (byte)(j >> 24);
        abyte0[i + 1] = (byte)(j >> 16);
        abyte0[i + 2] = (byte)(j >> 8);
        abyte0[i + 3] = (byte)j;
    }

    private void c(int i)
    {
        int i1 = i + 4;
        i = f();
        if (i >= i1)
        {
            return;
        }
        int j = a;
        int k;
        int l;
        do
        {
            l = i + j;
            k = j << 1;
            j = k;
            i = l;
        } while (l < i1);
        d(k);
        i = b(f.b + 4 + f.c);
        if (i < e.b)
        {
            FileChannel filechannel = c.getChannel();
            filechannel.position(a);
            i -= 4;
            if (filechannel.transferTo(16L, i, filechannel) != (long)i)
            {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        if (f.b < e.b)
        {
            i = (a + f.b) - 16;
            a(k, d, e.b, i);
            f = new abe(i, f.c);
        } else
        {
            a(k, d, e.b, f.b);
        }
        a = k;
    }

    private void d(int i)
    {
        c.setLength(i);
        c.getChannel().force(true);
    }

    private void e()
    {
        c.seek(0L);
        c.readFully(g);
        a = a(g, 0);
        if ((long)a > c.length())
        {
            throw new IOException((new StringBuilder()).append("File is truncated. Expected length: ").append(a).append(", Actual length: ").append(c.length()).toString());
        } else
        {
            d = a(g, 4);
            int i = a(g, 8);
            int j = a(g, 12);
            e = a(i);
            f = a(j);
            return;
        }
    }

    private int f()
    {
        return a - a();
    }

    public int a()
    {
        if (d == 0)
        {
            return 16;
        }
        if (f.b >= e.b)
        {
            return (f.b - e.b) + 4 + f.c + 16;
        } else
        {
            return (f.b + 4 + f.c + a) - e.b;
        }
    }

    public void a(abg abg1)
    {
        this;
        JVM INSTR monitorenter ;
        int j = e.b;
        int i = 0;
_L2:
        if (i >= d)
        {
            break; /* Loop/switch isn't completed */
        }
        abe abe1 = a(j);
        abg1.read(new abf(this, abe1), abe1.c);
        j = abe1.b;
        j = b(abe1.c + (j + 4));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        abg1;
        throw abg1;
    }

    public void a(byte abyte0[])
    {
        a(abyte0, 0, abyte0.length);
    }

    public void a(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        b(abyte0, "buffer");
        if ((i | j) < 0)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        if (j <= abyte0.length - i)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        throw new IndexOutOfBoundsException();
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        boolean flag;
        c(j);
        flag = b();
        if (!flag) goto _L2; else goto _L1
_L1:
        int k = 16;
_L3:
        abe abe1;
        abe1 = new abe(k, j);
        b(g, 0, j);
        a(abe1.b, g, 0, 4);
        a(abe1.b + 4, abyte0, i, j);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        i = abe1.b;
_L4:
        a(a, d + 1, i, abe1.b);
        f = abe1;
        d = d + 1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        e = f;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        k = b(f.b + 4 + f.c);
          goto _L3
        i = e.b;
          goto _L4
    }

    public boolean a(int i, int j)
    {
        return a() + 4 + i <= j;
    }

    public boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        int i = d;
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (b())
        {
            throw new NoSuchElementException();
        }
        break MISSING_BLOCK_LABEL_22;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (d != 1)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        d();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        int i = b(e.b + 4 + e.c);
        b(i, g, 0, 4);
        int j = a(g, 0);
        a(a, d - 1, i, f.b);
        d = d - 1;
        e = new abe(i, j);
          goto _L1
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        c.close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        a(4096, 0, 0, 0);
        d = 0;
        e = abe.a;
        f = abe.a;
        if (a > 4096)
        {
            d(4096);
        }
        a = 4096;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append('[');
        stringbuilder.append("fileLength=").append(a);
        stringbuilder.append(", size=").append(d);
        stringbuilder.append(", first=").append(e);
        stringbuilder.append(", last=").append(f);
        stringbuilder.append(", element lengths=[");
        try
        {
            a(new abg(stringbuilder) {

                boolean a;
                final StringBuilder b;
                final abd c;

                public void read(InputStream inputstream, int i)
                {
                    if (a)
                    {
                        a = false;
                    } else
                    {
                        b.append(", ");
                    }
                    b.append(i);
                }

            
            {
                c = abd.this;
                b = stringbuilder;
                super();
                a = true;
            }
            });
        }
        catch (IOException ioexception)
        {
            b.log(Level.WARNING, "read error", ioexception);
        }
        stringbuilder.append("]]");
        return stringbuilder.toString();
    }

}
