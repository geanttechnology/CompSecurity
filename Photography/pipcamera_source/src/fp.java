// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.fotoable.comlib.util.ImageCache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class fp extends fq
{

    private fi f;
    private File g;
    private boolean h;
    private final Object i = new Object();

    public fp(Context context, int j)
    {
        super(context, j);
        h = true;
        a(context);
    }

    private void a(Context context)
    {
        b(context);
        try
        {
            g = ImageCache.a(context, "http");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g = null;
        }
    }

    private Bitmap b(String s)
    {
        Object obj;
        Object obj2;
        obj = null;
        obj2 = ImageCache.c(s);
        Object obj3 = i;
        obj3;
        JVM INSTR monitorenter ;
_L3:
        boolean flag = h;
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj1;
        try
        {
            i.wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L3; else goto _L2
_L2:
        obj1 = f;
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        obj1 = f.a(((String) (obj2)));
        obj = obj1;
        if (obj1 != null) goto _L7; else goto _L6
_L6:
        obj = f.b(((String) (obj2)));
        if (obj == null) goto _L9; else goto _L8
_L8:
        if (!a(s, ((fj) (obj)).a(0))) goto _L11; else goto _L10
_L10:
        ((fj) (obj)).a();
_L9:
        obj = f.a(((String) (obj2)));
_L7:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_468;
        }
        s = (FileInputStream)((fm) (obj)).a(0);
        obj = s;
        obj2 = s.getFD();
        obj1 = s;
_L22:
        obj = obj1;
        s = ((String) (obj2));
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj = obj1;
        s = ((String) (obj2));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        ((FileInputStream) (obj1)).close();
        s = ((String) (obj2));
        obj = obj1;
_L15:
        obj3;
        JVM INSTR monitorexit ;
        IOException ioexception;
        if (s != null)
        {
            try
            {
                s = a(s, a, b, g());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = null;
            }
        } else
        {
            s = null;
        }
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            catch (IOException ioexception1) { }
        }
        return s;
_L11:
        ((fj) (obj)).b();
          goto _L9
        obj1;
        s = null;
_L21:
        obj = s;
        Log.e("ImageFetcher", (new StringBuilder()).append("processBitmap - ").append(obj1).toString());
        obj = s;
        if (false) goto _L13; else goto _L12
_L12:
        obj = s;
        if (s == null) goto _L13; else goto _L14
_L14:
        s.close();
        obj1 = null;
        obj = s;
        s = ((String) (obj1));
          goto _L15
        obj;
        obj1 = null;
        obj = s;
        s = ((String) (obj1));
          goto _L15
        obj1;
        s = null;
_L20:
        obj = s;
        Log.e("ImageFetcher", (new StringBuilder()).append("processBitmap - ").append(obj1).toString());
        obj = s;
        if (false) goto _L13; else goto _L16
_L16:
        obj = s;
        if (s == null) goto _L13; else goto _L17
_L17:
        s.close();
        obj1 = null;
        obj = s;
        s = ((String) (obj1));
          goto _L15
        obj;
        obj1 = null;
        obj = s;
        s = ((String) (obj1));
          goto _L15
        s;
        obj = null;
_L19:
        if (false || obj == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        throw s;
        obj3;
        JVM INSTR monitorexit ;
        throw s;
_L5:
        Log.d("ImageFetcher", " not mHttpDiskCache - ");
        obj1 = a(s);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_387;
        }
        Log.d("ImageFetcher", " resultbytes not null - ");
        obj = BitmapFactory.decodeByteArray(((byte []) (obj1)), 0, obj1.length);
_L18:
        obj3;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
        obj;
        obj1 = new HashMap();
        obj = s;
        if (s == null)
        {
            obj = "null";
        }
        ((HashMap) (obj1)).put("url", obj);
        obj = null;
          goto _L18
        s;
        obj = obj1;
        s = ((String) (obj2));
          goto _L15
        s;
          goto _L19
        obj1;
          goto _L20
        obj1;
          goto _L21
_L13:
        s = null;
          goto _L15
        obj1 = null;
        obj2 = null;
          goto _L22
    }

    private void b(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null || !context.isConnectedOrConnecting())
        {
            Log.e("ImageFetcher", "checkConnection - no connection found");
        }
    }

    public static void e()
    {
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void k()
    {
        if (g == null)
        {
            f = null;
            h = false;
            return;
        }
        if (!g.exists())
        {
            g.mkdirs();
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = g.isDirectory();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (ImageCache.a(g) > 0xa00000L)
        {
            f = fi.a(g, 1, 1, 0xa00000L);
        }
_L1:
        h = false;
        i.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        f = null;
          goto _L1
        f = null;
          goto _L1
    }

    protected Bitmap a(Object obj)
    {
        return b(String.valueOf(obj));
    }

    protected void a()
    {
        super.a();
        k();
    }

    public boolean a(String s, OutputStream outputstream)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3 = null;
        obj2 = null;
        e();
        int j;
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            outputstream = null;
            obj = null;
            obj1 = obj2;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            outputstream = null;
            obj = null;
            obj1 = obj3;
        }
        try
        {
            obj = new BufferedInputStream(s.getInputStream(), 8192);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            obj = s;
            s = outputstream;
            outputstream = null;
            obj1 = obj2;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = s;
            s = outputstream;
            outputstream = null;
            obj1 = obj3;
        }
        obj1 = new BufferedOutputStream(outputstream, 8192);
_L3:
        j = ((BufferedInputStream) (obj)).read();
        if (j == -1) goto _L2; else goto _L1
_L1:
        ((BufferedOutputStream) (obj1)).write(j);
          goto _L3
        obj2;
        outputstream = s;
        s = ((String) (obj2));
        obj2 = obj;
        obj = outputstream;
        outputstream = ((OutputStream) (obj2));
_L5:
        Log.e("ImageFetcher", (new StringBuilder()).append("Error in downloadBitmap - ").append(s).toString());
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        ((BufferedOutputStream) (obj1)).close();
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return false;
_L2:
        if (s != null)
        {
            s.disconnect();
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        ((BufferedOutputStream) (obj1)).close();
        IOException ioexception;
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return true;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        ((BufferedOutputStream) (obj1)).close();
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (OutputStream outputstream) { }
        }
        throw s;
        obj1;
        outputstream = ((OutputStream) (obj));
        obj = s;
        s = ((String) (obj1));
        obj1 = obj3;
        break MISSING_BLOCK_LABEL_180;
        outputstream;
        obj2 = s;
        s = outputstream;
        outputstream = ((OutputStream) (obj));
        obj = obj2;
        break MISSING_BLOCK_LABEL_180;
        s;
        break MISSING_BLOCK_LABEL_180;
        ioexception;
        outputstream = ((OutputStream) (obj));
        obj = s;
        s = ioexception;
        ioexception = ((IOException) (obj2));
        if (true) goto _L5; else goto _L4
_L4:
    }

    public byte[] a(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        s = (new URL(s)).openStream();
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[4096];
_L1:
        int j = s.read(abyte0);
label0:
        {
            if (j == -1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream.write(abyte0, 0, j);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
        }
          goto _L1
        abyte0 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        s.close();
        return abyte0;
    }

    protected void b()
    {
        super.b();
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (f == null) goto _L2; else goto _L1
_L1:
        boolean flag = f.a();
        if (flag) goto _L2; else goto _L3
_L3:
        f.c();
_L4:
        f = null;
        h = true;
        k();
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Log.e("ImageFetcher", (new StringBuilder()).append("clearCacheInternal - ").append(obj1).toString());
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    protected void c()
    {
        super.c();
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        fi fi1 = f;
        if (fi1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        f.b();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Log.e("ImageFetcher", (new StringBuilder()).append("flush - ").append(obj1).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    protected void d()
    {
        super.d();
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        fi fi1 = f;
        if (fi1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (!f.a())
        {
            f.close();
            f = null;
        }
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Log.e("ImageFetcher", (new StringBuilder()).append("closeCacheInternal - ").append(obj1).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }
}
