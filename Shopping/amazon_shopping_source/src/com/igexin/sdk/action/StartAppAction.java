// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.igexin.sdk.Consts;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.bean.StartAppBean;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.action:
//            AbstractPushMessageAction, PushMessageAction

public class StartAppAction
    implements AbstractPushMessageAction
{

    public StartAppAction()
    {
    }

    public void broadcastPayload(String s, String s1, String s2, byte abyte0[], boolean flag)
    {
label0:
        {
            if (abyte0 != null)
            {
                if (!flag)
                {
                    break label0;
                }
                Intent intent = new Intent((new StringBuilder()).append("com.igexin.sdk.action.carrier.").append(s2).toString());
                s = PushMessageAction.getInstance().getPushMessageCacheId(s, s1);
                intent.putExtra("type", 3);
                intent.putExtra("payloadid", s);
                intent.putExtra("appid", s2);
                intent.putExtra("packagename", SdkService.getInstance().getPackageName());
                s = Boolean.valueOf(true);
                if (abyte0.length >= 0x10000)
                {
                    s = Boolean.valueOf(false);
                    s2 = new ByteArrayInputStream(abyte0);
                    s1 = new byte[0x10000];
                    try
                    {
                        s2.read(s1, 0, 65535);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s2)
                    {
                        s2.printStackTrace();
                    }
                    intent.putExtra("payload", s1);
                } else
                {
                    intent.putExtra("payload", abyte0);
                }
                intent.putExtra("datadone", s);
                SdkService.getInstance().sendBroadcast(intent);
            }
            return;
        }
        Intent intent1 = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10001);
        bundle.putString("payloadid", PushMessageAction.getInstance().getPushMessageCacheId(s, s1));
        bundle.putString("appid", s2);
        bundle.putString("packagename", SdkService.getInstance().getPackageName());
        intent1.setAction((new StringBuilder()).append("com.igexin.sdk.action.").append(s2).toString());
        s = Boolean.valueOf(true);
        if (abyte0.length >= 0x10000)
        {
            s = Boolean.valueOf(false);
            s2 = new ByteArrayInputStream(abyte0);
            s1 = new byte[0x10000];
            try
            {
                s2.read(s1, 0, 65535);
            }
            // Misplaced declaration of an exception variable
            catch (String s2)
            {
                s2.printStackTrace();
            }
            bundle.putByteArray("payload", s1);
        } else
        {
            bundle.putByteArray("payload", abyte0);
        }
        bundle.putBoolean("datadone", s.booleanValue());
        intent1.putExtras(bundle);
        SdkService.getInstance().sendBroadcast(intent1);
    }

    public boolean executeAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        if (pushmessagebean != null && basebean != null)
        {
            StartAppBean startappbean = (StartAppBean)basebean;
            boolean flag = false;
            PackageManager packagemanager = SdkService.getInstance().getPackageManager();
            String s = startappbean.getAppid();
            if (s.equals(""))
            {
                basebean = Consts.VPUSH_APPID;
                flag = true;
            } else
            {
                basebean = s;
                if (Consts.VPUSH_APPID.equals(startappbean.getAppid()))
                {
                    flag = true;
                    basebean = s;
                }
            }
            if (flag)
            {
                broadcastPayload(pushmessagebean.getTaskId(), pushmessagebean.getMessageId(), basebean, pushmessagebean.getPayload(), true);
                if (startappbean.getIsAutoStart().equals("true"))
                {
                    basebean = packagemanager.getLaunchIntentForPackage(SdkService.getInstance().getPackageName());
                    SdkService.getInstance().startActivity(basebean);
                }
                PushMessageAction.getInstance().executePushMessageAction(pushmessagebean, startappbean.getDoActionId());
            } else
            {
                broadcastPayload(pushmessagebean.getTaskId(), pushmessagebean.getMessageId(), basebean, pushmessagebean.getPayload(), false);
                boolean flag2 = true;
                boolean flag1 = flag2;
                if (startappbean.getIsAutoStart().equals("true"))
                {
                    if (SdkService.getInstance().checkAppLauncher(startappbean.getPackageName()))
                    {
                        basebean = packagemanager.getLaunchIntentForPackage(startappbean.getPackageName());
                        SdkService.getInstance().startActivity(basebean);
                        flag1 = flag2;
                    } else
                    {
                        flag1 = false;
                    }
                }
                if (flag1)
                {
                    if (startappbean.getDoActionId() != null)
                    {
                        PushMessageAction.getInstance().executePushMessageAction(pushmessagebean, startappbean.getDoActionId());
                    }
                } else
                if (startappbean.getDoUninstallId() != null)
                {
                    PushMessageAction.getInstance().executePushMessageAction(pushmessagebean, startappbean.getDoUninstallId());
                }
            }
        }
        return true;
    }

    public BaseBean parseAction(JSONObject jsonobject)
    {
        StartAppBean startappbean;
        try
        {
            startappbean = new StartAppBean();
            startappbean.setType(jsonobject.getString("type"));
            startappbean.setActionId(jsonobject.getString("actionid"));
            startappbean.setDoActionId(jsonobject.getString("do"));
            if (jsonobject.has("appstartupid"))
            {
                startappbean.setPackageName(jsonobject.getJSONObject("appstartupid").getString("android"));
            }
            if (jsonobject.has("is_autostart"))
            {
                startappbean.setIsAutoStart(jsonobject.getString("is_autostart"));
            }
            if (jsonobject.has("appid"))
            {
                startappbean.setAppid(jsonobject.getString("appid"));
            }
            if (jsonobject.has("noinstall_action"))
            {
                startappbean.setDoUninstallId(jsonobject.getString("noinstall_action"));
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return startappbean;
    }

    public com.igexin.sdk.Consts.ActionPrepareState prepareExecuteAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        return com.igexin.sdk.Consts.ActionPrepareState.success;
    }
}
