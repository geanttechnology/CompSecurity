// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.content.Context;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.AdMetadata;
import com.millennialmedia.internal.adcontrollers.WebController;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            InterstitialAdapter

public class InterstitialWebAdapter extends InterstitialAdapter
{

    private static final String TAG = com/millennialmedia/internal/adadapters/InterstitialWebAdapter.getSimpleName();
    com.millennialmedia.internal.adcontrollers.WebController.WebControllerListener controllerListener;
    WebController webController;

    public InterstitialWebAdapter()
    {
        controllerListener = new com.millennialmedia.internal.adcontrollers.WebController.WebControllerListener() {

            final InterstitialWebAdapter this$0;

            public void attachFailed()
            {
                adapterListener.showFailed(new com.millennialmedia.InterstitialAd.InterstitialErrorStatus(7, "Unable to start interstitial activity"));
            }

            public void attachSucceeded()
            {
            }

            public void initFailed()
            {
                adapterListener.initFailed();
            }

            public void initSucceeded()
            {
                adapterListener.initSucceeded();
            }

            public void onAdLeftApplication()
            {
                adapterListener.onAdLeftApplication();
            }

            public void onClicked()
            {
                adapterListener.onClicked();
            }

            public void onCollapsed()
            {
                adapterListener.onClosed();
            }

            public void onExpanded()
            {
                adapterListener.shown();
            }

            public void onResize(int i, int j)
            {
            }

            public void onResized(int i, int j, boolean flag)
            {
                if (flag)
                {
                    adapterListener.onClosed();
                }
            }

            
            {
                this$0 = InterstitialWebAdapter.this;
                super();
            }
        };
    }

    public void init(Context context, InterstitialAdapter.InterstitialAdapterListener interstitialadapterlistener)
    {
        adapterListener = interstitialadapterlistener;
        webController = new WebController(context, true, adContent, adMetadata, controllerListener);
    }

    public void show(Context context, com.millennialmedia.InterstitialAd.DisplayOptions displayoptions)
    {
        context = displayoptions;
        if (displayoptions == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Display options not specified, using defaults.");
            }
            context = new com.millennialmedia.InterstitialAd.DisplayOptions();
        }
        context = (new com.millennialmedia.internal.MMActivity.MMActivityConfig()).setImmersive(((com.millennialmedia.InterstitialAd.DisplayOptions) (context)).immersive).setTransitionAnimation(((com.millennialmedia.InterstitialAd.DisplayOptions) (context)).enterAnimationId, ((com.millennialmedia.InterstitialAd.DisplayOptions) (context)).exitAnimationId);
        boolean flag;
        if (adMetadata != null && adMetadata.isTransparent())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context = context.setTransparent(flag);
        webController.showExpanded(context);
    }

}
