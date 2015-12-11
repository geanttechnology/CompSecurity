// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.view.View;
import com.apprupt.sdk.adview.ExpandProperties;
import com.apprupt.sdk.adview.OrientationProperties;
import com.apprupt.sdk.mediation.Adapter;
import com.apprupt.sdk.mediation.InterstitialAdWrapper;
import com.apprupt.sdk.mediation.Mediator;
import com.apprupt.sdk.mediation.Size;
import com.apprupt.sdk.mediation.ValueExchangeCompletion;

// Referenced classes of package com.apprupt.sdk:
//            CvAdWrapper, Logger, CvMediator, CvViewHelper, 
//            MRAIDView, CvInterstitialActivity

public class CvInterstitialAdWrapper extends CvAdWrapper
    implements InterstitialAdWrapper
{

    private volatile CvInterstitialActivity activity;
    private volatile com.apprupt.sdk.mediation.InterstitialAdWrapper.Listener listener;
    private final Logger.log llog = Logger.get("Lifecycle.InterstitialWrapper");
    private ValueExchangeCompletion veCompletion;
    private MRAIDView view;

    CvInterstitialAdWrapper(Adapter adapter, CvMediator cvmediator)
    {
        super(adapter, cvmediator);
        listener = null;
        activity = null;
        view = null;
        anyVECompletion(cvmediator.getValueExchangeCompletion());
    }

    private void afterPrepare()
    {
        llog.i(new Object[] {
            "Present interstitial"
        });
        CvViewHelper.runOnUIThread(new _cls3());
    }

    private void anyVECompletion(ValueExchangeCompletion valueexchangecompletion)
    {
        if (valueexchangecompletion != null)
        {
            veCompletion = valueexchangecompletion;
            return;
        } else
        {
            veCompletion = new _cls1();
            return;
        }
    }

    void adResponseProcessed()
    {
        getMediator().adDidFinishLoading(this);
    }

    public void changeCloseButtonVisibility(boolean flag)
    {
    }

    Runnable closeButtonHandler()
    {
        return view.closeButtonHandler();
    }

    ExpandProperties getExpandProperties()
    {
        return view.getExpandProperties();
    }

    public com.apprupt.sdk.mediation.InterstitialAdWrapper.Listener getListener()
    {
        return listener;
    }

    OrientationProperties getOrientationProperties()
    {
        return view.getOrientationProperties();
    }

    View getView()
    {
        return view;
    }

    public void presentInterstitial()
    {
        llog.i(new Object[] {
            "load mraid view..."
        });
        CvViewHelper.runOnUIThread(new _cls2(), true);
    }

    void setActivity(CvInterstitialActivity cvinterstitialactivity)
    {
        activity = cvinterstitialactivity;
    }

    public void setBackgroundColor(int i)
    {
    }

    public void setListener(com.apprupt.sdk.mediation.InterstitialAdWrapper.Listener listener1)
    {
        listener = listener1;
    }

    public void setMediator(Mediator mediator)
    {
        super.setMediator(mediator);
        anyVECompletion(getMediator().getValueExchangeCompletion());
    }

    void setupSize(Size size)
    {
        android.content.Context context = getMediator().getContext();
        size = new android.widget.RelativeLayout.LayoutParams(size.computedWidth(context, true), size.computedHeight(context, true));
        size.addRule(13);
        int i = CvViewHelper.dp2px(50F);
        view.setLayoutParams(size);
        view.setMinimumHeight(i);
    }

    void veCompleted()
    {
        CvViewHelper.runOnUIThread(new _cls4(), true);
    }


/*
    static MRAIDView access$002(CvInterstitialAdWrapper cvinterstitialadwrapper, MRAIDView mraidview)
    {
        cvinterstitialadwrapper.view = mraidview;
        return mraidview;
    }

*/




    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}

}
