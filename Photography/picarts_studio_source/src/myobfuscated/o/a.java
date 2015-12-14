// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.o;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

// Referenced classes of package myobfuscated.o:
//            f, e, c, b, 
//            d

public final class a
    implements Closeable
{

    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e = 1;
    private long f;
    private final int g = 1;
    private long h;
    private Writer i;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75F, true);
    private int k;
    private long l;
    private ThreadPoolExecutor m;
    private final Callable n = new Callable() {

        private a a;

        private Void a()
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
            if (a.c(a))
            {
                a.d(a);
                a.e(a);
            }
            a1;
            JVM INSTR monitorexit ;
            return null;
            exception;
            a1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final Object call()
        {
            return a();
        }

            
            {
                a = a.this;
                super();
            }
    };

    private a(File file, int i1, int j1, long l1)
    {
        h = 0L;
        l = 0L;
        m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a = file;
        b = new File(file, "journal");
        c = new File(file, "journal.tmp");
        d = new File(file, "journal.bkp");
        f = l1;
    }

    static Writer a(a a1)
    {
        return a1.i;
    }

    public static a a(File file, long l1)
    {
        Object obj;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
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
        obj = new a(file, 1, 1, l1);
        if (!((a) (obj)).b.exists())
        {
            break MISSING_BLOCK_LABEL_154;
        }
        ((a) (obj)).a();
        ((a) (obj)).b();
        return ((a) (obj));
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder("DiskLruCache ")).append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((a) (obj)).close();
        myobfuscated.o.f.a(((a) (obj)).a);
        file.mkdirs();
        file = new a(file, 1, 1, l1);
        file.c();
        return file;
    }

    private void a()
    {
        e e1 = new e(new FileInputStream(b), f.a);
        Exception exception;
        String s = e1.a();
        String s2 = e1.a();
        String s3 = e1.a();
        String s4 = e1.a();
        String s6 = e1.a();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s2) || !Integer.toString(e).equals(s3) || !Integer.toString(g).equals(s4) || !"".equals(s6))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s).append(", ").append(s2).append(", ").append(s4).append(", ").append(s6).append("]").toString());
        }
        int i1 = 0;
_L8:
        String s5;
        int j1;
        s5 = e1.a();
        j1 = s5.indexOf(' ');
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        try
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s5).toString());
        }
        catch (EOFException eofexception) { }
        finally
        {
            myobfuscated.o.f.a(e1);
            throw exception;
        }
        k = i1 - j.size();
        String s1;
        c c1;
        c c2;
        int k1;
        int l1;
        if (e1.b == -1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L4; else goto _L3
_L3:
        c();
_L6:
        myobfuscated.o.f.a(e1);
        return;
_L2:
        k1 = j1 + 1;
        l1 = s5.indexOf(' ', k1);
        if (l1 != -1)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        s1 = s5.substring(k1);
        if (j1 != 6)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        if (s5.startsWith("REMOVE"))
        {
            j.remove(s1);
            break; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_340;
        s1 = s5.substring(k1, l1);
        c2 = (c)j.get(s1);
        c1 = c2;
        if (c2 != null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        c1 = new c(this, s1, (byte)0);
        j.put(s1, c1);
        if (l1 == -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_436;
        }
        if (s5.startsWith("CLEAN"))
        {
            String as[] = s5.substring(l1 + 1).split(" ");
            c1.e = true;
            c1.f = null;
            c1.a(as);
            break; /* Loop/switch isn't completed */
        }
        if (l1 != -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_476;
        }
        if (s5.startsWith("DIRTY"))
        {
            c1.f = new b(this, c1, (byte)0);
            break; /* Loop/switch isn't completed */
        }
        if (l1 != -1 || j1 != 4)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        if (s5.startsWith("READ"))
        {
            break; /* Loop/switch isn't completed */
        }
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(s5).toString());
_L4:
        i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b, true), f.a));
        if (true) goto _L6; else goto _L5
_L5:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
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

    public static void a(a a1, b b1, boolean flag)
    {
        a1.a(b1, flag);
    }

    private void a(b b1, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        c c1;
        c1 = b1.a;
        if (c1.f != b1)
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
        if (c1.e) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L7:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= g) goto _L2; else goto _L4
_L4:
        if (!b1.b[i1])
        {
            b1.b();
            throw new IllegalStateException((new StringBuilder("Newly created entry didn't create value for index ")).append(i1).toString());
        }
        if (c1.d[i1].exists()) goto _L6; else goto _L5
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
        for (; j1 >= g; j1++)
        {
            break MISSING_BLOCK_LABEL_228;
        }

        b1 = c1.d[j1];
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        if (b1.exists())
        {
            file = c1.c[j1];
            b1.renameTo(file);
            l1 = c1.b[j1];
            l2 = file.length();
            c1.b[j1] = l2;
            h = (h - l1) + l2;
        }
        break MISSING_BLOCK_LABEL_434;
        a(((File) (b1)));
        break MISSING_BLOCK_LABEL_434;
        k = k + 1;
        c1.f = null;
        if (!(c1.e | flag))
        {
            break MISSING_BLOCK_LABEL_377;
        }
        c1.e = true;
        i.append("CLEAN");
        i.append(' ');
        i.append(c1.a);
        i.append(c1.a());
        i.append('\n');
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        l1 = l;
        l = 1L + l1;
        c1.g = l1;
_L9:
        i.flush();
        if (h > f || d())
        {
            m.submit(n);
        }
          goto _L8
        j.remove(c1.a);
        i.append("REMOVE");
        i.append(' ');
        i.append(c1.a);
        i.append('\n');
          goto _L9
    }

    private void b()
    {
        a(c);
        for (Iterator iterator = j.values().iterator(); iterator.hasNext();)
        {
            c c1 = (c)iterator.next();
            if (c1.f == null)
            {
                int i1 = 0;
                while (i1 < g) 
                {
                    h = h + c1.b[i1];
                    i1++;
                }
            } else
            {
                c1.f = null;
                for (int j1 = 0; j1 < g; j1++)
                {
                    a(c1.c[j1]);
                    a(c1.d[j1]);
                }

                iterator.remove();
            }
        }

    }

    static void b(a a1)
    {
        a1.f();
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (i != null)
        {
            i.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c), f.a));
        Iterator iterator;
        ((Writer) (obj)).write("libcore.io.DiskLruCache");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("1");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(e));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(g));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("\n");
        iterator = j.values().iterator();
_L1:
        c c1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_236;
            }
            c1 = (c)iterator.next();
            if (c1.f == null)
            {
                break MISSING_BLOCK_LABEL_197;
            }
            ((Writer) (obj)).write((new StringBuilder("DIRTY ")).append(c1.a).append('\n').toString());
        } while (true);
        Exception exception;
        exception;
        ((Writer) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder("CLEAN ")).append(c1.a).append(c1.a()).append('\n').toString());
          goto _L1
        ((Writer) (obj)).close();
        if (b.exists())
        {
            a(b, d, true);
        }
        a(c, b, false);
        d.delete();
        i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b, true), f.a));
        this;
        JVM INSTR monitorexit ;
    }

    private boolean c(String s)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        c c1;
        e();
        c1 = (c)j.get(s);
        if (c1 == null) goto _L2; else goto _L1
_L1:
        Object obj = c1.f;
        if (obj == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L5:
        h = h - c1.b[i1];
        c1.b[i1] = 0L;
        i1++;
_L3:
        if (i1 >= g)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        obj = c1.c[i1];
        if (!((File) (obj)).exists() || ((File) (obj)).delete()) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder("failed to delete ")).append(obj).toString());
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        k = k + 1;
        i.append("REMOVE");
        i.append(' ');
        i.append(s);
        i.append('\n');
        j.remove(s);
        if (d())
        {
            m.submit(n);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static boolean c(a a1)
    {
        return a1.d();
    }

    static void d(a a1)
    {
        a1.c();
    }

    private boolean d()
    {
        return k >= 2000 && k >= j.size();
    }

    static int e(a a1)
    {
        a1.k = 0;
        return 0;
    }

    private void e()
    {
        if (i == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    static int f(a a1)
    {
        return a1.g;
    }

    private void f()
    {
        while (h > f) 
        {
            c((String)((java.util.Map.Entry)j.entrySet().iterator().next()).getKey());
        }
    }

    static File g(a a1)
    {
        return a1.a;
    }

    public final d a(String s)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        c c1;
        e();
        c1 = (c)j.get(s);
        if (c1 != null) goto _L2; else goto _L1
_L1:
        d d1 = obj;
_L6:
        this;
        JVM INSTR monitorexit ;
        return d1;
_L2:
        d1 = obj;
        File afile[];
        int j1;
        if (!c1.e)
        {
            continue; /* Loop/switch isn't completed */
        }
        afile = c1.c;
        j1 = afile.length;
        int i1 = 0;
_L4:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        d1 = obj;
        if (!afile[i1].exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        k = k + 1;
        i.append("READ");
        i.append(' ');
        i.append(s);
        i.append('\n');
        if (d())
        {
            m.submit(n);
        }
        d1 = new d(this, s, c1.g, c1.c, c1.b);
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public final b b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        c c1;
        e();
        c1 = (c)j.get(s);
        if (-1L == -1L) goto _L2; else goto _L1
_L1:
        if (c1 == null) goto _L4; else goto _L3
_L3:
        long l1 = c1.g;
        if (l1 == -1L) goto _L2; else goto _L4
_L4:
        s = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (c1 != null) goto _L6; else goto _L5
_L5:
        c1 = new c(this, s, (byte)0);
        j.put(s, c1);
_L8:
        b b1;
        b1 = new b(this, c1, (byte)0);
        c1.f = b1;
        i.append("DIRTY");
        i.append(' ');
        i.append(s);
        i.append('\n');
        i.flush();
        s = b1;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L6:
        b1 = c1.f;
        if (b1 == null) goto _L8; else goto _L7
_L7:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        Writer writer = i;
        if (writer != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = (new ArrayList(j.values())).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            c c1 = (c)iterator.next();
            if (c1.f != null)
            {
                c1.f.b();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        throw exception;
        f();
        i.close();
        i = null;
          goto _L1
    }
}
