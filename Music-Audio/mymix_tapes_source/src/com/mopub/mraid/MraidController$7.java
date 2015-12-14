// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.mopub.mraid:
//            MraidController, MraidScreenMetrics, MraidBridge

class val.successRunnable
    implements Runnable
{

    final MraidController this$0;
    final View val$currentWebView;
    final Runnable val$successRunnable;

    public void run()
    {
        DisplayMetrics displaymetrics = MraidController.access$600(MraidController.this).getResources().getDisplayMetrics();
        MraidController.access$1100(MraidController.this).setScreenSize(displaymetrics.widthPixels, displaymetrics.heightPixels);
        int ai[] = new int[2];
        android.view.ViewGroup viewgroup = MraidController.access$1200(MraidController.this);
        viewgroup.getLocationOnScreen(ai);
        MraidController.access$1100(MraidController.this).setRootViewPosition(ai[0], ai[1], viewgroup.getWidth(), viewgroup.getHeight());
        MraidController.access$1300(MraidController.this).getLocationOnScreen(ai);
        MraidController.access$1100(MraidController.this).setDefaultAdPosition(ai[0], ai[1], MraidController.access$1300(MraidController.this).getWidth(), MraidController.access$1300(MraidController.this).getHeight());
        val$currentWebView.getLocationOnScreen(ai);
        MraidController.access$1100(MraidController.this).setCurrentAdPosition(ai[0], ai[1], val$currentWebView.getWidth(), val$currentWebView.getHeight());
        MraidController.access$200(MraidController.this).notifyScreenMetrics(MraidController.access$1100(MraidController.this));
        if (MraidController.access$100(MraidController.this).isAttached())
        {
            MraidController.access$100(MraidController.this).notifyScreenMetrics(MraidController.access$1100(MraidController.this));
        }
        if (val$successRunnable != null)
        {
            val$successRunnable.run();
        }
    }

    ()
    {
        this$0 = final_mraidcontroller;
        val$currentWebView = view;
        val$successRunnable = Runnable.this;
        super();
    }
}
