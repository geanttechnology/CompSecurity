// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.b:
//            cj, y, u, dc, 
//            ce

public class ar
{

    private static final Set a = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat b = new DecimalFormat("#,###");
    private cj c;
    private File d;
    private boolean e;

    public ar(cj cj1)
    {
        c = cj1;
        cj1 = cj1.getContext().getCacheDir();
        if (cj1 == null)
        {
            com.google.android.gms.ads.internal.util.client.b.e("Context.getCacheDir() returned null");
        } else
        {
            d = new File(cj1, "admobVideoStreams");
            if (!d.isDirectory() && !d.mkdirs())
            {
                com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Could not create preload cache directory at ").append(d.getAbsolutePath()).toString());
                d = null;
                return;
            }
            if (!d.setReadable(true, false) || !d.setExecutable(true, false))
            {
                com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Could not set cache file permissions at ").append(d.getAbsolutePath()).toString());
                d = null;
                return;
            }
        }
    }

    static cj a(ar ar1)
    {
        return ar1.c;
    }

    private File a(File file)
    {
        return new File(d, (new StringBuilder()).append(file.getName()).append(".done").toString());
    }

    private void a(String s, File file)
    {
        a.a.post(new _cls3(s, file));
    }

    private void a(String s, File file, int i)
    {
        a.a.post(new _cls2(s, file, i));
    }

    private void a(String s, File file, int i, int j)
    {
        a.a.post(new _cls1(s, file, i, j));
    }

    private String b(String s)
    {
        return h.a().a(s);
    }

    private static void b(File file)
    {
        if (file.isFile())
        {
            file.setLastModified(System.currentTimeMillis());
            return;
        }
        try
        {
            file.createNewFile();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    public void a()
    {
        e = true;
    }

    public boolean a(String s)
    {
        Object obj;
        File file;
        String s1;
        if (d == null)
        {
            a(s, null);
            return false;
        }
        while (b() > ((Integer)y.m.c()).intValue()) 
        {
            if (!c())
            {
                com.google.android.gms.ads.internal.util.client.b.e("Unable to expire stream cache");
                a(s, null);
                return false;
            }
        }
        obj = b(s);
        file = new File(d, ((String) (obj)));
        obj = a(file);
        if (file.isFile() && ((File) (obj)).isFile())
        {
            int i = (int)file.length();
            com.google.android.gms.ads.internal.util.client.b.a((new StringBuilder()).append("Stream cache hit at ").append(s).toString());
            a(s, file, i);
            return true;
        }
        s1 = (new StringBuilder()).append(d.getAbsolutePath()).append(s).toString();
        synchronized (a)
        {
            if (!a.contains(s1))
            {
                break MISSING_BLOCK_LABEL_220;
            }
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Stream cache already in progress at ").append(s).toString());
            a(s, file);
        }
        return false;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
        a.add(s1);
        set;
        JVM INSTR monitorexit ;
        Object obj1;
        obj1 = HttpInstrumentation.openConnection((new URL(s)).openConnection());
        int j = ((Integer)y.q.c()).intValue();
        ((URLConnection) (obj1)).setConnectTimeout(j);
        ((URLConnection) (obj1)).setReadTimeout(j);
        if (!(obj1 instanceof HttpURLConnection)) goto _L2; else goto _L1
_L1:
        int k = ((HttpURLConnection)obj1).getResponseCode();
        if (k < 400) goto _L2; else goto _L3
_L3:
        try
        {
            throw new IOException((new StringBuilder()).append("HTTP status code ").append(k).append(" at ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = null;
        }
_L7:
        Object obj2;
        FileChannel filechannel;
        ByteBuffer bytebuffer;
        dc dc1;
        ce ce1;
        int l;
        int i1;
        int j1;
        int k1;
        long l1;
        long l2;
        try
        {
            ((FileOutputStream) (obj1)).close();
        }
        catch (IOException ioexception) { }
        catch (NullPointerException nullpointerexception) { }
        if (e)
        {
            com.google.android.gms.ads.internal.util.client.b.c((new StringBuilder()).append("Preload aborted for URL \"").append(s).append("\"").toString());
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.c((new StringBuilder()).append("Preload failed for URL \"").append(s).append("\"").toString(), ((Throwable) (obj)));
        }
        if (file.exists() && !file.delete())
        {
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Could not delete partial cache file at ").append(file.getAbsolutePath()).toString());
        }
        a(s, file);
        a.remove(s1);
        return false;
_L2:
        j1 = ((URLConnection) (obj1)).getContentLength();
        if (j1 >= 0)
        {
            break MISSING_BLOCK_LABEL_496;
        }
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Stream cache aborted, missing content-length header at ").append(s).toString());
        a(s, file);
        a.remove(s1);
        return false;
        obj2 = b.format(j1);
        k1 = ((Integer)y.n.c()).intValue();
        if (j1 <= k1)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Content length ").append(((String) (obj2))).append(" exceeds limit at ").append(s).toString());
        a(s, file);
        a.remove(s1);
        return false;
        com.google.android.gms.ads.internal.util.client.b.a((new StringBuilder()).append("Caching ").append(((String) (obj2))).append(" bytes from ").append(s).toString());
        obj2 = Channels.newChannel(((URLConnection) (obj1)).getInputStream());
        obj1 = new FileOutputStream(file);
        filechannel = ((FileOutputStream) (obj1)).getChannel();
        bytebuffer = ByteBuffer.allocate(0x100000);
        dc1 = com.google.android.gms.ads.internal.c.g();
        l1 = dc1.a();
        ce1 = new ce(((Long)y.p.c()).longValue());
        l2 = ((Long)y.o.c()).longValue();
        l = 0;
_L5:
        i1 = ((ReadableByteChannel) (obj2)).read(bytebuffer);
        if (i1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = l + i1;
        if (i1 <= k1)
        {
            break MISSING_BLOCK_LABEL_742;
        }
        throw new IOException("stream cache file size limit exceeded");
        bytebuffer.flip();
        while (filechannel.write(bytebuffer) > 0) ;
        bytebuffer.clear();
        if (dc1.a() - l1 > 1000L * l2)
        {
            throw new IOException("stream cache time limit exceeded");
        }
        if (e)
        {
            throw new IOException("abort requested");
        }
        l = i1;
        if (!ce1.a())
        {
            continue; /* Loop/switch isn't completed */
        }
        a(s, file, i1, j1);
        l = i1;
        if (true) goto _L5; else goto _L4
_L4:
        ((FileOutputStream) (obj1)).close();
        if (com.google.android.gms.ads.internal.util.client.b.a(3))
        {
            obj2 = b.format(l);
            com.google.android.gms.ads.internal.util.client.b.a((new StringBuilder()).append("Preloaded ").append(((String) (obj2))).append(" bytes from ").append(s).toString());
        }
        file.setReadable(true, false);
        b(((File) (obj)));
        a(s, file, l);
        a.remove(s1);
        return true;
        obj;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public int b()
    {
        int i;
        int k;
        i = 0;
        k = 0;
        if (d != null) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        File afile[] = d.listFiles();
        int l = afile.length;
        int j = 0;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            k = i;
            if (!afile[j].getName().endsWith(".done"))
            {
                k = i + 1;
            }
            j++;
            i = k;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean c()
    {
        if (d == null)
        {
            return false;
        }
        File file = null;
        long l = 0x7fffffffffffffffL;
        File afile[] = d.listFiles();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file1 = afile[i];
            if (file1.getName().endsWith(".done"))
            {
                continue;
            }
            long l1 = file1.lastModified();
            if (l1 < l)
            {
                file = file1;
                l = l1;
            }
        }

        boolean flag;
        if (file != null)
        {
            boolean flag1 = file.delete();
            file = a(file);
            flag = flag1;
            if (file.isFile())
            {
                flag = flag1 & file.delete();
            }
        } else
        {
            flag = false;
        }
        return flag;
    }


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
