// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.samsung.rest:
//            HTTPMethod, MultipleRequestExecutorException, Request, Response, 
//            RestUtil, OnRequestCallbackListener

public class RequestExecuter
{

    private static int $SWITCH_TABLE$com$samsung$rest$HTTPMethod[];
    private DefaultHttpClient httpclient;
    private boolean isRequestCompleted;
    private boolean isRequestStarted;

    static int[] $SWITCH_TABLE$com$samsung$rest$HTTPMethod()
    {
        int ai[] = $SWITCH_TABLE$com$samsung$rest$HTTPMethod;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[HTTPMethod.values().length];
        try
        {
            ai[HTTPMethod.DELETE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[HTTPMethod.GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[HTTPMethod.HEAD.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[HTTPMethod.OPTIONS.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[HTTPMethod.POST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[HTTPMethod.PUT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[HTTPMethod.TRACE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$samsung$rest$HTTPMethod = ai;
        return ai;
    }

    public RequestExecuter()
    {
        isRequestCompleted = false;
        isRequestStarted = false;
    }

    public void execute(Request request, int i, OnRequestCallbackListener onrequestcallbacklistener)
    {
        Object obj;
        Response response;
        Object obj1;
        Object obj2;
        HTTPMethod httpmethod;
        if (isRequestCompleted)
        {
            throw new MultipleRequestExecutorException("A _restClient object can be used only once!");
        }
        isRequestStarted = true;
        obj1 = request.getUrl();
        obj2 = ((URL) (obj1)).toString();
        Log.d("RequestExecuter", ((String) (obj2)));
        httpclient = new DefaultHttpClient();
        obj = new ProtocolVersion("HTTP", 1, 1);
        httpclient.getParams().setParameter("http.protocol.version", obj);
        obj = null;
        response = new Response();
        httpmethod = request.getMethod();
        $SWITCH_TABLE$com$samsung$rest$HTTPMethod()[httpmethod.ordinal()];
        JVM INSTR tableswitch 1 7: default 988
    //                   1 512
    //                   2 526
    //                   3 540
    //                   4 554
    //                   5 568
    //                   6 582
    //                   7 596;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        ((AbstractHttpMessage) (obj)).setParams((new BasicHttpParams()).setParameter(((String) (obj2)), obj1));
        obj1 = request.getHeaders().entrySet().iterator();
_L24:
        if (((Iterator) (obj1)).hasNext()) goto _L10; else goto _L9
_L9:
        if (!(obj instanceof HttpEntityEnclosingRequest)) goto _L12; else goto _L11
_L11:
        obj1 = (HttpEntityEnclosingRequest)obj;
        if (request.getFilePath() == null) goto _L14; else goto _L13
_L13:
        Log.d("RequestExecuter", (new StringBuilder("FilePath: ")).append(request.getFilePath()).toString());
        obj2 = new File(request.getFilePath());
        if (!((File) (obj2)).exists()) goto _L16; else goto _L15
_L15:
        MultipartEntity multipartentity = new MultipartEntity();
        multipartentity.addPart("upload", new FileBody(((File) (obj2))));
        ((HttpEntityEnclosingRequest) (obj1)).setEntity(multipartentity);
        response.setActionType(101);
        Log.d("RequestExecuter", "Create entity");
_L12:
        httpclient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
        httpclient.setRedirectHandler(new DefaultRedirectHandler() {

            final RequestExecuter this$0;

            public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
                throws ProtocolException
            {
                httpcontext = super.getLocationURI(httpresponse, httpcontext);
                Log.d("RequestExecuter", (new StringBuilder("Redirect response status: ")).append(httpresponse.getStatusLine()).toString());
                Log.d("RequestExecuter", (new StringBuilder("Redirect: ")).append(httpcontext).toString());
                return httpcontext;
            }

            
            {
                this$0 = RequestExecuter.this;
                super();
            }
        });
        if (!request.isWaitForResponse()) goto _L18; else goto _L17
_L17:
        long l = System.currentTimeMillis();
        obj1 = httpclient.execute((HttpUriRequest)obj, null);
        response.setExecutionTime(System.currentTimeMillis() - l);
        response.setStatusCode(((HttpResponse) (obj1)).getStatusLine().getStatusCode());
        response.setStatusLine(((HttpResponse) (obj1)).getStatusLine().toString());
        obj2 = ((HttpResponse) (obj1)).getAllHeaders();
        obj = null;
        int k = obj2.length;
        int j = 0;
_L27:
        if (j < k) goto _L20; else goto _L19
_L19:
        if (obj == null) goto _L22; else goto _L21
_L21:
        obj2 = RestUtil.getCharsetFromContentType(((String) (obj)));
        obj = Charset.forName(((String) (obj2)));
_L25:
        obj1 = ((HttpResponse) (obj1)).getEntity();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_501;
        }
        obj1 = ((HttpEntity) (obj1)).getContent();
        obj1 = RestUtil.inputStream2String(((java.io.InputStream) (obj1)), ((Charset) (obj)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_501;
        }
        Header header;
        try
        {
            response.setBody(((String) (obj1)));
            break MISSING_BLOCK_LABEL_501;
        }
        catch (IOException ioexception) { }
          goto _L23
_L2:
        obj = new HttpGet(((String) (obj2)));
          goto _L1
_L3:
        obj = new HttpPost(((String) (obj2)));
          goto _L1
_L4:
        obj = new HttpPut(((String) (obj2)));
          goto _L1
_L5:
        obj = new HttpDelete(((String) (obj2)));
          goto _L1
_L6:
        obj = new HttpHead(((String) (obj2)));
          goto _L1
_L7:
        obj = new HttpOptions(((String) (obj2)));
          goto _L1
_L8:
        obj = new HttpTrace(((String) (obj2)));
          goto _L1
_L10:
        obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
        ((AbstractHttpMessage) (obj)).addHeader(new BasicHeader((String)((java.util.Map.Entry) (obj2)).getKey(), (String)((java.util.Map.Entry) (obj2)).getValue()));
          goto _L24
_L26:
        try
        {
            onrequestcallbacklistener.onRequestCallback(request, response, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.d("RequestExecuter", (new StringBuilder(" ")).append(((IOException) (obj)).getMessage()).toString());
        }
        onrequestcallbacklistener.onRequestCallback(request, response, i);
        return;
_L16:
        Log.d("RequestExecuter", "File no exist!");
        return;
_L14:
        obj2 = new ByteArrayEntity(request.getBody().getBytes());
        ((AbstractHttpEntity) (obj2)).setContentType(request.getContentType());
        ((HttpEntityEnclosingRequest) (obj1)).setEntity(((HttpEntity) (obj2)));
          goto _L12
_L20:
        header = obj2[j];
        response.addHeader(header.getName(), header.getValue());
        if (header.getName().equalsIgnoreCase("content-type"))
        {
            obj = header.getValue();
        }
        break MISSING_BLOCK_LABEL_991;
        obj;
        Log.d("RequestExecuter", (new StringBuilder("Charset name is illegal: ")).append(((String) (obj2))).toString());
        obj = Charset.defaultCharset();
          goto _L25
        obj;
        Log.d("RequestExecuter", (new StringBuilder("Charset ")).append(((String) (obj2))).append(" is not supported in this JVM.").toString());
        obj = Charset.defaultCharset();
          goto _L25
        obj;
        Log.d("RequestExecuter", "Charset parameter is not available in Content-Type header!");
        obj = Charset.defaultCharset();
          goto _L25
_L22:
        obj = Charset.defaultCharset();
        Log.d("RequestExecuter", (new StringBuilder("Content-Type header not available in response. Using platform default encoding: ")).append(((Charset) (obj)).name()).toString());
          goto _L25
_L23:
        Log.d("RequestExecuter", (new StringBuilder("Response body conversion to string using ")).append(((Charset) (obj)).displayName()).append(" encoding failed. Response body not set!").toString());
          goto _L26
_L18:
        Log.d("RequestExecuter", "No Wait For Responce");
        httpclient.execute((HttpUriRequest)obj, null);
        return;
        j++;
          goto _L27
    }
}
