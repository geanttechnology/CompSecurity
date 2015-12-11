// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.StackUtil;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            LogTrackPerf

public class LogTrackError extends LogTrackPerf
{

    public static final String ERROR_NAME_API = "APIError";
    public static final String ERROR_NAME_CRASH = "CrashError";
    public static final String ERROR_NAME_HTTP = "HTTPError";
    public static final String ERROR_NAME_NETWORK = "NetworkError";
    public static final String ERROR_NAME_NONFATAL_EXCEPTION = "NonFatalException";
    public static final String HIDDEN_INFO = "*** HIDDEN ***";
    public static final String HTTP_REQUEST_CONTENT_TYPE = "httpRequestContentType";
    public static final String HTTP_RESPONSE_CODE = "httpResponseCode";
    public static final String HTTP_RESPONSE_CONTENT_TYPE = "httpResponseContentType";
    public static final String HTTP_RESPONSE_MESSAGE = "httpResponseMessage";
    private static final int MAX_STACK_CHARS = 1536;
    private static final int MAX_STACK_LINES = 40;
    public static final String REQUEST_BODY = "requestBody";
    public static final String REQUEST_CLASS = "requestClass";
    public static final String REQUEST_HEADERS = "requestHeaders";
    public static final String RESPONSE_BODY = "responseBody";
    public static final String RESPONSE_HEADERS = "responseHeaders";
    public static final String SEPARATOR = "\n";
    private String backTrace;
    private String countryCode;
    private String errorCode;
    private String errorDomain;
    private String errorName;
    private String globalId;
    private String longErrorMessage;
    private Map requestHeaders;
    private String serverAddress;
    private ResultStatus status;
    private String url;
    private final HashMap userData;

    public LogTrackError(LogTrackPerf logtrackperf, String s, String s1, String s2, String s3, Throwable throwable)
    {
        super(logtrackperf);
        userData = new HashMap();
        sharedInit(s, s1, s2, s3, throwable);
    }

    public LogTrackError(String s, String s1, String s2, String s3, String s4, String s5, Throwable throwable)
    {
        super(s, s1);
        userData = new HashMap();
        sharedInit(s2, s3, s4, s5, throwable);
    }

    private void sharedInit(String s, String s1, String s2, String s3, Throwable throwable)
    {
        errorName = s3;
        url = s;
        errorDomain = s2;
        userData.put("requestClass", s1);
        if (throwable != null)
        {
            errorCode = throwable.getClass().getSimpleName();
            longErrorMessage = throwable.getLocalizedMessage();
            backTrace = StackUtil.deepStackTrace(throwable, 1536);
            return;
        } else
        {
            s = StackUtil.getCurrentThreadBackTrace(3, 40, "\n");
            backTrace = s.substring(0, Math.min(s.length(), 1536));
            return;
        }
    }

    public String getBackTrace()
    {
        return backTrace;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public String getErrorDomain()
    {
        return errorDomain;
    }

    public String getErrorName()
    {
        return errorName;
    }

    public String getGlobalId()
    {
        return globalId;
    }

    public String getLastViewedItemId()
    {
        return null;
    }

    public String getLevel()
    {
        return "ERROR";
    }

    public String getLongErrorMessage()
    {
        return longErrorMessage;
    }

    public String getRecentImpressions()
    {
        return null;
    }

    public String getRecentSearches()
    {
        return null;
    }

    public Map getRequestHeaders()
    {
        return requestHeaders;
    }

    public Map getResponseHeaders()
    {
        return responseHeaders;
    }

    public ResultStatus getResultStatus()
    {
        return status;
    }

    public String getServerAddress()
    {
        return serverAddress;
    }

    public String getUrl()
    {
        return url;
    }

    public HashMap getUserData()
    {
        return userData;
    }

    public void setContent(Map map, String s, String s1)
    {
        requestHeaders = createHeaderMap(map);
        if (s != null)
        {
            userData.put("requestBody", s);
        }
        if (s1 != null)
        {
            userData.put("responseBody", s1);
        }
    }

    public void setCountryCode(String s)
    {
        countryCode = s;
    }

    public void setErrorCode(String s)
    {
        errorCode = s;
    }

    public void setGlobalId(String s)
    {
        globalId = s;
    }

    public void setHttpResponseInfo(int i, String s, String s1)
    {
        userData.put("httpResponseCode", String.valueOf(i));
        userData.put("httpResponseMessage", s);
        userData.put("httpResponseContentType", s1);
        if (errorCode == null && TextUtils.equals("HTTPError", errorName))
        {
            setErrorCode((new StringBuilder()).append("H").append(i).toString());
        }
    }

    public void setLongErrorMessage(String s)
    {
        longErrorMessage = s;
    }

    public void setResultStatus(EbayContext ebaycontext, ResultStatus resultstatus)
    {
        status = resultstatus;
        if (resultstatus != null)
        {
            resultstatus = resultstatus.getFirstError();
            if (resultstatus != null)
            {
                setErrorCode(String.valueOf(resultstatus.getId()));
                setLongErrorMessage(ResultStatus.getSafeLongMessage(ebaycontext, resultstatus));
                errorDomain = resultstatus.getDomain();
            }
        }
    }

    public void setServerAddress(String s)
    {
        serverAddress = s;
    }
}
