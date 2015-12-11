// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            SISRequest, MobileAdsInfoStore, Configuration, AppEventRegistrationHandler, 
//            MobileAdsLoggerFactory, DeviceInfo, RegistrationInfo, AppInfo, 
//            JSONUtils, MobileAdsLogger, SISGenerateDIDRequest, SISUpdateDeviceInfoRequest, 
//            SISDeviceRequest

class SISRegisterEventRequest
    implements SISRequest
{
    static class SISRequestFactory
    {

        public SISDeviceRequest createDeviceRequest(SISRequestType sisrequesttype)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[];

                static 
                {
                    $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType = new int[SISRequestType.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[SISRequestType.GENERATE_DID.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[SISRequestType.UPDATE_DEVICE_INFO.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[SISRequestType.REGISTER_EVENT.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.amazon.device.ads.SISRegisterEventRequest.SISRequestType[sisrequesttype.ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("SISRequestType ").append(sisrequesttype).append(" is not a SISDeviceRequest").toString());

            case 1: // '\001'
                return new SISGenerateDIDRequest();

            case 2: // '\002'
                return new SISUpdateDeviceInfoRequest();
            }
        }

        public SISRegisterEventRequest createRegisterEventRequest(AdvertisingIdentifier.Info info, JSONArray jsonarray)
        {
            return new SISRegisterEventRequest(info, jsonarray);
        }

        SISRequestFactory()
        {
        }
    }

    static final class SISRequestType extends Enum
    {

        private static final SISRequestType $VALUES[];
        public static final SISRequestType GENERATE_DID;
        public static final SISRequestType REGISTER_EVENT;
        public static final SISRequestType UPDATE_DEVICE_INFO;

        public static SISRequestType valueOf(String s)
        {
            return (SISRequestType)Enum.valueOf(com/amazon/device/ads/SISRegisterEventRequest$SISRequestType, s);
        }

        public static SISRequestType[] values()
        {
            return (SISRequestType[])$VALUES.clone();
        }

        static 
        {
            GENERATE_DID = new SISRequestType("GENERATE_DID", 0);
            UPDATE_DEVICE_INFO = new SISRequestType("UPDATE_DEVICE_INFO", 1);
            REGISTER_EVENT = new SISRequestType("REGISTER_EVENT", 2);
            $VALUES = (new SISRequestType[] {
                GENERATE_DID, UPDATE_DEVICE_INFO, REGISTER_EVENT
            });
        }

        private SISRequestType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Metrics.MetricType CALL_METRIC_TYPE;
    private static final String LOGTAG = "SISRegisterEventRequest";
    private static final String PATH = "/register_event";
    private final AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private final AppEventRegistrationHandler appEventRegistrationHandler;
    private final JSONArray appEvents;
    private final Configuration configuration;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;

    public SISRegisterEventRequest(AdvertisingIdentifier.Info info, JSONArray jsonarray)
    {
        this(info, jsonarray, MobileAdsInfoStore.getInstance(), Configuration.getInstance(), AppEventRegistrationHandler.getInstance());
    }

    SISRegisterEventRequest(AdvertisingIdentifier.Info info, JSONArray jsonarray, MobileAdsInfoStore mobileadsinfostore, Configuration configuration1, AppEventRegistrationHandler appeventregistrationhandler)
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger("SISRegisterEventRequest");
        advertisingIdentifierInfo = info;
        appEvents = jsonarray;
        infoStore = mobileadsinfostore;
        configuration = configuration1;
        appEventRegistrationHandler = appeventregistrationhandler;
    }

    public Metrics.MetricType getCallMetricType()
    {
        return CALL_METRIC_TYPE;
    }

    public String getLogTag()
    {
        return "SISRegisterEventRequest";
    }

    public MobileAdsLogger getLogger()
    {
        return logger;
    }

    public String getPath()
    {
        return "/register_event";
    }

    public HashMap getPostParameters()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("events", appEvents.toString());
        return hashmap;
    }

    public WebRequest.QueryStringParameters getQueryParameters()
    {
        WebRequest.QueryStringParameters querystringparameters = new WebRequest.QueryStringParameters();
        querystringparameters.putUrlEncoded("adId", advertisingIdentifierInfo.getSISDeviceIdentifier());
        querystringparameters.putUrlEncoded("dt", infoStore.getDeviceInfo().getDeviceType());
        RegistrationInfo registrationinfo = infoStore.getRegistrationInfo();
        querystringparameters.putUrlEncoded("app", registrationinfo.getAppName());
        querystringparameters.putUrlEncoded("appId", registrationinfo.getAppKey());
        querystringparameters.putUrlEncoded("aud", configuration.getString(Configuration.ConfigOption.SIS_DOMAIN));
        querystringparameters.putUnencoded("pkg", infoStore.getAppInfo().getPackageInfoJSONString());
        return querystringparameters;
    }

    public void onResponseReceived(JSONObject jsonobject)
    {
        int i = JSONUtils.getIntegerFromJSON(jsonobject, "rcode", 0);
        if (i == 1)
        {
            logger.d("Application events registered successfully.");
            appEventRegistrationHandler.onAppEventsRegistered();
            return;
        } else
        {
            logger.d((new StringBuilder()).append("Application events not registered. rcode:").append(i).toString());
            return;
        }
    }

    static 
    {
        CALL_METRIC_TYPE = Metrics.MetricType.SIS_LATENCY_REGISTER_EVENT;
    }
}
