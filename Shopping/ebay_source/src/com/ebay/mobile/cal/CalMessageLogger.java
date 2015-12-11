// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.cal;

import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.cal.LogMessage;
import com.ebay.common.net.api.cal.LogMessageData;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.service.LoggingService;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.IRequestLogger;
import com.ebay.nautilus.kernel.net.LogTrackConfiguration;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.RequestLoggerFactory;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalMessageLogger extends RequestLoggerFactory
{
    private static class EbayShoppingErrorLogger extends ErrorLogger
    {

        protected String getErrorDescription(EbayResponseError ebayresponseerror)
        {
            if (ebayresponseerror != null)
            {
                return (new StringBuilder()).append("S").append(ebayresponseerror.code).toString();
            } else
            {
                return "";
            }
        }

        protected void logCal(com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder logmessagedatabuilder)
        {
            logmessagedatabuilder.setSiteID(((EbayShoppingRequest)request).site.id);
        }

        public EbayShoppingErrorLogger(EbayShoppingRequest ebayshoppingrequest, CalMessageLogger calmessagelogger)
        {
            super(ebayshoppingrequest, calmessagelogger);
        }
    }

    private static class EbaySoaErrorLogger extends SoaErrorLogger
    {

        protected void logCal(com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder logmessagedatabuilder)
        {
            if (!TextUtils.isEmpty(((EbaySoaRequest)request).soaGlobalId))
            {
                EbaySite ebaysite = EbaySite.getInstanceFromId(((EbaySoaRequest)request).soaGlobalId);
                if (ebaysite != null)
                {
                    logmessagedatabuilder.setSiteID(ebaysite.id);
                }
            }
        }

        public EbaySoaErrorLogger(EbaySoaRequest ebaysoarequest, CalMessageLogger calmessagelogger)
        {
            super(ebaysoarequest, calmessagelogger);
        }
    }

    private static class EbayTradingErrorLogger extends ErrorLogger
    {

        protected String getErrorDescription(EbayResponseError ebayresponseerror)
        {
            if (ebayresponseerror != null)
            {
                return (new StringBuilder()).append("T").append(ebayresponseerror.code).toString();
            } else
            {
                return "";
            }
        }

        protected void logCal(com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder logmessagedatabuilder)
        {
            logmessagedatabuilder.setSiteID(((EbayTradingRequest)request).site.id);
        }

        public EbayTradingErrorLogger(EbayTradingRequest ebaytradingrequest, CalMessageLogger calmessagelogger)
        {
            super(ebaytradingrequest, calmessagelogger);
        }
    }

    private static class ErrorLogger
        implements IRequestLogger
    {

        private final CalMessageLogger calMessageLogger;
        protected final EbayRequest request;
        private long requestTime;
        private long responseTime;

        private void addServiceNameAndOperationName(com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder logmessagedatabuilder)
        {
            logmessagedatabuilder.setOperationName(request.getOperationName());
            logmessagedatabuilder.setServiceName(request.getServiceName());
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
                if (!(ebayresponseerror instanceof com.ebay.nautilus.domain.net.EbayResponseError.LongDetails))
                {
                    break label0;
                }
                ebayresponseerror = (com.ebay.nautilus.domain.net.EbayResponseError.LongDetails)ebayresponseerror;
                obj = s;
                if (((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails) (ebayresponseerror)).parameters == null)
                {
                    break label0;
                }
                ebayresponseerror = ((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails) (ebayresponseerror)).parameters.iterator();
                do
                {
                    obj = s;
                    if (!ebayresponseerror.hasNext())
                    {
                        break label0;
                    }
                    obj = (com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter)ebayresponseerror.next();
                } while (!"errorMessage".equalsIgnoreCase(((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).name));
                obj = ((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter) (obj)).value;
            }
            return ((String) (obj));
        }

        protected void logCal(com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder logmessagedatabuilder)
        {
        }

        public void logHostError(int i)
        {
            com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder logmessagedatabuilder = new com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder();
            logmessagedatabuilder.setBackTrace(LogMessage.getBackTrace());
            logmessagedatabuilder.setElapsedTime(String.valueOf(responseTime - requestTime));
            logmessagedatabuilder.setRequestStartTime(String.valueOf(requestTime));
            logmessagedatabuilder.setErrorDomain(com/ebay/nautilus/kernel/net/Connector.getSimpleName());
            logmessagedatabuilder.setRequestClass(request.getClass().getSimpleName());
            logmessagedatabuilder.setExceptionReason((new StringBuilder()).append("H").append(i).toString());
            Object obj = MyApp.getPrefs();
            logmessagedatabuilder.setUserID(((Preferences) (obj)).getCurrentUser());
            obj = ((Preferences) (obj)).getCurrentCountry();
            if (obj != null)
            {
                logmessagedatabuilder.setCountryCode(((EbayCountry) (obj)).getCountryCode());
            }
            obj = request.getRequestUrl();
            if (obj != null)
            {
                logmessagedatabuilder.setApiUrl(((URL) (obj)).toString());
            }
            addServiceNameAndOperationName(logmessagedatabuilder);
            logCal(logmessagedatabuilder);
            calMessageLogger.sendMessage(logmessagedatabuilder.build());
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
                            obj = (com.ebay.nautilus.kernel.content.ResultStatus.Message)iterator.next();
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
                    obj = new com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder();
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setBackTrace(LogMessage.getBackTrace());
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setElapsedTime(String.valueOf(responseTime - requestTime));
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setErrorCode(String.valueOf(ebayresponse.ackCode));
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setErrorDomain(com/ebay/nautilus/kernel/net/Connector.getSimpleName());
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setLongErrorMessage(((String) (obj2)));
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setRequestStartTime(String.valueOf(requestTime));
                    obj2 = MyApp.getPrefs();
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setUserID(((Preferences) (obj2)).getCurrentUser());
                    obj2 = ((Preferences) (obj2)).getCurrentCountry();
                    if (obj2 != null)
                    {
                        ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setCountryCode(((EbayCountry) (obj2)).getCountryCode());
                    }
                    obj2 = request.getRequestUrl();
                    if (obj2 != null)
                    {
                        ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setApiUrl(((URL) (obj2)).toString());
                    }
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setExceptionReason(response);
                    ((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).setRequestClass(request.getClass().getSimpleName());
                    addServiceNameAndOperationName(((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)));
                    logCal(((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)));
                    calMessageLogger.sendMessage(((com.ebay.common.net.api.cal.LogMessageData.LogMessageDataBuilder) (obj)).build());
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

        public ErrorLogger(EbayRequest ebayrequest, CalMessageLogger calmessagelogger)
        {
            requestTime = 0L;
            responseTime = 0L;
            request = ebayrequest;
            calMessageLogger = calmessagelogger;
        }
    }

    private static class SoaErrorLogger extends ErrorLogger
    {

        protected String getErrorDescription(EbayResponseError ebayresponseerror)
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (ebayresponseerror != null && (ebayresponseerror instanceof com.ebay.nautilus.domain.net.EbayResponseError.LongDetails))
            {
                com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails = (com.ebay.nautilus.domain.net.EbayResponseError.LongDetails)ebayresponseerror;
                stringbuilder.append("SOA");
                StringBuilder stringbuilder1 = stringbuilder.append('.');
                if (longdetails.domain == null)
                {
                    ebayresponseerror = "Unknown";
                } else
                {
                    ebayresponseerror = longdetails.domain;
                }
                stringbuilder1.append(ebayresponseerror);
                stringbuilder1 = stringbuilder.append('.');
                if (longdetails.subdomain == null)
                {
                    ebayresponseerror = "Unknown";
                } else
                {
                    ebayresponseerror = longdetails.subdomain;
                }
                stringbuilder1.append(ebayresponseerror);
                stringbuilder1 = stringbuilder.append('.');
                if (longdetails.categoryDescription() == null)
                {
                    ebayresponseerror = "Unknown";
                } else
                {
                    ebayresponseerror = longdetails.categoryDescription();
                }
                stringbuilder1.append(ebayresponseerror);
                stringbuilder1 = stringbuilder.append('.');
                if (longdetails.code == null)
                {
                    ebayresponseerror = "Unknown";
                } else
                {
                    ebayresponseerror = longdetails.code;
                }
                stringbuilder1.append(ebayresponseerror);
            } else
            {
                stringbuilder.append("SOA").append('.').append("Unknown");
            }
            return stringbuilder.toString();
        }

        public SoaErrorLogger(EbayRequest ebayrequest, CalMessageLogger calmessagelogger)
        {
            super(ebayrequest, calmessagelogger);
        }
    }


    public CalMessageLogger()
    {
    }

    public IRequestLogger create(Request request)
    {
        while (!LogTrackManager.getConfig().isAplsLogErrorMessageV1() || !(request instanceof EbayRequest) || (request instanceof com.ebay.common.net.api.cal.LogMessage.LogMessageRequest)) 
        {
            return null;
        }
        if (request instanceof EbayShoppingRequest)
        {
            return new EbayShoppingErrorLogger((EbayShoppingRequest)request, this);
        }
        if (request instanceof EbayTradingRequest)
        {
            return new EbayTradingErrorLogger((EbayTradingRequest)request, this);
        }
        if (request instanceof EbaySoaRequest)
        {
            return new EbaySoaErrorLogger((EbaySoaRequest)request, this);
        } else
        {
            return new ErrorLogger((EbayRequest)request, this);
        }
    }

    public void sendMessage(LogMessageData logmessagedata)
    {
        LoggingService.invoke(MyApp.getApp().getApplicationContext(), logmessagedata, MyApp.getPrefs().getCurrentSite());
    }
}
