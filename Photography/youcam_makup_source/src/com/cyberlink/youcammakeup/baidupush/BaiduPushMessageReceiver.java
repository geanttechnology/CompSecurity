// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.baidupush;

import android.content.Context;
import com.baidu.frontia.api.FrontiaPushMessageReceiver;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;
import java.util.List;

public class BaiduPushMessageReceiver extends FrontiaPushMessageReceiver
{

    public BaiduPushMessageReceiver()
    {
    }

    public void onBind(Context context, int i, String s, String s1, String s2, String s3)
    {
        context = (new StringBuilder()).append("onBind errorCode=").append(i).append(" appid=").append(s).append(" userId=").append(s1).append(" channelId=").append(s2).append(" requestId=").append(s3).toString();
        if (i == 0)
        {
            m.b("BaiduPushMessageReceiver", context);
            z.a(s2);
            z.b(s1);
            context = Globals.d().w();
            if (context != null)
            {
                context.M();
            }
            return;
        } else
        {
            m.e("BaiduPushMessageReceiver", context);
            return;
        }
    }

    public void onDelTags(Context context, int i, List list, List list1, String s)
    {
    }

    public void onListTags(Context context, int i, List list, String s)
    {
    }

    public void onMessage(Context context, String s, String s1)
    {
        m.b("BaiduPushMessageReceiver", (new StringBuilder()).append("message=\"").append(s).append("\" customContentString=").append(s1).toString());
        Globals.d().a(0L, null);
    }

    public void onNotificationClicked(Context context, String s, String s1, String s2)
    {
    }

    public void onSetTags(Context context, int i, List list, List list1, String s)
    {
    }

    public void onUnbind(Context context, int i, String s)
    {
        m.b("BaiduPushMessageReceiver", (new StringBuilder()).append("onUnbind errorCode=").append(i).append(" requestId = ").append(s).toString());
        z.a("BaiduIsBind", Boolean.valueOf(false), Globals.d());
    }
}
