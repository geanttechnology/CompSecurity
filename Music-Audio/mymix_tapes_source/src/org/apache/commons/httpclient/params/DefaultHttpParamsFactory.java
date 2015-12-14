// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.params;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpVersion;

// Referenced classes of package org.apache.commons.httpclient.params:
//            HttpParamsFactory, HttpClientParams, HttpParams

public class DefaultHttpParamsFactory
    implements HttpParamsFactory
{

    static Class class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
    private HttpParams httpParams;

    public DefaultHttpParamsFactory()
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    protected HttpParams createParams()
    {
        Object obj;
        HttpClientParams httpclientparams;
        httpclientparams = new HttpClientParams(null);
        httpclientparams.setParameter("http.useragent", "Jakarta Commons-HttpClient/3.1");
        httpclientparams.setVersion(HttpVersion.HTTP_1_1);
        String s;
        if (class$org$apache$commons$httpclient$SimpleHttpConnectionManager == null)
        {
            obj = _mthclass$("org.apache.commons.httpclient.SimpleHttpConnectionManager");
            class$org$apache$commons$httpclient$SimpleHttpConnectionManager = ((Class) (obj));
        } else
        {
            obj = class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
        }
        httpclientparams.setConnectionManagerClass(((Class) (obj)));
        httpclientparams.setCookiePolicy("default");
        httpclientparams.setHttpElementCharset("US-ASCII");
        httpclientparams.setContentCharset("ISO-8859-1");
        httpclientparams.setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler());
        obj = new ArrayList();
        ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
            "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", 
            "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"
        }));
        httpclientparams.setParameter("http.dateparser.patterns", obj);
        obj = null;
        s = System.getProperty("httpclient.useragent");
        obj = s;
_L11:
        if (obj != null)
        {
            httpclientparams.setParameter("http.useragent", obj);
        }
        obj = null;
        s = System.getProperty("httpclient.authentication.preemptive");
        obj = s;
_L9:
        if (obj != null)
        {
            obj = ((String) (obj)).trim().toLowerCase();
            if (((String) (obj)).equals("true"))
            {
                httpclientparams.setParameter("http.authentication.preemptive", Boolean.TRUE);
            } else
            if (((String) (obj)).equals("false"))
            {
                httpclientparams.setParameter("http.authentication.preemptive", Boolean.FALSE);
            }
        }
        obj = null;
        s = System.getProperty("apache.commons.httpclient.cookiespec");
        obj = s;
_L7:
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!"COMPATIBILITY".equalsIgnoreCase(((String) (obj)))) goto _L4; else goto _L3
_L3:
        httpclientparams.setCookiePolicy("compatibility");
_L2:
        return httpclientparams;
_L4:
        if ("NETSCAPE_DRAFT".equalsIgnoreCase(((String) (obj))))
        {
            httpclientparams.setCookiePolicy("netscape");
            return httpclientparams;
        }
        if (!"RFC2109".equalsIgnoreCase(((String) (obj)))) goto _L2; else goto _L5
_L5:
        httpclientparams.setCookiePolicy("rfc2109");
        return httpclientparams;
        SecurityException securityexception;
        securityexception;
        if (true) goto _L7; else goto _L6
_L6:
        securityexception;
        if (true) goto _L9; else goto _L8
_L8:
        securityexception;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public HttpParams getDefaultParams()
    {
        this;
        JVM INSTR monitorenter ;
        HttpParams httpparams;
        if (httpParams == null)
        {
            httpParams = createParams();
        }
        httpparams = httpParams;
        this;
        JVM INSTR monitorexit ;
        return httpparams;
        Exception exception;
        exception;
        throw exception;
    }
}
