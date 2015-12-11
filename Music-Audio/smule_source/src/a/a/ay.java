// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package a.a:
//            ax, cv, en, az, 
//            ba, cx

public final class ay
{

    public final File a;
    public String b;
    public List c;
    private cx d;
    private int e;
    private int f;
    private int g;
    private az h;
    private boolean i;

    public ay(Context context, ax ax1)
    {
        String s = ax1.a();
        this(new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("//com.crittercism//").append(s).toString()), ax1.c(), ax1.d(), ax1.e(), ax1.b(), ax1.f());
    }

    private ay(File file, az az1, cx cx1, int j, int k, String s)
    {
        i = false;
        h = az1;
        d = cx1;
        g = j;
        f = k;
        b = s;
        a = file;
        file.mkdirs();
        d();
        e = h().length;
        c = new LinkedList();
    }

    private boolean c(cv cv1)
    {
        BufferedOutputStream bufferedoutputstream;
        File file;
        file = new File(a, cv1.f());
        bufferedoutputstream = null;
        BufferedOutputStream bufferedoutputstream1 = new BufferedOutputStream(new FileOutputStream(file));
        bufferedoutputstream = bufferedoutputstream1;
_L2:
        cv1.a(bufferedoutputstream);
        FileNotFoundException filenotfoundexception;
        try
        {
            bufferedoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (cv cv1)
        {
            file.delete();
            en.a((new StringBuilder("Unable to close ")).append(file.getAbsolutePath()).toString(), cv1);
            return false;
        }
        return true;
        filenotfoundexception;
        (new StringBuilder("Could not open output stream to : ")).append(file);
        en.a();
        if (true) goto _L2; else goto _L1
_L1:
        cv1;
        file.delete();
        en.a((new StringBuilder("Unable to write to ")).append(file.getAbsolutePath()).toString(), cv1);
        try
        {
            bufferedoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (cv cv1)
        {
            file.delete();
            en.a((new StringBuilder("Unable to close ")).append(file.getAbsolutePath()).toString(), cv1);
            return false;
        }
        return false;
        cv1;
        try
        {
            bufferedoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (cv cv1)
        {
            file.delete();
            en.a((new StringBuilder("Unable to close ")).append(file.getAbsolutePath()).toString(), cv1);
            return false;
        }
        throw cv1;
    }

    private boolean d()
    {
        if (!a.isDirectory())
        {
            i = true;
            String s = a.getAbsolutePath();
            if (a.exists())
            {
                new IOException((new StringBuilder()).append(s).append(" is not a directory").toString());
            } else
            {
                new FileNotFoundException((new StringBuilder()).append(s).append(" does not exist").toString());
            }
        }
        return !i;
    }

    private void e()
    {
        while (b() > i() && f()) ;
    }

    private boolean f()
    {
        az az1 = h;
        if (h != null)
        {
            az az2 = h;
            File afile[] = g();
            File file = null;
            if (afile.length > az2.a)
            {
                file = afile[az2.a];
            }
            if (file != null && file.delete())
            {
                return true;
            }
        }
        return false;
    }

    private File[] g()
    {
        File afile[] = h();
        Arrays.sort(afile);
        return afile;
    }

    private File[] h()
    {
        File afile1[] = a.listFiles();
        File afile[] = afile1;
        if (afile1 == null)
        {
            afile = new File[0];
        }
        return afile;
    }

    private int i()
    {
        this;
        JVM INSTR monitorenter ;
        int j = f;
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    public final ay a(Context context)
    {
        String s = a.getName();
        s = (new StringBuilder()).append(s).append("_").append(UUID.randomUUID().toString()).toString();
        return new ay(new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("//com.crittercism/pending/").append(s).toString()), h, d, g, f, b);
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        File afile[] = h();
        int j = 0;
_L4:
        if (j >= afile.length)
        {
            break; /* Loop/switch isn't completed */
        }
        afile[j].delete();
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(ay ay1)
    {
        int j;
        while (ay1 == null || (j = a.getName().compareTo(ay1.a.getName())) == 0) 
        {
            return;
        }
        if (j >= 0) goto _L2; else goto _L1
_L1:
        ay ay3 = ay1;
        ay ay2 = this;
_L4:
        ay2;
        JVM INSTR monitorenter ;
        ay3;
        JVM INSTR monitorenter ;
        if (d() && ay1.d())
        {
            break; /* Loop/switch isn't completed */
        }
        ay3;
        JVM INSTR monitorexit ;
        ay2;
        JVM INSTR monitorexit ;
        return;
        ay1;
        ay2;
        JVM INSTR monitorexit ;
        throw ay1;
_L2:
        ay3 = this;
        ay2 = ay1;
        if (true) goto _L4; else goto _L3
_L3:
        File afile[] = g();
        j = 0;
_L6:
        if (j >= afile.length)
        {
            break; /* Loop/switch isn't completed */
        }
        File file = new File(ay1.a, afile[j].getName());
        afile[j].renameTo(file);
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        ay1.e();
        for (ay1 = c.iterator(); ay1.hasNext(); ((ba)ay1.next()).d()) { }
        break MISSING_BLOCK_LABEL_176;
        ay1;
        ay3;
        JVM INSTR monitorexit ;
        throw ay1;
        ay3;
        JVM INSTR monitorexit ;
        ay2;
        JVM INSTR monitorexit ;
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d();
          goto _L1
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L1:
        if (!flag || s == null) goto _L3; else goto _L2
_L2:
        s = new File(a.getAbsolutePath(), s);
        if (s.exists())
        {
            s.delete();
        }
        if (true) goto _L3; else goto _L4
_L4:
        s;
        throw s;
    }

    public final boolean a(cv cv1)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = d();
        if (flag) goto _L2; else goto _L1
_L1:
        flag = flag1;
_L3:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (e < g)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        en.b();
        flag = flag1;
          goto _L3
        cv1;
        throw cv1;
        int j = b();
        if (j != i()) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (!f()) goto _L3; else goto _L5
_L5:
        if (j <= i())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        i = true;
        flag = flag1;
          goto _L3
        flag = c(cv1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        e = e + 1;
        cv1 = c;
        cv1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((ba)iterator.next()).c()) { }
        break MISSING_BLOCK_LABEL_165;
        Exception exception;
        exception;
        cv1;
        JVM INSTR monitorexit ;
        throw exception;
        cv1;
        JVM INSTR monitorexit ;
          goto _L3
    }

    public final int b()
    {
        this;
        JVM INSTR monitorenter ;
        int j = h().length;
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean b(cv cv1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d();
        if (flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        (new File(a, cv1.f())).delete();
        flag = c(cv1);
        if (true) goto _L4; else goto _L3
_L3:
        cv1;
        throw cv1;
    }

    public final List c()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        boolean flag;
        arraylist = new ArrayList();
        flag = d();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        File afile[];
        cx cx1 = d;
        afile = g();
        int j = 0;
_L4:
        if (j >= afile.length)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(d.a(afile[j]));
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }
}
