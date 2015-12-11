// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayRequest, CosVersionType, EbayResponseError, EbayErrorUtil

public abstract class EbayCosRequest extends EbayRequest
    implements com.ebay.nautilus.kernel.net.Request.Recoverable
{

    protected static final String COS_CORRELATION_SESSION = "x-ebay-c-correlation-session";
    protected static final String COS_END_USER_CONTEXT = "x-ebay-c-enduserctx";
    protected static final String COS_IDENTITY = "x-ebay-c-identity";
    protected static final String COS_MARKETPLACE_ID = "x-ebay-c-marketplace-id";
    protected static final String COS_REQUEST_ID = "x-ebay-c-request-id";
    protected static final String COS_TERRITORY_ID = "x-ebay-c-territory-id";
    protected static final String COS_TRACKING = "x-ebay-c-tracking";
    protected static final String COS_VERSION = "x-ebay-c-version";
    private static final int DEFAULT_RETRY_COUNT = 1;
    private static final String DEFAULT_SERVICE_VERSION = "1.0.0";
    private static final String HTTP_AUTHORIZATION = "Authorization";
    private static final String SOAP_ACTION = "soapaction";
    protected static final String TAG = com/ebay/nautilus/domain/net/EbayCosRequest.getSimpleName();
    protected String authHeaderValue;
    protected final CosVersionType cosVersionType;
    protected String endUserContext;
    protected String iafToken;
    protected String marketPlaceId;
    protected String requestBodyContentType;
    protected String responseBodyContentType;
    protected String serviceVersion;
    protected String soapAction;
    protected String territory;
    protected String trackingCorrelationId;
    protected String trackingCorrelationSession;
    protected String trackingHeader;
    protected boolean useServiceVersion;

    protected EbayCosRequest(String s, String s1)
    {
        super(s, s1);
        marketPlaceId = null;
        iafToken = null;
        soapAction = null;
        territory = null;
        endUserContext = null;
        trackingHeader = null;
        trackingCorrelationId = null;
        trackingCorrelationSession = null;
        useServiceVersion = true;
        serviceVersion = "1.0.0";
        cosVersionType = CosVersionType.V1;
    }

    protected EbayCosRequest(String s, String s1, CosVersionType cosversiontype)
    {
        super(s, s1);
        marketPlaceId = null;
        iafToken = null;
        soapAction = null;
        territory = null;
        endUserContext = null;
        trackingHeader = null;
        trackingCorrelationId = null;
        trackingCorrelationSession = null;
        useServiceVersion = true;
        serviceVersion = "1.0.0";
        cosVersionType = cosversiontype;
    }

    public static String getLocaleList()
    {
        Object obj = Locale.getDefault();
        String s = ((Locale) (obj)).getLanguage();
        obj = ((Locale) (obj)).getCountry();
        if (s.length() == 2 && ((String) (obj)).length() == 2)
        {
            return (new StringBuilder()).append(s).append('-').append(((String) (obj))).toString();
        } else
        {
            return null;
        }
    }

    protected final String buildEndUserContext(EbayCountry ebaycountry, Address address, Location location, boolean flag)
    {
        String s = null;
        Object obj2 = null;
        Object obj1 = null;
        Object obj = null;
        if (ebaycountry != null)
        {
            s = ebaycountry.getCountryCode();
        }
        String s1 = s;
        EbayCountry ebaycountry1 = obj2;
        String s2 = obj;
        if (address != null)
        {
            s1 = s;
            ebaycountry1 = obj2;
            s2 = obj;
            if (address.addressFields != null)
            {
                if (!TextUtils.isEmpty(address.addressFields.getCountry()))
                {
                    s = address.addressFields.getCountry();
                }
                ebaycountry = obj1;
                if (!TextUtils.isEmpty(address.addressFields.getCity()))
                {
                    ebaycountry = address.addressFields.getCity();
                }
                s1 = s;
                ebaycountry1 = ebaycountry;
                s2 = obj;
                if (!TextUtils.isEmpty(address.addressFields.getPostalCode()))
                {
                    s2 = address.addressFields.getPostalCode();
                    ebaycountry1 = ebaycountry;
                    s1 = s;
                }
            }
        }
        return buildEndUserContext(s1, ((String) (ebaycountry1)), s2, location, flag);
    }

    protected final String buildEndUserContext(String s, String s1, String s2, Location location, boolean flag)
    {
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        DelimitedStringBuilder delimitedstringbuilder;
        String s3;
        try
        {
            stringbuilder = new StringBuilder();
            stringbuilder1 = new StringBuilder();
            delimitedstringbuilder = new DelimitedStringBuilder(stringbuilder, ",");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "invalid encoding", s);
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        s3 = NautilusDomain.getMachineGroupId(getContext());
        if (!TextUtils.isEmpty(s3))
        {
            delimitedstringbuilder.appendDelimiterExceptFirstTime().append("deviceId=").append(s3);
            delimitedstringbuilder.appendDelimiterExceptFirstTime().append("machineGroupID=IDREF");
        }
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        delimitedstringbuilder.appendDelimiterExceptFirstTime().append("physicalLocation=");
        stringbuilder1.append("latitude=").append(location.getLatitude());
        stringbuilder1.append(",longitude=").append(location.getLongitude());
        stringbuilder.append(URLEncoder.encode(stringbuilder1.toString(), "UTF-8"));
        stringbuilder1.setLength(0);
        if (!TextUtils.isEmpty(s))
        {
            delimitedstringbuilder.appendDelimiterExceptFirstTime().append("contextualLocation=");
            stringbuilder1.append("country=").append(s);
            if (!TextUtils.isEmpty(s1))
            {
                stringbuilder1.append(",city=").append(s1);
            }
            if (!TextUtils.isEmpty(s2))
            {
                stringbuilder1.append(",zip=").append(s2);
            }
            stringbuilder.append(URLEncoder.encode(stringbuilder1.toString(), "UTF-8"));
            stringbuilder1.setLength(0);
        }
        if (!cosVersionType.minimumOf(CosVersionType.V3) || getEbayContext() == null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        delimitedstringbuilder.appendDelimiterExceptFirstTime().append("userAgent=");
        s2 = new DelimitedStringBuilder(stringbuilder, ";", true);
        s2.append("ebayUserAgent/eBayAndroid");
        s2.append(getEbayContext().getAppInfo().getAppVersionWithoutBuildNumber());
        s2.append(DeviceInfoUtil.getOsType());
        s2.append(android.os.Build.VERSION.RELEASE);
        s2.append(Build.MANUFACTURER.replaceAll("[,;]", "_"));
        s2.append(Build.DEVICE.replaceAll("[,;]", "_"));
        s1 = DeviceInfoUtil.getCarrier(getContext());
        s = s1;
        if (!TextUtils.isEmpty(s1))
        {
            s = s1.replaceAll("[,;]", "_");
        }
        s2.append(s);
        s2.append(DeviceInfoUtil.getScreenResolution(getContext()));
        s = getContext().getResources().getDisplayMetrics();
        s2.append(String.format(Locale.US, "%.1f", new Object[] {
            Float.valueOf(((DisplayMetrics) (s)).density)
        }));
        s = stringbuilder.toString();
        return s;
    }

    public void clearResponse()
    {
    }

    protected String getIdentity(EbayAppCredentials ebayappcredentials)
    {
        return String.format("id=%s,idp=EBAYAPP", new Object[] {
            ebayappcredentials.appId
        });
    }

    public int getRetryCount()
    {
        return 1;
    }

    public boolean hasRecoverableError(Response response, IOException ioexception)
    {
        if (isIdempotent()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (isRetriableException(ioexception))
        {
            return true;
        }
        if (response == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (NetworkUtil.isHttpClass5xx(response.responseCode))
        {
            return true;
        }
        response = response.getResultStatus().getMessages();
        if (response == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        response = response.iterator();
        do
        {
            if (!response.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            ioexception = (com.ebay.nautilus.kernel.content.ResultStatus.Message)response.next();
        } while (!(ioexception instanceof EbayResponseError) || ((EbayResponseError)ioexception).actionToTake != EbayResponseError.RecommendedAction.RETRY);
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    protected void initialize(ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        super.initialize(resultstatusowner);
        EbayContext ebaycontext = getEbayContext();
        EbayAppCredentials ebayappcredentials = EbayAppCredentials.get(ebaycontext);
        if (cosVersionType.minimumOf(CosVersionType.V2))
        {
            authHeaderValue = (new StringBuilder()).append("Bearer ").append(ebayappcredentials.getBearerToken(ebaycontext, iafToken, resultstatusowner)).toString();
            return;
        }
        if (iafToken != null)
        {
            authHeaderValue = (new StringBuilder()).append("IAF ").append(iafToken).toString();
            return;
        } else
        {
            authHeaderValue = (new StringBuilder()).append("APP ").append(ebayappcredentials.appId).toString();
            return;
        }
    }

    protected boolean isIdempotent()
    {
        return false;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        Object obj = getEbayContext();
        String s1 = getIdentity(EbayAppCredentials.get(((EbayContext) (obj))));
        if (s1 != null)
        {
            iheaders.setHeader("x-ebay-c-identity", s1);
        }
        if (marketPlaceId != null)
        {
            iheaders.setHeader("x-ebay-c-marketplace-id", marketPlaceId);
        }
        if (useServiceVersion)
        {
            iheaders.setHeader("x-ebay-c-version", serviceVersion);
        }
        if (territory != null)
        {
            iheaders.setHeader("x-ebay-c-territory-id", territory);
        }
        if (TextUtils.isEmpty(endUserContext))
        {
            endUserContext = buildEndUserContext(null, null, null, null, true);
        }
        if (!TextUtils.isEmpty(endUserContext))
        {
            iheaders.setHeader("x-ebay-c-enduserctx", endUserContext);
        }
        obj = (ExperimentationDataManager)DataManager.getIfExists(((EbayContext) (obj)), new com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager.KeyParams(getEbayContext()));
        if (obj != null)
        {
            obj = ((ExperimentationDataManager) (obj)).getTrackingSessionHeaders();
            String s2;
            for (Iterator iterator = ((Bundle) (obj)).keySet().iterator(); iterator.hasNext(); iheaders.setHeader(s2, ((Bundle) (obj)).getString(s2)))
            {
                s2 = (String)iterator.next();
            }

        }
        if (soapAction != null)
        {
            iheaders.setHeader("soapaction", soapAction);
        }
        iheaders.setHeader("Authorization", authHeaderValue);
        if (requestBodyContentType != null)
        {
            iheaders.setHeader("Content-Type", requestBodyContentType);
        } else
        {
            iheaders.setHeader("Content-Type", "application/xml; charset=UTF-8");
        }
        if (responseBodyContentType != null)
        {
            iheaders.setHeader("accept", responseBodyContentType);
        } else
        {
            iheaders.setHeader("accept", "application/xml; charset=UTF-8");
        }
        obj = getLocaleList();
        if (obj != null)
        {
            iheaders.setHeader("accept-language", ((String) (obj)));
        }
        if (trackingHeader != null)
        {
            iheaders.setHeader("x-ebay-c-tracking", trackingHeader);
        }
        if (trackingCorrelationId != null)
        {
            try
            {
                iheaders.setHeader("x-ebay-c-request-id", (new StringBuilder()).append("rci=").append(URLEncoder.encode(trackingCorrelationId, "UTF-8")).toString());
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                Log.e(TAG, "invalid encoding", unsupportedencodingexception);
            }
        }
        if (trackingCorrelationSession != null)
        {
            try
            {
                String s = URLEncoder.encode(trackingCorrelationSession, "UTF-8");
                iheaders.setHeader("x-ebay-c-correlation-session", (new StringBuilder()).append("si=").append(s).append(",gci=").append(s).toString());
            }
            catch (UnsupportedEncodingException unsupportedencodingexception1)
            {
                Log.e(TAG, "invalid encoding", unsupportedencodingexception1);
            }
        }
        super.onAddHeaders(iheaders);
    }

    public void validateFailure(EbayContext ebaycontext, Response response)
        throws InterruptedException
    {
        EbayErrorUtil.validateInvalidIafTokenError(ebaycontext, iafToken, marketPlaceId, response);
    }

}
