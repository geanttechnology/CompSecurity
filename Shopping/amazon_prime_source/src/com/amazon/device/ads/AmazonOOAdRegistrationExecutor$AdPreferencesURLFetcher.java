// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            StartUpWaiter, AmazonOOAdRegistrationExecutor, AdvertisingIdentifier, Configuration, 
//            MobileAdsLogger, WebUtils2, MobileAdsInfoStore, RegistrationInfo, 
//            AmazonOOAdPreferencesURLListener, Settings

private static class webUtils extends StartUpWaiter
{

    private final AdvertisingIdentifier advertisingIdentifier;
    private final MobileAdsInfoStore infoStore;
    private final AmazonOOAdPreferencesURLListener listener;
    private final MobileAdsLogger logger;
    private final onFetched threadRunner;
    private final WebUtils2 webUtils;

    private void onFetched(final String adPreferencesURL)
    {
        threadRunner.threadRunner(new Runnable() {

            final AmazonOOAdRegistrationExecutor.AdPreferencesURLFetcher this$0;
            final String val$adPreferencesURL;

            public void run()
            {
                listener.onAdPreferencesURLFetched(adPreferencesURL);
            }

            
            {
                this$0 = AmazonOOAdRegistrationExecutor.AdPreferencesURLFetcher.this;
                adPreferencesURL = s;
                super();
            }
        }, _cls1.val.adPreferencesURL, _cls1.val.adPreferencesURL);
    }

    protected void startUpFailed()
    {
        onFetched(null);
    }

    protected void startUpReady()
    {
        onFetched onfetched = advertisingIdentifier.getAdvertisingIdentifierInfo();
        String s = getConfiguration().getString(getConfiguration);
        StringBuilder stringbuilder = new StringBuilder(s);
        if (s.indexOf('?') == -1)
        {
            stringbuilder.append("?");
        } else
        {
            stringbuilder.append("&");
        }
        stringbuilder.append("adId=");
        s = onfetched.getConfiguration();
        if (!onfetched.getConfiguration())
        {
            logger.w("Ad-id not found, using blank");
            s = "";
        }
        stringbuilder.append(webUtils.getURLEncodedString(s));
        stringbuilder.append("&appId=");
        stringbuilder.append(webUtils.getURLEncodedString(infoStore.getRegistrationInfo().getAppKey()));
        onFetched(stringbuilder.toString());
    }


    protected _cls1.val.adPreferencesURL(AmazonOOAdPreferencesURLListener amazonooadpreferencesurllistener, AdvertisingIdentifier advertisingidentifier, _cls1.val.adPreferencesURL adpreferencesurl, Settings settings, Configuration configuration, MobileAdsInfoStore mobileadsinfostore, MobileAdsLogger mobileadslogger, 
            WebUtils2 webutils2)
    {
        super(settings, configuration);
        listener = amazonooadpreferencesurllistener;
        advertisingIdentifier = advertisingidentifier;
        threadRunner = adpreferencesurl;
        infoStore = mobileadsinfostore;
        logger = mobileadslogger;
        webUtils = webutils2;
    }
}
