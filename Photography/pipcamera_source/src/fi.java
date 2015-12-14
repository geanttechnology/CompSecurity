// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

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

public final class fi
    implements Closeable
{

    private static final Charset a = Charset.forName("UTF-8");
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private final long f;
    private final int g;
    private long h;
    private Writer i;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75F, true);
    private int k;
    private long l;
    private final ExecutorService m;
    private final Callable n = new Callable() {

        final fi a;

        public Void a()
        {
label0:
            {
                synchronized (a)
                {
                    if (fi.a(a) != null)
                    {
                        break label0;
                    }
                }
                return null;
            }
            fi.b(a);
            if (fi.c(a))
            {
                fi.d(a);
                fi.a(a, 0);
            }
            fi1;
            JVM INSTR monitorexit ;
            return null;
            exception;
            fi1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public Object call()
        {
            return a();
        }

            
            {
                a = fi.this;
                super();
            }
    };

    private fi(File file, int i1, int j1, long l1)
    {
        h = 0L;
        l = 0L;
        m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        b = file;
        e = i1;
        c = new File(file, "journal");
        d = new File(file, "journal.tmp");
        g = j1;
        f = l1;
    }

    static int a(fi fi1, int i1)
    {
        fi1.k = i1;
        return i1;
    }

    public static fi a(File file, int i1, int j1, long l1)
    {
        fi fi1;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        fi1 = new fi(file, i1, j1, l1);
        if (!fi1.c.exists())
        {
            break MISSING_BLOCK_LABEL_102;
        }
        fi1.d();
        fi1.e();
        fi1.i = new BufferedWriter(new FileWriter(fi1.c, true), 8192);
        return fi1;
        IOException ioexception;
        ioexception;
        try
        {
            fi1.c();
        }
        catch (Exception exception) { }
        file.mkdirs();
        file = new fi(file, i1, j1, l1);
        file.f();
        return file;
    }

    private fj a(String s, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        fl fl1;
        h();
        e(s);
        fl1 = (fl)j.get(s);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (fl1 == null) goto _L4; else goto _L3
_L3:
        long l2 = fl.e(fl1);
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (fl1 != null) goto _L6; else goto _L5
_L5:
        fl1 = new fl(this, s);
        j.put(s, fl1);
_L8:
        fj fj1;
        fj1 = new fj(this, fl1);
        fl.a(fl1, fj1);
        i.write((new StringBuilder()).append("DIRTY ").append(s).append('\n').toString());
        i.flush();
        s = fj1;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L6:
        fj1 = fl.a(fl1);
        if (fj1 == null) goto _L8; else goto _L7
_L7:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    static Writer a(fi fi1)
    {
        return fi1.i;
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

    static void a(fi fi1, fj fj1, boolean flag)
    {
        fi1.a(fj1, flag);
    }

    private void a(fj fj1, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        fl fl1;
        fl1 = fj.a(fj1);
        if (fl.a(fl1) != fj1)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        fj1;
        this;
        JVM INSTR monitorexit ;
        throw fj1;
        int j1 = ((flag1) ? 1 : 0);
        if (!flag) goto _L2; else goto _L1
_L1:
        j1 = ((flag1) ? 1 : 0);
        if (fl.d(fl1)) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L9:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= g) goto _L2; else goto _L4
_L4:
        if (!fl1.b(i1).exists())
        {
            fj1.b();
            throw new IllegalStateException((new StringBuilder()).append("edit didn't create file ").append(i1).toString());
        }
          goto _L5
_L2:
        if (j1 >= g) goto _L7; else goto _L6
_L6:
        fj1 = fl1.b(j1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        if (fj1.exists())
        {
            File file = fl1.a(j1);
            fj1.renameTo(file);
            long l1 = fl.b(fl1)[j1];
            long l3 = file.length();
            fl.b(fl1)[j1] = l3;
            h = (h - l1) + l3;
        }
        break MISSING_BLOCK_LABEL_394;
        b(fj1);
        break MISSING_BLOCK_LABEL_394;
_L7:
        k = k + 1;
        fl.a(fl1, null);
        if (!(fl.d(fl1) | flag))
        {
            break MISSING_BLOCK_LABEL_335;
        }
        fl.a(fl1, true);
        i.write((new StringBuilder()).append("CLEAN ").append(fl.c(fl1)).append(fl1.a()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        long l2 = l;
        l = 1L + l2;
        fl.a(fl1, l2);
_L8:
        if (h > f || g())
        {
            m.submit(n);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        j.remove(fl.c(fl1));
        i.write((new StringBuilder()).append("REMOVE ").append(fl.c(fl1)).append('\n').toString());
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
        if (file != null && file.exists()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((file = file.listFiles()) != null)
        {
            int j1 = file.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                File file1 = file[i1];
                if (file1 != null && file1.exists() && file1.isDirectory())
                {
                    a(file1);
                }
                if (file1 != null && file1.exists())
                {
                    if (file1.delete());
                }
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
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

    static void b(fi fi1)
    {
        fi1.i();
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

    static boolean c(fi fi1)
    {
        return fi1.g();
    }

    private void d()
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(c), 8192);
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

    static void d(fi fi1)
    {
        fi1.f();
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
            fl fl1 = (fl)j.get(s1);
            if (fl1 == null)
            {
                fl1 = new fl(this, s1);
                j.put(s1, fl1);
            }
            if (as[0].equals("CLEAN") && as.length == g + 2)
            {
                fl.a(fl1, true);
                fl.a(fl1, null);
                fl.a(fl1, (String[])a(as, 2, as.length));
                return;
            }
            if (as[0].equals("DIRTY") && as.length == 2)
            {
                fl.a(fl1, new fj(this, fl1));
                return;
            }
            if (!as[0].equals("READ") || as.length != 2)
            {
                throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
            }
        }
    }

    static int e(fi fi1)
    {
        return fi1.g;
    }

    private void e()
    {
        b(d);
        for (Iterator iterator = j.values().iterator(); iterator.hasNext();)
        {
            fl fl1 = (fl)iterator.next();
            if (fl.a(fl1) == null)
            {
                int i1 = 0;
                while (i1 < g) 
                {
                    h = h + fl.b(fl1)[i1];
                    i1++;
                }
            } else
            {
                fl.a(fl1, null);
                for (int j1 = 0; j1 < g; j1++)
                {
                    b(fl1.a(j1));
                    b(fl1.b(j1));
                }

                iterator.remove();
            }
        }

    }

    private void e(String s)
    {
        if (s.contains(" ") || s.contains("\n") || s.contains("\r"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("keys must not contain spaces or newlines: \"").append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    static File f(fi fi1)
    {
        return fi1.b;
    }

    private void f()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        if (i != null)
        {
            i.close();
        }
        obj = new BufferedWriter(new FileWriter(d), 8192);
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
        fl fl1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_229;
            }
            fl1 = (fl)iterator.next();
            if (fl.a(fl1) == null)
            {
                break MISSING_BLOCK_LABEL_187;
            }
            ((Writer) (obj)).write((new StringBuilder()).append("DIRTY ").append(fl.c(fl1)).append('\n').toString());
        } while (true);
        obj;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder()).append("CLEAN ").append(fl.c(fl1)).append(fl1.a()).append('\n').toString());
          goto _L1
        ((Writer) (obj)).close();
        d.renameTo(c);
        i = new BufferedWriter(new FileWriter(c, true), 8192);
        this;
        JVM INSTR monitorexit ;
    }

    private boolean g()
    {
        return k >= 2000 && k >= j.size();
    }

    private void h()
    {
        if (i == null)
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

    public fm a(String s)
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        fl fl1;
        h();
        e(s);
        fl1 = (fl)j.get(s);
        if (fl1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return ((fm) (obj));
_L2:
        obj = obj1;
        if (!fl.d(fl1))
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
        obj[i1] = new FileInputStream(fl1.a(i1));
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        k = k + 1;
        i.append((new StringBuilder()).append("READ ").append(s).append('\n').toString());
        if (g())
        {
            m.submit(n);
        }
        obj = new fm(this, s, fl.e(fl1), ((InputStream []) (obj)));
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
        return i == null;
    }

    public fj b(String s)
    {
        return a(s, -1L);
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        h();
        i();
        i.flush();
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
        try
        {
            a(b);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public boolean c(String s)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        fl fl1;
        h();
        e(s);
        fl1 = (fl)j.get(s);
        if (fl1 == null) goto _L2; else goto _L1
_L1:
        Object obj = fl.a(fl1);
        if (obj == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L5:
        h = h - fl.b(fl1)[i1];
        fl.b(fl1)[i1] = 0L;
        i1++;
_L3:
        if (i1 >= g)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        obj = fl1.a(i1);
        if (((File) (obj)).delete()) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder()).append("failed to delete ").append(obj).toString());
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        k = k + 1;
        i.append((new StringBuilder()).append("REMOVE ").append(s).append('\n').toString());
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
            fl fl1 = (fl)iterator.next();
            if (fl.a(fl1) != null)
            {
                fl.a(fl1).b();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        throw exception;
        i();
        i.close();
        i = null;
          goto _L1
    }

}
