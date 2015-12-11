// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.Activity;
import android.app.Fragment;
import android.os.Handler;
import android.view.View;
import com.comcast.cim.container.CALContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticatingFragmentDelegate

public abstract class AuthenticatingFragment extends Fragment
    implements AuthenticatingFragmentDelegate.InternalLifecycleRunner
{

    protected final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/launch/AuthenticatingFragment);
    private AuthenticatingFragmentDelegate authenticatingFragmentDelegate;
    protected Handler handler;

    public AuthenticatingFragment()
    {
        authenticatingFragmentDelegate = CALContainer.getInstance().getAuthenticatingFragmentDelegate(this);
        handler = new Handler();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        authenticatingFragmentDelegate.onAttach(activity);
    }

    public final void onResume()
    {
        super.onResume();
        LOG.debug("onResume");
        authenticatingFragmentDelegate.onResume();
    }

    public void onResumeInternal()
    {
    }

    public final void onStart()
    {
        super.onStart();
        LOG.debug("onStart");
        authenticatingFragmentDelegate.onStart();
    }

    public void onStartInternal()
    {
    }

    protected void safeSetVisibility(View view, int i)
    {
        if (view != null)
        {
            view.setVisibility(i);
        }
    }
}
