// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.gotv.crackle.Application;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.Localization;
import java.util.Locale;
import tv.freewheel.ad.AdManager;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IAdManager;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;

// Referenced classes of package com.freewheel.ad:
//            IAdHolder

public class AdFetcher
{

    public static final String AD_SLOT_NAME = "SPLASH_SLOT";
    public static final String BANNER_SLOT_NAME = "BANNER_SLOT";
    private static String fwAdServer = "http://2517d.v.fwmrm.net";
    public static String mAdmangerUrl = "http://adm.fwmrm.net/p/crackle_live/AdManager.fpk";
    private static int networkId = 0x2517d;
    private static String playerProfile = "151933:crackle_android_live_v2";
    private static String siteSection;
    private IConstants adConstants;
    private IAdContext adContext;
    private IAdHolder adHolder;
    private String adId;
    protected IAdManager adManager;
    private boolean disposed;
    private boolean isLAT;

    public AdFetcher(IAdHolder iadholder)
    {
        disposed = false;
        adHolder = iadholder;
        adManager = AdManager.getInstance(Application.getInstance());
        getAdInfo();
    }

    private void getAdInfo()
    {
        isLAT = true;
        (new Thread(new Runnable() {

            final AdFetcher this$0;

            public void run()
            {
                try
                {
                    com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(Application.getAppContext());
                    adId = info.getId();
                    isLAT = info.isLimitAdTrackingEnabled();
                }
                catch (Exception exception) { }
                if (TextUtils.isEmpty(adId))
                {
                    adId = android.provider.Settings.Secure.getString(Application.getInstance().getContentResolver(), "android_id");
                    isLAT = false;
                }
            }

            
            {
                this$0 = AdFetcher.this;
                super();
            }
        })).start();
    }

    public static String getPlayerProfile()
    {
        return playerProfile;
    }

    public void dispose()
    {
        disposed = true;
    }

    public String fwUserAgentValue()
    {
        return (new StringBuilder()).append("Crackle_").append(Application.getInstalledVersion()).append("_android_").append(android.os.Build.VERSION.RELEASE).append("_").append(Build.MODEL).append("_").append(Application.getInstance().getLocalization().getCurrentCountryCode()).toString();
    }

    public void getAdWithCurrentContext()
    {
        adHolder.beforeSubmitRequest(siteSection);
        adContext.submitRequest(10D);
    }

    public void loadAd()
    {
        loadAd(null);
    }

    public void loadAd(String s)
    {
        if (s != null)
        {
            String s1 = Application.getInstance().getLocalization().getCurrentCountryCode().toLowerCase(Locale.US);
            if (s1.equalsIgnoreCase("us"))
            {
                s1 = "";
            } else
            {
                s1 = (new StringBuilder()).append("_").append(s1).toString();
            }
            if (Application.isAmazonFireTV())
            {
                siteSection = String.format(s, new Object[] {
                    s1
                });
            } else
            if (Application.isFanhattan())
            {
                siteSection = s;
            } else
            if (Application.getInstance().isTablet())
            {
                siteSection = String.format(s, new Object[] {
                    "tablet", s1
                });
            } else
            {
                siteSection = String.format(s, new Object[] {
                    "handset", s1
                });
            }
        }
        if (disposed)
        {
            return;
        }
        if (adManager == null)
        {
            adHolder.onAdManagerLoadFailed();
            return;
        }
        adManager.setServer(fwAdServer);
        adManager.setNetwork(networkId);
        adContext = adManager.newContext();
        IAdContext iadcontext;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            adContext.addKeyValue("cRoll", "true");
        } else
        {
            adContext.addKeyValue("cRoll", "false");
        }
        adContext.addKeyValue("uip", Application.getInstance().getLocalization().getPublicIPAddress());
        adContext.addKeyValue("uagent", fwUserAgentValue());
        if (adHolder.getVideoTitle() != null)
        {
            adContext.addKeyValue("title", adHolder.getVideoTitle().toLowerCase(Locale.US).replace(" ", ""));
        }
        if (CrackleAccountManager.getUserAge() > 0)
        {
            adContext.addKeyValue("k1", String.format("%d", new Object[] {
                Integer.valueOf(CrackleAccountManager.getUserAge())
            }));
            adContext.addKeyValue("k2", String.format("%d", new Object[] {
                Integer.valueOf(CrackleAccountManager.getUserGender())
            }));
        }
        iadcontext = adContext;
        if (Application.getInstance().isTablet())
        {
            s = "TAB";
        } else
        {
            s = "PHN";
        }
        iadcontext.addKeyValue("nielsen_device_group", s);
        adContext.addKeyValue("nielsen_platform", "MBL");
        adContext.addKeyValue("_fw_nielsen_app_id", "PFDF102BF-8FB9-B8EF-E040-070AAD315556");
        if (isLAT)
        {
            adContext.addKeyValue("c9", "devid,optout");
        } else
        {
            adContext.addKeyValue("_fw_did_google_advertising_id", adId);
        }
        iadcontext = adContext;
        if (isLAT)
        {
            s = "devid,optout";
        } else
        {
            s = adId;
        }
        iadcontext.addKeyValue("comscore_did_x", s);
        adContext.addKeyValue("comscore_impl_type", "a");
        adContext.addKeyValue("comscore_platform", "android");
        adContext.addKeyValue("comscore_device", Build.DEVICE);
        adContext.setActivity(adHolder.getBaseActivity());
        adHolder.onAdContextCreated(adContext);
        adConstants = adContext.getConstants();
        s = new IEventListener() {

            final AdFetcher this$0;

            public void run(IEvent ievent)
            {
                if (disposed)
                {
                    return;
                } else
                {
                    adHolder.onRequestComplete(ievent);
                    return;
                }
            }

            
            {
                this$0 = AdFetcher.this;
                super();
            }
        };
        adContext.addEventListener(adConstants.EVENT_REQUEST_COMPLETE(), s);
        adContext.setProfile(playerProfile, null, null, null);
        adContext.setSiteSection(siteSection, 0, 0, 0, 0);
        adHolder.beforeSubmitRequest(siteSection);
        adContext.submitRequest(10D);
    }




/*
    static String access$002(AdFetcher adfetcher, String s)
    {
        adfetcher.adId = s;
        return s;
    }

*/


/*
    static boolean access$102(AdFetcher adfetcher, boolean flag)
    {
        adfetcher.isLAT = flag;
        return flag;
    }

*/


}
