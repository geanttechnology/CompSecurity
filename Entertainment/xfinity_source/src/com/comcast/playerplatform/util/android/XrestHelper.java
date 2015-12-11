// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpGet;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpHead;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpPost;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpRequestBase;
import com.comcast.cim.httpcomponentsandroid.entity.StringEntity;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.util.EntityUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.comcast.playerplatform.util.android:
//            MoneyTrace, ThreadManager, AbstractResponseEventListener

public class XrestHelper
    implements Runnable
{

    private HttpEntity currentEntity;
    private String endpoint;
    private Map headers;
    private HttpClient httpClient;
    private String httpMethod;
    private String input;
    private AbstractResponseEventListener listener;
    private MoneyTrace moneyTrace;

    public XrestHelper(String s, String s1, String s2, Map map, AbstractResponseEventListener abstractresponseeventlistener, HttpClient httpclient)
    {
        input = s;
        endpoint = s1;
        httpMethod = s2;
        headers = map;
        listener = abstractresponseeventlistener;
        httpClient = httpclient;
    }

    public XrestHelper(String s, String s1, String s2, Map map, AbstractResponseEventListener abstractresponseeventlistener, HttpClient httpclient, MoneyTrace moneytrace)
    {
        input = s;
        endpoint = s1;
        httpMethod = s2;
        headers = map;
        listener = abstractresponseeventlistener;
        httpClient = httpclient;
        moneyTrace = moneytrace;
    }

    private void getHeaders(HttpRequestBase httprequestbase)
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = headers.entrySet().iterator(); iterator.hasNext(); httprequestbase.setHeader((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    private String parseResponse(HttpResponse httpresponse)
        throws Exception
    {
        InputStream inputstream = httpresponse.getEntity().getContent();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        if (httpresponse.getStatusLine().getStatusCode() != 200)
        {
            EntityUtils.consume(httpresponse.getEntity());
            return (new StringBuilder()).append("Network Error on request to ").append(endpoint).append(" Reason: ").append(httpresponse.getStatusLine().getReasonPhrase()).toString();
        }
        httpresponse = new StringBuilder();
        do
        {
            String s = bufferedreader.readLine();
            if (s == null)
            {
                bufferedreader.close();
                inputstream.close();
                return httpresponse.toString();
            }
            httpresponse.append(s);
        } while (true);
    }

    private String sendHttpMessage()
        throws Exception
    {
        Object obj1 = null;
        if (currentEntity != null)
        {
            EntityUtils.consume(currentEntity);
            currentEntity = null;
        }
        Object obj;
        if (httpMethod.equals("POST"))
        {
            obj = new HttpPost(endpoint);
            ((HttpPost) (obj)).setEntity(new StringEntity(input));
            if (moneyTrace != null)
            {
                ((HttpPost) (obj)).setHeader(moneyTrace.getHttpHeader(), moneyTrace.generateHttpHeaderValue());
            }
            if (headers != null && !headers.isEmpty())
            {
                getHeaders(((HttpRequestBase) (obj)));
            }
            obj = parseResponse(httpClient.execute(((com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest) (obj))));
        } else
        {
            if (httpMethod.equals("GET"))
            {
                obj = new HttpGet(endpoint);
                if (moneyTrace != null)
                {
                    ((HttpGet) (obj)).setHeader(moneyTrace.getHttpHeader(), moneyTrace.generateHttpHeaderValue());
                }
                if (headers != null && !headers.isEmpty())
                {
                    getHeaders(((HttpRequestBase) (obj)));
                }
                return parseResponse(httpClient.execute(((com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest) (obj))));
            }
            obj = obj1;
            if (httpMethod.equals("HEAD"))
            {
                obj = new HttpHead(endpoint);
                if (moneyTrace != null)
                {
                    ((HttpHead) (obj)).setHeader(moneyTrace.getHttpHeader(), moneyTrace.generateHttpHeaderValue());
                }
                if (headers != null && !headers.isEmpty())
                {
                    getHeaders(((HttpRequestBase) (obj)));
                }
                ((HttpHead) (obj)).getParams().setParameter("http.protocol.handle-redirects", Boolean.valueOf(false));
                obj = httpClient.execute(((com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest) (obj)));
                currentEntity = ((HttpResponse) (obj)).getEntity();
                if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 302)
                {
                    throw new Exception(((HttpResponse) (obj)).getStatusLine().getReasonPhrase());
                }
                Header aheader[] = ((HttpResponse) (obj)).getHeaders("location");
                obj = obj1;
                if (aheader != null)
                {
                    obj = obj1;
                    if (aheader.length > 0)
                    {
                        String s = aheader[aheader.length - 1].getValue();
                        obj = s;
                        if (!s.endsWith(".m3u8"))
                        {
                            endpoint = s;
                            return sendHttpMessage();
                        }
                    }
                }
            }
        }
        return ((String) (obj));
    }

    public void run()
    {
        final String responseString;
        try
        {
            responseString = sendHttpMessage();
        }
        catch (Exception exception)
        {
            exception = (new StringBuilder()).append("Network Error on request to ").append(endpoint).toString();
        }
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final XrestHelper this$0;
            final String val$responseString;

            public void run()
            {
label0:
                {
                    if (listener != null)
                    {
                        if (!responseString.contains("Network Error on request to"))
                        {
                            break label0;
                        }
                        listener.requestFailed(responseString);
                    }
                    return;
                }
                if (httpMethod.equals("HEAD"))
                {
                    listener.redirectUrlFound(responseString);
                    return;
                } else
                {
                    listener.responseReceived(responseString);
                    return;
                }
            }

            
            {
                this$0 = XrestHelper.this;
                responseString = s;
                super();
            }
        });
    }


}
