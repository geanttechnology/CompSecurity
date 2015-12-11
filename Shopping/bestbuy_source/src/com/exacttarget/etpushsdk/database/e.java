// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.util.a;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import com.exacttarget.etpushsdk.util.n;
import java.util.ArrayList;
import java.util.List;

public class e
{

    public static final String a[] = {
        "id", "alert", "sound", "badge", "open_direct", "category", "start_date", "end_date", "message_type", "content_type", 
        "page_id", "url", "subject", "site_id", "read", "custom", "keys", "period_show_count", "last_shown_date", "next_allowed_show", 
        "show_count", "message_limit", "rolling_period", "period_type", "number_of_periods", "messages_per_period", "message_deleted", "min_tripped", "proximity", "ephemeral_message", 
        "has_entered", "notify_id", "loiter_seconds", "entry_time"
    };

    public static int a(String s, ContentValues contentvalues)
    {
        s = String.valueOf(s);
        return i.a().b().update("messages", contentvalues, "id = ?", new String[] {
            s
        });
    }

    public static int a(String s, String as[], ContentValues contentvalues)
    {
        return i.a().b().update("messages", contentvalues, s, as);
    }

    public static Message a(Cursor cursor)
    {
        Message message;
        boolean flag1;
        flag1 = true;
        message = new Message();
        message.setId(cursor.getString(cursor.getColumnIndex("id")));
        message.setAlert(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("alert"))));
        message.setSound(cursor.getString(cursor.getColumnIndex("sound")));
        message.setBadge(cursor.getString(cursor.getColumnIndex("badge")));
        message.setOpenDirect(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("open_direct"))));
        message.setCategory(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("category"))));
        message.setStartDate(n.a(cursor.getString(cursor.getColumnIndex("start_date"))));
        message.setEndDate(n.a(cursor.getString(cursor.getColumnIndex("end_date"))));
        message.setMessageType(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("message_type"))));
        message.setContentType(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("content_type"))));
        message.setPageId(cursor.getString(cursor.getColumnIndex("page_id")));
        message.setUrl(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("url"))));
        message.setSubject(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("subject"))));
        message.setSiteId(cursor.getString(cursor.getColumnIndex("site_id")));
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndex("read")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        message.setRead(Boolean.valueOf(flag));
        message.setCustom(cursor.getString(cursor.getColumnIndex("custom")));
        message.setKeys(Registration.deserializeAttributes(com.exacttarget.etpushsdk.util.a.b(ETPush.a(), cursor.getString(cursor.getColumnIndex("keys")))));
        message.setPeriodShowCount(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("period_show_count"))));
        message.setLastShownDate(n.a(cursor.getString(cursor.getColumnIndex("last_shown_date"))));
        message.setNextAllowedShow(n.a(cursor.getString(cursor.getColumnIndex("next_allowed_show"))));
        message.setShowCount(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("show_count"))));
        message.setMessageLimit(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("message_limit"))));
        if (cursor.getInt(cursor.getColumnIndex("rolling_period")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        message.setIsRollingPeriod(Boolean.valueOf(flag));
        message.setPeriodType(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("period_type"))));
        message.setNumberOfPeriods(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("number_of_periods"))));
        message.setMessagesPerPeriod(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("messages_per_period"))));
        if (cursor.getInt(cursor.getColumnIndex("message_deleted")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        message.setMessageDeleted(Boolean.valueOf(flag));
        message.setMinTripped(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("min_tripped"))));
        message.setProximity(cursor.getInt(cursor.getColumnIndex("proximity")));
        if (cursor.getInt(cursor.getColumnIndex("ephemeral_message")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        message.setEphemeralMessage(Boolean.valueOf(flag));
        if (cursor.getInt(cursor.getColumnIndex("has_entered")) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        try
        {
            message.setHasEntered(Boolean.valueOf(flag));
            message.setNotifyId(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("notify_id"))));
            message.setLoiterSeconds(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("loiter_seconds"))));
            message.setEntryTime(Long.valueOf(cursor.getLong(cursor.getColumnIndex("entry_time"))));
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            m.c("~!de", cursor.getMessage(), cursor);
            return null;
        }
        return message;
    }

    public static Message a(String s)
    {
        Object obj1 = null;
        Object obj = null;
        Cursor cursor = i.a().b().query("messages", a, "id = ?", new String[] {
            s
        }, null, null, null, "1");
        s = obj1;
        if (cursor != null)
        {
            s = obj;
            if (cursor.moveToFirst())
            {
                s = a(cursor);
            }
            cursor.close();
        }
        return s;
    }

    public static List a(String s, String as[], String s1, String s2, String s3)
    {
        s = i.a().b().query("messages", a, s, as, s1, s2, s3);
        as = new ArrayList();
        if (s != null)
        {
            s.moveToFirst();
            for (; !s.isAfterLast(); s.moveToNext())
            {
                as.add(a(((Cursor) (s))));
            }

            s.close();
        }
        return as;
    }

    public static void a(Message message)
    {
        i.a().b().insert("messages", null, d(message));
    }

    public static int b(String s)
    {
        return i.a().b().delete("messages", "id = ?", new String[] {
            s
        });
    }

    public static void b(Message message)
    {
        if (a(message.getId()) == null)
        {
            a(message);
            return;
        } else
        {
            c(message);
            return;
        }
    }

    public static int c(Message message)
    {
        String s = String.valueOf(message.getId());
        return i.a().b().update("messages", d(message), "id = ?", new String[] {
            s
        });
    }

    private static ContentValues d(Message message)
    {
        boolean flag = true;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", message.getId());
        contentvalues.put("alert", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), message.getAlert()));
        contentvalues.put("sound", message.getSound());
        contentvalues.put("badge", message.getBadge());
        contentvalues.put("open_direct", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), message.getOpenDirect()));
        contentvalues.put("category", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), message.getCategory()));
        contentvalues.put("start_date", n.a(message.getStartDate()));
        contentvalues.put("end_date", n.a(message.getEndDate()));
        contentvalues.put("message_type", message.getMessageType());
        contentvalues.put("content_type", message.getContentType());
        contentvalues.put("page_id", message.getPageId());
        contentvalues.put("url", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), message.getUrl()));
        contentvalues.put("subject", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), message.getSubject()));
        contentvalues.put("site_id", message.getSiteId());
        int j;
        if (message.getRead().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("read", Integer.valueOf(j));
        contentvalues.put("custom", message.getCustom());
        contentvalues.put("custom", message.getCustom());
        contentvalues.put("keys", com.exacttarget.etpushsdk.util.a.a(ETPush.a(), Registration.serializeAttributes(message.getKeys())));
        contentvalues.put("period_show_count", message.getPeriodShowCount());
        contentvalues.put("last_shown_date", n.a(message.getLastShownDate()));
        contentvalues.put("next_allowed_show", n.a(message.getNextAllowedShow()));
        contentvalues.put("show_count", message.getShowCount());
        contentvalues.put("message_limit", message.getMessageLimit());
        if (message.getIsRollingPeriod().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("rolling_period", Integer.valueOf(j));
        contentvalues.put("period_type", message.getPeriodType());
        contentvalues.put("number_of_periods", message.getNumberOfPeriods());
        contentvalues.put("messages_per_period", message.getMessagesPerPeriod());
        if (message.getMessageDeleted().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("message_deleted", Integer.valueOf(j));
        contentvalues.put("min_tripped", message.getMinTripped());
        contentvalues.put("proximity", Integer.valueOf(message.getProximity()));
        if (message.getEphemeralMessage().booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("ephemeral_message", Integer.valueOf(j));
        if (message.getHasEntered().booleanValue())
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        contentvalues.put("has_entered", Integer.valueOf(j));
        contentvalues.put("notify_id", message.getNotifyId());
        contentvalues.put("loiter_seconds", message.getLoiterSeconds());
        contentvalues.put("entry_time", message.getEntryTime());
        return contentvalues;
    }

}
