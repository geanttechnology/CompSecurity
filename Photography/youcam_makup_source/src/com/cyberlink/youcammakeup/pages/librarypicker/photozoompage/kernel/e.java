// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import com.pf.common.utility.m;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            h, f, i

public final class e
    implements Closeable
{

    private static final Charset a = Charset.forName("UTF-8");
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final long f;
    private final int g;
    private long h;
    private boolean i;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75F, true);
    private int k;
    private long l;
    private final ExecutorService m;
    private final Callable n = new Callable() {

        final e a;

        public Void a()
        {
label0:
            {
                synchronized (a)
                {
                    if (e.a(a))
                    {
                        break label0;
                    }
                }
                return null;
            }
            e.b(a);
            if (e.c(a))
            {
                e.d(a);
                e.a(a, 0);
            }
            e1;
            JVM INSTR monitorexit ;
            return null;
            exception;
            e1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public Object call()
        {
            return a();
        }

            
            {
                a = e.this;
                super();
            }
    };

    private e(File file, int i1, int j1, long l1)
    {
        h = 0L;
        i = false;
        l = 0L;
        m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        b = file.getPath();
        e = i1;
        c = (new File(file, "journal")).getPath();
        d = (new File(file, "journal.tmp")).getPath();
        g = j1;
        f = l1;
    }

    static int a(e e1, int i1)
    {
        e1.k = i1;
        return i1;
    }

    public static e a(File file, int i1, int j1, long l1)
    {
        e e1;
        File file1;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        e1 = new e(file, i1, j1, l1);
        file1 = new File(e1.c);
        if (file1 == null || !file1.exists()) goto _L2; else goto _L1
_L1:
        e1.d();
        e1.e();
        e1.i = true;
        return e1;
        IOException ioexception;
        ioexception;
        com.pf.common.utility.m.e("DiskLruCache", (new StringBuilder()).append("DiskLruCache ").append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        try
        {
            e1.c();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new IOException((new StringBuilder()).append("IOException open - ").append(file).toString());
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("IllegalArgumentException open - ").append(file).toString());
        }
_L4:
        file.mkdirs();
        file = new e(file, i1, j1, l1);
        file.f();
        return file;
_L2:
        try
        {
            e1.c();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new IOException((new StringBuilder()).append("IOException open - ").append(file).toString());
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("IllegalArgumentException open - ").append(file).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private f a(String s, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        h h1;
        h();
        g(s);
        h1 = (h)j.get(s);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (h1 == null) goto _L4; else goto _L3
_L3:
        long l2 = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.e(h1);
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (h1 != null) goto _L6; else goto _L5
_L5:
        h1 = new h(this, s);
        j.put(s, h1);
_L8:
        f f1;
        f1 = new f(this, h1);
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, f1);
        e((new StringBuilder()).append("DIRTY ").append(s).append('\n').toString());
        s = f1;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L6:
        f1 = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1);
        if (f1 == null) goto _L8; else goto _L7
_L7:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static String a(InputStream inputstream)
    {
        StringBuilder stringbuilder = new StringBuilder(80);
        do
        {
            int i1 = inputstream.read();
            if (i1 == -1)
            {
                throw new EOFException();
            }
            if (i1 == 10)
            {
                i1 = stringbuilder.length();
                if (i1 > 0 && stringbuilder.charAt(i1 - 1) == '\r')
                {
                    stringbuilder.setLength(i1 - 1);
                }
                return stringbuilder.toString();
            }
            stringbuilder.append((char)i1);
        } while (true);
    }

    static void a(e e1, f f1, boolean flag)
    {
        e1.a(f1, flag);
    }

    private void a(f f1, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        h h1;
        h1 = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.f.a(f1);
        if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1) != f1)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        f1;
        this;
        JVM INSTR monitorexit ;
        throw f1;
        int j1 = ((flag1) ? 1 : 0);
        if (!flag) goto _L2; else goto _L1
_L1:
        j1 = ((flag1) ? 1 : 0);
        if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.d(h1)) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L9:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= g) goto _L2; else goto _L4
_L4:
        if (!h1.b(i1).exists())
        {
            f1.b();
            throw new IllegalStateException((new StringBuilder()).append("edit didn't create file ").append(i1).toString());
        }
          goto _L5
_L2:
        if (j1 >= g) goto _L7; else goto _L6
_L6:
        f1 = h1.b(j1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (f1.exists())
        {
            File file = h1.a(j1);
            f1.renameTo(file);
            long l1 = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.b(h1)[j1];
            long l3 = file.length();
            com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.b(h1)[j1] = l3;
            h = (h - l1) + l3;
        }
        break MISSING_BLOCK_LABEL_389;
        b(f1);
        break MISSING_BLOCK_LABEL_389;
_L7:
        k = k + 1;
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, null);
        if (!(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.d(h1) | flag))
        {
            break MISSING_BLOCK_LABEL_333;
        }
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, true);
        e((new StringBuilder()).append("CLEAN ").append(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.c(h1)).append(h1.a()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        long l2 = l;
        l = 1L + l2;
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, l2);
_L8:
        if (h > f || g())
        {
            m.submit(n);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        j.remove(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.c(h1));
        e((new StringBuilder()).append("REMOVE ").append(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.c(h1)).append('\n').toString());
          goto _L8
_L5:
        i1++;
          goto _L9
        j1++;
          goto _L2
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        throw closeable;
        closeable;
    }

    public static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("not a directory: ").append(file).toString());
        }
        int j1 = afile.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            file = afile[i1];
            if (file.isDirectory())
            {
                a(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder()).append("failed to delete file: ").append(file).toString());
            }
        }

    }

    static boolean a(e e1)
    {
        return e1.i;
    }

    private static Object[] a(Object aobj[], int i1, int j1)
    {
        int k1 = aobj.length;
        if (i1 > j1)
        {
            throw new IllegalArgumentException();
        }
        if (i1 < 0 || i1 > k1)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j1 -= i1;
            k1 = Math.min(j1, k1 - i1);
            Object aobj1[] = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), j1);
            System.arraycopy(((Object) (aobj)), i1, ((Object) (aobj1)), 0, k1);
            return aobj1;
        }
    }

    static void b(e e1)
    {
        e1.i();
    }

    private static void b(File file)
    {
        if (file.exists() && !file.delete())
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    static boolean c(e e1)
    {
        return e1.g();
    }

    private void d()
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(new File(c)), 8192);
        Exception exception;
        String s = a(bufferedinputstream);
        String s1 = a(bufferedinputstream);
        String s2 = a(bufferedinputstream);
        String s3 = a(bufferedinputstream);
        String s4 = a(bufferedinputstream);
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(e).equals(s2) || !Integer.toString(g).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        try
        {
            do
            {
                d(a(bufferedinputstream));
            } while (true);
        }
        catch (EOFException eofexception)
        {
            a(bufferedinputstream);
        }
        finally
        {
            a(bufferedinputstream);
            throw exception;
        }
        return;
    }

    static void d(e e1)
    {
        e1.f();
    }

    private void d(String s)
    {
        String as[] = s.split(" ");
        if (as.length < 2)
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
        }
        String s1 = as[1];
        if (as[0].equals("REMOVE") && as.length == 2)
        {
            j.remove(s1);
        } else
        {
            h h1 = (h)j.get(s1);
            if (h1 == null)
            {
                h1 = new h(this, s1);
                j.put(s1, h1);
            }
            if (as[0].equals("CLEAN") && as.length == g + 2)
            {
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, true);
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, null);
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, (String[])a(as, 2, as.length));
                return;
            }
            if (as[0].equals("DIRTY") && as.length == 2)
            {
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, new f(this, h1));
                return;
            }
            if (!as[0].equals("READ") || as.length != 2)
            {
                throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
            }
        }
    }

    static int e(e e1)
    {
        return e1.g;
    }

    private void e()
    {
        b(new File(d));
        for (Iterator iterator = j.values().iterator(); iterator.hasNext();)
        {
            h h1 = (h)iterator.next();
            if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1) == null)
            {
                int i1 = 0;
                while (i1 < g) 
                {
                    h = h + com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.b(h1)[i1];
                    i1++;
                }
            } else
            {
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1, null);
                for (int j1 = 0; j1 < g; j1++)
                {
                    b(h1.a(j1));
                    b(h1.b(j1));
                }

                iterator.remove();
            }
        }

    }

    private void e(String s)
    {
        BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(new File(c), true), 8192);
        bufferedwriter.write(s);
        bufferedwriter.flush();
        bufferedwriter.close();
    }

    static String f(e e1)
    {
        return e1.b;
    }

    private void f()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        BufferedWriter bufferedwriter;
        Iterator iterator;
        obj = new File(d);
        i = false;
        bufferedwriter = new BufferedWriter(new FileWriter(((File) (obj))), 8192);
        bufferedwriter.write("libcore.io.DiskLruCache");
        bufferedwriter.write("\n");
        bufferedwriter.write("1");
        bufferedwriter.write("\n");
        bufferedwriter.write(Integer.toString(e));
        bufferedwriter.write("\n");
        bufferedwriter.write(Integer.toString(g));
        bufferedwriter.write("\n");
        bufferedwriter.write("\n");
        iterator = j.values().iterator();
_L1:
        h h1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_234;
            }
            h1 = (h)iterator.next();
            if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1) == null)
            {
                break MISSING_BLOCK_LABEL_190;
            }
            bufferedwriter.write((new StringBuilder()).append("DIRTY ").append(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.c(h1)).append('\n').toString());
        } while (true);
        obj;
        throw obj;
        bufferedwriter.write((new StringBuilder()).append("CLEAN ").append(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.c(h1)).append(h1.a()).append('\n').toString());
          goto _L1
        bufferedwriter.close();
        ((File) (obj)).renameTo(new File(c));
        i = true;
        this;
        JVM INSTR monitorexit ;
    }

    private void f(String s)
    {
        BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(new File(c), true), 8192);
        bufferedwriter.append(s);
        bufferedwriter.flush();
        bufferedwriter.close();
    }

    private void g(String s)
    {
        if (s.contains(" ") || s.contains("\n") || s.contains("\r"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("keys must not contain spaces or newlines: \"").append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    private boolean g()
    {
        return k >= 2000 && k >= j.size();
    }

    private void h()
    {
        if (!i)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    private void i()
    {
        while (h > f) 
        {
            c((String)((java.util.Map.Entry)j.entrySet().iterator().next()).getKey());
        }
    }

    public i a(String s)
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        h h1;
        h();
        g(s);
        h1 = (h)j.get(s);
        if (h1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return ((i) (obj));
_L2:
        obj = obj1;
        if (!com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.d(h1))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new InputStream[g];
        int i1 = 0;
_L4:
        if (i1 >= g)
        {
            break; /* Loop/switch isn't completed */
        }
        obj[i1] = new FileInputStream(h1.a(i1));
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        k = k + 1;
        f((new StringBuilder()).append("READ ").append(s).append('\n').toString());
        if (g())
        {
            m.submit(n);
        }
        obj = new i(this, s, com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.e(h1), ((InputStream []) (obj)));
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
        s;
        obj = obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean a()
    {
        return !i;
    }

    public f b(String s)
    {
        return a(s, -1L);
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        h();
        i();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        close();
        a(new File(b));
    }

    public boolean c(String s)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        h h1;
        h();
        g(s);
        h1 = (h)j.get(s);
        if (h1 == null) goto _L2; else goto _L1
_L1:
        Object obj = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1);
        if (obj == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L5:
        h = h - com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.b(h1)[i1];
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.b(h1)[i1] = 0L;
        i1++;
_L3:
        if (i1 >= g)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        obj = h1.a(i1);
        if (((File) (obj)).delete()) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder()).append("failed to delete ").append(obj).toString());
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        k = k + 1;
        f((new StringBuilder()).append("REMOVE ").append(s).append('\n').toString());
        j.remove(s);
        if (g())
        {
            m.submit(n);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = i;
        if (flag) goto _L2; else goto _L1
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
            h h1 = (h)iterator.next();
            if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1) != null)
            {
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.h.a(h1).b();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        throw exception;
        i();
        i = false;
          goto _L1
    }

}
