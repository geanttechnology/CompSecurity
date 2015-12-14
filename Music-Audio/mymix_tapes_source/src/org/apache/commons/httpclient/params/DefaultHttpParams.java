// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.params;

import java.io.Serializable;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.params:
//            HttpParams, DefaultHttpParamsFactory, HttpParamsFactory

public class DefaultHttpParams
    implements HttpParams, Serializable, Cloneable
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$params$DefaultHttpParams;
    private static HttpParamsFactory httpParamsFactory = new DefaultHttpParamsFactory();
    private HttpParams defaults;
    private HashMap parameters;

    public DefaultHttpParams()
    {
        this(getDefaultParams());
    }

    public DefaultHttpParams(HttpParams httpparams)
    {
        defaults = null;
        parameters = null;
        defaults = httpparams;
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

    public static HttpParams getDefaultParams()
    {
        return httpParamsFactory.getDefaultParams();
    }

    public static void setHttpParamsFactory(HttpParamsFactory httpparamsfactory)
    {
        if (httpparamsfactory == null)
        {
            throw new IllegalArgumentException("httpParamsFactory may not be null");
        } else
        {
            httpParamsFactory = httpparamsfactory;
            return;
        }
    }

    public void clear()
    {
        parameters = null;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        DefaultHttpParams defaulthttpparams = (DefaultHttpParams)super.clone();
        if (parameters != null)
        {
            defaulthttpparams.parameters = (HashMap)parameters.clone();
        }
        defaulthttpparams.setDefaults(defaults);
        return defaulthttpparams;
    }

    public boolean getBooleanParameter(String s, boolean flag)
    {
        s = ((String) (getParameter(s)));
        if (s == null)
        {
            return flag;
        } else
        {
            return ((Boolean)s).booleanValue();
        }
    }

    public HttpParams getDefaults()
    {
        this;
        JVM INSTR monitorenter ;
        HttpParams httpparams = defaults;
        this;
        JVM INSTR monitorexit ;
        return httpparams;
        Exception exception;
        exception;
        throw exception;
    }

    public double getDoubleParameter(String s, double d)
    {
        s = ((String) (getParameter(s)));
        if (s == null)
        {
            return d;
        } else
        {
            return ((Double)s).doubleValue();
        }
    }

    public int getIntParameter(String s, int i)
    {
        s = ((String) (getParameter(s)));
        if (s == null)
        {
            return i;
        } else
        {
            return ((Integer)s).intValue();
        }
    }

    public long getLongParameter(String s, long l)
    {
        s = ((String) (getParameter(s)));
        if (s == null)
        {
            return l;
        } else
        {
            return ((Long)s).longValue();
        }
    }

    public Object getParameter(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        if (parameters != null)
        {
            obj = parameters.get(s);
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        if (defaults != null)
        {
            obj = defaults.getParameter(s);
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public boolean isParameterFalse(String s)
    {
        boolean flag = false;
        if (!getBooleanParameter(s, false))
        {
            flag = true;
        }
        return flag;
    }

    public boolean isParameterSet(String s)
    {
        return getParameter(s) != null;
    }

    public boolean isParameterSetLocally(String s)
    {
        return parameters != null && parameters.get(s) != null;
    }

    public boolean isParameterTrue(String s)
    {
        return getBooleanParameter(s, false);
    }

    public void setBooleanParameter(String s, boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        setParameter(s, boolean1);
    }

    public void setDefaults(HttpParams httpparams)
    {
        this;
        JVM INSTR monitorenter ;
        defaults = httpparams;
        this;
        JVM INSTR monitorexit ;
        return;
        httpparams;
        throw httpparams;
    }

    public void setDoubleParameter(String s, double d)
    {
        setParameter(s, new Double(d));
    }

    public void setIntParameter(String s, int i)
    {
        setParameter(s, new Integer(i));
    }

    public void setLongParameter(String s, long l)
    {
        setParameter(s, new Long(l));
    }

    public void setParameter(String s, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (parameters == null)
        {
            parameters = new HashMap();
        }
        parameters.put(s, obj);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Set parameter " + s + " = " + obj);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setParameters(String as[], Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        setParameter(as[i], obj);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        as;
        throw as;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$params$DefaultHttpParams == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.params.DefaultHttpParams");
            class$org$apache$commons$httpclient$params$DefaultHttpParams = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$params$DefaultHttpParams;
        }
        LOG = LogFactory.getLog(class1);
    }
}
