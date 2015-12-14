// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.autoupdatesdk.obf.d;
import com.baidu.autoupdatesdk.obf.g;

public class BDBroadcastReceiver extends BroadcastReceiver
{

    public BDBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("com.baidu.autoupdatesdk.ACTION_NEW_UPDATE".equals(intent.getAction()) || "com.baidu.autoupdatesdk.ACTION_DOWNLOAD_COMPLETE".equals(intent.getAction()))
        {
            if (g.a != null)
            {
                g.a.a();
            }
        } else
        if (("com.baidu.autoupdatesdk.ACTION_NEW_AS".equals(intent.getAction()) || "com.baidu.autoupdatesdk.ACTION_AS_DOWNLOAD_COMPLETE".equals(intent.getAction())) && d.a != null)
        {
            d.a.a();
            return;
        }
    }
}
