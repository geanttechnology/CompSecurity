// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.DateUtil;
import com.amazon.insights.core.util.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.amazon.insights.core.http:
//            HttpClient, HttpUtil

public class DefaultHttpClient
    implements com.amazon.insights.core.http.HttpClient
{
    public static class DefaultRequest
        implements HttpClient.Request
    {

        protected Map headers;
        protected HttpClient.HttpMethod method;
        protected Map params;
        protected byte postBody[];
        protected String url;

        public HttpClient.Request addHeader(String s, String s1)
        {
            headers.put(s, s1);
            return this;
        }

        public Map getHeaders()
        {
            return headers;
        }

        public HttpClient.HttpMethod getMethod()
        {
            return method;
        }

        public Map getParams()
        {
            return params;
        }

        public String getPostBody()
        {
label0:
            {
                String s;
                try
                {
                    if (postBody == null)
                    {
                        break label0;
                    }
                    s = new String(postBody, "UTF-8");
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    return null;
                }
                return s;
            }
            return null;
        }

        public byte[] getPostBodyBytes()
        {
            if (postBody != null)
            {
                return (byte[])postBody.clone();
            } else
            {
                return null;
            }
        }

        public String getUrl()
        {
            return url;
        }

        public HttpClient.Request setMethod(HttpClient.HttpMethod httpmethod)
        {
            method = httpmethod;
            return this;
        }

        public HttpClient.Request setPostBody(String s)
        {
            try
            {
                postBody = s.getBytes("UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                postBody = null;
                return this;
            }
            return this;
        }

        public HttpClient.Request setPostBody(byte abyte0[])
        {
            if (abyte0 != null)
            {
                postBody = (byte[])abyte0.clone();
                return this;
            } else
            {
                postBody = null;
                return this;
            }
        }

        public HttpClient.Request setUrl(String s)
        {
            url = s;
            return this;
        }

        public String toString()
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append((new StringBuilder()).append("{\n\t\"method\" : \"").append(method).append("\",\n").toString());
            stringbuffer.append((new StringBuilder()).append("\t\"url\" : \"").append(url).append("\",\n").toString());
            stringbuffer.append((new StringBuilder()).append("\t\"postBody\" : \"").append(getPostBody()).append("\",\n").toString());
            stringbuffer.append("\t\"params\" : {\n");
            java.util.Map.Entry entry;
            for (Iterator iterator = params.entrySet().iterator(); iterator.hasNext(); stringbuffer.append((new StringBuilder()).append("\t\t\"").append((String)entry.getKey()).append("\" : \"").append((String)entry.getValue()).append("\",\n").toString()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            stringbuffer.append("\t},\n\t\"headers\" : {\n");
            java.util.Map.Entry entry1;
            for (Iterator iterator1 = headers.entrySet().iterator(); iterator1.hasNext(); stringbuffer.append((new StringBuilder()).append("\t\t\"").append((String)entry1.getKey()).append("\" : \"").append((String)entry1.getValue()).append("\",\n").toString()))
            {
                entry1 = (java.util.Map.Entry)iterator1.next();
            }

            stringbuffer.append("\t}\n}\n");
            return stringbuffer.toString();
        }

        public DefaultRequest()
        {
            params = new HashMap();
            headers = new HashMap();
            method = HttpClient.HttpMethod.GET;
        }
    }

    public static class DefaultResponse
        implements HttpClient.Response
    {

        protected int code;
        protected Map headersMap;
        protected String message;
        protected HttpClient.Request originatingRequest;
        protected long requestSize;
        protected String response;
        protected long responseSize;

        static HttpClient.Response createResponse()
        {
            return new DefaultResponse();
        }

        public HttpClient.Response addHeader(String s, String s1)
        {
            headersMap.put(s, s1);
            return this;
        }

        public int getCode()
        {
            return code;
        }

        public String getHeader(String s)
        {
            Object obj;
label0:
            {
                Object obj1 = null;
                obj = obj1;
                if (StringUtil.isNullOrEmpty(s))
                {
                    break label0;
                }
                Iterator iterator = headersMap.entrySet().iterator();
                do
                {
                    obj = obj1;
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    obj = (java.util.Map.Entry)iterator.next();
                } while (!((String)((java.util.Map.Entry) (obj)).getKey()).equalsIgnoreCase(s));
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
            }
            return ((String) (obj));
        }

        public String getMessage()
        {
            return message;
        }

        public HttpClient.Request getOriginatingRequest()
        {
            return originatingRequest;
        }

        public long getRequestSize()
        {
            return requestSize;
        }

        public String getResponse()
        {
            return response;
        }

        public long getResponseSize()
        {
            return responseSize;
        }

        public HttpClient.Response setCode(int i)
        {
            code = i;
            return this;
        }

        public HttpClient.Response setMessage(String s)
        {
            message = s;
            return this;
        }

        public HttpClient.Response setOriginatingRequest(HttpClient.Request request)
        {
            originatingRequest = request;
            return this;
        }

        public HttpClient.Response setRequestSize(long l)
        {
            requestSize = l;
            return this;
        }

        public HttpClient.Response setResponse(String s)
        {
            response = s;
            return this;
        }

        public HttpClient.Response setResponseSize(long l)
        {
            responseSize = l;
            return this;
        }

        public String toString()
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append((new StringBuilder()).append("{\n\t\"code\" : \"").append(code).append("\",\n").append("\t\"message\" : \"").append(message).append("\",\n").append("\t\"response\" : \"").append(response).append("\",\n").append("\t\"headers\" : {\n").toString());
            java.util.Map.Entry entry;
            for (Iterator iterator = headersMap.entrySet().iterator(); iterator.hasNext(); stringbuffer.append((new StringBuilder()).append("\t\t\"").append((String)entry.getKey()).append("\" : \"").append((String)entry.getValue()).append("\",\n").toString()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            stringbuffer.append("\t}\n}\n");
            return stringbuffer.toString();
        }

        public DefaultResponse()
        {
            requestSize = 0L;
            responseSize = 0L;
            headersMap = new HashMap();
        }
    }


    private static final Logger logger = Logger.getLogger(com/amazon/insights/core/http/HttpClient);
    private DateFormat df;
    private List interceptors;

    public DefaultHttpClient()
    {
        interceptors = new LinkedList();
        df = DateUtil.createLocaleIndependentDateFormatter("yyyy-MM-dd'T'HH:mm:ssZ");
    }

    private HttpClient.Response executeHttpRequest(HttpUriRequest httpurirequest, int i)
    {
        Object obj;
        Object obj2;
        Object obj3;
        String s;
        GZIPInputStream gzipinputstream;
        GZIPInputStream gzipinputstream1;
        Object obj4;
        String s1;
        Object obj5;
        Object obj6;
        Object obj7;
        HttpClient.Response response;
        HttpEntity httpentity;
        int j;
        response = DefaultResponse.createResponse();
        obj2 = HttpUtil.getHttpClient();
        obj = null;
        long l = System.currentTimeMillis();
        Header header;
        if (i >= 0)
        {
            i++;
        } else
        {
            i = 1;
        }
        j = 1;
_L8:
        obj4 = obj;
        if (j > i)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj4 = ((HttpClient) (obj2)).execute(httpurirequest);
_L7:
        response.addHeader("x-amzn-RequestTime", Long.toString(System.currentTimeMillis() - l));
        response.addHeader("x-amzn-RequestAttempts", Integer.toString(j));
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_766;
        }
        response.setCode(((HttpResponse) (obj4)).getStatusLine().getStatusCode()).setMessage(((HttpResponse) (obj4)).getStatusLine().getReasonPhrase()).setRequestSize(calculateRequestSize(httpurirequest));
        httpentity = ((HttpResponse) (obj4)).getEntity();
        s1 = null;
        obj2 = null;
        if (httpentity == null) goto _L2; else goto _L1
_L1:
        obj5 = null;
        obj6 = null;
        obj7 = null;
        obj = null;
        obj3 = obj;
        s = s1;
        gzipinputstream1 = obj5;
        gzipinputstream = obj6;
        obj2 = obj7;
        header = ((HttpResponse) (obj4)).getFirstHeader("Content-Encoding");
        if (header == null) goto _L4; else goto _L3
_L3:
        obj3 = obj;
        s = s1;
        gzipinputstream1 = obj5;
        gzipinputstream = obj6;
        obj2 = obj7;
        if (!header.getValue().equalsIgnoreCase("gzip")) goto _L4; else goto _L5
_L5:
        obj3 = obj;
        s = s1;
        gzipinputstream1 = obj5;
        gzipinputstream = obj6;
        obj2 = obj7;
        obj = new GZIPInputStream(httpentity.getContent());
_L9:
        obj3 = obj;
        s = s1;
        gzipinputstream1 = ((GZIPInputStream) (obj));
        gzipinputstream = ((GZIPInputStream) (obj));
        obj2 = obj;
        s1 = StringUtil.convertStreamToUTF8String(((InputStream) (obj)));
        obj3 = obj;
        s = s1;
        gzipinputstream1 = ((GZIPInputStream) (obj));
        gzipinputstream = ((GZIPInputStream) (obj));
        obj2 = obj;
        response.setResponseSize(calculateResponseSize(((HttpResponse) (obj4))) + (long)s1.length());
        obj2 = s1;
        if (obj == null) goto _L2; else goto _L6
_L6:
        ((InputStream) (obj)).close();
        obj2 = s1;
_L2:
        if (obj2 != null)
        {
            response.setResponse(((String) (obj2)));
            httpurirequest = ((HttpResponse) (obj4)).getAllHeaders();
            if (httpurirequest != null && httpurirequest.length > 0)
            {
                for (i = 0; i < httpurirequest.length; i++)
                {
                    response.addHeader(httpurirequest[i].getName(), httpurirequest[i].getValue());
                }

            }
        }
        break MISSING_BLOCK_LABEL_766;
        obj2;
        response.setCode(400).setMessage(String.format("Issue making request to service, %s", new Object[] {
            ((ClientProtocolException) (obj2)).toString()
        }));
        obj4 = obj;
          goto _L7
        obj3;
        j++;
        response.setCode(-1000).setMessage(String.format("Unable to communicate with service, %s", new Object[] {
            ((IOException) (obj3)).toString()
        }));
          goto _L8
_L4:
        obj3 = obj;
        s = s1;
        gzipinputstream1 = obj5;
        gzipinputstream = obj6;
        obj2 = obj7;
        obj = httpentity.getContent();
          goto _L9
        Object obj1;
        obj1;
        httpurirequest = null;
        obj2 = obj3;
        response.setCode(500).setMessage(String.format("Issue recieving response from service, %s", new Object[] {
            ((IllegalStateException) (obj1)).toString()
        }));
        obj2 = httpurirequest;
        if (obj3 == null) goto _L2; else goto _L10
_L10:
        ((InputStream) (obj3)).close();
        obj2 = httpurirequest;
          goto _L2
        obj1;
        obj2 = httpurirequest;
          goto _L2
        httpurirequest;
        obj2 = gzipinputstream1;
        response.setCode(500).setMessage(String.format("Issue with response from service, %s", new Object[] {
            httpurirequest.toString()
        }));
        obj2 = s;
        if (gzipinputstream1 == null) goto _L2; else goto _L11
_L11:
        gzipinputstream1.close();
        obj2 = s;
          goto _L2
        httpurirequest;
        obj2 = s;
          goto _L2
        Exception exception;
        exception;
        obj1 = null;
        obj2 = gzipinputstream;
        httpurirequest.abort();
        obj2 = gzipinputstream;
        response.setCode(500).setMessage(String.format("Issue with response from service, %s", new Object[] {
            exception.toString()
        }));
        obj2 = obj1;
        if (gzipinputstream == null) goto _L2; else goto _L12
_L12:
        gzipinputstream.close();
        obj2 = obj1;
          goto _L2
        httpurirequest;
        obj2 = obj1;
          goto _L2
        httpurirequest;
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
            }
            catch (IOException ioexception) { }
        }
        throw httpurirequest;
        httpurirequest;
        obj2 = s1;
          goto _L2
        return response;
          goto _L7
    }

    private String getCurrentDateTime()
    {
        return df.format(new Date());
    }

    public void addInterceptor(HttpClient.Interceptor interceptor)
    {
        if (interceptor != null)
        {
            interceptors.add(interceptor);
        }
    }

    HttpUriRequest buildHttpRequest(HttpClient.Request request)
    {
        Object obj = null;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod[];

            static 
            {
                $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod = new int[HttpClient.HttpMethod.values().length];
                try
                {
                    $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod[HttpClient.HttpMethod.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod[HttpClient.HttpMethod.POST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.insights.core.http.HttpClient.HttpMethod[request.getMethod().ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 103
    //                   2 290;
           goto _L1 _L2 _L3
_L1:
        if (obj != null)
        {
            java.util.Map.Entry entry;
            for (request = request.getHeaders().entrySet().iterator(); request.hasNext(); ((HttpUriRequest) (obj)).addHeader((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)request.next();
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        obj = new StringBuffer();
        if (!request.getParams().isEmpty())
        {
            ((StringBuffer) (obj)).append("?");
            for (Iterator iterator = request.getParams().entrySet().iterator(); iterator.hasNext();)
            {
                Object obj1 = (java.util.Map.Entry)iterator.next();
                obj1 = (new StringBuilder()).append((String)((java.util.Map.Entry) (obj1)).getKey()).append("=").append(URLEncoder.encode((String)((java.util.Map.Entry) (obj1)).getValue())).toString();
                if (((StringBuffer) (obj)).length() > 1)
                {
                    ((StringBuffer) (obj)).append("&");
                    ((StringBuffer) (obj)).append(((String) (obj1)));
                } else
                {
                    ((StringBuffer) (obj)).append(((String) (obj1)));
                }
            }

        }
        obj = new HttpGet((new StringBuilder()).append(request.getUrl()).append(((StringBuffer) (obj)).toString()).toString());
        continue; /* Loop/switch isn't completed */
_L3:
        HttpPost httppost = new HttpPost(request.getUrl());
        obj = httppost;
        if (request.getPostBodyBytes() != null)
        {
            obj = httppost;
            if (request.getPostBodyBytes().length > 0)
            {
                obj = new ByteArrayEntity(request.getPostBodyBytes());
                ((HttpPost)httppost).setEntity(((HttpEntity) (obj)));
                obj = httppost;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        return ((HttpUriRequest) (obj));
    }

    long calculateRequestSize(HttpUriRequest httpurirequest)
    {
        long l1 = 0L;
        if (httpurirequest == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        Header aheader[];
        Header header;
        int i;
        int j;
        long l;
        try
        {
            l = 0L + (long)httpurirequest.getRequestLine().toString().length();
            aheader = httpurirequest.getAllHeaders();
            j = aheader.length;
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            return 0L;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        header = aheader[i];
        l = l + (long)header.getName().length() + (long)header.getValue().length() + 2L;
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_38;
_L1:
        l1 = l;
        if (!httpurirequest.getMethod().equalsIgnoreCase("post"))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        l1 = ((HttpPost)httpurirequest).getEntity().getContentLength();
        l1 = l + l1;
        return l1;
    }

    long calculateResponseSize(HttpResponse httpresponse)
    {
        long l1 = 0L;
        if (httpresponse == null) goto _L2; else goto _L1
_L1:
        int j;
        long l;
        l = 0L + (long)httpresponse.getStatusLine().toString().length();
        httpresponse = httpresponse.getAllHeaders();
        j = httpresponse.length;
        int i = 0;
_L3:
        Header header;
        l1 = l;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        header = httpresponse[i];
        int k;
        l1 = header.getName().length();
        k = header.getValue().length();
        l = l + l1 + (long)k + 2L;
        i++;
        if (true) goto _L3; else goto _L2
        httpresponse;
        l1 = 0L;
_L2:
        return l1;
    }

    public HttpClient.Response execute(HttpClient.Request request, Integer integer)
    {
        Integer integer1 = integer;
        if (integer == null)
        {
            integer1 = Integer.valueOf(1);
        }
        request.addHeader("Date", getCurrentDateTime());
        for (integer = interceptors.iterator(); integer.hasNext(); ((HttpClient.Interceptor)integer.next()).before(request)) { }
        integer = executeHttpRequest(buildHttpRequest(request), integer1.intValue());
        if (integer != null)
        {
            integer.setOriginatingRequest(request);
        }
        for (request = interceptors.iterator(); request.hasNext(); ((HttpClient.Interceptor)request.next()).after(integer)) { }
        return integer;
    }

    public HttpClient.Request newRequest()
    {
        return new DefaultRequest();
    }

}
