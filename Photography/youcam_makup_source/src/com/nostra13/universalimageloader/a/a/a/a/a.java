// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

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

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            h, d, b, g, 
//            e

final class a
    implements Closeable
{

    static final Pattern a = Pattern.compile("[a-z0-9._-]{1,64}");
    private static final OutputStream r = new OutputStream() {

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
    private int i;
    private final int j;
    private long k;
    private int l;
    private Writer m;
    private final LinkedHashMap n = new LinkedHashMap(0, 0.75F, true);
    private int o;
    private long p;
    private final Callable q = new Callable() {

        final a a;

        public Void a()
        {
label0:
            {
                synchronized (a)
                {
                    if (a.a(a) != null)
                    {
                        break label0;
                    }
                }
                return null;
            }
            a.b(a);
            a.c(a);
            if (a.d(a))
            {
                a.e(a);
                a.a(a, 0);
            }
            a1;
            JVM INSTR monitorexit ;
            return null;
            exception;
            a1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public Object call()
        {
            return a();
        }

            
            {
                a = a.this;
                super();
            }
    };

    private a(File file, int i1, int j1, long l1, int k1)
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

    static int a(a a1, int i1)
    {
        a1.o = i1;
        return i1;
    }

    public static a a(File file, int i1, int j1, long l1, int k1)
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
        obj = new a(file, i1, j1, l1, k1);
        if (!((a) (obj)).d.exists())
        {
            break MISSING_BLOCK_LABEL_226;
        }
        ((a) (obj)).c();
        ((a) (obj)).d();
        obj.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((a) (obj)).d, true), h.a));
        return ((a) (obj));
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder()).append("DiskLruCache ").append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((a) (obj)).a();
        file.mkdirs();
        file = new a(file, i1, j1, l1, k1);
        file.e();
        return file;
    }

    private b a(String s, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        d d1;
        g();
        e(s);
        d1 = (d)n.get(s);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (d1 == null) goto _L4; else goto _L3
_L3:
        long l2 = com.nostra13.universalimageloader.a.a.a.a.d.e(d1);
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (d1 != null) goto _L6; else goto _L5
_L5:
        d1 = new d(this, s);
        n.put(s, d1);
_L8:
        b b1;
        b1 = new b(this, d1);
        com.nostra13.universalimageloader.a.a.a.a.d.a(d1, b1);
        m.write((new StringBuilder()).append("DIRTY ").append(s).append('\n').toString());
        m.flush();
        s = b1;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L6:
        b1 = com.nostra13.universalimageloader.a.a.a.a.d.a(d1);
        if (b1 == null) goto _L8; else goto _L7
_L7:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    static Writer a(a a1)
    {
        return a1.m;
    }

    static void a(a a1, b b1, boolean flag)
    {
        a1.a(b1, flag);
    }

    private void a(b b1, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        d d1;
        d1 = com.nostra13.universalimageloader.a.a.a.a.b.a(b1);
        if (com.nostra13.universalimageloader.a.a.a.a.d.a(d1) != b1)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        b1;
        this;
        JVM INSTR monitorexit ;
        throw b1;
        int j1 = ((flag1) ? 1 : 0);
        if (!flag) goto _L2; else goto _L1
_L1:
        j1 = ((flag1) ? 1 : 0);
        if (com.nostra13.universalimageloader.a.a.a.a.d.d(d1)) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L7:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= j) goto _L2; else goto _L4
_L4:
        if (!com.nostra13.universalimageloader.a.a.a.a.b.b(b1)[i1])
        {
            b1.b();
            throw new IllegalStateException((new StringBuilder()).append("Newly created entry didn't create value for index ").append(i1).toString());
        }
        if (d1.b(i1).exists()) goto _L6; else goto _L5
_L5:
        b1.b();
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

        b1 = d1.b(j1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        if (b1.exists())
        {
            file = d1.a(j1);
            b1.renameTo(file);
            l1 = com.nostra13.universalimageloader.a.a.a.a.d.b(d1)[j1];
            l2 = file.length();
            com.nostra13.universalimageloader.a.a.a.a.d.b(d1)[j1] = l2;
            k = (k - l1) + l2;
            l = l + 1;
        }
        break MISSING_BLOCK_LABEL_438;
        a(((File) (b1)));
        break MISSING_BLOCK_LABEL_438;
        o = o + 1;
        com.nostra13.universalimageloader.a.a.a.a.d.a(d1, null);
        if (!(com.nostra13.universalimageloader.a.a.a.a.d.d(d1) | flag))
        {
            break MISSING_BLOCK_LABEL_388;
        }
        com.nostra13.universalimageloader.a.a.a.a.d.a(d1, true);
        m.write((new StringBuilder()).append("CLEAN ").append(com.nostra13.universalimageloader.a.a.a.a.d.c(d1)).append(d1.a()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        l1 = p;
        p = 1L + l1;
        com.nostra13.universalimageloader.a.a.a.a.d.a(d1, l1);
_L9:
        m.flush();
        if (k > h || l > i || f())
        {
            b.submit(q);
        }
          goto _L8
        n.remove(com.nostra13.universalimageloader.a.a.a.a.d.c(d1));
        m.write((new StringBuilder()).append("REMOVE ").append(com.nostra13.universalimageloader.a.a.a.a.d.c(d1)).append('\n').toString());
          goto _L9
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
        return r;
    }

    static void b(a a1)
    {
        a1.h();
    }

    private void c()
    {
        g g1 = new g(new FileInputStream(d), h.a);
        String s = g1.a();
        String s1 = g1.a();
        String s2 = g1.a();
        String s3 = g1.a();
        String s4 = g1.a();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(g).equals(s2) || !Integer.toString(j).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        break MISSING_BLOCK_LABEL_184;
        Object obj;
        obj;
        com.nostra13.universalimageloader.a.a.a.a.h.a(g1);
        throw obj;
        int i1 = 0;
_L2:
        d(g1.a());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        o = i1 - n.size();
        com.nostra13.universalimageloader.a.a.a.a.h.a(g1);
        return;
    }

    static void c(a a1)
    {
        a1.i();
    }

    private void d()
    {
        a(e);
        for (Iterator iterator = n.values().iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            if (com.nostra13.universalimageloader.a.a.a.a.d.a(d1) == null)
            {
                int i1 = 0;
                while (i1 < j) 
                {
                    k = k + com.nostra13.universalimageloader.a.a.a.a.d.b(d1)[i1];
                    l = l + 1;
                    i1++;
                }
            } else
            {
                com.nostra13.universalimageloader.a.a.a.a.d.a(d1, null);
                for (int j1 = 0; j1 < j; j1++)
                {
                    a(d1.a(j1));
                    a(d1.b(j1));
                }

                iterator.remove();
            }
        }

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
        n.remove(s1);
_L6:
        return;
_L2:
        s1 = s.substring(j1, k1);
_L4:
        d d2 = (d)n.get(s1);
        d d1 = d2;
        if (d2 == null)
        {
            d1 = new d(this, s1);
            n.put(s1, d1);
        }
        if (k1 != -1 && i1 == "CLEAN".length() && s.startsWith("CLEAN"))
        {
            s = s.substring(k1 + 1).split(" ");
            com.nostra13.universalimageloader.a.a.a.a.d.a(d1, true);
            com.nostra13.universalimageloader.a.a.a.a.d.a(d1, null);
            com.nostra13.universalimageloader.a.a.a.a.d.a(d1, s);
            return;
        }
        if (k1 == -1 && i1 == "DIRTY".length() && s.startsWith("DIRTY"))
        {
            com.nostra13.universalimageloader.a.a.a.a.d.a(d1, new b(this, d1));
            return;
        }
        if (k1 != -1 || i1 != "READ".length() || !s.startsWith("READ"))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean d(a a1)
    {
        return a1.f();
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (m != null)
        {
            m.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e), h.a));
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
        d d1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_243;
            }
            d1 = (d)iterator.next();
            if (com.nostra13.universalimageloader.a.a.a.a.d.a(d1) == null)
            {
                break MISSING_BLOCK_LABEL_201;
            }
            ((Writer) (obj)).write((new StringBuilder()).append("DIRTY ").append(com.nostra13.universalimageloader.a.a.a.a.d.c(d1)).append('\n').toString());
        } while (true);
        Exception exception;
        exception;
        ((Writer) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder()).append("CLEAN ").append(com.nostra13.universalimageloader.a.a.a.a.d.c(d1)).append(d1.a()).append('\n').toString());
          goto _L1
        ((Writer) (obj)).close();
        if (d.exists())
        {
            a(d, f, true);
        }
        a(e, d, false);
        f.delete();
        m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, true), h.a));
        this;
        JVM INSTR monitorexit ;
    }

    static void e(a a1)
    {
        a1.e();
    }

    private void e(String s)
    {
        if (!a.matcher(s).matches())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("keys must match regex [a-z0-9._-]{1,64}: \"").append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    static int f(a a1)
    {
        return a1.j;
    }

    private boolean f()
    {
        return o >= 2000 && o >= n.size();
    }

    static File g(a a1)
    {
        return a1.c;
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
    {
        while (k > h) 
        {
            c((String)((java.util.Map.Entry)n.entrySet().iterator().next()).getKey());
        }
    }

    private void i()
    {
        while (l > i) 
        {
            c((String)((java.util.Map.Entry)n.entrySet().iterator().next()).getKey());
        }
    }

    public e a(String s)
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        d d1;
        g();
        e(s);
        d1 = (d)n.get(s);
        if (d1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
_L8:
        this;
        JVM INSTR monitorexit ;
        return ((e) (obj));
_L2:
        obj = obj1;
        InputStream ainputstream[];
        if (!com.nostra13.universalimageloader.a.a.a.a.d.d(d1))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new File[j];
        ainputstream = new InputStream[j];
        int i1 = 0;
_L5:
        if (i1 >= j) goto _L4; else goto _L3
_L3:
        File file = d1.a(i1);
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
        com.nostra13.universalimageloader.a.a.a.a.h.a(ainputstream[i1]);
        i1++;
        if (true) goto _L6; else goto _L4
_L4:
        o = o + 1;
        m.append((new StringBuilder()).append("READ ").append(s).append('\n').toString());
        if (f())
        {
            b.submit(q);
        }
        obj = new e(this, s, com.nostra13.universalimageloader.a.a.a.a.d.e(d1), ((File []) (obj)), ainputstream, com.nostra13.universalimageloader.a.a.a.a.d.b(d1));
        if (true) goto _L8; else goto _L7
_L7:
        s;
        throw s;
    }

    public void a()
    {
        close();
        com.nostra13.universalimageloader.a.a.a.a.h.a(c);
    }

    public b b(String s)
    {
        return a(s, -1L);
    }

    public boolean c(String s)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        d d1;
        g();
        e(s);
        d1 = (d)n.get(s);
        if (d1 == null) goto _L2; else goto _L1
_L1:
        Object obj = com.nostra13.universalimageloader.a.a.a.a.d.a(d1);
        if (obj == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L5:
        k = k - com.nostra13.universalimageloader.a.a.a.a.d.b(d1)[i1];
        l = l - 1;
        com.nostra13.universalimageloader.a.a.a.a.d.b(d1)[i1] = 0L;
        i1++;
_L3:
        if (i1 >= j)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = d1.a(i1);
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
            d d1 = (d)iterator.next();
            if (com.nostra13.universalimageloader.a.a.a.a.d.a(d1) != null)
            {
                com.nostra13.universalimageloader.a.a.a.a.d.a(d1).b();
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
