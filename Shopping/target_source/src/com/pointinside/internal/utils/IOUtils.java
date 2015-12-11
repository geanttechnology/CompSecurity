// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import android.util.Log;
import com.google.b.f;
import com.google.b.g;
import com.google.b.t;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.internal.DateDeserializer;
import com.pointinside.internal.LongSerializer;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.pointinside.internal.utils:
//            LogUtils

public final class IOUtils
{
    public static class AnalyticsPOSTData
    {

        public List data;

        public String getJSONString()
        {
            return IOUtils.serializeToJSONString(this, new t[] {
                new LongSerializer()
            });
        }

        public transient AnalyticsPOSTData(BaseAnalyticsData abaseanalyticsdata[])
        {
            data = Arrays.asList(abaseanalyticsdata);
        }
    }


    private static final int ACCEPTABLE_STATUS_CODES[] = {
        200, 204
    };
    private static final String LOG_TAG = "IOUtils";
    private static final Map sMimeTypeExtensions;
    private static final Object semaphore = new Object();

    private IOUtils()
    {
    }

    private static void checkResponse(HttpURLConnection httpurlconnection, String s)
    {
        int ai[];
        boolean flag;
        int i;
        boolean flag1;
        int j;
        int k;
        flag1 = false;
        try
        {
            j = httpurlconnection.getResponseCode();
            ai = ACCEPTABLE_STATUS_CODES;
            k = ai.length;
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            LogUtils.logE("IOUtils", Log.getStackTraceString(httpurlconnection));
            return;
        }
        i = 0;
          goto _L1
_L5:
        LogUtils.logDebugIO(httpurlconnection.getURL().toExternalForm());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        LogUtils.logDebugIO((new StringBuilder()).append("Post_body or Response --> ").append(s).toString());
        LogUtils.logDebugIO((new StringBuilder()).append("Response Code -->").append(httpurlconnection.getResponseCode()).toString());
        if (flag)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        s = new StringBuilder();
        s.append(Integer.toString(j)).append(": ");
        httpurlconnection = httpurlconnection.getResponseMessage();
        if (httpurlconnection == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s.append(httpurlconnection);
        LogUtils.logE("IOUtils", s.toString());
        return;
_L3:
        i++;
_L1:
        flag = flag1;
        if (i >= k)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j != ai[i]) goto _L3; else goto _L2
_L2:
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void closeQuietly(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            LogUtils.logE("IOUtils", closeable.getMessage());
        }
    }

    public static Object deserializeFromJSONString(String s, Class class1)
    {
        g g1 = new g();
        g1.a(java/util/Date, new DateDeserializer());
        return g1.d().a(s, class1);
    }

    public static void downloadFile(URL url, File file, boolean flag)
        throws IOException
    {
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
        HttpURLConnection httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection(url.openConnection());
        Object obj1 = new FileOutputStream(file, flag);
        file = null;
        InputStream inputstream;
        url = new byte[1024];
        inputstream = httpurlconnection.getInputStream();
_L3:
        int i = inputstream.read(url);
        if (i <= -1) goto _L2; else goto _L1
_L1:
        ((FileOutputStream) (obj1)).write(url, 0, i);
          goto _L3
        file;
        throw file;
        url;
_L14:
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        if (file == null) goto _L7; else goto _L6
_L6:
        ((FileOutputStream) (obj1)).close();
_L5:
        throw url;
        url;
        httpurlconnection.disconnect();
        throw url;
        url;
        obj;
        JVM INSTR monitorexit ;
        throw url;
_L2:
        inputstream.close();
        ((FileOutputStream) (obj1)).flush();
        ((FileOutputStream) (obj1)).close();
        if (obj1 == null) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
        ((FileOutputStream) (obj1)).close();
_L9:
        httpurlconnection.disconnect();
        obj;
        JVM INSTR monitorexit ;
        return;
        url;
        throw new NullPointerException();
_L11:
        ((FileOutputStream) (obj1)).close();
        if (true) goto _L9; else goto _L12
_L12:
        obj1;
        file.addSuppressed(((Throwable) (obj1)));
          goto _L5
_L7:
        ((FileOutputStream) (obj1)).close();
          goto _L5
        url;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public static void enableHttpLogging()
    {
        Logger.getLogger("Feeds API").setLevel(Level.CONFIG);
    }

    private static HttpURLConnection executeHttpPostRequest(HttpURLConnection httpurlconnection, Object obj)
        throws IOException
    {
        return executeHttpPostRequest(httpurlconnection, serializeToJSONString(obj, new t[0]));
    }

    public static HttpURLConnection executeHttpPostRequest(HttpURLConnection httpurlconnection, String s)
    {
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
        executeHttpRequest(httpurlconnection, "POST");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        byte abyte0[] = s.getBytes();
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setRequestProperty("Content-Length", Integer.toString(abyte0.length));
        httpurlconnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        httpurlconnection.setUseCaches(false);
        OutputStream outputstream = httpurlconnection.getOutputStream();
        outputstream.write(abyte0);
        outputstream.close();
_L1:
        checkResponse(httpurlconnection, s);
        obj;
        JVM INSTR monitorexit ;
        return httpurlconnection;
        IOException ioexception;
        ioexception;
        LogUtils.logE("IOUtils", ioexception.getMessage());
          goto _L1
        httpurlconnection;
        obj;
        JVM INSTR monitorexit ;
        throw httpurlconnection;
    }

    public static HttpURLConnection executeHttpRequest(HttpURLConnection httpurlconnection, String s)
        throws IOException
    {
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        if (s.trim().equals(""))
        {
            throw new IllegalArgumentException("if method is non-null it cannot be an empty string");
        }
        break MISSING_BLOCK_LABEL_39;
        httpurlconnection;
        obj;
        JVM INSTR monitorexit ;
        throw httpurlconnection;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (httpurlconnection.getRequestMethod() == null)
        {
            httpurlconnection.setRequestMethod(s);
        }
        if ("GET".equals(s))
        {
            checkResponse(httpurlconnection, null);
        }
        obj;
        JVM INSTR monitorexit ;
        return httpurlconnection;
    }

    public static String getFileExtension(String s)
    {
        int i = s.lastIndexOf('.');
        if (i != -1)
        {
            return s.substring(i + 1);
        } else
        {
            return null;
        }
    }

    public static String getFileExtensionForMimeType(String s)
    {
        return (String)sMimeTypeExtensions.get(s);
    }

    public static void mkdir(File file)
        throws FileNotFoundException
    {
        if (!file.isDirectory() && !file.mkdir())
        {
            throw new FileNotFoundException((new StringBuilder()).append("Failed to create dir: ").append(file.getPath()).toString());
        } else
        {
            return;
        }
    }

    public static void mkdirs(File file)
        throws FileNotFoundException
    {
        if (!file.isDirectory() && !file.mkdirs())
        {
            throw new FileNotFoundException((new StringBuilder()).append("Failed to create dirs: ").append(file.getPath()).toString());
        } else
        {
            return;
        }
    }

    public static transient String serializeToJSONString(Object obj, t at[])
    {
        g g1 = new g();
        g1.c();
        if (at.length > 0)
        {
            int j = at.length;
            for (int i = 0; i < j; i++)
            {
                if (at[i] instanceof LongSerializer)
                {
                    g1.a(java/lang/Long, new LongSerializer());
                }
            }

        }
        return g1.d().b(obj);
    }

    static 
    {
        sMimeTypeExtensions = new HashMap();
        sMimeTypeExtensions.put("image/svg+xml", "svg");
        sMimeTypeExtensions.put("image/png", "png");
    }
}
