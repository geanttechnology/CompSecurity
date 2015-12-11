// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;

// Referenced classes of package com.apprupt.sdk:
//            URLRequest

public class <init>
{

    public final int code;
    public final String data;
    public final Exception error;
    public final boolean isError;
    public final String message;
    final URLRequest this$0;

    private (int i, String s)
    {
        this(i, s, ((Exception) (null)));
    }

    <init>(int i, String s, <init> <init>1)
    {
        this(i, s);
    }

    private <init>(int i, String s, Exception exception)
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
        URLRequest.access$000().error(new Object[] {
            "URLResponse", Boolean.valueOf(flag), Integer.valueOf(j), obj, exception
        });
    }

    private error(Exception exception)
    {
        this(-1100, null, exception);
    }

    <init>(Exception exception, <init> <init>1)
    {
        this(exception);
    }
}
