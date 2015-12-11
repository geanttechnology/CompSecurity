// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

public class ExceptionHelper
    implements HarvestErrorCodes
{

    private static final AgentLog log = AgentLogManager.getAgentLog();

    public ExceptionHelper()
    {
    }

    public static int exceptionToErrorCode(Exception exception)
    {
        char c1 = '\uFC17';
        log.debug((new StringBuilder()).append("ExceptionHelper: exception ").append(exception.getClass().getName()).append(" to error code.").toString());
        char c;
        if (exception instanceof ClientProtocolException)
        {
            c = '\uFC0D';
        } else
        {
            if (exception instanceof UnknownHostException)
            {
                return -1006;
            }
            c = c1;
            if (!(exception instanceof SocketTimeoutException))
            {
                c = c1;
                if (!(exception instanceof ConnectTimeoutException))
                {
                    if (exception instanceof ConnectException)
                    {
                        return -1004;
                    }
                    if (exception instanceof MalformedURLException)
                    {
                        return -1000;
                    }
                    if (exception instanceof SSLException)
                    {
                        return -1200;
                    }
                    if (exception instanceof FileNotFoundException)
                    {
                        return -1302;
                    }
                    if (exception instanceof EOFException)
                    {
                        return -1302;
                    }
                    if (exception instanceof IOException)
                    {
                        recordSupportabilityMetric(exception, "IOException");
                        return -1300;
                    }
                    if (exception instanceof RuntimeException)
                    {
                        recordSupportabilityMetric(exception, "RuntimeException");
                        return -1301;
                    } else
                    {
                        return -1;
                    }
                }
            }
        }
        return c;
    }

    public static void recordSupportabilityMetric(Exception exception, String s)
    {
        exception = new AgentHealthException(exception);
        StackTraceElement stacktraceelement = exception.getStackTrace()[0];
        log.error(String.format("ExceptionHelper: %s:%s(%s:%s) %s[%s] %s", new Object[] {
            exception.getSourceClass(), exception.getSourceMethod(), stacktraceelement.getFileName(), Integer.valueOf(stacktraceelement.getLineNumber()), s, exception.getExceptionClass(), exception.getMessage()
        }));
        AgentHealth.noticeException(exception, s);
    }

}
