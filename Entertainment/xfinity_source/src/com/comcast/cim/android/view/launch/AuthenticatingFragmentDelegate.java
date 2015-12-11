// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.Activity;
import com.comcast.cim.android.authentication.AuthenticationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticationLauncher

public class AuthenticatingFragmentDelegate
{
    public static interface InternalLifecycleRunner
    {

        public abstract void onResumeInternal();

        public abstract void onStartInternal();
    }


    protected final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate);
    private AuthenticationLauncher authLauncher;
    private final AuthenticationStrategy authStrategy;
    private final InternalLifecycleRunner internalLifecycleRunner;

    public AuthenticatingFragmentDelegate(InternalLifecycleRunner internallifecyclerunner, AuthenticationStrategy authenticationstrategy)
    {
        internalLifecycleRunner = internallifecyclerunner;
        authStrategy = authenticationstrategy;
    }

    public void onAttach(Activity activity)
    {
        try
        {
            authLauncher = (AuthenticationLauncher)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new IllegalArgumentException("Cannot be attached to an activity that does not implement AuthenticationLauncher.", activity);
        }
    }

    public void onResume()
    {
        if (authStrategy.isAuthenticated())
        {
            internalLifecycleRunner.onResumeInternal();
            return;
        } else
        {
            LOG.warn("Skipping onResumeInternal because we are not authenticated");
            return;
        }
    }

    public void onStart()
    {
        if (authStrategy.isAuthenticated())
        {
            internalLifecycleRunner.onStartInternal();
            return;
        } else
        {
            LOG.warn("Skipping onStartInternal because we are not authenticated");
            return;
        }
    }
}
