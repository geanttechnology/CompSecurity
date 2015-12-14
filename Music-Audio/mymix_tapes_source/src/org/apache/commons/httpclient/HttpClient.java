// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.security.Provider;
import java.security.Security;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpState, HostConfiguration, HttpConnectionManager, SimpleHttpConnectionManager, 
//            HttpException, HttpMethod, URI, HttpMethodDirector

public class HttpClient
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$HttpClient;
    private HostConfiguration hostConfiguration;
    private HttpConnectionManager httpConnectionManager;
    private HttpClientParams params;
    private HttpState state;

    public HttpClient()
    {
        this(new HttpClientParams());
    }

    public HttpClient(HttpConnectionManager httpconnectionmanager)
    {
        this(new HttpClientParams(), httpconnectionmanager);
    }

    public HttpClient(HttpClientParams httpclientparams)
    {
        state = new HttpState();
        params = null;
        hostConfiguration = new HostConfiguration();
        if (httpclientparams == null)
        {
            throw new IllegalArgumentException("Params may not be null");
        }
        params = httpclientparams;
        httpConnectionManager = null;
        httpclientparams = httpclientparams.getConnectionManagerClass();
        if (httpclientparams != null)
        {
            try
            {
                httpConnectionManager = (HttpConnectionManager)httpclientparams.newInstance();
            }
            // Misplaced declaration of an exception variable
            catch (HttpClientParams httpclientparams)
            {
                LOG.warn("Error instantiating connection manager class, defaulting to SimpleHttpConnectionManager", httpclientparams);
            }
        }
        if (httpConnectionManager == null)
        {
            httpConnectionManager = new SimpleHttpConnectionManager();
        }
        if (httpConnectionManager != null)
        {
            httpConnectionManager.getParams().setDefaults(params);
        }
    }

    public HttpClient(HttpClientParams httpclientparams, HttpConnectionManager httpconnectionmanager)
    {
        state = new HttpState();
        params = null;
        hostConfiguration = new HostConfiguration();
        if (httpconnectionmanager == null)
        {
            throw new IllegalArgumentException("httpConnectionManager cannot be null");
        }
        if (httpclientparams == null)
        {
            throw new IllegalArgumentException("Params may not be null");
        } else
        {
            params = httpclientparams;
            httpConnectionManager = httpconnectionmanager;
            httpConnectionManager.getParams().setDefaults(params);
            return;
        }
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

    public int executeMethod(HostConfiguration hostconfiguration, HttpMethod httpmethod)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpClient.executeMethod(HostConfiguration,HttpMethod)");
        return executeMethod(hostconfiguration, httpmethod, null);
    }

    public int executeMethod(HostConfiguration hostconfiguration, HttpMethod httpmethod, HttpState httpstate)
        throws IOException, HttpException
    {
label0:
        {
            LOG.trace("enter HttpClient.executeMethod(HostConfiguration,HttpMethod,HttpState)");
            if (httpmethod == null)
            {
                throw new IllegalArgumentException("HttpMethod parameter may not be null");
            }
            HostConfiguration hostconfiguration2 = getHostConfiguration();
            HostConfiguration hostconfiguration1 = hostconfiguration;
            if (hostconfiguration == null)
            {
                hostconfiguration1 = hostconfiguration2;
            }
            URI uri = httpmethod.getURI();
            if (hostconfiguration1 != hostconfiguration2)
            {
                hostconfiguration = hostconfiguration1;
                if (!uri.isAbsoluteURI())
                {
                    break label0;
                }
            }
            hostconfiguration1 = (HostConfiguration)hostconfiguration1.clone();
            hostconfiguration = hostconfiguration1;
            if (uri.isAbsoluteURI())
            {
                hostconfiguration1.setHost(uri);
                hostconfiguration = hostconfiguration1;
            }
        }
        HttpConnectionManager httpconnectionmanager = getHttpConnectionManager();
        HttpClientParams httpclientparams = params;
        HttpState httpstate1 = httpstate;
        if (httpstate == null)
        {
            httpstate1 = getState();
        }
        (new HttpMethodDirector(httpconnectionmanager, hostconfiguration, httpclientparams, httpstate1)).executeMethod(httpmethod);
        return httpmethod.getStatusCode();
    }

    public int executeMethod(HttpMethod httpmethod)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpClient.executeMethod(HttpMethod)");
        return executeMethod(null, httpmethod, null);
    }

    public String getHost()
    {
        return hostConfiguration.getHost();
    }

    public HostConfiguration getHostConfiguration()
    {
        this;
        JVM INSTR monitorenter ;
        HostConfiguration hostconfiguration = hostConfiguration;
        this;
        JVM INSTR monitorexit ;
        return hostconfiguration;
        Exception exception;
        exception;
        throw exception;
    }

    public HttpConnectionManager getHttpConnectionManager()
    {
        this;
        JVM INSTR monitorenter ;
        HttpConnectionManager httpconnectionmanager = httpConnectionManager;
        this;
        JVM INSTR monitorexit ;
        return httpconnectionmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public HttpClientParams getParams()
    {
        return params;
    }

    public int getPort()
    {
        return hostConfiguration.getPort();
    }

    public HttpState getState()
    {
        this;
        JVM INSTR monitorenter ;
        HttpState httpstate = state;
        this;
        JVM INSTR monitorexit ;
        return httpstate;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isStrictMode()
    {
        this;
        JVM INSTR monitorenter ;
        return false;
    }

    public void setConnectionTimeout(int i)
    {
        this;
        JVM INSTR monitorenter ;
        httpConnectionManager.getParams().setConnectionTimeout(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setHostConfiguration(HostConfiguration hostconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        hostConfiguration = hostconfiguration;
        this;
        JVM INSTR monitorexit ;
        return;
        hostconfiguration;
        throw hostconfiguration;
    }

    public void setHttpConnectionFactoryTimeout(long l)
    {
        this;
        JVM INSTR monitorenter ;
        params.setConnectionManagerTimeout(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setHttpConnectionManager(HttpConnectionManager httpconnectionmanager)
    {
        this;
        JVM INSTR monitorenter ;
        httpConnectionManager = httpconnectionmanager;
        if (httpConnectionManager != null)
        {
            httpConnectionManager.getParams().setDefaults(params);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        httpconnectionmanager;
        throw httpconnectionmanager;
    }

    public void setParams(HttpClientParams httpclientparams)
    {
        if (httpclientparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        } else
        {
            params = httpclientparams;
            return;
        }
    }

    public void setState(HttpState httpstate)
    {
        this;
        JVM INSTR monitorenter ;
        state = httpstate;
        this;
        JVM INSTR monitorexit ;
        return;
        httpstate;
        throw httpstate;
    }

    public void setStrictMode(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        params.makeStrict();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        params.makeLenient();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setTimeout(int i)
    {
        this;
        JVM INSTR monitorenter ;
        params.setSoTimeout(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        Object obj;
        Provider provider;
        int i;
        if (class$org$apache$commons$httpclient$HttpClient == null)
        {
            obj = _mthclass$("org.apache.commons.httpclient.HttpClient");
            class$org$apache$commons$httpclient$HttpClient = ((Class) (obj));
        } else
        {
            obj = class$org$apache$commons$httpclient$HttpClient;
        }
        LOG = LogFactory.getLog(((Class) (obj)));
        if (!LOG.isDebugEnabled())
        {
            break MISSING_BLOCK_LABEL_300;
        }
        LOG.debug("Java version: " + System.getProperty("java.version"));
        LOG.debug("Java vendor: " + System.getProperty("java.vendor"));
        LOG.debug("Java class path: " + System.getProperty("java.class.path"));
        LOG.debug("Operating system name: " + System.getProperty("os.name"));
        LOG.debug("Operating system architecture: " + System.getProperty("os.arch"));
        LOG.debug("Operating system version: " + System.getProperty("os.version"));
        obj = Security.getProviders();
        i = 0;
_L1:
        if (i >= obj.length)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        provider = obj[i];
        LOG.debug(provider.getName() + " " + provider.getVersion() + ": " + provider.getInfo());
        i++;
          goto _L1
        SecurityException securityexception;
        securityexception;
    }
}
