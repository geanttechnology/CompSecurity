// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.IOException;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.ProtocolException;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeadMethod extends HttpMethodBase
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$HeadMethod;

    public HeadMethod()
    {
        setFollowRedirects(true);
    }

    public HeadMethod(String s)
    {
        super(s);
        setFollowRedirects(true);
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

    public int getBodyCheckTimeout()
    {
        return getParams().getIntParameter("http.protocol.head-body-timeout", -1);
    }

    public String getName()
    {
        return "HEAD";
    }

    protected void readResponseBody(HttpState httpstate, HttpConnection httpconnection)
        throws HttpException, IOException
    {
        LOG.trace("enter HeadMethod.readResponseBody(HttpState, HttpConnection)");
        int i = getParams().getIntParameter("http.protocol.head-body-timeout", -1);
        if (i < 0)
        {
            responseBodyConsumed();
        } else
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Check for non-compliant response body. Timeout in " + i + " ms");
            }
            boolean flag;
            try
            {
                flag = httpconnection.isResponseAvailable(i);
            }
            catch (IOException ioexception)
            {
                LOG.debug("An IOException occurred while testing if a response was available, we will assume one is not.", ioexception);
                flag = false;
            }
            if (flag)
            {
                if (getParams().isParameterTrue("http.protocol.reject-head-body"))
                {
                    throw new ProtocolException("Body content may not be sent in response to HTTP HEAD request");
                } else
                {
                    LOG.warn("Body content returned in response to HTTP HEAD");
                    super.readResponseBody(httpstate, httpconnection);
                    return;
                }
            }
        }
    }

    public void recycle()
    {
        super.recycle();
        setFollowRedirects(true);
    }

    public void setBodyCheckTimeout(int i)
    {
        getParams().setIntParameter("http.protocol.head-body-timeout", i);
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$HeadMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.HeadMethod");
            class$org$apache$commons$httpclient$methods$HeadMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$HeadMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
