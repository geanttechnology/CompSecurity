// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.smartadserver.android.library.SASBannerView;

// Referenced classes of package com.intentsoftware.addapptr.fullscreens:
//            SmartAdServerFullscreen, CloseDrawable

public class SmartAdServerFullscreenActivity extends Activity
{

    public static final int CLOSE_BUTTON_SIZE = 38;
    public static final String SMART_AD_SERVER_CLICKED = "SMART_AD_SERVER_CLICKED";
    public static final String SMART_AD_SERVER_FAILED = "SMART_AD_SERVER_FAILED";
    public static final String SMART_AD_SERVER_FINISH = "SMART_AD_SERVER_FINISH";
    private Intent intent;
    private SASBannerView interstitialView;
    private boolean reportedClick;
    private boolean shouldSkipViewRemoval;

    public SmartAdServerFullscreenActivity()
    {
    }

    private com.smartadserver.android.library.ui.SASAdView.OnStateChangeListener createStateChangeListener()
    {
        return new com.smartadserver.android.library.ui.SASAdView.OnStateChangeListener() {

            final SmartAdServerFullscreenActivity this$0;

            public void onStateChanged(com.smartadserver.android.library.ui.SASAdView.StateChangeEvent statechangeevent)
            {
                if (statechangeevent.getType() == 2)
                {
                    interstitialView.close();
                    shouldSkipViewRemoval = true;
                    finishActivity();
                }
            }

            
            {
                this$0 = SmartAdServerFullscreenActivity.this;
                super();
            }
        };
    }

    private android.view.View.OnTouchListener createTouchListener()
    {
        return new android.view.View.OnTouchListener() {

            final SmartAdServerFullscreenActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    view.performClick();
                }
                if (!reportedClick)
                {
                    reportedClick = true;
                    intent = new Intent();
                    intent.setAction("SMART_AD_SERVER_CLICKED");
                    sendBroadcast(intent);
                }
                return false;
            }

            
            {
                this$0 = SmartAdServerFullscreenActivity.this;
                super();
            }
        };
    }

    private void finishActivity()
    {
        if (interstitialView != null && !shouldSkipViewRemoval)
        {
            ViewGroup viewgroup = (ViewGroup)interstitialView.getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(interstitialView);
            }
        }
        intent = new Intent();
        intent.setAction("SMART_AD_SERVER_FINISH");
        sendBroadcast(intent);
        finish();
    }

    public void onBackPressed()
    {
        finishActivity();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
    }

    protected void onDestroy()
    {
        if (interstitialView != null)
        {
            interstitialView.onDestroy();
        }
        super.onDestroy();
    }

    protected void onStart()
    {
        super.onStart();
        interstitialView = SmartAdServerFullscreen.interstitialView;
        if (interstitialView != null)
        {
            Object obj = (ViewGroup)interstitialView.getParent();
            if (obj != null)
            {
                ((ViewGroup) (obj)).removeView(interstitialView);
            }
            obj = new ImageView(this);
            ((ImageView) (obj)).setBackgroundDrawable(new CloseDrawable(true));
            ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final SmartAdServerFullscreenActivity this$0;

                public void onClick(View view1)
                {
                    interstitialView.close();
                    finishActivity();
                }

            
            {
                this$0 = SmartAdServerFullscreenActivity.this;
                super();
            }
            });
            float f = getResources().getDisplayMetrics().density;
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(38F * f), (int)(38F * f));
            layoutparams.addRule(11);
            View view = new View(this);
            view.setOnTouchListener(createTouchListener());
            interstitialView.addView(view, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            interstitialView.removeCloseButton();
            interstitialView.addView(((View) (obj)), layoutparams);
            interstitialView.addStateChangeListener(createStateChangeListener());
            setContentView(interstitialView);
            return;
        } else
        {
            intent = new Intent();
            intent.setAction("SMART_AD_SERVER_FAILED");
            sendBroadcast(intent);
            finishActivity();
            return;
        }
    }




/*
    static boolean access$202(SmartAdServerFullscreenActivity smartadserverfullscreenactivity, boolean flag)
    {
        smartadserverfullscreenactivity.shouldSkipViewRemoval = flag;
        return flag;
    }

*/



/*
    static boolean access$302(SmartAdServerFullscreenActivity smartadserverfullscreenactivity, boolean flag)
    {
        smartadserverfullscreenactivity.reportedClick = flag;
        return flag;
    }

*/



/*
    static Intent access$402(SmartAdServerFullscreenActivity smartadserverfullscreenactivity, Intent intent1)
    {
        smartadserverfullscreenactivity.intent = intent1;
        return intent1;
    }

*/
}
