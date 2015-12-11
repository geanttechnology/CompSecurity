// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.data.AnalyticItem;
import com.exacttarget.etpushsdk.data.AnalyticPiItem;
import com.exacttarget.etpushsdk.data.LocationUpdate;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.database.a;
import com.exacttarget.etpushsdk.database.c;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.database.g;
import com.exacttarget.etpushsdk.database.h;
import com.exacttarget.etpushsdk.event.AnalyticItemEvent;
import com.exacttarget.etpushsdk.event.AnalyticPiItemEvent;
import com.exacttarget.etpushsdk.event.BackgroundEvent;
import com.exacttarget.etpushsdk.event.BeaconRequest;
import com.exacttarget.etpushsdk.event.BeaconResponseEvent;
import com.exacttarget.etpushsdk.event.CloudPagesResponse;
import com.exacttarget.etpushsdk.event.GeofenceRequest;
import com.exacttarget.etpushsdk.event.GeofenceResponseEvent;
import com.exacttarget.etpushsdk.event.IEventFactory;
import com.exacttarget.etpushsdk.event.LocationUpdateEvent;
import com.exacttarget.etpushsdk.event.PushReceivedEvent;
import com.exacttarget.etpushsdk.event.RegistrationEvent;
import com.exacttarget.etpushsdk.event.ServerErrorEvent;
import com.exacttarget.etpushsdk.location.b;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import com.exacttarget.etpushsdk.util.n;
import com.exacttarget.etpushsdk.util.o;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import p;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETAnalytics, ETException, ETPush, ETLocationReceiver, 
//            ETLocationManager, ETPushReceiver, ETNotifications, ETNotificationLaunchIntent, 
//            ETNotificationBuilder

public final class ETPushService extends IntentService
{

    private static final Long a = Long.valueOf(0x493e0L);
    private static final Object b = new Object();
    private final DecimalFormat c = new DecimalFormat("#.######");

    public ETPushService()
    {
        super("~!ETPushService");
    }

    private Class a(String s)
    {
        m.a("~!ETPushService", String.format("Build Factory From Response Type: %1$s", new Object[] {
            s
        }));
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!ETPushService", String.format("Error building our EventFactory from HttpResponseType: %1$s", new Object[] {
                s.getMessage()
            }), s);
            return null;
        }
        return s;
    }

    private Object a(Integer integer, List list, String s, Class class1)
    {
        m.a("~!ETPushService", String.format("Build Event From Factory: %1$s", new Object[] {
            class1.getName()
        }));
        try
        {
            class1 = (IEventFactory)class1.newInstance();
            s = ((String) (class1.fromJson(s)));
        }
        // Misplaced declaration of an exception variable
        catch (Integer integer)
        {
            m.c("~!ETPushService", String.format("Error building our Event from EventFactory: %1$s", new Object[] {
                integer.getMessage()
            }), integer);
            return null;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        s = class1;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        s = class1;
        if (list.isEmpty())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        class1.setDatabaseIds(class1, list);
        s = class1;
        a(integer, list, s);
        return s;
    }

    private String a()
    {
        return (new StringBuilder()).append("ETPushSDK/").append(o.a()).append(" (Android)").toString();
    }

    private void a(Intent intent)
    {
        Object obj;
        m.a("~!ETPushService", "Open intent.");
        intent = intent.getExtras();
        obj = (Intent)intent.getParcelable("et_push_open_intent");
        boolean flag = intent.getBoolean("et_auto_cancel", false);
        m.a("~!ETPushService", (new StringBuilder()).append("AUTOCANCEL: ").append(flag).toString());
        int j = intent.getInt("et_notification_id_key", -1);
        m.a("~!ETPushService", (new StringBuilder()).append("NOTIFICATION_ID: ").append(j).toString());
        if (flag && j > -1)
        {
            ((NotificationManager)getApplicationContext().getSystemService("notification")).cancel(j);
            getApplicationContext().sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        ((Intent) (obj)).addFlags(0x10000000);
        getApplicationContext().startActivity(((Intent) (obj)));
        if (!(com.exacttarget.etpushsdk.util.d.f() | com.exacttarget.etpushsdk.util.d.g()))
        {
            break MISSING_BLOCK_LABEL_370;
        }
        intent = ((Intent) (obj)).getExtras().getString("_m");
        j = ((Intent) (obj)).getExtras().getInt("transitionType", -1);
        String s = ((Intent) (obj)).getExtras().getString("regionId");
        if (intent == null || intent.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        try
        {
            com.exacttarget.etpushsdk.ETAnalytics.a().a(0L);
            obj = new AnalyticItem(getApplicationContext());
            ((AnalyticItem) (obj)).setEventDate(new Date());
            ((AnalyticItem) (obj)).a(2);
            ((AnalyticItem) (obj)).a(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            m.c("~!ETPushService", intent.getMessage(), intent);
            return;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        if (j != 1) goto _L4; else goto _L3
_L3:
        ((AnalyticItem) (obj)).a(6);
_L5:
        ((AnalyticItem) (obj)).a(s);
_L2:
        if (com.exacttarget.etpushsdk.util.d.f())
        {
            intent = new AnalyticItem(((AnalyticItem) (obj)));
            intent.a(4);
            com.exacttarget.etpushsdk.database.a.a(intent);
        }
        if (com.exacttarget.etpushsdk.util.d.g())
        {
            intent = new AnalyticItem(((AnalyticItem) (obj)));
            intent.a(5);
            intent.setPiAppKey("849f26e2-2df6-11e4-ab12-14109fdc48df");
            com.exacttarget.etpushsdk.database.a.a(intent);
            return;
        }
        break MISSING_BLOCK_LABEL_370;
_L4:
        if (j != 2)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        ((AnalyticItem) (obj)).a(7);
          goto _L5
        ((AnalyticItem) (obj)).a(12);
          goto _L5
        m.d("~!ETPushService", "Received invalid Intent.");
    }

    private void a(Integer integer, List list, Object obj)
    {
        Object obj1;
        Object obj2;
        int j;
        if (integer.intValue() > 0)
        {
            obj1 = "null";
        } else
        {
            obj1 = String.valueOf(integer);
        }
        if (list == null)
        {
            obj2 = "null";
        } else
        {
            obj2 = String.valueOf(list.size());
        }
        m.a("~!ETPushService", String.format("Update Event with Received Database ID: %1$s or ID List with %2$s ID(s)", new Object[] {
            obj1, obj2
        }));
        if (list == null) goto _L2; else goto _L1
_L1:
        if (list.isEmpty()) goto _L2; else goto _L3
_L3:
        m.a("~!ETPushService", String.format("Adding %1$d ID(s) from database list", new Object[] {
            Integer.valueOf(list.size())
        }));
        if (!(obj instanceof ArrayList)) goto _L5; else goto _L4
_L4:
        if (((ArrayList)obj).isEmpty()) goto _L7; else goto _L6
_L6:
        integer = null;
        j = 0;
_L8:
        if (j >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = ((ArrayList)obj).get(j);
        obj1 = integer;
        if (integer != null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj1 = obj2.getClass().getMethod("setId", new Class[] {
            java/lang/Integer
        });
        ((Method) (obj1)).invoke(obj2, new Object[] {
            list.get(j)
        });
        m.a("~!ETPushService", String.format("Added ID %s", new Object[] {
            String.valueOf(list.get(j))
        }));
        j++;
        integer = ((Integer) (obj1));
        if (true) goto _L8; else goto _L7
_L2:
        if (integer.intValue() > 0)
        {
            m.a("~!ETPushService", String.format("Adding ID %1$d", new Object[] {
                integer
            }));
            obj.getClass().getMethod("setId", new Class[] {
                java/lang/Integer
            }).invoke(obj, new Object[] {
                integer
            });
            return;
        }
        break MISSING_BLOCK_LABEL_379;
_L5:
        try
        {
            m.a("~!ETPushService", "Adding to single class");
            obj.getClass().getMethod("setDatabaseIds", new Class[] {
                java/util/List
            }).invoke(obj, new Object[] {
                list
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Integer integer)
        {
            m.c("~!ETPushService", String.format("Error updating our Event with Received Database IDs: %1$s", new Object[] {
                integer.getMessage()
            }), integer);
        }
        return;
        m.a("~!ETPushService", "Nothing to do, no databaseIds sent");
_L7:
    }

    private void a(String s, String s1, String s2, Integer integer, List list, String s3)
    {
        Object obj;
        int j;
        try
        {
            m.a("~!ETPushService", "Sending data...");
            s1 = s1.replaceAll("\\{et_app_id\\}", com.exacttarget.etpushsdk.util.d.b());
            obj = new DefaultHttpClient();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!ETPushService", String.format("Error sending data: %1$s", new Object[] {
                s.getMessage()
            }), s);
            return;
        }
        j = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 987
    //                   70454: 132
    //                   79599: 164
    //                   2461856: 148;
           goto _L1 _L2 _L3 _L4
_L23:
        throw new ETException((new StringBuilder()).append("Invalid Request Method: ").append(s).append(", only GET, POST, PUT supported.").toString());
_L2:
        if (s.equals("GET"))
        {
            j = 0;
        }
          goto _L1
_L4:
        if (s.equals("POST"))
        {
            j = 1;
        }
          goto _L1
_L3:
        if (s.equals("PUT"))
        {
            j = 2;
        }
          goto _L1
_L24:
        s = new HttpGet(s1);
_L13:
        s.setHeader("Accept", "application/json");
        s.setHeader("User-Agent", a());
        s.setHeader("Authorization", String.format("Bearer %1$s", new Object[] {
            com.exacttarget.etpushsdk.util.d.c()
        }));
        m.a("~!ETPushService", (new StringBuilder()).append("Request Url: ").append(s1).toString());
        m.a("~!ETPushService", (new StringBuilder()).append("Request data: ").append(s3).toString());
        long l = SystemClock.elapsedRealtime();
        obj = p.a(((org.apache.http.client.HttpClient) (obj)), s);
        m.a("~!ETPushService", (new StringBuilder()).append("Request took: ").append(SystemClock.elapsedRealtime() - l).append("ms").toString());
        j = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        if (j < 200 || j > 299) goto _L6; else goto _L5
_L5:
        m.a("~!ETPushService", (new StringBuilder()).append("Success with StatusCode: ").append(String.valueOf(j)).toString());
_L18:
        s3 = ((HttpResponse) (obj)).getEntity();
        s = null;
        s1 = integer;
        if (s3 == null) goto _L8; else goto _L7
_L7:
        s3 = EntityUtils.toString(s3);
        if (j < 200 || j > 299) goto _L10; else goto _L9
_L9:
        m.a("~!ETPushService", (new StringBuilder()).append("Success Response: ").append(s3).toString());
        s1 = integer;
        s = s3;
_L8:
        if (TextUtils.isEmpty(s2) || j < 200 || j > 299) goto _L12; else goto _L11
_L11:
        m.a("~!ETPushService", String.format("Creating Event: %1$s", new Object[] {
            s2
        }));
        s2 = a(s2);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_613;
        }
        s = ((String) (a(((Integer) (s1)), list, s, ((Class) (s2)))));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_613;
        }
        if (s instanceof RegistrationEvent)
        {
            m.a("~!ETPushService", "Saving a hash of our registration.");
            com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "previousRegistrationHash", b(((RegistrationEvent)s).toJson()));
        }
        m.a("~!ETPushService", String.format("Posting %1$s to EventBus", new Object[] {
            s.getClass().getName()
        }));
        EventBus.getInstance().a(s);
_L22:
        m.a("~!ETPushService", "Sending data done.");
        return;
_L25:
        s = new HttpPost(s1);
        ((HttpPost)s).setEntity(new StringEntity(s3));
        s.setHeader("Content-type", "application/json");
          goto _L13
_L26:
        s = new HttpPut(s1);
        ((HttpPut)s).setEntity(new StringEntity(s3));
        s.setHeader("Content-type", "application/json");
          goto _L13
_L6:
        if (j < 400 || j > 499) goto _L15; else goto _L14
_L14:
        m.c("~!ETPushService", (new StringBuilder()).append("Warning with StatusCode: ").append(String.valueOf(j)).toString());
        if (j != 402) goto _L17; else goto _L16
_L16:
        m.c("~!ETPushService", "You are attempting to use a feature that is not enabled in your account. If you believe this is incorrect, please contact Global Support.");
          goto _L18
_L17:
        m.c("~!ETPushService", "A client error occurred while communicating with ExactTarget. Please verify that you have everything configured correctly.");
          goto _L18
_L15:
        m.d("~!ETPushService", (new StringBuilder()).append("Error with StatusCode: ").append(String.valueOf(j)).toString());
          goto _L18
_L10:
        if (j < 400 || j > 499) goto _L20; else goto _L19
_L19:
        m.c("~!ETPushService", (new StringBuilder()).append("Warning Response: ").append(s3).toString());
        s = s3;
        s1 = integer;
          goto _L8
_L20:
        m.d("~!ETPushService", (new StringBuilder()).append("Error Response: ").append(s3).toString());
        s = s3;
        s1 = integer;
        if (s2.equals(com/exacttarget/etpushsdk/event/GeofenceResponseEvent.getName())) goto _L8; else goto _L21
_L21:
        s1 = Integer.valueOf(0);
        s = s3;
          goto _L8
_L12:
        m.d("~!ETPushService", String.format("Posting an error event to EventBus.  Error was: %1$s", new Object[] {
            ((HttpResponse) (obj)).getStatusLine().getReasonPhrase()
        }));
        EventBus.getInstance().a(new ServerErrorEvent(((HttpResponse) (obj)).getStatusLine().getReasonPhrase(), Integer.valueOf(j)));
          goto _L22
_L1:
        j;
        JVM INSTR tableswitch 0 2: default 1016
    //                   0 180
    //                   1 623
    //                   2 663;
           goto _L23 _L24 _L25 _L26
    }

    private void a(boolean flag)
    {
        PackageManager packagemanager = com.exacttarget.etpushsdk.ETPush.a().getPackageManager();
        ComponentName componentname = new ComponentName(com.exacttarget.etpushsdk.ETPush.a(), com/exacttarget/etpushsdk/ETLocationReceiver);
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        packagemanager.setComponentEnabledSetting(componentname, byte0, 1);
    }

    private String b(String s)
    {
        m.a("~!ETPushService", String.format("createHash(final String string) // string = '%s'", new Object[] {
            s
        }));
        byte abyte0[];
        StringBuilder stringbuilder;
        int j;
        int k;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuilder = new StringBuilder();
            k = abyte0.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        j = 0;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        for (s = Integer.toHexString(abyte0[j] & 0xff); s.length() < 2; s = (new StringBuilder()).append("0").append(s).toString()) { }
        stringbuilder.append(s);
        j++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_55;
_L1:
        m.a("~!ETPushService", String.format("return %s", new Object[] {
            stringbuilder.toString()
        }));
        s = stringbuilder.toString();
        return s;
    }

    private void b()
    {
        if (!com.exacttarget.etpushsdk.util.d.h() || !ETLocationManager.getInstance().isWatchingLocation() && !ETLocationManager.getInstance().isWatchingProximity())
        {
            break MISSING_BLOCK_LABEL_240;
        }
        m.a("~!ETPushService", "Location on and watching location...");
        if (!((Boolean)com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_key_run_once", Boolean.valueOf(false), new Object[] {
    PreferenceManager.getDefaultSharedPreferences(com.exacttarget.etpushsdk.ETPush.a())
})).booleanValue())
        {
            break MISSING_BLOCK_LABEL_240;
        }
        b b1 = new b((LocationManager)com.exacttarget.etpushsdk.ETPush.a().getSystemService("location"));
        Boolean boolean1 = (Boolean)com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_key_follow_location_changes", Boolean.valueOf(true), new Object[] {
            PreferenceManager.getDefaultSharedPreferences(com.exacttarget.etpushsdk.ETPush.a())
        });
        try
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("active", Boolean.FALSE);
            g.a(null, null, contentvalues);
        }
        catch (Exception exception)
        {
            m.c("~!ETPushService", exception.getMessage(), exception);
        }
        if (boolean1.booleanValue())
        {
            Intent intent = new Intent(com.exacttarget.etpushsdk.ETPush.a(), com/exacttarget/etpushsdk/ETLocationReceiver);
            intent.setAction("et_location_action_passive_location_change");
            b1.a(0x493e0L, 0L, PendingIntent.getActivity(com.exacttarget.etpushsdk.ETPush.a(), 1003, intent, 0x8000000));
        }
        if (ETLocationManager.getInstance().isWatchingLocation())
        {
            ETLocationManager.getInstance().f(true);
            ETLocationManager.getInstance().a(false);
        }
        if (ETLocationManager.getInstance().isWatchingProximity())
        {
            ETLocationManager.getInstance().h(true);
            ETLocationManager.getInstance().b(false);
        }
        return;
        ETException etexception;
        etexception;
        m.c("~!ETPushService", etexception.getMessage(), etexception);
        return;
    }

    private void b(Intent intent)
    {
        m.a("~!ETPushService", "packageReplaced() started.");
        String s = getApplicationContext().getPackageName();
        if (intent.getExtras().getInt("android.intent.extra.UID") == Process.myUid())
        {
            m.a("~!ETPushService", String.format("Package replace started for %1$s", new Object[] {
                s
            }));
            ETPush.getInstance().i();
        } else
        {
            m.a("~!ETPushService", "Some other application updated.  Nothing to see here.");
        }
        m.a("~!ETPushService", "packageReplaced() ended.");
    }

    private void c(Intent intent)
    {
        m.a("~!ETPushService", "appShutdown() started.");
        long l;
        boolean flag;
        boolean flag1;
        if (com.exacttarget.etpushsdk.util.d.h())
        {
            m.a("~!ETPushService", "Checking if we are currently tracking geoFence entry times.");
            flag = com.exacttarget.etpushsdk.ETAnalytics.a().b();
        } else
        {
            flag = false;
        }
        if (com.exacttarget.etpushsdk.util.d.i())
        {
            m.a("~!ETPushService", "Checking if we are currently tracking Beacon entry times.");
            flag1 = com.exacttarget.etpushsdk.ETAnalytics.a().c();
        } else
        {
            flag1 = false;
        }
        l = ((Long)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "pause_time_key", Long.valueOf(-1L), new Object[0])).longValue();
        m.a("~!ETPushService", String.format("Pause time: %d", new Object[] {
            Long.valueOf(l)
        }));
        if (l == -1L) goto _L2; else goto _L1
_L1:
        com.exacttarget.etpushsdk.ETPush.d();
        d(intent);
_L4:
        m.a("~!ETPushService", "appShutdown() ended.");
        return;
_L2:
        if (flag || flag1)
        {
            intent = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushReceiver);
            intent.putExtra("et_send_type_extra", "et_send_type_analytic_events");
            getApplicationContext().sendBroadcast(intent);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void d(Intent intent)
    {
        m.a("~!ETPushService", "appInBackground() started.");
        long l;
        try
        {
            com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "pause_time_key");
            m.a("~!ETPushService", String.format("%s removed", new Object[] {
                "pause_time_key"
            }));
            i.a().c();
            m.a("~!ETPushService", "SQLite VACUUM complete");
        }
        catch (Exception exception)
        {
            m.c("~!ETPushService", String.format("SQLite VACUUM had an exception that we will ignore: %s", new Object[] {
                exception.getMessage()
            }), exception);
        }
        l = intent.getLongExtra("time_went_in_background", -1L);
        m.a("~!ETPushService", "Notify that app has gone into background.");
        EventBus.getInstance().b(new BackgroundEvent(true, l));
        m.a("~!ETPushService", "appInBackground() ended.");
    }

    private void e(Intent intent)
    {
        Object obj;
        Long long1;
        obj = intent.getStringExtra("et_send_type_extra");
        m.a("~!ETPushService", String.format("Sending data for: %s", new Object[] {
            obj
        }));
        long1 = Long.valueOf(System.currentTimeMillis());
        if (!"et_send_type_analytic_events".equals(obj) || com.exacttarget.etpushsdk.util.d.a(getApplicationContext())) goto _L2; else goto _L1
_L1:
        Object obj1 = com.exacttarget.etpushsdk.database.a.a("pi_app_key IS NULL AND ready_to_send = ? ", new String[] {
            "1"
        }, null, null, "id ASC ");
        obj = new StringBuilder();
        intent = "";
        ((StringBuilder) (obj)).append("[");
        ArrayList arraylist = new ArrayList();
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            AnalyticItem analyticitem = (AnalyticItem)((Iterator) (obj1)).next();
            analyticitem.setLastSent(long1);
            com.exacttarget.etpushsdk.database.a.b(analyticitem);
            if (analyticitem.getValue().intValue() <= 0)
            {
                com.exacttarget.etpushsdk.database.a.a(analyticitem.getId().intValue());
            } else
            {
                arraylist.add(analyticitem.getId());
                ((StringBuilder) (obj)).append(intent).append(analyticitem.a());
                intent = ",";
            }
        }

        if (((StringBuilder) (obj)).length() > 0)
        {
            ((StringBuilder) (obj)).append("]");
            m.a("~!ETPushService", (new StringBuilder()).append("AnalyticItems (JSON): ").append(((StringBuilder) (obj)).toString()).toString());
            intent = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
            intent.putExtra("param_database_ids", (Serializable)arraylist);
            intent.putExtra("param_http_method", "POST");
            intent.putExtra("param_http_url", "https://consumer.exacttargetapis.com/device/v1/event/analytic");
            intent.putExtra("param_http_response_type", com/exacttarget/etpushsdk/event/AnalyticItemEvent.getName());
            intent.putExtra("param_data_json", ((StringBuilder) (obj)).toString());
            f(intent);
        }
_L10:
        return;
_L2:
        if (!"pi_send_type_analytic_events".equals(obj) || com.exacttarget.etpushsdk.util.d.a(getApplicationContext())) goto _L4; else goto _L3
_L3:
        ArrayList arraylist1;
        boolean flag;
        boolean flag1;
        String s1;
        String s2;
        Iterator iterator;
        AnalyticItem analyticitem1;
        Calendar calendar;
        Calendar calendar1;
        String s3;
        try
        {
            obj = com.exacttarget.etpushsdk.database.a.a("pi_app_key IS NOT NULL AND ready_to_send = ? ", new String[] {
                "1"
            }, null, null, "id ASC ");
            s1 = (String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_user_id_cache", null, new Object[0]);
            s2 = (String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_session_id_cache", null, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            m.c("~!ETPushService", intent.getMessage(), intent);
            return;
        }
        intent = null;
        arraylist1 = new ArrayList();
        iterator = ((List) (obj)).iterator();
_L11:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        analyticitem1 = (AnalyticItem)iterator.next();
        analyticitem1.setLastSent(long1);
        com.exacttarget.etpushsdk.database.a.b(analyticitem1);
        if (analyticitem1.getValue().intValue() > 0) goto _L8; else goto _L7
_L7:
        com.exacttarget.etpushsdk.database.a.a(analyticitem1.getId().intValue());
        obj = intent;
        break MISSING_BLOCK_LABEL_2229;
_L8:
        arraylist1.add(analyticitem1.getId());
        calendar = Calendar.getInstance();
        calendar.setTime(analyticitem1.getEventDate());
        calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(calendar.getTimeInMillis());
        calendar1.add(13, analyticitem1.getValue().intValue());
        if (intent != null)
        {
            break MISSING_BLOCK_LABEL_830;
        }
        intent = new AnalyticPiItem(getApplicationContext());
        intent.setApiKey("849f26e2-2df6-11e4-ab12-14109fdc48df");
        intent.setAppId(com.exacttarget.etpushsdk.util.d.b());
        intent.setUserId(s1);
        intent.setSessionId(s2);
        intent.setPushEnabled(Boolean.valueOf(ETPush.getInstance().isPushEnabled()));
        intent.setManufacturer((String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_manufacturer_cache", null, new Object[0]));
        intent.setPlatform((String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_platform_cache", null, new Object[0]));
        intent.setPlatformVersion((String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_platform_version_cache", null, new Object[0]));
        intent.setDeviceType((String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_model_cache", null, new Object[0]));
        intent.setDeviceId((String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_device_id_cache", null, new Object[0]));
        if (!com.exacttarget.etpushsdk.util.d.h() || !ETLocationManager.getInstance().isWatchingLocation())
        {
            break MISSING_BLOCK_LABEL_830;
        }
        obj = (String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_last_location_latitude", null, new Object[0]);
        s3 = (String)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_last_location_longitude", null, new Object[0]);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(s3))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!(flag1 & flag))
        {
            break MISSING_BLOCK_LABEL_830;
        }
        intent.setLatitude(Double.valueOf(((String) (obj))).doubleValue());
        intent.setLongitude(Double.valueOf(s3).doubleValue());
        intent.a(calendar.getTime(), calendar1.getTime(), analyticitem1.getAnalyticTypes().contains(Integer.valueOf(2)));
        obj = intent;
        if (ETPush.getLogLevel() > 3)
        {
            break MISSING_BLOCK_LABEL_2229;
        }
        obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        ((SimpleDateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("UTC"));
        m.a("~!ETPushService", (new StringBuilder()).append("Time in app start time: ").append(((SimpleDateFormat) (obj)).format(calendar.getTime())).append(" end time: ").append(((SimpleDateFormat) (obj)).format(calendar1.getTime())).append(" from push: ").append(analyticitem1.getAnalyticTypes().contains(Integer.valueOf(2))).toString());
        obj = intent;
        break MISSING_BLOCK_LABEL_2229;
_L6:
        if (intent == null) goto _L10; else goto _L9
_L9:
        m.a("~!ETPushService", (new StringBuilder()).append("PI Items:").append(intent.a()).toString());
        obj = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
        ((Intent) (obj)).putExtra("param_database_ids", (Serializable)arraylist1);
        ((Intent) (obj)).putExtra("param_http_method", "POST");
        ((Intent) (obj)).putExtra("param_http_url", "https://app.igodigital.com/api/v1/collect/process_batch");
        ((Intent) (obj)).putExtra("param_http_response_type", com/exacttarget/etpushsdk/event/AnalyticPiItemEvent.getName());
        ((Intent) (obj)).putExtra("param_data_json", intent.a());
        f(((Intent) (obj)));
        return;
_L4:
        if ("et_send_type_registration".equals(obj) && !com.exacttarget.etpushsdk.util.d.a(getApplicationContext()))
        {
            intent = h.a();
            if (intent != null)
            {
                obj = (String)com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "previousRegistrationHash", null, new Object[0]);
                m.a("~!ETPushService", String.format("%s = %s", new Object[] {
                    "previousRegistrationHash", obj
                }));
                String s = b(intent.toJson());
                if (obj != null && s.equals(obj))
                {
                    m.a("~!ETPushService", "This registration contained no changes.  SKIP registration send.");
                    return;
                } else
                {
                    intent.setLastSent(long1);
                    h.b(intent);
                    obj = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
                    ((Intent) (obj)).putExtra("param_database_id", intent.getId());
                    m.a("~!ETPushService", String.format("Registration (JSON): %1$s", new Object[] {
                        intent.toJson()
                    }));
                    m.a("~!ETPushService", (new StringBuilder()).append("REGISTRATION ID: ").append(intent.getId()).toString());
                    ((Intent) (obj)).putExtra("param_http_method", "POST");
                    ((Intent) (obj)).putExtra("param_http_url", "https://consumer.exacttargetapis.com/device/v1/registration");
                    ((Intent) (obj)).putExtra("param_http_response_type", com/exacttarget/etpushsdk/event/RegistrationEvent.getName());
                    ((Intent) (obj)).putExtra("param_data_json", intent.toJson());
                    f(((Intent) (obj)));
                    return;
                }
            } else
            {
                m.a("~!ETPushService", "Nothing to send.  SKIP registration send.");
                return;
            }
        }
        if ("et_send_type_location".equals(obj) && !com.exacttarget.etpushsdk.util.d.a(getApplicationContext()))
        {
            intent = com.exacttarget.etpushsdk.database.d.a("last_sent < ?", new String[] {
                String.valueOf(long1.longValue() - a.longValue())
            }, null, null, "id ASC ").iterator();
            while (intent.hasNext()) 
            {
                obj = (LocationUpdate)intent.next();
                ((LocationUpdate) (obj)).setLastSent(long1);
                com.exacttarget.etpushsdk.database.d.b(((LocationUpdate) (obj)));
                m.a("~!ETPushService", String.format("LocationUpdate (JSON): %1$s", new Object[] {
                    ((LocationUpdate) (obj)).toJson()
                }));
                m.a("~!ETPushService", (new StringBuilder()).append("Send Location Update for: ").append(((LocationUpdate) (obj)).getId()).toString());
                Intent intent1 = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
                intent1.putExtra("param_database_id", ((LocationUpdate) (obj)).getId());
                intent1.putExtra("param_http_method", "POST");
                intent1.putExtra("param_http_url", "https://consumer.exacttargetapis.com/device/v1/location/{et_app_id}");
                intent1.putExtra("param_http_response_type", com/exacttarget/etpushsdk/event/LocationUpdateEvent.getName());
                intent1.putExtra("param_data_json", ((LocationUpdate) (obj)).toJson());
                f(intent1);
            }
        } else
        if ("et_send_type_geofence".equals(obj))
        {
            intent = com.exacttarget.etpushsdk.database.c.a(null, null, null, null, null);
            if (intent != null && intent.size() > 0)
            {
                obj = (GeofenceRequest)intent.get(intent.size() - 1);
                com.exacttarget.etpushsdk.database.c.a(intent);
                obj = "https://consumer.exacttargetapis.com/device/v1/location/{et_app_id}/fence/?latitude={latitude}&longitude={longitude}&deviceid={device_id}".replaceAll("\\{device_id\\}", ((GeofenceRequest) (obj)).getDeviceId()).replaceAll("\\{latitude\\}", c.format(((GeofenceRequest) (obj)).getLatitude())).replaceAll("\\{longitude\\}", c.format(((GeofenceRequest) (obj)).getLongitude()));
                intent = ((Intent) (obj));
                if (com.exacttarget.etpushsdk.util.d.a(getApplicationContext().getApplicationContext()))
                {
                    intent = (new StringBuilder()).append(((String) (obj))).append("&all=true").toString();
                }
                obj = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
                ((Intent) (obj)).putExtra("param_http_method", "GET");
                ((Intent) (obj)).putExtra("param_http_url", intent);
                ((Intent) (obj)).putExtra("param_http_response_type", com/exacttarget/etpushsdk/event/GeofenceResponseEvent.getName());
                f(((Intent) (obj)));
                return;
            }
        } else
        if ("et_send_type_proximity".equals(obj))
        {
            intent = com.exacttarget.etpushsdk.database.b.a(null, null, null, null, null);
            if (intent != null && intent.size() > 0)
            {
                obj = (BeaconRequest)intent.get(intent.size() - 1);
                com.exacttarget.etpushsdk.database.b.a(intent);
                obj = "https://consumer.exacttargetapis.com/device/v1/location/{et_app_id}/proximity/?latitude={latitude}&longitude={longitude}&deviceid={device_id}".replaceAll("\\{device_id\\}", ((BeaconRequest) (obj)).getDeviceId()).replaceAll("\\{latitude\\}", c.format(((BeaconRequest) (obj)).getLatitude())).replaceAll("\\{longitude\\}", c.format(((BeaconRequest) (obj)).getLongitude()));
                intent = ((Intent) (obj));
                if (com.exacttarget.etpushsdk.util.d.a(getApplicationContext().getApplicationContext()))
                {
                    intent = (new StringBuilder()).append(((String) (obj))).append("&all=true").toString();
                }
                obj = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
                ((Intent) (obj)).putExtra("param_http_method", "GET");
                ((Intent) (obj)).putExtra("param_http_url", intent);
                ((Intent) (obj)).putExtra("param_http_response_type", com/exacttarget/etpushsdk/event/BeaconResponseEvent.getName());
                f(((Intent) (obj)));
                return;
            }
        } else
        {
            if ("et_send_type_cloudpage".equals(obj))
            {
                intent = "https://consumer.exacttargetapis.com/device/v1/{et_app_id}/message/?deviceid={device_id}&messagetype={messagetype}&contenttype={contenttype}".replaceAll("\\{device_id\\}", com.exacttarget.etpushsdk.util.g.uniqueDeviceIdentifier(getApplicationContext())).replaceAll("\\{messagetype\\}", Message.b.toString()).replaceAll("\\{contenttype\\}", Message.i.toString());
                obj = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
                ((Intent) (obj)).putExtra("param_http_method", "GET");
                ((Intent) (obj)).putExtra("param_http_url", intent);
                ((Intent) (obj)).putExtra("param_http_response_type", com/exacttarget/etpushsdk/event/CloudPagesResponse.getName());
                f(((Intent) (obj)));
                return;
            }
            if ("et_send_type_custom_app_request".equals(obj))
            {
                obj = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushService);
                ((Intent) (obj)).putExtra("param_http_method", intent.getStringExtra("param_http_method"));
                ((Intent) (obj)).putExtra("param_http_url", intent.getStringExtra("param_http_url"));
                ((Intent) (obj)).putExtra("param_http_response_type", intent.getStringExtra("param_http_response_type"));
                intent = intent.getStringExtra("param_data_json");
                if (intent != null && intent.length() > 0)
                {
                    ((Intent) (obj)).putExtra("param_data_json", intent);
                }
                f(((Intent) (obj)));
                return;
            }
            if (!com.exacttarget.etpushsdk.util.d.a(getApplicationContext()))
            {
                m.d("~!ETPushService", (new StringBuilder()).append("Unknown SEND_TYPE for ETSendDataReceiver: ").append(((String) (obj))).toString());
                return;
            }
        }
          goto _L10
        intent = ((Intent) (obj));
          goto _L11
    }

    private void f(Intent intent)
    {
        m.a("~!ETPushService", "initiateHttpSend()");
        Integer integer = Integer.valueOf(intent.getIntExtra("param_database_id", -1));
        Object obj;
        String s;
        String s1;
        String s2;
        if (integer.intValue() > 0)
        {
            obj = "null";
        } else
        {
            obj = String.valueOf(integer);
        }
        m.a("~!ETPushService", String.format("Database ID from Intent: %s", new Object[] {
            obj
        }));
        obj = (List)intent.getSerializableExtra("param_database_ids");
        s = intent.getStringExtra("param_http_method");
        s1 = intent.getStringExtra("param_http_url");
        s2 = intent.getStringExtra("param_http_response_type");
        intent = intent.getStringExtra("param_data_json");
        if (n.b(getApplicationContext()))
        {
            a(s, s1, s2, integer, ((List) (obj)), intent);
            return;
        } else
        {
            m.c("~!ETPushService", "SendUpdate: Network not available");
            return;
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        android.os.PowerManager.WakeLock wakelock;
        m.a("~!ETPushService", String.format("%s.onHandleIntent()", new Object[] {
            getClass().getSimpleName()
        }));
        wakelock = ((PowerManager)getSystemService("power")).newWakeLock(1, "~!ETPushService");
        wakelock.acquire();
        ETPushReceiver.completeWakefulIntent(intent);
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = intent.getStringExtra("et_push_action");
        com.exacttarget.etpushsdk.ETPush.c();
        obj2 = intent.getStringExtra("registration_id");
        obj = intent.getStringExtra("error");
        obj3 = intent.getStringExtra("unregistered");
        int j = -1;
        ((String) (obj1)).hashCode();
        JVM INSTR lookupswitch 13: default 1667
    //                   -1980154005: 288
    //                   -1172645946: 410
    //                   -810471698: 305
    //                   -743092218: 356
    //                   366519424: 374
    //                   490310653: 271
    //                   798292259: 254
    //                   1060266838: 392
    //                   1736128796: 339
    //                   1947666138: 322
    //                   2074178206: 428
    //                   2074287068: 446
    //                   2124850837: 464;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L43:
        if (!com.exacttarget.etpushsdk.util.d.a(getApplicationContext()))
        {
            m.d("~!ETPushService", (new StringBuilder()).append("Unknown PUSH_ACTION for ETPushService: ").append(((String) (obj1))).toString());
        }
_L15:
        wakelock.release();
        return;
_L8:
        if (((String) (obj1)).equals("android.intent.action.BOOT_COMPLETED"))
        {
            j = 0;
        }
          goto _L1
_L7:
        if (((String) (obj1)).equals("android.intent.action.BATTERY_LOW"))
        {
            j = 1;
        }
          goto _L1
_L2:
        if (((String) (obj1)).equals("android.intent.action.BATTERY_OKAY"))
        {
            j = 2;
        }
          goto _L1
_L4:
        if (((String) (obj1)).equals("android.intent.action.PACKAGE_REPLACED"))
        {
            j = 3;
        }
          goto _L1
_L11:
        if (((String) (obj1)).equals("android.intent.action.ACTION_SHUTDOWN"))
        {
            j = 4;
        }
          goto _L1
_L10:
        if (((String) (obj1)).equals("com.google.android.c2dm.intent.REGISTRATION"))
        {
            j = 5;
        }
          goto _L1
_L5:
        if (((String) (obj1)).equals("com.amazon.device.messaging.intent.REGISTRATION"))
        {
            j = 6;
        }
          goto _L1
_L6:
        if (((String) (obj1)).equals("com.google.android.c2dm.intent.RECEIVE"))
        {
            j = 7;
        }
          goto _L1
_L9:
        if (((String) (obj1)).equals("com.amazon.device.messaging.intent.RECEIVE"))
        {
            j = 8;
        }
          goto _L1
_L3:
        if (((String) (obj1)).equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
            j = 9;
        }
          goto _L1
_L12:
        if (((String) (obj1)).equals("et_push_action_open"))
        {
            j = 10;
        }
          goto _L1
_L13:
        if (((String) (obj1)).equals("et_push_action_send"))
        {
            j = 11;
        }
          goto _L1
_L14:
        if (((String) (obj1)).equals("et_push_app_in_background"))
        {
            j = 12;
        }
          goto _L1
_L44:
        try
        {
            m.a("~!ETPushService", "Boot completed.");
            b();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            m.c("~!ETPushService", intent.getMessage(), intent);
        }
          goto _L15
_L45:
        m.a("~!ETPushService", "Battery low.");
        a(true);
        ETLocationManager.getInstance().a();
          goto _L15
_L46:
        m.a("~!ETPushService", "Battery okay now.");
        a(false);
        ETLocationManager.getInstance().b();
          goto _L15
_L47:
        m.a("~!ETPushService", "Package replaced has been called.");
        b(intent);
          goto _L15
_L48:
        m.a("~!ETPushService", "Device is shutting down.");
        c(intent);
          goto _L15
_L49:
        m.a("~!ETPushService", "Received a registration event from Google.");
        if (obj == null) goto _L17; else goto _L16
_L16:
        m.d("~!ETPushService", (new StringBuilder()).append("GCM Registration error: ").append(((String) (obj))).toString());
        intent = new ServerErrorEvent();
        intent.setMessage((new StringBuilder()).append("GCM Registration error: ").append(((String) (obj))).toString());
        EventBus.getInstance().a(intent);
          goto _L15
_L17:
        if (obj3 == null) goto _L19; else goto _L18
_L18:
        m.d("~!ETPushService", "GCM Unregistered.  This should not happen.");
          goto _L15
_L19:
        if (obj2 == null) goto _L15; else goto _L20
_L20:
        m.a("~!ETPushService", String.format("GCM Registration complete. System Token received: %s", new Object[] {
            obj2
        }));
        ETPush.getInstance().a(((String) (obj2)));
          goto _L15
_L50:
        m.a("~!ETPushService", "Received a registration event from Amazon.");
        if (obj == null) goto _L22; else goto _L21
_L21:
        m.d("~!ETPushService", (new StringBuilder()).append("ADM Registration error: ").append(((String) (obj))).toString());
          goto _L15
_L22:
        if (obj3 == null) goto _L24; else goto _L23
_L23:
        m.d("~!ETPushService", "ADM Unregistered.  This should not happen");
          goto _L15
_L24:
        if (obj2 == null) goto _L15; else goto _L25
_L25:
        m.a("~!ETPushService", String.format("ADM Registration complete. System Token received: %s", new Object[] {
            obj2
        }));
        ETPush.getInstance().a(((String) (obj2)));
          goto _L15
_L51:
        m.a("~!ETPushService", "Hello from ExactTarget! Push Message received.");
        if (!ETPush.getInstance().isPushEnabled())
        {
            m.a("~!ETPushService", "Push is disabled. Thanks for playing.");
            return;
        }
        obj1 = intent.getExtras();
        if (ETPush.getLogLevel() > 3) goto _L27; else goto _L26
_L26:
        obj = ((Bundle) (obj1)).keySet().iterator();
        intent = "";
        while (((Iterator) (obj)).hasNext()) 
        {
            obj2 = (String)((Iterator) (obj)).next();
            intent = (new StringBuilder()).append(intent).append("[").append(((String) (obj2))).append(":").append(((Bundle) (obj1)).get(((String) (obj2)))).append("] ").toString();
        }
        m.a("~!ETPushService", (new StringBuilder()).append("Payload: ").append(intent).toString());
_L27:
        if (!((Bundle) (obj1)).containsKey("regionId") && ((Bundle) (obj1)).containsKey("_m") && com.exacttarget.etpushsdk.util.d.f())
        {
            com.exacttarget.etpushsdk.ETAnalytics.a().b(((Bundle) (obj1)).getString("_m"));
        }
        if (ETNotifications.getNotificationLaunchIntent() == null) goto _L29; else goto _L28
_L28:
        intent = ETNotifications.getNotificationLaunchIntent().setupLaunchIntent(getApplicationContext(), ((Bundle) (obj1)));
_L36:
        obj2 = new Intent((new StringBuilder()).append(getApplicationContext().getPackageName()).append(".MESSAGE_OPENED").toString());
        ((Intent) (obj2)).putExtra("et_open_type_extra", "et_push_action_open");
        ((Intent) (obj2)).putExtra("et_push_open_intent", intent);
        obj = b;
        obj;
        JVM INSTR monitorenter ;
        j = ((Integer)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_notification_id_key", Integer.valueOf(0), new Object[] {
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
        })).intValue();
        m.a("~!ETPushService", (new StringBuilder()).append("NOTIFICATION_ID: ").append(j).toString());
        ((Intent) (obj2)).putExtra("et_notification_id_key", j);
        obj3 = ((Bundle) (obj1)).getString("_m");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_1244;
        }
        obj3 = com.exacttarget.etpushsdk.database.e.a(((Bundle) (obj1)).getString("_m"));
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_1244;
        }
        ((Message) (obj3)).setNotifyId(Integer.valueOf(j));
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("notify_id", Integer.valueOf(j));
        com.exacttarget.etpushsdk.database.e.a(((Message) (obj3)).getId(), contentvalues);
_L37:
        j++;
        com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_notification_id_key", Integer.valueOf(j));
        obj;
        JVM INSTR monitorexit ;
        if (ETNotifications.getNotificationBuilder() == null) goto _L31; else goto _L30
_L30:
        obj = ETNotifications.getNotificationBuilder().setupNotificationBuilder(getApplicationContext(), ((Bundle) (obj1)));
_L38:
        if (obj == null || intent == null) goto _L33; else goto _L32
_L32:
        ((android.support.v4.app.NotificationCompat.Builder) (obj)).setContentIntent(ETNotifications.setupLaunchPendingIntent(getApplicationContext(), ((Intent) (obj2)), false));
_L33:
        if (obj == null) goto _L35; else goto _L34
_L34:
        intent = ((android.support.v4.app.NotificationCompat.Builder) (obj)).build();
        ((NotificationManager)getApplicationContext().getSystemService("notification")).notify(j, intent);
_L35:
        EventBus.getInstance().a(new PushReceivedEvent(((Bundle) (obj1))));
          goto _L15
_L29:
        intent = ETNotifications.setupLaunchIntent(getApplicationContext(), ((Bundle) (obj1)));
          goto _L36
        Exception exception;
        exception;
        m.c("~!ETPushService", exception.getMessage(), exception);
          goto _L37
        intent;
        obj;
        JVM INSTR monitorexit ;
        throw intent;
_L31:
        obj = ETNotifications.setupNotificationBuilder(getApplicationContext(), ((Bundle) (obj1)));
          goto _L38
_L52:
        m.a("~!ETPushService", "Received a connectivity change.");
        ((Integer)com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_last_connection_state", Integer.valueOf(99), new Object[0])).intValue();
        JVM INSTR tableswitch 0 1: default 1739
    //                   0 1524
    //                   1 1604;
           goto _L39 _L40 _L41
_L39:
        m.a("~!ETPushService", "Last connection state was UNKNOWN.");
_L42:
        if (n.b(getApplicationContext()))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        m.a("~!ETPushService", String.format("Saving state: %1d", new Object[] {
            Integer.valueOf(j)
        }));
        com.exacttarget.etpushsdk.util.d.a(getApplicationContext(), "et_last_connection_state", Integer.valueOf(j));
          goto _L15
_L40:
        m.a("~!ETPushService", "Last connection state was OFF.");
        if (n.b(getApplicationContext()))
        {
            m.a("~!ETPushService", "Now online, check if registrations need to be sent");
            if (h.a() != null)
            {
                m.a("~!ETPushService", "There are saved registrations.  Send them.");
                intent = new Intent(getApplicationContext(), com/exacttarget/etpushsdk/ETPushReceiver);
                intent.putExtra("et_send_type_extra", "et_send_type_registration");
                getApplicationContext().sendBroadcast(intent);
            }
        }
          goto _L42
_L41:
        m.a("~!ETPushService", "Last connection state was ON.");
          goto _L42
_L53:
        m.a("~!ETPushService", "Open from notification.");
        a(intent);
          goto _L15
_L54:
        m.a("~!ETPushService", "Send data to Marketing Cloud.");
        e(intent);
          goto _L15
_L55:
        m.a("~!ETPushService", "App in background.");
        d(intent);
          goto _L15
_L1:
        j;
        JVM INSTR tableswitch 0 12: default 1736
    //                   0 482
    //                   1 513
    //                   2 536
    //                   3 559
    //                   4 576
    //                   5 593
    //                   6 728
    //                   7 824
    //                   8 824
    //                   9 1404
    //                   10 1616
    //                   11 1633
    //                   12 1650;
           goto _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L51 _L52 _L53 _L54 _L55
    }

}
