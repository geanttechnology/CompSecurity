// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.IMWebView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDAudioVideoController, MRAIDInterstitialController

public class MRAIDExpandController
{

    protected static final int PLACEHOLDER_ID = 437;
    protected static final int RELATIVELAYOUT_ID = 438;
    private IMWebView a;
    private Activity b;
    private Activity c;
    private IMWebView d;
    private IMWebView e;
    public com.inmobi.re.controller.JSController.ExpandProperties expandProperties;
    public int initialExpandOrientation;
    public boolean lockOrientationValueForExpand;
    public boolean mIsExpandUrlValid;
    public Display mSensorDisplay;
    public String orientationValueForExpand;
    public boolean tempExpPropsLock;
    public boolean useLockOrient;

    public MRAIDExpandController(IMWebView imwebview, Activity activity)
    {
        tempExpPropsLock = true;
        d = null;
        mIsExpandUrlValid = false;
        lockOrientationValueForExpand = true;
        e = null;
        a = imwebview;
        b = activity;
    }

    private FrameLayout a(com.inmobi.re.controller.JSController.ExpandProperties expandproperties)
    {
        FrameLayout framelayout = (FrameLayout)((ViewGroup)a.getOriginalParent()).getRootView().findViewById(0x1020002);
        a();
        FrameLayout framelayout1 = new FrameLayout(a.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        framelayout1.setId(435);
        framelayout1.setOnTouchListener(new _cls2());
        framelayout1.setPadding(expandproperties.x, expandproperties.y, 0, 0);
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        RelativeLayout relativelayout = new RelativeLayout(a.getContext());
        relativelayout.setId(438);
        android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        if (mIsExpandUrlValid)
        {
            relativelayout.addView(d, layoutparams2);
        } else
        {
            relativelayout.addView(a, layoutparams2);
        }
        a(((ViewGroup) (relativelayout)), expandproperties.useCustomClose);
        framelayout1.addView(relativelayout, layoutparams1);
        framelayout.addView(framelayout1, layoutparams);
        a.setFocusable(true);
        a.setFocusableInTouchMode(true);
        a.requestFocus();
        return framelayout1;
    }

    static IMWebView a(MRAIDExpandController mraidexpandcontroller)
    {
        return mraidexpandcontroller.a;
    }

    private void a()
    {
        if (a.getOriginalParent() != a.getParent())
        {
            ((ViewGroup)a.getParent()).removeView(a);
            return;
        }
        try
        {
            FrameLayout framelayout = new FrameLayout(a.getContext());
            framelayout.setId(437);
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(a.getWidth(), a.getHeight());
            ((ViewGroup)a.getOriginalParent()).addView(framelayout, a.getOriginalIndex(), layoutparams);
            ((ViewGroup)a.getParent()).removeView(a);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.2", "Exception in replaceByPlaceHolder ", exception);
        }
        return;
    }

    private void a(ViewGroup viewgroup, boolean flag)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(a.getDensity() * 50F), (int)(a.getDensity() * 50F));
        layoutparams.addRule(11);
        viewgroup.addView(b(), layoutparams);
        CustomView customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_BUTTON);
        byte byte0;
        if (flag || a.getCustomClose())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        customview.setVisibility(byte0);
        customview.setId(225);
        viewgroup.addView(customview, layoutparams);
    }

    private CustomView b()
    {
        CustomView customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        customview.setId(226);
        customview.disableView(a.getDisableCloseRegion());
        return customview;
    }

    private void c()
    {
        Object obj;
        if (d == null)
        {
            ((ViewGroup)a.getParent().getParent().getParent()).removeView((View)a.getParent().getParent());
            ((ViewGroup)a.getParent()).removeView(a);
        } else
        {
            ((ViewGroup)d.getParent().getParent().getParent()).removeView((View)d.getParent().getParent());
            ((ViewGroup)d.getParent()).removeView(d);
        }
        obj = ((View)a.getOriginalParent()).findViewById(437);
        ((ViewGroup)((View) (obj)).getParent()).removeView(((View) (obj)));
        if (a.mOriginalWebviewForExpandUrl != null)
        {
            obj = a.mOriginalWebviewForExpandUrl;
        } else
        {
            obj = a;
        }
        ((ViewGroup)a.getOriginalParent()).addView(((View) (obj)), a.getOriginalIndex());
        ((IMWebView) (obj)).resetLayout();
    }

    public void closeExpanded()
    {
        if (a.getViewState().compareTo(com.inmobi.re.container.IMWebView.ViewState.DEFAULT) == 0)
        {
            return;
        }
        if (e != null)
        {
            e.destroy();
        }
        if (a.mOriginalWebviewForExpandUrl != null)
        {
            a.mOriginalWebviewForExpandUrl.setState(com.inmobi.re.container.IMWebView.ViewState.DEFAULT);
            a.mAudioVideoController.releaseAllPlayers();
            a.mOriginalWebviewForExpandUrl.mAudioVideoController.releaseAllPlayers();
            a.mOriginalWebviewForExpandUrl.mExpandController.e = null;
            a.destroy();
        } else
        {
            e = null;
        }
        synchronized (a.mutex)
        {
            a.isMutexAquired.set(false);
            a.mutex.notifyAll();
        }
        if (!tempExpPropsLock && a.publisherOrientation == -1)
        {
            tempExpPropsLock = true;
        }
        a.doNotFireVisibilityChanged.set(true);
        c();
        a.mAudioVideoController.releaseAllPlayers();
        a.getMRAIDUrls().clear();
        a.closeExpanded();
        a.setVisibility(0);
        mIsExpandUrlValid = false;
        if (useLockOrient)
        {
            b.setRequestedOrientation(initialExpandOrientation);
        }
        a.setState(com.inmobi.re.container.IMWebView.ViewState.DEFAULT);
        a.doNotFireVisibilityChanged.set(false);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void disableEnableHardwareAccelerationForExpandWithURLView()
    {
        if (e != null)
        {
            e.disableHardwareAcceleration();
        }
    }

    public void doExpand(Bundle bundle)
    {
        a.doNotFireVisibilityChanged.set(true);
        FrameLayout framelayout;
        Intent intent;
        try
        {
            if (a.getOriginalParent() == null)
            {
                a.saveOriginalViewParent();
            }
            if (((FrameLayout)a.getParent().getParent()).getId() == 435)
            {
                ((ViewGroup)a.getParent().getParent().getParent()).removeView((View)a.getParent().getParent());
            }
        }
        catch (Exception exception) { }
        bundle = bundle.getString("expand_url");
        if (!URLUtil.isValidUrl(bundle)) goto _L2; else goto _L1
_L1:
        mIsExpandUrlValid = true;
        d = new IMWebView(a.getContext(), a.mListener, false, false);
        e = d;
        d.publisherOrientation = a.publisherOrientation;
        d.mExpandController.tempExpPropsLock = a.mExpandController.tempExpPropsLock;
        d.mExpandController.expandProperties = new com.inmobi.re.controller.JSController.ExpandProperties();
        d.mExpandController.expandProperties.x = a.mExpandController.expandProperties.x;
        d.mExpandController.expandProperties.y = expandProperties.y;
        d.mExpandController.expandProperties.currentX = expandProperties.currentX;
        d.mExpandController.expandProperties.currentY = expandProperties.currentY;
        d.mExpandController.initialExpandOrientation = a.mExpandController.initialExpandOrientation;
        d.mExpandController.useLockOrient = a.mExpandController.useLockOrient;
        d.mExpandController.mIsExpandUrlValid = a.mExpandController.mIsExpandUrlValid;
        d.mExpandController.e = a.mExpandController.e;
        d.mOriginalWebviewForExpandUrl = a;
        d.setOriginalParent(a.getOriginalParent());
        a.doNotFireVisibilityChanged.set(false);
_L5:
        framelayout = a(expandProperties);
        framelayout.setBackgroundColor(0);
        intent = new Intent(b, com/inmobi/androidsdk/IMBrowserActivity);
        intent.putExtra("extra_browser_type", 102);
        IMBrowserActivity.setExpandedLayout(framelayout);
        if (!mIsExpandUrlValid) goto _L4; else goto _L3
_L3:
        IMBrowserActivity.setExpandedWebview(d);
_L6:
        IMBrowserActivity.setOriginalActivity(b);
        b.startActivity(intent);
_L7:
        a.mAudioVideoController.videoValidateWidth = expandProperties.width;
        if (d != null)
        {
            d.mAudioVideoController.videoValidateWidth = expandProperties.width;
        }
        synchronized (a.mutex)
        {
            a.isMutexAquired.set(false);
            a.mutex.notifyAll();
        }
        try
        {
            if (mIsExpandUrlValid)
            {
                d.loadUrl(bundle);
            }
            a.requestLayout();
            a.invalidate();
            a.postInHandler(new _cls1());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.debug("[InMobi]-[RE]-4.5.2", "Exception in doexpand ", bundle);
            a.setState(com.inmobi.re.container.IMWebView.ViewState.DEFAULT);
            synchronized (a.mutex)
            {
                a.isMutexAquired.set(false);
                a.mutex.notifyAll();
            }
        }
        a.doNotFireVisibilityChanged.set(false);
        return;
_L2:
        mIsExpandUrlValid = false;
          goto _L5
        obj;
        bundle;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        IMBrowserActivity.setExpandedWebview(a);
          goto _L6
        obj;
        Log.internal("[InMobi]-[RE]-4.5.2", "Exception in expand in separate activity ", ((Throwable) (obj)));
          goto _L7
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
          goto _L5
    }

    public void handleOrientationFor2Piece()
    {
        int i;
        i = a.getIntegerCurrentRotation();
        if (a.mInterstitialController.lockOrientationValueForInterstitial)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        if (a.mInterstitialController.orientationValueForInterstitial.equals("portrait"))
        {
            b.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(i));
            return;
        }
        try
        {
            if (a.mInterstitialController.orientationValueForInterstitial.equals("landscape"))
            {
                b.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(i));
                return;
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "IMWebview Handle orientation for 2 piece ", exception);
            return;
        }
        if (b.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "In allowFalse, none mode dev orientation:ORIENTATION_LANDSCAPE");
            b.setRequestedOrientation(0);
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.2", "In allowFalse, none mode dev orientation:ORIENTATION_PORTRAIT");
        b.setRequestedOrientation(1);
        return;
        if (b.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.2", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
        return;
    }

    public void handleOrientationForExpand()
    {
        if (mIsExpandUrlValid)
        {
            e.lockExpandOrientation(c, lockOrientationValueForExpand, orientationValueForExpand);
            return;
        } else
        {
            a.lockExpandOrientation(c, lockOrientationValueForExpand, orientationValueForExpand);
            return;
        }
    }

    public void reset()
    {
        expandProperties = new com.inmobi.re.controller.JSController.ExpandProperties();
    }

    public void setActivity(Activity activity)
    {
        if (activity != null)
        {
            c = activity;
        }
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
