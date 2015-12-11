// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class amy
    implements Closeable
{
    static class a
    {

        static final a a = new a(0, 0);
        final int b;
        final int c;

        public String toString()
        {
            return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("position = ").append(b).append(", length = ").append(c).append("]").toString();
        }


        a(int i, int j)
        {
            b = i;
            c = j;
        }
    }

    private final class b extends InputStream
    {

        final amy a;
        private int b;
        private int c;

        public int read()
            throws IOException
        {
            if (c == 0)
            {
                return -1;
            } else
            {
                amy.a(a).seek(b);
                int i = amy.a(a).read();
                b = amy.a(a, b + 1);
                c = c - 1;
                return i;
            }
        }

        public int read(byte abyte0[], int i, int j)
            throws IOException
        {
            amy.a(abyte0, "buffer");
            if ((i | j) < 0 || j > abyte0.length - i)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (c > 0)
            {
                int k = j;
                if (j > c)
                {
                    k = c;
                }
                amy.a(a, b, abyte0, i, k);
                b = amy.a(a, b + k);
                c = c - k;
                return k;
            } else
            {
                return -1;
            }
        }

        private b(a a1)
        {
            a = amy.this;
            super();
            b = amy.a(amy.this, a1.b + 4);
            c = a1.c;
        }

    }

    public static interface c
    {

        public abstract void read(InputStream inputstream, int i)
            throws IOException;
    }


    private static final Logger b = Logger.getLogger(android/support/v7/amy.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private a e;
    private a f;
    private final byte g[] = new byte[16];

    public amy(File file)
        throws IOException
    {
        if (!file.exists())
        {
            a(file);
        }
        c = b(file);
        e();
    }

    static int a(amy amy1, int i)
    {
        return amy1.b(i);
    }

    private static int a(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    private a a(int i)
        throws IOException
    {
        if (i == 0)
        {
            return a.a;
        } else
        {
            c.seek(i);
            return new a(i, c.readInt());
        }
    }

    static RandomAccessFile a(amy amy1)
    {
        return amy1.c;
    }

    static Object a(Object obj, String s)
    {
        return b(obj, s);
    }

    private void a(int i, int j, int k, int l)
        throws IOException
    {
        a(g, new int[] {
            i, j, k, l
        });
        c.seek(0L);
        c.write(g);
    }

    private void a(int i, byte abyte0[], int j, int k)
        throws IOException
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

    static void a(amy amy1, int i, byte abyte0[], int j, int k)
        throws IOException
    {
        amy1.b(i, abyte0, j, k);
    }

    private static void a(File file)
        throws IOException
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
        throws FileNotFoundException
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
        throws IOException
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
        throws IOException
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
            f = new a(i, f.c);
        } else
        {
            a(k, d, e.b, f.b);
        }
        a = k;
    }

    private void d(int i)
        throws IOException
    {
        c.setLength(i);
        c.getChannel().force(true);
    }

    private void e()
        throws IOException
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

    public void a(c c1)
        throws IOException
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
        a a1 = a(j);
        c1.read(new b(a1), a1.c);
        j = a1.b;
        j = b(a1.c + (j + 4));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        c1;
        throw c1;
    }

    public void a(byte abyte0[])
        throws IOException
    {
        a(abyte0, 0, abyte0.length);
    }

    public void a(byte abyte0[], int i, int j)
        throws IOException
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
        a a1;
        a1 = new a(k, j);
        b(g, 0, j);
        a(a1.b, g, 0, 4);
        a(a1.b + 4, abyte0, i, j);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        i = a1.b;
_L4:
        a(a, d + 1, i, a1.b);
        f = a1;
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
        throws IOException
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
        e = new a(i, j);
          goto _L1
    }

    public void close()
        throws IOException
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
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        a(4096, 0, 0, 0);
        d = 0;
        e = a.a;
        f = a.a;
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
            a(new c(stringbuilder) {

                boolean a;
                final StringBuilder b;
                final amy c;

                public void read(InputStream inputstream, int i)
                    throws IOException
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
                c = amy.this;
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
