// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

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

// Referenced classes of package com.amazon.device.ads:
//            WebRequest, MobileAdsLogger

class HttpClientWebRequest extends WebRequest
{

    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final String LOGTAG = com/amazon/device/ads/HttpClientWebRequest.getSimpleName();
    private HttpClient client;

    HttpClientWebRequest()
    {
    }

    private void prepareFormRequestBody(HttpPost httppost, String s)
        throws WebRequest.WebRequestException
    {
        s = new ArrayList();
        java.util.Map.Entry entry;
        for (Iterator iterator = postParameters.entrySet().iterator(); iterator.hasNext(); s.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        try
        {
            httppost.setEntity(new UrlEncodedFormEntity(s, "UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpPost httppost)
        {
            getLogger().e("Unsupported character encoding used while creating the request: %s", new Object[] {
                httppost.getMessage()
            });
        }
        throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request", httppost);
    }

    private void prepareRequestBody(HttpPost httppost)
        throws WebRequest.WebRequestException
    {
        String s1 = charset;
        String s = s1;
        if (s1 == null)
        {
            s = "UTF-8";
        }
        String s2 = contentType;
        s1 = s2;
        if (s2 == null)
        {
            s1 = "text/plain";
        }
        if (requestBody != null)
        {
            prepareStringRequestBody(httppost, s1, s);
            return;
        } else
        {
            prepareFormRequestBody(httppost, s);
            return;
        }
    }

    private void prepareStringRequestBody(HttpPost httppost, String s, String s1)
        throws WebRequest.WebRequestException
    {
        try
        {
            s1 = new StringEntity(requestBody, s1);
            s1.setContentType(s);
            httppost.setEntity(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpPost httppost)
        {
            getLogger().e("Unsupported character encoding used while creating the request. ", new Object[] {
                httppost.getMessage()
            });
        }
        throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request.", httppost);
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

        java.util.Map.Entry entry;
        try
        {
            uri = createURI(url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            getLogger().e("Problem with URI syntax: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.MALFORMED_URL, "Problem with URI syntax", url);
        }
        _cls1..SwitchMap.com.amazon.device.ads.WebRequest.HttpMethod[getHttpMethod().ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 166
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
        url = new HttpPost(uri);
        prepareRequestBody((HttpPost)url);
        if (true) goto _L5; else goto _L4
_L4:
        logUrl(uri.toString());
        if (logRequestBodyEnabled && getRequestBody() != null)
        {
            getLogger().d("Request Body: %s", new Object[] {
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
            getLogger().e("Invalid client protocol: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            getLogger().e("IOException during client execution: %s", new Object[] {
                url.getMessage()
            });
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException during client execution", url);
        }
        return parseResponse(url);
    }

    protected String getSubLogTag()
    {
        return LOGTAG;
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
                    getLogger().e("IOException while reading the input stream from response: %s", new Object[] {
                        httpresponse.getMessage()
                    });
                    throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", httpresponse);
                }
            }
        }
        return webresponse;
    }

}
