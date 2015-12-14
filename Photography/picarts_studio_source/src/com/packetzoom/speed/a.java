// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHttpResponse;

// Referenced classes of package com.packetzoom.speed:
//            PacketZoomClient, Session

public class a
    implements InvocationHandler
{

    private static final String a_java_lang_String_static_fld = com/packetzoom/speed/PacketZoomClient.getName();
    private Session a_com_packetzoom_speed_Session_fld;
    private volatile Object a_java_lang_Object_fld;

    public a()
    {
        a_java_lang_Object_fld = null;
        a_com_packetzoom_speed_Session_fld = null;
    }

    private HttpResponse a(HttpUriRequest httpurirequest)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(httpurirequest.getURI().toURL().toString())).openConnection();
        httpurirequest = httpurirequest.getAllHeaders();
        for (int i = 0; i < httpurirequest.length; i++)
        {
            httpurlconnection.addRequestProperty(httpurirequest[i].getName(), httpurirequest[i].getValue());
        }

        httpurirequest = new BasicHttpResponse(new ProtocolVersion("HTTP", 1, 1), httpurlconnection.getResponseCode(), null);
        BasicHttpEntity basichttpentity = new BasicHttpEntity();
        basichttpentity.setContent(httpurlconnection.getInputStream());
        basichttpentity.setContentLength(httpurlconnection.getContentLength());
        basichttpentity.setContentType(httpurlconnection.getContentType());
        basichttpentity.setContentEncoding(httpurlconnection.getContentEncoding());
        httpurirequest.setEntity(basichttpentity);
        return httpurirequest;
    }

    public HttpClient a(HttpClient httpclient, Session session)
    {
        a_java_lang_Object_fld = httpclient;
        a_com_packetzoom_speed_Session_fld = session;
        httpclient = httpclient.getClass().getSuperclass().getInterfaces();
        return (HttpClient)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), httpclient, this);
    }

    public Object invoke(Object obj, Method method, Object aobj[])
    {
        obj = method.getName();
        method = a_java_lang_Object_fld.getClass().getMethod(((String) (obj)), method.getParameterTypes());
        if (a_com_packetzoom_speed_Session_fld.isEnabled() && "execute".equals(obj))
        {
            HttpUriRequest httpurirequest = (HttpUriRequest)aobj[0];
            if (httpurirequest.getMethod().equalsIgnoreCase("GET"))
            {
                return a(httpurirequest);
            }
            (new StringBuilder("proxing: ")).append(((HttpUriRequest)aobj[0]).getURI().toString());
        }
        if (aobj != null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        return method.invoke(a_java_lang_Object_fld, new Object[0]);
        method = ((Method) (method.invoke(a_java_lang_Object_fld, aobj)));
        return method;
        obj;
        throw ((InvocationTargetException) (obj)).getCause();
        method;
        Log.e(a_java_lang_String_static_fld, (new StringBuilder("Undeclared exception caught in ")).append(((String) (obj))).toString(), method);
        return null;
    }

}
