// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.google.b.t;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.net.url.URLBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class WebserviceRequestor
{

    public static final long DEFAULT_DATE = -1L;
    private static final int INPUT_BUFFER_LENGTH = 1024;
    public final URLBuilder URL;
    protected long lastNetworkDate;
    protected long lastNetworkDuration;
    private long lastParseDate;
    private long lastParseDuration;
    protected String lastPostBody;
    private JSONResponse lastResponse;
    private String lastResponsePayload;
    private final JSONResponse responseType;

    protected WebserviceRequestor(URLBuilder urlbuilder, JSONResponse jsonresponse)
    {
        lastNetworkDate = -1L;
        lastNetworkDuration = -1L;
        lastParseDate = -1L;
        lastParseDuration = -1L;
        lastPostBody = null;
        URL = urlbuilder;
        responseType = jsonresponse;
    }

    private static String readStream(InputStream inputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(1024);
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return bytearrayoutputstream.toString();
            }
        } while (true);
    }

    public List fetchAll()
        throws IOException
    {
        lastNetworkDate = System.currentTimeMillis();
        List list;
        HttpURLConnection httpurlconnection = URL.openConnection();
        list = parseResponse(IOUtils.executeHttpRequest(httpurlconnection, "GET"));
        httpurlconnection.disconnect();
        LogUtils.logDebugIO(httpurlconnection.getURL().toExternalForm());
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        LogUtils.logDebugIO(String.format("network connection open for %d ms", new Object[] {
            Long.valueOf(lastNetworkDuration)
        }));
        return list;
        Exception exception;
        exception;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        LogUtils.logDebugIO(String.format("network connection open for %d ms", new Object[] {
            Long.valueOf(lastNetworkDuration)
        }));
        throw exception;
    }

    public List fetchAll(Object obj)
        throws IOException
    {
        lastNetworkDate = System.currentTimeMillis();
        HttpURLConnection httpurlconnection = URL.openConnection();
        lastPostBody = IOUtils.serializeToJSONString(obj, new t[0]);
        obj = parseResponse(IOUtils.executeHttpPostRequest(httpurlconnection, lastPostBody));
        httpurlconnection.disconnect();
        LogUtils.logDebugIO(httpurlconnection.getURL().toExternalForm());
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        LogUtils.logDebugIO(String.format("network connection open for %d ms", new Object[] {
            Long.valueOf(lastNetworkDuration)
        }));
        return ((List) (obj));
        obj;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        LogUtils.logDebugIO(String.format("network connection open for %d ms", new Object[] {
            Long.valueOf(lastNetworkDuration)
        }));
        throw obj;
    }

    protected String fetchResponsePayload(HttpURLConnection httpurlconnection)
        throws IOException
    {
        lastParseDate = System.currentTimeMillis();
        httpurlconnection = new InputStreamReader(httpurlconnection.getInputStream());
        StringBuilder stringbuilder = new StringBuilder();
        char ac[] = new char[1024];
        do
        {
            int i = httpurlconnection.read(ac);
            if (i > -1)
            {
                char ac1[] = new char[i];
                System.arraycopy(ac, 0, ac1, 0, i);
                stringbuilder.append(ac1);
            } else
            {
                lastResponsePayload = stringbuilder.toString();
                LogUtils.logDebugIO((new StringBuilder()).append("Response --> ").append(lastResponsePayload).toString());
                httpurlconnection.close();
                return lastResponsePayload;
            }
        } while (true);
    }

    protected Map getDeserializers()
    {
        return null;
    }

    public final String getLastSerializedPostBody()
    {
        return lastPostBody;
    }

    public long getLatestNetworkDate()
    {
        return lastNetworkDate;
    }

    public long getLatestNetworkDuration()
    {
        return lastNetworkDuration;
    }

    public long getLatestParseDate()
    {
        return lastParseDate;
    }

    public long getLatestParseDuration()
    {
        return lastParseDuration;
    }

    public String getLatestResponsePayload()
    {
        return lastResponsePayload;
    }

    public JSONResponse getResponse()
    {
        return lastResponse;
    }

    List parseAsList(String s)
        throws IOException
    {
        parseAsObject(s);
        List list = (List)lastResponse.getData();
        if (list == null)
        {
            throw new IllegalStateException("JSONResponse.getData() returned a null value.");
        }
        s = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            try
            {
                s.add(obj);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                obj = new RuntimeException((new StringBuilder()).append("JSON response did not return the proper type. Received ").append(obj.getClass().getSimpleName()).toString());
                ((RuntimeException) (obj)).initCause(s);
                throw obj;
            }
        } while (true);
        return s;
    }

    Object parseAsObject(String s)
        throws IOException
    {
        lastResponse = (JSONResponse)IOUtils.deserializeFromJSONString(s, responseType.getClass());
        lastParseDuration = System.currentTimeMillis() - lastParseDate;
        LogUtils.logDebugIO(String.format("request parse %d ms", new Object[] {
            Long.valueOf(lastParseDuration)
        }));
        return lastResponse.getData();
    }

    protected final List parseResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        return parseAsList(fetchResponsePayload(httpurlconnection));
    }

    protected final Object parseResponseAsObject(HttpURLConnection httpurlconnection)
        throws IOException
    {
        return parseAsObject(fetchResponsePayload(httpurlconnection));
    }

    public final List updateCacheOnly(Map map)
        throws IOException
    {
        boolean flag;
        if (map == null)
        {
            throw new IllegalArgumentException("cacheData cannot be null");
        }
        flag = URL.updateCache;
        URL.updateCache = true;
        lastNetworkDate = System.currentTimeMillis();
        HttpURLConnection httpurlconnection = URL.openConnection();
        lastPostBody = IOUtils.serializeToJSONString(map, new t[0]);
        IOUtils.executeHttpPostRequest(httpurlconnection, lastPostBody);
        URL.updateCache = flag;
        map = parseResponse(httpurlconnection);
        httpurlconnection.disconnect();
        LogUtils.logDebugIO(httpurlconnection.getURL().toExternalForm());
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        LogUtils.logDebugIO(String.format("network connection open for %d ms", new Object[] {
            Long.valueOf(lastNetworkDuration)
        }));
        return map;
        map;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        LogUtils.logDebugIO(String.format("network connection open for %d ms", new Object[] {
            Long.valueOf(lastNetworkDuration)
        }));
        throw map;
    }
}
