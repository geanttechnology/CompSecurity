// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            AdView, InternalAdRegistration, IInternalAdRegistration, DeviceInfo, 
//            AdData, IAdController, Log, AdProperties

abstract class AdRenderer
    implements AdView
{
    protected static final class AdState extends Enum
    {

        private static final AdState $VALUES[];
        public static final AdState EXPANDED;

        public static AdState valueOf(String s)
        {
            return (AdState)Enum.valueOf(com/amazon/device/ads/AdRenderer$AdState, s);
        }

        public static AdState[] values()
        {
            return (AdState[])$VALUES.clone();
        }

        static 
        {
            EXPANDED = new AdState("EXPANDED", 0);
            $VALUES = (new AdState[] {
                EXPANDED
            });
        }

        private AdState(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final String AAX_REDIRECT_BETA = "aax-beta.integ.amazon.com";
    protected static final String AAX_REDIRECT_GAMMA = "aax-us-east.amazon-adsystem.com";
    protected static final String AAX_REDIRECT_PROD = "aax-us-east.amazon-adsystem.com";
    protected static final String CORNERSTONE_BEST_ENDPOINT_BETA = "d16g-cornerstone-bes.integ.amazon.com";
    protected static final String CORNERSTONE_BEST_ENDPOINT_PROD = "pda-bes.amazon.com";
    private static final String LOG_TAG = "AdRenderer";
    protected AdData adData;
    protected final Context context;
    protected final IAdController controller;
    protected boolean isDestroyed;
    protected boolean isInitialized;
    private double scalingMultiplier;
    protected boolean viewRemoved;

    protected AdRenderer(AdData addata, IAdController iadcontroller, Context context1)
    {
        viewRemoved = false;
        isDestroyed = false;
        isInitialized = false;
        scalingMultiplier = 1.0D;
        adData = addata;
        controller = iadcontroller;
        context = context1;
    }

    protected static double calculateScalingMultiplier(int i, int j, int k, int l)
    {
        double d = (double)k / (double)i;
        double d1 = (double)l / (double)j;
        if ((d1 < d || d == 0.0D) && d1 != 0.0D)
        {
            d = d1;
        }
        d1 = d;
        if (d == 0.0D)
        {
            d1 = 1.0D;
        }
        return d1;
    }

    protected static double determineScalingMultiplier(AdData addata, IAdController iadcontroller)
    {
        float f = InternalAdRegistration.getInstance().getDeviceInfo().getScalingFactorAsFloat();
        int i = (int)((float)addata.getWidth() * f);
        int j = (int)((float)addata.getHeight() * f);
        double d = calculateScalingMultiplier(i, j, iadcontroller.getWindowWidth(), iadcontroller.getWindowHeight());
        Log.d("AdRenderer", "Scaling Params: scalingDensity: %f, windowWidth: %d, windowHeight: %d, adWidth: %d, adHeight: %d, scale: %f", new Object[] {
            Float.valueOf(f), Integer.valueOf(iadcontroller.getWindowWidth()), Integer.valueOf(iadcontroller.getWindowHeight()), Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d)
        });
        return d;
    }

    protected void adLoaded(AdProperties adproperties)
    {
        controller.adLoaded(adproperties);
    }

    protected abstract void destroy();

    protected abstract boolean getAdState(AdState adstate);

    public int getHeight()
    {
        return adData.getHeight();
    }

    protected double getScalingMultiplier()
    {
        return scalingMultiplier;
    }

    public String getScalingMultiplierDescription()
    {
        if (getScalingMultiplier() > 1.0D)
        {
            return "u";
        }
        if (getScalingMultiplier() < 1.0D && getScalingMultiplier() > 0.0D)
        {
            return "d";
        } else
        {
            return "n";
        }
    }

    public AdWebViewClient.UrlExecutor getSpecialUrlExecutor()
    {
        return controller.getSpecialUrlExecutor();
    }

    public void initialize()
    {
        scalingMultiplier = determineScalingMultiplier(adData, controller);
        isInitialized = true;
    }

    protected boolean isAdViewDestroyed()
    {
        return !isInitialized() || isDestroyed;
    }

    protected boolean isAdViewRemoved()
    {
        return !isInitialized() || viewRemoved;
    }

    public boolean isAdViewRenderable()
    {
        return isInitialized() && !isAdViewRemoved() && !isAdViewDestroyed();
    }

    public boolean isInitialized()
    {
        return isInitialized;
    }

    protected abstract void prepareToGoAway();

    protected abstract void removeView();

    protected abstract boolean render();

    protected abstract boolean sendCommand(String s, Map map);

    protected void setAd(AdData addata)
    {
        adData = addata;
    }

    public boolean shouldDisableWebViewHardwareAcceleration()
    {
        return controller.shouldDisableWebViewHardwareAcceleration();
    }

    protected abstract boolean shouldReuse();
}
