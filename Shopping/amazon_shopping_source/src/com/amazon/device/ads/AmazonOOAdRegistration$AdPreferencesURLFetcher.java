// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.amazon.device.ads:
//            StartUpWaiter, AmazonOOAdRegistration, AdvertisingIdentifier, Configuration, 
//            Log, Utils, InternalAdRegistration, IInternalAdRegistration, 
//            RegistrationInfo, AmazonOOAdPreferencesURLListener

private static class listener extends StartUpWaiter
{

    private AmazonOOAdPreferencesURLListener listener;

    private void onFetched(final String adPreferencesURL)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final AmazonOOAdRegistration.AdPreferencesURLFetcher this$0;
            final String val$adPreferencesURL;

            public void run()
            {
                listener.onAdPreferencesURLFetched(adPreferencesURL);
            }

            
            {
                this$0 = AmazonOOAdRegistration.AdPreferencesURLFetcher.this;
                adPreferencesURL = s;
                super();
            }
        });
    }

    protected void startUpFailed()
    {
        onFetched(null);
    }

    protected void startUpReady()
    {
        onFetched onfetched = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
        String s = Configuration.getInstance().getString(nfo);
        StringBuilder stringbuilder = new StringBuilder(s);
        if (s.indexOf('?') == -1)
        {
            stringbuilder.append("?");
        } else
        {
            stringbuilder.append("&");
        }
        stringbuilder.append("adId=");
        s = onfetched.er();
        if (!onfetched.er())
        {
            Log.w("AmazonOOAdRegistration", "Ad-id not found, using blank");
            s = "";
        }
        stringbuilder.append(Utils.getURLEncodedString(s));
        stringbuilder.append("&appId=");
        stringbuilder.append(Utils.getURLEncodedString(InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey()));
        onFetched(stringbuilder.toString());
    }


    protected _cls1.val.adPreferencesURL(AmazonOOAdPreferencesURLListener amazonooadpreferencesurllistener)
    {
        listener = amazonooadpreferencesurllistener;
    }
}
