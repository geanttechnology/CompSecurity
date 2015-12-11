// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.receivers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.aqo;
import android.text.TextUtils;
import com.abtnprojects.ambatana.a;
import com.abtnprojects.ambatana.models.chat.MessageJsonEntity;
import com.abtnprojects.ambatana.ui.activities.ProductActivity;
import com.abtnprojects.ambatana.ui.activities.ProductListingActivity;
import com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity;
import com.abtnprojects.ambatana.ui.activities.chat.UserMessagesListActivity;
import com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity;
import com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.ParsePushBroadcastReceiver;
import org.json.JSONException;
import org.json.JSONObject;

public class AmbatanaBroadcastPushReceiver extends ParsePushBroadcastReceiver
{

    public static String a = "com.abtnprojects.ambatana.receivers.AmbatanaBroadcastPushReceiver.NEW_MESSAGE";
    public static int b = 1;
    public static String c = "com.abtnprojects.ambatana.receivers.AmbatanaBroadcastPushReceiver.ADD_MESSAGE_IN_CONVERSATION";
    public static int d = 0;
    private static final long f[] = {
        25L, 150L, 25L, 150L
    };
    MessageJsonEntity e;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private SharedPreferences m;

    public AmbatanaBroadcastPushReceiver()
    {
        e = new MessageJsonEntity();
    }

    private void a(Context context, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            Intent intent = new Intent();
            intent.setAction(c);
            intent.putExtra("message_extra", e.transform(s));
            intent.putExtra("product_id", g);
            context.sendBroadcast(intent);
        }
    }

    private void a(Context context, String s, String s1, int i1, String s2)
    {
        String s3 = context.getString(0x7f0901d0);
        Intent intent = new Intent(context, com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
        intent.setFlags(0x10000000);
        intent.setFlags(0x4000000);
        intent.putExtra("product_id", s1);
        intent.putExtra("user_id", s2);
        intent.putExtra("origin_activity", 2);
        s1 = PendingIntent.getActivity(context, 1000, intent, 0x8000000);
        s = (new android.support.v4.app.v.d(context)).a(0x7f0200ee).c(s).a(s3).b(s).a(s1).a(true);
        s.a(s1);
        if (a(m))
        {
            s.a(Uri.parse((new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/raw/letgo_notification").toString()));
        }
        if (b(m))
        {
            s.a(f);
        }
        if (c(m))
        {
            s.a(0xffff0000, 300, 3000);
        }
        ((NotificationManager)context.getSystemService("notification")).notify(i1, s.a());
    }

    private void a(Context context, String s, JSONObject jsonobject)
        throws JSONException
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("pushJson : ");
        String s1;
        if (!(jsonobject instanceof JSONObject))
        {
            s1 = jsonobject.toString();
        } else
        {
            s1 = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        aqo.a(stringbuilder.append(s1).toString(), new Object[0]);
        b(jsonobject);
        a(context, s);
        com.abtnprojects.ambatana.a.a(context).b();
        if (!TextUtils.isEmpty(i))
        {
            s = i;
            jsonobject = g;
            int i1 = d;
            d = i1 + 1;
            a(context, s, ((String) (jsonobject)), i1, h);
        }
    }

    private void a(Context context, JSONObject jsonobject)
        throws JSONException
    {
        if (!jsonobject.isNull("alert"))
        {
            i = jsonobject.getString("alert");
        }
        jsonobject = new Intent(context, com/abtnprojects/ambatana/ui/activities/ProductListingActivity);
        jsonobject.setFlags(0x10000000);
        jsonobject.setFlags(0x4000000);
        a(context, PendingIntent.getActivity(context, 1010, jsonobject, 0x8000000), i);
    }

    private boolean a(SharedPreferences sharedpreferences)
    {
        return sharedpreferences.getBoolean("sound", true);
    }

    private Intent b(Context context, Intent intent)
    {
        Intent intent1;
        Intent intent2;
        intent2 = new Intent(context, com/abtnprojects/ambatana/ui/activities/ProductListingActivity);
        intent1 = intent2;
        if (intent == null) goto _L2; else goto _L1
_L1:
        intent = intent.getBundleExtra("landing_extras_id");
        intent1 = intent2;
        if (intent == null) goto _L2; else goto _L3
_L3:
        intent1 = intent2;
        if (!intent.containsKey("url")) goto _L2; else goto _L4
_L4:
        intent = intent.getString("url");
        intent1 = intent2;
        if (intent == null) goto _L2; else goto _L5
_L5:
        intent = Uri.parse(intent);
        if (!a(intent)) goto _L7; else goto _L6
_L6:
        intent1 = new Intent(context, com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity);
        intent1.setData(intent);
_L2:
        intent1.setFlags(0x10000000);
        intent1.setFlags(0x4000000);
        return intent1;
_L7:
        if (b(((Uri) (intent))))
        {
            intent1 = new Intent(context, com/abtnprojects/ambatana/ui/activities/posting/ProductNewActivity);
        } else
        if (c(intent))
        {
            intent1 = new Intent(context, com/abtnprojects/ambatana/ui/activities/ProductActivity);
            intent1.setData(intent);
        } else
        if (d(intent))
        {
            intent1 = new Intent(context, com/abtnprojects/ambatana/ui/activities/chat/UserMessagesListActivity);
        } else
        {
            intent1 = intent2;
            if (e(intent))
            {
                intent1 = new Intent(context, com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
                intent1.putExtra("origin_activity", 3);
                intent1.setData(intent);
            }
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    private void b(JSONObject jsonobject)
    {
        if (jsonobject != null)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("pushData : ");
            String s;
            if (!(jsonobject instanceof JSONObject))
            {
                s = jsonobject.toString();
            } else
            {
                s = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }
            aqo.a(stringbuilder.append(s).toString(), new Object[0]);
            c(jsonobject);
            d(jsonobject);
            e(jsonobject);
            f(jsonobject);
            g(jsonobject);
            h(jsonobject);
        }
    }

    private boolean b(SharedPreferences sharedpreferences)
    {
        return sharedpreferences.getBoolean("vibrate", true);
    }

    private void c(JSONObject jsonobject)
    {
        if (jsonobject == null || jsonobject.isNull("p"))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        g = jsonobject.getString("p");
        return;
        JSONException jsonexception;
        jsonexception;
        aqo.b(jsonexception, "Error parsing json object %s", new Object[] {
            jsonobject
        });
        return;
    }

    private boolean c(SharedPreferences sharedpreferences)
    {
        return sharedpreferences.getBoolean("light", true);
    }

    private void d(JSONObject jsonobject)
    {
        if (jsonobject == null || jsonobject.isNull("u"))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        h = jsonobject.getString("u");
        return;
        JSONException jsonexception;
        jsonexception;
        aqo.b(jsonexception, "Error parsing json object %s", new Object[] {
            jsonobject
        });
        return;
    }

    private void e(JSONObject jsonobject)
    {
        if (jsonobject == null || jsonobject.isNull("alert"))
        {
            break MISSING_BLOCK_LABEL_23;
        }
        i = jsonobject.getString("alert");
        return;
        JSONException jsonexception;
        jsonexception;
        aqo.b(jsonexception, "Error parsing gson object %s", new Object[] {
            jsonobject
        });
        return;
    }

    private void f(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        if (jsonobject.isNull("n_t"))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        j = jsonobject.getString("n_t");
_L1:
        return;
        JSONException jsonexception;
        jsonexception;
        aqo.b(jsonexception, "Error parsing gson object %s", new Object[] {
            jsonobject
        });
        return;
        if (!jsonobject.isNull("notification_type"))
        {
            try
            {
                j = jsonobject.getString("notification_type");
                return;
            }
            catch (JSONException jsonexception1)
            {
                aqo.b(jsonexception1, "Error parsing gson object %s", new Object[] {
                    jsonobject
                });
            }
            return;
        }
          goto _L1
    }

    private void g(JSONObject jsonobject)
    {
        if (jsonobject == null || jsonobject.isNull("messageObjectId"))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        k = jsonobject.getString("messageObjectId");
        return;
        JSONException jsonexception;
        jsonexception;
        aqo.b(jsonexception, "Error parsing gson object %s", new Object[] {
            jsonobject
        });
        return;
    }

    private void h(JSONObject jsonobject)
    {
        if (jsonobject == null || jsonobject.isNull("img"))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        l = jsonobject.getString("img");
        return;
        JSONException jsonexception;
        jsonexception;
        aqo.b(jsonexception, "Error parsing gson object %s", new Object[] {
            jsonobject
        });
        return;
    }

    protected void a(Context context, PendingIntent pendingintent, String s)
    {
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        s = (new android.support.v4.app.v.d(context)).a(0x7f0200ee).a("Letgo").b(s).c(s).a((new android.support.v4.app.v.c()).a(s));
        s.a(pendingintent);
        s.a(true);
        if (a(m))
        {
            s.a(Uri.parse((new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/raw/letgo_notification").toString()));
        }
        if (b(m))
        {
            s.a(f);
        }
        if (c(m))
        {
            s.a(0xffff0000, 300, 3000);
        }
        notificationmanager.notify(1010, s.a());
    }

    protected void a(Context context, Intent intent)
    {
        String s = intent.getStringExtra("alert");
        intent.getStringExtra("k");
        if (!TextUtils.isEmpty(s))
        {
            a(context, PendingIntent.getActivity(context, 1010, b(context, intent), 0x8000000), s);
        }
    }

    protected void a(Context context, Intent intent, String s)
    {
        Bundle bundle = intent.getExtras();
        if (!intent.hasExtra("com.parse.Data"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        aqo.a("Intent with extra %s", new Object[] {
            "com.parse.Data"
        });
        intent = bundle.getString("com.parse.Data");
        s = JSONObjectInstrumentation.init(intent);
        if (a(((JSONObject) (s))))
        {
            a(context, ((String) (intent)), ((JSONObject) (s)));
            return;
        }
        try
        {
            a(context, ((JSONObject) (s)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aqo.b(context, "Error parsing json %s", new Object[] {
                intent
            });
        }
        return;
        if (s.equals("com.abtnprojects.ambatana.receivers.AmbatanaBroadcastPushReceiver.USER_LOCATION_CHANGED"))
        {
            aqo.a("Location Changed", new Object[0]);
            return;
        } else
        {
            aqo.a("Intent without extra com.parse.Data", new Object[0]);
            return;
        }
    }

    protected boolean a(Uri uri)
    {
        return "users".equalsIgnoreCase(uri.getHost());
    }

    protected boolean a(JSONObject jsonobject)
    {
        return jsonobject != null && (jsonobject.has("p") || jsonobject.has("m"));
    }

    protected boolean b(Uri uri)
    {
        return "sell".equalsIgnoreCase(uri.getHost());
    }

    protected boolean c(Uri uri)
    {
        return "products".equalsIgnoreCase(uri.getHost());
    }

    protected boolean d(Uri uri)
    {
        return "chats".equalsIgnoreCase(uri.getHost());
    }

    protected boolean e(Uri uri)
    {
        return "chat".equalsIgnoreCase(uri.getHost());
    }

    public void onReceive(Context context, Intent intent)
    {
        m = PreferenceManager.getDefaultSharedPreferences(context);
        String s = intent.getAction();
        if (s != null && (s.equals(a) || s.equals("com.parse.push.intent.RECEIVE")))
        {
            a(context, intent, s);
            return;
        }
        if (s != null && "com.kahuna.sdk.push.received".equals(s))
        {
            a(context, intent);
            return;
        } else
        {
            aqo.c("Unhandled action received %s", new Object[] {
                s
            });
            return;
        }
    }

}
