// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.location.Location;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            Utils, DebugProperties, AdRequest, InternalAdRegistration, 
//            IInternalAdRegistration, RegistrationInfo, DeviceInfo, Log, 
//            AdTargetingOptions, Configuration, AdLocation, AdData, 
//            AppInfo, Version, AdSize, Settings, 
//            JSONUtils

abstract class AAXParameter
{
    static class AdvertisingIdentifierParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            if (parameterdata.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier())
            {
                return parameterdata.adRequest.getAdvertisingIdentifierInfo().getAdvertisingIdentifier();
            } else
            {
                return null;
            }
        }

        AdvertisingIdentifierParameter()
        {
            super("idfa", "debug.idfa");
        }
    }

    static class AppKeyParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            return InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
        }

        AppKeyParameter()
        {
            super("appId", "debug.appid");
        }
    }

    static class BooleanParameter extends AAXParameter
    {

        protected Boolean getFromDebugProperties()
        {
            return DebugProperties.getDebugPropertyAsBoolean(getDebugName(), null);
        }

        protected volatile Object getFromDebugProperties()
        {
            return getFromDebugProperties();
        }

        protected Boolean parseFromString(String s)
        {
            return Boolean.valueOf(Boolean.parseBoolean(s));
        }

        protected volatile Object parseFromString(String s)
        {
            return parseFromString(s);
        }

        BooleanParameter(String s, String s1)
        {
            super(s, s1);
        }
    }

    static class DeviceInfoParameter extends JSONObjectParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected JSONObject getDerivedValue(ParameterData parameterdata)
        {
            return InternalAdRegistration.getInstance().getDeviceInfo().toJsonObject(parameterdata.adRequest.getOrientation());
        }

        DeviceInfoParameter()
        {
            super("dinfo", "debug.dinfo");
        }
    }

    static class FloorPriceParameter extends LongParameter
    {

        protected Long getDerivedValue(ParameterData parameterdata)
        {
            if (parameterdata.loiSlot.getAdTargetingOptions().hasFloorPrice())
            {
                return Long.valueOf(parameterdata.loiSlot.getAdTargetingOptions().getFloorPrice());
            } else
            {
                return null;
            }
        }

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        FloorPriceParameter()
        {
            super("ec", "debug.ec");
        }
    }

    static class GeoLocationParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
label0:
            {
                if (Configuration.getInstance().getBoolean(Configuration.ConfigOption.SEND_GEO) && parameterdata.adRequest.getAdTargetingOptions().isGeoLocationEnabled())
                {
                    parameterdata = (new AdLocation()).getLocation();
                    if (parameterdata != null)
                    {
                        break label0;
                    }
                }
                return null;
            }
            return (new StringBuilder()).append(parameterdata.getLatitude()).append(",").append(parameterdata.getLongitude()).toString();
        }

        GeoLocationParameter()
        {
            super("geoloc", "debug.geoloc");
        }
    }

    static class IntegerParameter extends AAXParameter
    {

        protected Integer getFromDebugProperties()
        {
            return DebugProperties.getDebugPropertyAsInteger(getDebugName(), null);
        }

        protected volatile Object getFromDebugProperties()
        {
            return getFromDebugProperties();
        }

        protected Integer parseFromString(String s)
        {
            return Integer.valueOf(Integer.parseInt(s));
        }

        protected volatile Object parseFromString(String s)
        {
            return parseFromString(s);
        }

        IntegerParameter(String s, String s1)
        {
            super(s, s1);
        }
    }

    static class JSONArrayParameter extends AAXParameter
    {

        protected volatile Object getFromDebugProperties()
        {
            return getFromDebugProperties();
        }

        protected JSONArray getFromDebugProperties()
        {
            return parseFromString(DebugProperties.getDebugPropertyAsString(getDebugName(), null));
        }

        protected volatile Object parseFromString(String s)
        {
            return parseFromString(s);
        }

        protected JSONArray parseFromString(String s)
        {
            try
            {
                s = new JSONArray(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e(AAXParameter.LOG_TAG, "Unable to parse the following value into a JSONArray: %s", new Object[] {
                    getName()
                });
                return null;
            }
            return s;
        }

        JSONArrayParameter(String s, String s1)
        {
            super(s, s1);
        }
    }

    static class JSONObjectParameter extends AAXParameter
    {

        protected volatile Object getFromDebugProperties()
        {
            return getFromDebugProperties();
        }

        protected JSONObject getFromDebugProperties()
        {
            return parseFromString(DebugProperties.getDebugPropertyAsString(getDebugName(), null));
        }

        protected volatile Object parseFromString(String s)
        {
            return parseFromString(s);
        }

        protected JSONObject parseFromString(String s)
        {
            try
            {
                s = new JSONObject(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e(AAXParameter.LOG_TAG, "Unable to parse the following value into a JSONObject: %s", new Object[] {
                    getName()
                });
                return null;
            }
            return s;
        }

        JSONObjectParameter(String s, String s1)
        {
            super(s, s1);
        }
    }

    static class LongParameter extends AAXParameter
    {

        protected Long getFromDebugProperties()
        {
            return DebugProperties.getDebugPropertyAsLong(getDebugName(), null);
        }

        protected volatile Object getFromDebugProperties()
        {
            return getFromDebugProperties();
        }

        protected Long parseFromString(String s)
        {
            return Long.valueOf(Long.parseLong(s));
        }

        protected volatile Object parseFromString(String s)
        {
            return parseFromString(s);
        }

        LongParameter(String s, String s1)
        {
            super(s, s1);
        }
    }

    static class MD5UDIDParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            if (!parameterdata.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier())
            {
                return InternalAdRegistration.getInstance().getDeviceInfo().getUdidMd5();
            } else
            {
                return null;
            }
        }

        MD5UDIDParameter()
        {
            super("md5_udid", "debug.md5udid");
        }
    }

    static class MaxSizeParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            return parameterdata.loiSlot.getAdData().getMaxSize();
        }

        MaxSizeParameter()
        {
            super("mxsz", "debug.mxsz");
        }
    }

    static class OptOutParameter extends BooleanParameter
    {

        protected Boolean getDerivedValue(ParameterData parameterdata)
        {
            if (parameterdata.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier())
            {
                return Boolean.valueOf(parameterdata.adRequest.getAdvertisingIdentifierInfo().isLimitAdTrackingEnabled());
            } else
            {
                return null;
            }
        }

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        OptOutParameter()
        {
            super("oo", "debug.optOut");
        }
    }

    static class PackageInfoParameter extends JSONObjectParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected JSONObject getDerivedValue(ParameterData parameterdata)
        {
            return InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSON();
        }

        PackageInfoParameter()
        {
            super("pkg", "debug.pkg");
        }
    }

    static class ParameterData
    {

        private AdRequest adRequest;
        private Map advancedOptions;
        private AdRequest.LOISlot loiSlot;

        ParameterData setAdRequest(AdRequest adrequest)
        {
            adRequest = adrequest;
            return this;
        }

        ParameterData setAdvancedOptions(Map map)
        {
            advancedOptions = map;
            return this;
        }

        ParameterData setLOISlot(AdRequest.LOISlot loislot)
        {
            loiSlot = loislot;
            return this;
        }




        ParameterData()
        {
        }
    }

    static class SDKVersionParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            return Version.getSDKVersion();
        }

        SDKVersionParameter()
        {
            super("adsdk", "debug.ver");
        }
    }

    static class SHA1UDIDParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            if (!parameterdata.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier())
            {
                return InternalAdRegistration.getInstance().getDeviceInfo().getUdidSha1();
            } else
            {
                return null;
            }
        }

        SHA1UDIDParameter()
        {
            super("sha1_udid", "debug.sha1udid");
        }
    }

    static class SISDeviceIdentifierParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            return parameterdata.adRequest.getAdvertisingIdentifierInfo().getSISDeviceIdentifier();
        }

        SISDeviceIdentifierParameter()
        {
            super("ad-id", "debug.adid");
        }
    }

    static class SizeParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            return parameterdata.loiSlot.getAdData().getRequestedAdSize().toString();
        }

        SizeParameter()
        {
            super("sz", "debug.size");
        }
    }

    static class SlotIdParameter extends IntegerParameter
    {

        protected Integer getDerivedValue(ParameterData parameterdata)
        {
            return Integer.valueOf(parameterdata.loiSlot.getAdData().getSlotId());
        }

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        SlotIdParameter()
        {
            super("slotId", "debug.slotId");
        }
    }

    static class SlotParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            return parameterdata.adRequest.getOrientation();
        }

        SlotParameter()
        {
            super("slot", "debug.slot");
        }
    }

    static class StringParameter extends AAXParameter
    {

        protected volatile Object getFromDebugProperties()
        {
            return getFromDebugProperties();
        }

        protected String getFromDebugProperties()
        {
            return DebugProperties.getDebugPropertyAsString(getDebugName(), null);
        }

        protected volatile Object parseFromString(String s)
        {
            return parseFromString(s);
        }

        protected String parseFromString(String s)
        {
            return s;
        }

        StringParameter(String s, String s1)
        {
            super(s, s1);
        }
    }

    static class TestParameter extends BooleanParameter
    {

        protected Boolean getDerivedValue(ParameterData parameterdata)
        {
            return Settings.getInstance().getBoolean("testingEnabled", null);
        }

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        TestParameter()
        {
            super("isTest", "debug.test");
        }
    }

    static class UserAgentParameter extends StringParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected String getDerivedValue(ParameterData parameterdata)
        {
            return DeviceInfo.getUserAgentString();
        }

        UserAgentParameter()
        {
            super("ua", "debug.ua");
        }
    }

    static class UserInfoParameter extends JSONObjectParameter
    {

        protected volatile Object getDerivedValue(ParameterData parameterdata)
        {
            return getDerivedValue(parameterdata);
        }

        protected JSONObject getDerivedValue(ParameterData parameterdata)
        {
            if (parameterdata.adRequest.getAdTargetingOptions().hasAge())
            {
                int i = parameterdata.adRequest.getAdTargetingOptions().getAge();
                parameterdata = new JSONObject();
                JSONUtils.put(parameterdata, "age", String.valueOf(i));
                return parameterdata;
            } else
            {
                return null;
            }
        }

        UserInfoParameter()
        {
            super("uinfo", "debug.ui");
        }
    }


    static final AAXParameter ADVERTISING_IDENTIFIER = new AdvertisingIdentifierParameter();
    static final AAXParameter APP_KEY = new AppKeyParameter();
    static final AAXParameter CHANNEL = new StringParameter("c", "debug.channel");
    static final AAXParameter DEVICE_INFO = new DeviceInfoParameter();
    static final AAXParameter FLOOR_PRICE = new FloorPriceParameter();
    static final AAXParameter GEOLOCATION = new GeoLocationParameter();
    private static final String LOG_TAG = com/amazon/device/ads/AAXParameter.getSimpleName();
    static final AAXParameter MAX_SIZE = new MaxSizeParameter();
    static final AAXParameter MD5_UDID = new MD5UDIDParameter();
    static final AAXParameter OPT_OUT = new OptOutParameter();
    static final AAXParameter PACKAGE_INFO = new PackageInfoParameter();
    static final AAXParameter PAGE_TYPE = new StringParameter("pt", "debug.pt");
    static final AAXParameter PUBLISHER_ASINS = new JSONArrayParameter("pa", "debug.pa");
    static final AAXParameter PUBLISHER_KEYWORDS = new JSONArrayParameter("pk", "debug.pk");
    static final AAXParameter SDK_VERSION = new SDKVersionParameter();
    static final AAXParameter SHA1_UDID = new SHA1UDIDParameter();
    static final AAXParameter SIS_DEVICE_IDENTIFIER = new SISDeviceIdentifierParameter();
    static final AAXParameter SIZE = new SizeParameter();
    static final AAXParameter SLOT = new SlotParameter();
    static final AAXParameter SLOTS = new JSONArrayParameter("slots", "debug.slots");
    static final AAXParameter SLOT_ID = new SlotIdParameter();
    static final AAXParameter SLOT_POSITION = new StringParameter("sp", "debug.sp");
    static final AAXParameter TEST = new TestParameter();
    static final AAXParameter USER_AGENT = new UserAgentParameter();
    static final AAXParameter USER_INFO = new UserInfoParameter();
    private final String debugName;
    private final String name;

    AAXParameter(String s, String s1)
    {
        name = s;
        debugName = s1;
    }

    protected String getDebugName()
    {
        return debugName;
    }

    protected Object getDerivedValue(ParameterData parameterdata)
    {
        return null;
    }

    protected abstract Object getFromDebugProperties();

    String getName()
    {
        return name;
    }

    Object getValue(ParameterData parameterdata)
    {
        ParameterData parameterdata1;
        if (hasDebugPropertiesValue())
        {
            parameterdata = ((ParameterData) (getFromDebugProperties()));
        } else
        if (parameterdata.advancedOptions.containsKey(name))
        {
            parameterdata = ((ParameterData) (parseFromString((String)parameterdata.advancedOptions.remove(name))));
        } else
        {
            parameterdata = ((ParameterData) (getDerivedValue(parameterdata)));
        }
        parameterdata1 = parameterdata;
        if (parameterdata instanceof String)
        {
            parameterdata1 = parameterdata;
            if (Utils.isNullOrWhiteSpace((String)parameterdata))
            {
                parameterdata1 = null;
            }
        }
        return parameterdata1;
    }

    protected boolean hasDebugPropertiesValue()
    {
        return DebugProperties.containsDebugProperty(debugName);
    }

    protected abstract Object parseFromString(String s);


}
