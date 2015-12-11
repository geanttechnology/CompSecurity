// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseEvent
{
    public static final class AppPlatform extends Enum
    {

        private static final AppPlatform $VALUES[];
        public static final AppPlatform ANDROID;
        public static final AppPlatform IOS;
        public static final AppPlatform MOBILE_WEB;
        public static final AppPlatform NONE;
        private final int mType;

        public static AppPlatform valueOf(String s)
        {
            return (AppPlatform)Enum.valueOf(com/mopub/common/event/BaseEvent$AppPlatform, s);
        }

        public static AppPlatform[] values()
        {
            return (AppPlatform[])$VALUES.clone();
        }

        public int getType()
        {
            return mType;
        }

        static 
        {
            NONE = new AppPlatform("NONE", 0, 0);
            IOS = new AppPlatform("IOS", 1, 1);
            ANDROID = new AppPlatform("ANDROID", 2, 2);
            MOBILE_WEB = new AppPlatform("MOBILE_WEB", 3, 3);
            $VALUES = (new AppPlatform[] {
                NONE, IOS, ANDROID, MOBILE_WEB
            });
        }

        private AppPlatform(String s, int i, int j)
        {
            super(s, i);
            mType = j;
        }
    }

    public static abstract class Builder
    {

        private String mAdCreativeId;
        private Double mAdHeightPx;
        private String mAdNetworkType;
        private String mAdType;
        private String mAdUnitId;
        private Double mAdWidthPx;
        private Category mCategory;
        private Double mGeoAccuracy;
        private Double mGeoLat;
        private Double mGeoLon;
        private Name mName;
        private Double mPerformanceDurationMs;
        private String mRequestId;
        private Integer mRequestRetries;
        private Integer mRequestStatusCode;
        private String mRequestUri;
        private double mSamplingRate;
        private ScribeCategory mScribeCategory;
        private SdkProduct mSdkProduct;

        public abstract BaseEvent build();

        public Builder withAdCreativeId(String s)
        {
            mAdCreativeId = s;
            return this;
        }

        public Builder withAdHeightPx(Double double1)
        {
            mAdHeightPx = double1;
            return this;
        }

        public Builder withAdNetworkType(String s)
        {
            mAdNetworkType = s;
            return this;
        }

        public Builder withAdType(String s)
        {
            mAdType = s;
            return this;
        }

        public Builder withAdUnitId(String s)
        {
            mAdUnitId = s;
            return this;
        }

        public Builder withAdWidthPx(Double double1)
        {
            mAdWidthPx = double1;
            return this;
        }

        public Builder withGeoAccuracy(Double double1)
        {
            mGeoAccuracy = double1;
            return this;
        }

        public Builder withGeoLat(Double double1)
        {
            mGeoLat = double1;
            return this;
        }

        public Builder withGeoLon(Double double1)
        {
            mGeoLon = double1;
            return this;
        }

        public Builder withPerformanceDurationMs(Double double1)
        {
            mPerformanceDurationMs = double1;
            return this;
        }

        public Builder withRequestId(String s)
        {
            mRequestId = s;
            return this;
        }

        public Builder withRequestRetries(Integer integer)
        {
            mRequestRetries = integer;
            return this;
        }

        public Builder withRequestStatusCode(Integer integer)
        {
            mRequestStatusCode = integer;
            return this;
        }

        public Builder withRequestUri(String s)
        {
            mRequestUri = s;
            return this;
        }

        public Builder withSdkProduct(SdkProduct sdkproduct)
        {
            mSdkProduct = sdkproduct;
            return this;
        }




















        public Builder(ScribeCategory scribecategory, Name name, Category category, double d)
        {
            Preconditions.checkNotNull(scribecategory);
            Preconditions.checkNotNull(name);
            Preconditions.checkNotNull(category);
            boolean flag;
            if (d >= 0.0D && d <= 1.0D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            mScribeCategory = scribecategory;
            mName = name;
            mCategory = category;
            mSamplingRate = d;
        }
    }

    public static final class Category extends Enum
    {

        private static final Category $VALUES[];
        public static final Category REQUESTS;
        private final String mCategory;

        public static Category valueOf(String s)
        {
            return (Category)Enum.valueOf(com/mopub/common/event/BaseEvent$Category, s);
        }

        public static Category[] values()
        {
            return (Category[])$VALUES.clone();
        }

        public String getCategory()
        {
            return mCategory;
        }

        static 
        {
            REQUESTS = new Category("REQUESTS", 0, "requests");
            $VALUES = (new Category[] {
                REQUESTS
            });
        }

        private Category(String s, int i, String s1)
        {
            super(s, i);
            mCategory = s1;
        }
    }

    public static final class Name extends Enum
    {

        private static final Name $VALUES[];
        public static final Name AD_REQUEST;
        public static final Name CLICK_REQUEST;
        public static final Name IMPRESSION_REQUEST;
        private final String mName;

        public static Name valueOf(String s)
        {
            return (Name)Enum.valueOf(com/mopub/common/event/BaseEvent$Name, s);
        }

        public static Name[] values()
        {
            return (Name[])$VALUES.clone();
        }

        public String getName()
        {
            return mName;
        }

        static 
        {
            AD_REQUEST = new Name("AD_REQUEST", 0, "ad_request");
            IMPRESSION_REQUEST = new Name("IMPRESSION_REQUEST", 1, "impression_request");
            CLICK_REQUEST = new Name("CLICK_REQUEST", 2, "click_request");
            $VALUES = (new Name[] {
                AD_REQUEST, IMPRESSION_REQUEST, CLICK_REQUEST
            });
        }

        private Name(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }

    public static final class SamplingRate extends Enum
    {

        private static final SamplingRate $VALUES[];
        public static final SamplingRate AD_REQUEST;
        private final double mSamplingRate;

        public static SamplingRate valueOf(String s)
        {
            return (SamplingRate)Enum.valueOf(com/mopub/common/event/BaseEvent$SamplingRate, s);
        }

        public static SamplingRate[] values()
        {
            return (SamplingRate[])$VALUES.clone();
        }

        public double getSamplingRate()
        {
            return mSamplingRate;
        }

        static 
        {
            AD_REQUEST = new SamplingRate("AD_REQUEST", 0, 0.10000000000000001D);
            $VALUES = (new SamplingRate[] {
                AD_REQUEST
            });
        }

        private SamplingRate(String s, int i, double d)
        {
            super(s, i);
            mSamplingRate = d;
        }
    }

    public static final class ScribeCategory extends Enum
    {

        private static final ScribeCategory $VALUES[];
        public static final ScribeCategory EXCHANGE_CLIENT_ERROR;
        public static final ScribeCategory EXCHANGE_CLIENT_EVENT;
        private final String mScribeCategory;

        public static ScribeCategory valueOf(String s)
        {
            return (ScribeCategory)Enum.valueOf(com/mopub/common/event/BaseEvent$ScribeCategory, s);
        }

        public static ScribeCategory[] values()
        {
            return (ScribeCategory[])$VALUES.clone();
        }

        public String getCategory()
        {
            return mScribeCategory;
        }

        static 
        {
            EXCHANGE_CLIENT_EVENT = new ScribeCategory("EXCHANGE_CLIENT_EVENT", 0, "exchange_client_event");
            EXCHANGE_CLIENT_ERROR = new ScribeCategory("EXCHANGE_CLIENT_ERROR", 1, "exchange_client_error");
            $VALUES = (new ScribeCategory[] {
                EXCHANGE_CLIENT_EVENT, EXCHANGE_CLIENT_ERROR
            });
        }

        private ScribeCategory(String s, int i, String s1)
        {
            super(s, i);
            mScribeCategory = s1;
        }
    }

    public static final class SdkProduct extends Enum
    {

        private static final SdkProduct $VALUES[];
        public static final SdkProduct NATIVE;
        public static final SdkProduct NONE;
        public static final SdkProduct WEB_VIEW;
        private final int mType;

        public static SdkProduct valueOf(String s)
        {
            return (SdkProduct)Enum.valueOf(com/mopub/common/event/BaseEvent$SdkProduct, s);
        }

        public static SdkProduct[] values()
        {
            return (SdkProduct[])$VALUES.clone();
        }

        public int getType()
        {
            return mType;
        }

        static 
        {
            NONE = new SdkProduct("NONE", 0, 0);
            WEB_VIEW = new SdkProduct("WEB_VIEW", 1, 1);
            NATIVE = new SdkProduct("NATIVE", 2, 2);
            $VALUES = (new SdkProduct[] {
                NONE, WEB_VIEW, NATIVE
            });
        }

        private SdkProduct(String s, int i, int j)
        {
            super(s, i);
            mType = j;
        }
    }


    private final String mAdCreativeId;
    private final Double mAdHeightPx;
    private final String mAdNetworkType;
    private final String mAdType;
    private final String mAdUnitId;
    private final Double mAdWidthPx;
    private final Category mCategory;
    private ClientMetadata mClientMetaData;
    private final Integer mDeviceScreenHeightDip;
    private final Integer mDeviceScreenWidthDip;
    private final Double mGeoAccuracy;
    private final Double mGeoLat;
    private final Double mGeoLon;
    private final String mIsoCountryCode;
    private final Name mName;
    private final String mNetworkOperator;
    private final String mNetworkOperatorName;
    private final com.mopub.common.ClientMetadata.MoPubNetworkType mNetworkType;
    private final Double mPerformanceDurationMs;
    private final String mRequestId;
    private final Integer mRequestRetries;
    private final Integer mRequestStatusCode;
    private final String mRequestUri;
    private final double mSamplingRate;
    private final ScribeCategory mScribeCategory;
    private final SdkProduct mSdkProduct;
    private final String mSimIsoCountryCode;
    private final String mSimOperator;
    private final String mSimOperatorName;
    private final long mTimestampUtcMs = System.currentTimeMillis();

    public BaseEvent(Builder builder)
    {
        Preconditions.checkNotNull(builder);
        mScribeCategory = builder.mScribeCategory;
        mName = builder.mName;
        mCategory = builder.mCategory;
        mSdkProduct = builder.mSdkProduct;
        mAdUnitId = builder.mAdUnitId;
        mAdCreativeId = builder.mAdCreativeId;
        mAdType = builder.mAdType;
        mAdNetworkType = builder.mAdNetworkType;
        mAdWidthPx = builder.mAdWidthPx;
        mAdHeightPx = builder.mAdHeightPx;
        mGeoLat = builder.mGeoLat;
        mGeoLon = builder.mGeoLon;
        mGeoAccuracy = builder.mGeoAccuracy;
        mPerformanceDurationMs = builder.mPerformanceDurationMs;
        mRequestId = builder.mRequestId;
        mRequestStatusCode = builder.mRequestStatusCode;
        mRequestUri = builder.mRequestUri;
        mRequestRetries = builder.mRequestRetries;
        mSamplingRate = builder.mSamplingRate;
        mClientMetaData = ClientMetadata.getInstance();
        if (mClientMetaData != null)
        {
            mDeviceScreenWidthDip = Integer.valueOf(mClientMetaData.getDeviceScreenWidthDip());
            mDeviceScreenHeightDip = Integer.valueOf(mClientMetaData.getDeviceScreenHeightDip());
            mNetworkType = mClientMetaData.getActiveNetworkType();
            mNetworkOperator = mClientMetaData.getNetworkOperator();
            mNetworkOperatorName = mClientMetaData.getNetworkOperatorName();
            mIsoCountryCode = mClientMetaData.getIsoCountryCode();
            mSimOperator = mClientMetaData.getSimOperator();
            mSimOperatorName = mClientMetaData.getSimOperatorName();
            mSimIsoCountryCode = mClientMetaData.getSimIsoCountryCode();
            return;
        } else
        {
            mDeviceScreenWidthDip = null;
            mDeviceScreenHeightDip = null;
            mNetworkType = null;
            mNetworkOperator = null;
            mNetworkOperatorName = null;
            mIsoCountryCode = null;
            mSimOperator = null;
            mSimOperatorName = null;
            mSimIsoCountryCode = null;
            return;
        }
    }

    public String getAdCreativeId()
    {
        return mAdCreativeId;
    }

    public Double getAdHeightPx()
    {
        return mAdHeightPx;
    }

    public String getAdNetworkType()
    {
        return mAdNetworkType;
    }

    public String getAdType()
    {
        return mAdType;
    }

    public String getAdUnitId()
    {
        return mAdUnitId;
    }

    public Double getAdWidthPx()
    {
        return mAdWidthPx;
    }

    public String getAppName()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getAppName();
        }
    }

    public String getAppPackageName()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getAppPackageName();
        }
    }

    public AppPlatform getAppPlatform()
    {
        return AppPlatform.ANDROID;
    }

    public String getAppVersion()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getAppVersion();
        }
    }

    public Category getCategory()
    {
        return mCategory;
    }

    public String getClientAdvertisingId()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getDeviceId();
        }
    }

    public Boolean getClientDoNotTrack()
    {
        boolean flag;
        if (mClientMetaData == null || mClientMetaData.isDoNotTrackSet())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public String getDeviceManufacturer()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getDeviceManufacturer();
        }
    }

    public String getDeviceModel()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getDeviceModel();
        }
    }

    public String getDeviceOsVersion()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getDeviceOsVersion();
        }
    }

    public String getDeviceProduct()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getDeviceProduct();
        }
    }

    public Integer getDeviceScreenHeightDip()
    {
        return mDeviceScreenHeightDip;
    }

    public Integer getDeviceScreenWidthDip()
    {
        return mDeviceScreenWidthDip;
    }

    public Double getGeoAccuracy()
    {
        return mGeoAccuracy;
    }

    public Double getGeoLat()
    {
        return mGeoLat;
    }

    public Double getGeoLon()
    {
        return mGeoLon;
    }

    public Name getName()
    {
        return mName;
    }

    public String getNetworkIsoCountryCode()
    {
        return mIsoCountryCode;
    }

    public String getNetworkOperatorCode()
    {
        return mNetworkOperator;
    }

    public String getNetworkOperatorName()
    {
        return mNetworkOperatorName;
    }

    public String getNetworkSimCode()
    {
        return mSimOperator;
    }

    public String getNetworkSimIsoCountryCode()
    {
        return mSimIsoCountryCode;
    }

    public String getNetworkSimOperatorName()
    {
        return mSimOperatorName;
    }

    public com.mopub.common.ClientMetadata.MoPubNetworkType getNetworkType()
    {
        return mNetworkType;
    }

    public String getObfuscatedClientAdvertisingId()
    {
        return "ifa:XXXX";
    }

    public Double getPerformanceDurationMs()
    {
        return mPerformanceDurationMs;
    }

    public String getRequestId()
    {
        return mRequestId;
    }

    public Integer getRequestRetries()
    {
        return mRequestRetries;
    }

    public Integer getRequestStatusCode()
    {
        return mRequestStatusCode;
    }

    public String getRequestUri()
    {
        return mRequestUri;
    }

    public double getSamplingRate()
    {
        return mSamplingRate;
    }

    public ScribeCategory getScribeCategory()
    {
        return mScribeCategory;
    }

    public SdkProduct getSdkProduct()
    {
        return mSdkProduct;
    }

    public String getSdkVersion()
    {
        if (mClientMetaData == null)
        {
            return null;
        } else
        {
            return mClientMetaData.getSdkVersion();
        }
    }

    public Long getTimestampUtcMs()
    {
        return Long.valueOf(mTimestampUtcMs);
    }

    public String toString()
    {
        return (new StringBuilder()).append("BaseEvent\nScribeCategory: ").append(getScribeCategory()).append("\n").append("Name: ").append(getName()).append("\n").append("Category: ").append(getCategory()).append("\n").append("SdkProduct: ").append(getSdkProduct()).append("\n").append("SdkVersion: ").append(getSdkVersion()).append("\n").append("AdUnitId: ").append(getAdUnitId()).append("\n").append("AdCreativeId: ").append(getAdCreativeId()).append("\n").append("AdType: ").append(getAdType()).append("\n").append("AdNetworkType: ").append(getAdNetworkType()).append("\n").append("AdWidthPx: ").append(getAdWidthPx()).append("\n").append("AdHeightPx: ").append(getAdHeightPx()).append("\n").append("AppPlatform: ").append(getAppPlatform()).append("\n").append("AppName: ").append(getAppName()).append("\n").append("AppPackageName: ").append(getAppPackageName()).append("\n").append("AppVersion: ").append(getAppVersion()).append("\n").append("DeviceManufacturer: ").append(getDeviceManufacturer()).append("\n").append("DeviceModel: ").append(getDeviceModel()).append("\n").append("DeviceProduct: ").append(getDeviceProduct()).append("\n").append("DeviceOsVersion: ").append(getDeviceOsVersion()).append("\n").append("DeviceScreenWidth: ").append(getDeviceScreenWidthDip()).append("\n").append("DeviceScreenHeight: ").append(getDeviceScreenHeightDip()).append("\n").append("GeoLat: ").append(getGeoLat()).append("\n").append("GeoLon: ").append(getGeoLon()).append("\n").append("GeoAccuracy: ").append(getGeoAccuracy()).append("\n").append("PerformanceDurationMs: ").append(getPerformanceDurationMs()).append("\n").append("NetworkType: ").append(getNetworkType()).append("\n").append("NetworkOperatorCode: ").append(getNetworkOperatorCode()).append("\n").append("NetworkOperatorName: ").append(getNetworkOperatorName()).append("\n").append("NetworkIsoCountryCode: ").append(getNetworkIsoCountryCode()).append("\n").append("NetworkSimCode: ").append(getNetworkSimCode()).append("\n").append("NetworkSimOperatorName: ").append(getNetworkSimOperatorName()).append("\n").append("NetworkSimIsoCountryCode: ").append(getNetworkSimIsoCountryCode()).append("\n").append("RequestId: ").append(getRequestId()).append("\n").append("RequestStatusCode: ").append(getRequestStatusCode()).append("\n").append("RequestUri: ").append(getRequestUri()).append("\n").append("RequestRetries: ").append(getRequestRetries()).append("\n").append("SamplingRate: ").append(getSamplingRate()).append("\n").append("TimestampUtcMs: ").append((new SimpleDateFormat()).format(new Date(getTimestampUtcMs().longValue()))).append("\n").toString();
    }
}
