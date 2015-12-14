// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            ActivityIndicatorCheckThread, NetworkIndicator, LoadingSpinner

private class networkConnectivity
    implements Runnable
{

    private GridStatus gridStatus;
    private LoadingSpinner loadingSpinner;
    private NetworkConnectivity networkConnectivity;
    final ActivityIndicatorCheckThread this$0;

    public void onDestroy()
    {
        ActivityIndicatorCheckThread.access$000(ActivityIndicatorCheckThread.this).onDestroy();
    }

    public void run()
    {
        boolean flag2 = networkConnectivity.hasExceededErrorLimit();
        boolean flag1 = networkConnectivity.isNetworkConnected();
        this._cls0 _lcls0;
        NetworkIndicator networkindicator;
        boolean flag;
        if (flag1 && flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag2 = gridStatus.isLoading();
        if (!flag1 || flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        networkindicator = ActivityIndicatorCheckThread.access$000(ActivityIndicatorCheckThread.this);
        if (flag)
        {
            _lcls0 = this._fld0;
        } else
        {
            _lcls0 = this._fld0;
        }
        networkindicator.showIndicator(flag1, _lcls0);
        if (!flag1 && flag2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        loadingSpinner.showSpinner(flag1);
    }

    public (NetworkConnectivity networkconnectivity, GridStatus gridstatus, LoadingSpinner loadingspinner)
    {
        this$0 = ActivityIndicatorCheckThread.this;
        super();
        gridStatus = gridstatus;
        loadingSpinner = loadingspinner;
        networkConnectivity = networkconnectivity;
    }
}
