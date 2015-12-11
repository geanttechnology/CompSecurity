// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.sitespeed.SiteSpeedRequest;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.DefaultHelper;

public class SiteSpeedDataManager extends DataManager
{
    public static class DeviceMeta
    {

        public final String appVersion;
        public final String deviceModel;
        public final String memorySize;
        public final String osType;
        public final String osVersion;
        public final String trackingId;

        public String toString()
        {
            return (new StringBuilder()).append("DeviceMeta [trackingId=").append(trackingId).append(", deviceModel=").append(deviceModel).append(", osType=").append(osType).append(", osVersion=").append(osVersion).append(", appVersion=").append(appVersion).append(", memorySize=").append(memorySize).append("]").toString();
        }

        public DeviceMeta(String s, String s1, String s2, String s3, String s4, String s5)
        {
            trackingId = s;
            deviceModel = s1;
            osType = s2;
            osVersion = s3;
            appVersion = s4;
            memorySize = s5;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return SiteSpeedDataManager.KEY;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public SiteSpeedDataManager createManager(EbayContext ebaycontext)
        {
            return new SiteSpeedDataManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return obj == this || (obj instanceof KeyParams);
        }


        public KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onUploadCompleted(SiteSpeedDataManager sitespeeddatamanager, Content content);
    }

    public static class SiteSpeedMeta
    {

        public final String carrier;
        public String deviceId;
        public final String mobileNetworkType;
        public final String networkType;
        public final boolean portrait;
        public final String preferredLanguage;
        public final int rolloutThreshold;
        public final String screenRes;

        public void setDeviceId(String s)
        {
            deviceId = s;
        }

        public String toString()
        {
            return (new StringBuilder()).append("SiteSpeedMeta [carrier=").append(carrier).append(", networkType=").append(networkType).append(", mobileNetworkType=").append(mobileNetworkType).append(", preferredLanguage=").append(preferredLanguage).append(", deviceId=").append(deviceId).append(", rolloutThreshold=").append(rolloutThreshold).append(", screenRes=").append(screenRes).append("]").toString();
        }

        public SiteSpeedMeta(String s, String s1, String s2, String s3, int i, String s4, boolean flag)
        {
            carrier = s;
            networkType = s1;
            mobileNetworkType = s2;
            preferredLanguage = s3;
            rolloutThreshold = i;
            screenRes = s4;
            portrait = flag;
        }
    }

    private final class UploadTask extends AsyncTask
    {

        private final SiteSpeedData data;
        private final SiteSpeedMeta meta;
        private final Observer observer;
        final SiteSpeedDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            meta.setDeviceId(EbayIdentity.getDeviceIdString(getContext()));
            avoid = new ResultStatusOwner();
            safeSendRequest(new SiteSpeedRequest(data, deviceMeta, meta), avoid);
            avoid = avoid.getResultStatus();
            if (SiteSpeedDataManager.logger.isLoggable)
            {
                SiteSpeedDataManager.logger.log((new StringBuilder()).append("Sent site speed data with result: ").append(avoid.toString()).toString());
                SiteSpeedDataManager.logger.log(data.toString());
                SiteSpeedDataManager.logger.log(deviceMeta.toString());
                SiteSpeedDataManager.logger.log(meta.toString());
            }
            if (avoid == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(data, avoid);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            while (content == null || observer == null) 
            {
                return;
            }
            observer.onUploadCompleted(SiteSpeedDataManager.this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public UploadTask(Observer observer1, SiteSpeedMeta sitespeedmeta, SiteSpeedData sitespeeddata)
        {
            this$0 = SiteSpeedDataManager.this;
            super();
            observer = observer1;
            meta = sitespeedmeta;
            data = sitespeeddata;
        }
    }


    public static final KeyParams KEY = new KeyParams();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("siteSpeed", 3, "Site Speed performance");
    private final DeviceMeta deviceMeta;

    SiteSpeedDataManager(EbayContext ebaycontext)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/SiteSpeedDataManager$Observer);
        ebaycontext = EbayAppCredentials.get(getEbayContext());
        String s = DefaultHelper.forString(DeviceInfoUtil.getMemorySize(getContext(), true), "Unknown");
        deviceMeta = new DeviceMeta(((EbayAppCredentials) (ebaycontext)).trackingAppId, DeviceInfoUtil.getDeviceModel(), DeviceInfoUtil.getOsType(), android.os.Build.VERSION.RELEASE, getEbayContext().getAppInfo().getAppVersionWithoutBuildNumber(), s);
    }

    private boolean isSiteSpeedEnabled()
    {
        if (Log.isLoggable("SiteSpeed", 3))
        {
            return true;
        } else
        {
            return DeviceConfiguration.getAsync().get(DcsNautilusBoolean.SiteSpeedSendData);
        }
    }

    public KeyParams getParams()
    {
        return KEY;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void upload(Observer observer, SiteSpeedData sitespeeddata)
    {
        if (!sitespeeddata.isReportable() || !isSiteSpeedEnabled())
        {
            if (observer != null)
            {
                observer.onUploadCompleted(this, new Content(sitespeeddata));
            }
            return;
        } else
        {
            sitespeeddata.markReported();
            Object obj = DeviceConfiguration.getNoSync();
            obj = new SiteSpeedMeta(DeviceInfoUtil.getCarrier(getContext()), DeviceInfoUtil.getNetworkType(getContext()), DeviceInfoUtil.getMobileNetworkType(getContext()), DeviceInfoUtil.getPreferredLanguage(), ((DeviceConfiguration) (obj)).getState().rolloutThreshold, DeviceInfoUtil.getScreenResolution(getContext()), DeviceInfoUtil.isPortrait(getContext()));
            executeOnThreadPool(new UploadTask((Observer)getSafeCallback(observer), ((SiteSpeedMeta) (obj)), sitespeeddata), new Void[0]);
            return;
        }
    }



}
