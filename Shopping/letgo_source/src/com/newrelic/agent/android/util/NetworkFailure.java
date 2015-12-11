// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

public final class NetworkFailure extends Enum
{

    private static final NetworkFailure $VALUES[];
    public static final NetworkFailure BadServerResponse;
    public static final NetworkFailure BadURL;
    public static final NetworkFailure CannotConnectToHost;
    public static final NetworkFailure DNSLookupFailed;
    public static final NetworkFailure SecureConnectionFailed;
    public static final NetworkFailure TimedOut;
    public static final NetworkFailure Unknown;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private int errorCode;

    private NetworkFailure(String s, int i, int j)
    {
        super(s, i);
        errorCode = j;
    }

    public static int exceptionToErrorCode(Exception exception)
    {
        return exceptionToNetworkFailure(exception).getErrorCode();
    }

    public static NetworkFailure exceptionToNetworkFailure(Exception exception)
    {
        log.error((new StringBuilder()).append("NetworkFailure.exceptionToNetworkFailure: Attempting to convert network exception ").append(exception.getClass().getName()).append(" to error code.").toString());
        NetworkFailure networkfailure = Unknown;
        if (exception instanceof UnknownHostException)
        {
            networkfailure = DNSLookupFailed;
        } else
        {
            if ((exception instanceof SocketTimeoutException) || (exception instanceof ConnectTimeoutException))
            {
                return TimedOut;
            }
            if (exception instanceof ConnectException)
            {
                return CannotConnectToHost;
            }
            if (exception instanceof MalformedURLException)
            {
                return BadURL;
            }
            if (exception instanceof SSLException)
            {
                return SecureConnectionFailed;
            }
            if ((exception instanceof HttpResponseException) || (exception instanceof ClientProtocolException))
            {
                return BadServerResponse;
            }
        }
        return networkfailure;
    }

    public static NetworkFailure valueOf(String s)
    {
        return (NetworkFailure)Enum.valueOf(com/newrelic/agent/android/util/NetworkFailure, s);
    }

    public static NetworkFailure[] values()
    {
        return (NetworkFailure[])$VALUES.clone();
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    static 
    {
        Unknown = new NetworkFailure("Unknown", 0, -1);
        BadURL = new NetworkFailure("BadURL", 1, -1000);
        TimedOut = new NetworkFailure("TimedOut", 2, -1001);
        CannotConnectToHost = new NetworkFailure("CannotConnectToHost", 3, -1004);
        DNSLookupFailed = new NetworkFailure("DNSLookupFailed", 4, -1006);
        BadServerResponse = new NetworkFailure("BadServerResponse", 5, -1011);
        SecureConnectionFailed = new NetworkFailure("SecureConnectionFailed", 6, -1200);
        $VALUES = (new NetworkFailure[] {
            Unknown, BadURL, TimedOut, CannotConnectToHost, DNSLookupFailed, BadServerResponse, SecureConnectionFailed
        });
    }
}
