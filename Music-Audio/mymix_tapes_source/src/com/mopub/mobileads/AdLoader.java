// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.AdResponse;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            AdViewController, MoPubView

abstract class AdLoader
{
    static class CustomEventAdLoader extends AdLoader
    {

        private String mCustomEventClassName;
        private Map mServerExtras;

        Map getServerExtras()
        {
            return mServerExtras;
        }

        void load()
        {
            Object obj = (AdViewController)mWeakAdViewController.get();
            if (obj == null || ((AdViewController) (obj)).isDestroyed() || TextUtils.isEmpty(mCustomEventClassName))
            {
                return;
            }
            ((AdViewController) (obj)).setNotLoading();
            obj = ((AdViewController) (obj)).getMoPubView();
            if (obj == null)
            {
                MoPubLog.d("Can't load an ad in this ad view because it was destroyed.");
                return;
            } else
            {
                ((MoPubView) (obj)).loadCustomEvent(mCustomEventClassName, mServerExtras);
                return;
            }
        }

        public CustomEventAdLoader(AdViewController adviewcontroller, String s, Map map)
        {
            super(adviewcontroller);
            mCustomEventClassName = s;
            mServerExtras = map;
        }
    }


    WeakReference mWeakAdViewController;

    AdLoader(AdViewController adviewcontroller)
    {
        mWeakAdViewController = new WeakReference(adviewcontroller);
    }

    static AdLoader fromAdResponse(AdResponse adresponse, AdViewController adviewcontroller)
    {
        MoPubLog.i("Performing custom event.");
        String s = adresponse.getCustomEventClassName();
        if (s != null)
        {
            return new CustomEventAdLoader(adviewcontroller, s, adresponse.getServerExtras());
        } else
        {
            MoPubLog.i("Failed to create custom event.");
            return null;
        }
    }

    abstract void load();
}
