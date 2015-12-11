// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.device.ads:
//            MraidDisplayController, Log

class this._cls0 extends BroadcastReceiver
{

    private int mLastRotation;
    final MraidDisplayController this$0;

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
            {
                int i = MraidDisplayController.access$000(MraidDisplayController.this);
                if (i != mLastRotation)
                {
                    mLastRotation = i;
                    MraidDisplayController.access$100(MraidDisplayController.this, mLastRotation);
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d("MraidDisplayController", "Orientation broadcast receiver got exception while executing: %s", new Object[] {
                context.getLocalizedMessage()
            });
        }
    }

    ()
    {
        this$0 = MraidDisplayController.this;
        super();
    }
}
