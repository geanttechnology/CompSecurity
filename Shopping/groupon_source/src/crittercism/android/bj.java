// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// Referenced classes of package crittercism.android:
//            bi, dg, bv, bw

public class bj
{
    public static final class a
    {

        int a;

        public a(int l)
        {
            a = l;
        }
    }


    private static final String a = crittercism/android/bj.getName();
    private final File b;
    private bw c;
    private int d;
    private int e;
    private int f;
    private a g;
    private boolean h;
    private String i;
    private String j;

    public bj(Context context, bi bi1)
    {
        String s = bi1.a();
        this(new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("//com.crittercism//").append(s).toString()), bi1.c(), bi1.d(), bi1.f(), bi1.b(), bi1.g(), bi1.e());
    }

    private bj(File file, a a1, bw bw1, int l, int i1, String s, String s1)
    {
        h = false;
        g = a1;
        c = bw1;
        f = l;
        e = i1;
        i = s;
        j = s1;
        b = file;
        file.mkdirs();
        f();
        d = j().length;
    }

    private boolean f()
    {
        if (!b.isDirectory())
        {
            h = true;
            String s = b.getAbsolutePath();
            if (b.exists())
            {
                new IOException((new StringBuilder()).append(s).append(" is not a directory").toString());
            } else
            {
                new FileNotFoundException((new StringBuilder()).append(s).append(" does not exist").toString());
            }
        }
        return !h;
    }

    private void g()
    {
        while (b() > k() && h()) ;
    }

    private boolean h()
    {
        a a1 = g;
        if (g != null)
        {
            a a2 = g;
            File afile[] = i();
            File file = null;
            if (afile.length > a2.a)
            {
                file = afile[a2.a];
            }
            if (file != null && file.delete())
            {
                return true;
            }
        }
        return false;
    }

    private File[] i()
    {
        File afile[] = j();
        Arrays.sort(afile);
        return afile;
    }

    private File[] j()
    {
        File afile1[] = b.listFiles();
        File afile[] = afile1;
        if (afile1 == null)
        {
            afile = new File[0];
        }
        return afile;
    }

    private int k()
    {
        this;
        JVM INSTR monitorenter ;
        int l = e;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final bj a(Context context)
    {
        String s = b.getName();
        s = (new StringBuilder()).append(s).append("_").append(UUID.randomUUID().toString()).toString();
        return new bj(new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("//com.crittercism/pending/").append(s).toString()), g, c, f, e, i, j);
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        File afile[] = j();
        int l = 0;
_L4:
        if (l >= afile.length)
        {
            break; /* Loop/switch isn't completed */
        }
        afile[l].delete();
        l++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(bj bj1)
    {
        int l;
        while (bj1 == null || (l = b.getName().compareTo(bj1.b.getName())) == 0) 
        {
            return;
        }
        if (l >= 0) goto _L2; else goto _L1
_L1:
        bj bj3 = bj1;
        bj bj2 = this;
_L4:
        bj2;
        JVM INSTR monitorenter ;
        bj3;
        JVM INSTR monitorenter ;
        if (f() && bj1.f())
        {
            break; /* Loop/switch isn't completed */
        }
        bj3;
        JVM INSTR monitorexit ;
        bj2;
        JVM INSTR monitorexit ;
        return;
        bj1;
        bj2;
        JVM INSTR monitorexit ;
        throw bj1;
_L2:
        bj3 = this;
        bj2 = bj1;
        if (true) goto _L4; else goto _L3
_L3:
        File afile[] = i();
        l = 0;
_L6:
        if (l >= afile.length)
        {
            break; /* Loop/switch isn't completed */
        }
        File file = new File(bj1.b, afile[l].getName());
        afile[l].renameTo(file);
        l++;
        if (true) goto _L6; else goto _L5
_L5:
        bj1.g();
        bj3;
        JVM INSTR monitorexit ;
        bj2;
        JVM INSTR monitorexit ;
        return;
        bj1;
        bj3;
        JVM INSTR monitorexit ;
        throw bj1;
    }

    public final boolean a(bv bv1)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = f();
        if (flag) goto _L2; else goto _L1
_L1:
        flag = flag1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (d < f)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        bv1 = a;
        dg.b();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        bv1;
        throw bv1;
        File file;
        int l;
        file = new File(b, bv1.e());
        l = b();
        if (l != k())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        flag = flag1;
        if (!h())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l <= k())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        h = true;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file));
        bv1.a(bufferedoutputstream);
        d = d + 1;
        bufferedoutputstream.close();
_L4:
        flag = true;
        continue; /* Loop/switch isn't completed */
        bv1;
        bv1 = a;
        (new StringBuilder("Could not open output stream to : ")).append(file);
        dg.a();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        bv1;
        file.delete();
        dg.a("Crittercism", (new StringBuilder("Unable to close file ")).append(file.getAbsolutePath()).toString(), bv1);
        if (true) goto _L4; else goto _L3
_L3:
        bv1;
        file.delete();
        dg.a("Crittercism", (new StringBuilder("Unable to write to ")).append(file.getAbsolutePath()).toString(), bv1);
        bufferedoutputstream.close();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        bv1;
        file.delete();
        dg.a("Crittercism", (new StringBuilder("Unable to close file ")).append(file.getAbsolutePath()).toString(), bv1);
        flag = flag1;
        if (true) goto _L6; else goto _L5
_L5:
        bv1;
        bufferedoutputstream.close();
_L7:
        throw bv1;
        IOException ioexception;
        ioexception;
        file.delete();
        dg.a("Crittercism", (new StringBuilder("Unable to close file ")).append(file.getAbsolutePath()).toString(), ioexception);
          goto _L7
    }

    public final int b()
    {
        this;
        JVM INSTR monitorenter ;
        int l = j().length;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final List c()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        boolean flag;
        arraylist = new ArrayList();
        flag = f();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        File afile[];
        bw bw1 = c;
        afile = i();
        int l = 0;
_L4:
        if (l >= afile.length)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(c.a(afile[l]));
        l++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public final String d()
    {
        return i;
    }

    public final String e()
    {
        return j;
    }

}
