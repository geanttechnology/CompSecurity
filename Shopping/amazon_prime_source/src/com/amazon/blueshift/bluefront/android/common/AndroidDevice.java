// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.common;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

// Referenced classes of package com.amazon.blueshift.bluefront.android.common:
//            DeviceUtils

public final class AndroidDevice
{
    public static class Builder
    {

        private String mAppVersion;
        private String mBrand;
        private String mCarrier;
        private int mConnectedNetworkType;
        private final Context mContext;
        private final String mDeviceId;
        private Location mLocation;
        private String mManufacturer;
        private String mModel;
        private String mSerialNumber;

        public final Builder appVersion(String s)
        {
            boolean flag;
            if (!Strings.isNullOrEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "App version cannot be null.");
            mAppVersion = s;
            return this;
        }

        public final Builder brand(String s)
        {
            boolean flag;
            if (!Strings.isNullOrEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Brand cannot be null or empty.");
            mBrand = s;
            return this;
        }

        public final AndroidDevice build()
        {
            return new AndroidDevice(this);
        }

        public final Builder carrier(String s)
        {
            boolean flag;
            if (!Strings.isNullOrEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Carrier cannot be null or empty.");
            mCarrier = s;
            return this;
        }

        public final Builder connectedNetworkType(int i)
        {
            boolean flag;
            if (i >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Network type cannot be negative.");
            mConnectedNetworkType = i;
            return this;
        }

        public final Builder location(Location location1)
        {
            Preconditions.checkNotNull(location1, "Location cannot be null.");
            mLocation = location1;
            return this;
        }

        public final Builder manufacturer(String s)
        {
            boolean flag;
            if (!Strings.isNullOrEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Manufactuer cannot be null or empty.");
            mManufacturer = s;
            return this;
        }

        public final Builder model(String s)
        {
            boolean flag;
            if (!Strings.isNullOrEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Model cannot be null or empty.");
            mModel = s;
            return this;
        }

        public final Builder serialNumber(String s)
        {
            boolean flag;
            if (!Strings.isNullOrEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Device serial number cannot be null or empty.");
            mSerialNumber = s;
            return this;
        }










        public Builder(Context context, String s)
        {
            mSerialNumber = Build.SERIAL;
            mBrand = Build.BRAND;
            mManufacturer = Build.MANUFACTURER;
            mModel = Build.MODEL;
            Preconditions.checkNotNull(context, "Context cannot be null.");
            boolean flag;
            if (!Strings.isNullOrEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Device id cannot be null.");
            mContext = context;
            mDeviceId = s;
            mLocation = DeviceUtils.getLocation(context);
            mAppVersion = DeviceUtils.getAppVersion(mContext);
            mCarrier = DeviceUtils.getCarrierName(mContext);
            mConnectedNetworkType = ((TelephonyManager)mContext.getSystemService("phone")).getNetworkType();
        }
    }


    private final String mAppVersion;
    private final String mBrand;
    private final String mCarrier;
    private final int mConnectedNetworkType;
    private final String mDeviceId;
    private final Location mLocation;
    private final String mManufacturer;
    private final String mModel;
    private final String mSerialNumber;

    private AndroidDevice(Builder builder)
    {
        mDeviceId = builder.mDeviceId;
        mConnectedNetworkType = builder.mConnectedNetworkType;
        mLocation = builder.mLocation;
        mAppVersion = builder.mAppVersion;
        mCarrier = builder.mCarrier;
        mSerialNumber = builder.mSerialNumber;
        mBrand = builder.mBrand;
        mManufacturer = builder.mManufacturer;
        mModel = builder.mModel;
    }


    public String getAppVersion()
    {
        return mAppVersion;
    }

    public String getBrand()
    {
        return mBrand;
    }

    public String getCarrier()
    {
        return mCarrier;
    }

    public int getConnectedNetworkType()
    {
        return mConnectedNetworkType;
    }

    public String getId()
    {
        return mDeviceId;
    }

    public Location getLocation()
    {
        return mLocation;
    }

    public String getManufacturer()
    {
        return mManufacturer;
    }

    public String getModel()
    {
        return mModel;
    }

    public String getSerialNumber()
    {
        return mSerialNumber;
    }
}
