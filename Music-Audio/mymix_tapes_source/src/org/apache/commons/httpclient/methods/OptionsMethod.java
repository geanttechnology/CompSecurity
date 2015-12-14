// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OptionsMethod extends HttpMethodBase
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$OptionsMethod;
    private Vector methodsAllowed;

    public OptionsMethod()
    {
        methodsAllowed = new Vector();
    }

    public OptionsMethod(String s)
    {
        super(s);
        methodsAllowed = new Vector();
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

    public Enumeration getAllowedMethods()
    {
        checkUsed();
        return methodsAllowed.elements();
    }

    public String getName()
    {
        return "OPTIONS";
    }

    public boolean isAllowed(String s)
    {
        checkUsed();
        return methodsAllowed.contains(s);
    }

    public boolean needContentLength()
    {
        return false;
    }

    protected void processResponseHeaders(HttpState httpstate, HttpConnection httpconnection)
    {
        LOG.trace("enter OptionsMethod.processResponseHeaders(HttpState, HttpConnection)");
        httpstate = getResponseHeader("allow");
        if (httpstate != null)
        {
            for (httpstate = new StringTokenizer(httpstate.getValue(), ","); httpstate.hasMoreElements(); methodsAllowed.addElement(httpconnection))
            {
                httpconnection = httpstate.nextToken().trim().toUpperCase();
            }

        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$OptionsMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.OptionsMethod");
            class$org$apache$commons$httpclient$methods$OptionsMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$OptionsMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
