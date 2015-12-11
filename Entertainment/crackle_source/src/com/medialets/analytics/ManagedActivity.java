// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.medialets.analytics:
//            MMAnalyticsManager

public abstract class ManagedActivity extends Activity
{

    protected MMAnalyticsManager mManager;
    protected boolean useTestServer;

    public ManagedActivity()
    {
    }

    public abstract String getAppVersion();

    public abstract String getMMAppID();

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mManager = MMAnalyticsManager.sharedInstance(this);
        mManager.start(getMMAppID(), getAppVersion(), useLocation());
    }

    public void onDestroy()
    {
        super.onDestroy();
        mManager.stop();
    }

    public void onPause()
    {
        super.onPause();
        mManager.pause();
    }

    public void onRestart()
    {
        super.onRestart();
    }

    public void onResume()
    {
        super.onResume();
        mManager.resume();
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
    }

    public abstract boolean useLocation();
}
