// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.pipcamera.activity.PIPCameraActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity
    implements IWXAPIEventHandler
{

    private IWXAPI a;

    public WXEntryActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = WXAPIFactory.createWXAPI(this, "wx236dd568f82c78c2", false);
        a.handleIntent(getIntent(), this);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        a.handleIntent(intent, this);
    }

    public void onReq(BaseReq basereq)
    {
        switch (basereq.getType())
        {
        case 4: // '\004'
        default:
            return;

        case 3: // '\003'
            basereq = new Intent();
            break;
        }
        basereq.setClass(this, com/pipcamera/activity/PIPCameraActivity);
        startActivity(basereq);
    }

    public void onResp(BaseResp baseresp)
    {
        switch (baseresp.errCode)
        {
        case -4: 
        case -3: 
        case -2: 
        case -1: 
        case 0: // '\0'
        default:
            finish();
            break;
        }
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, PIPCameraApplication.h);
        ApplicationState.checkAppStateAfterOnStart();
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(getApplicationContext());
        ApplicationState.checkAppStateAfterOnStop();
    }
}
