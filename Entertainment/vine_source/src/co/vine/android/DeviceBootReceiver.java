// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import co.vine.android.service.ResourceService;
import com.edisonwang.android.slog.SLog;

public class DeviceBootReceiver extends BroadcastReceiver
{

    public DeviceBootReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        SLog.d("Received device boot message {}.", s);
        if ("android.intent.action.PACKAGE_REPLACED".equals(s))
        {
            intent = intent.getData();
            if (intent != null && !context.getPackageName().equals(intent.getSchemeSpecificPart()))
            {
                return;
            }
        }
        context.startService(new Intent(context, co/vine/android/service/ResourceService));
    }
}
