// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteFullException;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.c;
import com.socialin.android.d;
import com.socialin.android.photo.database.b;
import com.socialin.android.util.an;
import com.socialin.gson.Gson;
import java.util.Date;

// Referenced classes of package com.socialin.android.photo.notifications:
//            NotificationsService

final class a extends an
{

    private Intent a;
    private NotificationsService b;

    private transient Void a()
    {
        int i = 0;
        Object obj = a.getAction();
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 5: default 642
    //                   -771210135: 91
    //                   -328627421: 64
    //                   -262106510: 106
    //                   558589027: 76
    //                   1055201153: 121;
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
        if ("pull".equals(SocialinV3.getInstance().getAppProps().getData().a.onPolicy)) goto _L13; else goto _L12
_L12:
        boolean flag;
        obj1 = ((Intent) (obj1)).getStringExtra("extra.message");
        flag = d.b;
        if (!flag);
        Object obj3 = (com.socialin.android.apiv3.model.tificationItem)c.a().fromJson(((String) (obj1)), com/socialin/android/apiv3/model/NotificationResponse$NotificationItem);
        if (!SocialinV3.getInstance().isRegistered() || SocialinV3.getInstance().getUser().id != ((com.socialin.android.apiv3.model.tificationItem) (obj3)).userId) goto _L13; else goto _L14
_L14:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("notification_id", ((com.socialin.android.apiv3.model.tificationItem) (obj3)).id);
        contentvalues.put("notification_item", ((String) (obj1)).getBytes());
        contentvalues.put("created_at", Long.valueOf(((com.socialin.android.apiv3.model.tificationItem) (obj3)).createdAt.getTime()));
        exception.getContentResolver().insert(b.a, contentvalues);
        exception.a(((com.socialin.android.apiv3.model.tificationItem) (obj3)));
        obj3 = new Intent("com.picsart.studio.notification.action");
        ((Intent) (obj3)).putExtra("extra.result.string", ((String) (obj1)));
        ((Intent) (obj3)).putExtra("extra.result.action", "action.gcm.message");
        ((Intent) (obj3)).putExtra("extra.result.code", 1);
        exception.sendBroadcast(((Intent) (obj3)));
        return null;
        Object obj2;
        obj2;
        exception.getContentResolver().delete(b.a, null, null);
        d.b(((SQLiteFullException) (obj2)).getMessage(), new Object[] {
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
        Object obj4 = (com.socialin.android.apiv3.model.tificationItem)c.a().fromJson(((String) (obj2)), com/socialin/android/apiv3/model/NotificationResponse$NotificationItem);
        obj2 = new ContentValues();
        ((ContentValues) (obj2)).put("notification_id", ((com.socialin.android.apiv3.model.tificationItem) (obj4)).id);
        ((ContentValues) (obj2)).put("notification_item", c.a().toJson(obj4).getBytes());
        ((ContentValues) (obj2)).put("created_at", Long.valueOf(((com.socialin.android.apiv3.model.tificationItem) (obj4)).createdAt.getTime()));
        ((ContentValues) (obj2)).put("read", Integer.valueOf(((com.socialin.android.apiv3.model.tificationItem) (obj4)).read));
        obj4 = (new StringBuilder("notification_id=\"")).append(((com.socialin.android.apiv3.model.tificationItem) (obj4)).id).append("\"").toString();
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
    //                   0 136
    //                   1 170
    //                   2 179
    //                   3 192
    //                   4 454;
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
            NotificationsService.a(b);
        }
    }

    onItem(NotificationsService notificationsservice, Intent intent)
    {
        b = notificationsservice;
        a = intent;
        super();
    }
}
