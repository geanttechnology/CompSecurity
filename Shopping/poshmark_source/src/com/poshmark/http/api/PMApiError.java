// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMError;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.PMHttpError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.HttpHostConnectException;

public class PMApiError extends PMHttpError
{

    private static Map exceptionsToErrorType = new HashMap() {

            
            {
                put(org/apache/http/NoHttpResponseException, PMErrorType.CONNECTION_FAILURE);
                put(java/net/UnknownHostException, PMErrorType.CONNECTION_FAILURE);
                put(org/apache/http/conn/HttpHostConnectException, PMErrorType.CONNECTION_FAILURE);
                put(java/net/SocketException, PMErrorType.CONNECTION_FAILURE);
                put(javax/net/ssl/SSLException, PMErrorType.CONNECTION_FAILURE);
                put(java/io/InterruptedIOException, PMErrorType.CONNECTION_TIMEOUT);
                put(java/net/SocketTimeoutException, PMErrorType.CONNECTION_TIMEOUT);
            }
    };
    public final int httpCode;
    public final PMError pmError;
    public final PMErrorType pmErrorType;

    public PMApiError(PMError pmerror, Throwable throwable, int i, PMErrorType pmerrortype)
    {
        super(throwable);
        pmError = pmerror;
        httpCode = i;
        if (pmerrortype != PMErrorType.UNKNOWN_ERROR)
        {
            pmerror = pmerrortype;
        } else
        {
            pmerror = getErrorType(pmerror, throwable, i, pmerrortype);
        }
        pmErrorType = pmerror;
        if (pmerrortype == PMErrorType.CONNECTION_TIMEOUT)
        {
            Analytics.getInstance().trackEvent(null, "error", "request_timeout_error", null);
        } else
        if (pmerrortype == PMErrorType.UNKNOWN_ERROR)
        {
            Analytics.getInstance().trackEvent(null, "error", "unknown_error", null);
            return;
        }
    }

    public static PMApiError deserialize(String s)
    {
        Gson gson = (new GsonBuilder()).create();
        if (!(gson instanceof Gson))
        {
            s = ((String) (gson.fromJson(s, com/poshmark/http/api/PMApiError)));
        } else
        {
            s = ((String) (GsonInstrumentation.fromJson((Gson)gson, s, com/poshmark/http/api/PMApiError)));
        }
        return (PMApiError)s;
    }

    private static PMErrorType getErrorType(PMError pmerror, Throwable throwable, int i, PMErrorType pmerrortype)
    {
        Object obj;
        obj = pmerrortype;
        if (pmerrortype == PMErrorType.UNKNOWN_ERROR)
        {
            obj = pmerrortype;
            if (pmerror != null)
            {
                obj = pmerrortype;
                if (pmerror.error != null)
                {
                    obj = pmerrortype;
                    if (pmerror.error.error_type != null)
                    {
                        obj = pmerrortype;
                        if (pmerror.error.error_type.length() > 0)
                        {
                            pmerror = (PMErrorType)PMErrorType.errorMap.get(pmerror.error.error_type);
                            obj = pmerror;
                            if (pmerror == null)
                            {
                                obj = PMErrorType.UNKNOWN_ERROR;
                            }
                        }
                    }
                }
            }
        }
        pmerror = ((PMError) (obj));
        if (obj != PMErrorType.UNKNOWN_ERROR) goto _L2; else goto _L1
_L1:
        pmerror = ((PMError) (obj));
        if (i == 0) goto _L2; else goto _L3
_L3:
        pmerror = ((PMError) (obj));
        if (i == 200) goto _L2; else goto _L4
_L4:
        i;
        JVM INSTR lookupswitch 9: default 200
    //                   400: 285
    //                   401: 292
    //                   403: 299
    //                   404: 306
    //                   410: 313
    //                   500: 317
    //                   501: 317
    //                   502: 317
    //                   503: 324;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L11 _L12
_L5:
        pmerror = ((PMError) (obj));
        if (throwable == null)
        {
            pmerror = PMErrorType.HTTP_ERROR;
        }
_L2:
        Object obj1 = pmerror;
        if (pmerror == PMErrorType.UNKNOWN_ERROR)
        {
            obj1 = pmerror;
            if (throwable != null)
            {
                obj1 = (PMErrorType)exceptionsToErrorType.get(throwable.getClass());
                pmerrortype = ((PMErrorType) (obj1));
                if (obj1 == null)
                {
                    pmerrortype = ((PMErrorType) (obj1));
                    if (throwable.getClass().isAssignableFrom(java/io/IOException))
                    {
                        pmerrortype = PMErrorType.CONNECTION_FAILURE;
                    }
                }
                obj1 = pmerror;
                if (pmerrortype != null)
                {
                    obj1 = pmerrortype;
                }
            }
        }
        return ((PMErrorType) (obj1));
_L6:
        pmerror = PMErrorType.HTTP_BAD_REQUEST;
        continue; /* Loop/switch isn't completed */
_L7:
        pmerror = PMErrorType.HTTP_UNAUTHORIZED;
        continue; /* Loop/switch isn't completed */
_L8:
        pmerror = PMErrorType.HTTP_ACCESS_FORBIDDEN;
        continue; /* Loop/switch isn't completed */
_L9:
        pmerror = PMErrorType.HTTP_NOT_FOUND;
        continue; /* Loop/switch isn't completed */
_L10:
        pmerror = PMErrorType.HTTP_GONE;
_L11:
        pmerror = PMErrorType.HTTP_INTERNAL_SERVER_ERROR;
        continue; /* Loop/switch isn't completed */
_L12:
        pmerror = PMErrorType.HTTP_SERVER_UNAVAILABLE;
        if (true) goto _L2; else goto _L13
_L13:
    }

    public static PMErrorType lookupServerErrorType(String s)
    {
        PMErrorType pmerrortype = (PMErrorType)PMErrorType.errorMap.get(s);
        s = pmerrortype;
        if (pmerrortype == null)
        {
            s = PMErrorType.UNKNOWN_ERROR;
        }
        return s;
    }

    public static String serialize(PMApiError pmapierror)
    {
        Gson gson = (new GsonBuilder()).create();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(pmapierror, com/poshmark/http/api/PMApiError);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, pmapierror, com/poshmark/http/api/PMApiError);
        }
    }

    public String getUserMessage()
    {
        if (pmError != null && pmError.error != null)
        {
            return pmError.error.user_message;
        } else
        {
            return null;
        }
    }

    public boolean isAlreadyExistsError()
    {
        return pmErrorType == PMErrorType.ALREADY_EXISTS_ERROR;
    }

    public boolean isNetworkDomainError()
    {
        static class _cls2
        {

            static final int $SwitchMap$com$poshmark$data_model$models$PMErrorType[];

            static 
            {
                $SwitchMap$com$poshmark$data_model$models$PMErrorType = new int[PMErrorType.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$PMErrorType[PMErrorType.CONNECTION_FAILURE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$PMErrorType[PMErrorType.CONNECTION_TIMEOUT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.poshmark.data_model.models.PMErrorType[pmErrorType.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

}
