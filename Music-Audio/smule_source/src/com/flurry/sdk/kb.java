// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
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

// Referenced classes of package com.flurry.sdk:
//            kd, kc

public final class kb
    implements Closeable
{

    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream p = new OutputStream() {

        public void write(int i1)
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
    private final int i;
    private long j;
    private Writer k;
    private final LinkedHashMap l = new LinkedHashMap(0, 0.75F, true);
    private int m;
    private long n;
    private final Callable o = new Callable() {

        final kb a;

        public Void a()
        {
label0:
            {
                synchronized (a)
                {
                    if (kb.a(a) != null)
                    {
                        break label0;
                    }
                }
                return null;
            }
            kb.b(a);
            if (kb.c(a))
            {
                kb.d(a);
                kb.a(a, 0);
            }
            kb1;
            JVM INSTR monitorexit ;
            return null;
            exception;
            kb1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public Object call()
        {
            return a();
        }

            
            {
                a = kb.this;
                super();
            }
    };

    private kb(File file, int i1, int j1, long l1)
    {
        j = 0L;
        n = 0L;
        b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c = file;
        g = i1;
        d = new File(file, "journal");
        e = new File(file, "journal.tmp");
        f = new File(file, "journal.bkp");
        i = j1;
        h = l1;
    }

    static int a(kb kb1, int i1)
    {
        kb1.m = i1;
        return i1;
    }

    private a a(String s, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        b b1;
        g();
        e(s);
        b1 = (b)l.get(s);
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
        l.put(s, b1);
_L8:
        a a1;
        a1 = new a(b1);
        b.a(b1, a1);
        k.write((new StringBuilder()).append("DIRTY ").append(s).append('\n').toString());
        k.flush();
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

    public static kb a(File file, int i1, int j1, long l1)
    {
        Object obj;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
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
        obj = new kb(file, i1, j1, l1);
        if (!((kb) (obj)).d.exists())
        {
            break MISSING_BLOCK_LABEL_209;
        }
        ((kb) (obj)).c();
        ((kb) (obj)).d();
        obj.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((kb) (obj)).d, true), kd.a));
        return ((kb) (obj));
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder()).append("DiskLruCache ").append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((kb) (obj)).a();
        file.mkdirs();
        file = new kb(file, i1, j1, l1);
        file.e();
        return file;
    }

    static Writer a(kb kb1)
    {
        return kb1.k;
    }

    private void a(a a1, boolean flag)
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
        if (i1 >= i) goto _L2; else goto _L4
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
        for (; j1 >= i; j1++)
        {
            break MISSING_BLOCK_LABEL_228;
        }

        a1 = b1.b(j1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        if (a1.exists())
        {
            file = b1.a(j1);
            a1.renameTo(file);
            l1 = b.b(b1)[j1];
            l2 = file.length();
            b.b(b1)[j1] = l2;
            j = (j - l1) + l2;
        }
        break MISSING_BLOCK_LABEL_417;
        a(((File) (a1)));
        break MISSING_BLOCK_LABEL_417;
        m = m + 1;
        b.a(b1, null);
        if (!(b.d(b1) | flag))
        {
            break MISSING_BLOCK_LABEL_367;
        }
        b.a(b1, true);
        k.write((new StringBuilder()).append("CLEAN ").append(b.c(b1)).append(b1.a()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        l1 = n;
        n = 1L + l1;
        b.a(b1, l1);
_L9:
        k.flush();
        if (j > h || f())
        {
            b.submit(o);
        }
          goto _L8
        l.remove(b.c(b1));
        k.write((new StringBuilder()).append("REMOVE ").append(b.c(b1)).append('\n').toString());
          goto _L9
    }

    static void a(kb kb1, a a1, boolean flag)
    {
        kb1.a(a1, flag);
    }

    private static void a(File file)
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
        return p;
    }

    static void b(kb kb1)
    {
        kb1.h();
    }

    private void c()
    {
        kc kc1 = new kc(new FileInputStream(d), kd.a);
        String s = kc1.a();
        String s1 = kc1.a();
        String s2 = kc1.a();
        String s3 = kc1.a();
        String s4 = kc1.a();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(g).equals(s2) || !Integer.toString(i).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        break MISSING_BLOCK_LABEL_184;
        Object obj;
        obj;
        kd.a(kc1);
        throw obj;
        int i1 = 0;
_L2:
        d(kc1.a());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        m = i1 - l.size();
        kd.a(kc1);
        return;
    }

    static boolean c(kb kb1)
    {
        return kb1.f();
    }

    private void d()
    {
        a(e);
        for (Iterator iterator = l.values().iterator(); iterator.hasNext();)
        {
            b b1 = (b)iterator.next();
            if (b.a(b1) == null)
            {
                int i1 = 0;
                while (i1 < i) 
                {
                    j = j + b.b(b1)[i1];
                    i1++;
                }
            } else
            {
                b.a(b1, null);
                for (int j1 = 0; j1 < i; j1++)
                {
                    a(b1.a(j1));
                    a(b1.b(j1));
                }

                iterator.remove();
            }
        }

    }

    static void d(kb kb1)
    {
        kb1.e();
    }

    private void d(String s)
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
        l.remove(s1);
_L6:
        return;
_L2:
        s1 = s.substring(j1, k1);
_L4:
        b b2 = (b)l.get(s1);
        b b1 = b2;
        if (b2 == null)
        {
            b1 = new b(s1);
            l.put(s1, b1);
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

    static int e(kb kb1)
    {
        return kb1.i;
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (k != null)
        {
            k.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e), kd.a));
        Iterator iterator;
        ((Writer) (obj)).write("libcore.io.DiskLruCache");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("1");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(g));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(i));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("\n");
        iterator = l.values().iterator();
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
        k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, true), kd.a));
        this;
        JVM INSTR monitorexit ;
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

    static File f(kb kb1)
    {
        return kb1.c;
    }

    private boolean f()
    {
        return m >= 2000 && m >= l.size();
    }

    private void g()
    {
        if (k == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    private void h()
    {
        while (j > h) 
        {
            c((String)((java.util.Map.Entry)l.entrySet().iterator().next()).getKey());
        }
    }

    public c a(String s)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        b b1;
        g();
        e(s);
        b1 = (b)l.get(s);
        if (b1 != null) goto _L2; else goto _L1
_L1:
        c c1 = obj;
_L7:
        this;
        JVM INSTR monitorexit ;
        return c1;
_L2:
        c1 = obj;
        InputStream ainputstream[];
        if (!b.d(b1))
        {
            continue; /* Loop/switch isn't completed */
        }
        ainputstream = new InputStream[i];
        int i1 = 0;
_L4:
        if (i1 >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        ainputstream[i1] = new FileInputStream(b1.a(i1));
        i1++;
        if (true) goto _L4; else goto _L3
        s;
        i1 = 0;
_L5:
        c1 = obj;
        if (i1 >= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        c1 = obj;
        if (ainputstream[i1] == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        kd.a(ainputstream[i1]);
        i1++;
        if (true) goto _L5; else goto _L3
_L3:
        m = m + 1;
        k.append((new StringBuilder()).append("READ ").append(s).append('\n').toString());
        if (f())
        {
            b.submit(o);
        }
        c1 = new c(s, b.e(b1), ainputstream, b.b(b1));
        if (true) goto _L7; else goto _L6
_L6:
        s;
        throw s;
    }

    public void a()
    {
        close();
        kd.a(c);
    }

    public a b(String s)
    {
        return a(s, -1L);
    }

    public boolean c(String s)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        b b1;
        g();
        e(s);
        b1 = (b)l.get(s);
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
        j = j - b.b(b1)[i1];
        b.b(b1)[i1] = 0L;
        i1++;
_L3:
        if (i1 >= i)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = b1.a(i1);
        if (!((File) (obj)).exists() || ((File) (obj)).delete()) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder()).append("failed to delete ").append(obj).toString());
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        m = m + 1;
        k.append((new StringBuilder()).append("REMOVE ").append(s).append('\n').toString());
        l.remove(s);
        if (f())
        {
            b.submit(o);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        Writer writer = k;
        if (writer != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = (new ArrayList(l.values())).iterator();
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
        k.close();
        k = null;
          goto _L1
    }


    private class b
    {

        final kb a;
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
        {
            b1.a(as);
        }

        private void a(String as[])
        {
            if (as.length != kb.e(a))
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
            return new File(kb.f(a), (new StringBuilder()).append(b).append(".").append(i1).toString());
        }

        public String a()
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
            return new File(kb.f(a), (new StringBuilder()).append(b).append(".").append(i1).append(".tmp").toString());
        }

        private b(String s)
        {
            a = kb.this;
            super();
            b = s;
            c = new long[kb.e(kb.this)];
        }

    }


    private class a
    {

        final kb a;
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
        {
            kb kb1 = a;
            kb1;
            JVM INSTR monitorenter ;
            if (b.a(b) != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            kb1;
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
            class a extends FilterOutputStream
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

                public void write(int j1)
                {
                    try
                    {
                        out.write(j1);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        a.a(a, true);
                    }
                }

                public void write(byte abyte0[], int j1, int k1)
                {
                    try
                    {
                        out.write(abyte0, j1, k1);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[])
                    {
                        a.a(a, true);
                    }
                }

                private a(OutputStream outputstream)
                {
                    a = a.this;
                    super(outputstream);
                }

            }

            obj1 = new a(((OutputStream) (obj1)));
            kb1;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
            obj1;
            kb.f(a).mkdirs();
            obj1 = new FileOutputStream(file);
              goto _L1
            obj1;
            obj1 = kb.b();
            kb1;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
        }

        public void a()
        {
            if (d)
            {
                kb.a(a, this, false);
                a.c(b.c(b));
            } else
            {
                kb.a(a, this, true);
            }
            e = true;
        }

        public void b()
        {
            kb.a(a, this, false);
        }

        private a(b b1)
        {
            a = kb.this;
            super();
            b = b1;
            if (b.d(b1))
            {
                kb1 = null;
            } else
            {
                kb1 = new boolean[kb.e(kb.this)];
            }
            c = kb.this;
        }

    }


    private class c
        implements Closeable
    {

        final kb a;
        private final String b;
        private final long c;
        private final InputStream d[];
        private final long e[];

        public InputStream a(int i1)
        {
            return d[i1];
        }

        public void close()
        {
            InputStream ainputstream[] = d;
            int j1 = ainputstream.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                kd.a(ainputstream[i1]);
            }

        }

        private c(String s, long l1, InputStream ainputstream[], long al[])
        {
            a = kb.this;
            super();
            b = s;
            c = l1;
            d = ainputstream;
            e = al;
        }

        c(String s, long l1, InputStream ainputstream[], long al[], _cls1 _pcls1)
        {
            this(s, l1, ainputstream, al);
        }
    }

}
