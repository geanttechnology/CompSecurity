// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.channel.MMessageActV2;
import com.tencent.mm.sdk.channel.compatible.MMessage;
import com.tencent.mm.sdk.channel.compatible.MMessageUtil;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            IWXAPI, MMSharedPreferences, WXApiImplComm, IWXAPIEventHandler

final class WXApiImplV10
    implements IWXAPI
{

    private static String wxappPayEntryClassname = null;
    private String appId;
    private boolean checkSignature;
    private Context context;
    private boolean detached;

    WXApiImplV10(Context context1, String s, boolean flag)
    {
        checkSignature = false;
        detached = false;
        Log.d("MicroMsg.SDK.WXApiImplV10", (new StringBuilder()).append("<init>, appId = ").append(s).append(", checkSignature = ").append(flag).toString());
        context = context1;
        appId = s;
        checkSignature = flag;
    }

    private boolean checkSumConsistent(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != null && abyte0.length != 0 && abyte1 != null && abyte1.length != 0) goto _L2; else goto _L1
_L1:
        Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
_L4:
        return false;
_L2:
        if (abyte0.length != abyte1.length)
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
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

    private boolean sendJumpToBizProfileReq(Context context1, Bundle bundle)
    {
        context1.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] {
            appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), (new StringBuilder()).append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene")).append("").toString(), (new StringBuilder()).append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type")).append("").toString()
        }, null);
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context1, Bundle bundle)
    {
        context1.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] {
            appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), (new StringBuilder()).append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene")).append("").toString()
        }, null);
        return true;
    }

    private boolean sendPayReq(Context context1, Bundle bundle)
    {
        if (wxappPayEntryClassname == null)
        {
            wxappPayEntryClassname = (new MMSharedPreferences(context1)).getString("_wxapp_pay_entry_classname_", null);
            Log.d("MicroMsg.SDK.WXApiImplV10", (new StringBuilder()).append("pay, set wxappPayEntryClassname = ").append(wxappPayEntryClassname).toString());
            if (wxappPayEntryClassname == null)
            {
                Log.e("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        com.tencent.mm.sdk.channel.MMessageActV2.Args args = new com.tencent.mm.sdk.channel.MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context1, args);
    }

    public int getWXAppSupportAPI()
    {
        if (detached)
        {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled())
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return 0;
        } else
        {
            return (new MMSharedPreferences(context)).getInt("_build_info_sdk_int_", 0);
        }
    }

    public boolean handleIntent(Intent intent, IWXAPIEventHandler iwxapieventhandler)
    {
        if (!WXApiImplComm.isIntentFromWx(intent, "com.tencent.mm.openapi.token"))
        {
            Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
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
            Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
            return false;
        }
        if (!checkSumConsistent(intent.getByteArrayExtra("_mmessage_checksum"), MMessageUtil.genCheckSum(s, i, s1)))
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
            return false;
        }
        i = intent.getIntExtra("_wxapi_command_type", 0);
        switch (i)
        {
        default:
            Log.e("MicroMsg.SDK.WXApiImplV10", (new StringBuilder()).append("unknown cmd = ").append(i).toString());
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

    public boolean isWXAppInstalled()
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

    public boolean registerApp(String s)
    {
        if (detached)
        {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(context, "com.tencent.mm", checkSignature))
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", (new StringBuilder()).append("registerApp, appId = ").append(s).toString());
        if (s != null)
        {
            appId = s;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", (new StringBuilder()).append("register app ").append(context.getPackageName()).toString());
        s = new com.tencent.mm.sdk.channel.compatible.MMessage.Args();
        s.targetPkg = "com.tencent.mm";
        s.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
        s.content = (new StringBuilder()).append("weixin://registerapp?appid=").append(appId).toString();
        return MMessage.send(context, s);
    }

    public boolean sendReq(BaseReq basereq)
    {
        if (detached)
        {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(context, "com.tencent.mm", checkSignature))
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
            return false;
        }
        if (!basereq.checkArgs())
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
            return false;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", (new StringBuilder()).append("sendReq, req type = ").append(basereq.getType()).toString());
        Bundle bundle = new Bundle();
        basereq.toBundle(bundle);
        if (basereq.getType() == 5)
        {
            return sendPayReq(context, bundle);
        }
        if (basereq.getType() == 7)
        {
            return sendJumpToBizProfileReq(context, bundle);
        }
        if (basereq.getType() == 8)
        {
            return sendJumpToBizWebviewReq(context, bundle);
        } else
        {
            basereq = new com.tencent.mm.sdk.channel.MMessageActV2.Args();
            basereq.bundle = bundle;
            basereq.content = (new StringBuilder()).append("weixin://sendreq?appid=").append(appId).toString();
            basereq.targetPkgName = "com.tencent.mm";
            basereq.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(context, basereq);
        }
    }

    public boolean sendResp(BaseResp baseresp)
    {
        if (detached)
        {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(context, "com.tencent.mm", checkSignature))
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
            return false;
        }
        if (!baseresp.checkArgs())
        {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
            return false;
        } else
        {
            Bundle bundle = new Bundle();
            baseresp.toBundle(bundle);
            baseresp = new com.tencent.mm.sdk.channel.MMessageActV2.Args();
            baseresp.bundle = bundle;
            baseresp.content = (new StringBuilder()).append("weixin://sendresp?appid=").append(appId).toString();
            baseresp.targetPkgName = "com.tencent.mm";
            baseresp.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(context, baseresp);
        }
    }

}
