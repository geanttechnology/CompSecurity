// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import com.amazon.device.ads.AmazonOOAdPreferencesURLListener;
import com.amazon.device.ads.AmazonOOAdRegistration;
import com.amazon.device.ads.AmazonOOAdRegistrationListener;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonProgressDialog;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.mobileads:
//            AdsHelper

class this._cls0
    implements AmazonOOAdPreferencesURLListener
{

    final l.activity this$0;

    public void onAdPreferencesURLFetched(String s)
    {
        progressDialog.dismiss();
        ActivityUtils.startAdsWebActivity(activity, s);
    }

    l.activity()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/mobileads/AdsHelper$2

/* anonymous class */
    static final class AdsHelper._cls2
        implements AmazonOOAdRegistrationListener
    {

        final AmazonActivity val$activity;
        final AmazonProgressDialog val$progressDialog;

        public void onRegistrationInfoReady(com.amazon.device.ads.AmazonOOAdRegistration.AmazonOOAdRegistrationInfo amazonooadregistrationinfo)
        {
            if (amazonooadregistrationinfo != null)
            {
                AmazonOOAdRegistration.fetchAdPreferencesURL(new AdsHelper._cls2._cls1());
                return;
            } else
            {
                progressDialog.dismiss();
                return;
            }
        }

            
            {
                progressDialog = amazonprogressdialog;
                activity = amazonactivity;
                super();
            }
    }

}
