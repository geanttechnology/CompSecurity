// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.mobile.analytics.RoiTrackEventRequest;
import com.ebay.mobile.analytics.RoiTrackEventResponse;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.analytics.model.TrackingFlags;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IHeader;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.XmlFormatter;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            AnalyticsProviderModule, TrackEventResponse

public final class TrackEventRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String BIT_POSITION_TAG = "bitPosition";
    private static final String COOKIE_TAG = "rovercookie";
    private static final String EVENT_NAME_TAG = "eventName";
    private static final String EVENT_TAG = "trackingEvent";
    private static final String FLAGSET_NAME_TAG = "name";
    private static final String FLAGSET_TAG = "flagset";
    private static final String FLAGS_TAG = "flags";
    private static final String KEY_TAG = "key";
    private static final String MOBILE_APP_NAME_HEADER = "x-ebay-mobile-app-name";
    private static final String MOBILE_APP_VERSION_HEADER = "x-ebay-mobile-app-version";
    private static final String MOBILE_MTS_APP_ID_HEADER = "x-ebay-mobile-mts-appid";
    private static final String PARAMETER_TAG = "trackingParameter";
    private static final String PROPERTY_TAG = "eventProperty";
    private static final String REQUEST_NAME = "trackEventRequest";
    private static final String ROI_URL_TAG = "ru";
    private static final String ROVER_COMMAND_ROI = "roverroi";
    private static final String ROVER_COMMAND_TAG = "rvrcmd";
    private static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    public static final String SERVICE_NAME = "MobileTrackingService";
    private static final String SERVICE_OPERATION = "trackEvent";
    private static final String SESSION_COUNTER_TAG = "c";
    private static final String SESSION_TAG = "trackingSessionData";
    private static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    private static final String SOURCE_ID_EVENT = "srce";
    private static final String SOURCE_ID_LINK = "srcc";
    private static final String SOURCE_ID_MODULE = "srcm";
    private static final String SOURCE_ID_REFERENCE = "ref";
    private static final String TAGS_TAG = "tags";
    static final String TIMESTAMP_TAG = "eventTimestamp";
    private static final String VALUE_TAG = "value";
    private static final String VERBOSITY = "verbose";
    private static AtomicLong sessionCounter = new AtomicLong();
    private String appId;
    private byte bytes[];
    private final Context context;
    private final List events;
    private final Bundle sessionData;

    protected TrackEventRequest(Context context1, Bundle bundle, List list)
    {
        super("MobileTrackingService", true, "trackEvent");
        bytes = null;
        setGzipCompress(true);
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaMessageProtocol = "SOAP12";
        super.soaGlobalId = GLOBAL_ID;
        super.dataFormat = "XML";
        super.soaContentType = "text/xml";
        if (bundle.containsKey("ai"))
        {
            appId = bundle.getString("ai");
            bundle.remove("ai");
        }
        if (bundle.containsKey("site"))
        {
            super.soaGlobalId = EbaySite.getInstanceFromId(bundle.getString("site")).idString;
            bundle.remove("site");
        }
        if (bundle.containsKey("iafToken"))
        {
            super.iafToken = bundle.getString("iafToken");
            bundle.remove("iafToken");
        }
        context = context1;
        sessionData = bundle;
        events = list;
    }

    private void addEventFlags(XmlSerializer xmlserializer, TrackingFlags trackingflags)
        throws IOException
    {
        if (trackingflags != null && trackingflags.hasFlags())
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "flagset");
            String s = trackingflags.getName();
            if (!TextUtils.isEmpty(s))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "name", s);
            }
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "flags");
            for (trackingflags = trackingflags.getBitPositionsAsStrings().iterator(); trackingflags.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "bitPosition", (String)trackingflags.next())) { }
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "flags");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "flagset");
        }
    }

    private void addEventPostamble(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingEvent");
    }

    private void addEventPreamble(XmlSerializer xmlserializer, TrackingData trackingdata)
        throws IOException
    {
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            FwLog.logMethod(AnalyticsProviderModule.verboseLogger, new Object[0]);
        }
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingEvent");
        String s = trackingdata.getName();
        if (s == null)
        {
            s = "Unknown";
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "eventName", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "eventTimestamp", trackingdata.getAndRemoveValueForKey("eventTimestamp"));
    }

    private void addEventSourceIdentification(XmlSerializer xmlserializer, SourceIdentification sourceidentification)
        throws IOException
    {
        if (sourceidentification != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "ref");
            String s = sourceidentification.getEvent();
            if (s != null)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "srce", s);
            }
            s = sourceidentification.getModule();
            if (s != null)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "srcm", s);
            }
            sourceidentification = sourceidentification.getLink();
            if (sourceidentification != null)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "srcc", sourceidentification);
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "ref");
        }
    }

    private void addEventTags(XmlSerializer xmlserializer, Bundle bundle)
        throws IOException
    {
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "tags");
        addSessionCounterParameter(xmlserializer);
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); addParameter(xmlserializer, s, bundle.getString(s)))
        {
            s = (String)iterator.next();
        }

        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "tags");
    }

    private void addParameter(XmlSerializer xmlserializer, String s, String s1)
        throws IOException
    {
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingParameter");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "key", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "value", s1);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingParameter");
    }

    private void addRoiEvent(XmlSerializer xmlserializer, TrackingData trackingdata)
    {
        Object obj;
        boolean flag1;
        Object obj1 = trackingdata.getValueForKey("roiTransactionType");
        Object obj2 = trackingdata.getValueForKey("sellerName");
        String s = trackingdata.getValueForKey("itm");
        String s1 = trackingdata.getValueForKey("bti");
        String s2 = trackingdata.getValueForKey("quan");
        obj = trackingdata.getValueForKey("orderTotal.currencyId");
        String s3 = trackingdata.getValueForKey("orderTotal.amount");
        String s4;
        boolean flag;
        if (obj != null && s3 != null)
        {
            obj = new ItemCurrency(((String) (obj)), s3);
        } else
        {
            obj = null;
        }
        s3 = trackingdata.getValueForKey("leaf");
        s4 = trackingdata.getValueForKey("secondaryCategoryId");
        if (obj2 != null || s != null || s1 != null || s2 != null || obj != null || s3 != null || s4 != null)
        {
            obj = new com.ebay.mobile.analytics.RoiTrackEventRequest.ItemData(((String) (obj2)), s, s1, s2, ((ItemCurrency) (obj)), s3, s4);
        } else
        {
            obj = null;
        }
        obj2 = EbaySite.getInstanceFromId(trackingdata.getValueForKey("shipsiteid"));
        s = trackingdata.getValueForKey("userName");
        obj = new RoiTrackEventRequest(((String) (obj1)), appId, ((EbaySite) (obj2)), iafToken, s, ((com.ebay.mobile.analytics.RoiTrackEventRequest.ItemData) (obj)));
        obj = (RoiTrackEventResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), ((com.ebay.nautilus.kernel.net.Request) (obj)));
        if (!((RoiTrackEventResponse) (obj)).isSuccessful()) goto _L2; else goto _L1
_L1:
        flag1 = false;
        flag = false;
        if (((RoiTrackEventResponse) (obj)).urls == null) goto _L4; else goto _L3
_L3:
        obj = ((RoiTrackEventResponse) (obj)).urls.iterator();
_L7:
        flag1 = flag;
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L5
_L5:
        obj1 = Uri.parse((String)((Iterator) (obj)).next());
        if (isRoverRoi(((Uri) (obj1))))
        {
            flag = true;
        }
        addEventPreamble(xmlserializer, trackingdata);
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "eventProperty");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "tags");
        addSessionCounterParameter(xmlserializer);
        addParameter(xmlserializer, "rvrcmd", "roverroi");
        addParameter(xmlserializer, "ru", URLEncoder.encode(((Uri) (obj1)).toString(), "ISO-8859-1"));
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "tags");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "eventProperty");
        addEventPostamble(xmlserializer);
        if (true) goto _L7; else goto _L6
_L6:
        xmlserializer;
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            AnalyticsProviderModule.verboseLogger.logAsError("ROI factory failed", xmlserializer);
        }
_L9:
        return;
_L4:
        if (flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (AnalyticsProviderModule.debugLogger.isLoggable)
        {
            AnalyticsProviderModule.debugLogger.logAsError("ROI factory failed; a response was received, but no 'roverroi' URLs were included.");
            return;
        }
        continue; /* Loop/switch isn't completed */
        xmlserializer;
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            AnalyticsProviderModule.verboseLogger.logAsError("ROI factory failed", xmlserializer);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        xmlserializer = "ROI factory failed";
        if (((RoiTrackEventResponse) (obj)).getResultStatus().hasError())
        {
            xmlserializer = (new StringBuilder()).append("ROI factory failed").append(": ").append(((RoiTrackEventResponse) (obj)).getResultStatus()).toString();
        }
        throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(xmlserializer);
        xmlserializer;
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            AnalyticsProviderModule.verboseLogger.logAsError("ROI factory failed", xmlserializer);
            return;
        }
        continue; /* Loop/switch isn't completed */
        xmlserializer;
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            AnalyticsProviderModule.verboseLogger.logAsError("ROI factory failed", xmlserializer);
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void addSessionCounterParameter(XmlSerializer xmlserializer)
        throws IOException
    {
        addParameter(xmlserializer, "c", (new StringBuilder()).append("").append(sessionCounter.incrementAndGet()).toString());
    }

    private void addSessionData(XmlSerializer xmlserializer)
        throws IOException
    {
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            FwLog.logMethod(AnalyticsProviderModule.verboseLogger, new Object[0]);
        }
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingSessionData");
        addParameter(xmlserializer, "rovercookie", AnalyticsProviderModule.getCookie(context));
        if (sessionData != null)
        {
            String s;
            for (Iterator iterator = (new HashSet(sessionData.keySet())).iterator(); iterator.hasNext(); addParameter(xmlserializer, s, sessionData.getString(s)))
            {
                s = (String)iterator.next();
            }

        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingSessionData");
    }

    private void addTrackingEvent(XmlSerializer xmlserializer, TrackingData trackingdata)
        throws IOException
    {
        addEventPreamble(xmlserializer, trackingdata);
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "eventProperty");
        addEventTags(xmlserializer, trackingdata.getKeyValuePairs());
        addEventFlags(xmlserializer, trackingdata.getTrackingFlags());
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "eventProperty");
        addEventSourceIdentification(xmlserializer, trackingdata.getSourceIdentification());
        addEventPostamble(xmlserializer);
    }

    protected static boolean isRoverRoi(Uri uri)
    {
        boolean flag1 = false;
        String s = uri.getAuthority();
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.startsWith("rover."))
            {
                flag = flag1;
                if (s.endsWith(".ebay.com"))
                {
                    uri = uri.getPathSegments();
                    flag = flag1;
                    if (uri != null)
                    {
                        flag = flag1;
                        if (!uri.isEmpty())
                        {
                            flag = flag1;
                            if ("roverroi".equals(uri.get(0)))
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        bytes = XmlSerializerHelper.buildXmlRequest(this);
        return bytes;
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            FwLog.logMethod(AnalyticsProviderModule.verboseLogger, new Object[0]);
        }
        xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackEventRequest");
        if (!AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "verbose", "errors");
        }
        addSessionData(xmlserializer);
        Iterator iterator = events.iterator();
        do
        {
            if (iterator.hasNext())
            {
                TrackingData trackingdata = (TrackingData)iterator.next();
                if ("Foreground".equals(trackingdata.getName()))
                {
                    sessionCounter.set(0L);
                }
                TrackingType trackingtype = trackingdata.getTrackingType();
                if (AnalyticsProviderModule.verboseLogger.isLoggable)
                {
                    AnalyticsProviderModule.verboseLogger.log((new StringBuilder()).append("Handling ").append(trackingtype.toString()).toString());
                }
                static class _cls1
                {

                    static final int $SwitchMap$com$ebay$mobile$analytics$TrackingType[];

                    static 
                    {
                        $SwitchMap$com$ebay$mobile$analytics$TrackingType = new int[TrackingType.values().length];
                        try
                        {
                            $SwitchMap$com$ebay$mobile$analytics$TrackingType[TrackingType.EVENT.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$analytics$TrackingType[TrackingType.PAGE_IMPRESSION.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$analytics$TrackingType[TrackingType.ROI.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls1..SwitchMap.com.ebay.mobile.analytics.TrackingType[trackingtype.ordinal()])
                {
                case 1: // '\001'
                    addTrackingEvent(xmlserializer, trackingdata);
                    break;

                case 2: // '\002'
                    addTrackingEvent(xmlserializer, trackingdata);
                    break;

                case 3: // '\003'
                    addRoiEvent(xmlserializer, trackingdata);
                    break;
                }
            } else
            {
                xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackEventRequest");
                xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
                xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
                return;
            }
        } while (true);
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.mobileTrackingServiceApi);
    }

    public TrackEventResponse getResponse()
    {
        return new TrackEventResponse(context);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay-mobile-app-version", NautilusKernel.getAppVersionWithoutBuildNumber(getContext()));
        iheaders.setHeader("x-ebay-mobile-app-name", "AEAPP");
        iheaders.setHeader("x-ebay-mobile-mts-appid", appId);
        iheaders.setHeader("x-ebay3pp-device-id", EbayIdentity.get3ppFingerprint(getContext()));
        if (AnalyticsProviderModule.debugLogger.isLoggable)
        {
            iheaders = iheaders.iterator();
            do
            {
                if (!iheaders.hasNext())
                {
                    break;
                }
                Object obj = (IHeader)iheaders.next();
                obj = new String((new StringBuilder()).append(">> ").append(((IHeader) (obj)).getName()).append(": ").append(((IHeader) (obj)).getValue()).toString());
                if (AnalyticsProviderModule.verboseLogger.isLoggable)
                {
                    AnalyticsProviderModule.verboseLogger.log(((String) (obj)));
                }
            } while (true);
            iheaders = XmlFormatter.format(new String(bytes));
            if (AnalyticsProviderModule.debugLogger.isLoggable)
            {
                AnalyticsProviderModule.debugLogger.log(iheaders);
            }
        }
    }

}
