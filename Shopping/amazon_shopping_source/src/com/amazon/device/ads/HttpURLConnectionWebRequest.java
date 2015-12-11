// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            WebRequest, Log, Utils

class HttpURLConnectionWebRequest extends WebRequest
{

    private static final String LOG_TAG = com/amazon/device/ads/HttpURLConnectionWebRequest.getSimpleName();

    HttpURLConnectionWebRequest()
    {
    }

    private void writePostBody(HttpURLConnection httpurlconnection)
        throws WebRequest.WebRequestException
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (requestBody == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append(requestBody);
_L4:
        Object obj;
        Object obj1;
        if (logRequestBodyEnabled && getRequestBody() != null)
        {
            Log.d(getLogTag(), "Request Body: %s", new Object[] {
                getRequestBody()
            });
        }
        obj = null;
        obj1 = null;
        httpurlconnection = new OutputStreamWriter(httpurlconnection.getOutputStream(), "UTF-8");
        httpurlconnection.write(stringbuilder.toString());
        if (httpurlconnection == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        httpurlconnection.close();
        return;
_L2:
        if (postParameters != null && !postParameters.isEmpty())
        {
            for (obj = postParameters.entrySet().iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((String)((java.util.Map.Entry) (obj1)).getKey()).append("=").append(Utils.getURLEncodedString((String)((java.util.Map.Entry) (obj1)).getValue())).append("&"))
            {
                obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

            stringbuilder.deleteCharAt(stringbuilder.lastIndexOf("&"));
        }
        if (true) goto _L4; else goto _L3
_L3:
        httpurlconnection;
        Log.e(getLogTag(), "Problem while closing output stream writer for request body: %s", new Object[] {
            httpurlconnection.getMessage()
        });
        throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while closing output stream writer for request body", httpurlconnection);
        obj;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj1 = obj;
_L8:
        obj = httpurlconnection;
        Log.e(getLogTag(), "Problem while creating output steam for request body: %s", new Object[] {
            ((IOException) (obj1)).getMessage()
        });
        obj = httpurlconnection;
        throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while creating output steam for request body", ((Throwable) (obj1)));
        httpurlconnection;
_L6:
        if (obj != null)
        {
            try
            {
                ((OutputStreamWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                Log.e(getLogTag(), "Problem while closing output stream writer for request body: %s", new Object[] {
                    httpurlconnection.getMessage()
                });
                throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while closing output stream writer for request body", httpurlconnection);
            }
        }
        throw httpurlconnection;
        obj1;
        obj = httpurlconnection;
        httpurlconnection = ((HttpURLConnection) (obj1));
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected WebRequest.WebResponse doHttpNetworkCall(URL url)
        throws WebRequest.WebRequestException
    {
        try
        {
            url = openConnection(url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e(getLogTag(), "Problem while opening the URL connection: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while opening the URL connection", url);
        }
        setupRequestProperties(url);
        try
        {
            url.connect();
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e(getLogTag(), "Socket timed out while connecting to URL: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_TIMEOUT, "Socket timed out while connecting to URL", url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e(getLogTag(), "Problem while connecting to URL: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while connecting to URL", url);
        }
        return prepareResponse(url);
    }

    protected String getSubLogTag()
    {
        return LOG_TAG;
    }

    protected HttpURLConnection openConnection(URL url)
        throws IOException
    {
        return (HttpURLConnection)url.openConnection();
    }

    protected WebRequest.WebResponse prepareResponse(HttpURLConnection httpurlconnection)
        throws WebRequest.WebRequestException
    {
        WebRequest.WebResponse webresponse = new WebRequest.WebResponse(this);
        webresponse.setLogTag(getLogTag());
        webresponse.enableLog(logResponseEnabled);
        try
        {
            webresponse.setHttpStatusCode(httpurlconnection.getResponseCode());
            webresponse.setHttpStatus(httpurlconnection.getResponseMessage());
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            Log.e(getLogTag(), "Socket Timeout while getting the response status code: %s", new Object[] {
                httpurlconnection.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_TIMEOUT, "Socket Timeout while getting the response status code", httpurlconnection);
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            Log.e(getLogTag(), "IOException while getting the response status code: %s", new Object[] {
                httpurlconnection.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException while getting the response status code", httpurlconnection);
        }
        if (webresponse.getHttpStatusCode() == 200)
        {
            try
            {
                webresponse.setInputStream(httpurlconnection.getInputStream());
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                Log.e(getLogTag(), "IOException while reading the input stream from response: %s", new Object[] {
                    httpurlconnection.getMessage()
                });
                throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", httpurlconnection);
            }
        }
        return webresponse;
    }

    protected void setupRequestProperties(HttpURLConnection httpurlconnection)
        throws WebRequest.WebRequestException
    {
        Iterator iterator;
        try
        {
            httpurlconnection.setRequestMethod(getHttpMethod().name());
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            Log.e(getLogTag(), "Invalid client protocol: %s", new Object[] {
                httpurlconnection.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", httpurlconnection);
        }
        iterator = headers.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() != null && !((String)entry.getValue()).equals(""))
            {
                httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
            }
        } while (true);
        httpurlconnection.setConnectTimeout(getTimeout());
        httpurlconnection.setReadTimeout(getTimeout());
        logUrl(httpurlconnection.getURL().toString());
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod[];

            static 
            {
                $SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod = new int[WebRequest.HttpMethod.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod[WebRequest.HttpMethod.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod[WebRequest.HttpMethod.POST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.device.ads.WebRequest.HttpMethod[getHttpMethod().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            httpurlconnection.setDoOutput(false);
            return;

        case 2: // '\002'
            httpurlconnection.setDoOutput(true);
            break;
        }
        writePostBody(httpurlconnection);
    }

}
