// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

final class i
    implements Runnable
{

    private final long a;
    private final b._cls1 b;
    private g c;

    private i(g g1, long l1)
    {
        c = g1;
        super();
        b = l.d;
        a = l1;
    }

    i(g g1, long l1, byte byte0)
    {
        this(g1, l1);
    }

    private boolean a(File file)
    {
        bc.a("Deleting %s", file.getAbsolutePath());
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int i1 = afile.length;
            for (int j = 0; j < i1; j++)
            {
                if (!a(afile[j]))
                {
                    return false;
                }
            }

        }
        return file.delete();
    }

    private boolean a(k k1)
    {
        try
        {
            bc.a((new StringBuilder("Size of dex file = ")).append(k1.c.length()).toString());
            Object obj = new DexClassLoader(k1.c.getAbsolutePath(), k1.d.getAbsolutePath(), null, g.getClassLoader());
            obj = g.a(c, ((ClassLoader) (obj)));
            bc.a("Finished verifying the downloaded dex file @ %s. Total number of info points enabled for next restart is #%d.", k1.c, Integer.valueOf(((h) (obj)).b()));
        }
        // Misplaced declaration of an exception variable
        catch (k k1)
        {
            p.a("Error attempting to verify downloaded dex file", k1);
            return false;
        }
        return true;
    }

    public final void run()
    {
        Object obj1;
        try
        {
            if (b.e() >= a)
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bc.a((new StringBuilder("Error while attempting to download dex with version = ")).append(a).toString(), ((Throwable) (obj)));
            synchronized (c)
            {
                if (g.a(c) == a)
                {
                    g.a(c, -1L);
                }
            }
            return;
        }
        obj1 = g.b(c);
        bc.a("Info point version has changed to #%s on the server. Attempting to download info points from %s", Long.valueOf(a), ((e) (obj1)).a());
        ((e) (obj1)).a("infopVersion", (new StringBuilder()).append(a).toString());
        obj = new k(l.c.m, a, (byte)0);
        if (((k) (obj)).a.exists() && !a(((k) (obj)).a))
        {
            throw new IllegalStateException((new StringBuilder("Failed to delete files under:")).append(((k) (obj)).a).toString());
        }
        break MISSING_BLOCK_LABEL_195;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        FileOutputStream fileoutputstream;
        byte abyte0[];
        if (!((k) (obj)).a.exists() && !((k) (obj)).a.mkdirs())
        {
            throw new IllegalStateException((new StringBuilder("Failed to create parent dex directory: ")).append(((k) (obj)).a).append(". Info points cannot run").toString());
        }
        if (!((k) (obj)).b.exists() && !((k) (obj)).b.mkdirs())
        {
            throw new IllegalStateException((new StringBuilder("Failed to create dex directory: ")).append(((k) (obj)).b).append(". Info points cannot run").toString());
        }
        if (!((k) (obj)).d.exists() && !((k) (obj)).d.mkdirs())
        {
            throw new IllegalStateException((new StringBuilder("Failed to create optimized cache directory for dex loading: ")).append(((k) (obj)).d).toString());
        }
        if (((e) (obj1)).h() != 200)
        {
            throw new IOException((new StringBuilder("Invalid response code ")).append(((e) (obj1)).h()).append(" from the server.").toString());
        }
        fileoutputstream = new FileOutputStream(((k) (obj)).c);
        obj1 = new BufferedInputStream(((e) (obj1)).g());
        abyte0 = new byte[4096];
_L1:
        int j = ((BufferedInputStream) (obj1)).read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_445;
        }
        fileoutputstream.write(abyte0, 0, j);
          goto _L1
        fileoutputstream.close();
        ((BufferedInputStream) (obj1)).close();
        if (a(((k) (obj))))
        {
            bc.a("Finished downloading info points. Updating info point version and enabled flag.");
            b.a(a);
            return;
        }
        g.a(c, b);
        synchronized (c)
        {
            if (g.a(c) == a)
            {
                g.a(c, -1L);
            }
        }
        return;
        exception1;
        g1;
        JVM INSTR monitorexit ;
        throw exception1;
    }
}
