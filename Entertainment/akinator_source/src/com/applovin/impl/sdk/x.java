// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, bw, br, n, 
//            bu

public class x
{

    private final AppLovinLogger a;
    private final AppLovinSdkImpl b;
    private final String c = "FileManager";
    private final Object d = new Object();

    x(AppLovinSdk applovinsdk)
    {
        b = (AppLovinSdkImpl)applovinsdk;
        a = applovinsdk.getLogger();
    }

    long a(long l)
    {
        return l / 0x100000L;
    }

    public File a(String s, Context context, boolean flag)
    {
        Object obj;
        a.d("FileManager", (new StringBuilder()).append("Looking up cached resource: ").append(s).toString());
        if (!a(context) && !flag)
        {
            return null;
        }
        obj = s;
        if (s.contains("icon"))
        {
            obj = s.replace("/", "_").replace(".", "_");
        }
        s = ((String) (d));
        s;
        JVM INSTR monitorenter ;
        context = b(context);
        obj = new File(context, ((String) (obj)));
        context.mkdirs();
        return ((File) (obj));
        context;
        s;
        JVM INSTR monitorexit ;
        return null;
        context;
        s;
        JVM INSTR monitorexit ;
        throw context;
    }

    String a(Context context, String s)
    {
        return a(context, s, false);
    }

    String a(Context context, String s, boolean flag)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        b.getLogger().d("FileManager", "Nothing to cache, skipping...");
        context = "";
_L4:
        return context;
_L2:
        String s1;
        File file;
        b.getLogger().d("FileManager", (new StringBuilder()).append("Starting caching of resource ").append(s).toString());
        s1 = Uri.parse(s).getLastPathSegment();
        file = a(s1, context, false);
        if (file == null || !file.exists())
        {
            break; /* Loop/switch isn't completed */
        }
        context = s1;
        if (flag)
        {
            return Uri.fromFile(file).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (a(file, s))
        {
            context = s1;
            if (flag)
            {
                return Uri.fromFile(file).toString();
            }
        } else
        {
            return null;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    void a(long l, Context context)
    {
        long l1 = c();
        if (l1 == -1L)
        {
            a.d("FileManager", "Cache has no maximum size set; skipping drop...");
            return;
        }
        if (a(l) > l1)
        {
            a.d("FileManager", "Cache has exceeded maximum size; dropping...");
            f(context);
            b.b().a("cache_drop_count");
            return;
        } else
        {
            a.d("FileManager", "Cache is present but under size limit; not dropping...");
            return;
        }
    }

    boolean a()
    {
        return ((Boolean)b.a(br.aA)).booleanValue();
    }

    protected boolean a(Context context)
    {
        return n.a("android.permission.WRITE_EXTERNAL_STORAGE", context);
    }

    boolean a(ByteArrayOutputStream bytearrayoutputstream, File file)
    {
        a.d("FileManager", (new StringBuilder()).append("Writing resource to filesystem: ").append(file.getName()).toString());
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        file = fileoutputstream;
        bytearrayoutputstream.writeTo(fileoutputstream);
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = flag1;
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        fileoutputstream.close();
        flag = flag1;
_L1:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        IOException ioexception;
        ioexception;
        bytearrayoutputstream = null;
_L3:
        file = bytearrayoutputstream;
        a.e("FileManager", "Unable to write data to file", ioexception);
        if (bytearrayoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        bytearrayoutputstream.close();
        flag = false;
          goto _L1
        bytearrayoutputstream;
        flag = false;
          goto _L1
        bytearrayoutputstream;
        file = null;
_L2:
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file) { }
        throw bytearrayoutputstream;
        bytearrayoutputstream;
        obj;
        JVM INSTR monitorexit ;
        throw bytearrayoutputstream;
        bytearrayoutputstream;
        flag = flag1;
          goto _L1
        bytearrayoutputstream;
          goto _L2
        ioexception;
        bytearrayoutputstream = fileoutputstream;
          goto _L3
    }

    boolean a(File file)
    {
        a.d("FileManager", (new StringBuilder()).append("Removing file ").append(file.getName()).append(" from filesystem...").toString());
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorenter ;
_L2:
        boolean flag;
        synchronized (d)
        {
            flag = file.delete();
        }
        return flag;
        Exception exception;
        exception;
        a.e("FileManager", (new StringBuilder()).append("Failed to remove file ").append(file.getName()).append(" from filesystem!").toString(), exception);
        obj;
        JVM INSTR monitorexit ;
        return false;
        file;
        obj;
        JVM INSTR monitorexit ;
        throw file;
    }

    boolean a(File file, String s)
    {
        Object obj;
        Object obj1;
        InputStream inputstream;
        byte abyte0[];
        obj1 = null;
        inputstream = null;
        abyte0 = null;
        obj = null;
        a.d("FileManager", (new StringBuilder()).append("Starting caching of ").append(s).append(" into ").append(file.getAbsoluteFile()).toString());
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        obj1 = inputstream;
        obj = abyte0;
        httpurlconnection.setConnectTimeout(((Integer)b.a(br.t)).intValue());
        obj1 = inputstream;
        obj = abyte0;
        httpurlconnection.setReadTimeout(((Integer)b.a(br.v)).intValue());
        obj1 = inputstream;
        obj = abyte0;
        httpurlconnection.setDefaultUseCaches(true);
        obj1 = inputstream;
        obj = abyte0;
        httpurlconnection.setUseCaches(true);
        obj1 = inputstream;
        obj = abyte0;
        httpurlconnection.setAllowUserInteraction(false);
        obj1 = inputstream;
        obj = abyte0;
        httpurlconnection.setInstanceFollowRedirects(true);
        obj1 = inputstream;
        obj = abyte0;
        inputstream = httpurlconnection.getInputStream();
        obj1 = inputstream;
        obj = inputstream;
        abyte0 = new byte[1024];
_L2:
        obj1 = inputstream;
        obj = inputstream;
        int i = inputstream.read(abyte0, 0, abyte0.length);
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = inputstream;
        obj = inputstream;
        bytearrayoutputstream.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        obj;
        obj1 = inputstream;
        obj = inputstream;
        bytearrayoutputstream.close();
_L3:
        boolean flag;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        if (httpurlconnection != null)
        {
            try
            {
                httpurlconnection.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        return false;
_L1:
        obj1 = inputstream;
        obj = inputstream;
        flag = a(bytearrayoutputstream, file);
        if (!flag)
        {
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (File file) { }
            }
            if (bytearrayoutputstream != null)
            {
                try
                {
                    bytearrayoutputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (File file) { }
            }
            if (httpurlconnection != null)
            {
                try
                {
                    httpurlconnection.disconnect();
                }
                // Misplaced declaration of an exception variable
                catch (File file) { }
            }
            return false;
        }
        obj1 = inputstream;
        obj = inputstream;
        a.d("FileManager", (new StringBuilder()).append("Caching completed for ").append(file).toString());
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        if (httpurlconnection != null)
        {
            try
            {
                httpurlconnection.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        return true;
        obj1;
        httpurlconnection = null;
        bytearrayoutputstream = null;
_L5:
        a.e("FileManager", (new StringBuilder()).append("Failed to cache \"").append(s).append("\" into \"").append(file.getAbsolutePath()).append("\"").toString(), ((Throwable) (obj1)));
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        if (httpurlconnection != null)
        {
            try
            {
                httpurlconnection.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        return false;
        file;
        httpurlconnection = null;
        bytearrayoutputstream = null;
        obj = obj1;
_L4:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (httpurlconnection != null)
        {
            try
            {
                httpurlconnection.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw file;
        file;
          goto _L3
        file;
        httpurlconnection = null;
        obj = obj1;
          goto _L4
        file;
        obj = obj1;
          goto _L4
        file;
          goto _L4
        obj1;
        httpurlconnection = null;
          goto _L5
        obj1;
          goto _L5
    }

    public boolean a(String s, Context context)
    {
        boolean flag;
        synchronized (d)
        {
            flag = b(s, context, false);
        }
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    long b()
    {
        long l = ((Long)b.a(br.aB)).longValue();
        if (l >= 0L && a())
        {
            return l;
        } else
        {
            return -1L;
        }
    }

    File b(Context context)
    {
        if (a(context))
        {
            return new File(context.getExternalFilesDir(null), "al");
        } else
        {
            return new File(context.getCacheDir(), "al");
        }
    }

    public boolean b(String s, Context context, boolean flag)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        s = a(s, context, flag);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.exists() || s.isDirectory()) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    int c()
    {
        int i = ((Integer)b.a(br.aC)).intValue();
        if (i >= 0 && a())
        {
            return i;
        } else
        {
            return -1;
        }
    }

    public List c(Context context)
    {
        Object obj = b(context);
        if (((File) (obj)).isDirectory())
        {
            synchronized (d)
            {
                obj = Arrays.asList(((File) (obj)).listFiles());
            }
            return ((List) (obj));
        } else
        {
            return new ArrayList(0);
        }
        exception;
        context;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void d(Context context)
    {
        if (!a())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (b.isEnabled())
        {
            a.e("FileManager", "Cannot empty file cache after SDK has completed initialization and ad loads are in progress!");
            return;
        }
        a.d("FileManager", "Compacting cache...");
        synchronized (d)
        {
            a(e(context), context);
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a.e("FileManager", "Caught exception while compacting cache!", context);
        }
        b.getSettingsManager().a(br.aA, Boolean.valueOf(false));
        b.getSettingsManager().b();
    }

    long e(Context context)
    {
        Object obj;
        File file;
        long l;
        l = 0L;
        long l1 = b();
        boolean flag;
        boolean flag1;
        boolean flag2;
        long l2;
        if (l1 != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        obj = d;
        obj;
        JVM INSTR monitorenter ;
        context = c(context).iterator();
_L1:
        if (!context.hasNext())
        {
            break MISSING_BLOCK_LABEL_197;
        }
        file = (File)context.next();
        flag2 = false;
        flag1 = flag2;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        flag1 = flag2;
        if (l2 - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) <= l1)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        a.d("FileManager", (new StringBuilder()).append("File ").append(file.getName()).append(" has expired, removing...").toString());
        a(file);
        flag1 = true;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        b.b().a("cached_files_expired");
          goto _L1
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        l += file.length();
          goto _L1
        obj;
        JVM INSTR monitorexit ;
        return l;
    }

    void f(Context context)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        for (context = c(context).iterator(); context.hasNext(); a((File)context.next())) { }
        break MISSING_BLOCK_LABEL_49;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        obj;
        JVM INSTR monitorexit ;
    }
}
