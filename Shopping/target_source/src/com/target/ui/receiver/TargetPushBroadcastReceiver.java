// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.receiver;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.ParsePushBroadcastReceiver;
import com.target.a.a.b;
import com.target.mothership.util.o;
import com.target.ui.analytics.a.aj;
import com.target.ui.b.a;
import org.json.JSONException;
import org.json.JSONObject;

public class TargetPushBroadcastReceiver extends ParsePushBroadcastReceiver
{

    private static final String ALERT = "alert";
    private static final String APP_CONFIG = "app_config";
    private static final String MSG_TYPE = "msg_type";
    private static final String TAG = com/target/ui/receiver/TargetPushBroadcastReceiver.getSimpleName();

    public TargetPushBroadcastReceiver()
    {
    }

    private JSONObject a(Intent intent)
    {
        try
        {
            intent = JSONObjectInstrumentation.init(intent.getStringExtra("com.parse.Data"));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            b.a(TAG, "Unexpected JSONException when receiving push data: ", intent);
            return null;
        }
        return intent;
    }

    private void a(Context context, JSONObject jsonobject)
    {
        if (o.a("app_config", jsonobject.optString("msg_type")))
        {
            (new a(context, com.target.mothership.a.a.a())).a(true);
        }
    }

    protected Bitmap getLargeIcon(Context context, Intent intent)
    {
        return BitmapFactoryInstrumentation.decodeResource(context.getResources(), 0x7f020198);
    }

    protected int getSmallIconId(Context context, Intent intent)
    {
        return 0x7f0201a8;
    }

    protected void onPushOpen(Context context, Intent intent)
    {
        super.onPushOpen(context, intent);
        context = a(intent);
        if (context != null && context.has("alert"))
        {
            aj.a(context.optString("alert")).e();
        }
    }

    protected void onPushReceive(Context context, Intent intent)
    {
        JSONObject jsonobject = a(intent);
        if (jsonobject != null)
        {
            com.target.ui.l.a.a(context);
            com.target.ui.l.a a1 = com.target.ui.l.a.a();
            if (!jsonobject.has("alert") && jsonobject.has("msg_type"))
            {
                a(context, jsonobject);
            } else
            if (jsonobject.has("alert") && a1.b())
            {
                super.onPushReceive(context, intent);
                return;
            }
        }
    }

}
