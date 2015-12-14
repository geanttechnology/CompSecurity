// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.util.Log;
import com.appboy.enums.CardCategory;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.d;
import com.socialin.gson.Gson;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import myobfuscated.e.a;
import myobfuscated.e.b;
import myobfuscated.g.c;
import myobfuscated.g.e;
import myobfuscated.g.f;

// Referenced classes of package com.socialin.android.photo.notifications:
//            NotificationsService

final class a
    implements b
{

    private NotificationsService a;

    public final void trigger(Object obj)
    {
        ContentValues acontentvalues[];
        HashSet hashset;
        a a1;
        HashSet hashset1;
        int k;
        a1 = (a)obj;
        k = a1.b(CardCategory.ALL_CATEGORIES);
        acontentvalues = new ContentValues[k];
        hashset1 = new HashSet();
        hashset = new HashSet();
        Object obj1 = a.getContentResolver().query(com.socialin.android.photo.database.b.a, new String[] {
            "notification_id"
        }, "notification_id like ?", new String[] {
            "appboy_%"
        }, null);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (((Cursor) (obj1)).moveToFirst())
        {
            do
            {
                hashset.add(((Cursor) (obj1)).getString(0));
            } while (((Cursor) (obj1)).moveToNext());
        }
        ((Cursor) (obj1)).close();
        ((Cursor) (obj1)).close();
          goto _L2
_L17:
        int j;
        if (j >= k) goto _L4; else goto _L3
_L3:
        c c1 = (c)a1.a(CardCategory.ALL_CATEGORIES).get(j);
        if (!c1.m.contains(CardCategory.NEWS)) goto _L6; else goto _L5
_L5:
        obj = (new StringBuilder("appboy_")).append(c1.c()).append("_").append(c1.g()).toString();
        hashset1.add(obj);
        if (hashset.contains(obj)) goto _L6; else goto _L7
_L7:
        com.socialin.android.apiv3.model.tificationItem tificationitem;
        tificationitem = new com.socialin.android.apiv3.model.tificationItem();
        tificationitem.id = ((String) (obj));
        if (!(c1 instanceof myobfuscated.g.b)) goto _L9; else goto _L8
_L8:
        obj1 = ((myobfuscated.g.b)c1).b;
        obj = ((myobfuscated.g.b)c1).d;
_L10:
        int i;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(c1.g() * 1000L);
        int l = calendar.get(13);
        int i1 = calendar.get(12);
        int j1 = calendar.get(11);
        int k1 = calendar.get(5);
        int l1 = calendar.get(2);
        int i2 = calendar.get(1);
        tificationitem.message = ((String) (obj1));
        tificationitem.createdAt = (new GregorianCalendar(i2, l1, k1, j1, i1, l)).getTime();
        tificationitem.action = "appboy_news";
        tificationitem.data = ((String) (obj));
        acontentvalues[i] = new ContentValues();
        acontentvalues[i].put("notification_id", tificationitem.id);
        acontentvalues[i].put("notification_item", com.socialin.android.c.a().toJson(tificationitem).getBytes());
        acontentvalues[i].put("created_at", Long.valueOf(tificationitem.createdAt.getTime()));
        i++;
_L6:
        j++;
        continue; /* Loop/switch isn't completed */
        obj;
_L15:
        ExceptionReportService.report(SocialinV3.getInstance().getContext(), ((Throwable) (obj)), String.valueOf(SocialinV3.getInstance().getUser().id));
        ((Cursor) (obj1)).close();
          goto _L2
        obj;
        try
        {
            ((Cursor) (obj1)).close();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            d.b(((IllegalArgumentException) (obj)).getMessage(), new Object[] {
                obj
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.getContentResolver().delete(com.socialin.android.photo.database.b.a, null, null);
        }
        d.b(((SQLiteFullException) (obj)).getMessage(), new Object[] {
            obj
        });
        return;
_L9:
label0:
        {
            if (!(c1 instanceof e))
            {
                break label0;
            }
            obj1 = ((e)c1).c;
            obj = ((e)c1).d;
        }
          goto _L10
        if (!(c1 instanceof myobfuscated.g.a))
        {
            break MISSING_BLOCK_LABEL_611;
        }
        Log.i("Notification Service", "Banner Card");
        obj = null;
        obj1 = null;
          goto _L10
label1:
        {
            if (!(c1 instanceof myobfuscated.g.d))
            {
                break label1;
            }
            obj1 = ((myobfuscated.g.d)c1).a;
            obj = ((myobfuscated.g.d)c1).o;
        }
          goto _L10
        if (!(c1 instanceof f)) goto _L12; else goto _L11
_L11:
        obj1 = ((f)c1).b;
        obj = ((f)c1).c;
          goto _L10
_L4:
        hashset.removeAll(hashset1);
        if (hashset.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_813;
        }
        obj1 = (String[])hashset.toArray(new String[hashset.size()]);
        i = 0;
        obj = " in (?";
_L14:
        if (i >= hashset.size() - 1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(",?").toString();
        i++;
        if (true) goto _L14; else goto _L13
_L13:
        obj = (new StringBuilder()).append(((String) (obj))).append(")").toString();
        a.getContentResolver().delete(com.socialin.android.photo.database.b.a, (new StringBuilder("notification_id")).append(((String) (obj))).toString(), ((String []) (obj1)));
        a.getContentResolver().bulkInsert(com.socialin.android.photo.database.b.a, acontentvalues);
        return;
        obj;
          goto _L15
        obj;
          goto _L15
_L12:
        obj = null;
        obj1 = null;
          goto _L10
_L2:
        i = 0;
        j = 0;
        if (true) goto _L17; else goto _L16
_L16:
    }

    onItem(NotificationsService notificationsservice)
    {
        a = notificationsservice;
        super();
    }
}
