// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mobile.mash.api.MASHPluginManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

public class MShopMASHPluginManager extends MASHPluginManager
{

    private static final Map SERVICE_MAPPING = new HashMap();

    public MShopMASHPluginManager(CordovaWebView cordovawebview, CordovaInterface cordovainterface, List list)
    {
        super(cordovawebview, cordovainterface, list);
    }

    private static void initServiceMappingForApi14To16()
    {
        SERVICE_MAPPING.put("LaunchIntentURL", "MASHCore");
        SERVICE_MAPPING.put("CanLaunchIntentURL", "MASHCore");
        SERVICE_MAPPING.put("ShowContactPicker", "MASHContacts");
        SERVICE_MAPPING.put("AddEventListener", "MASHEvent");
        SERVICE_MAPPING.put("RemoveEventListener", "MASHEvent");
        SERVICE_MAPPING.put("DispatchEvent", "MASHEvent");
        SERVICE_MAPPING.put("ShowEmbeddedBrowser", "MASHEmbeddedBrowser");
        SERVICE_MAPPING.put("ExitEmbeddedBrowser", "MASHEmbeddedBrowser");
        SERVICE_MAPPING.put("ShowOneClickSettings", "MASHMShopYourAccount");
        SERVICE_MAPPING.put("ShowAdsPreferences", "MASHMShopYourAccount");
        SERVICE_MAPPING.put("ShowAmazonPoints", "MASHMShopYourAccount");
        SERVICE_MAPPING.put("ShowOfferListingPage", "MASHMShopDetailPage");
        SERVICE_MAPPING.put("ShowBarcodeScanner", "MASHMShopSearch");
        SERVICE_MAPPING.put("ShowDeliveryDestinationPicker", "MASHMShopCheckout");
        SERVICE_MAPPING.put("CancelFullscreen", "MASHAppUi");
        SERVICE_MAPPING.put("RequestFullscreen", "MASHAppUi");
        SERVICE_MAPPING.put("FocusOnItem", "MASHAppUi");
        SERVICE_MAPPING.put("Share", "MASHSocial");
        SERVICE_MAPPING.put("aiv.IsPlaybackSustainable", "MASHAiv");
        SERVICE_MAPPING.put("aiv.StartPlayback", "MASHAiv");
        SERVICE_MAPPING.put("aiv.StartTrailer", "MASHAiv");
        SERVICE_MAPPING.put("aiv.WhisperCache", "MASHAiv");
    }

    protected String overrideServiceName(String s, String s1)
    {
        String s2 = null;
        if ("Mash".equals(s))
        {
            s2 = (String)SERVICE_MAPPING.get(s1);
        }
        if (s2 != null)
        {
            return s2;
        } else
        {
            return s;
        }
    }

    static 
    {
        initServiceMappingForApi14To16();
    }
}
