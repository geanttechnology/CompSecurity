// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.common.util.DateAndTime;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdResponse
    implements Serializable
{
    public static class Builder
    {

        private Integer adTimeoutDelayMillis;
        private String adType;
        private String adUnitId;
        private String clickTrackingUrl;
        private String customEventClassName;
        private String dspCreativeId;
        private String failoverUrl;
        private String fullAdType;
        private Integer height;
        private String impressionTrackingUrl;
        private JSONObject jsonBody;
        private String networkType;
        private String redirectUrl;
        private Integer refreshTimeMillis;
        private String requestId;
        private String responseBody;
        private boolean scrollable;
        private Map serverExtras;
        private Integer width;

        public AdResponse build()
        {
            return new AdResponse(this);
        }

        public Builder setAdTimeoutDelayMilliseconds(Integer integer)
        {
            adTimeoutDelayMillis = integer;
            return this;
        }

        public Builder setAdType(String s)
        {
            adType = s;
            return this;
        }

        public Builder setAdUnitId(String s)
        {
            adUnitId = s;
            return this;
        }

        public Builder setClickTrackingUrl(String s)
        {
            clickTrackingUrl = s;
            return this;
        }

        public Builder setCustomEventClassName(String s)
        {
            customEventClassName = s;
            return this;
        }

        public Builder setDimensions(Integer integer, Integer integer1)
        {
            width = integer;
            height = integer1;
            return this;
        }

        public Builder setDspCreativeId(String s)
        {
            dspCreativeId = s;
            return this;
        }

        public Builder setFailoverUrl(String s)
        {
            failoverUrl = s;
            return this;
        }

        public Builder setFullAdType(String s)
        {
            fullAdType = s;
            return this;
        }

        public Builder setImpressionTrackingUrl(String s)
        {
            impressionTrackingUrl = s;
            return this;
        }

        public Builder setJsonBody(JSONObject jsonobject)
        {
            jsonBody = jsonobject;
            return this;
        }

        public Builder setNetworkType(String s)
        {
            networkType = s;
            return this;
        }

        public Builder setRedirectUrl(String s)
        {
            redirectUrl = s;
            return this;
        }

        public Builder setRefreshTimeMilliseconds(Integer integer)
        {
            refreshTimeMillis = integer;
            return this;
        }

        public Builder setRequestId(String s)
        {
            requestId = s;
            return this;
        }

        public Builder setResponseBody(String s)
        {
            responseBody = s;
            return this;
        }

        public Builder setScrollable(Boolean boolean1)
        {
            boolean flag;
            if (boolean1 == null)
            {
                flag = scrollable;
            } else
            {
                flag = boolean1.booleanValue();
            }
            scrollable = flag;
            return this;
        }

        public Builder setServerExtras(Map map)
        {
            if (map == null)
            {
                serverExtras = new TreeMap();
                return this;
            } else
            {
                serverExtras = new TreeMap(map);
                return this;
            }
        }




















        public Builder()
        {
            scrollable = false;
            serverExtras = new TreeMap();
        }
    }


    private static final long serialVersionUID = 1L;
    private final Integer mAdTimeoutDelayMillis;
    private final String mAdType;
    private final String mAdUnitId;
    private final String mClickTrackingUrl;
    private final String mCustomEventClassName;
    private final String mDspCreativeId;
    private final String mFailoverUrl;
    private final String mFullAdType;
    private final Integer mHeight;
    private final String mImpressionTrackingUrl;
    private final JSONObject mJsonBody;
    private final String mNetworkType;
    private final String mRedirectUrl;
    private final Integer mRefreshTimeMillis;
    private final String mRequestId;
    private final String mResponseBody;
    private final boolean mScrollable;
    private final Map mServerExtras;
    private final long mTimestamp;
    private final Integer mWidth;

    private AdResponse(Builder builder)
    {
        mAdType = builder.adType;
        mAdUnitId = builder.adUnitId;
        mFullAdType = builder.fullAdType;
        mNetworkType = builder.networkType;
        mRedirectUrl = builder.redirectUrl;
        mClickTrackingUrl = builder.clickTrackingUrl;
        mImpressionTrackingUrl = builder.impressionTrackingUrl;
        mFailoverUrl = builder.failoverUrl;
        mRequestId = builder.requestId;
        mWidth = builder.width;
        mHeight = builder.height;
        mAdTimeoutDelayMillis = builder.adTimeoutDelayMillis;
        mRefreshTimeMillis = builder.refreshTimeMillis;
        mDspCreativeId = builder.dspCreativeId;
        mScrollable = builder.scrollable;
        mResponseBody = builder.responseBody;
        mJsonBody = builder.jsonBody;
        mCustomEventClassName = builder.customEventClassName;
        mServerExtras = builder.serverExtras;
        mTimestamp = DateAndTime.now().getTime();
    }


    public Integer getAdTimeoutMillis()
    {
        return mAdTimeoutDelayMillis;
    }

    public String getAdType()
    {
        return mAdType;
    }

    public String getAdUnitId()
    {
        return mAdUnitId;
    }

    public String getClickTrackingUrl()
    {
        return mClickTrackingUrl;
    }

    public String getCustomEventClassName()
    {
        return mCustomEventClassName;
    }

    public String getDspCreativeId()
    {
        return mDspCreativeId;
    }

    public String getFailoverUrl()
    {
        return mFailoverUrl;
    }

    public String getFullAdType()
    {
        return mFullAdType;
    }

    public Integer getHeight()
    {
        return mHeight;
    }

    public String getImpressionTrackingUrl()
    {
        return mImpressionTrackingUrl;
    }

    public JSONObject getJsonBody()
    {
        return mJsonBody;
    }

    public String getNetworkType()
    {
        return mNetworkType;
    }

    public String getRedirectUrl()
    {
        return mRedirectUrl;
    }

    public Integer getRefreshTimeMillis()
    {
        return mRefreshTimeMillis;
    }

    public String getRequestId()
    {
        return mRequestId;
    }

    public Map getServerExtras()
    {
        return new TreeMap(mServerExtras);
    }

    public String getStringBody()
    {
        return mResponseBody;
    }

    public long getTimestamp()
    {
        return mTimestamp;
    }

    public Integer getWidth()
    {
        return mWidth;
    }

    public boolean hasJson()
    {
        return mJsonBody != null;
    }

    public boolean isScrollable()
    {
        return mScrollable;
    }

    public Builder toBuilder()
    {
        return (new Builder()).setAdType(mAdType).setNetworkType(mNetworkType).setRedirectUrl(mRedirectUrl).setClickTrackingUrl(mClickTrackingUrl).setImpressionTrackingUrl(mImpressionTrackingUrl).setFailoverUrl(mFailoverUrl).setDimensions(mWidth, mHeight).setAdTimeoutDelayMilliseconds(mAdTimeoutDelayMillis).setRefreshTimeMilliseconds(mRefreshTimeMillis).setDspCreativeId(mDspCreativeId).setScrollable(Boolean.valueOf(mScrollable)).setResponseBody(mResponseBody).setJsonBody(mJsonBody).setCustomEventClassName(mCustomEventClassName).setServerExtras(mServerExtras);
    }
}
