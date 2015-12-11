// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.supersonicads.sdk.agent.SupersonicAdsPublisherAgent;
import com.supersonicads.sdk.data.AdUnitsState;
import com.supersonicads.sdk.utils.Logger;
import com.supersonicads.sdk.utils.SDKUtils;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;

// Referenced classes of package com.supersonicads.sdk.controller:
//            VideoEventsListener, SupersonicWebView

public class ControllerActivity extends Activity
    implements SupersonicWebView.OnWebViewControllerChangeListener, VideoEventsListener
{
    private class OrientationManager extends OrientationEventListener
    {

        public int currentOrientation;
        public int defaultOrientation;
        final ControllerActivity this$0;

        public void onOrientationChanged(int i)
        {
            if (i != -1) goto _L2; else goto _L1
_L1:
            setRequestedOrientation(mOrientation);
_L21:
            return;
_L2:
            if (i > 45 && i <= 315) goto _L4; else goto _L3
_L3:
            mOrientationType;
            JVM INSTR tableswitch 0 2: default 68
        //                       0 83
        //                       1 116
        //                       2 128;
               goto _L5 _L6 _L7 _L8
_L5:
            setRequestedOrientation(mOrientation);
            return;
_L6:
            if (defaultOrientation == 2)
            {
                mOrientation = 9;
            } else
            {
                mOrientation = 1;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            mOrientation = 0;
            continue; /* Loop/switch isn't completed */
_L8:
            if (defaultOrientation == 2)
            {
                if (currentOrientation == 2)
                {
                    mOrientation = 0;
                } else
                {
                    mOrientation = 0;
                }
            } else
            {
                mOrientation = 1;
            }
            if (true) goto _L5; else goto _L4
_L4:
            if (i <= 45 || i > 135) goto _L10; else goto _L9
_L9:
            mOrientationType;
            JVM INSTR tableswitch 0 2: default 228
        //                       0 243
        //                       1 255
        //                       2 268;
               goto _L11 _L12 _L13 _L14
_L11:
            setRequestedOrientation(mOrientation);
            return;
_L12:
            mOrientation = 1;
            continue; /* Loop/switch isn't completed */
_L13:
            mOrientation = 8;
            continue; /* Loop/switch isn't completed */
_L14:
            if (defaultOrientation == 2)
            {
                mOrientation = 1;
            } else
            {
                mOrientation = 8;
            }
            if (true) goto _L11; else goto _L10
_L10:
            if (i <= 135 || i > 225)
            {
                continue; /* Loop/switch isn't completed */
            }
            mOrientationType;
            JVM INSTR tableswitch 0 2: default 348
        //                       0 363
        //                       1 396
        //                       2 409;
               goto _L15 _L16 _L17 _L18
_L15:
            setRequestedOrientation(mOrientation);
            return;
_L16:
            if (defaultOrientation == 2)
            {
                mOrientation = 9;
            } else
            {
                mOrientation = 1;
            }
            continue; /* Loop/switch isn't completed */
_L17:
            mOrientation = 8;
            continue; /* Loop/switch isn't completed */
_L18:
            if (defaultOrientation == 2)
            {
                if (currentOrientation == 2)
                {
                    mOrientation = 8;
                } else
                {
                    mOrientation = 8;
                }
            } else
            {
                mOrientation = 9;
            }
            if (true) goto _L15; else goto _L19
_L19:
            if (i <= 225 || i > 315) goto _L21; else goto _L20
_L20:
            mOrientationType;
            JVM INSTR tableswitch 0 2: default 512
        //                       0 527
        //                       1 540
        //                       2 552;
               goto _L22 _L23 _L24 _L25
_L22:
            setRequestedOrientation(mOrientation);
            return;
_L23:
            mOrientation = 9;
            continue; /* Loop/switch isn't completed */
_L24:
            mOrientation = 0;
            continue; /* Loop/switch isn't completed */
_L25:
            if (defaultOrientation == 2)
            {
                if (currentOrientation == 2)
                {
                    mOrientation = 9;
                } else
                {
                    mOrientation = 9;
                }
            } else
            {
                mOrientation = 0;
            }
            if (true) goto _L22; else goto _L26
_L26:
        }

        public OrientationManager(Context context, int i)
        {
            this$0 = ControllerActivity.this;
            super(context, i);
            defaultOrientation = 1;
            currentOrientation = 1;
            defaultOrientation = SDKUtils.getDeviceDefaultOrientation(context);
            currentOrientation = context.getResources().getConfiguration().orientation;
        }
    }


    private static final String TAG = com/supersonicads/sdk/controller/ControllerActivity.getSimpleName();
    private static final int WEB_VIEW_VIEW_ID = 1;
    final android.widget.RelativeLayout.LayoutParams MATCH_PARENT_LAYOUT_PARAMS = new android.widget.RelativeLayout.LayoutParams(-1, -1);
    public int applicationRotation;
    private boolean calledFromOnCreate;
    public int currentRequestedRotation;
    private RelativeLayout mContainer;
    private int mOrientation;
    private OrientationManager mOrientationManager;
    public int mOrientationType;
    private String mProductType;
    private AdUnitsState mState;
    private SupersonicWebView mWebViewController;
    private FrameLayout mWebViewFrameContainer;

    public ControllerActivity()
    {
        mOrientationType = -1;
        applicationRotation = -1;
        currentRequestedRotation = -1;
        calledFromOnCreate = false;
    }

    private void cancelScreenOn()
    {
        runOnUiThread(new Runnable() {

            final ControllerActivity this$0;

            public void run()
            {
                getWindow().clearFlags(128);
            }

            
            {
                this$0 = ControllerActivity.this;
                super();
            }
        });
    }

    private void handleOrientationState(String s, int i)
    {
        if (s != null)
        {
            if ("landscape".equalsIgnoreCase(s))
            {
                setInitiateLandscapeOrientation();
                setOrientationEventListener(1);
            } else
            {
                if ("portrait".equalsIgnoreCase(s))
                {
                    setInitiatePortraitOrientation();
                    setOrientationEventListener(0);
                    return;
                }
                if ("application".equalsIgnoreCase(s))
                {
                    setOrientationEventListener(2);
                    return;
                }
                if ("device".equalsIgnoreCase(s))
                {
                    if (isDeviceOrientationLocked())
                    {
                        setRequestedOrientation(1);
                        return;
                    } else
                    {
                        setOrientationEventListener(2);
                        return;
                    }
                }
            }
        }
    }

    private void hideActivityTitle()
    {
        requestWindowFeature(1);
    }

    private void hideActivtiyStatusBar()
    {
        getWindow().setFlags(1024, 1024);
    }

    private void initOrientationManager()
    {
        mOrientationManager = new OrientationManager(this, 3);
        Intent intent = getIntent();
        handleOrientationState(intent.getStringExtra("orientation_set_flag"), intent.getIntExtra("rotation_set_flag", 0));
    }

    private boolean isDeviceOrientationLocked()
    {
        return android.provider.Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    private void keepScreenOn()
    {
        runOnUiThread(new Runnable() {

            final ControllerActivity this$0;

            public void run()
            {
                getWindow().addFlags(128);
            }

            
            {
                this$0 = ControllerActivity.this;
                super();
            }
        });
    }

    private void removeWebViewContainerView()
    {
        if (mContainer != null)
        {
            ViewGroup viewgroup = (ViewGroup)mWebViewFrameContainer.getParent();
            if (viewgroup.findViewById(1) != null)
            {
                viewgroup.removeView(mWebViewFrameContainer);
            }
        }
    }

    private void setInitiateLandscapeOrientation()
    {
        int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
        Logger.i(TAG, "setInitiateLandscapeOrientation");
        if (i == 0)
        {
            Logger.i(TAG, "ROTATION_0");
            mOrientation = 0;
            setRequestedOrientation(0);
            return;
        }
        if (i == 2)
        {
            Logger.i(TAG, "ROTATION_180");
            mOrientation = 8;
            setRequestedOrientation(8);
            return;
        }
        if (i == 3)
        {
            Logger.i(TAG, "ROTATION_270 Right Landscape");
            mOrientation = 8;
            setRequestedOrientation(8);
            return;
        }
        if (i == 1)
        {
            Logger.i(TAG, "ROTATION_90 Left Landscape");
            mOrientation = 0;
            setRequestedOrientation(0);
            return;
        } else
        {
            Logger.i(TAG, "No Rotation");
            return;
        }
    }

    private void setInitiatePortraitOrientation()
    {
        int i = SDKUtils.getRotation(this);
        Logger.i(TAG, "setInitiatePortraitOrientation");
        if (i == 0)
        {
            Logger.i(TAG, "ROTATION_0");
            mOrientation = 1;
            setRequestedOrientation(1);
            return;
        }
        if (i == 2)
        {
            Logger.i(TAG, "ROTATION_180");
            mOrientation = 9;
            setRequestedOrientation(9);
            return;
        }
        if (i == 1)
        {
            Logger.i(TAG, "ROTATION_270 Right Landscape");
            mOrientation = 1;
            setRequestedOrientation(1);
            return;
        }
        if (i == 3)
        {
            Logger.i(TAG, "ROTATION_90 Left Landscape");
            mOrientation = 1;
            setRequestedOrientation(1);
            return;
        } else
        {
            Logger.i(TAG, "No Rotation");
            return;
        }
    }

    private void setOrientationEventListener(int i)
    {
        mOrientationType = i;
        Logger.i(TAG, (new StringBuilder()).append("setOrientationEventListener(").append(i).append(")").toString());
    }

    private void setRotation(int i)
    {
        if (i == 0)
        {
            Logger.i(TAG, "ROTATION_0");
            mOrientation = 1;
            setRequestedOrientation(1);
            return;
        }
        if (i == 2)
        {
            Logger.i(TAG, "ROTATION_180");
            mOrientation = 9;
            setRequestedOrientation(9);
            return;
        }
        if (i == 3)
        {
            Logger.i(TAG, "ROTATION_270 Right Landscape");
            mOrientation = 8;
            setRequestedOrientation(8);
            return;
        }
        if (i == 1)
        {
            Logger.i(TAG, "ROTATION_90 Left Landscape");
            mOrientation = 0;
            setRequestedOrientation(0);
            return;
        } else
        {
            Logger.i(TAG, "No Rotation");
            return;
        }
    }

    public void onBackPressed()
    {
        com.supersonicads.sdk.data.SSAEnums.BackButtonState backbuttonstate;
        Logger.i(TAG, "onBackPressed");
        backbuttonstate = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getBackButtonState();
        static class _cls4
        {

            static final int $SwitchMap$com$supersonicads$sdk$data$SSAEnums$BackButtonState[];

            static 
            {
                $SwitchMap$com$supersonicads$sdk$data$SSAEnums$BackButtonState = new int[com.supersonicads.sdk.data.SSAEnums.BackButtonState.values().length];
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$BackButtonState[com.supersonicads.sdk.data.SSAEnums.BackButtonState.None.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$BackButtonState[com.supersonicads.sdk.data.SSAEnums.BackButtonState.Device.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$BackButtonState[com.supersonicads.sdk.data.SSAEnums.BackButtonState.Controller.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.com.supersonicads.sdk.data.SSAEnums.BackButtonState[backbuttonstate.ordinal()];
        JVM INSTR tableswitch 1 3: default 52
    //                   1 52
    //                   2 53
    //                   3 58;
           goto _L1 _L1 _L2 _L3
_L1:
        return;
_L2:
        super.onBackPressed();
        return;
_L3:
        if (mWebViewController != null)
        {
            mWebViewController.nativeNavigationPressed("back");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Logger.i(TAG, "onCreate");
        hideActivityTitle();
        hideActivtiyStatusBar();
        mWebViewController = SupersonicAdsPublisherAgent.getInstance(this).getWebViewController();
        mWebViewController.setId(1);
        mWebViewController.setOnWebViewControllerChangeListener(this);
        mProductType = getIntent().getStringExtra("productType");
        if (!TextUtils.isEmpty(mProductType) && com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString().equalsIgnoreCase(mProductType))
        {
            if (bundle != null)
            {
                bundle = (AdUnitsState)bundle.getParcelable("state");
                if (bundle != null)
                {
                    mState = bundle;
                    mWebViewController.restoreState(bundle);
                }
                finish();
            } else
            {
                mState = mWebViewController.getSavedState();
            }
        }
        if (!TextUtils.isEmpty(mProductType) && com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString().equalsIgnoreCase(mProductType))
        {
            mWebViewController.setVideoEventsListener(this);
        }
        mContainer = new RelativeLayout(this);
        setContentView(mContainer, MATCH_PARENT_LAYOUT_PARAMS);
        mWebViewFrameContainer = mWebViewController.getLayout();
        if (mContainer.findViewById(1) == null && mWebViewFrameContainer.getParent() != null)
        {
            calledFromOnCreate = true;
            finish();
        }
        initOrientationManager();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Logger.i(TAG, "onDestroy");
        if (calledFromOnCreate)
        {
            removeWebViewContainerView();
        }
        if (mWebViewController != null)
        {
            mWebViewController.setState(SupersonicWebView.State.Gone);
            mWebViewController.removeVideoEventsListener();
        }
    }

    public void onHide()
    {
        runOnUiThread(new Runnable() {

            final ControllerActivity this$0;

            public void run()
            {
                finish();
            }

            
            {
                this$0 = ControllerActivity.this;
                super();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && mWebViewController.inCustomView())
        {
            mWebViewController.hideCustomView();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        Logger.i(TAG, "onPause");
        ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
        if (mWebViewController != null)
        {
            mWebViewController.unregisterConnectionReceiver(this);
            mWebViewController.pause();
            mWebViewController.viewableChange(false, "main");
        }
        removeWebViewContainerView();
        if (mOrientationManager != null)
        {
            mOrientationManager.disable();
        }
    }

    protected void onResume()
    {
        super.onResume();
        Logger.i(TAG, "onResume");
        mContainer.addView(mWebViewFrameContainer, MATCH_PARENT_LAYOUT_PARAMS);
        if (mWebViewController != null)
        {
            mWebViewController.registerConnectionReceiver(this);
            mWebViewController.resume();
            mWebViewController.viewableChange(true, "main");
        }
        if (mOrientationManager != null && mOrientationManager.canDetectOrientation())
        {
            mOrientationManager.enable();
        }
        ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (!TextUtils.isEmpty(mProductType) && com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString().equalsIgnoreCase(mProductType))
        {
            mState.setShouldRestore(true);
            bundle.putParcelable("state", mState);
        }
    }

    public void onSetOrientationCalled(String s, int i)
    {
        handleOrientationState(s, i);
    }

    protected void onUserLeaveHint()
    {
        super.onUserLeaveHint();
        Logger.i(TAG, "onUserLeaveHint");
    }

    public void onVideoEnded()
    {
        toggleKeepScreen(false);
    }

    public void onVideoPaused()
    {
        toggleKeepScreen(false);
    }

    public void onVideoResumed()
    {
        toggleKeepScreen(true);
    }

    public void onVideoStarted()
    {
        toggleKeepScreen(true);
    }

    public void onVideoStopped()
    {
        toggleKeepScreen(false);
    }

    public void setRequestedOrientation(int i)
    {
        if (currentRequestedRotation != i)
        {
            Logger.i(TAG, (new StringBuilder()).append("Rotation: Req = ").append(i).append(" Curr = ").append(currentRequestedRotation).toString());
            currentRequestedRotation = i;
            super.setRequestedOrientation(i);
        }
    }

    public void toggleKeepScreen(boolean flag)
    {
        if (flag)
        {
            keepScreenOn();
            return;
        } else
        {
            cancelScreenOn();
            return;
        }
    }




/*
    static int access$002(ControllerActivity controlleractivity, int i)
    {
        controlleractivity.mOrientation = i;
        return i;
    }

*/
}
