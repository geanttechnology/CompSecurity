// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ebay.mobile.service.AppForegroundService;
import com.ebay.nautilus.shell.app.ActivityShim;

public class AppForegroundShim extends ActivityShim
    implements ServiceConnection
{

    private boolean bound;

    public AppForegroundShim()
    {
    }

    protected void onPause()
    {
        if (bound)
        {
            bound = false;
            getActivity().unbindService(this);
        }
        super.onPause();
    }

    protected void onResume()
    {
        Activity activity = getActivity();
        bound = activity.bindService(new Intent(activity, com/ebay/mobile/service/AppForegroundService), this, 1);
        super.onResume();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }
}
