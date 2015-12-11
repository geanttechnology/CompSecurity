// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.smule.android.c.aa;
import com.smule.android.d;
import com.smule.android.f.l;
import com.smule.android.f.p;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.android.notifications:
//            GCMIntentService

public class a
{

    private static final String a = com/smule/android/notifications/a.getName();
    private static int b;
    private static a c = null;
    private boolean d;
    private boolean e;
    private int f;
    private String g;
    private String h;
    private AtomicBoolean i;

    public a()
    {
        d = true;
        i = new AtomicBoolean(false);
    }

    public static a a()
    {
        if (c == null)
        {
            c = new a();
        }
        return c;
    }

    public static void a(int j)
    {
        b = j;
    }

    private void a(Context context, boolean flag, String s, String s1)
    {
        int j = l.a(context);
        aa.c(a, (new StringBuilder()).append("update - updating MagicNotification info in SharedPreferences; value of registrationId is: ").append(s).toString());
        android.content.SharedPreferences.Editor editor = context.getApplicationContext().getSharedPreferences("notification_prefs", 0).edit();
        editor.putBoolean("pref_notifications_on", flag);
        editor.putBoolean("gcm_used", true);
        editor.putInt("notification_app_ver", j);
        editor.putString("notification_reg_id", s);
        editor.putString("device_id", s1);
        p.a(editor);
        e = flag;
        f = l.a(context);
        g = s;
        h = s1;
    }

    private void a(GoogleCloudMessaging googlecloudmessaging, Context context)
    {
        if (i.getAndSet(true))
        {
            aa.e(a, "registerInBackground - registration already in progress; aborting duplicate call");
            return;
        } else
        {
            (new AsyncTask(googlecloudmessaging, context) {

                final GoogleCloudMessaging a;
                final Context b;
                final a c;

                protected transient Void a(Void avoid[])
                {
                    String s = com.smule.android.network.core.b.d().a(true);
                    avoid = s;
                    if (s != null)
                    {
                        break MISSING_BLOCK_LABEL_25;
                    }
                    avoid = com.smule.android.network.core.b.d().c();
                    String s1 = a.register(new String[] {
                        GCMIntentService.a()
                    });
                    aa.c(a.c(), (new StringBuilder()).append("registerInBackground - device registered; registration ID = ").append(s1).toString());
                    if (com.smule.android.network.a.p.a(s1, avoid, true).a())
                    {
                        aa.c(a.c(), (new StringBuilder()).append("registerInBackground - network call successful; registration ID = ").append(s1).append(", device ID = ").append(avoid).toString());
                        a.a(c, b, a.a(c), s1, avoid);
                    }
_L2:
                    return null;
                    avoid;
                    aa.e(a.c(), "registerInBackground - IOException thrown while registering");
                    if (true) goto _L2; else goto _L1
_L1:
                }

                protected void a(Void void1)
                {
                    super.onPostExecute(void1);
                    com.smule.android.notifications.a.b(c).set(false);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                c = a.this;
                a = googlecloudmessaging;
                b = context;
                super();
            }
            }).execute(new Void[] {
                null, null, null
            });
            return;
        }
    }

    static void a(a a1, Context context, boolean flag, String s, String s1)
    {
        a1.a(context, flag, s, s1);
    }

    static void a(a a1, GoogleCloudMessaging googlecloudmessaging, Context context)
    {
        a1.a(googlecloudmessaging, context);
    }

    static boolean a(a a1)
    {
        return a1.e;
    }

    static boolean a(a a1, Context context)
    {
        return a1.f(context);
    }

    static String b(a a1, Context context)
    {
        return a1.e(context);
    }

    static AtomicBoolean b(a a1)
    {
        return a1.i;
    }

    static String c()
    {
        return a;
    }

    private String e(Context context)
    {
        g(context);
        if (g.isEmpty())
        {
            aa.c(a, "Registration not found.");
            return "";
        }
        int j = l.a(context);
        if (f != j)
        {
            aa.c(a, (new StringBuilder()).append("App version changed was ").append(f).append(" changed to ").append(j).append(".").toString());
            return "";
        }
        aa.c(a, "App version was not changed");
        String s = com.smule.android.network.core.b.d().a(true);
        context = s;
        if (TextUtils.isEmpty(s))
        {
            context = com.smule.android.network.core.b.d().c();
        }
        if (!context.equals(h))
        {
            aa.c(a, (new StringBuilder()).append("Device ID changed was ").append(h).append(" changed to ").append(context).append(".").toString());
            return "";
        } else
        {
            aa.c(a, "Device ID was not changed");
            return g;
        }
    }

    private boolean f(Context context)
    {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0;
    }

    private void g(Context context)
    {
        aa.c(a, (new StringBuilder()).append("readPrefs - begin; mNeedPrefs = ").append(d).toString());
        if (d)
        {
            context = context.getApplicationContext().getSharedPreferences("notification_prefs", 0);
            e = context.getBoolean("pref_notifications_on", true);
            f = context.getInt("notification_app_ver", 0);
            g = context.getString("notification_reg_id", "");
            h = context.getString("device_id", "");
            d = false;
        }
        aa.c(a, (new StringBuilder()).append("readPrefs - end value of registration id is: ").append(g).toString());
    }

    public void a(Context context)
    {
        com.smule.android.network.core.b.a(new Runnable(context) {

            final Context a;
            final a b;

            public void run()
            {
                if (!a.a(b, a))
                {
                    aa.e(a.c(), "register - Google Play services are not available; aborting register");
                    return;
                }
                GoogleCloudMessaging googlecloudmessaging = GoogleCloudMessaging.getInstance(a);
                if (com.smule.android.notifications.a.b(b, a).isEmpty())
                {
                    aa.c(a.c(), "register - registering device for push notifications.");
                    a.a(b, googlecloudmessaging, a);
                    return;
                } else
                {
                    aa.c(a.c(), "register - registrationId is not empty, so not registering again");
                    return;
                }
            }

            
            {
                b = a.this;
                a = context;
                super();
            }
        });
    }

    public void a(Context context, String s, String s1, Intent intent)
    {
        long l1 = System.currentTimeMillis();
        Notification notification = new Notification(b, s1, l1);
        notification.flags = notification.flags | 0x10;
        notification.setLatestEventInfo(context, s, s1, PendingIntent.getActivity(context, 0, intent, 0x8000000));
        ((NotificationManager)context.getSystemService("notification")).notify(1, notification);
    }

    public void a(Context context, String s, String s1, String s2, String s3, String s4)
    {
        d d1 = new d();
        d1.a = context;
        d1.b = s;
        d1.c = s1;
        d1.e = s2;
        d1.d = s3;
        d1.f = s4;
        if (!com.smule.android.network.core.b.d().a(d1))
        {
            b(context, s, s1, s2, s3, s4);
        }
    }

    public String b()
    {
        return g;
    }

    public void b(Context context)
    {
        g(context);
        c(context);
    }

    public void b(Context context, String s, String s1, String s2, String s3, String s4)
    {
        if (s == null || s1 == null || s2 == null || s3 == null)
        {
            aa.c(a, "Skipping notification. No url or tickerText or header or msg.");
            return;
        } else
        {
            s1 = new Intent("android.intent.action.VIEW", Uri.parse(s));
            s1.setData(Uri.parse(s));
            s1.putExtra("PARAMS", s4);
            s1.addFlags(0x14000000);
            a(context, s2, s3, s1);
            return;
        }
    }

    public void c(Context context)
    {
        if (e)
        {
            a(context);
        }
    }

    public void d(Context context)
    {
        g(context);
        a(context, e, g, h);
    }

}
