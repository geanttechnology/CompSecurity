// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import android.webkit.URLUtil;
import com.immersion.hapticmediasdk.b.b;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.immersion.hapticmediasdk:
//            a, d

public final class c extends com.immersion.hapticmediasdk.a
{
    private final class a
        implements Runnable
    {

        public static int b = 24;
        public static int c = 1;
        public static int d = 2;
        public final c a;
        private URL e;

        private void a(int i1)
        {
            this;
            JVM INSTR monitorenter ;
            c.a(a, i1);
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void run()
        {
            HttpURLConnection httpurlconnection;
            httpurlconnection = (HttpURLConnection)e.openConnection();
            httpurlconnection.setConnectTimeout(10000);
            httpurlconnection.setReadTimeout(10000);
            httpurlconnection.setUseCaches(false);
            int i1 = b;
            switch ((i1 * (c + i1)) % d)
            {
            default:
                b = 0;
                c = 6;
                break;

            case 0: // '\0'
                break;
            }
            int j1;
            httpurlconnection.setRequestMethod("HEAD");
            j1 = httpurlconnection.getResponseCode();
            Object obj;
            try
            {
                a(j1);
                return;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            obj;
            com.immersion.hapticmediasdk.b.b.a("ValidateURL", ((IOException) (obj)).getMessage());
            try
            {
                a(500);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw obj;
            }
            obj;
            a(500);
            throw obj;
        }

        public a()
        {
            a = c.this;
            do
            {
            } while (true);
        }
    }


    public static int h = 13;
    public static int i = 0;
    public static int j = 1;
    public static int k = 2;
    private int l;

    public c(Context context)
    {
        try
        {
            super(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
        if (((h + j) * h) % k != i)
        {
            h = 61;
            i = 61;
        }
        try
        {
            l = 400;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
    }

    public static int a(c c1, int i1)
    {
        if (((j + 61) * 61) % k != i)
        {
            h = 4;
            i = 61;
        }
        try
        {
            c1.l = i1;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        return i1;
    }

    private boolean b(String s)
    {
        boolean flag1 = false;
        s.replaceFirst("https", "http");
        InterruptedException interruptedexception;
        int i1;
        boolean flag;
        try
        {
            s = new a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.immersion.hapticmediasdk.b.b.a("HapticContentSDK", s.getMessage());
            return false;
        }
        (new Thread(s, "ping url")).start();
        s;
        JVM INSTR monitorenter ;
        l = -100;
_L2:
        i1 = l;
        Exception exception;
label0:
        {
            if (i1 >= 0)
            {
                break label0;
            }
            try
            {
                s.wait(100L);
            }
            // Misplaced declaration of an exception variable
            catch (InterruptedException interruptedexception) { }
            finally { }
        }
        if (true) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (200 > l)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        flag = flag1;
        if (l <= 399)
        {
            flag = true;
        }
        s;
        JVM INSTR monitorexit ;
        return flag;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int c(String s)
    {
        if (s == null)
        {
            com.immersion.hapticmediasdk.b.b.a("HapticContentSDK", "invalid local hapt file url: null");
            return -4;
        }
        File file = new File(s);
        if (file.isFile())
        {
            if (file.canRead())
            {
                c.a(s, false);
                return c.a(com.immersion.hapticmediasdk.a.a.b);
            } else
            {
                com.immersion.hapticmediasdk.b.b.a("HapticContentSDK", "could not access local hapt file: permission denied");
                return -3;
            }
        } else
        {
            com.immersion.hapticmediasdk.b.b.a("HapticContentSDK", "invalid local hapt file url: directory");
            return -4;
        }
    }

    public final int a(String s)
    {
_L2:
        if (URLUtil.isFileUrl(s))
        {
            return c(s);
        } else
        {
            com.immersion.hapticmediasdk.b.b.a("HapticContentSDK", "could not access hapt file url: unsupposted protocol");
            return -5;
        }
        a.a a1 = b();
        if (a1 != a.a.d && a1 != a.a.a && a1 != com.immersion.hapticmediasdk.a.a.b && a1 != a.a.e)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        int i1 = c.a(a.a.a);
        if (i1 != 0)
        {
            return i1;
        }
        if (!URLUtil.isValidUrl(s))
        {
            return c(s);
        }
        if (!URLUtil.isHttpUrl(s) && !URLUtil.isHttpsUrl(s)) goto _L2; else goto _L1
_L1:
        if (!b(s))
        {
            com.immersion.hapticmediasdk.b.b.a("HapticContentSDK", "could not access hapt file url: Inaccessible URL");
            return -2;
        } else
        {
            c.a(s, true);
            return c.a(com.immersion.hapticmediasdk.a.a.b);
        }
        return -1;
    }
}
