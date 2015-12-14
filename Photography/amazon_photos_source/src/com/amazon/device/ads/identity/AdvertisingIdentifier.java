// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            Settings, StringUtils, GooglePlayServices, ThreadUtils, 
//            Log, AmazonRegistration, IAmazonRegistration, RegistrationInfo, 
//            DebugProperties

class AdvertisingIdentifier
{
    static class Info
    {

        private String advertisingIdentifier;
        private boolean canDo;
        private boolean limitAdTrackingEnabled;
        private String sisDeviceIdentifier;

        boolean canDo()
        {
            return canDo;
        }

        String getAdvertisingIdentifier()
        {
            return DebugProperties.getInstance().getDebugPropertyAsString("debug.idfa", advertisingIdentifier);
        }

        String getSISDeviceIdentifier()
        {
            return DebugProperties.getInstance().getDebugPropertyAsString("debug.adid", sisDeviceIdentifier);
        }

        boolean hasAdvertisingIdentifier()
        {
            return !StringUtils.isNullOrEmpty(getAdvertisingIdentifier());
        }

        boolean isLimitAdTrackingEnabled()
        {
            return DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.optOut", limitAdTrackingEnabled);
        }


/*
        static Info access$000$12f690c7(Info info)
        {
            info.canDo = false;
            return info;
        }

*/


/*
        static Info access$100(Info info, String s)
        {
            info.advertisingIdentifier = s;
            return info;
        }

*/


/*
        static Info access$200(Info info, boolean flag)
        {
            info.limitAdTrackingEnabled = flag;
            return info;
        }

*/


/*
        static Info access$300(Info info, String s)
        {
            info.sisDeviceIdentifier = s;
            return info;
        }

*/

        Info()
        {
            canDo = true;
        }
    }


    private static final String LOG_TAG = com/amazon/device/ads/identity/AdvertisingIdentifier.getSimpleName();
    private GooglePlayServices.AdvertisingInfo gpsAdvertisingInfo;
    private boolean shouldSetCurrentAdvertisingIdentifier;

    AdvertisingIdentifier()
    {
        shouldSetCurrentAdvertisingIdentifier = true;
    }

    private static String getCurrentGPSAID()
    {
        return Settings.getInstance().getString("gpsAdId", "");
    }

    private boolean hasCurrentGPSAID()
    {
        return !StringUtils.isNullOrEmpty(getCurrentGPSAID());
    }

    protected void fetchGooglePlayServicesAdvertisingIdentifierInfo()
    {
        gpsAdvertisingInfo = (new GooglePlayServices()).getAdvertisingIdentifierInfo();
    }

    Info getAdvertisingIdentifierInfo()
    {
        boolean flag3 = false;
        if (ThreadUtils.isOnMainThread())
        {
            Log.e(LOG_TAG, "You must obtain the advertising indentifier information on a background thread.", new Object[0]);
            return (new Info()).canDo;
        }
        fetchGooglePlayServicesAdvertisingIdentifierInfo();
        if (shouldSetCurrentAdvertisingIdentifier)
        {
            Object obj;
            Object obj1;
            boolean flag;
            boolean flag4;
            if (AmazonRegistration.getInstance().getRegistrationInfo().hasAdId() && RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier() && !hasCurrentGPSAID() && getGPSAdvertisingInfo().hasAdvertisingIdentifier())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = "migrate";
            } else
            {
                boolean flag1;
                if (hasCurrentGPSAID() && getGPSAdvertisingInfo().hasAdvertisingIdentifier() && !getCurrentGPSAID().equals(getGPSAdvertisingInfo().getAdvertisingIdentifier()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    obj = "reset";
                } else
                {
                    boolean flag2;
                    if (hasCurrentGPSAID() && !getGPSAdvertisingInfo().hasAdvertisingIdentifier())
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    String s;
                    if (flag2)
                    {
                        obj = "revert";
                    } else
                    {
                        obj = null;
                    }
                }
            }
            if (obj != null)
            {
                Log.d(LOG_TAG, "Transition: %s", new Object[] {
                    obj
                });
                Settings.getInstance().putString("adIdTransistion", ((String) (obj)));
            } else
            {
                Log.d(LOG_TAG, "No transition detected.", new Object[0]);
            }
        }
        obj = new Info();
        if (getGPSAdvertisingInfo().hasAdvertisingIdentifier())
        {
            obj.advertisingIdentifier = getGPSAdvertisingInfo().getAdvertisingIdentifier();
            obj.limitAdTrackingEnabled = getGPSAdvertisingInfo().isLimitAdTrackingEnabled();
            if (shouldSetCurrentAdvertisingIdentifier)
            {
                obj1 = getGPSAdvertisingInfo().getAdvertisingIdentifier();
                Settings.getInstance().putString("gpsAdId", ((String) (obj1)));
            }
        }
        obj1 = AmazonRegistration.getInstance().getRegistrationInfo();
        flag4 = RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier();
        if (((Info) (obj)).hasAdvertisingIdentifier())
        {
            if (!flag4)
            {
                s = Settings.getInstance().getString("amzn-ad-id-origin", null);
                flag3 = ((Info) (obj)).getAdvertisingIdentifier().equals(s);
            }
        } else
        {
            flag3 = flag4;
        }
        if (flag3)
        {
            obj.sisDeviceIdentifier = ((RegistrationInfo) (obj1)).getAdId();
            return ((Info) (obj));
        } else
        {
            ((RegistrationInfo) (obj1)).requestNewSISDeviceIdentifier();
            return ((Info) (obj));
        }
    }

    protected GooglePlayServices.AdvertisingInfo getGPSAdvertisingInfo()
    {
        return gpsAdvertisingInfo;
    }

    AdvertisingIdentifier setShouldSetCurrentAdvertisingIdentifier(boolean flag)
    {
        shouldSetCurrentAdvertisingIdentifier = flag;
        return this;
    }

}
