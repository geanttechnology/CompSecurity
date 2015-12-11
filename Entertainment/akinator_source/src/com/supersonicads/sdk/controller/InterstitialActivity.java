// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.os.Bundle;
import com.supersonicads.sdk.utils.Logger;

// Referenced classes of package com.supersonicads.sdk.controller:
//            ControllerActivity

public class InterstitialActivity extends ControllerActivity
{

    private static final String TAG = com/supersonicads/sdk/controller/ControllerActivity.getSimpleName();

    public InterstitialActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Logger.i(TAG, "onCreate");
    }

    protected void onPause()
    {
        super.onPause();
        Logger.i(TAG, "onPause");
    }

    protected void onResume()
    {
        super.onResume();
        Logger.i(TAG, "onResume");
    }

}
