// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.manager;

import android.app.Fragment;
import com.bumptech.glide.RequestManager;

// Referenced classes of package com.bumptech.glide.manager:
//            ActivityFragmentLifecycle

public class RequestManagerFragment extends Fragment
{

    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;

    public RequestManagerFragment()
    {
        this(new ActivityFragmentLifecycle());
    }

    RequestManagerFragment(ActivityFragmentLifecycle activityfragmentlifecycle)
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

    public void onTrimMemory(int i)
    {
        if (requestManager != null)
        {
            requestManager.onTrimMemory(i);
        }
    }

    public void setRequestManager(RequestManager requestmanager)
    {
        requestManager = requestmanager;
    }
}
