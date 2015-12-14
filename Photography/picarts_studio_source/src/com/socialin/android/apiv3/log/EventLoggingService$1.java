// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.util.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.log:
//            EventLoggingService

final class a extends BroadcastReceiver
{

    private EventLoggingService a;

    public final void onReceive(Context context, Intent intent)
    {
        if ("picsart.event.add.action".equals(intent.getAction()))
        {
            EventLoggingService.access$000(a, intent);
        } else
        {
            if ("picsart.event.add.attribute".equals(intent.getAction()))
            {
                EventLoggingService.access$100(a, intent);
                return;
            }
            if ("picsart.start.session.action".equals(intent.getAction()))
            {
                a.handleSessionStart(intent);
                return;
            }
            if ("picsart.end.session.action".equals(intent.getAction()))
            {
                if (EventLoggingService.access$200().getBoolean("ACTIVITY_LIFE", false))
                {
                    if (SocialinV3.getInstance().getAppProps().getData()._fld200 != null)
                    {
                        EventLoggingService.access$300().putLong("SESSION_TIMESTAMP", System.currentTimeMillis() / (long)SocialinV3.getInstance().getAppProps().getData()._fld300.Unit);
                    } else
                    {
                        EventLoggingService.access$300().putLong("SESSION_TIMESTAMP", System.currentTimeMillis() / (long)a.timeStampUnit);
                    }
                }
                EventLoggingService.access$300().putBoolean("ACTIVITY_LIFE", false);
                EventLoggingService.access$300().commit();
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
            {
                s.c(a.getApplicationContext());
                return;
            }
            if (intent.getAction().equals("picsart.analytics.debug.request.action"))
            {
                context = EventLoggingService.access$400(a).obtainMessage(3);
                Bundle bundle = new Bundle();
                bundle.putString("event_id", intent.getExtras().getString("event_id"));
                bundle.putString("data", intent.getExtras().getString("data"));
                bundle.putLong("timeStamp", intent.getExtras().getLong("timeStamp"));
                context.setData(bundle);
                EventLoggingService.access$400(a).sendMessage(context);
                return;
            }
            if ("picsart.contact.send.action".equals(intent.getAction()))
            {
                context = new JSONObject();
                JSONObject jsonobject = new JSONObject();
                JSONObject jsonobject1 = new JSONObject();
                JSONArray jsonarray = new JSONArray();
                try
                {
                    jsonobject.put("event_type", intent.getExtras().getString("event_id"));
                    jsonobject.put("data", new JSONObject(intent.getExtras().getString("data")));
                    jsonobject.put("timestamp", intent.getExtras().getString("timestamp"));
                    jsonarray.put(jsonobject);
                    EventLoggingService.access$600(a, jsonobject1, EventLoggingService.access$500(a));
                    context.put("events", jsonarray);
                    context.put("header", jsonobject1);
                    intent = new JSONArray();
                    intent.put(context);
                    a.sendUserConnsRequest(intent.toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.getMessage();
                }
                return;
            }
        }
    }

    (EventLoggingService eventloggingservice)
    {
        a = eventloggingservice;
        super();
    }
}
