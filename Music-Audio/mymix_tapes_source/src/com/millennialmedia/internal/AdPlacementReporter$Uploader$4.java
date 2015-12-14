// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;

// Referenced classes of package com.millennialmedia.internal:
//            AdPlacementReporter

static final class  extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        if (EnvironmentUtils.isNetworkAvailable())
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(AdPlacementReporter.access$100(), "Reporting detected network is now available -- requesting upload");
            }
            EnvironmentUtils.getApplicationContext().unregisterReceiver(this);
            tUploadState(.UPLOADING);
        }
    }

    ()
    {
    }
}
