// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.Preconditions;

// Referenced classes of package com.mopub.mraid:
//            MraidController

class mLastRotation extends BroadcastReceiver
{

    private Context mContext;
    private int mLastRotation;
    final MraidController this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (mContext != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()))
        {
            int i = MraidController.access$1400(MraidController.this);
            if (i != mLastRotation)
            {
                mLastRotation = i;
                handleOrientationChange(mLastRotation);
                return;
            }
        }
    }

    public void register(Context context)
    {
        Preconditions.checkNotNull(context);
        mContext = context.getApplicationContext();
        if (mContext != null)
        {
            mContext.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public void unregister()
    {
        if (mContext != null)
        {
            mContext.unregisterReceiver(this);
            mContext = null;
        }
    }

    ()
    {
        this$0 = MraidController.this;
        super();
        mLastRotation = -1;
    }
}
