// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import com.bumptech.glide.manager.RequestTracker;

// Referenced classes of package com.bumptech.glide:
//            RequestManager

private static class requestTracker
    implements com.bumptech.glide.manager.racker
{

    private final RequestTracker requestTracker;

    public void onConnectivityChanged(boolean flag)
    {
        if (flag)
        {
            requestTracker.restartRequests();
        }
    }

    public (RequestTracker requesttracker)
    {
        requestTracker = requesttracker;
    }
}
