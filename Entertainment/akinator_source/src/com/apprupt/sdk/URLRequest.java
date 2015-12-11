// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.os.Handler;
import android.os.Looper;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvAppInfo

public class URLRequest
{
    public class URLResponse
    {

        public final int code;
        public final String data;
        public final Exception error;
        public final boolean isError;
        public final String message;
        final URLRequest this$0;

        private URLResponse(int i, String s)
        {
            this(i, s, ((Exception) (null)));
        }

        URLResponse(int i, String s, _cls1 _pcls1)
        {
            this(i, s);
        }

        private URLResponse(int i, String s, Exception exception)
        {
            this$0 = URLRequest.this;
            super();
            boolean flag = false;
            urlrequest = null;
            int j = i;
            Object obj;
            if (exception != null)
            {
                if (exception instanceof SocketTimeoutException)
                {
                    j = -1001;
                    urlrequest = "Socket timeout";
                } else
                if (exception instanceof ConnectException)
                {
                    j = -1002;
                    urlrequest = "Connect error";
                } else
                if (exception instanceof NoRouteToHostException)
                {
                    j = -1003;
                    urlrequest = "No route to host";
                } else
                {
                    urlrequest = (new StringBuilder()).append("Error while trying to connect (").append(exception.getClass().getName()).append("): ").append(exception.getMessage()).toString();
                    j = i;
                }
            }
            obj = URLRequest.this;
            if (j != 200)
            {
                boolean flag1 = true;
                flag = flag1;
                obj = URLRequest.this;
                if (URLRequest.this == null)
                {
                    obj = (new StringBuilder()).append("Server respond with code ").append(j).toString();
                    flag = flag1;
                }
            }
            data = s;
            code = j;
            message = ((String) (obj));
            isError = flag;
            error = exception;
            URLRequest.log.e(new Object[] {
                "URLResponse", Boolean.valueOf(flag), Integer.valueOf(j), obj, exception
            });
        }

        private URLResponse(Exception exception)
        {
            this(-1100, null, exception);
        }

        URLResponse(Exception exception, _cls1 _pcls1)
        {
            this(exception);
        }
    }


    public static final int CONNECT_CODE = -1002;
    public static final int NOROUTE_CODE = -1003;
    public static final int TIMEOUT_CODE = -1001;
    public static final int UNKNOWN_CODE = -1100;
    private static final Logger.log log = Logger.get("URL_REQUEST");
    private static final Logger.log qlog = Logger.get("Q");
    private boolean canceled;
    Handler handler;
    private HashMap headers;
    private String host;
    private Listener listener;
    private List params;
    private StringBuilder path;
    private StringBuilder query;
    private Type type;
    private boolean useSSL;

    private URLRequest(Type type1, String s, Object aobj[])
    {
        handler = new Handler(Looper.getMainLooper());
        path = new StringBuilder();
        query = null;
        params = null;
        listener = null;
        canceled = false;
        useSSL = false;
        headers = new HashMap();
        setHost(s);
        if (aobj != null && aobj.length > 0)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                addPathComponent(aobj[i]);
            }

        }
        type = type1;
    }

    private URI _getURI()
    {
        Object obj = new StringBuilder();
        ((StringBuilder) (obj)).append("http");
        if (useSSL)
        {
            ((StringBuilder) (obj)).append("s");
        }
        ((StringBuilder) (obj)).append("://");
        ((StringBuilder) (obj)).append(getHost());
        ((StringBuilder) (obj)).append(path);
        if (query != null)
        {
            ((StringBuilder) (obj)).append("?");
            ((StringBuilder) (obj)).append(query);
        }
        log.e(new Object[] {
            ((StringBuilder) (obj)).toString()
        });
        try
        {
            obj = new URI(((StringBuilder) (obj)).toString());
        }
        catch (URISyntaxException urisyntaxexception)
        {
            InternalError internalerror = new InternalError(urisyntaxexception.toString());
            internalerror.setStackTrace(urisyntaxexception.getStackTrace());
            throw internalerror;
        }
        return ((URI) (obj));
    }

    private void _postResponse(URLResponse urlresponse)
    {
        log.e(new Object[] {
            "Posting URLResponse", Boolean.valueOf(urlresponse.isError), Integer.valueOf(urlresponse.code), urlresponse.message
        });
    /* block-local class not found */
    class Listener {}

        if (listener != null && !canceled)
        {
            listener.response(urlresponse);
        }
    }

    private URLRequest _send(HttpEntity httpentity, String s)
    {
    /* block-local class not found */
    class Type {}

        if (type != Type.GET) goto _L2; else goto _L1
_L1:
        Object obj = new HttpGet(_getURI());
_L4:
    /* block-local class not found */
    class ResponseDispatcher {}

        ((HttpRequestBase) (obj)).setHeader("user-agent", CvAppInfo.getInstance().getUserAgent());
        for (httpentity = headers.keySet().iterator(); httpentity.hasNext();)
        {
            s = (String)httpentity.next();
            Iterator iterator = ((ArrayList)headers.get(s)).iterator();
            while (iterator.hasNext()) 
            {
                ((HttpRequestBase) (obj)).setHeader(s, (String)iterator.next());
            }
        }

        break MISSING_BLOCK_LABEL_190;
_L2:
        HttpPost httppost;
        try
        {
            httppost = new HttpPost(_getURI());
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            handler.post(new ResponseDispatcher(new URLResponse(httpentity, null)));
            return this;
        }
        obj = httppost;
        if (httpentity == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((HttpPost)httppost).setEntity(httpentity);
        obj = httppost;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        httppost.setHeader("content-type", s);
        obj = httppost;
        if (true) goto _L4; else goto _L3
_L3:
    /* block-local class not found */
    class RequestSender {}

        (new Thread(new RequestSender(((HttpRequestBase) (obj)), null))).start();
        return this;
    }

    public static URLRequest get(String s)
    {
        return new URLRequest(Type.GET, s, null);
    }

    public static transient URLRequest get(String s, Object aobj[])
    {
        return new URLRequest(Type.GET, s, aobj);
    }

    private ArrayList headerArray(String s)
    {
        s = s.toLowerCase();
        if (!headers.containsKey(s))
        {
            return new ArrayList();
        } else
        {
            return (ArrayList)headers.get(s);
        }
    }

    public static URLRequest post(String s)
    {
        return new URLRequest(Type.POST, s, null);
    }

    public static transient URLRequest post(String s, Object aobj[])
    {
        return new URLRequest(Type.POST, s, aobj);
    }

    private URLRequest setHeader(String s, ArrayList arraylist)
    {
        headers.put(s.toLowerCase(), arraylist);
        return this;
    }

    public URLRequest addHeader(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = headerArray(s);
        arraylist.add(s1);
        s = setHeader(s, arraylist);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public URLRequest addPathComponent(Object obj)
    {
        return addPathComponent(obj, true);
    }

    public URLRequest addPathComponent(Object obj, boolean flag)
    {
        path.append("/");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        String s = URLEncoder.encode(obj.toString(), "UTF-8");
_L1:
        path.append(s);
        return this;
        s = obj.toString();
          goto _L1
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        log.e(unsupportedencodingexception, new Object[] {
            (new StringBuilder()).append("Cannot add path component: ").append(obj).toString()
        });
        return this;
    }

    public URLRequest addPostParam(String s, Object obj)
    {
        if (type == Type.GET)
        {
            throw new InvalidParameterException("Cannot add param to post request");
        }
        if (params == null)
        {
            params = new ArrayList();
        }
        List list = params;
        if (obj == null)
        {
            obj = "";
        } else
        {
            obj = obj.toString();
        }
        list.add(new BasicNameValuePair(s, ((String) (obj))));
        return this;
    }

    public URLRequest addQueryParam(String s, Object obj)
    {
        if (query == null)
        {
            query = new StringBuilder();
        } else
        {
            query.append("&");
        }
        try
        {
            query.append(URLEncoder.encode(s, "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.e(s, new Object[] {
                "Cannot encode query param."
            });
            return this;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        query.append("=");
        query.append(URLEncoder.encode(obj.toString(), "UTF-8"));
        return this;
    }

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
        canceled = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Q.Task defer()
    {
        return defer(null, null);
    }

    public Q.Task defer(String s)
    {
        return defer(s, "text/plain");
    }

    public Q.Task defer(String s, String s1)
    {
        return new _cls1(s, s1);
    }

    public Q.Task defer(JSONArray jsonarray)
    {
        return defer(jsonarray.toString(), "application/json");
    }

    public Q.Task defer(JSONObject jsonobject)
    {
        return defer(jsonobject.toString(), "application/json");
    }

    public String getHost()
    {
        return host;
    }

    public boolean getUseSSL()
    {
        return useSSL;
    }

    public URLRequest send()
    {
        if (params != null)
        {
            URLRequest urlrequest;
            try
            {
                urlrequest = _send(new UrlEncodedFormEntity(params, "UTF-8"), null);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                InternalError internalerror = new InternalError(unsupportedencodingexception.toString());
                internalerror.setStackTrace(unsupportedencodingexception.getStackTrace());
                throw internalerror;
            }
            return urlrequest;
        } else
        {
            return _send(null, null);
        }
    }

    public URLRequest send(String s)
    {
        return send(s, "text/plain");
    }

    public URLRequest send(String s, String s1)
    {
        try
        {
            s = new StringEntity(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s1 = new InternalError(s.toString());
            s1.setStackTrace(s.getStackTrace());
            throw s1;
        }
        s.setContentType(new BasicHeader("content-type", s1));
        return _send(s, s1);
    }

    public URLRequest send(JSONArray jsonarray)
    {
        return send(jsonarray.toString(), "application/json");
    }

    public URLRequest send(JSONObject jsonobject)
    {
        return send(jsonobject.toString(), "application/json");
    }

    public URLRequest setHeader(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = headerArray(s);
        arraylist.clear();
        arraylist.add(s1);
        s = setHeader(s, arraylist);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void setHost(String s)
    {
        if (s == null)
        {
            throw new InvalidParameterException("Host cannot be null");
        }
        if (!s.startsWith("https://")) goto _L2; else goto _L1
_L1:
        setUseSSL(true);
_L4:
        host = s.replaceAll("^https?://", "").replaceAll("[/]+$", "");
        return;
_L2:
        if (s.startsWith("http://"))
        {
            setUseSSL(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public URLRequest setListener(Listener listener1)
    {
        listener = listener1;
        return this;
    }

    public void setUseSSL(boolean flag)
    {
        useSSL = flag;
    }







/*
    static Listener access$702(URLRequest urlrequest, Listener listener1)
    {
        urlrequest.listener = listener1;
        return listener1;
    }

*/

    // Unreferenced inner class com/apprupt/sdk/URLRequest$CancelRequest
    /* block-local class not found */
    class CancelRequest {}


    /* member class not found */
    class _cls1 {}

}
