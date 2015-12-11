// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.HSConversation;
import com.helpshift.f.a;
import com.helpshift.h.e;
import com.helpshift.l;
import com.helpshift.s;
import com.helpshift.t;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.i:
//            x, m, t, h

public final class k
{

    private static String a = "HelpShiftDebug";
    private static l b;

    public static Handler a(Context context, m m)
    {
        return new Handler(m, new l(context), context) {

            final m a;
            final l b;
            final Context c;

            public void handleMessage(Message message)
            {
                message = (JSONArray)message.obj;
                if (a != null)
                {
                    a.a();
                }
                  goto _L1
_L10:
                int i;
                if (i >= message.length()) goto _L3; else goto _L2
_L2:
                JSONObject jsonobject;
                Object obj;
                jsonobject = message.getJSONObject(i);
                obj = jsonobject.getString("id");
                if (b.a.k().equals(obj)) goto _L5; else goto _L4
_L4:
                Object obj1;
                obj = e.a(((String) (obj)));
                obj1 = jsonobject.getJSONArray("messages");
                if (((JSONArray) (obj1)).length() != 1) goto _L7; else goto _L6
_L6:
                obj1 = ((JSONArray) (obj1)).getJSONObject(((JSONArray) (obj1)).length() - 1);
                if (!t.b(((JSONObject) (obj1)).getString("origin"), ((JSONObject) (obj1)).getString("type"))) goto _L7; else goto _L5
_L7:
                int j = ((a) (obj)).h();
                if (j == 0) goto _L5; else goto _L8
_L8:
                int i1 = (int)com.helpshift.i.h.a.parse(jsonobject.getString("created_at")).getTime();
                com.helpshift.i.k.a(c, jsonobject.getString("id"), i1, j, "inapp", com.helpshift.i.k.a(c));
                  goto _L5
                ParseException parseexception;
                parseexception;
                Log.d(com.helpshift.i.k.a(), parseexception.toString());
                  goto _L5
                message;
                Log.d(com.helpshift.i.k.a(), message.getMessage());
_L3:
                return;
_L1:
                i = 0;
                continue; /* Loop/switch isn't completed */
_L5:
                i++;
                if (true) goto _L10; else goto _L9
_L9:
            }

            
            {
                a = m1;
                b = l1;
                c = context;
                super();
            }
        };
    }

    static String a()
    {
        return a;
    }

    public static String a(Context context)
    {
        String s1;
        String s2;
        try
        {
            s1 = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        }
        catch (NullPointerException nullpointerexception)
        {
            Log.d(a, "getApplicationName", nullpointerexception);
            nullpointerexception = null;
        }
        s2 = s1;
        if (s1 == null)
        {
            s2 = context.getResources().getString(com.helpshift.b.g.E);
        }
        return s2;
    }

    public static void a(Context context, String s1, int i, int j, String s2, String s3)
    {
        Object obj;
        NotificationManager notificationmanager;
        String s4;
        int i1;
        if (b == null)
        {
            b = new l(context);
        }
        b.a.a(s1, i, j, s2, s3);
        if (!com.helpshift.f.a.c(s1).equals(b.B()))
        {
            return;
        }
        obj = t.a();
        if (obj != null)
        {
            ((com.helpshift.t.c) (obj)).a(j);
        }
        notificationmanager = (NotificationManager)context.getSystemService("notification");
        s4 = context.getResources().getQuantityString(com.helpshift.b.f.a, j, new Object[] {
            Integer.valueOf(j)
        });
        i1 = com.helpshift.i.x.a(context);
        obj = new s(context);
        Object obj1 = ((s) (obj)).r();
        if (!((JSONObject) (obj1)).has("notificationSound")) goto _L2; else goto _L1
_L1:
        j = ((JSONObject) (obj1)).getInt("notificationSound");
        obj = Uri.parse((new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/").append(j).toString());
_L6:
        j = i1;
        if (((JSONObject) (obj1)).has("notificationIcon"))
        {
            j = ((JSONObject) (obj1)).getInt("notificationIcon");
        }
_L3:
        obj1 = new Intent(context, com/helpshift/HSConversation);
        ((Intent) (obj1)).setFlags(0x10000000);
        ((Intent) (obj1)).putExtra("issueId", s1);
        ((Intent) (obj1)).putExtra("chatLaunchSource", s2);
        ((Intent) (obj1)).putExtra("isRoot", true);
        s2 = PendingIntent.getActivity(context, i, ((Intent) (obj1)), 0);
        obj1 = new android.support.v4.app.u.d(context);
        ((android.support.v4.app.u.d) (obj1)).a(j);
        ((android.support.v4.app.u.d) (obj1)).a(s3);
        ((android.support.v4.app.u.d) (obj1)).b(s4);
        ((android.support.v4.app.u.d) (obj1)).a(s2);
        ((android.support.v4.app.u.d) (obj1)).a(true);
        if (obj == null)
        {
            if (b(context))
            {
                ((android.support.v4.app.u.d) (obj1)).b(-1);
            } else
            {
                ((android.support.v4.app.u.d) (obj1)).b(5);
            }
        } else
        {
            ((android.support.v4.app.u.d) (obj1)).a(((Uri) (obj)));
            if (b(context))
            {
                ((android.support.v4.app.u.d) (obj1)).b(6);
            } else
            {
                ((android.support.v4.app.u.d) (obj1)).b(4);
            }
        }
        notificationmanager.notify(s1, 1, ((android.support.v4.app.u.d) (obj1)).a());
        return;
        obj1;
        obj = null;
_L4:
        Log.d(a, "getAppConfig", ((Throwable) (obj1)));
        j = i1;
          goto _L3
        obj1;
          goto _L4
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static boolean b(Context context)
    {
        return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
    }

}
