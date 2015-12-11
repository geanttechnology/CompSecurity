// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.amazon.mShop.android.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.share.SharableAppInfoManager;
import com.amazon.mShop.share.WechatSDKManager;
import com.amazon.mShop.util.ActivityUtils;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends Activity
    implements IWXAPIEventHandler
{

    public WXEntryActivity()
    {
    }

    private void handleIntentBySdk(Intent intent)
    {
        IWXAPI iwxapi = WechatSDKManager.getAPIHandle(this);
        if (iwxapi != null)
        {
            iwxapi.handleIntent(intent, this);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (AppLocale.getInstance().getCurrentLocaleName().equals("zh_CN") && SharableAppInfoManager.isCnMshopPackage(getApplicationContext()))
        {
            handleIntentBySdk(getIntent());
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        if (AppLocale.getInstance().getCurrentLocaleName().equals("zh_CN") && SharableAppInfoManager.isCnMshopPackage(getApplicationContext()))
        {
            setIntent(intent);
            handleIntentBySdk(intent);
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onReq(BaseReq basereq)
    {
        if (basereq.getType() != 3)
        {
            return;
        } else
        {
            RefMarkerObserver.logRefMarker(String.format("cm_:sw_cl_%1s", new Object[] {
                WechatSDKManager.getIconLaunchReftag()
            }));
            WechatSDKManager.setPendingTransaction(basereq.transaction);
            ActivityUtils.startHomeActivity(this);
            finish();
            return;
        }
    }

    public void onResp(BaseResp baseresp)
    {
        finish();
    }
}
