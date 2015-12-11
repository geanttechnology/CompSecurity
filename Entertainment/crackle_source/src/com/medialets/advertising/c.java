// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.medialets.advertising:
//            AdManager, a, AdManagerService

final class c extends Handler
{

    private AdManager a;

    c(AdManager admanager)
    {
        a = admanager;
        super();
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            com.medialets.advertising.a.d((new StringBuilder()).append("Unexpected message: ").append(message.what).toString());
            return;

        case 1: // '\001'
            com.medialets.advertising.a.a("Ad cache sync failed: No Network Connection.");
            if (a.mSyncListener != null)
            {
                a.mSyncListener.onSyncFailed(1);
            }
            a.mService.onSyncCompleted();
            return;

        case 2: // '\002'
            com.medialets.advertising.a.a((new StringBuilder()).append("Ad cache sync failed: Unexpected error: ").append(message.obj).toString());
            if (a.mSyncListener != null)
            {
                a.mSyncListener.onSyncFailed(2);
            }
            a.mService.onSyncCompleted();
            return;

        case 3: // '\003'
            com.medialets.advertising.a.a("Ad cache sync completed successfully.");
            break;
        }
        if (a.mSyncListener != null)
        {
            a.mSyncListener.onSyncComplete();
        }
        a.mService.onSyncCompleted();
    }
}
