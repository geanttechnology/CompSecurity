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
import com.socialin.android.apiv3.model.NewsResponse;
import com.socialin.android.apiv3.model.NotificationResponse;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.c;
import com.socialin.android.photo.database.b;
import com.socialin.android.util.e;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import com.socialin.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.photo.notifications:
//            NotificationsService

final class a
    implements d
{

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
        com.socialin.android.apiv3.model.tificationItem tificationitem = (com.socialin.android.apiv3.model.tificationItem)request.get(i);
        if (tificationitem.action.equalsIgnoreCase("start_activity") && tificationitem.sysParams.actionUrl != null && tificationitem.sysParams.actionUrl.length() > 0)
        {
            tificationitem.action = "open_deep_linking";
        }
        NotificationsService.a(a, tificationitem);
        acontentvalues[i] = new ContentValues();
        acontentvalues[i].put("notification_id", tificationitem.id);
        acontentvalues[i].put("notification_item", c.a().toJson(tificationitem).getBytes(e.a));
        acontentvalues[i].put("created_at", Long.valueOf(tificationitem.createdAt.getTime()));
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
        if (!com.socialin.android.d.b)
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

    onItem(NotificationsService notificationsservice)
    {
        a = notificationsservice;
        super();
    }
}
