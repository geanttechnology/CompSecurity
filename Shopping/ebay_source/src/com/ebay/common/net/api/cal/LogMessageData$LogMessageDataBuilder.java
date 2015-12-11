// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cal;


// Referenced classes of package com.ebay.common.net.api.cal:
//            LogMessageData

public static final class 
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
        return new LogMessageData(this, null);
    }

    public  setApiUrl(String s)
    {
        apiUrl = s;
        return this;
    }

    public apiUrl setBackTrace(String s)
    {
        backTrace = s;
        return this;
    }

    public backTrace setCountryCode(String s)
    {
        countryCode = s;
        return this;
    }

    public countryCode setDiagnosticInfo(String s)
    {
        diagnosticInfo = s;
        return this;
    }

    public diagnosticInfo setElapsedTime(String s)
    {
        elapsedTime = s;
        return this;
    }

    public elapsedTime setErrorCode(String s)
    {
        errorCode = s;
        return this;
    }

    public errorCode setErrorDomain(String s)
    {
        errorDomain = s;
        return this;
    }

    public errorDomain setExceptionReason(String s)
    {
        exceptionReason = s;
        return this;
    }

    public exceptionReason setLongErrorMessage(String s)
    {
        longErrorMessage = s;
        return this;
    }

    public longErrorMessage setOperationName(String s)
    {
        operationName = s;
        return this;
    }

    public operationName setRecentImpressions(String s)
    {
        recentImpressions = s;
        return this;
    }

    public recentImpressions setRecentSearches(String s)
    {
        recentSearches = s;
        return this;
    }

    public recentSearches setRequestClass(String s)
    {
        requestClass = s;
        return this;
    }

    public requestClass setRequestStartTime(String s)
    {
        requestStartTime = s;
        return this;
    }

    public requestStartTime setServiceName(String s)
    {
        serviceName = s;
        return this;
    }

    public serviceName setSiteID(String s)
    {
        siteID = s;
        return this;
    }

    public siteID setUserID(String s)
    {
        userID = s;
        return this;
    }

    public ()
    {
    }
}
