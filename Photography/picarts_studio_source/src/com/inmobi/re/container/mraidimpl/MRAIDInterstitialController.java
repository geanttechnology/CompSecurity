// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Message;
import android.view.Display;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.IMWebView;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDAudioVideoController

public class MRAIDInterstitialController
{

    protected static final int INT_BACKGROUND_ID = 224;
    public static AtomicBoolean isInterstitialDisplayed = new AtomicBoolean();
    private IMWebView a;
    private Activity b;
    private long c;
    private int d;
    public boolean lockOrientationValueForInterstitial;
    public Message mMsgOnInterstitialClosed;
    public Message mMsgOnInterstitialShown;
    public Display mSensorDisplay;
    public String orientationValueForInterstitial;

    public MRAIDInterstitialController(IMWebView imwebview, Activity activity)
    {
        lockOrientationValueForInterstitial = true;
        c = 0L;
        a = imwebview;
    }

    private CustomView a()
    {
        CustomView customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        customview.setId(226);
        customview.disableView(a.getDisableCloseRegion());
        return customview;
    }

    static IMWebView a(MRAIDInterstitialController mraidinterstitialcontroller)
    {
        return mraidinterstitialcontroller.a;
    }

    static long b(MRAIDInterstitialController mraidinterstitialcontroller)
    {
        return mraidinterstitialcontroller.c;
    }

    public void animateAndDismissWebview()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setStartOffset(0L);
        alphaanimation.setDuration(c);
        alphaanimation.setAnimationListener(new _cls1());
        a.startAnimation(alphaanimation);
    }

    public void changeContentAreaForInterstitials(long l)
    {
        FrameLayout framelayout;
        RelativeLayout relativelayout;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        CustomView customview;
        int i;
        c = l;
        i = Initializer.getConfigParams().getWebviewBgColor();
        d = b.getRequestedOrientation();
        handleOrientationForInterstitial();
        framelayout = (FrameLayout)b.findViewById(0x1020002);
        relativelayout = new RelativeLayout(a.getContext());
        layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        layoutparams.addRule(10);
        a.setFocusable(true);
        a.setFocusableInTouchMode(true);
        relativelayout.addView(a, layoutparams);
        layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(a.getDensity() * 50F), (int)(a.getDensity() * 50F));
        layoutparams.addRule(11);
        relativelayout.addView(a(), layoutparams);
        customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_BUTTON);
        byte byte0;
        if (a.getCustomClose())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        try
        {
            customview.setVisibility(byte0);
            customview.setId(225);
            relativelayout.addView(customview, layoutparams);
            layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
            relativelayout.setId(224);
            relativelayout.setBackgroundColor(i);
            framelayout.addView(relativelayout, layoutparams);
            a.setBackgroundColor(i);
            a.requestFocus();
            a.setOnKeyListener(new _cls3());
            a.setOnTouchListener(new _cls4());
            isInterstitialDisplayed.set(true);
            a.fireOnShowAdScreen();
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.2", "Failed showing interstitial ad", exception);
        }
        return;
    }

    public void dismissWebview()
    {
        FrameLayout framelayout = (FrameLayout)b.findViewById(0x1020002);
        RelativeLayout relativelayout = (RelativeLayout)framelayout.findViewById(224);
        b.runOnUiThread(new _cls2(relativelayout, framelayout));
    }

    public void handleInterstitialClose()
    {
        IMWebView.userInitiatedClose = true;
        isInterstitialDisplayed.set(false);
        a.close();
    }

    public void handleOrientationForInterstitial()
    {
        a.lockExpandOrientation(b, lockOrientationValueForInterstitial, orientationValueForInterstitial);
    }

    public void resetContentsForInterstitials()
    {
        try
        {
            if (a.getParent() == null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.2", "Failed to close the interstitial ad", exception);
            return;
        }
        b.setRequestedOrientation(d);
        a.mAudioVideoController.releaseAllPlayers();
        if ((RelativeLayout)((FrameLayout)b.findViewById(0x1020002)).findViewById(224) != null)
        {
            if (c <= 0L)
            {
                break MISSING_BLOCK_LABEL_115;
            }
            animateAndDismissWebview();
        }
_L1:
        a.fireOnDismissAdScreen();
        a.injectJavaScript("window.mraidview.unRegisterOrientationListener()");
        a.setState(com.inmobi.re.container.IMWebView.ViewState.HIDDEN);
        b.finish();
        return;
        dismissWebview();
          goto _L1
    }

    public void setActivity(Activity activity)
    {
        if (activity != null)
        {
            b = activity;
        }
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls2 {}

}
