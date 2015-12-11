// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.content.Intent;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.model.user.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticationLauncher, AuthenticatingActivityDelegate

public abstract class AuthenticatingActivity extends BaseActivity
    implements AuthenticatingActivityDelegate.InternalLifecycleRunner, AuthenticationLauncher
{

    private final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/launch/AuthenticatingActivity);
    AuthenticatingActivityDelegate authenticatingActivityDelegate;

    public AuthenticatingActivity()
    {
        authenticatingActivityDelegate = CALContainer.getInstance().getAuthenticatingActivityDelegate(this, this);
    }

    protected abstract UserManager getUserManager();

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        authenticatingActivityDelegate.onActivityResult(i, j, intent);
    }

    protected void onPause()
    {
        super.onPause();
        LOG.debug("onPause");
        authenticatingActivityDelegate.onPause();
    }

    public final void onResume()
    {
        super.onResume();
        LOG.debug("onResume");
        authenticatingActivityDelegate.onResume();
    }

    public void onResumeInternal()
    {
    }

    public final void onStart()
    {
        super.onStart();
        LOG.debug("onStart");
        authenticatingActivityDelegate.onStart();
    }

    public void onStartInternal()
    {
    }
}
