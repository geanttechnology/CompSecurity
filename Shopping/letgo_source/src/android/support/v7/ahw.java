// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.support.v7:
//            ahz, ahy

final class ahw
    implements Closeable
{
    public final class a
    {

        final ahw a;
        private final b b;
        private final boolean c[];
        private boolean d;
        private boolean e;

        static b a(a a1)
        {
            return a1.b;
        }

        static boolean a(a a1, boolean flag)
        {
            a1.d = flag;
            return flag;
        }

        static boolean[] b(a a1)
        {
            return a1.c;
        }

        public OutputStream a(int i1)
            throws IOException
        {
            ahw ahw1 = a;
            ahw1;
            JVM INSTR monitorenter ;
            if (b.a(b) != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            ahw1;
            JVM INSTR monitorexit ;
            throw obj;
            File file;
            if (!b.d(b))
            {
                c[i1] = true;
            }
            file = b.b(i1);
            Object obj1 = new FileOutputStream(file);
_L1:
            obj1 = new a(this, ((OutputStream) (obj1)));
            ahw1;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
            obj1;
            ahw.g(a).mkdirs();
            obj1 = new FileOutputStream(file);
              goto _L1
            obj1;
            obj1 = ahw.b();
            ahw1;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
        }

        public void a()
            throws IOException
        {
            if (d)
            {
                ahw.a(a, this, false);
                a.c(b.c(b));
            } else
            {
                ahw.a(a, this, true);
            }
            e = true;
        }

        public void b()
            throws IOException
        {
            ahw.a(a, this, false);
        }

        private a(b b1)
        {
            a = ahw.this;
            super();
            b = b1;
            if (b.d(b1))
            {
                ahw1 = null;
            } else
            {
                ahw1 = new boolean[ahw.f(ahw.this)];
            }
            c = ahw.this;
        }

    }

    private class a.a extends FilterOutputStream
    {

        final a a;

        public void close()
        {
            try
            {
                out.close();
                return;
            }
            catch (IOException ioexception)
            {
                a.a(a, true);
            }
        }

        public void flush()
        {
            try
            {
                out.flush();
                return;
            }
            catch (IOException ioexception)
            {
                a.a(a, true);
            }
        }

        public void write(int i1)
        {
            try
            {
                out.write(i1);
                return;
            }
            catch (IOException ioexception)
            {
                a.a(a, true);
            }
        }

        public void write(byte abyte0[], int i1, int j1)
        {
            try
            {
                out.write(abyte0, i1, j1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                a.a(a, true);
            }
        }

        private a.a(a a1, OutputStream outputstream)
        {
            a = a1;
            super(outputstream);
        }

    }

    private final class b
    {

        final ahw a;
        private final String b;
        private final long c[];
        private boolean d;
        private a e;
        private long f;

        static long a(b b1, long l1)
        {
            b1.f = l1;
            return l1;
        }

        static a a(b b1)
        {
            return b1.e;
        }

        static a a(b b1, a a1)
        {
            b1.e = a1;
            return a1;
        }

        static void a(b b1, String as[])
            throws IOException
        {
            b1.a(as);
        }

        private void a(String as[])
            throws IOException
        {
            if (as.length != ahw.f(a))
            {
                throw b(as);
            }
            int i1 = 0;
            do
            {
                try
                {
                    if (i1 >= as.length)
                    {
                        break;
                    }
                    c[i1] = Long.parseLong(as[i1]);
                }
                catch (NumberFormatException numberformatexception)
                {
                    throw b(as);
                }
                i1++;
            } while (true);
        }

        static boolean a(b b1, boolean flag)
        {
            b1.d = flag;
            return flag;
        }

        private IOException b(String as[])
            throws IOException
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
        }

        static long[] b(b b1)
        {
            return b1.c;
        }

        static String c(b b1)
        {
            return b1.b;
        }

        static boolean d(b b1)
        {
            return b1.d;
        }

        static long e(b b1)
        {
            return b1.f;
        }

        public File a(int i1)
        {
            return new File(ahw.g(a), (new StringBuilder()).append(b).append(".").append(i1).toString());
        }

        public String a()
            throws IOException
        {
            StringBuilder stringbuilder = new StringBuilder();
            long al[] = c;
            int j1 = al.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                long l1 = al[i1];
                stringbuilder.append(' ').append(l1);
            }

            return stringbuilder.toString();
        }

        public File b(int i1)
        {
            return new File(ahw.g(a), (new StringBuilder()).append(b).append(".").append(i1).append(".tmp").toString());
        }

        private b(String s)
        {
            a = ahw.this;
            super();
            b = s;
            c = new long[ahw.f(ahw.this)];
        }

    }

    public final class c
        implements Closeable
    {

        final ahw a;
        private final String b;
        private final long c;
        private File d[];
        private final InputStream e[];
        private final long f[];

        public File a(int i1)
        {
            return d[i1];
        }

        public void close()
        {
            InputStream ainputstream[] = e;
            int j1 = ainputstream.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                ahz.a(ainputstream[i1]);
            }

        }

        private c(String s, long l1, File afile[], InputStream ainputstream[], long al[])
        {
            a = ahw.this;
            super();
            b = s;
            c = l1;
            d = afile;
            e = ainputstream;
            f = al;
        }

        c(String s, long l1, File afile[], InputStream ainputstream[], long al[], 
                _cls1 _pcls1)
        {
            this(s, l1, afile, ainputstream, al);
        }
    }


    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream r = new OutputStream() {

        public void write(int i1)
            throws IOException
        {
        }

    };
    final ThreadPoolExecutor b;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private int i;
    private final int j;
    private long k;
    private int l;
    private Writer m;
    private final LinkedHashMap n = new LinkedHashMap(0, 0.75F, true);
    private int o;
    private long p;
    private final Callable q = new Callable() {

        final ahw a;

        public Void a()
            throws Exception
        {
label0:
            {
                synchronized (a)
                {
                    if (ahw.a(a) != null)
                    {
                        break label0;
                    }
                }
                return null;
            }
            ahw.b(a);
            ahw.c(a);
            if (ahw.d(a))
            {
                ahw.e(a);
                ahw.a(a, 0);
            }
            ahw1;
            JVM INSTR monitorexit ;
            return null;
            exception;
            ahw1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public Object call()
            throws Exception
        {
            return a();
        }

            
            {
                a = ahw.this;
                super();
            }
    };

    private ahw(File file, int i1, int j1, long l1, int k1)
    {
        k = 0L;
        l = 0;
        p = 0L;
        b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c = file;
        g = i1;
        d = new File(file, "journal");
        e = new File(file, "journal.tmp");
        f = new File(file, "journal.bkp");
        j = j1;
        h = l1;
        i = k1;
    }

    static int a(ahw ahw1, int i1)
    {
        ahw1.o = i1;
        return i1;
    }

    private a a(String s, long l1)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        b b1;
        g();
        e(s);
        b1 = (b)n.get(s);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (b1 == null) goto _L4; else goto _L3
_L3:
        long l2 = b.e(b1);
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (b1 != null) goto _L6; else goto _L5
_L5:
        b1 = new b(s);
        n.put(s, b1);
_L8:
        a a1;
        a1 = new a(b1);
        b.a(b1, a1);
        m.write((new StringBuilder()).append("DIRTY ").append(s).append('\n').toString());
        m.flush();
        s = a1;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L6:
        a1 = b.a(b1);
        if (a1 == null) goto _L8; else goto _L7
_L7:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static ahw a(File file, int i1, int j1, long l1, int k1)
        throws IOException
    {
        Object obj;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (k1 <= 0)
        {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        obj = new File(file, "journal.bkp");
        if (((File) (obj)).exists())
        {
            File file1 = new File(file, "journal");
            if (file1.exists())
            {
                ((File) (obj)).delete();
            } else
            {
                a(((File) (obj)), file1, false);
            }
        }
        obj = new ahw(file, i1, j1, l1, k1);
        if (!((ahw) (obj)).d.exists())
        {
            break MISSING_BLOCK_LABEL_227;
        }
        ((ahw) (obj)).c();
        ((ahw) (obj)).d();
        obj.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((ahw) (obj)).d, true), ahz.a));
        return ((ahw) (obj));
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder()).append("DiskLruCache ").append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((ahw) (obj)).a();
        file.mkdirs();
        file = new ahw(file, i1, j1, l1, k1);
        file.e();
        return file;
    }

    static Writer a(ahw ahw1)
    {
        return ahw1.m;
    }

    private void a(a a1, boolean flag)
        throws IOException
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        b b1;
        b1 = a.a(a1);
        if (b.a(b1) != a1)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        int j1 = ((flag1) ? 1 : 0);
        if (!flag) goto _L2; else goto _L1
_L1:
        j1 = ((flag1) ? 1 : 0);
        if (b.d(b1)) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L7:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= j) goto _L2; else goto _L4
_L4:
        if (!a.b(a1)[i1])
        {
            a1.b();
            throw new IllegalStateException((new StringBuilder()).append("Newly created entry didn't create value for index ").append(i1).toString());
        }
        if (b1.b(i1).exists()) goto _L6; else goto _L5
_L5:
        a1.b();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        i1++;
          goto _L7
_L2:
        File file;
        long l1;
        long l2;
        for (; j1 >= j; j1++)
        {
            break MISSING_BLOCK_LABEL_238;
        }

        a1 = b1.b(j1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        if (a1.exists())
        {
            file = b1.a(j1);
            a1.renameTo(file);
            l1 = b.b(b1)[j1];
            l2 = file.length();
            b.b(b1)[j1] = l2;
            k = (k - l1) + l2;
            l = l + 1;
        }
        break MISSING_BLOCK_LABEL_438;
        a(((File) (a1)));
        break MISSING_BLOCK_LABEL_438;
        o = o + 1;
        b.a(b1, null);
        if (!(b.d(b1) | flag))
        {
            break MISSING_BLOCK_LABEL_388;
        }
        b.a(b1, true);
        m.write((new StringBuilder()).append("CLEAN ").append(b.c(b1)).append(b1.a()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        l1 = p;
        p = 1L + l1;
        b.a(b1, l1);
_L9:
        m.flush();
        if (k > h || l > i || f())
        {
            b.submit(q);
        }
          goto _L8
        n.remove(b.c(b1));
        m.write((new StringBuilder()).append("REMOVE ").append(b.c(b1)).append('\n').toString());
          goto _L9
    }

    static void a(ahw ahw1, a a1, boolean flag)
        throws IOException
    {
        ahw1.a(a1, flag);
    }

    private static void a(File file)
        throws IOException
    {
        if (file.exists() && !file.delete())
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private static void a(File file, File file1, boolean flag)
        throws IOException
    {
        if (flag)
        {
            a(file1);
        }
        if (!file.renameTo(file1))
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    static OutputStream b()
    {
        return r;
    }

    static void b(ahw ahw1)
        throws IOException
    {
        ahw1.h();
    }

    private void c()
        throws IOException
    {
        ahy ahy1 = new ahy(new FileInputStream(d), ahz.a);
        String s = ahy1.a();
        String s1 = ahy1.a();
        String s2 = ahy1.a();
        String s3 = ahy1.a();
        String s4 = ahy1.a();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(g).equals(s2) || !Integer.toString(j).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        break MISSING_BLOCK_LABEL_184;
        Object obj;
        obj;
        ahz.a(ahy1);
        throw obj;
        int i1 = 0;
_L2:
        d(ahy1.a());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        o = i1 - n.size();
        ahz.a(ahy1);
        return;
    }

    static void c(ahw ahw1)
        throws IOException
    {
        ahw1.i();
    }

    private void d()
        throws IOException
    {
        a(e);
        for (Iterator iterator = n.values().iterator(); iterator.hasNext();)
        {
            b b1 = (b)iterator.next();
            if (b.a(b1) == null)
            {
                int i1 = 0;
                while (i1 < j) 
                {
                    k = k + b.b(b1)[i1];
                    l = l + 1;
                    i1++;
                }
            } else
            {
                b.a(b1, null);
                for (int j1 = 0; j1 < j; j1++)
                {
                    a(b1.a(j1));
                    a(b1.b(j1));
                }

                iterator.remove();
            }
        }

    }

    private void d(String s)
        throws IOException
    {
        int i1;
        int j1;
        int k1;
        i1 = s.indexOf(' ');
        if (i1 == -1)
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
        }
        j1 = i1 + 1;
        k1 = s.indexOf(' ', j1);
        if (k1 != -1) goto _L2; else goto _L1
_L1:
        String s1 = s.substring(j1);
        if (i1 != "REMOVE".length() || !s.startsWith("REMOVE")) goto _L4; else goto _L3
_L3:
        n.remove(s1);
_L6:
        return;
_L2:
        s1 = s.substring(j1, k1);
_L4:
        b b2 = (b)n.get(s1);
        b b1 = b2;
        if (b2 == null)
        {
            b1 = new b(s1);
            n.put(s1, b1);
        }
        if (k1 != -1 && i1 == "CLEAN".length() && s.startsWith("CLEAN"))
        {
            s = s.substring(k1 + 1).split(" ");
            b.a(b1, true);
            b.a(b1, null);
            b.a(b1, s);
            return;
        }
        if (k1 == -1 && i1 == "DIRTY".length() && s.startsWith("DIRTY"))
        {
            b.a(b1, new a(b1));
            return;
        }
        if (k1 != -1 || i1 != "READ".length() || !s.startsWith("READ"))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean d(ahw ahw1)
    {
        return ahw1.f();
    }

    private void e()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (m != null)
        {
            m.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e), ahz.a));
        Iterator iterator;
        ((Writer) (obj)).write("libcore.io.DiskLruCache");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("1");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(g));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(j));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("\n");
        iterator = n.values().iterator();
_L1:
        b b1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_243;
            }
            b1 = (b)iterator.next();
            if (b.a(b1) == null)
            {
                break MISSING_BLOCK_LABEL_201;
            }
            ((Writer) (obj)).write((new StringBuilder()).append("DIRTY ").append(b.c(b1)).append('\n').toString());
        } while (true);
        Exception exception;
        exception;
        ((Writer) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder()).append("CLEAN ").append(b.c(b1)).append(b1.a()).append('\n').toString());
          goto _L1
        ((Writer) (obj)).close();
        if (d.exists())
        {
            a(d, f, true);
        }
        a(e, d, false);
        f.delete();
        m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, true), ahz.a));
        this;
        JVM INSTR monitorexit ;
    }

    static void e(ahw ahw1)
        throws IOException
    {
        ahw1.e();
    }

    private void e(String s)
    {
        if (!a.matcher(s).matches())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("keys must match regex [a-z0-9_-]{1,64}: \"").append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    static int f(ahw ahw1)
    {
        return ahw1.j;
    }

    private boolean f()
    {
        return o >= 2000 && o >= n.size();
    }

    static File g(ahw ahw1)
    {
        return ahw1.c;
    }

    private void g()
    {
        if (m == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    private void h()
        throws IOException
    {
        while (k > h) 
        {
            c((String)((java.util.Map.Entry)n.entrySet().iterator().next()).getKey());
        }
    }

    private void i()
        throws IOException
    {
        while (l > i) 
        {
            c((String)((java.util.Map.Entry)n.entrySet().iterator().next()).getKey());
        }
    }

    public c a(String s)
        throws IOException
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        b b1;
        g();
        e(s);
        b1 = (b)n.get(s);
        if (b1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
_L8:
        this;
        JVM INSTR monitorexit ;
        return ((c) (obj));
_L2:
        obj = obj1;
        InputStream ainputstream[];
        if (!b.d(b1))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new File[j];
        ainputstream = new InputStream[j];
        int i1 = 0;
_L5:
        if (i1 >= j) goto _L4; else goto _L3
_L3:
        File file = b1.a(i1);
        obj[i1] = file;
        ainputstream[i1] = new FileInputStream(file);
        i1++;
          goto _L5
        s;
        i1 = 0;
_L6:
        obj = obj1;
        if (i1 >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (ainputstream[i1] == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ahz.a(ainputstream[i1]);
        i1++;
        if (true) goto _L6; else goto _L4
_L4:
        o = o + 1;
        m.append((new StringBuilder()).append("READ ").append(s).append('\n').toString());
        if (f())
        {
            b.submit(q);
        }
        obj = new c(s, b.e(b1), ((File []) (obj)), ainputstream, b.b(b1));
        if (true) goto _L8; else goto _L7
_L7:
        s;
        throw s;
    }

    public void a()
        throws IOException
    {
        close();
        ahz.a(c);
    }

    public a b(String s)
        throws IOException
    {
        return a(s, -1L);
    }

    public boolean c(String s)
        throws IOException
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        b b1;
        g();
        e(s);
        b1 = (b)n.get(s);
        if (b1 == null) goto _L2; else goto _L1
_L1:
        Object obj = b.a(b1);
        if (obj == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L5:
        k = k - b.b(b1)[i1];
        l = l - 1;
        b.b(b1)[i1] = 0L;
        i1++;
_L3:
        if (i1 >= j)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = b1.a(i1);
        if (!((File) (obj)).exists() || ((File) (obj)).delete()) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder()).append("failed to delete ").append(obj).toString());
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        o = o + 1;
        m.append((new StringBuilder()).append("REMOVE ").append(s).append('\n').toString());
        n.remove(s);
        if (f())
        {
            b.submit(q);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Writer writer = m;
        if (writer != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = (new ArrayList(n.values())).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (b)iterator.next();
            if (b.a(b1) != null)
            {
                b.a(b1).b();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        throw exception;
        h();
        i();
        m.close();
        m = null;
          goto _L1
    }

}
