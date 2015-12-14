// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import com.appboy.Appboy;
import com.appboy.enums.CardCategory;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.PicsartNewsController;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.NewsResponse;
import com.socialin.android.apiv3.model.NotificationResponse;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.c;
import com.socialin.android.d;
import com.socialin.android.photo.database.b;
import com.socialin.android.util.an;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import com.socialin.gson.Gson;
import com.socialin.gson.JsonIOException;
import com.socialin.gson.JsonSyntaxException;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import myobfuscated.e.a;
import myobfuscated.f.m;
import myobfuscated.g.e;
import myobfuscated.g.f;
import org.json.JSONArray;

public class NotificationsService extends Service
{

    boolean a;
    private boolean b;
    private Appboy c;
    private PicsartNewsController d;
    private int e;
    private long f;
    private Handler g;
    private myobfuscated.e.b h;

    public NotificationsService()
    {
        b = false;
        d = new PicsartNewsController();
        a = true;
        e = 0x57e40;
        f = 0L;
    }

    private Intent a(com.socialin.android.apiv3.model.BannersResponse.BannerItem banneritem)
    {
        Object obj = new Intent();
        ((Intent) (obj)).setClassName(getApplicationContext(), banneritem.activityName);
        banneritem = banneritem.activityParams;
        if (banneritem == null) goto _L2; else goto _L1
_L1:
        if (banneritem.size() <= 0) goto _L2; else goto _L3
_L3:
        int i = 0;
_L12:
        if (i >= banneritem.size()) goto _L2; else goto _L4
_L4:
        Object obj1 = (com.socialin.android.apiv3.model.BannersResponse.ActivityParams)banneritem.get(i);
        if (!"int".equalsIgnoreCase(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).type)) goto _L6; else goto _L5
_L5:
        ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, Integer.parseInt(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value));
          goto _L7
_L6:
        if (!"boolean".equalsIgnoreCase(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).type)) goto _L9; else goto _L8
_L8:
        ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, Boolean.parseBoolean(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value));
          goto _L7
_L10:
        if (d.b)
        {
            ((Exception) (obj)).getMessage();
            return banneritem;
        } else
        {
            ExceptionReportService.report(getApplicationContext(), ((Throwable) (obj)), SocialinV3.getInstance().getUser().id);
            return banneritem;
        }
_L9:
        try
        {
            ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, ((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value);
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            banneritem = ((com.socialin.android.apiv3.model.BannersResponse.BannerItem) (obj));
            obj = obj1;
        }
          goto _L10
_L2:
        return ((Intent) (obj));
        obj;
        banneritem = null;
        if (true) goto _L10; else goto _L7
_L7:
        i++;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private List a()
    {
        Cursor cursor;
        ArrayList arraylist;
        cursor = getContentResolver().query(b.a, null, null, null, null);
        arraylist = new ArrayList();
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        boolean flag;
        if (cursor.moveToFirst())
        {
            do
            {
                InputStreamReader inputstreamreader = new InputStreamReader(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("notification_item"))));
                arraylist.add((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)com.socialin.android.c.a().fromJson(inputstreamreader, com/socialin/android/apiv3/model/NotificationResponse$NotificationItem));
                flag = cursor.moveToNext();
            } while (flag);
        }
        cursor.close();
        return arraylist;
        Object obj;
        obj;
_L2:
        ExceptionReportService.report(SocialinV3.getInstance().getContext(), ((Throwable) (obj)), String.valueOf(SocialinV3.getInstance().getUser().id));
        cursor.close();
        return arraylist;
        obj;
        cursor.close();
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(Intent intent)
    {
        if (!"action.refresh".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        if (!b) goto _L4; else goto _L3
_L3:
        return;
_L4:
        b = true;
_L2:
        if ("action.start.continuous.refresh".equals(intent.getAction()))
        {
            a = false;
            if (System.currentTimeMillis() - f > (long)e || f == 0L)
            {
                intent.setAction("action.refresh");
            }
        }
        if ("action.stop.continuous.refresh".equals(intent.getAction()))
        {
            a = true;
        }
        if (!"actoion.get.picsart.news".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_163;
        }
        if (!s.a(getApplicationContext())) goto _L3; else goto _L5
_L5:
        d.setRequestCompleteListener(new com.socialin.asyncnet.d() {

            private NotificationsService a;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request)
            {
                int i;
                boolean flag;
                flag = true;
                i = 0;
                obj = (NewsResponse)obj;
                if (((NewsResponse) (obj)).response == null || ((NewsResponse) (obj)).response.length() <= 0) goto _L2; else goto _L1
_L1:
                obj = NewsResponse.toNotificationResponse(((NewsResponse) (obj)));
                if (obj == null) goto _L4; else goto _L3
_L3:
                ContentValues acontentvalues[];
                try
                {
                    request = ((NotificationResponse) (obj)).response;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ExceptionReportService.report(SocialinV3.getInstance().getContext(), ((Throwable) (obj)), String.valueOf(SocialinV3.getInstance().getUser().id));
                    return;
                }
                if (request == null) goto _L4; else goto _L5
_L5:
                acontentvalues = new ContentValues[request.size()];
_L6:
                if (i >= request.size())
                {
                    break MISSING_BLOCK_LABEL_205;
                }
                com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)request.get(i);
                if (notificationitem.action.equalsIgnoreCase("start_activity") && notificationitem.sysParams.actionUrl != null && notificationitem.sysParams.actionUrl.length() > 0)
                {
                    notificationitem.action = "open_deep_linking";
                }
                com.socialin.android.photo.notifications.NotificationsService.a(a, notificationitem);
                acontentvalues[i] = new ContentValues();
                acontentvalues[i].put("notification_id", notificationitem.id);
                acontentvalues[i].put("notification_item", com.socialin.android.c.a().toJson(notificationitem).getBytes(com.socialin.android.util.e.a));
                acontentvalues[i].put("created_at", Long.valueOf(notificationitem.createdAt.getTime()));
                i++;
                  goto _L6
                a.getContentResolver().bulkInsert(b.a, acontentvalues);
                i = ((flag) ? 1 : 0);
_L8:
                request = new Intent("com.picsart.studio.notification.action");
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_388;
                }
                obj = ((NotificationResponse) (obj)).toString();
_L7:
                request.putExtra("extra.result.string", ((String) (obj)));
                request.putExtra("extra.result.action", "actoion.get.picsart.news");
                request.putExtra("extra.result.code", i);
                a.sendBroadcast(request);
                return;
                request;
                a.getContentResolver().delete(b.a, null, null);
                com.socialin.android.d.b(request.getMessage(), new Object[] {
                    request
                });
                i = ((flag) ? 1 : 0);
                continue; /* Loop/switch isn't completed */
                request;
                if (!d.b)
                {
                    break MISSING_BLOCK_LABEL_361;
                }
                request.getMessage();
                i = ((flag) ? 1 : 0);
                continue; /* Loop/switch isn't completed */
                ExceptionReportService.report(a.getApplicationContext(), request, SocialinV3.getInstance().getUser().id);
                i = ((flag) ? 1 : 0);
                continue; /* Loop/switch isn't completed */
                obj = "";
                  goto _L7
_L4:
                i = 2;
                if (true) goto _L8; else goto _L2
_L2:
            }

            
            {
                a = NotificationsService.this;
                super();
            }
        });
        d.doRequest();
        return;
        intent;
        ExceptionReportService.report(SocialinV3.getInstance().getContext(), intent, String.valueOf(SocialinV3.getInstance().getUser().id));
        return;
        (new an(intent) {

            private Intent a;
            private NotificationsService b;

            private transient Void a()
            {
                int i = 0;
                Object obj = a.getAction();
                ((String) (obj)).hashCode();
                JVM INSTR lookupswitch 5: default 642
            //                           -771210135: 91
            //                           -328627421: 64
            //                           -262106510: 106
            //                           558589027: 76
            //                           1055201153: 121;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L3:
                if (!((String) (obj)).equals("action.refresh")) goto _L1; else goto _L7
_L5:
                if (!((String) (obj)).equals("action.delete")) goto _L1; else goto _L8
_L8:
                i = 1;
                  goto _L7
_L2:
                if (!((String) (obj)).equals("action.mark.as.read")) goto _L1; else goto _L9
_L9:
                i = 2;
                  goto _L7
_L4:
                if (!((String) (obj)).equals("action.gcm.message")) goto _L1; else goto _L10
_L10:
                i = 3;
                  goto _L7
_L6:
                if (!((String) (obj)).equals("action.update")) goto _L1; else goto _L11
_L11:
                i = 4;
                  goto _L7
_L17:
                try
                {
                    com.socialin.android.photo.notifications.NotificationsService.b(b);
                }
                catch (Exception exception)
                {
                    ExceptionReportService.report(SocialinV3.getInstance().getContext(), exception, String.valueOf(SocialinV3.getInstance().getUser().id));
                    return null;
                }
                return null;
_L18:
                com.socialin.android.photo.notifications.NotificationsService.c(b);
                return null;
_L19:
                com.socialin.android.photo.notifications.NotificationsService.b(b, a);
                return null;
_L20:
                Object obj1;
                exception = b;
                obj1 = a;
                if ("pull".equals(SocialinV3.getInstance().getAppProps().getData().api.notificationPolicy)) goto _L13; else goto _L12
_L12:
                boolean flag;
                obj1 = ((Intent) (obj1)).getStringExtra("extra.message");
                flag = d.b;
                if (!flag);
                Object obj3 = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)com.socialin.android.c.a().fromJson(((String) (obj1)), com/socialin/android/apiv3/model/NotificationResponse$NotificationItem);
                if (!SocialinV3.getInstance().isRegistered() || SocialinV3.getInstance().getUser().id != ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj3)).userId) goto _L13; else goto _L14
_L14:
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("notification_id", ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj3)).id);
                contentvalues.put("notification_item", ((String) (obj1)).getBytes());
                contentvalues.put("created_at", Long.valueOf(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj3)).createdAt.getTime()));
                exception.getContentResolver().insert(b.a, contentvalues);
                exception.a(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj3)));
                obj3 = new Intent("com.picsart.studio.notification.action");
                ((Intent) (obj3)).putExtra("extra.result.string", ((String) (obj1)));
                ((Intent) (obj3)).putExtra("extra.result.action", "action.gcm.message");
                ((Intent) (obj3)).putExtra("extra.result.code", 1);
                exception.sendBroadcast(((Intent) (obj3)));
                return null;
                Object obj2;
                obj2;
                exception.getContentResolver().delete(b.a, null, null);
                com.socialin.android.d.b(((SQLiteFullException) (obj2)).getMessage(), new Object[] {
                    obj2
                });
                return null;
                obj2;
                if (!d.b) goto _L16; else goto _L15
_L15:
                ((Exception) (obj2)).getMessage();
                return null;
_L16:
                ExceptionReportService.report(exception.getApplicationContext(), ((Throwable) (obj2)), SocialinV3.getInstance().getUser().id);
                return null;
_L21:
                exception = b;
                obj2 = a.getStringExtra("extra.message");
                Object obj4 = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)com.socialin.android.c.a().fromJson(((String) (obj2)), com/socialin/android/apiv3/model/NotificationResponse$NotificationItem);
                obj2 = new ContentValues();
                ((ContentValues) (obj2)).put("notification_id", ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj4)).id);
                ((ContentValues) (obj2)).put("notification_item", com.socialin.android.c.a().toJson(obj4).getBytes());
                ((ContentValues) (obj2)).put("created_at", Long.valueOf(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj4)).createdAt.getTime()));
                ((ContentValues) (obj2)).put("read", Integer.valueOf(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj4)).read));
                obj4 = (new StringBuilder("notification_id=\"")).append(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj4)).id).append("\"").toString();
                i = exception.getContentResolver().update(b.a, ((ContentValues) (obj2)), ((String) (obj4)), null);
                if (!d.b);
                obj2 = new Intent("com.picsart.studio.notification.action");
                ((Intent) (obj2)).putExtra("extra.result.action", "action.update");
                if (i > 0)
                {
                    i = 1;
                } else
                {
                    i = 2;
                }
                ((Intent) (obj2)).putExtra("extra.result.code", i);
                exception.sendBroadcast(((Intent) (obj2)));
                return null;
_L1:
                i = -1;
_L7:
                i;
                JVM INSTR tableswitch 0 4: default 680
            //                           0 136
            //                           1 170
            //                           2 179
            //                           3 192
            //                           4 454;
                   goto _L13 _L17 _L18 _L19 _L20 _L21
_L13:
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj)
            {
                if ("action.refresh".equals(a.getAction()))
                {
                    com.socialin.android.photo.notifications.NotificationsService.a(b);
                }
            }

            
            {
                b = NotificationsService.this;
                a = intent;
                super();
            }
        }).a(new Void[0]);
        return;
    }

    private void a(NotificationResponse notificationresponse, String s1)
    {
        ArrayList arraylist;
        ContentValues acontentvalues[];
        int j;
        long l;
        boolean flag;
        arraylist = new ArrayList();
        notificationresponse = notificationresponse.response;
        if (notificationresponse == null)
        {
            break MISSING_BLOCK_LABEL_876;
        }
        acontentvalues = new ContentValues[notificationresponse.size()];
        j = 0;
        flag = true;
        l = 0L;
_L2:
        com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem;
        String s2;
        SharedPreferences sharedpreferences;
        if (j >= notificationresponse.size())
        {
            break MISSING_BLOCK_LABEL_781;
        }
        notificationitem = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)notificationresponse.get(j);
        s2 = notificationitem.action;
        sharedpreferences = getSharedPreferences((new StringBuilder("sinPref_")).append(getString(m.e(this, "app_name_short"))).toString(), 0);
        flag = true;
        if (sharedpreferences.getBoolean("notifications_enable_all", true))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = false;
_L16:
        if ("like_removed".equals(notificationitem.action) || "photo_removed".equals(notificationitem.action))
        {
            arraylist.add(notificationitem);
        }
        "photo_added".equals(notificationitem.action);
        long l1 = l;
        if (notificationitem.createdAt.getTime() > l)
        {
            l1 = notificationitem.createdAt.getTime();
            s1 = notificationitem.id;
        }
        acontentvalues[j] = new ContentValues();
        acontentvalues[j].put("notification_id", notificationitem.id);
        acontentvalues[j].put("notification_item", com.socialin.android.c.a().toJson(notificationitem).getBytes());
        acontentvalues[j].put("created_at", Long.valueOf(notificationitem.createdAt.getTime()));
        a(notificationitem);
        j++;
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
        int i = -1;
        s2.hashCode();
        JVM INSTR lookupswitch 10: default 388
    //                   -2109581921: 531
    //                   -1304808889: 514
    //                   -1123176672: 480
    //                   -794646952: 565
    //                   456345042: 548
    //                   492094105: 463
    //                   1182873491: 601
    //                   1427018931: 583
    //                   1538532511: 619
    //                   2142227051: 497;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L3:
        break; /* Loop/switch isn't completed */
_L12:
        break MISSING_BLOCK_LABEL_619;
_L14:
        switch (i)
        {
        case 0: // '\0'
            flag = sharedpreferences.getBoolean("notifications_enable_likes_me", true);
            break;

        case 1: // '\001'
            flag = sharedpreferences.getBoolean("notifications_enable_comments", true);
            break;

        case 2: // '\002'
            flag = sharedpreferences.getBoolean("notifications_enable_mention", true);
            break;

        case 3: // '\003'
            flag = sharedpreferences.getBoolean("enable_facebook_notifications", true);
            break;

        case 4: // '\004'
            flag = sharedpreferences.getBoolean("notifications_enable_follow_me", true);
            break;

        case 5: // '\005'
            flag = sharedpreferences.getBoolean("notifications_enable_follow", true);
            break;

        case 6: // '\006'
            flag = sharedpreferences.getBoolean("notifications_enable_likes", true);
            break;

        case 7: // '\007'
            flag = sharedpreferences.getBoolean("notifications_enable_publishs", true);
            break;

        case 8: // '\b'
            flag = sharedpreferences.getBoolean("notifications_enable_reposts_me", true);
            break;

        case 9: // '\t'
            flag = sharedpreferences.getBoolean("notifications_enable_reposts_other", true);
            break;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (s2.equals("friend_like_added"))
        {
            i = 0;
        }
          goto _L14
_L6:
        if (s2.equals("comment_added"))
        {
            i = 1;
        }
          goto _L14
_L13:
        if (s2.equals("mention_added"))
        {
            i = 2;
        }
          goto _L14
_L5:
        if (s2.equals("facebook_added"))
        {
            i = 3;
        }
          goto _L14
_L4:
        if (s2.equals("follower_added"))
        {
            i = 4;
        }
          goto _L14
_L8:
        if (s2.equals("following_added"))
        {
            i = 5;
        }
          goto _L14
_L7:
        if (s2.equals("like_added"))
        {
            i = 6;
        }
          goto _L14
_L11:
        if (s2.equals("photo_added"))
        {
            i = 7;
        }
          goto _L14
_L10:
        if (s2.equals("user_photo_reposted"))
        {
            i = 8;
        }
          goto _L14
        if (s2.equals("photo_reposted"))
        {
            i = 9;
        }
          goto _L14
        if (true) goto _L16; else goto _L15
_L15:
        i = getContentResolver().bulkInsert(b.a, acontentvalues);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_809;
        }
        myobfuscated.bo.c.b(i, getApplicationContext());
        if (s1 != null)
        {
            try
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString((new StringBuilder()).append(SocialinV3.getInstance().getUser().id).append("prefs.since.id").toString(), s1).commit();
            }
            // Misplaced declaration of an exception variable
            catch (NotificationResponse notificationresponse)
            {
                getContentResolver().delete(b.a, null, null);
                com.socialin.android.d.b(notificationresponse.getMessage(), new Object[] {
                    notificationresponse
                });
            }
            // Misplaced declaration of an exception variable
            catch (NotificationResponse notificationresponse)
            {
                if (d.b)
                {
                    notificationresponse.getMessage();
                } else
                {
                    ExceptionReportService.report(getApplicationContext(), notificationresponse, SocialinV3.getInstance().getUser().id);
                }
            }
        }
        if (arraylist.size() > 0)
        {
            a(((List) (arraylist)));
        }
    }

    static void a(NotificationsService notificationsservice, Intent intent)
    {
        notificationsservice.a(intent);
    }

    static void a(NotificationsService notificationsservice, com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
    {
        notificationsservice.a(notificationitem);
    }

    private void a(List list)
    {
        ArrayList arraylist = new ArrayList();
        List list1 = a();
        for (list = list.iterator(); list.hasNext();)
        {
            com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)list.next();
            Iterator iterator = list1.iterator();
            while (iterator.hasNext()) 
            {
                com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem1 = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)iterator.next();
                if (notificationitem1 != null && notificationitem1.item != null)
                {
                    boolean flag;
                    long l;
                    long l1;
                    if (notificationitem1.item.origin != null)
                    {
                        l = notificationitem1.item.origin.id;
                    } else
                    {
                        l = -1L;
                    }
                    l1 = notificationitem1.item.id;
                    if (notificationitem.item.id == l1 || notificationitem.item.id == l)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if ("like_removed".equals(notificationitem.action))
                    {
                        if (notificationitem.item.id == l1 && notificationitem1.user.id == notificationitem.user.id)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    }
                    if (flag)
                    {
                        arraylist.add(notificationitem1.id);
                    }
                }
            }
        }

        if (arraylist.size() > 0)
        {
            b(arraylist);
        }
    }

    static boolean a(NotificationsService notificationsservice)
    {
        notificationsservice.b = false;
        return false;
    }

    static void b(NotificationsService notificationsservice)
    {
        if (s.a(notificationsservice.getApplicationContext()) && SocialinV3.getInstance().getUser() != null && SocialinV3.getInstance().getUser().key != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s2;
        String s3;
        s3 = PreferenceManager.getDefaultSharedPreferences(notificationsservice).getString((new StringBuilder()).append(SocialinV3.getInstance().getUser().id).append("prefs.since.id").toString(), null);
        notificationsservice.f = System.currentTimeMillis();
        s2 = "";
        SharedPreferences sharedpreferences = notificationsservice.getSharedPreferences((new StringBuilder("sinPref_")).append(notificationsservice.getString(m.e(notificationsservice, "app_name_short"))).toString(), 0);
        if (!sharedpreferences.getBoolean("notifications_enable_likes_me", true))
        {
            s2 = (new StringBuilder()).append("").append("like_added").toString();
        }
        String s1 = s2;
        if (!sharedpreferences.getBoolean("notifications_enable_reposts_me", true))
        {
            s1 = s2;
            if (!s2.equals(""))
            {
                s1 = (new StringBuilder()).append(s2).append(",").toString();
            }
            s1 = (new StringBuilder()).append(s1).append("user_photo_reposted").toString();
        }
        s2 = s1;
        if (!sharedpreferences.getBoolean("notifications_enable_reposts_other", true))
        {
            s2 = s1;
            if (!s1.equals(""))
            {
                s2 = (new StringBuilder()).append(s1).append(",").toString();
            }
            s2 = (new StringBuilder()).append(s2).append("photo_reposted").toString();
        }
        s1 = s2;
        if (!sharedpreferences.getBoolean("notifications_enable_likes", true))
        {
            s1 = s2;
            if (!s2.equals(""))
            {
                s1 = (new StringBuilder()).append(s2).append(",").toString();
            }
            s1 = (new StringBuilder()).append(s1).append("friend_like_added").toString();
        }
        s2 = s1;
        if (!sharedpreferences.getBoolean("notifications_enable_comments", true))
        {
            s2 = s1;
            if (!s1.equals(""))
            {
                s2 = (new StringBuilder()).append(s1).append(",").toString();
            }
            s2 = (new StringBuilder()).append(s2).append("comment_added,reply_added").toString();
        }
        s1 = s2;
        if (!sharedpreferences.getBoolean("notifications_enable_mention", true))
        {
            s1 = s2;
            if (!s2.equals(""))
            {
                s1 = (new StringBuilder()).append(s2).append(",").toString();
            }
            s1 = (new StringBuilder()).append(s1).append("mention_added").toString();
        }
        s2 = s1;
        if (!sharedpreferences.getBoolean("notifications_enable_publishs", true))
        {
            s2 = s1;
            if (!s1.equals(""))
            {
                s2 = (new StringBuilder()).append(s1).append(",").toString();
            }
            s2 = (new StringBuilder()).append(s2).append("photo_added").toString();
        }
        s1 = s2;
        if (!sharedpreferences.getBoolean("notifications_enable_follow_me", true))
        {
            s1 = s2;
            if (!s2.equals(""))
            {
                s1 = (new StringBuilder()).append(s2).append(",").toString();
            }
            s1 = (new StringBuilder()).append(s1).append("follower_added").toString();
        }
        s2 = s1;
        if (!sharedpreferences.getBoolean("notifications_enable_follow", true))
        {
            s2 = s1;
            if (!s1.equals(""))
            {
                s2 = (new StringBuilder()).append(s1).append(",").toString();
            }
            s2 = (new StringBuilder()).append(s2).append("following_added").toString();
        }
        s1 = s2;
        if (!sharedpreferences.getBoolean("enable_facebook_notifications", true))
        {
            s1 = s2;
            if (!s2.equals(""))
            {
                s1 = (new StringBuilder()).append(s2).append(",").toString();
            }
            s1 = (new StringBuilder()).append(s1).append("facebook_added").toString();
        }
        s2 = s1;
        if (!sharedpreferences.getBoolean("enable_twitter_notifications", true))
        {
            s2 = s1;
            if (!s1.equals(""))
            {
                s2 = (new StringBuilder()).append(s1).append(",").toString();
            }
            s2 = (new StringBuilder()).append(s2).append("twitter_added").toString();
        }
        Object obj = (NotificationResponse)SocialinApiV3.getInstance().createNotificationsRequest(s3, s2).d();
        int i = 1;
_L4:
        if (obj != null)
        {
            notificationsservice.a(((NotificationResponse) (obj)), s3);
        }
        Intent intent;
        if (obj != null)
        {
            obj = ((NotificationResponse) (obj)).message;
        } else
        {
            obj = "";
        }
        intent = new Intent("com.picsart.studio.notification.action");
        intent.putExtra("extra.result.string", ((String) (obj)));
        intent.putExtra("extra.result.action", "action.refresh");
        intent.putExtra("extra.result.code", i);
        intent.putExtra("myNetworkNewItemsCount", 0);
        notificationsservice.sendBroadcast(intent);
        if (notificationsservice.c != null)
        {
            try
            {
                notificationsservice.c.removeSingleSubscription(notificationsservice.h, myobfuscated/e/a);
                notificationsservice.h = notificationsservice. new myobfuscated.e.b() {

                    private NotificationsService a;

                    public final void trigger(Object obj1)
                    {
                        ContentValues acontentvalues[];
                        HashSet hashset;
                        a a1;
                        HashSet hashset1;
                        int l;
                        a1 = (a)obj1;
                        l = a1.b(CardCategory.ALL_CATEGORIES);
                        acontentvalues = new ContentValues[l];
                        hashset1 = new HashSet();
                        hashset = new HashSet();
                        Object obj2 = a.getContentResolver().query(b.a, new String[] {
                            "notification_id"
                        }, "notification_id like ?", new String[] {
                            "appboy_%"
                        }, null);
                        if (obj2 == null) goto _L2; else goto _L1
_L1:
                        if (((Cursor) (obj2)).moveToFirst())
                        {
                            do
                            {
                                hashset.add(((Cursor) (obj2)).getString(0));
                            } while (((Cursor) (obj2)).moveToNext());
                        }
                        ((Cursor) (obj2)).close();
                        ((Cursor) (obj2)).close();
                          goto _L2
_L17:
                        int k;
                        if (k >= l) goto _L4; else goto _L3
_L3:
                        myobfuscated.g.c c1 = (myobfuscated.g.c)a1.a(CardCategory.ALL_CATEGORIES).get(k);
                        if (!c1.m.contains(CardCategory.NEWS)) goto _L6; else goto _L5
_L5:
                        obj1 = (new StringBuilder("appboy_")).append(c1.c()).append("_").append(c1.g()).toString();
                        hashset1.add(obj1);
                        if (hashset.contains(obj1)) goto _L6; else goto _L7
_L7:
                        com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem;
                        notificationitem = new com.socialin.android.apiv3.model.NotificationResponse.NotificationItem();
                        notificationitem.id = ((String) (obj1));
                        if (!(c1 instanceof myobfuscated.g.b)) goto _L9; else goto _L8
_L8:
                        obj2 = ((myobfuscated.g.b)c1).b;
                        obj1 = ((myobfuscated.g.b)c1).d;
_L10:
                        int j;
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                        calendar.setTimeInMillis(c1.g() * 1000L);
                        int i1 = calendar.get(13);
                        int j1 = calendar.get(12);
                        int k1 = calendar.get(11);
                        int l1 = calendar.get(5);
                        int i2 = calendar.get(2);
                        int j2 = calendar.get(1);
                        notificationitem.message = ((String) (obj2));
                        notificationitem.createdAt = (new GregorianCalendar(j2, i2, l1, k1, j1, i1)).getTime();
                        notificationitem.action = "appboy_news";
                        notificationitem.data = ((String) (obj1));
                        acontentvalues[j] = new ContentValues();
                        acontentvalues[j].put("notification_id", notificationitem.id);
                        acontentvalues[j].put("notification_item", com.socialin.android.c.a().toJson(notificationitem).getBytes());
                        acontentvalues[j].put("created_at", Long.valueOf(notificationitem.createdAt.getTime()));
                        j++;
_L6:
                        k++;
                        continue; /* Loop/switch isn't completed */
                        obj1;
_L15:
                        ExceptionReportService.report(SocialinV3.getInstance().getContext(), ((Throwable) (obj1)), String.valueOf(SocialinV3.getInstance().getUser().id));
                        ((Cursor) (obj2)).close();
                          goto _L2
                        obj1;
                        try
                        {
                            ((Cursor) (obj2)).close();
                            throw obj1;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            com.socialin.android.d.b(((IllegalArgumentException) (obj1)).getMessage(), new Object[] {
                                obj1
                            });
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            a.getContentResolver().delete(b.a, null, null);
                        }
                        com.socialin.android.d.b(((SQLiteFullException) (obj1)).getMessage(), new Object[] {
                            obj1
                        });
                        return;
_L9:
label0:
                        {
                            if (!(c1 instanceof e))
                            {
                                break label0;
                            }
                            obj2 = ((e)c1).c;
                            obj1 = ((e)c1).d;
                        }
                          goto _L10
                        if (!(c1 instanceof myobfuscated.g.a))
                        {
                            break MISSING_BLOCK_LABEL_611;
                        }
                        Log.i("Notification Service", "Banner Card");
                        obj1 = null;
                        obj2 = null;
                          goto _L10
label1:
                        {
                            if (!(c1 instanceof myobfuscated.g.d))
                            {
                                break label1;
                            }
                            obj2 = ((myobfuscated.g.d)c1).a;
                            obj1 = ((myobfuscated.g.d)c1).o;
                        }
                          goto _L10
                        if (!(c1 instanceof f)) goto _L12; else goto _L11
_L11:
                        obj2 = ((f)c1).b;
                        obj1 = ((f)c1).c;
                          goto _L10
_L4:
                        hashset.removeAll(hashset1);
                        if (hashset.size() <= 0)
                        {
                            break MISSING_BLOCK_LABEL_813;
                        }
                        obj2 = (String[])hashset.toArray(new String[hashset.size()]);
                        j = 0;
                        obj1 = " in (?";
_L14:
                        if (j >= hashset.size() - 1)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        obj1 = (new StringBuilder()).append(((String) (obj1))).append(",?").toString();
                        j++;
                        if (true) goto _L14; else goto _L13
_L13:
                        obj1 = (new StringBuilder()).append(((String) (obj1))).append(")").toString();
                        a.getContentResolver().delete(b.a, (new StringBuilder("notification_id")).append(((String) (obj1))).toString(), ((String []) (obj2)));
                        a.getContentResolver().bulkInsert(b.a, acontentvalues);
                        return;
                        obj1;
                          goto _L15
                        obj1;
                          goto _L15
_L12:
                        obj1 = null;
                        obj2 = null;
                          goto _L10
_L2:
                        j = 0;
                        k = 0;
                        if (true) goto _L17; else goto _L16
_L16:
                    }

            
            {
                a = NotificationsService.this;
                super();
            }
                };
                notificationsservice.c.subscribeToFeedUpdates(notificationsservice.h);
                notificationsservice.c.requestFeedRefresh();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NotificationsService notificationsservice)
            {
                com.socialin.android.d.a(notificationsservice.getMessage(), notificationsservice);
            }
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        if (d.b)
        {
            ((Exception) (obj)).getMessage();
            obj = null;
            i = 2;
        } else
        {
            ExceptionReportService.report(notificationsservice.getApplicationContext(), ((Throwable) (obj)), SocialinV3.getInstance().getUser().id);
            obj = null;
            i = 2;
        }
          goto _L4
    }

    static void b(NotificationsService notificationsservice, Intent intent)
    {
        String as[] = intent.getStringExtra("extra.deleted.ids").split(",");
        intent = new StringBuilder();
        intent.append("(");
        for (int i = 0; i < as.length; i++)
        {
            intent.append('"');
            intent.append(as[i]);
            intent.append('"');
            if (i < as.length - 1)
            {
                intent.append(",");
            }
        }

        intent.append(")");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("read", Integer.valueOf(1));
        intent = (new StringBuilder("notification_id in ")).append(intent.toString()).toString();
        int j = notificationsservice.getContentResolver().update(b.a, contentvalues, intent, null);
        intent = new Intent("com.picsart.studio.notification.action");
        intent.putExtra("extra.result.string", j);
        intent.putExtra("extra.result.action", "action.mark.as.read");
        if (j > 0)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        intent.putExtra("extra.result.code", j);
        notificationsservice.sendBroadcast(intent);
    }

    private boolean b(List list)
    {
        boolean flag = false;
        int j;
        if (list.size() > 0)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("(");
            for (int i = 0; i < list.size(); i++)
            {
                stringbuilder.append("'");
                stringbuilder.append((String)list.get(i));
                stringbuilder.append("'");
                if (i < list.size() - 1)
                {
                    stringbuilder.append(",");
                }
            }

            stringbuilder.append(")");
            list = (new StringBuilder("notification_id in ")).append(stringbuilder.toString()).toString();
            j = getContentResolver().delete(b.a, list, null);
        } else
        {
            j = 0;
        }
        if (j > 0)
        {
            flag = true;
        }
        return flag;
    }

    static void c(NotificationsService notificationsservice)
    {
        byte byte0 = 2;
        int i = notificationsservice.getContentResolver().delete(b.a, null, null);
        if (i >= 0)
        {
            byte0 = 1;
        }
        Intent intent = new Intent("com.picsart.studio.notification.action");
        intent.putExtra("extra.result.string", String.valueOf(i));
        intent.putExtra("extra.result.action", "action.delete");
        intent.putExtra("extra.result.code", byte0);
        notificationsservice.sendBroadcast(intent);
    }

    final void a(com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
    {
        PendingIntent pendingintent = null;
        if (!notificationitem.isSystemType()) goto _L2; else goto _L1
_L1:
        int i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
_L4:
        Object obj = notificationitem.type;
        if (obj == null) goto _L2; else goto _L3
_L3:
        String s1;
        String s2;
        if ("info_sys_notice".equalsIgnoreCase(((String) (obj))) || "update_available".equalsIgnoreCase(((String) (obj))))
        {
            s1 = notificationitem.message;
            s2 = notificationitem.action;
            if (notificationitem.read == 2)
            {
                m.c(this, notificationitem.id);
                return;
            }
            break MISSING_BLOCK_LABEL_125;
        }
          goto _L2
        obj;
        if (!d.b)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        ((android.content.pm.PackageManager.NameNotFoundException) (obj)).getMessage();
        i = 0;
          goto _L4
        try
        {
            ExceptionReportService.report(getApplicationContext(), ((Throwable) (obj)), SocialinV3.getInstance().getUser().id);
        }
        // Misplaced declaration of an exception variable
        catch (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
        {
            if (d.b)
            {
                notificationitem.getMessage();
                return;
            } else
            {
                ExceptionReportService.report(getApplicationContext(), notificationitem, SocialinV3.getInstance().getUser().id);
                return;
            }
        }
        i = 0;
          goto _L4
        if (notificationitem.type.equalsIgnoreCase("update_available") && i >= notificationitem.getAppLastVersion())
        {
            m.c(this, notificationitem.id);
            return;
        }
        if (!"update_available".equalsIgnoreCase(((String) (obj)))) goto _L6; else goto _L5
_L5:
        obj = myobfuscated.cv.c.b(getApplicationContext());
_L7:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        ((Intent) (obj)).putExtra("notificationId", notificationitem.id);
        ((Intent) (obj)).setFlags(0x24000000);
        pendingintent = PendingIntent.getActivity(this, -notificationitem.id.hashCode(), ((Intent) (obj)), 0);
        notificationitem = notificationitem.id;
        obj = getString(0x7f0808af);
        getString(0x7f0808af);
        m.a(this, notificationitem, ((String) (obj)), s1, 0x7f0204a6, pendingintent);
        return;
_L6:
        if ("start_activity".equalsIgnoreCase(s2))
        {
            if (notificationitem.sysParams != null)
            {
                obj = a(notificationitem.sysParams);
                continue; /* Loop/switch isn't completed */
            }
            break MISSING_BLOCK_LABEL_343;
        }
        if ("open_url".equalsIgnoreCase(s2))
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse(notificationitem.sysParams.actionUrl));
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        if (true) goto _L7; else goto _L2
_L2:
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        String s1 = Build.MANUFACTURER;
        boolean flag;
        if (s1 != null && s1.toLowerCase().contains("motorola"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!SocialinV3.getInstance().getSettings().isAppboyEnabled() || flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        c = Appboy.getInstance(getApplicationContext());
        return;
        Exception exception;
        exception;
        if (d.b)
        {
            exception.getMessage();
            return;
        } else
        {
            ExceptionReportService.report(getApplicationContext(), exception, SocialinV3.getInstance().getUser().id);
            return;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        c.removeSingleSubscription(h, myobfuscated/e/a);
        return;
        Exception exception;
        exception;
        if (d.b)
        {
            exception.getMessage();
            return;
        } else
        {
            ExceptionReportService.report(getApplicationContext(), exception, SocialinV3.getInstance().getUser().id);
            return;
        }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (intent != null)
        {
            a(intent);
        }
        if (g == null)
        {
            g = new Handler();
            g.postDelayed(new Runnable() {

                private NotificationsService a;

                public final void run()
                {
                    if (a.a)
                    {
                        return;
                    } else
                    {
                        Intent intent1 = new Intent();
                        intent1.setAction("action.refresh");
                        com.socialin.android.photo.notifications.NotificationsService.a(a, intent1);
                        return;
                    }
                }

            
            {
                a = NotificationsService.this;
                super();
            }
            }, e);
        }
        return 2;
    }
}
