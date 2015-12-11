// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MetricsCollector, ThreadUtils, MobileAdsLogger, 
//            AdMetrics, WebRequest

class Metrics
{
    static final class MetricType extends Enum
    {

        private static final MetricType $VALUES[];
        public static final MetricType AAX_CONFIG_DOWNLOAD_FAILED;
        public static final MetricType AAX_CONFIG_DOWNLOAD_LATENCY;
        public static final MetricType AAX_LATENCY_GET_AD;
        public static final MetricType ADLAYOUT_HEIGHT_ZERO;
        public static final MetricType AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO;
        public static final MetricType AD_COUNTER_AUTO_AD_SIZE;
        public static final MetricType AD_COUNTER_FAILED_DUE_TO_NO_RETRY;
        public static final MetricType AD_COUNTER_IDENTIFIED_DEVICE;
        public static final MetricType AD_COUNTER_PARENT_VIEW_MISSING;
        public static final MetricType AD_COUNTER_RENDERING_FATAL;
        public static final MetricType AD_COUNTER_RESHOWN;
        public static final MetricType AD_EXPIRED_BEFORE_SHOWING;
        public static final MetricType AD_FAILED_INVALID_AUTO_AD_SIZE;
        public static final MetricType AD_FAILED_LAYOUT_NOT_RUN;
        public static final MetricType AD_FAILED_NULL_LAYOUT_PARAMS;
        public static final MetricType AD_FAILED_UNKNOWN_WEBVIEW_ISSUE;
        public static final MetricType AD_IS_INTERSTITIAL;
        public static final MetricType AD_LATENCY_RENDER;
        public static final MetricType AD_LATENCY_RENDER_FAILED;
        public static final MetricType AD_LATENCY_TOTAL;
        public static final MetricType AD_LATENCY_TOTAL_FAILURE;
        public static final MetricType AD_LATENCY_TOTAL_SUCCESS;
        public static final MetricType AD_LAYOUT_INITIALIZATION;
        public static final MetricType AD_LOADED_TO_AD_SHOW_TIME;
        public static final MetricType AD_LOAD_FAILED;
        public static final MetricType AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT;
        public static final MetricType AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT;
        public static final MetricType AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END;
        public static final MetricType AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL;
        public static final MetricType AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP;
        public static final MetricType AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START;
        public static final MetricType AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP;
        public static final MetricType AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE;
        public static final MetricType AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START;
        public static final MetricType AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START;
        public static final MetricType AD_NO_RETRY_TTL_RECEIVED;
        public static final MetricType AD_SHOW_DURATION;
        public static final MetricType AD_SHOW_LATENCY;
        public static final MetricType ASSETS_CREATED_LATENCY;
        public static final MetricType ASSETS_ENSURED_LATENCY;
        public static final MetricType ASSETS_FAILED;
        public static final MetricType CARRIER_NAME;
        public static final MetricType CONFIG_DOWNLOAD_ERROR;
        public static final MetricType CONFIG_DOWNLOAD_LATENCY;
        public static final MetricType CONFIG_PARSE_ERROR;
        public static final MetricType CONNECTION_TYPE;
        public static final MetricType CUSTOM_RENDER_HANDLED;
        public static final MetricType EXPIRED_AD_CALL;
        public static final MetricType INTERSTITIAL_AD_ACTIVITY_FAILED;
        public static final MetricType RENDER_REQUIREMENT_CHECK_FAILURE;
        public static final MetricType SET_ORIENTATION_FAILURE;
        public static final MetricType SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED;
        public static final MetricType SIS_LATENCY_REGISTER;
        public static final MetricType SIS_LATENCY_REGISTER_EVENT;
        public static final MetricType SIS_LATENCY_UPDATE_DEVICE_INFO;
        public static final MetricType TLS_ENABLED;
        public static final MetricType VIEWPORT_SCALE;
        public static final MetricType WIFI_PRESENT;
        private final String aaxName;
        private final boolean isAdTypeSpecific;

        public static MetricType valueOf(String s)
        {
            return (MetricType)Enum.valueOf(com/amazon/device/ads/Metrics$MetricType, s);
        }

        public static MetricType[] values()
        {
            return (MetricType[])$VALUES.clone();
        }

        public String getAaxName()
        {
            return aaxName;
        }

        public boolean isAdTypeSpecific()
        {
            return isAdTypeSpecific;
        }

        static 
        {
            AD_LATENCY_TOTAL = new MetricType("AD_LATENCY_TOTAL", 0, "tl", true);
            AD_LATENCY_TOTAL_SUCCESS = new MetricType("AD_LATENCY_TOTAL_SUCCESS", 1, "tsl", true);
            AD_LATENCY_TOTAL_FAILURE = new MetricType("AD_LATENCY_TOTAL_FAILURE", 2, "tfl", true);
            AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START = new MetricType("AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START", 3, "llfsl", true);
            AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP = new MetricType("AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP", 4, "lfsul");
            AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START = new MetricType("AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START", 5, "lfsasl");
            AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END = new MetricType("AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END", 6, "laefel");
            AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP = new MetricType("AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP", 7, "lffsul");
            AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START = new MetricType("AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START", 8, "lffsrsl", true);
            AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE = new MetricType("AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE", 9, "lffsfl", true);
            AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL = new MetricType("AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL", 10, "lcaul");
            ASSETS_CREATED_LATENCY = new MetricType("ASSETS_CREATED_LATENCY", 11, "lacl");
            ASSETS_ENSURED_LATENCY = new MetricType("ASSETS_ENSURED_LATENCY", 12, "lael");
            ASSETS_FAILED = new MetricType("ASSETS_FAILED", 13, "af");
            AD_LOADED_TO_AD_SHOW_TIME = new MetricType("AD_LOADED_TO_AD_SHOW_TIME", 14, "alast");
            AD_SHOW_LATENCY = new MetricType("AD_SHOW_LATENCY", 15, "lsa");
            AD_SHOW_DURATION = new MetricType("AD_SHOW_DURATION", 16, "sd", true);
            AD_LAYOUT_INITIALIZATION = new MetricType("AD_LAYOUT_INITIALIZATION", 17, "ali");
            AAX_LATENCY_GET_AD = new MetricType("AAX_LATENCY_GET_AD", 18, "al");
            AD_LOAD_FAILED = new MetricType("AD_LOAD_FAILED", 19, "lf");
            AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT = new MetricType("AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT", 20, "lfat");
            AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT = new MetricType("AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT", 21, "lfpt", true);
            AD_COUNTER_IDENTIFIED_DEVICE = new MetricType("AD_COUNTER_IDENTIFIED_DEVICE", 22, "id");
            AD_COUNTER_RENDERING_FATAL = new MetricType("AD_COUNTER_RENDERING_FATAL", 23, "rf", true);
            AD_LATENCY_RENDER = new MetricType("AD_LATENCY_RENDER", 24, "rl", true);
            AD_LATENCY_RENDER_FAILED = new MetricType("AD_LATENCY_RENDER_FAILED", 25, "rlf", true);
            AD_COUNTER_FAILED_DUE_TO_NO_RETRY = new MetricType("AD_COUNTER_FAILED_DUE_TO_NO_RETRY", 26, "nrtf");
            AD_NO_RETRY_TTL_RECEIVED = new MetricType("AD_NO_RETRY_TTL_RECEIVED", 27, "nrtr");
            AD_COUNTER_AUTO_AD_SIZE = new MetricType("AD_COUNTER_AUTO_AD_SIZE", 28, "aas");
            AD_COUNTER_PARENT_VIEW_MISSING = new MetricType("AD_COUNTER_PARENT_VIEW_MISSING", 29, "pvm");
            ADLAYOUT_HEIGHT_ZERO = new MetricType("ADLAYOUT_HEIGHT_ZERO", 30, "ahz");
            VIEWPORT_SCALE = new MetricType("VIEWPORT_SCALE", 31, "vs");
            AD_COUNTER_RESHOWN = new MetricType("AD_COUNTER_RESHOWN", 32, "rs", true);
            AD_FAILED_UNKNOWN_WEBVIEW_ISSUE = new MetricType("AD_FAILED_UNKNOWN_WEBVIEW_ISSUE", 33, "fuwi");
            AD_FAILED_NULL_LAYOUT_PARAMS = new MetricType("AD_FAILED_NULL_LAYOUT_PARAMS", 34, "fnlp");
            AD_FAILED_LAYOUT_NOT_RUN = new MetricType("AD_FAILED_LAYOUT_NOT_RUN", 35, "flnr");
            AD_FAILED_INVALID_AUTO_AD_SIZE = new MetricType("AD_FAILED_INVALID_AUTO_AD_SIZE", 36, "faas");
            SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED = new MetricType("SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED", 37, "sid");
            SIS_LATENCY_REGISTER = new MetricType("SIS_LATENCY_REGISTER", 38, "srl");
            SIS_LATENCY_UPDATE_DEVICE_INFO = new MetricType("SIS_LATENCY_UPDATE_DEVICE_INFO", 39, "sul");
            SIS_LATENCY_REGISTER_EVENT = new MetricType("SIS_LATENCY_REGISTER_EVENT", 40, "srel");
            CONFIG_DOWNLOAD_ERROR = new MetricType("CONFIG_DOWNLOAD_ERROR", 41, "cde");
            CONFIG_DOWNLOAD_LATENCY = new MetricType("CONFIG_DOWNLOAD_LATENCY", 42, "cdt");
            CONFIG_PARSE_ERROR = new MetricType("CONFIG_PARSE_ERROR", 43, "cpe");
            AAX_CONFIG_DOWNLOAD_LATENCY = new MetricType("AAX_CONFIG_DOWNLOAD_LATENCY", 44, "acl");
            AAX_CONFIG_DOWNLOAD_FAILED = new MetricType("AAX_CONFIG_DOWNLOAD_FAILED", 45, "acf");
            CUSTOM_RENDER_HANDLED = new MetricType("CUSTOM_RENDER_HANDLED", 46, "crh");
            TLS_ENABLED = new MetricType("TLS_ENABLED", 47, "tls");
            WIFI_PRESENT = new MetricType("WIFI_PRESENT", 48, "wifi");
            CARRIER_NAME = new MetricType("CARRIER_NAME", 49, "car");
            CONNECTION_TYPE = new MetricType("CONNECTION_TYPE", 50, "ct");
            AD_IS_INTERSTITIAL = new MetricType("AD_IS_INTERSTITIAL", 51, "i");
            INTERSTITIAL_AD_ACTIVITY_FAILED = new MetricType("INTERSTITIAL_AD_ACTIVITY_FAILED", 52, "iaaf");
            RENDER_REQUIREMENT_CHECK_FAILURE = new MetricType("RENDER_REQUIREMENT_CHECK_FAILURE", 53, "rrcfc", true);
            EXPIRED_AD_CALL = new MetricType("EXPIRED_AD_CALL", 54, "eac", true);
            AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO = new MetricType("AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO", 55, "rarfc", true);
            SET_ORIENTATION_FAILURE = new MetricType("SET_ORIENTATION_FAILURE", 56, "rsofc", true);
            AD_EXPIRED_BEFORE_SHOWING = new MetricType("AD_EXPIRED_BEFORE_SHOWING", 57, "aebs", true);
            $VALUES = (new MetricType[] {
                AD_LATENCY_TOTAL, AD_LATENCY_TOTAL_SUCCESS, AD_LATENCY_TOTAL_FAILURE, AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP, AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START, AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END, AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP, AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, 
                AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL, ASSETS_CREATED_LATENCY, ASSETS_ENSURED_LATENCY, ASSETS_FAILED, AD_LOADED_TO_AD_SHOW_TIME, AD_SHOW_LATENCY, AD_SHOW_DURATION, AD_LAYOUT_INITIALIZATION, AAX_LATENCY_GET_AD, AD_LOAD_FAILED, 
                AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT, AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT, AD_COUNTER_IDENTIFIED_DEVICE, AD_COUNTER_RENDERING_FATAL, AD_LATENCY_RENDER, AD_LATENCY_RENDER_FAILED, AD_COUNTER_FAILED_DUE_TO_NO_RETRY, AD_NO_RETRY_TTL_RECEIVED, AD_COUNTER_AUTO_AD_SIZE, AD_COUNTER_PARENT_VIEW_MISSING, 
                ADLAYOUT_HEIGHT_ZERO, VIEWPORT_SCALE, AD_COUNTER_RESHOWN, AD_FAILED_UNKNOWN_WEBVIEW_ISSUE, AD_FAILED_NULL_LAYOUT_PARAMS, AD_FAILED_LAYOUT_NOT_RUN, AD_FAILED_INVALID_AUTO_AD_SIZE, SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED, SIS_LATENCY_REGISTER, SIS_LATENCY_UPDATE_DEVICE_INFO, 
                SIS_LATENCY_REGISTER_EVENT, CONFIG_DOWNLOAD_ERROR, CONFIG_DOWNLOAD_LATENCY, CONFIG_PARSE_ERROR, AAX_CONFIG_DOWNLOAD_LATENCY, AAX_CONFIG_DOWNLOAD_FAILED, CUSTOM_RENDER_HANDLED, TLS_ENABLED, WIFI_PRESENT, CARRIER_NAME, 
                CONNECTION_TYPE, AD_IS_INTERSTITIAL, INTERSTITIAL_AD_ACTIVITY_FAILED, RENDER_REQUIREMENT_CHECK_FAILURE, EXPIRED_AD_CALL, AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO, SET_ORIENTATION_FAILURE, AD_EXPIRED_BEFORE_SHOWING
            });
        }

        private MetricType(String s, int i, String s1)
        {
            this(s, i, s1, false);
        }

        private MetricType(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            aaxName = s1;
            isAdTypeSpecific = flag;
        }
    }

    static interface MetricsSubmitter
    {

        public abstract String getInstrumentationPixelUrl();

        public abstract MetricsCollector getMetricsCollector();

        public abstract void resetMetricsCollector();
    }


    private static final String LOGTAG = com/amazon/device/ads/Metrics.getSimpleName();
    private static final boolean TYPED_METRIC = true;
    private static Metrics instance = new Metrics();
    private final MobileAdsLogger logger;
    private MetricsCollector metricsCollector;

    Metrics()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        metricsCollector = new MetricsCollector();
    }

    public static Metrics getInstance()
    {
        return instance;
    }

    private MobileAdsLogger getLogger()
    {
        return logger;
    }

    private void sendMetrics(final WebRequest webRequest)
    {
        ThreadUtils.scheduleRunnable(new Runnable() {

            final Metrics this$0;
            final WebRequest val$webRequest;

            public void run()
            {
                webRequest.enableLog(true);
                static class _cls2
                {

                    static final int $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[];

                    static 
                    {
                        $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus = new int[WebRequest.WebRequestStatus.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.NETWORK_FAILURE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.MALFORMED_URL.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                try
                {
                    webRequest.makeCall();
                    return;
                }
                catch (WebRequest.WebRequestException webrequestexception)
                {
                    switch (_cls2..SwitchMap.com.amazon.device.ads.WebRequest.WebRequestStatus[webrequestexception.getStatus().ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        getLogger().e("Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[] {
                            webrequestexception.getMessage()
                        });
                        return;

                    case 2: // '\002'
                        getLogger().e("Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[] {
                            webrequestexception.getMessage()
                        });
                        return;

                    case 3: // '\003'
                        getLogger().e("Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[] {
                            webrequestexception.getMessage()
                        });
                        // fall through

                    case 4: // '\004'
                        getLogger().e("Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[] {
                            webrequestexception.getMessage()
                        });
                        break;
                    }
                }
            }

            
            {
                this$0 = Metrics.this;
                webRequest = webrequest;
                super();
            }
        });
    }

    public MetricsCollector getMetricsCollector()
    {
        return metricsCollector;
    }

    public void submitAndResetMetrics(MetricsSubmitter metricssubmitter)
    {
        getLogger().d("METRIC Submit and Reset");
        AdMetrics admetrics = new AdMetrics(metricssubmitter);
        if (admetrics.canSubmit())
        {
            metricssubmitter = metricsCollector;
            metricsCollector = new MetricsCollector();
            admetrics.addGlobalMetrics(metricssubmitter);
            sendMetrics(admetrics.getAaxWebRequestAndResetAdMetrics());
            return;
        } else
        {
            metricssubmitter.resetMetricsCollector();
            return;
        }
    }


}
