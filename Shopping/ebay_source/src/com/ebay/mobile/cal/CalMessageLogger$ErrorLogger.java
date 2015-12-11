// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.cal;

import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.cal.LogMessage;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.IRequestLogger;
import com.ebay.nautilus.kernel.net.LogTrackConfiguration;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.cal:
//            CalMessageLogger

private static class calMessageLogger
    implements IRequestLogger
{

    private final CalMessageLogger calMessageLogger;
    protected final EbayRequest request;
    private long requestTime;
    private long responseTime;

    private void addServiceNameAndOperationName(com.ebay.common.net.api.cal.Builder builder)
    {
        builder.setOperationName(request.getOperationName());
        builder.setServiceName(request.getServiceName());
    }

    protected String getErrorDescription(EbayResponseError ebayresponseerror)
    {
        return "";
    }

    protected String getLongMessage(EbayResponseError ebayresponseerror)
    {
        Object obj;
label0:
        {
            String s = ebayresponseerror.longMessage;
            obj = s;
            if (!TextUtils.isEmpty(s))
            {
                break label0;
            }
            obj = s;
            if (!(ebayresponseerror instanceof com.ebay.nautilus.domain.net.))
            {
                break label0;
            }
            ebayresponseerror = (com.ebay.nautilus.domain.net.)ebayresponseerror;
            obj = s;
            if (((com.ebay.nautilus.domain.net.) (ebayresponseerror)).parameters == null)
            {
                break label0;
            }
            ebayresponseerror = ((com.ebay.nautilus.domain.net.) (ebayresponseerror)).parameters.iterator();
            do
            {
                obj = s;
                if (!ebayresponseerror.hasNext())
                {
                    break label0;
                }
                obj = (com.ebay.nautilus.domain.net..Parameter)ebayresponseerror.next();
            } while (!"errorMessage".equalsIgnoreCase(((com.ebay.nautilus.domain.net..Parameter) (obj)).name));
            obj = ((com.ebay.nautilus.domain.net..Parameter) (obj)).value;
        }
        return ((String) (obj));
    }

    protected void logCal(com.ebay.common.net.api.cal.Builder builder)
    {
    }

    public void logHostError(int i)
    {
        com.ebay.common.net.api.cal.Builder builder = new com.ebay.common.net.api.cal.Builder();
        builder.setBackTrace(LogMessage.getBackTrace());
        builder.setElapsedTime(String.valueOf(responseTime - requestTime));
        builder.setRequestStartTime(String.valueOf(requestTime));
        builder.setErrorDomain(com/ebay/nautilus/kernel/net/Connector.getSimpleName());
        builder.setRequestClass(request.getClass().getSimpleName());
        builder.setExceptionReason((new StringBuilder()).append("H").append(i).toString());
        Object obj = MyApp.getPrefs();
        builder.setUserID(((Preferences) (obj)).getCurrentUser());
        obj = ((Preferences) (obj)).getCurrentCountry();
        if (obj != null)
        {
            builder.setCountryCode(((EbayCountry) (obj)).getCountryCode());
        }
        obj = request.getRequestUrl();
        if (obj != null)
        {
            builder.setApiUrl(((URL) (obj)).toString());
        }
        addServiceNameAndOperationName(builder);
        logCal(builder);
        calMessageLogger.sendMessage(builder.build());
    }

    public void setCompleteResponse(Response response)
    {
        EbayResponse ebayresponse = (EbayResponse)response;
        if (ebayresponse.ackCode == -1)
        {
            Object obj1 = null;
            response = null;
            List list = ebayresponse.getResultStatus().getMessages();
            Object obj = obj1;
            if (list != null)
            {
                obj = obj1;
                if (!list.isEmpty())
                {
                    Iterator iterator = list.iterator();
                    do
                    {
                        obj = response;
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        obj = (com.ebay.nautilus.kernel.content.er)iterator.next();
                        if (obj instanceof EbayResponseError)
                        {
                            obj = (EbayResponseError)obj;
                            switch (((EbayResponseError) (obj)).category)
                            {
                            default:
                                break;

                            case 1: // '\001'
                            case 3: // '\003'
                                response = ((Response) (obj));
                                break;

                            case 2: // '\002'
                                if (LogTrackManager.getConfig().isRequestErrorReportingEnabled())
                                {
                                    response = ((Response) (obj));
                                }
                                break;
                            }
                        }
                    } while (true);
                }
            }
            if (obj != null)
            {
                response = getErrorDescription(((EbayResponseError) (obj)));
                Object obj2 = getLongMessage(((EbayResponseError) (obj)));
                obj = new com.ebay.common.net.api.cal.Builder();
                ((com.ebay.common.net.api.cal.Builder) (obj)).setBackTrace(LogMessage.getBackTrace());
                ((com.ebay.common.net.api.cal.Builder) (obj)).setElapsedTime(String.valueOf(responseTime - requestTime));
                ((com.ebay.common.net.api.cal.Builder) (obj)).setErrorCode(String.valueOf(ebayresponse.ackCode));
                ((com.ebay.common.net.api.cal.Builder) (obj)).setErrorDomain(com/ebay/nautilus/kernel/net/Connector.getSimpleName());
                ((com.ebay.common.net.api.cal.Builder) (obj)).setLongErrorMessage(((String) (obj2)));
                ((com.ebay.common.net.api.cal.Builder) (obj)).setRequestStartTime(String.valueOf(requestTime));
                obj2 = MyApp.getPrefs();
                ((com.ebay.common.net.api.cal.Builder) (obj)).setUserID(((Preferences) (obj2)).getCurrentUser());
                obj2 = ((Preferences) (obj2)).getCurrentCountry();
                if (obj2 != null)
                {
                    ((com.ebay.common.net.api.cal.Builder) (obj)).setCountryCode(((EbayCountry) (obj2)).getCountryCode());
                }
                obj2 = request.getRequestUrl();
                if (obj2 != null)
                {
                    ((com.ebay.common.net.api.cal.Builder) (obj)).setApiUrl(((URL) (obj2)).toString());
                }
                ((com.ebay.common.net.api.cal.Builder) (obj)).setExceptionReason(response);
                ((com.ebay.common.net.api.cal.Builder) (obj)).setRequestClass(request.getClass().getSimpleName());
                addServiceNameAndOperationName(((com.ebay.common.net.api.cal.Builder) (obj)));
                logCal(((com.ebay.common.net.api.cal.Builder) (obj)));
                calMessageLogger.sendMessage(((com.ebay.common.net.api.cal.Builder) (obj)).build());
            }
        }
    }

    public void setRequestTime(long l)
    {
        requestTime = l;
    }

    public void setResponseTime(long l)
    {
        responseTime = l;
    }

    public sageDataBuilder(EbayRequest ebayrequest, CalMessageLogger calmessagelogger)
    {
        requestTime = 0L;
        responseTime = 0L;
        request = ebayrequest;
        calMessageLogger = calmessagelogger;
    }
}
