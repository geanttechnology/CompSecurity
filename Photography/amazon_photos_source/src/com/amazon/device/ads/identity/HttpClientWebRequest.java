// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.amazon.device.ads.identity:
//            WebRequest, Log

class HttpClientWebRequest extends WebRequest
{

    private static final String LOG_TAG = com/amazon/device/ads/identity/HttpClientWebRequest.getSimpleName();
    private HttpClient client;

    HttpClientWebRequest()
    {
    }

    private void prepareFormRequestBody$75703322(HttpPost httppost)
        throws WebRequest.WebRequestException
    {
        ArrayList arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (Iterator iterator = postParameters.entrySet().iterator(); iterator.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        try
        {
            httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpPost httppost)
        {
            Log.e(getLogTag(), "Unsupported character encoding used while creating the request: %s", new Object[] {
                httppost.getMessage()
            });
        }
        throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request", httppost);
    }

    protected void closeConnection()
    {
        if (client != null)
        {
            client.getConnectionManager().closeIdleConnections(0L, TimeUnit.MILLISECONDS);
            client.getConnectionManager().closeExpiredConnections();
            client = null;
        }
    }

    protected HttpParams createHttpParams()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, getTimeout());
        HttpConnectionParams.setSoTimeout(basichttpparams, getTimeout());
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        return basichttpparams;
    }

    protected HttpRequestBase createHttpRequest(URL url)
        throws WebRequest.WebRequestException
    {
        URI uri;
        Iterator iterator = null;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$device$ads$identity$WebRequest$HttpMethod[];

            static 
            {
                $SwitchMap$com$amazon$device$ads$identity$WebRequest$HttpMethod = new int[WebRequest.HttpMethod.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$ads$identity$WebRequest$HttpMethod[WebRequest.HttpMethod.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$device$ads$identity$WebRequest$HttpMethod[WebRequest.HttpMethod.POST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        java.util.Map.Entry entry;
        try
        {
            uri = createURI(url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e(getLogTag(), "Problem with URI syntax: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.MALFORMED_URL, "Problem with URI syntax", url);
        }
        _cls1..SwitchMap.com.amazon.device.ads.identity.WebRequest.HttpMethod[getHttpMethod().ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 165
    //                   2 178;
           goto _L1 _L2 _L3
_L1:
        url = iterator;
_L5:
        iterator = headers.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() != null && !((String)entry.getValue()).equals(""))
            {
                url.addHeader((String)entry.getKey(), (String)entry.getValue());
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        url = new HttpGet(uri);
        continue; /* Loop/switch isn't completed */
_L3:
        HttpPost httppost = new HttpPost(uri);
        HttpPost httppost1 = (HttpPost)httppost;
        String s = charset;
        url = s;
        if (s == null)
        {
            url = "UTF-8";
        }
        String s1 = contentType;
        s = s1;
        if (s1 == null)
        {
            s = "text/plain";
        }
        if (requestBody != null)
        {
            try
            {
                url = new StringEntity(requestBody, url);
                url.setContentType(s);
                httppost1.setEntity(url);
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                Log.e(getLogTag(), "Unsupported character encoding used while creating the request. ", new Object[] {
                    url.getMessage()
                });
                throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request.", url);
            }
            url = httppost;
        } else
        {
            prepareFormRequestBody$75703322(httppost1);
            url = httppost;
        }
        if (true) goto _L5; else goto _L4
_L4:
        logUrl(uri.toString());
        if (logRequestBodyEnabled && getRequestBody() != null)
        {
            Log.d(getLogTag(), "Request Body: %s", new Object[] {
                getRequestBody()
            });
        }
        return url;
    }

    protected WebRequest.WebResponse doHttpNetworkCall(URL url)
        throws WebRequest.WebRequestException
    {
        url = createHttpRequest(url);
        HttpParams httpparams = createHttpParams();
        if (client != null)
        {
            closeConnection();
        }
        client = new DefaultHttpClient(httpparams);
        try
        {
            url = client.execute(url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e(getLogTag(), "Invalid client protocol: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e(getLogTag(), "IOException during client execution: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException during client execution", url);
        }
        return parseResponse(url);
    }

    protected String getSubLogTag()
    {
        return LOG_TAG;
    }

    protected WebRequest.WebResponse parseResponse(HttpResponse httpresponse)
        throws WebRequest.WebRequestException
    {
        WebRequest.WebResponse webresponse = new WebRequest.WebResponse(this);
        webresponse.setHttpStatusCode(httpresponse.getStatusLine().getStatusCode());
        webresponse.setHttpStatus(httpresponse.getStatusLine().getReasonPhrase());
        if (webresponse.getHttpStatusCode() == 200)
        {
            httpresponse = httpresponse.getEntity();
            if (httpresponse != null && httpresponse.getContentLength() != 0L)
            {
                try
                {
                    webresponse.setInputStream(httpresponse.getContent());
                }
                // Misplaced declaration of an exception variable
                catch (HttpResponse httpresponse)
                {
                    Log.e(getLogTag(), "IOException while reading the input stream from response: %s", new Object[] {
                        httpresponse.getMessage()
                    });
                    throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", httpresponse);
                }
            }
        }
        return webresponse;
    }

}
