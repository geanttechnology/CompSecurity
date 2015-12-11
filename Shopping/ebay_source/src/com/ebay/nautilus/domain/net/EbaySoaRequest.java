// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackConfiguration;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.DefaultHelper;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayRequest, EbayResponse, EbayErrorUtil

public abstract class EbaySoaRequest extends EbayRequest
{

    protected static final String GLOBAL_ID;
    private static final String SERVICE_VERSION = "1.0.0";
    private static final String SOA_ALT_FAULT_STATUS = "x-ebay-soa-alternate-fault-status";
    private static final String SOA_API_VERSION = "x-ebay-soa-service-version";
    private static final String SOA_CERTNAME = "x-ebay-certname";
    private static final String SOA_CONSUMER_ID = "x-ebay-soa-consumer-id";
    private static final String SOA_DEVNAME = "x-ebay-devname";
    private static final String SOA_GLOBAL_ID = "x-ebay-soa-global-id";
    private static final String SOA_LOCALE_LIST = "x-ebay-soa-locale-list";
    private static final String SOA_MESSAGE_PROTOCOL = "x-ebay-soa-message-protocol";
    public static final String SOA_OPERATION_NAME = "x-ebay-soa-operation-name";
    private static final String SOA_REQUEST_DATA_FORMAT = "x-ebay-soa-request-data-format";
    private static final String SOA_RESPONSE_DATA_FORMAT = "x-ebay-soa-response-data-format";
    protected static final String SOA_SECURITY_APPNAME = "x-ebay-soa-security-appname";
    private static final String SOA_SECURITY_IAF_TOKEN = "x-ebay-soa-security-iaftoken";
    private static final String SOA_SECURITY_TOKEN = "x-ebay-soa-security-token";
    private static final String SOA_SEND_RLOG_ID = "x-ebay-soa-send-rlogid";
    protected static final String SOA_SERVICE_NAME = "x-ebay-soa-service-name";
    protected static final String SOA_SOAP_ACTION = "soapaction";
    protected transient boolean bUseSoaServiceVersion;
    protected transient String dataFormat;
    protected transient String iafToken;
    protected transient boolean isAuthenticateRequest;
    protected transient boolean isConvertedToAlternateHttpFaultStatus;
    protected transient String responseDataFormat;
    private transient boolean serviceNameInHeader;
    protected transient String soaAppIdHeaderName;
    protected transient String soaContentType;
    public transient String soaGlobalId;
    protected transient String soaMessageProtocol;
    protected transient String soaServiceVersion;
    protected transient String soaSoapAction;
    protected transient boolean useSoaLocaleList;
    protected transient String userToken;

    protected EbaySoaRequest()
    {
        soaServiceVersion = "1.0.0";
        soaAppIdHeaderName = null;
        soaSoapAction = null;
        userToken = null;
        soaMessageProtocol = null;
        soaGlobalId = null;
        soaContentType = null;
        dataFormat = null;
        responseDataFormat = null;
        bUseSoaServiceVersion = true;
        isAuthenticateRequest = false;
        iafToken = null;
        useSoaLocaleList = false;
        isConvertedToAlternateHttpFaultStatus = false;
    }

    protected EbaySoaRequest(String s, boolean flag, String s1)
    {
        soaServiceVersion = "1.0.0";
        soaAppIdHeaderName = null;
        soaSoapAction = null;
        userToken = null;
        soaMessageProtocol = null;
        soaGlobalId = null;
        soaContentType = null;
        dataFormat = null;
        responseDataFormat = null;
        bUseSoaServiceVersion = true;
        isAuthenticateRequest = false;
        iafToken = null;
        useSoaLocaleList = false;
        isConvertedToAlternateHttpFaultStatus = false;
        serviceNameInHeader = flag;
        setServiceName(s);
        setOperationName(s1);
    }

    public static String buildErrorCode(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
label0:
        {
            String s = null;
            if (message != null)
            {
                if (!(message instanceof EbayResponseError.LongDetails))
                {
                    break label0;
                }
                message = (EbayResponseError.LongDetails)message;
                s = (new StringBuilder()).append("SOA.").append(DefaultHelper.forString(message.getDomain(), "Unknown")).append(".").append(DefaultHelper.forString(((EbayResponseError.LongDetails) (message)).subdomain, "Unknown")).append(".").append(DefaultHelper.forString(message.categoryDescription(), "Unknown")).append(".").append(DefaultHelper.forString(((EbayResponseError.LongDetails) (message)).code, "Unknown")).toString();
            }
            return s;
        }
        return (new StringBuilder()).append("SOA.").append(DefaultHelper.forString(message.getDomain(), "Unknown")).append(".").append("Unknown").append(".").append("Unknown").append(".").append(message.getId()).toString();
    }

    public void appendErrorData(LogTrackError logtrackerror, EbayResponse ebayresponse, IOException ioexception)
    {
        super.appendErrorData(logtrackerror, ebayresponse, ioexception);
        if (!TextUtils.isEmpty(soaGlobalId))
        {
            EbayRequest.addSiteInfo(logtrackerror, EbaySite.getInstanceFromId(soaGlobalId));
        }
        ebayresponse = getFirstResponseError(ebayresponse);
        if (ebayresponse != null)
        {
            logtrackerror.setErrorCode(buildErrorCode(ebayresponse));
        }
    }

    public volatile void appendErrorData(LogTrackError logtrackerror, Response response, IOException ioexception)
    {
        appendErrorData(logtrackerror, (EbayResponse)response, ioexception);
    }

    protected String getErrorLanguage()
    {
        return errorLanguage;
    }

    protected String getLocaleList()
    {
        Object obj = Locale.getDefault();
        String s = ((Locale) (obj)).getLanguage();
        String s1 = ((Locale) (obj)).getCountry();
        String s2 = ((Locale) (obj)).getCountry();
        Object obj1 = null;
        obj = obj1;
        if (s != null)
        {
            obj = obj1;
            if (s2 != null)
            {
                obj = obj1;
                if (s.length() == 2)
                {
                    obj = obj1;
                    if (s2.length() == 2)
                    {
                        obj = (new StringBuilder()).append(s).append('-').append(s1).append('_').append(s2).toString();
                    }
                }
            }
        }
        return ((String) (obj));
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        EbayAppCredentials ebayappcredentials = EbayAppCredentials.get(getEbayContext());
        String s = "x-ebay-soa-consumer-id";
        if (soaAppIdHeaderName != null)
        {
            String s1 = soaAppIdHeaderName;
            s = s1;
            if (isAuthenticateRequest)
            {
                if (getOperationName().compareTo("authenticate") == 0)
                {
                    iheaders.setHeader("x-ebay-devname", ebayappcredentials.developerId);
                    iheaders.setHeader("x-ebay-certname", ebayappcredentials.certId);
                    s = s1;
                } else
                {
                    s = null;
                }
            }
        }
        if (s != null && ebayappcredentials.appId != null)
        {
            iheaders.setHeader(s, ebayappcredentials.appId);
        }
        if (!TextUtils.isEmpty(soaGlobalId))
        {
            iheaders.setHeader("x-ebay-soa-global-id", soaGlobalId);
        }
        if (LogTrackManager.getConfig().isAplsSendRlogId())
        {
            iheaders.setHeader("x-ebay-soa-send-rlogid", "1");
        }
        iheaders.setHeader("x-ebay-soa-operation-name", getOperationName());
        s = getServiceName();
        if (serviceNameInHeader && s != null)
        {
            iheaders.setHeader("x-ebay-soa-service-name", s);
        }
        if (soaMessageProtocol != null)
        {
            iheaders.setHeader("x-ebay-soa-message-protocol", soaMessageProtocol);
        }
        if (soaSoapAction != null)
        {
            iheaders.setHeader("soapaction", soaSoapAction);
        }
        if (soaContentType != null)
        {
            iheaders.setHeader("Content-Type", soaContentType);
        } else
        if (soaMessageProtocol != null && soaMessageProtocol.compareTo("SOAP12") == 0)
        {
            iheaders.setHeader("Content-Type", "application/soap+xml; charset=UTF-8");
        } else
        {
            iheaders.setHeader("Content-Type", "text/xml; charset=UTF-8");
        }
        if (iafToken != null)
        {
            iheaders.setHeader("x-ebay-soa-security-iaftoken", iafToken);
        }
        if (userToken != null)
        {
            iheaders.setHeader("x-ebay-soa-security-token", userToken);
        }
        if (bUseSoaServiceVersion)
        {
            iheaders.setHeader("x-ebay-soa-service-version", soaServiceVersion);
        }
        if (dataFormat != null)
        {
            iheaders.setHeader("x-ebay-soa-request-data-format", dataFormat);
        }
        if (responseDataFormat != null)
        {
            iheaders.setHeader("x-ebay-soa-response-data-format", responseDataFormat);
        }
        if (isConvertedToAlternateHttpFaultStatus)
        {
            iheaders.setHeader("x-ebay-soa-alternate-fault-status", "");
        }
        if (useSoaLocaleList)
        {
            s = getLocaleList();
            if (s != null)
            {
                iheaders.setHeader("x-ebay-soa-locale-list", s);
            }
        }
        super.onAddHeaders(iheaders);
    }

    public void validateFailure(EbayContext ebaycontext, Response response)
        throws InterruptedException
    {
        EbayErrorUtil.validateInvalidIafTokenError(ebaycontext, iafToken, soaGlobalId, response);
    }

    static 
    {
        GLOBAL_ID = EbaySite.US.idString;
    }
}
