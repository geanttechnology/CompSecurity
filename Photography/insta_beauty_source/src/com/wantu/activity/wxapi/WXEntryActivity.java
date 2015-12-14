// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.tencent.mm.sdk.openapi.BaseReq;
import com.tencent.mm.sdk.openapi.BaseResp;
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
        a = WXAPIFactory.createWXAPI(this, "wx283019eeca171807", false);
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
        default:
            return;

        case 3: // '\003'
            Toast.makeText(this, "COMMAND_GETMESSAGE_FROM_WX", 1).show();
            return;

        case 4: // '\004'
            Toast.makeText(this, "COMMAND_SHOWMESSAGE_FROM_WX", 1).show();
            break;
        }
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
            return;
        }
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }
}
