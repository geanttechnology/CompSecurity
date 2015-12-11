// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cal;

import android.net.Uri;
import java.util.Locale;

public class LogMessageData
{
    public static final class LogMessageDataBuilder
    {

        String apiUrl;
        String backTrace;
        String countryCode;
        String diagnosticInfo;
        String elapsedTime;
        String errorCode;
        String errorDomain;
        String exceptionReason;
        String longErrorMessage;
        String operationName;
        String recentImpressions;
        String recentSearches;
        String requestClass;
        String requestStartTime;
        String serviceName;
        String siteID;
        String userID;

        public LogMessageData build()
        {
            return new LogMessageData(this);
        }

        public LogMessageDataBuilder setApiUrl(String s)
        {
            apiUrl = s;
            return this;
        }

        public LogMessageDataBuilder setBackTrace(String s)
        {
            backTrace = s;
            return this;
        }

        public LogMessageDataBuilder setCountryCode(String s)
        {
            countryCode = s;
            return this;
        }

        public LogMessageDataBuilder setDiagnosticInfo(String s)
        {
            diagnosticInfo = s;
            return this;
        }

        public LogMessageDataBuilder setElapsedTime(String s)
        {
            elapsedTime = s;
            return this;
        }

        public LogMessageDataBuilder setErrorCode(String s)
        {
            errorCode = s;
            return this;
        }

        public LogMessageDataBuilder setErrorDomain(String s)
        {
            errorDomain = s;
            return this;
        }

        public LogMessageDataBuilder setExceptionReason(String s)
        {
            exceptionReason = s;
            return this;
        }

        public LogMessageDataBuilder setLongErrorMessage(String s)
        {
            longErrorMessage = s;
            return this;
        }

        public LogMessageDataBuilder setOperationName(String s)
        {
            operationName = s;
            return this;
        }

        public LogMessageDataBuilder setRecentImpressions(String s)
        {
            recentImpressions = s;
            return this;
        }

        public LogMessageDataBuilder setRecentSearches(String s)
        {
            recentSearches = s;
            return this;
        }

        public LogMessageDataBuilder setRequestClass(String s)
        {
            requestClass = s;
            return this;
        }

        public LogMessageDataBuilder setRequestStartTime(String s)
        {
            requestStartTime = s;
            return this;
        }

        public LogMessageDataBuilder setServiceName(String s)
        {
            serviceName = s;
            return this;
        }

        public LogMessageDataBuilder setSiteID(String s)
        {
            siteID = s;
            return this;
        }

        public LogMessageDataBuilder setUserID(String s)
        {
            userID = s;
            return this;
        }

        public LogMessageDataBuilder()
        {
        }
    }


    private final String apiUrl;
    private final String backTrace;
    private final String countryCode;
    private final String diagnosticInfo;
    private final String elapsedTime;
    private final String errorCode;
    private final String errorDomain;
    private final String exceptionReason;
    private final String longErrorMessage;
    private final String operationName;
    private final String recentImpressions;
    private final String recentSearches;
    private final String requestClass;
    private final String requestStartTime;
    private final String serviceName;
    private final String siteID;
    private final String userID;

    private LogMessageData(LogMessageDataBuilder logmessagedatabuilder)
    {
        String s;
        if (logmessagedatabuilder.apiUrl == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.apiUrl;
        }
        apiUrl = s;
        if (logmessagedatabuilder.backTrace == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.backTrace;
        }
        backTrace = s;
        if (logmessagedatabuilder.diagnosticInfo == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.diagnosticInfo;
        }
        diagnosticInfo = s;
        if (logmessagedatabuilder.elapsedTime == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.elapsedTime;
        }
        elapsedTime = s;
        if (logmessagedatabuilder.errorCode == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.errorCode;
        }
        errorCode = s;
        if (logmessagedatabuilder.errorDomain == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.errorDomain;
        }
        errorDomain = s;
        if (logmessagedatabuilder.exceptionReason == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.exceptionReason;
        }
        exceptionReason = s;
        if (logmessagedatabuilder.longErrorMessage == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.longErrorMessage;
        }
        longErrorMessage = s;
        if (logmessagedatabuilder.recentImpressions == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.recentImpressions;
        }
        recentImpressions = s;
        if (logmessagedatabuilder.recentSearches == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.recentSearches;
        }
        recentSearches = s;
        if (logmessagedatabuilder.requestClass == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.requestClass;
        }
        requestClass = s;
        if (logmessagedatabuilder.requestStartTime == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.requestStartTime;
        }
        requestStartTime = s;
        if (logmessagedatabuilder.siteID == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.siteID;
        }
        siteID = s;
        if (logmessagedatabuilder.userID == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.userID;
        }
        userID = s;
        if (logmessagedatabuilder.serviceName == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.serviceName;
        }
        serviceName = s;
        if (logmessagedatabuilder.operationName == null)
        {
            s = "";
        } else
        {
            s = logmessagedatabuilder.operationName;
        }
        operationName = s;
        if (logmessagedatabuilder.countryCode == null)
        {
            logmessagedatabuilder = "";
        } else
        {
            logmessagedatabuilder = logmessagedatabuilder.countryCode.toUpperCase(Locale.US);
        }
        countryCode = logmessagedatabuilder;
    }


    public String toQueryString()
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.appendQueryParameter("apiURL", apiUrl);
        builder.appendQueryParameter("backtrace", backTrace);
        builder.appendQueryParameter("diagnosticInfo", diagnosticInfo);
        builder.appendQueryParameter("elapsedTime", elapsedTime);
        builder.appendQueryParameter("errorCode", errorCode);
        builder.appendQueryParameter("errorDomain", errorDomain);
        builder.appendQueryParameter("exceptionReason", exceptionReason);
        builder.appendQueryParameter("longErrorMessage", longErrorMessage);
        builder.appendQueryParameter("recentImpressions", recentImpressions);
        builder.appendQueryParameter("recentSearches", recentSearches);
        builder.appendQueryParameter("requestClass", requestClass);
        builder.appendQueryParameter("requestStartTime", requestStartTime);
        builder.appendQueryParameter("siteID", siteID);
        builder.appendQueryParameter("userID", userID);
        builder.appendQueryParameter("serviceName", serviceName);
        builder.appendQueryParameter("operationName", operationName);
        builder.appendQueryParameter("countryCode", countryCode);
        return builder.build().getEncodedQuery();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("LogMessage:\n");
        stringbuilder.append("apiURL=").append(apiUrl).append("\n");
        stringbuilder.append("backtrace=").append(backTrace).append("\n");
        stringbuilder.append("diagnosticInfo=").append(diagnosticInfo).append("\n");
        stringbuilder.append("elapsedTime=").append(elapsedTime).append("\n");
        stringbuilder.append("errorCode=").append(errorCode).append("\n");
        stringbuilder.append("errorDomain=").append(errorDomain).append("\n");
        stringbuilder.append("exceptionReason=").append(exceptionReason).append("\n");
        stringbuilder.append("longErrorMessage=").append(longErrorMessage).append("\n");
        stringbuilder.append("recentImpressions=").append(recentImpressions).append("\n");
        stringbuilder.append("recentSearches=").append(recentSearches).append("\n");
        stringbuilder.append("requestClass=").append(requestClass).append("\n");
        stringbuilder.append("requestStartTime=").append(requestStartTime).append("\n");
        stringbuilder.append("siteID=").append(siteID).append("\n");
        stringbuilder.append("userID=").append(userID).append("\n");
        stringbuilder.append("serviceName=").append(serviceName).append("\n");
        stringbuilder.append("operationName=").append(operationName).append("\n");
        stringbuilder.append("countryCode=").append(countryCode).append("\n");
        return stringbuilder.toString();
    }
}
