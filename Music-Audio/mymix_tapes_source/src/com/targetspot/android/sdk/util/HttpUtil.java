// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.os.Handler;
import android.os.Message;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

public final class HttpUtil
{
    public static class HttpHandler extends Handler
    {

        public static final int ERROR = 0;
        public static final int SUCCESS_JSON = 2;
        public static final int SUCCESS_STR = 1;

        public void handleError(Throwable throwable)
        {
        }

        public void handleJSONObject(JSONObject jsonobject)
        {
        }

        public void handleMessage(Message message)
        {
            if (message.what != 0) goto _L2; else goto _L1
_L1:
            if (message.obj == null) goto _L4; else goto _L3
_L3:
            if (!(message.obj instanceof Throwable)) goto _L6; else goto _L5
_L5:
            handleError((Throwable)message.obj);
_L8:
            return;
_L6:
            if (message.obj instanceof String)
            {
                handleError(new NullPointerException((String)message.obj));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            handleError(new NullPointerException());
            return;
_L2:
            if (message.what == 1)
            {
                if (message.obj == null)
                {
                    handleString(null);
                    return;
                }
                if (message.obj instanceof String)
                {
                    handleString((String)message.obj);
                    return;
                } else
                {
                    handleString(null);
                    return;
                }
            }
            if (message.what == 2)
            {
                if (message.obj == null)
                {
                    handleJSONObject(new JSONObject());
                    return;
                }
                if (message.obj instanceof JSONObject)
                {
                    handleJSONObject((JSONObject)message.obj);
                    return;
                }
                if (message.obj instanceof String)
                {
                    JSONObject jsonobject = new JSONObject();
                    try
                    {
                        message = new JSONObject((String)message.obj);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        message = jsonobject;
                    }
                    handleJSONObject(message);
                    return;
                } else
                {
                    handleJSONObject(new JSONObject());
                    return;
                }
            }
            if (true) goto _L8; else goto _L7
_L7:
        }

        public void handleString(String s)
        {
        }

        public HttpHandler()
        {
        }
    }


    private static ExecutorService pool = Executors.newFixedThreadPool(20);

    private HttpUtil()
    {
    }

    public static void asyncReadJSONObject(String s, HttpHandler httphandler)
    {
        pool.execute(new Runnable(s, httphandler) {

            final HttpHandler val$handler;
            final String val$url;

            public void run()
            {
                try
                {
                    JSONObject jsonobject = HttpUtil.readJSONObject(url);
                    if (handler != null)
                    {
                        Message.obtain(handler, 2, jsonobject).sendToTarget();
                    }
                    return;
                }
                catch (Throwable throwable)
                {
                    if (handler != null)
                    {
                        Message.obtain(handler, 0, throwable).sendToTarget();
                        return;
                    } else
                    {
                        throwable.printStackTrace();
                        return;
                    }
                }
            }

            
            {
                url = s;
                handler = httphandler;
                super();
            }
        });
    }

    public static void asyncReadUrl(String s, boolean flag, HttpHandler httphandler)
    {
        pool.execute(new Runnable(s, flag, httphandler) {

            final HttpHandler val$handler;
            final boolean val$isCompressed;
            final String val$url;

            public void run()
            {
                try
                {
                    String s1 = HttpUtil.readUrl(url, isCompressed);
                    if (handler != null)
                    {
                        Message.obtain(handler, 1, s1).sendToTarget();
                    }
                    return;
                }
                catch (Throwable throwable)
                {
                    if (handler != null)
                    {
                        Message.obtain(handler, 0, throwable).sendToTarget();
                        return;
                    } else
                    {
                        throwable.printStackTrace();
                        return;
                    }
                }
            }

            
            {
                url = s;
                isCompressed = flag;
                handler = httphandler;
                super();
            }
        });
    }

    public static void downloadFile(String s, File file, boolean flag)
        throws IOException
    {
        Object obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), 15000);
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), 15000);
        obj = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj)));
        s = new HttpGet(s);
        s.addHeader("Cache-Control", "no-cache");
        if (flag)
        {
            s.addHeader("Accept-Encoding", "gzip,deflate");
        }
        s = ((HttpClient) (obj)).execute(s);
        if (s.getStatusLine().getStatusCode() == 200)
        {
            storeResponse(s, file);
        }
        ((HttpClient) (obj)).getConnectionManager().shutdown();
    }

    public static InputStream getInputStream(HttpResponse httpresponse)
        throws IOException
    {
        boolean flag1 = false;
        boolean flag = false;
        Header aheader[] = httpresponse.getHeaders("Content-Encoding");
        if (aheader != null)
        {
            int i = 0;
            int j = aheader.length;
            do
            {
                flag1 = flag;
                if (i >= j)
                {
                    break;
                }
                flag1 = flag;
                if (aheader[i].getName().toLowerCase().equals("content-encoding"))
                {
                    flag1 = flag;
                    if (aheader[i].getValue().toLowerCase().equals("gzip"))
                    {
                        flag1 = true;
                    }
                }
                i++;
                flag = flag1;
            } while (true);
        }
        if (flag1)
        {
            return new GZIPInputStream(httpresponse.getEntity().getContent());
        } else
        {
            return httpresponse.getEntity().getContent();
        }
    }

    private static String readInputStream(InputStream inputstream)
        throws IOException
    {
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            String s = inputstream.readLine();
            if (s != null)
            {
                stringbuffer.append(s);
                stringbuffer.append("\n");
            } else
            {
                inputstream.close();
                return stringbuffer.toString().trim();
            }
        } while (true);
    }

    public static JSONObject readJSONObject(String s)
        throws IOException, JSONException
    {
        return new JSONObject(readUrl(s, true));
    }

    public static String readResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        Object obj;
        BufferedInputStream bufferedinputstream;
        try
        {
            bufferedinputstream = new BufferedInputStream(httpurlconnection.getInputStream());
        }
        catch (IOException ioexception)
        {
            httpurlconnection = readInputStream(httpurlconnection.getErrorStream());
            throw new IOException((new StringBuilder()).append("getInputStream failed: ").append(httpurlconnection).toString());
        }
        obj = bufferedinputstream;
        if ("gzip".equals(httpurlconnection.getContentEncoding()))
        {
            obj = new GZIPInputStream(bufferedinputstream);
        }
        return readInputStream(((InputStream) (obj)));
    }

    public static String readResponse(HttpResponse httpresponse)
        throws IOException
    {
        httpresponse = new BufferedReader(new InputStreamReader(getInputStream(httpresponse), "UTF-8"));
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            String s = httpresponse.readLine();
            if (s != null)
            {
                stringbuffer.append(s);
                stringbuffer.append("\n");
            } else
            {
                httpresponse.close();
                return stringbuffer.toString().trim();
            }
        } while (true);
    }

    public static String readUrl(String s, boolean flag)
        throws IOException
    {
        Object obj;
        obj = new URL(s);
        s = null;
        obj = (HttpURLConnection)((URL) (obj)).openConnection();
        s = ((String) (obj));
        ((HttpURLConnection) (obj)).setUseCaches(false);
        s = ((String) (obj));
        ((HttpURLConnection) (obj)).setConnectTimeout(15000);
        s = ((String) (obj));
        ((HttpURLConnection) (obj)).setRequestProperty("Cache-Control", "no-cache");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        s = ((String) (obj));
        ((HttpURLConnection) (obj)).setRequestProperty("Accept-Encoding", "gzip,deflate");
        s = ((String) (obj));
        ((HttpURLConnection) (obj)).connect();
        s = ((String) (obj));
        String s1 = readResponse(((HttpURLConnection) (obj)));
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        return s1;
        Exception exception;
        exception;
        if (s != null)
        {
            s.disconnect();
        }
        throw exception;
    }

    public static void storeResponse(HttpResponse httpresponse, File file)
        throws IOException
    {
        httpresponse = getInputStream(httpresponse);
        file = new FileOutputStream(file);
        byte abyte0[] = new byte[8192];
        do
        {
            int i = httpresponse.read(abyte0, 0, abyte0.length);
            if (i < 0)
            {
                file.close();
                return;
            }
            file.write(abyte0, 0, i);
        } while (true);
    }

}
