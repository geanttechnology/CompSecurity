// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
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

// Referenced classes of package com.google.android.gms.d:
//            cp, he, ay, ax, 
//            ii, gu

public final class cs extends cp
{

    private static final Set b = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat c = new DecimalFormat("#,###");
    private File d;
    private boolean e;

    public cs(he he1)
    {
        super(he1);
        he1 = he1.getContext().getCacheDir();
        if (he1 == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        } else
        {
            d = new File(he1, "admobVideoStreams");
            if (!d.isDirectory() && !d.mkdirs())
            {
                (new StringBuilder("Could not create preload cache directory at ")).append(d.getAbsolutePath());
                com.google.android.gms.ads.internal.util.client.b.a(5);
                d = null;
                return;
            }
            if (!d.setReadable(true, false) || !d.setExecutable(true, false))
            {
                (new StringBuilder("Could not set cache file permissions at ")).append(d.getAbsolutePath());
                com.google.android.gms.ads.internal.util.client.b.a(5);
                d = null;
                return;
            }
        }
    }

    private File a(File file)
    {
        return new File(d, (new StringBuilder()).append(file.getName()).append(".done").toString());
    }

    public final void a()
    {
        e = true;
    }

    public final boolean a(String s)
    {
        File file2;
        String s2;
        File file3;
        if (d == null)
        {
            a(s, null);
            return false;
        }
        do
        {
            au au;
            int i;
            boolean flag;
            if (d == null)
            {
                i = 0;
            } else
            {
                File afile[] = d.listFiles();
                int l2 = afile.length;
                i = 0;
                int k1 = 0;
                while (k1 < l2) 
                {
                    int j2 = i;
                    if (!afile[k1].getName().endsWith(".done"))
                    {
                        j2 = i + 1;
                    }
                    k1++;
                    i = j2;
                }
            }
            au = ay.o;
            if (i <= ((Integer)p.n().a(au)).intValue())
            {
                break;
            }
            if (d == null)
            {
                flag = false;
            } else
            {
                File file = null;
                long l3 = 0x7fffffffffffffffL;
                File afile1[] = d.listFiles();
                int l1 = afile1.length;
                for (int j = 0; j < l1; j++)
                {
                    File file1 = afile1[j];
                    if (file1.getName().endsWith(".done"))
                    {
                        continue;
                    }
                    long l5 = file1.lastModified();
                    if (l5 < l3)
                    {
                        file = file1;
                        l3 = l5;
                    }
                }

                flag = false;
                if (file != null)
                {
                    boolean flag1 = file.delete();
                    file = a(file);
                    flag = flag1;
                    if (file.isFile())
                    {
                        flag = flag1 & file.delete();
                    }
                }
            }
            if (!flag)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                a(s, null);
                return false;
            }
        } while (true);
        m.a();
        String s1 = com.google.android.gms.ads.internal.util.client.a.a(s);
        file2 = new File(d, s1);
        file3 = a(file2);
        if (file2.isFile() && file3.isFile())
        {
            int k = (int)file2.length();
            com.google.android.gms.ads.internal.util.client.b.a(3);
            a(s, file2.getAbsolutePath(), k);
            return true;
        }
        s2 = (new StringBuilder()).append(d.getAbsolutePath()).append(s).toString();
        synchronized (b)
        {
            if (!b.contains(s2))
            {
                break MISSING_BLOCK_LABEL_398;
            }
            com.google.android.gms.ads.internal.util.client.b.a(5);
            a(s, file2.getAbsolutePath());
        }
        return false;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
        b.add(s2);
        set;
        JVM INSTR monitorexit ;
        Object obj;
        obj = (new URL(s)).openConnection();
        au au1 = ay.t;
        int l = ((Integer)p.n().a(au1)).intValue();
        ((URLConnection) (obj)).setConnectTimeout(l);
        ((URLConnection) (obj)).setReadTimeout(l);
        if (!(obj instanceof HttpURLConnection)) goto _L2; else goto _L1
_L1:
        int i1 = ((HttpURLConnection)obj).getResponseCode();
        if (i1 < 400) goto _L2; else goto _L3
_L3:
        try
        {
            throw new IOException((new StringBuilder("HTTP status code ")).append(i1).append(" at ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
_L8:
        IOException ioexception1;
        Object obj1;
        Object obj2;
        ByteBuffer bytebuffer;
        ii ii1;
        Object obj3;
        Object obj4;
        int j1;
        int i2;
        int k2;
        int i3;
        long l4;
        long l6;
        try
        {
            ((FileOutputStream) (obj)).close();
        }
        catch (IOException ioexception) { }
        catch (NullPointerException nullpointerexception) { }
        if (e)
        {
            (new StringBuilder("Preload aborted for URL \"")).append(s).append("\"");
            com.google.android.gms.ads.internal.util.client.b.a(4);
        } else
        {
            (new StringBuilder("Preload failed for URL \"")).append(s).append("\"");
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        if (file2.exists() && !file2.delete())
        {
            (new StringBuilder("Could not delete partial cache file at ")).append(file2.getAbsolutePath());
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        a(s, file2.getAbsolutePath());
        b.remove(s2);
        return false;
_L2:
        k2 = ((URLConnection) (obj)).getContentLength();
        if (k2 >= 0)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        a(s, file2.getAbsolutePath());
        b.remove(s2);
        return false;
        obj1 = c.format(k2);
        obj2 = com.google.android.gms.d.ay.p;
        i3 = ((Integer)p.n().a(((au) (obj2)))).intValue();
        if (k2 <= i3)
        {
            break MISSING_BLOCK_LABEL_738;
        }
        (new StringBuilder("Content length ")).append(((String) (obj1))).append(" exceeds limit at ").append(s);
        com.google.android.gms.ads.internal.util.client.b.a(5);
        a(s, file2.getAbsolutePath());
        b.remove(s2);
        return false;
        (new StringBuilder("Caching ")).append(((String) (obj1))).append(" bytes from ").append(s);
        com.google.android.gms.ads.internal.util.client.b.a(3);
        obj1 = Channels.newChannel(((URLConnection) (obj)).getInputStream());
        obj = new FileOutputStream(file2);
        obj2 = ((FileOutputStream) (obj)).getChannel();
        bytebuffer = ByteBuffer.allocate(0x100000);
        ii1 = p.i();
        j1 = 0;
        l4 = ii1.a();
        obj3 = ay.s;
        obj3 = new gu(((Long)p.n().a(((au) (obj3)))).longValue());
        obj4 = ay.r;
        l6 = ((Long)p.n().a(((au) (obj4)))).longValue();
_L5:
        i2 = ((ReadableByteChannel) (obj1)).read(bytebuffer);
        if (i2 < 0)
        {
            break MISSING_BLOCK_LABEL_1025;
        }
        i2 = j1 + i2;
        if (i2 <= i3)
        {
            break MISSING_BLOCK_LABEL_907;
        }
        throw new IOException("stream cache file size limit exceeded");
        bytebuffer.flip();
        while (((FileChannel) (obj2)).write(bytebuffer) > 0) ;
        bytebuffer.clear();
        if (ii1.a() - l4 > 1000L * l6)
        {
            throw new IOException("stream cache time limit exceeded");
        }
        if (e)
        {
            throw new IOException("abort requested");
        }
        j1 = i2;
        if (!((gu) (obj3)).a()) goto _L5; else goto _L4
_L4:
        obj4 = file2.getAbsolutePath();
        a.a.post(new cp._cls1(this, s, ((String) (obj4)), i2, k2));
        j1 = i2;
          goto _L5
        ((FileOutputStream) (obj)).close();
        if (com.google.android.gms.ads.internal.util.client.b.a(3))
        {
            obj1 = c.format(j1);
            (new StringBuilder("Preloaded ")).append(((String) (obj1))).append(" bytes from ").append(s);
            com.google.android.gms.ads.internal.util.client.b.a(3);
        }
        file2.setReadable(true, false);
        if (!file3.isFile())
        {
            break MISSING_BLOCK_LABEL_1126;
        }
        file3.setLastModified(System.currentTimeMillis());
_L6:
        a(s, file2.getAbsolutePath(), j1);
        b.remove(s2);
        return true;
        try
        {
            file3.createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception1) { }
          goto _L6
        IOException ioexception2;
        ioexception2;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
