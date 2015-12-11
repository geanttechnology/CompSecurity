// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            LoadingViewDelegate, LoadingIndicator

public class DefaultLoadingViewDelegate
    implements LoadingViewDelegate
{
    public class NetworkReceiver extends BroadcastReceiver
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
                    DefaultLoadingViewDelegate.LOG.debug("onReceive: NOT connected");
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

        public NetworkReceiver()
        {
            this$0 = DefaultLoadingViewDelegate.this;
            super();
        }
    }

    public static interface ReadyListener
    {

        public abstract void onReady();
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate);
    private Activity activity;
    private final ViewGroup bodyContainer;
    protected boolean firstTimeLoadStarted;
    private final InternetConnection internetConnection;
    private final LoadingIndicator loadingIndicator;
    protected TextView loadingInfoText;
    protected ProgressBar loadingProgressBar;
    protected Button loadingRetryButton;
    protected BroadcastReceiver networkReceiver;
    private ReadyListener readyListener;
    protected boolean receiverRegistered;
    protected boolean resourcesLoaded;

    public DefaultLoadingViewDelegate(Activity activity1, ViewGroup viewgroup, LoadingIndicator loadingindicator, InternetConnection internetconnection, ReadyListener readylistener)
    {
        networkReceiver = new NetworkReceiver();
        activity = activity1;
        loadingIndicator = loadingindicator;
        bodyContainer = viewgroup;
        readyListener = readylistener;
        internetConnection = internetconnection;
        setup();
    }

    public boolean firstTimeLoadStarted()
    {
        return firstTimeLoadStarted;
    }

    public void onLoadingFailed()
    {
        onLoadingFailed(com.comcast.cim.cmasl.android.util.R.string.loading_exception);
    }

    public void onLoadingFailed(int i)
    {
label0:
        {
            if (!resourcesLoaded)
            {
                if (!internetConnection.isConnected())
                {
                    break label0;
                }
                loadingInfoText.setText(activity.getResources().getString(i));
                loadingInfoText.setVisibility(0);
                loadingRetryButton.setVisibility(0);
                loadingProgressBar.setVisibility(4);
            }
            return;
        }
        loadingInfoText.setText(activity.getResources().getString(com.comcast.cim.cmasl.android.util.R.string.waiting_for_internet));
        loadingInfoText.setVisibility(0);
    }

    public void onLoadingFinished()
    {
        if (loadingIndicator != null)
        {
            loadingIndicator.setVisibility(8);
            bodyContainer.setVisibility(0);
        }
        resourcesLoaded = true;
    }

    public void onLoadingStarted()
    {
        if (loadingIndicator != null)
        {
            loadingIndicator.setVisibility(0);
            bodyContainer.setVisibility(8);
        }
    }

    public void onStart()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        activity.registerReceiver(networkReceiver, intentfilter);
        receiverRegistered = true;
    }

    public void onStop()
    {
        firstTimeLoadStarted = false;
        if (receiverRegistered)
        {
            activity.unregisterReceiver(networkReceiver);
            receiverRegistered = false;
        }
    }

    public boolean resourcesLoaded()
    {
        return resourcesLoaded;
    }

    public void setNetworkReceiver(BroadcastReceiver broadcastreceiver)
    {
        networkReceiver = broadcastreceiver;
    }

    public void setup()
    {
        loadingInfoText = (TextView)loadingIndicator.findViewById(com.comcast.cim.cmasl.android.util.R.id.loading_info_text);
        loadingRetryButton = (Button)loadingIndicator.findViewById(com.comcast.cim.cmasl.android.util.R.id.loading_retry_button);
        loadingRetryButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DefaultLoadingViewDelegate this$0;

            public void onClick(View view)
            {
                loadingProgressBar.setVisibility(0);
                loadingInfoText.setVisibility(4);
                loadingRetryButton.setVisibility(8);
                startLoading();
            }

            
            {
                this$0 = DefaultLoadingViewDelegate.this;
                super();
            }
        });
        loadingProgressBar = (ProgressBar)loadingIndicator.findViewById(com.comcast.cim.cmasl.android.util.R.id.loading_progressbar);
    }

    public void startLoading()
    {
        onLoadingStarted();
        readyListener.onReady();
    }


}
