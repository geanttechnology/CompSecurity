// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import com.apprupt.sdk.adview.AdViewWrapper;
import com.apprupt.sdk.adview.AdViewWrapperListener;

// Referenced classes of package com.apprupt.sdk:
//            CvError, CvContext

public class CvAdColony
{
    static interface Wrapper
    {

        public abstract AdViewWrapper createInlineAd(CvContext cvcontext, int i, int j, AdViewWrapperListener adviewwrapperlistener)
            throws CvError;

        public abstract AdViewWrapper createInlineAd(CvContext cvcontext, String s, int i, AdViewWrapperListener adviewwrapperlistener)
            throws CvError;

        public abstract void init(Activity activity);

        public abstract boolean isActiveForSpace(int i, boolean flag);

        public abstract boolean isActiveForSpace(String s, boolean flag);

        public abstract void onPause();

        public abstract void onResume(Activity activity);

        public abstract void reinit(Activity activity);

        public abstract void setAlwaysStartMuted(boolean flag);

        public abstract void showInterstitial(int i, WrapperListener wrapperlistener);

        public abstract void showInterstitial(String s, WrapperListener wrapperlistener);
    }


    private static Wrapper adColonyWrapper = new DummyWrapper(null);

    public CvAdColony()
    {
    }

    static void onPause()
    {
        adColonyWrapper.onPause();
    }

    static void onResume(Activity activity)
    {
        adColonyWrapper.onResume(activity);
    }

    static void setWrapper(Wrapper wrapper1)
    {
        Object obj = wrapper1;
    /* block-local class not found */
    class DummyWrapper {}

        if (wrapper1 == null)
        {
            obj = new DummyWrapper(null);
        }
        adColonyWrapper = ((Wrapper) (obj));
    }

    static Wrapper wrapper()
    {
        return adColonyWrapper;
    }


    // Unreferenced inner class com/apprupt/sdk/CvAdColony$WrapperListener
    /* block-local class not found */
    class WrapperListener {}

}
