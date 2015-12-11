// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
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

// Referenced classes of package com.google.android.gms.internal:
//            zzdv, zziz, zzby, zzbu, 
//            zzmn, zzik

public class zzdy extends zzdv
{

    private static final Set zzyk = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzyl = new DecimalFormat("#,###");
    private File zzym;
    private boolean zzyn;

    public zzdy(zziz zziz1)
    {
        super(zziz1);
        zziz1 = zziz1.getContext().getCacheDir();
        if (zziz1 == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Context.getCacheDir() returned null");
        } else
        {
            zzym = new File(zziz1, "admobVideoStreams");
            if (!zzym.isDirectory() && !zzym.mkdirs())
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Could not create preload cache directory at ").append(zzym.getAbsolutePath()).toString());
                zzym = null;
                return;
            }
            if (!zzym.setReadable(true, false) || !zzym.setExecutable(true, false))
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Could not set cache file permissions at ").append(zzym.getAbsolutePath()).toString());
                zzym = null;
                return;
            }
        }
    }

    private File zza(File file)
    {
        return new File(zzym, (new StringBuilder()).append(file.getName()).append(".done").toString());
    }

    private static void zzb(File file)
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

    public void abort()
    {
        zzyn = true;
    }

    public boolean zzab(String s)
    {
        Object obj1;
        File file;
        String s2;
        if (zzym == null)
        {
            zza(s, null, "noCacheDir", null);
            return false;
        }
        while (zzdK() > ((Integer)zzby.zzuy.get()).intValue()) 
        {
            if (!zzdL())
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to expire stream cache");
                zza(s, null, "expireFailed", null);
                return false;
            }
        }
        String s1 = zzac(s);
        file = new File(zzym, s1);
        obj1 = zza(file);
        if (file.isFile() && ((File) (obj1)).isFile())
        {
            int i = (int)file.length();
            com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder()).append("Stream cache hit at ").append(s).toString());
            zza(s, file.getAbsolutePath(), i);
            return true;
        }
        s2 = (new StringBuilder()).append(zzym.getAbsolutePath()).append(s).toString();
        synchronized (zzyk)
        {
            if (!zzyk.contains(s2))
            {
                break MISSING_BLOCK_LABEL_235;
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Stream cache already in progress at ").append(s).toString());
            zza(s, file.getAbsolutePath(), "inProgress", null);
        }
        return false;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
        zzyk.add(s2);
        set;
        JVM INSTR monitorexit ;
        Object obj3 = null;
        Object obj;
        obj = (new URL(s)).openConnection();
        int j = ((Integer)zzby.zzuD.get()).intValue();
        ((URLConnection) (obj)).setConnectTimeout(j);
        ((URLConnection) (obj)).setReadTimeout(j);
        if (!(obj instanceof HttpURLConnection)) goto _L2; else goto _L1
_L1:
        int k = ((HttpURLConnection)obj).getResponseCode();
        if (k < 400) goto _L2; else goto _L3
_L3:
        Object obj2;
        obj2 = "badUrl";
        Object obj4;
        Object obj5;
        zzmn zzmn1;
        zzik zzik1;
        int l;
        int i1;
        int j1;
        long l1;
        long l2;
        try
        {
            obj1 = (new StringBuilder()).append("HTTP request failed. Code: ").append(Integer.toString(k)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = null;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            throw new IOException((new StringBuilder()).append("HTTP status code ").append(k).append(" at ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
_L7:
        try
        {
            ((FileOutputStream) (obj3)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj4) { }
        // Misplaced declaration of an exception variable
        catch (Object obj4) { }
        if (zzyn)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG((new StringBuilder()).append("Preload aborted for URL \"").append(s).append("\"").toString());
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd((new StringBuilder()).append("Preload failed for URL \"").append(s).append("\"").toString(), ((Throwable) (obj)));
        }
        if (file.exists() && !file.delete())
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Could not delete partial cache file at ").append(file.getAbsolutePath()).toString());
        }
        zza(s, file.getAbsolutePath(), ((String) (obj2)), ((String) (obj1)));
        zzyk.remove(s2);
        return false;
_L2:
        try
        {
            i1 = ((URLConnection) (obj)).getContentLength();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = null;
            obj2 = "error";
            continue; /* Loop/switch isn't completed */
        }
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_548;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Stream cache aborted, missing content-length header at ").append(s).toString());
        zza(s, file.getAbsolutePath(), "contentLengthMissing", null);
        zzyk.remove(s2);
        return false;
        obj2 = zzyl.format(i1);
        j1 = ((Integer)zzby.zzuz.get()).intValue();
        if (i1 <= j1)
        {
            break MISSING_BLOCK_LABEL_663;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Content length ").append(((String) (obj2))).append(" exceeds limit at ").append(s).toString());
        obj = (new StringBuilder()).append("File too big for full file cache. Size: ").append(((String) (obj2))).toString();
        zza(s, file.getAbsolutePath(), "sizeExceeded", ((String) (obj)));
        zzyk.remove(s2);
        return false;
        com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder()).append("Caching ").append(((String) (obj2))).append(" bytes from ").append(s).toString());
        obj2 = Channels.newChannel(((URLConnection) (obj)).getInputStream());
        obj = new FileOutputStream(file);
        obj3 = ((FileOutputStream) (obj)).getChannel();
        obj5 = ByteBuffer.allocate(0x100000);
        zzmn1 = zzp.zzbz();
        k = 0;
        l1 = zzmn1.currentTimeMillis();
        zzik1 = new zzik(((Long)zzby.zzuC.get()).longValue());
        l2 = ((Long)zzby.zzuB.get()).longValue();
_L5:
        l = ((ReadableByteChannel) (obj2)).read(((ByteBuffer) (obj5)));
        if (l < 0)
        {
            break MISSING_BLOCK_LABEL_1041;
        }
        l = k + l;
        if (l > j1)
        {
            obj3 = "sizeExceeded";
            obj2 = obj3;
            try
            {
                obj1 = (new StringBuilder()).append("File too big for full file cache. Size: ").append(Integer.toString(l)).toString();
            }
            catch (IOException ioexception)
            {
                obj1 = null;
                obj4 = obj;
                obj = ioexception;
                continue; /* Loop/switch isn't completed */
            }
            obj2 = obj3;
            try
            {
                throw new IOException("stream cache file size limit exceeded");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj5)
            {
                obj3 = obj;
            }
            obj = obj5;
            continue; /* Loop/switch isn't completed */
        }
        ((ByteBuffer) (obj5)).flip();
        while (((FileChannel) (obj3)).write(((ByteBuffer) (obj5))) > 0) ;
        ((ByteBuffer) (obj5)).clear();
        if (zzmn1.currentTimeMillis() - l1 <= 1000L * l2)
        {
            break MISSING_BLOCK_LABEL_969;
        }
        obj3 = "downloadTimeout";
        obj2 = obj3;
        obj1 = (new StringBuilder()).append("Timeout exceeded. Limit: ").append(Long.toString(l2)).append(" sec").toString();
        obj2 = obj3;
        throw new IOException("stream cache time limit exceeded");
        if (zzyn)
        {
            try
            {
                throw new IOException("abort requested");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                obj2 = "externalAbort";
            }
            obj3 = obj;
            obj5 = null;
            obj = obj1;
            obj1 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        k = l;
        if (!zzik1.tryAcquire()) goto _L5; else goto _L4
_L4:
        zza(s, file.getAbsolutePath(), l, i1, false);
        k = l;
          goto _L5
        ((FileOutputStream) (obj)).close();
        if (com.google.android.gms.ads.internal.util.client.zzb.zzN(3))
        {
            obj2 = zzyl.format(k);
            com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder()).append("Preloaded ").append(((String) (obj2))).append(" bytes from ").append(s).toString());
        }
        file.setReadable(true, false);
        zzb(((File) (obj1)));
        zza(s, file.getAbsolutePath(), k);
        zzyk.remove(s2);
        return true;
        IOException ioexception1;
        ioexception1;
        obj1 = null;
        obj2 = "error";
        obj4 = obj;
        obj = ioexception1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public int zzdK()
    {
        int i;
        int k;
        i = 0;
        k = 0;
        if (zzym != null) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        File afile[] = zzym.listFiles();
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

    public boolean zzdL()
    {
        if (zzym == null)
        {
            return false;
        }
        File file = null;
        long l = 0x7fffffffffffffffL;
        File afile[] = zzym.listFiles();
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
            file = zza(file);
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

}
