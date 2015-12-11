// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseException, ParseRESTCommand, ParseTaskUtils, ParseObject

class ParseTestUtils
{

    private static final Object TEST_SERVER_LOCK = new Object();
    private static final AtomicBoolean strictModeEnabled = new AtomicBoolean(false);
    private static String testServer;

    ParseTestUtils()
    {
    }

    public static void clearApp()
    {
        ParseRESTCommand parserestcommand = new ParseRESTCommand("rest_clear_app", ParseRequest.Method.POST, new JSONObject(), null);
        try
        {
            ParseTaskUtils.wait(parserestcommand.executeAsync());
            return;
        }
        catch (ParseException parseexception)
        {
            throw new RuntimeException(parseexception.getMessage());
        }
    }

    private static String getTestServer(Context context)
    {
        if (testServer != null) goto _L2; else goto _L1
_L1:
        Object obj = TEST_SERVER_LOCK;
        obj;
        JVM INSTR monitorenter ;
        String s = testServer;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        testServer = (new BufferedReader(new InputStreamReader(context.getAssets().open("server.config")))).readLine();
_L3:
        obj;
        JVM INSTR monitorexit ;
_L2:
        return testServer;
        context;
        if (!Build.PRODUCT.contains("vbox"))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        testServer = "http://192.168.56.1:3000";
          goto _L3
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
label0:
        {
            if (!Build.PRODUCT.contains("sdk") && !Build.PRODUCT.contains("full_x86"))
            {
                break label0;
            }
            testServer = "http://10.0.2.2:3000";
        }
          goto _L3
        testServer = "http://localhost:3000";
          goto _L3
    }

    public static void setStrictModeEnabledForMainThread(boolean flag)
    {
        AtomicBoolean atomicboolean = strictModeEnabled;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (atomicboolean.compareAndSet(flag1, flag))
        {
            Semaphore semaphore = new Semaphore(0);
            (new Handler(Looper.getMainLooper())).post(new Runnable(flag, semaphore) {

                final Semaphore val$done;
                final boolean val$enabled;

                public void run()
                {
                    ParseTestUtils.setStrictModeEnabledForThisThread(enabled);
                    done.release();
                }

            
            {
                enabled = flag;
                done = semaphore;
                super();
            }
            });
            semaphore.acquireUninterruptibly();
        }
    }

    public static void setStrictModeEnabledForThisThread(boolean flag)
    {
        if (flag)
        {
            StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).detectAll().penaltyLog().penaltyDeath().build());
            return;
        } else
        {
            StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).detectAll().penaltyLog().build());
            return;
        }
    }

    public static void setTestServer(String s)
    {
        synchronized (TEST_SERVER_LOCK)
        {
            testServer = s;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static String useBadServerPort()
    {
        return useBadServerPort(ParseObject.server);
    }

    public static String useBadServerPort(String s)
    {
        String s1 = "http://10.0.2.2:6000";
        try
        {
            s = new URL(s);
            s = (new StringBuilder()).append(s.getProtocol()).append("://").append(s.getHost()).append(":").append(s.getPort() + 999).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s1;
        }
        return useServer(s);
    }

    public static String useInvalidServer()
    {
        return useServer("http://invalid.server:3000");
    }

    public static String useServer(String s)
    {
        String s1 = ParseObject.server;
        ParseObject.server = s;
        return s1;
    }

    public static String useTestServer(Context context)
    {
        return useServer(getTestServer(context));
    }

}
