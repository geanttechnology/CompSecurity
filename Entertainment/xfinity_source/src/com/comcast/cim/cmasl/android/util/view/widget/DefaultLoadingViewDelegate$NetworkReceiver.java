// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            DefaultLoadingViewDelegate

public class this._cls0 extends BroadcastReceiver
{

    final DefaultLoadingViewDelegate this$0;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = intent.getBooleanExtra("noConnectivity", false);
        if (!firstTimeLoadStarted)
        {
            firstTimeLoadStarted = true;
            loadingProgressBar.setVisibility(0);
            loadingInfoText.setVisibility(4);
            loadingRetryButton.setVisibility(8);
            startLoading();
        } else
        {
            if (flag)
            {
                DefaultLoadingViewDelegate.access$000().debug("onReceive: NOT connected");
                return;
            }
            if (!resourcesLoaded)
            {
                loadingProgressBar.setVisibility(0);
                loadingInfoText.setVisibility(4);
                loadingRetryButton.setVisibility(8);
                startLoading();
                return;
            }
        }
    }

    public ()
    {
        this$0 = DefaultLoadingViewDelegate.this;
        super();
    }
}
