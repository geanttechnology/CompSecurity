// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, InternalAdRegistration, IInternalAdRegistration, DeviceInfo, 
//            AdTargetingOptions, WebRequest, Configuration, AdData, 
//            Size, MetricsCollector, DebugProperties, Utils, 
//            Log

class AdRequest
{
    static class JSONObjectBuilder
    {

        private AAXParameter aaxParameters[];
        private Map advancedOptions;
        private final JSONObject json = new JSONObject();
        private AAXParameter.ParameterData parameterData;

        void build()
        {
            AAXParameter aaaxparameter[] = aaxParameters;
            int j = aaaxparameter.length;
            for (int i = 0; i < j; i++)
            {
                AAXParameter aaxparameter = aaaxparameter[i];
                putIntoJSON(aaxparameter, aaxparameter.getValue(parameterData));
            }

            if (advancedOptions != null)
            {
                Iterator iterator = advancedOptions.entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if (!Utils.isNullOrWhiteSpace((String)entry.getValue()))
                    {
                        putIntoJSON((String)entry.getKey(), entry.getValue());
                    }
                } while (true);
            }
        }

        JSONObject getJSON()
        {
            return json;
        }

        AAXParameter.ParameterData getParameterData()
        {
            return parameterData;
        }

        void putIntoJSON(AAXParameter aaxparameter, Object obj)
        {
            putIntoJSON(aaxparameter.getName(), obj);
        }

        void putIntoJSON(String s, Object obj)
        {
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_14;
            }
            json.put(s, obj);
            return;
            JSONException jsonexception;
            jsonexception;
            Log.d(AdRequest.LOG_TAG, "Could not add parameter to JSON %s: %s", new Object[] {
                s, obj
            });
            return;
        }

        JSONObjectBuilder setAAXParameters(AAXParameter aaaxparameter[])
        {
            aaxParameters = aaaxparameter;
            return this;
        }

        JSONObjectBuilder setAdvancedOptions(Map map)
        {
            advancedOptions = map;
            return this;
        }

        JSONObjectBuilder setParameterData(AAXParameter.ParameterData parameterdata)
        {
            parameterData = parameterdata;
            return this;
        }

        JSONObjectBuilder()
        {
        }
    }

    static class LOISlot
    {

        static final AAXParameter PARAMETERS[];
        private final AdData adData;
        private final JSONObjectBuilder jsonObjectBuilder;
        private final AdTargetingOptions opt;

        AdData getAdData()
        {
            return adData;
        }

        AdTargetingOptions getAdTargetingOptions()
        {
            return opt;
        }

        JSONObject getJSON()
        {
            jsonObjectBuilder.build();
            return jsonObjectBuilder.getJSON();
        }

        static 
        {
            PARAMETERS = (new AAXParameter[] {
                AAXParameter.SIZE, AAXParameter.PAGE_TYPE, AAXParameter.SLOT, AAXParameter.SLOT_POSITION, AAXParameter.MAX_SIZE, AAXParameter.SLOT_ID, AAXParameter.FLOOR_PRICE
            });
        }

        LOISlot(AdData addata, AdTargetingOptions adtargetingoptions, AdRequest adrequest)
        {
            adData = addata;
            opt = adtargetingoptions;
            addata = opt.getCopyOfAdvancedOptions();
            adtargetingoptions = (new AAXParameter.ParameterData()).setAdvancedOptions(addata).setLOISlot(this).setAdRequest(adrequest);
            jsonObjectBuilder = (new JSONObjectBuilder()).setAAXParameters(PARAMETERS).setAdvancedOptions(addata).setParameterData(adtargetingoptions);
        }
    }


    private static final String AAX_ENDPOINT = "/e/msdk/ads";
    private static final String LOG_TAG = com/amazon/device/ads/AdRequest.getSimpleName();
    private static final AAXParameter PARAMETERS[];
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private final String connectionType;
    private String instrPixelUrl;
    private final JSONObjectBuilder jsonObjectBuilder;
    private final AdTargetingOptions opt;
    private final String orientation;
    private final Size screenSize;
    protected final Map slots = new HashMap();

    AdRequest(AdTargetingOptions adtargetingoptions)
    {
        opt = adtargetingoptions;
        adtargetingoptions = InternalAdRegistration.getInstance().getDeviceInfo();
        orientation = adtargetingoptions.getOrientation();
        screenSize = adtargetingoptions.getScreenSize(orientation);
        connectionType = adtargetingoptions.getConnectionType();
        adtargetingoptions = opt.getCopyOfAdvancedOptions();
        AAXParameter.ParameterData parameterdata = (new AAXParameter.ParameterData()).setAdvancedOptions(adtargetingoptions).setAdRequest(this);
        jsonObjectBuilder = (new JSONObjectBuilder()).setAAXParameters(PARAMETERS).setAdvancedOptions(adtargetingoptions).setParameterData(parameterdata);
    }

    AdTargetingOptions getAdTargetingOptions()
    {
        return opt;
    }

    AdvertisingIdentifier.Info getAdvertisingIdentifierInfo()
    {
        return advertisingIdentifierInfo;
    }

    public String getInstrumentationPixelURL()
    {
        return instrPixelUrl;
    }

    String getOrientation()
    {
        return orientation;
    }

    protected JSONArray getSlots()
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = slots.values().iterator(); iterator.hasNext(); jsonarray.put(((LOISlot)iterator.next()).getJSON())) { }
        return jsonarray;
    }

    public WebRequest getWebRequest()
    {
        WebRequest webrequest = WebRequest.createNewWebRequest();
        webrequest.setExternalLogTag(LOG_TAG);
        webrequest.setHttpMethod(WebRequest.HttpMethod.POST);
        webrequest.setHost(Configuration.getInstance().getString(Configuration.ConfigOption.AAX_HOSTNAME));
        webrequest.setPath("/e/msdk/ads");
        webrequest.enableLog(true);
        webrequest.setContentType("application/json");
        setParametersInWebRequest(webrequest);
        return webrequest;
    }

    public void putSlot(AdData addata, AdTargetingOptions adtargetingoptions)
    {
        addata.setConnectionType(connectionType);
        addata.setScreenHeight(screenSize.getHeight());
        addata.setScreenWidth(screenSize.getWidth());
        if (getAdvertisingIdentifierInfo().hasSISDeviceIdentifier())
        {
            addata.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_IDENTIFIED_DEVICE);
        }
        addata = new LOISlot(addata, adtargetingoptions, this);
        slots.put(Integer.valueOf(addata.getAdData().getSlotId()), addata);
    }

    AdRequest setAdvertisingIdentifierInfo(AdvertisingIdentifier.Info info)
    {
        advertisingIdentifierInfo = info;
        return this;
    }

    public void setInstrumentationPixelURL(String s)
    {
        instrPixelUrl = s;
    }

    protected void setParametersInWebRequest(WebRequest webrequest)
    {
        jsonObjectBuilder.build();
        Object obj1 = AAXParameter.SLOTS.getValue(jsonObjectBuilder.getParameterData());
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = getSlots();
        }
        jsonObjectBuilder.putIntoJSON(AAXParameter.SLOTS, obj);
        obj = jsonObjectBuilder.getJSON();
        obj1 = DebugProperties.getDebugPropertyAsString("debug.aaxAdParams", null);
        if (!Utils.isNullOrEmpty(((String) (obj1))))
        {
            webrequest.setAdditionalQueryParamsString(((String) (obj1)));
        }
        setRequestBodyString(webrequest, ((JSONObject) (obj)));
    }

    protected void setRequestBodyString(WebRequest webrequest, JSONObject jsonobject)
    {
        webrequest.setRequestBodyString(jsonobject.toString());
    }

    static 
    {
        PARAMETERS = (new AAXParameter[] {
            AAXParameter.APP_KEY, AAXParameter.CHANNEL, AAXParameter.PUBLISHER_KEYWORDS, AAXParameter.PUBLISHER_ASINS, AAXParameter.USER_AGENT, AAXParameter.SDK_VERSION, AAXParameter.GEOLOCATION, AAXParameter.USER_INFO, AAXParameter.DEVICE_INFO, AAXParameter.PACKAGE_INFO, 
            AAXParameter.TEST, AAXParameter.SIS_DEVICE_IDENTIFIER, AAXParameter.SHA1_UDID, AAXParameter.MD5_UDID, AAXParameter.ADVERTISING_IDENTIFIER, AAXParameter.OPT_OUT
        });
    }

}
