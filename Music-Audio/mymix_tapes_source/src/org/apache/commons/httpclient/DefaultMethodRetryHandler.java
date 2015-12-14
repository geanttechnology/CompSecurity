// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            MethodRetryHandler, HttpMethod, HttpConnection, HttpRecoverableException

public class DefaultMethodRetryHandler
    implements MethodRetryHandler
{

    private boolean requestSentRetryEnabled;
    private int retryCount;

    public DefaultMethodRetryHandler()
    {
        retryCount = 3;
        requestSentRetryEnabled = false;
    }

    public int getRetryCount()
    {
        return retryCount;
    }

    public boolean isRequestSentRetryEnabled()
    {
        return requestSentRetryEnabled;
    }

    public boolean retryMethod(HttpMethod httpmethod, HttpConnection httpconnection, HttpRecoverableException httprecoverableexception, int i, boolean flag)
    {
        return (!flag || requestSentRetryEnabled) && i <= retryCount;
    }

    public void setRequestSentRetryEnabled(boolean flag)
    {
        requestSentRetryEnabled = flag;
    }

    public void setRetryCount(int i)
    {
        retryCount = i;
    }
}
