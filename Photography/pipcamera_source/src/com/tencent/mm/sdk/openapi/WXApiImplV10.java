// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayResp;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            IWXAPI, WXApiImplComm, IWXAPIEventHandler

final class WXApiImplV10
    implements IWXAPI
{

    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname = null;
    private String appId;
    private boolean checkSignature;
    private Context context;
    private boolean detached;

    WXApiImplV10(Context context1, String s, boolean flag)
    {
        checkSignature = false;
        detached = false;
        a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("<init>, appId = ")).append(s).append(", checkSignature = ").append(flag).toString());
        context = context1;
        appId = s;
        checkSignature = flag;
    }

    private boolean checkSumConsistent(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != null && abyte0.length != 0 && abyte1 != null && abyte1.length != 0) goto _L2; else goto _L1
_L1:
        a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
_L4:
        return false;
_L2:
        if (abyte0.length != abyte1.length)
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
            return false;
        }
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= abyte0.length)
                {
                    break label1;
                }
                if (abyte0[i] != abyte1[i])
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return true;
    }

    private boolean sendPayReq(Context context1, Bundle bundle)
    {
        if (wxappPayEntryClassname == null)
        {
            wxappPayEntryClassname = (new com.tencent.mm.sdk.a(context1)).getString("_wxapp_pay_entry_classname_", null);
            a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("pay, set wxappPayEntryClassname = ")).append(wxappPayEntryClassname).toString());
            if (wxappPayEntryClassname == null)
            {
                a.a("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        com.tencent.mm.sdk.a.a.a a1 = new com.tencent.mm.sdk.a.a.a();
        a1.k = bundle;
        a1.h = "com.tencent.mm";
        a1.i = wxappPayEntryClassname;
        return com.tencent.mm.sdk.a.a.a(context1, a1);
    }

    public final void detach()
    {
        a.c("MicroMsg.SDK.WXApiImplV10", "detach");
        detached = true;
        context = null;
    }

    public final int getWXAppSupportAPI()
    {
        if (detached)
        {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled())
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return 0;
        } else
        {
            return (new com.tencent.mm.sdk.a(context)).getInt("_build_info_sdk_int_", 0);
        }
    }

    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iwxapieventhandler)
    {
        if (!WXApiImplComm.isIntentFromWx(intent, "com.tencent.mm.openapi.token"))
        {
            a.b("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
            return false;
        }
        if (detached)
        {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
        String s = intent.getStringExtra("_mmessage_content");
        int i = intent.getIntExtra("_mmessage_sdkVersion", 0);
        String s1 = intent.getStringExtra("_mmessage_appPackage");
        if (s1 == null || s1.length() == 0)
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "invalid argument");
            return false;
        }
        if (!checkSumConsistent(intent.getByteArrayExtra("_mmessage_checksum"), b.a(s, i, s1)))
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "checksum fail");
            return false;
        }
        i = intent.getIntExtra("_wxapi_command_type", 0);
        switch (i)
        {
        default:
            a.a("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("unknown cmd = ")).append(i).toString());
            return false;

        case 1: // '\001'
            iwxapieventhandler.onResp(new com.tencent.mm.sdk.modelmsg.SendAuth.Resp(intent.getExtras()));
            return true;

        case 2: // '\002'
            iwxapieventhandler.onResp(new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Resp(intent.getExtras()));
            return true;

        case 3: // '\003'
            iwxapieventhandler.onReq(new com.tencent.mm.sdk.modelmsg.GetMessageFromWX.Req(intent.getExtras()));
            return true;

        case 4: // '\004'
            iwxapieventhandler.onReq(new com.tencent.mm.sdk.modelmsg.ShowMessageFromWX.Req(intent.getExtras()));
            return true;

        case 5: // '\005'
            iwxapieventhandler.onResp(new PayResp(intent.getExtras()));
            return true;

        case 6: // '\006'
            iwxapieventhandler.onReq(new com.tencent.mm.sdk.modelmsg.LaunchFromWX.Req(intent.getExtras()));
            break;
        }
        return true;
    }

    public final boolean isWXAppInstalled()
    {
        if (detached)
        {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        PackageInfo packageinfo;
        boolean flag;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        if (packageinfo == null)
        {
            return false;
        }
        flag = WXApiImplComm.validateAppSignature(context, packageinfo.signatures, checkSignature);
        return flag;
    }

    public final boolean isWXAppSupportAPI()
    {
        if (detached)
        {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        return getWXAppSupportAPI() >= 0x22010003;
    }

    public final boolean openWXApp()
    {
        if (detached)
        {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled())
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return false;
        }
        try
        {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
        }
        catch (Exception exception)
        {
            a.a("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("startActivity fail, exception = ")).append(exception.getMessage()).toString());
            return false;
        }
        return true;
    }

    public final boolean registerApp(String s)
    {
        if (detached)
        {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(context, "com.tencent.mm", checkSignature))
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("registerApp, appId = ")).append(s).toString());
        if (s != null)
        {
            appId = s;
        }
        a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("register app ")).append(context.getPackageName()).toString());
        s = new com.tencent.mm.sdk.a.a.a.a();
        s.l = "com.tencent.mm";
        s.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
        s.j = (new StringBuilder("weixin://registerapp?appid=")).append(appId).toString();
        return com.tencent.mm.sdk.a.a.a.a(context, s);
    }

    public final boolean sendReq(BaseReq basereq)
    {
        if (detached)
        {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(context, "com.tencent.mm", checkSignature))
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
            return false;
        }
        if (!basereq.checkArgs())
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
            return false;
        }
        a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("sendReq, req type = ")).append(basereq.getType()).toString());
        Bundle bundle = new Bundle();
        basereq.toBundle(bundle);
        if (basereq.getType() == 5)
        {
            return sendPayReq(context, bundle);
        } else
        {
            basereq = new com.tencent.mm.sdk.a.a.a();
            basereq.k = bundle;
            basereq.j = (new StringBuilder("weixin://sendreq?appid=")).append(appId).toString();
            basereq.h = "com.tencent.mm";
            basereq.i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return com.tencent.mm.sdk.a.a.a(context, basereq);
        }
    }

    public final boolean sendResp(BaseResp baseresp)
    {
        if (detached)
        {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(context, "com.tencent.mm", checkSignature))
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
            return false;
        }
        if (!baseresp.checkArgs())
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
            return false;
        } else
        {
            Bundle bundle = new Bundle();
            baseresp.toBundle(bundle);
            baseresp = new com.tencent.mm.sdk.a.a.a();
            baseresp.k = bundle;
            baseresp.j = (new StringBuilder("weixin://sendresp?appid=")).append(appId).toString();
            baseresp.h = "com.tencent.mm";
            baseresp.i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return com.tencent.mm.sdk.a.a.a(context, baseresp);
        }
    }

    public final void unregisterApp()
    {
        if (detached)
        {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(context, "com.tencent.mm", checkSignature))
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
            return;
        }
        a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("unregisterApp, appId = ")).append(appId).toString());
        if (appId == null || appId.length() == 0)
        {
            a.a("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
            return;
        } else
        {
            a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("unregister app ")).append(context.getPackageName()).toString());
            com.tencent.mm.sdk.a.a.a.a a1 = new com.tencent.mm.sdk.a.a.a.a();
            a1.l = "com.tencent.mm";
            a1.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
            a1.j = (new StringBuilder("weixin://unregisterapp?appid=")).append(appId).toString();
            com.tencent.mm.sdk.a.a.a.a(context, a1);
            return;
        }
    }

}
