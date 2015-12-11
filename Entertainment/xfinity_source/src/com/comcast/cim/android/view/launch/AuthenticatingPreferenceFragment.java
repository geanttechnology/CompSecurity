// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.Activity;
import android.preference.PreferenceFragment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticatingFragment, AuthenticatingPreferenceActivity

public class AuthenticatingPreferenceFragment extends PreferenceFragment
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/launch/AuthenticatingFragment);
    private AuthenticatingPreferenceActivity authenticatingActivity;

    public AuthenticatingPreferenceFragment()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            authenticatingActivity = (AuthenticatingPreferenceActivity)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new IllegalArgumentException("AuthenticatingPreferenceFragment cannot be added to an activity that does not extend from AuthenticatingPreferenceFragment.", activity);
        }
    }

    public final void onResume()
    {
        super.onResume();
        LOG.debug("onResume");
        if (authenticatingActivity.isAuthenticated())
        {
            onResumeInternal();
        }
    }

    protected void onResumeInternal()
    {
    }

    public final void onStart()
    {
        super.onStart();
        LOG.debug("onStart");
        if (authenticatingActivity.isAuthenticated())
        {
            onStartInternal();
            return;
        } else
        {
            LOG.warn("onStart() is a NOOP!");
            return;
        }
    }

    protected void onStartInternal()
    {
    }

}
