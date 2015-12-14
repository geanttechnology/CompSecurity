// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.IOException;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ExpectContinueMethod extends HttpMethodBase
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$ExpectContinueMethod;

    public ExpectContinueMethod()
    {
    }

    public ExpectContinueMethod(String s)
    {
        super(s);
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

    protected void addRequestHeaders(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter ExpectContinueMethod.addRequestHeaders(HttpState, HttpConnection)");
        super.addRequestHeaders(httpstate, httpconnection);
        boolean flag;
        if (getRequestHeader("Expect") != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (getParams().isParameterTrue("http.protocol.expect-continue") && getEffectiveVersion().greaterEquals(HttpVersion.HTTP_1_1) && hasRequestContent())
        {
            if (!flag)
            {
                setRequestHeader("Expect", "100-continue");
            }
        } else
        if (flag)
        {
            removeRequestHeader("Expect");
            return;
        }
    }

    public boolean getUseExpectHeader()
    {
        return getParams().getBooleanParameter("http.protocol.expect-continue", false);
    }

    protected abstract boolean hasRequestContent();

    public void setUseExpectHeader(boolean flag)
    {
        getParams().setBooleanParameter("http.protocol.expect-continue", flag);
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$ExpectContinueMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.ExpectContinueMethod");
            class$org$apache$commons$httpclient$methods$ExpectContinueMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$ExpectContinueMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
