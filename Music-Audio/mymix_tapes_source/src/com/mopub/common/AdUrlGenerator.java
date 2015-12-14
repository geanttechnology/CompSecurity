// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.util.DateAndTime;

// Referenced classes of package com.mopub.common:
//            BaseUrlGenerator, Preconditions, ClientMetadata, MoPub, 
//            LocationService

public abstract class AdUrlGenerator extends BaseUrlGenerator
{

    private static final String AD_UNIT_ID_KEY = "id";
    private static final String BUNDLE_ID_KEY = "bundle";
    private static final String CARRIER_NAME_KEY = "cn";
    private static final String CARRIER_TYPE_KEY = "ct";
    private static final String COUNTRY_CODE_KEY = "iso";
    private static final String IS_MRAID_KEY = "mr";
    private static final String KEYWORDS_KEY = "q";
    private static final String LAT_LONG_ACCURACY_KEY = "lla";
    private static final String LAT_LONG_FRESHNESS_KEY = "llf";
    private static final String LAT_LONG_FROM_SDK_KEY = "llsdk";
    private static final String LAT_LONG_KEY = "ll";
    private static final String MOBILE_COUNTRY_CODE_KEY = "mcc";
    private static final String MOBILE_NETWORK_CODE_KEY = "mnc";
    private static final String ORIENTATION_KEY = "o";
    private static final String SCREEN_SCALE_KEY = "sc_a";
    private static final String SDK_VERSION_KEY = "nv";
    private static final String TIMEZONE_OFFSET_KEY = "z";
    protected String mAdUnitId;
    protected Context mContext;
    protected String mKeywords;
    protected Location mLocation;

    public AdUrlGenerator(Context context)
    {
        mContext = context;
    }

    private void addParam(String s, ClientMetadata.MoPubNetworkType mopubnetworktype)
    {
        addParam(s, mopubnetworktype.toString());
    }

    private static int calculateLocationStalenessInMilliseconds(Location location)
    {
        Preconditions.checkNotNull(location);
        long l = location.getTime();
        return (int)(System.currentTimeMillis() - l);
    }

    private int mncPortionLength(String s)
    {
        return Math.min(3, s.length());
    }

    protected void addBaseParams(ClientMetadata clientmetadata)
    {
        setAdUnitId(mAdUnitId);
        setSdkVersion(clientmetadata.getSdkVersion());
        setDeviceInfo(new String[] {
            clientmetadata.getDeviceManufacturer(), clientmetadata.getDeviceModel(), clientmetadata.getDeviceProduct()
        });
        setBundleId(clientmetadata.getAppPackageName());
        setKeywords(mKeywords);
        setLocation(mLocation);
        setTimezone(DateAndTime.getTimeZoneOffsetString());
        setOrientation(clientmetadata.getOrientationString());
        setDeviceDimensions(clientmetadata.getDeviceDimensions());
        setDensity(clientmetadata.getDensity());
        String s = clientmetadata.getNetworkOperatorForUrl();
        setMccCode(s);
        setMncCode(s);
        setIsoCountryCode(clientmetadata.getIsoCountryCode());
        setCarrierName(clientmetadata.getNetworkOperatorName());
        setNetworkType(clientmetadata.getActiveNetworkType());
        setAppVersion(clientmetadata.getAppVersion());
        appendAdvertisingInfoTemplates();
    }

    protected void setAdUnitId(String s)
    {
        addParam("id", s);
    }

    protected void setBundleId(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            addParam("bundle", s);
        }
    }

    protected void setCarrierName(String s)
    {
        addParam("cn", s);
    }

    protected void setDensity(float f)
    {
        addParam("sc_a", (new StringBuilder()).append("").append(f).toString());
    }

    protected void setIsoCountryCode(String s)
    {
        addParam("iso", s);
    }

    protected void setKeywords(String s)
    {
        addParam("q", s);
    }

    protected void setLocation(Location location)
    {
        Location location2;
        Location location3;
label0:
        {
            Location location1 = location;
            location3 = LocationService.getLastKnownLocation(mContext, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
            location2 = location1;
            if (location3 == null)
            {
                break label0;
            }
            if (location != null)
            {
                location2 = location1;
                if (location3.getTime() < location.getTime())
                {
                    break label0;
                }
            }
            location2 = location3;
        }
        if (location2 != null)
        {
            addParam("ll", (new StringBuilder()).append(location2.getLatitude()).append(",").append(location2.getLongitude()).toString());
            addParam("lla", String.valueOf((int)location2.getAccuracy()));
            addParam("llf", String.valueOf(calculateLocationStalenessInMilliseconds(location2)));
            if (location2 == location3)
            {
                addParam("llsdk", "1");
            }
        }
    }

    protected void setMccCode(String s)
    {
        if (s == null)
        {
            s = "";
        } else
        {
            s = s.substring(0, mncPortionLength(s));
        }
        addParam("mcc", s);
    }

    protected void setMncCode(String s)
    {
        if (s == null)
        {
            s = "";
        } else
        {
            s = s.substring(mncPortionLength(s));
        }
        addParam("mnc", s);
    }

    protected void setMraidFlag(boolean flag)
    {
        if (flag)
        {
            addParam("mr", "1");
        }
    }

    protected void setNetworkType(ClientMetadata.MoPubNetworkType mopubnetworktype)
    {
        addParam("ct", mopubnetworktype);
    }

    protected void setOrientation(String s)
    {
        addParam("o", s);
    }

    protected void setSdkVersion(String s)
    {
        addParam("nv", s);
    }

    protected void setTimezone(String s)
    {
        addParam("z", s);
    }

    public AdUrlGenerator withAdUnitId(String s)
    {
        mAdUnitId = s;
        return this;
    }

    public AdUrlGenerator withFacebookSupported(boolean flag)
    {
        return this;
    }

    public AdUrlGenerator withKeywords(String s)
    {
        mKeywords = s;
        return this;
    }

    public AdUrlGenerator withLocation(Location location)
    {
        mLocation = location;
        return this;
    }
}
