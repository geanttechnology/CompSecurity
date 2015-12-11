// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.http;

import android.os.Build;
import android.util.Base64;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.util.UAStringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.urbanairship.http:
//            Response

public class Request
{

    private static final String USER_AGENT_FORMAT = "%s (%s; %s; UrbanAirshipLib-%s/%s; %s; %s)";
    protected String body;
    private boolean compressRequestBody;
    protected String contentType;
    private long ifModifiedSince;
    protected String password;
    protected String requestMethod;
    protected final Map responseProperties = new HashMap();
    protected URL url;
    protected String user;

    public Request(String s, URL url1)
    {
        ifModifiedSince = 0L;
        compressRequestBody = false;
        requestMethod = s;
        url = url1;
        responseProperties.put("User-Agent", getUrbanAirshipUserAgent());
    }

    public static String getUrbanAirshipUserAgent()
    {
        String s;
        if (UAirship.shared().getPlatformType() == 1)
        {
            s = "amazon";
        } else
        {
            s = "android";
        }
        return String.format(Locale.US, "%s (%s; %s; UrbanAirshipLib-%s/%s; %s; %s)", new Object[] {
            UAirship.getPackageName(), Build.MODEL, android.os.Build.VERSION.RELEASE, s, UAirship.getVersion(), UAirship.shared().getAirshipConfigOptions().getAppKey(), Locale.getDefault()
        });
    }

    private String readEntireStream(InputStream inputstream)
    {
        BufferedReader bufferedreader;
        Object obj;
        if (inputstream == null)
        {
            return null;
        }
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        obj = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ((StringBuilder) (obj)).append(s).append("\n");
          goto _L1
        obj;
        try
        {
            inputstream.close();
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Logger.error("Failed to close streams", inputstream);
        }
        throw obj;
        bufferedreader.close();
        try
        {
            inputstream.close();
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Logger.error("Failed to close streams", inputstream);
        }
        return ((StringBuilder) (obj)).toString();
    }

    public Response execute()
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setRequestMethod(requestMethod);
        if (body != null)
        {
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setRequestProperty("Content-Type", contentType);
        }
        httpurlconnection.setDoInput(true);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setAllowUserInteraction(false);
        if (ifModifiedSince > 0L)
        {
            httpurlconnection.setIfModifiedSince(ifModifiedSince);
        }
        String s;
        for (Iterator iterator = responseProperties.keySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty(s, (String)responseProperties.get(s)))
        {
            s = (String)iterator.next();
        }

          goto _L1
        Object obj;
        obj;
_L9:
        Logger.debug((new StringBuilder("Request - Request failed URL: ")).append(url).append(" method: ").append(requestMethod).toString(), ((Throwable) (obj)));
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return null;
_L1:
        if (!UAStringUtil.isEmpty(user) && !UAStringUtil.isEmpty(password))
        {
            obj = (new StringBuilder()).append(user).append(":").append(password).toString();
            httpurlconnection.setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString(((String) (obj)).getBytes(), 2)).toString());
        }
        if (body == null) goto _L3; else goto _L2
_L2:
        if (!compressRequestBody) goto _L5; else goto _L4
_L4:
        httpurlconnection.setRequestProperty("Content-Encoding", "gzip");
        obj = httpurlconnection.getOutputStream();
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(((OutputStream) (obj)));
        OutputStreamWriter outputstreamwriter1 = new OutputStreamWriter(gzipoutputstream, "UTF-8");
        outputstreamwriter1.write(body);
        outputstreamwriter1.close();
        gzipoutputstream.close();
        ((OutputStream) (obj)).close();
_L3:
        obj = (new Response.Builder(httpurlconnection.getResponseCode())).setResponseMessage(httpurlconnection.getResponseMessage()).setResponseHeaders(httpurlconnection.getHeaderFields()).setLastModified(httpurlconnection.getLastModified());
        ((Response.Builder) (obj)).setResponseBody(readEntireStream(httpurlconnection.getInputStream()));
_L6:
        obj = ((Response.Builder) (obj)).create();
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return ((Response) (obj));
_L5:
        obj = httpurlconnection.getOutputStream();
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(((OutputStream) (obj)), "UTF-8");
        outputstreamwriter.write(body);
        outputstreamwriter.close();
        ((OutputStream) (obj)).close();
          goto _L3
        obj;
_L7:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw obj;
        IOException ioexception;
        ioexception;
        ((Response.Builder) (obj)).setResponseBody(readEntireStream(httpurlconnection.getErrorStream()));
          goto _L6
        obj;
        httpurlconnection = null;
          goto _L7
        obj;
          goto _L7
        obj;
        httpurlconnection = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public Request setCompressRequestBody(boolean flag)
    {
        compressRequestBody = flag;
        return this;
    }

    public Request setCredentials(String s, String s1)
    {
        user = s;
        password = s1;
        return this;
    }

    public Request setHeader(String s, String s1)
    {
        if (s1 == null)
        {
            responseProperties.remove(s);
            return this;
        } else
        {
            responseProperties.put(s, s1);
            return this;
        }
    }

    public Request setIfModifiedSince(long l)
    {
        ifModifiedSince = l;
        return this;
    }

    public Request setRequestBody(String s, String s1)
    {
        body = s;
        contentType = s1;
        return this;
    }
}
