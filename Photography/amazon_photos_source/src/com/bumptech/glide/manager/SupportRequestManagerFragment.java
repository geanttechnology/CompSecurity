// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.manager;

import android.support.v4.app.Fragment;
import com.bumptech.glide.RequestManager;

// Referenced classes of package com.bumptech.glide.manager:
//            ActivityFragmentLifecycle

public class SupportRequestManagerFragment extends Fragment
{

    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;

    public SupportRequestManagerFragment()
    {
        this(new ActivityFragmentLifecycle());
    }

    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityfragmentlifecycle)
    {
        lifecycle = activityfragmentlifecycle;
    }

    ActivityFragmentLifecycle getLifecycle()
    {
        return lifecycle;
    }

    public RequestManager getRequestManager()
    {
        return requestManager;
    }

    public void onDestroy()
    {
        super.onDestroy();
        lifecycle.onDestroy();
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        if (requestManager != null)
        {
            requestManager.onLowMemory();
        }
    }

    public void onStart()
    {
        super.onStart();
        lifecycle.onStart();
    }

    public void onStop()
    {
        super.onStop();
        lifecycle.onStop();
    }

    public void setRequestManager(RequestManager requestmanager)
    {
        requestManager = requestmanager;
    }
}
