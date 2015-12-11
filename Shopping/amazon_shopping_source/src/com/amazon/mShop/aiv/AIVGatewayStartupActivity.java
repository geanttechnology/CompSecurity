// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.UIUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.aiv:
//            AIVAvailabilityUtils, LastAsinPlayHolder

public class AIVGatewayStartupActivity extends AmazonActivity
{
    private static class LaunchGatewayOnAIVInitialization
        implements Runnable
    {

        private final WeakReference mCallerActivity;

        public void run()
        {
            if (mCallerActivity.get() != null)
            {
                AIVAvailabilityUtils.waitForAIVInitialize();
                AIVGatewayStartupActivity aivgatewaystartupactivity = (AIVGatewayStartupActivity)mCallerActivity.get();
                if (aivgatewaystartupactivity != null)
                {
                    aivgatewaystartupactivity.runOnUiThread(aivgatewaystartupactivity. new _cls1LaunchAIVGatewayTask());
                    return;
                }
            }
        }

        private LaunchGatewayOnAIVInitialization(AIVGatewayStartupActivity aivgatewaystartupactivity)
        {
            if (aivgatewaystartupactivity == null)
            {
                throw new IllegalArgumentException("AIVGatewayStartupActivity cannot be null.");
            } else
            {
                mCallerActivity = new WeakReference(aivgatewaystartupactivity);
                return;
            }
        }

    }

    class LaunchGatewayOnAIVInitialization._cls1LaunchAIVGatewayTask
        implements Runnable
    {

        final LaunchGatewayOnAIVInitialization this$0;
        final AIVGatewayStartupActivity val$activity;

        public void run()
        {
            if (!activity.isFinishing())
            {
                activity.launchAIVGatewayPage();
            }
        }

        LaunchGatewayOnAIVInitialization._cls1LaunchAIVGatewayTask()
        {
            this$0 = final_launchgatewayonaivinitialization;
            activity = AIVGatewayStartupActivity.this;
            super();
        }
    }


    private static final String REFMARKER_LAUNCH_FROM_AIV_APP = "aiv_aw_app_open";
    private static final String SOURCE_COMPANION_APP_EXTRA = "SOURCE_AIV_COMPANION_APP";

    public AIVGatewayStartupActivity()
    {
    }

    private void launchAIVGatewayPage()
    {
        if (AIVAvailabilityUtils.isAIVAvailable())
        {
            finish();
            redirectVideoAsin();
            return;
        } else
        {
            finish();
            ActivityUtils.startHomeActivity(this);
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final AIVGatewayStartupActivity this$0;

                public void run()
                {
                    UIUtils.info((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.aiv_unavailable);
                }

            
            {
                this$0 = AIVGatewayStartupActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void redirectVideoAsin()
    {
        boolean flag = getIntent().getBooleanExtra("SOURCE_AIV_COMPANION_APP", false);
        String s = LastAsinPlayHolder.getInstance().takeAsin();
        if (flag && s != null)
        {
            ActivityUtils.launchDetailsPage(this, new ProductController(s, ClickStreamTag.ORIGIN_DEFAULT), new int[0]);
            return;
        }
        if (flag)
        {
            s = "aiv_aw_app_open";
        } else
        {
            s = null;
        }
        ActivityUtils.startAIVGatewayActivity(this, s, -1);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        pushView(com.amazon.mShop.android.lib.R.layout.splash_screen);
        bundle = Executors.newSingleThreadExecutor();
        bundle.submit(new LaunchGatewayOnAIVInitialization(this));
        bundle.shutdown();
        return;
        Exception exception;
        exception;
        bundle.shutdown();
        throw exception;
    }

}
