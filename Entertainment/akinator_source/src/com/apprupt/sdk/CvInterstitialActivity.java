// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.apprupt.sdk.adview.ExpandProperties;
import com.apprupt.sdk.adview.Orientation;
import com.apprupt.sdk.adview.OrientationProperties;
import java.util.HashMap;
import java.util.Timer;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvViewHelper, CvCloseButton, CvInterstitialAdWrapper, 
//            CvMediator, CvContentOptions, CvContext

public class CvInterstitialActivity extends Activity
{
    private static final class DummyListener
        implements CvSDK.CvInterstitialListener
    {

        public void cvInterstitialDidAppear(int i)
        {
        }

        public void cvInterstitialDidDisappear(int i)
        {
        }

        public void cvInterstitialDidFail(int i, String s, int j)
        {
        }

        public void cvInterstitialFirstTap()
        {
        }

        public void cvInterstitialWillAppear(int i)
        {
        }

        public void cvInterstitialWillDisappear(int i)
        {
        }

        private DummyListener()
        {
        }

    }


    private static int idCounter = 0;
    private static final Logger.log llog = Logger.get("Lifecycle.Interstitial");
    private static final Logger.log log = Logger.get("INTERSTITIAL");
    private static final HashMap transport = new HashMap();
    private int adSpaceId;
    private Runnable clickClose;
    private CvCloseButton closeButton;
    private Runnable closeHandler;
    private long lastTimestamp;
    private CvSDK.CvInterstitialListener listener;
    private RelativeLayout mLayout;
    private Timer mTimer;
    private long timeOnScreeen;
    private boolean visible;

    public CvInterstitialActivity()
    {
        mTimer = null;
        adSpaceId = -1;
        closeButton = null;
        closeHandler = null;
        listener = null;
        timeOnScreeen = 0L;
        lastTimestamp = 0L;
        visible = false;
        clickClose = new Runnable() {

            final CvInterstitialActivity this$0;

            public void run()
            {
                if (getTimeOnScreeen() < 2000L)
                {
                    return;
                }
                if (closeHandler != null)
                {
                    closeHandler.run();
                } else
                {
                    finish();
                }
                closeHandler = null;
            }

            
            {
                this$0 = CvInterstitialActivity.this;
                super();
            }
        };
    }

    static CvSDK.CvInterstitialListener anyListener(CvSDK.CvInterstitialListener cvinterstitiallistener)
    {
        if (cvinterstitiallistener != null)
        {
            return cvinterstitiallistener;
        } else
        {
            return new DummyListener();
        }
    }

    static void start(Context context, CvInterstitialAdWrapper cvinterstitialadwrapper)
    {
        CvViewHelper.runOnUIThread(new Runnable(cvinterstitialadwrapper, context) {

            final Context val$context;
            final CvInterstitialAdWrapper val$wrapper;

            public void run()
            {
                int i = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                wrapper = cvinterstitialadwrapper;
                context = context1;
                super();
            }
        }, true);
    }

    void changeBackgroundColor(int i)
    {
        mLayout.setBackgroundColor(i);
    }

    void changeCloseButtonVisibility(boolean flag)
    {
        CvCloseButton cvclosebutton = closeButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        cvclosebutton.setVisibility(i);
    }

    public long getTimeOnScreeen()
    {
        if (visible)
        {
            return (System.currentTimeMillis() - lastTimestamp) + timeOnScreeen;
        } else
        {
            return timeOnScreeen;
        }
    }

    public void onBackPressed()
    {
        clickClose.run();
    }

    protected void onCreate(Bundle bundle)
    {
        int i;
        onCreate(bundle);
        llog.i(new Object[] {
            "onCreate..."
        });
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        byte byte0 = -1;
        bundle = getIntent();
        i = byte0;
        if (bundle != null)
        {
            bundle = bundle.getExtras();
            i = byte0;
            if (bundle != null)
            {
                i = bundle.getInt("interstitialId", -1);
            }
        }
        Object obj = null;
        bundle = ((Bundle) (obj));
        if (i > 0)
        {
            bundle = ((Bundle) (obj));
            if (transport.containsKey(Integer.valueOf(i)))
            {
                bundle = (CvInterstitialAdWrapper)transport.remove(Integer.valueOf(i));
            }
        }
        if (bundle == null)
        {
            llog.e(new Object[] {
                "Cannot find intestitial data.. quiting"
            });
            finish();
            return;
        }
        mLayout = new RelativeLayout(this);
        setContentView(mLayout);
        listener = anyListener(bundle.getMediator().getContentOptions().interstitialListener);
        adSpaceId = Integer.valueOf(bundle.getMediator().getAdSpaceId()).intValue();
        obj = bundle.getView();
        ((View) (obj)).setBackgroundColor(0);
        ((CvContext)((View) (obj)).getContext()).swapContext(this);
        ((View) (obj)).setId(0xf42bb);
        mLayout.addView(((View) (obj)));
        obj = bundle.getExpandProperties();
        closeHandler = bundle.closeButtonHandler();
        closeButton = new CvCloseButton(this);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CvInterstitialActivity this$0;

            public void onClick(View view)
            {
                runOnUiThread(clickClose);
            }

            
            {
                this$0 = CvInterstitialActivity.this;
                super();
            }
        });
        CvCloseButton cvclosebutton = closeButton;
        if (((ExpandProperties) (obj)).getUseCustomClose())
        {
            i = 8;
        } else
        {
            i = 0;
        }
        cvclosebutton.setVisibility(i);
        i = CvViewHelper.dp2px(CvCloseButton.size);
        obj = new LayoutParams(i, i);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, 0xf42bb);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0xf42bb);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(-i, 0, 0, -i);
        closeButton.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mLayout.addView(closeButton);
        bundle.setActivity(this);
        bundle.setListener(new com.apprupt.sdk.mediation.InterstitialAdWrapper.Listener() {

            final CvInterstitialActivity this$0;

            public void onCloseAd()
            {
                finish();
            }

            public void onFirstTap()
            {
                if (listener != null)
                {
                    listener.cvInterstitialFirstTap();
                }
            }

            public void onKillSpace()
            {
                finish();
            }

            
            {
                this$0 = CvInterstitialActivity.this;
                super();
            }
        });
        bundle = bundle.getOrientationProperties();
        obj = bundle.getForceOrientation();
        if (obj == Orientation.NONE) goto _L2; else goto _L1
_L1:
        if (obj == Orientation.LANDSCAPE)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        setRequestedOrientation(i);
_L4:
        listener.cvInterstitialWillAppear(adSpaceId);
        return;
_L2:
        if (!bundle.getAllowOrientationChange())
        {
            setRequestedOrientation(getResources().getConfiguration().orientation);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDestroy()
    {
        onDestroy();
        listener.cvInterstitialDidDisappear(adSpaceId);
    }

    protected void onPause()
    {
        onPause();
        timeOnScreeen = System.currentTimeMillis() - lastTimestamp;
        visible = false;
        listener.cvInterstitialWillDisappear(adSpaceId);
    }

    protected void onResume()
    {
        onResume();
        lastTimestamp = System.currentTimeMillis();
        visible = true;
        listener.cvInterstitialDidAppear(adSpaceId);
    }




/*
    static Runnable access$002(CvInterstitialActivity cvinterstitialactivity, Runnable runnable)
    {
        cvinterstitialactivity.closeHandler = runnable;
        return runnable;
    }

*/



/*
    static int access$104()
    {
        int i = idCounter + 1;
        idCounter = i;
        return i;
    }

*/




}
