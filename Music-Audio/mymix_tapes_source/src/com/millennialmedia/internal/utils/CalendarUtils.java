// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.millennialmedia.MMLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal.utils:
//            EnvironmentUtils

public class CalendarUtils
{
    public static interface CalendarListener
    {

        public abstract void onError(String s);

        public abstract void onSuccess();

        public abstract void onUIDisplayed();
    }


    private static final String DaysInWeekArray[] = {
        "SU", "MO", "TU", "WE", "TH", "FR", "SA", "SU"
    };
    private static final String TAG = com/millennialmedia/internal/utils/CalendarUtils.getSimpleName();
    private static final String calendarEventDateFormats[] = {
        "yyyy-MM-dd'T'HH:mmZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZ"
    };
    private static final SimpleDateFormat rruleUntilDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

    public CalendarUtils()
    {
    }

    public static void addEvent(Context context, JSONObject jsonobject, CalendarListener calendarlistener)
    {
        if (EnvironmentUtils.hasCalendarPermission())
        {
            addEventWithAPI(context, jsonobject, calendarlistener);
            return;
        } else
        {
            addEventWithIntent(context, jsonobject, calendarlistener);
            return;
        }
    }

    public static void addEventWithAPI(Context context, JSONObject jsonobject, CalendarListener calendarlistener)
    {
        Object obj;
        Date date;
        String s2;
        Date date1;
        String s3;
        String s4;
        Integer integer;
        if (calendarlistener == null)
        {
            MMLog.e(TAG, "CalendarListener is required");
            return;
        }
        if (!EnvironmentUtils.hasCalendarPermission())
        {
            calendarlistener.onError("Application does not have permission to update calendar");
            return;
        }
        s2 = jsonobject.optString("description", null);
        date = parseDate(jsonobject.optString("start", null));
        date1 = parseDate(jsonobject.optString("end", null));
        s3 = jsonobject.optString("location", null);
        s4 = getRecurrenceRule(jsonobject.optJSONObject("recurrence"));
        String s = jsonobject.optString("summary", null);
        integer = getTransparency(jsonobject.optString("transparency", null));
        String s1 = jsonobject.optString("url", null);
        obj = s;
        if (s1 != null)
        {
            if (s == null)
            {
                obj = s1;
            } else
            {
                obj = (new StringBuilder()).append(s).append(System.getProperty("line.separator")).append(s1).toString();
            }
        }
        if (s2 == null || date == null)
        {
            calendarlistener.onError("Description and start are required");
            return;
        }
        Object obj1;
        context = context.getContentResolver();
        obj1 = new ContentValues();
        ((ContentValues) (obj1)).put("calendar_id", Long.valueOf(1L));
        ((ContentValues) (obj1)).put("eventTimezone", TimeZone.getDefault().getID());
        ((ContentValues) (obj1)).put("title", s2);
        ((ContentValues) (obj1)).put("dtstart", Long.valueOf(date.getTime()));
        if (date1 == null)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        ((ContentValues) (obj1)).put("dtend", Long.valueOf(date1.getTime()));
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        ((ContentValues) (obj1)).put("eventLocation", s3);
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        ((ContentValues) (obj1)).put("rrule", s4);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        ((ContentValues) (obj1)).put("description", ((String) (obj)));
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        ((ContentValues) (obj1)).put("availability", integer);
        obj = context.insert(android.provider.CalendarContract.Events.CONTENT_URI, ((ContentValues) (obj1)));
        if (obj == null)
        {
            try
            {
                calendarlistener.onError("Unable to add calendar event");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MMLog.e(TAG, "Exception adding calendar event: ", context);
            }
            calendarlistener.onError("Error occurred adding calendar event");
            return;
        }
        obj1 = Long.valueOf(((Uri) (obj)).getLastPathSegment());
        jsonobject = getReminderTimeInMinutes(jsonobject.optString("reminder", null), date);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_449;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("event_id", ((Long) (obj1)));
        contentvalues.put("method", Integer.valueOf(1));
        contentvalues.put("minutes", jsonobject);
        if (context.insert(android.provider.CalendarContract.Reminders.CONTENT_URI, contentvalues) == null)
        {
            context.delete(((Uri) (obj)), null, null);
            calendarlistener.onError("Unable to add reminder to calendar event");
            return;
        }
        calendarlistener.onSuccess();
        return;
    }

    public static void addEventWithIntent(Context context, JSONObject jsonobject, CalendarListener calendarlistener)
    {
        if (calendarlistener == null)
        {
            MMLog.e(TAG, "CalendarListener is required");
            return;
        }
        String s = jsonobject.optString("description", null);
        String s1 = jsonobject.optString("summary", null);
        String s2 = jsonobject.optString("location", null);
        String s3 = getRecurrenceRule(jsonobject.optJSONObject("recurrence"));
        Date date = parseDate(jsonobject.optString("start", null));
        Date date1 = parseDate(jsonobject.optString("end", null));
        jsonobject = getTransparency(jsonobject.optString("transparency", null));
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, String.format("Creating calendar event: title: %s, location: %s, start: %s, end: %s, description: %s, rrule: %s, transparency: %s", new Object[] {
                s, s2, date, date1, s1, s3, jsonobject
            }));
        }
        if (s == null || date == null)
        {
            calendarlistener.onError("Description and start are required");
            return;
        }
        Intent intent = (new Intent("android.intent.action.INSERT")).setData(android.provider.CalendarContract.Events.CONTENT_URI);
        intent.putExtra("title", s);
        intent.putExtra("beginTime", date.getTime());
        if (date1 != null)
        {
            intent.putExtra("endTime", date1.getTime());
        }
        if (s1 != null)
        {
            intent.putExtra("description", s1);
        }
        if (s2 != null)
        {
            intent.putExtra("eventLocation", s2);
        }
        if (s3 != null)
        {
            intent.putExtra("rrule", s3);
        }
        if (jsonobject != null)
        {
            intent.putExtra("availability", jsonobject);
        }
        try
        {
            context.startActivity(intent);
            calendarlistener.onUIDisplayed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            calendarlistener.onError("No calendar application installed");
        }
    }

    public static ArrayList convertDaysToRRuleDays(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            int j = jsonarray.optInt(i, 0);
            if (j >= 0 && j < DaysInWeekArray.length)
            {
                arraylist.add(DaysInWeekArray[j]);
            } else
            {
                MMLog.e(TAG, (new StringBuilder()).append("Invalid index for day of week <").append(j).append(">").toString());
            }
            i++;
        }
        return arraylist;
    }

    public static String getRecurrenceRule(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        Object obj = jsonobject.optString("frequency", null);
        if (obj == null)
        {
            MMLog.e(TAG, "frequency is required for recurrence rule");
            return null;
        }
        stringbuilder.append("FREQ=").append(((String) (obj))).append(";");
        obj = parseDate(jsonobject.optString("expires", null));
        if (obj != null)
        {
            obj = rruleUntilDateFormat.format(((Date) (obj)));
            stringbuilder.append("UNTIL=").append(((String) (obj))).append(";");
        }
        obj = jsonobject.optJSONArray("daysInWeek");
        if (obj != null)
        {
            obj = convertDaysToRRuleDays(((JSONArray) (obj)));
            if (((ArrayList) (obj)).size() > 0)
            {
                stringbuilder.append("BYDAY=").append(TextUtils.join(",", ((Iterable) (obj)))).append(";");
            }
        }
        obj = jsonobject.optString("daysInMonth", null);
        if (obj != null)
        {
            obj = ((String) (obj)).replaceAll("\\[", "").replaceAll("\\]", "");
            stringbuilder.append("BYMONTHDAY=").append(((String) (obj))).append(";");
        }
        obj = jsonobject.optString("monthsInYear", null);
        if (obj != null)
        {
            obj = ((String) (obj)).replaceAll("\\[", "").replaceAll("\\]", "");
            stringbuilder.append("BYMONTH=").append(((String) (obj))).append(";");
        }
        jsonobject = jsonobject.optString("daysInYear", null);
        if (jsonobject != null)
        {
            stringbuilder.append("BYYEARDAY=").append(jsonobject).append(";");
        }
        return stringbuilder.toString().toUpperCase();
    }

    public static Long getReminderTimeInMinutes(String s, Date date)
    {
        long l = -1L;
        if (s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (!s.startsWith("-"))
        {
            break; /* Loop/switch isn't completed */
        }
        long l1 = Long.parseLong(s);
        l = l1 * -1L;
_L4:
        if (l >= 0L)
        {
            return Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(l));
        }
        if (true) goto _L1; else goto _L3
        date;
        MMLog.e(TAG, (new StringBuilder()).append("Unable to convert reminder time to minutes <").append(s).append(">").toString());
          goto _L4
_L3:
        s = parseDate(s);
        if (s != null)
        {
            l = date.getTime() - s.getTime();
        }
          goto _L4
    }

    public static Integer getTransparency(String s)
    {
        Integer integer = null;
        if ("transparent".equals(s))
        {
            integer = Integer.valueOf(1);
        } else
        if ("opaque".equals(s))
        {
            return Integer.valueOf(0);
        }
        return integer;
    }

    public static Date parseDate(String s)
    {
        if (s == null)
        {
            return null;
        }
        Date date;
        try
        {
            date = DateUtils.parseDate(s, calendarEventDateFormats);
        }
        catch (DateParseException dateparseexception)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Error parsing calendar event date <").append(s).append(">").toString());
            return null;
        }
        return date;
    }

}
