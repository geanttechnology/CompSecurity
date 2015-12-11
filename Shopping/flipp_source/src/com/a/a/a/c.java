// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

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

// Referenced classes of package com.a.a.a:
//            e, d, u, m, 
//            f, h, s, i

public final class c
    implements Closeable
{

    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream p = new e();
    final ThreadPoolExecutor b;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g = 0x31191;
    private long h;
    private final int i = 2;
    private long j;
    private Writer k;
    private final LinkedHashMap l = new LinkedHashMap(0, 0.75F, true);
    private int m;
    private long n;
    private final Callable o = new d(this);

    private c(File file, long l1)
    {
        j = 0L;
        n = 0L;
        b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c = file;
        d = new File(file, "journal");
        e = new File(file, "journal.tmp");
        f = new File(file, "journal.bkp");
        h = l1;
    }

    public static c a(File file, long l1)
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
        obj = new c(file, l1);
        if (!((c) (obj)).d.exists())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        ((c) (obj)).b();
        ((c) (obj)).c();
        obj.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((c) (obj)).d, true), u.d));
        return ((c) (obj));
        IOException ioexception;
        ioexception;
        com.a.a.a.m.a();
        com.a.a.a.m.a((new StringBuilder("DiskLruCache ")).append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((c) (obj)).close();
        u.a(((c) (obj)).c);
        file.mkdirs();
        file = new c(file, l1);
        file.d();
        return file;
    }

    public static f a(c c1, String s1, long l1)
    {
        return c1.a(s1, l1);
    }

    static OutputStream a()
    {
        return p;
    }

    static Writer a(c c1)
    {
        return c1.k;
    }

    static void a(c c1, f f1, boolean flag)
    {
        c1.a(f1, flag);
    }

    private void a(f f1, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        h h1;
        h1 = f1.a;
        if (h1.d != f1)
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
        if (h1.c) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L7:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= i) goto _L2; else goto _L4
_L4:
        if (!f1.b[i1])
        {
            f1.b();
            throw new IllegalStateException((new StringBuilder("Newly created entry didn't create value for index ")).append(i1).toString());
        }
        if (h1.b(i1).exists()) goto _L6; else goto _L5
_L5:
        f1.b();
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
            break MISSING_BLOCK_LABEL_224;
        }

        f1 = h1.b(j1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        if (f1.exists())
        {
            file = h1.a(j1);
            f1.renameTo(file);
            l1 = h1.b[j1];
            l2 = file.length();
            h1.b[j1] = l2;
            j = (j - l1) + l2;
        }
        break MISSING_BLOCK_LABEL_404;
        a(((File) (f1)));
        break MISSING_BLOCK_LABEL_404;
        m = m + 1;
        h1.d = null;
        if (!(h1.c | flag))
        {
            break MISSING_BLOCK_LABEL_357;
        }
        h1.c = true;
        k.write((new StringBuilder("CLEAN ")).append(h1.a).append(h1.a()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        l1 = n;
        n = 1L + l1;
        h1.e = l1;
_L9:
        k.flush();
        if (j > h || e())
        {
            b.submit(o);
        }
          goto _L8
        l.remove(h1.a);
        k.write((new StringBuilder("REMOVE ")).append(h1.a).append('\n').toString());
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

    private void b()
    {
        s s5 = new s(new FileInputStream(d), u.d);
        Exception exception;
        String s1 = s5.a();
        String s3 = s5.a();
        String s4 = s5.a();
        String s6 = s5.a();
        String s8 = s5.a();
        if (!"libcore.io.DiskLruCache".equals(s1) || !"1".equals(s3) || !Integer.toString(g).equals(s4) || !Integer.toString(i).equals(s6) || !"".equals(s8))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s1).append(", ").append(s3).append(", ").append(s6).append(", ").append(s8).append("]").toString());
        }
        int i1 = 0;
_L2:
        String s7;
        int j1;
        s7 = s5.a();
        j1 = s7.indexOf(' ');
        if (j1 != -1)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        try
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s7).toString());
        }
        catch (EOFException eofexception) { }
        finally
        {
            u.a(s5);
            throw exception;
        }
        m = i1 - l.size();
        u.a(s5);
        return;
        int k1 = j1 + 1;
        int l1 = s7.indexOf(' ', k1);
        if (l1 != -1)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        String s2 = s7.substring(k1);
        if (j1 != 6)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        if (s7.startsWith("REMOVE"))
        {
            l.remove(s2);
            break MISSING_BLOCK_LABEL_517;
        }
        break MISSING_BLOCK_LABEL_329;
        s2 = s7.substring(k1, l1);
        h h2 = (h)l.get(s2);
        h h1;
        h1 = h2;
        if (h2 != null)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        h1 = new h(this, s2, (byte)0);
        l.put(s2, h1);
        if (l1 == -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        if (s7.startsWith("CLEAN"))
        {
            String as[] = s7.substring(l1 + 1).split(" ");
            h1.c = true;
            h1.d = null;
            h1.a(as);
            break MISSING_BLOCK_LABEL_517;
        }
        if (l1 != -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_465;
        }
        if (s7.startsWith("DIRTY"))
        {
            h1.d = new f(this, h1, (byte)0);
            break MISSING_BLOCK_LABEL_517;
        }
        if (l1 != -1 || j1 != 4)
        {
            break MISSING_BLOCK_LABEL_488;
        }
        if (s7.startsWith("READ"))
        {
            break MISSING_BLOCK_LABEL_517;
        }
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(s7).toString());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void b(c c1)
    {
        c1.g();
    }

    private void c()
    {
        a(e);
        for (Iterator iterator = l.values().iterator(); iterator.hasNext();)
        {
            h h1 = (h)iterator.next();
            if (h1.d == null)
            {
                int i1 = 0;
                while (i1 < i) 
                {
                    j = j + h1.b[i1];
                    i1++;
                }
            } else
            {
                h1.d = null;
                for (int j1 = 0; j1 < i; j1++)
                {
                    a(h1.a(j1));
                    a(h1.b(j1));
                }

                iterator.remove();
            }
        }

    }

    private static void c(String s1)
    {
        if (!a.matcher(s1).matches())
        {
            throw new IllegalArgumentException((new StringBuilder("keys must match regex [a-z0-9_-]{1,64}: \"")).append(s1).append("\"").toString());
        } else
        {
            return;
        }
    }

    static boolean c(c c1)
    {
        return c1.e();
    }

    private void d()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (k != null)
        {
            k.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e), u.d));
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
        h h1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_238;
            }
            h1 = (h)iterator.next();
            if (h1.d == null)
            {
                break MISSING_BLOCK_LABEL_199;
            }
            ((Writer) (obj)).write((new StringBuilder("DIRTY ")).append(h1.a).append('\n').toString());
        } while (true);
        Exception exception;
        exception;
        ((Writer) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder("CLEAN ")).append(h1.a).append(h1.a()).append('\n').toString());
          goto _L1
        ((Writer) (obj)).close();
        if (d.exists())
        {
            a(d, f, true);
        }
        a(e, d, false);
        f.delete();
        k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, true), u.d));
        this;
        JVM INSTR monitorexit ;
    }

    static void d(c c1)
    {
        c1.d();
    }

    static int e(c c1)
    {
        c1.m = 0;
        return 0;
    }

    private boolean e()
    {
        return m >= 2000 && m >= l.size();
    }

    static int f(c c1)
    {
        return c1.i;
    }

    private void f()
    {
        if (k == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    static File g(c c1)
    {
        return c1.c;
    }

    private void g()
    {
        while (j > h) 
        {
            b((String)((java.util.Map.Entry)l.entrySet().iterator().next()).getKey());
        }
    }

    public final f a(String s1, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        h h1;
        f();
        c(s1);
        h1 = (h)l.get(s1);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (h1 == null) goto _L4; else goto _L3
_L3:
        long l2 = h1.e;
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s1 = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        if (h1 != null) goto _L6; else goto _L5
_L5:
        h1 = new h(this, s1, (byte)0);
        l.put(s1, h1);
_L8:
        f f1;
        f1 = new f(this, h1, (byte)0);
        h1.d = f1;
        k.write((new StringBuilder("DIRTY ")).append(s1).append('\n').toString());
        k.flush();
        s1 = f1;
        continue; /* Loop/switch isn't completed */
        s1;
        throw s1;
_L6:
        f1 = h1.d;
        if (f1 == null) goto _L8; else goto _L7
_L7:
        s1 = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final i a(String s1)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        h h1;
        f();
        c(s1);
        h1 = (h)l.get(s1);
        if (h1 != null) goto _L2; else goto _L1
_L1:
        i i1 = obj;
_L7:
        this;
        JVM INSTR monitorexit ;
        return i1;
_L2:
        i1 = obj;
        InputStream ainputstream[];
        if (!h1.c)
        {
            continue; /* Loop/switch isn't completed */
        }
        ainputstream = new InputStream[i];
        int j1 = 0;
_L4:
        if (j1 >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        ainputstream[j1] = new FileInputStream(h1.a(j1));
        j1++;
        if (true) goto _L4; else goto _L3
        s1;
        j1 = 0;
_L5:
        i1 = obj;
        if (j1 >= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = obj;
        if (ainputstream[j1] == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        u.a(ainputstream[j1]);
        j1++;
        if (true) goto _L5; else goto _L3
_L3:
        m = m + 1;
        k.append((new StringBuilder("READ ")).append(s1).append('\n').toString());
        if (e())
        {
            b.submit(o);
        }
        i1 = new i(this, s1, h1.e, ainputstream, h1.b, (byte)0);
        if (true) goto _L7; else goto _L6
_L6:
        s1;
        throw s1;
    }

    public final boolean b(String s1)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        h h1;
        f();
        c(s1);
        h1 = (h)l.get(s1);
        if (h1 == null) goto _L2; else goto _L1
_L1:
        Object obj = h1.d;
        if (obj == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L5:
        j = j - h1.b[i1];
        h1.b[i1] = 0L;
        i1++;
_L3:
        if (i1 >= i)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = h1.a(i1);
        if (((File) (obj)).delete()) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder("failed to delete ")).append(obj).toString());
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
        m = m + 1;
        k.append((new StringBuilder("REMOVE ")).append(s1).append('\n').toString());
        l.remove(s1);
        if (e())
        {
            b.submit(o);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void close()
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
            h h1 = (h)iterator.next();
            if (h1.d != null)
            {
                h1.d.b();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        throw exception;
        g();
        k.close();
        k = null;
          goto _L1
    }

}
