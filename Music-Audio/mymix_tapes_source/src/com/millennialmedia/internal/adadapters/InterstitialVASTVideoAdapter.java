// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.content.Context;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMActivity;
import com.millennialmedia.internal.adcontrollers.VASTVideoController;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            InterstitialAdapter

public class InterstitialVASTVideoAdapter extends InterstitialAdapter
{

    private static final String TAG = com/millennialmedia/internal/adadapters/InterstitialVASTVideoAdapter.getSimpleName();
    private volatile boolean attached;
    private VASTVideoController vastVideoController;
    com.millennialmedia.internal.adcontrollers.VASTVideoController.VASTVideoControllerListener vastVideoControllerListener;

    public InterstitialVASTVideoAdapter()
    {
        vastVideoControllerListener = new com.millennialmedia.internal.adcontrollers.VASTVideoController.VASTVideoControllerListener() {

            final InterstitialVASTVideoAdapter this$0;

            public void attachFailed()
            {
                if (!attached)
                {
                    adapterListener.showFailed(new com.millennialmedia.InterstitialAd.InterstitialErrorStatus(7));
                }
            }

            public void attachSucceeded()
            {
                if (!attached)
                {
                    attached = true;
                    adapterListener.shown();
                }
            }

            public void initFailed()
            {
                adapterListener.initFailed();
            }

            public void initSucceeded()
            {
                adapterListener.initSucceeded();
            }

            public void onClick()
            {
                adapterListener.onClicked();
            }

            
            {
                this$0 = InterstitialVASTVideoAdapter.this;
                super();
            }
        };
    }

    public void init(Context context, InterstitialAdapter.InterstitialAdapterListener interstitialadapterlistener)
    {
        adapterListener = interstitialadapterlistener;
        vastVideoController = new VASTVideoController(context, adContent, vastVideoControllerListener);
    }

    public void show(Context context, com.millennialmedia.InterstitialAd.DisplayOptions displayoptions)
    {
        com.millennialmedia.InterstitialAd.DisplayOptions displayoptions1 = displayoptions;
        if (displayoptions == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Display options not specified, using defaults.");
            }
            displayoptions1 = (new com.millennialmedia.InterstitialAd.DisplayOptions()).setImmersive(true);
        }
        MMActivity.launch(context, (new com.millennialmedia.internal.MMActivity.MMActivityConfig()).setImmersive(displayoptions1.immersive), new com.millennialmedia.internal.MMActivity.MMActivityListener() {

            final InterstitialVASTVideoAdapter this$0;

            public boolean onBackPressed()
            {
                return vastVideoController.onBackPressed();
            }

            public void onCreate(MMActivity mmactivity)
            {
                vastVideoController.attach(mmactivity);
            }

            public void onDestroy(MMActivity mmactivity)
            {
                if (mmactivity.isFinishing())
                {
                    vastVideoController.shutdown();
                    adapterListener.onClosed();
                }
            }

            
            {
                this$0 = InterstitialVASTVideoAdapter.this;
                super();
            }
        });
    }




/*
    static boolean access$002(InterstitialVASTVideoAdapter interstitialvastvideoadapter, boolean flag)
    {
        interstitialvastvideoadapter.attached = flag;
        return flag;
    }

*/

}
