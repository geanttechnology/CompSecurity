// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetMethod extends HttpMethodBase
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$GetMethod;

    public GetMethod()
    {
        setFollowRedirects(true);
    }

    public GetMethod(String s)
    {
        super(s);
        LOG.trace("enter GetMethod(String)");
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

    public String getName()
    {
        return "GET";
    }

    public void recycle()
    {
        LOG.trace("enter GetMethod.recycle()");
        super.recycle();
        setFollowRedirects(true);
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$GetMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.GetMethod");
            class$org$apache$commons$httpclient$methods$GetMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$GetMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
