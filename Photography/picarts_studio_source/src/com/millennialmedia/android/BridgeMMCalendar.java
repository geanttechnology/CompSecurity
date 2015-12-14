// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMLog, MMJSResponse

class BridgeMMCalendar extends MMJSObject
{

    private static final String a = com/millennialmedia/android/BridgeMMCalendar.getName();
    private static final String d[] = {
        "yyyy-MM-dd'T'HH:mmZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZ"
    };
    private static final SimpleDateFormat e = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

    BridgeMMCalendar()
    {
    }

    private static String a(JSONObject jsonobject)
    {
        Object obj;
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        stringbuilder = new StringBuilder();
        JSONArray jsonarray;
        int i;
        try
        {
            String s = jsonobject.getString("frequency");
            stringbuilder.append("FREQ=").append(s).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.b(a, "Unable to get calendar event recurrence frequency");
        }
        try
        {
            String s1 = e.format(DateUtils.parseDate(jsonobject.getString("expires"), d));
            stringbuilder.append("UNTIL=").append(s1).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.e(a, "Error parsing calendar event recurrence expiration date");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.b(a, "Unable to get calendar event recurrence expiration date");
        }
        jsonarray = jsonobject.getJSONArray("daysInWeek");
        stringbuilder1 = new StringBuilder();
        i = 0;
_L11:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        jsonarray.getInt(i);
        JVM INSTR tableswitch 1 7: default 377
    //                   1 201
    //                   2 382
    //                   3 388
    //                   4 394
    //                   5 400
    //                   6 406
    //                   7 412;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_412;
_L12:
        stringbuilder1.append(((String) (obj))).append(",");
        i++;
          goto _L11
_L4:
        obj = "MO";
          goto _L12
_L2:
        try
        {
            stringbuilder.append("BYDAY=").append(stringbuilder1).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.b(a, "Unable to get days in week");
        }
        try
        {
            obj = jsonobject.getString("daysInMonth").replaceAll("\\[", "").replaceAll("\\]", "");
            stringbuilder.append("BYMONTHDAY=").append(((String) (obj))).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.b(a, "Unable to get days in month");
        }
        try
        {
            obj = jsonobject.getString("monthsInYear:").replaceAll("\\[", "").replaceAll("\\]", "");
            stringbuilder.append("BYMONTH=").append(((String) (obj))).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.b(a, "Unable to get months in year:");
        }
        try
        {
            jsonobject = jsonobject.getString("daysInYear");
            stringbuilder.append("BYYEARDAY=").append(jsonobject).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            MMLog.b(a, "Unable to get days in year");
        }
        return stringbuilder.toString().toUpperCase();
_L3:
        obj = null;
          goto _L12
_L5:
        obj = "TU";
          goto _L12
_L6:
        obj = "WE";
          goto _L12
_L7:
        obj = "TH";
          goto _L12
_L8:
        obj = "FR";
          goto _L12
_L9:
        obj = "SA";
          goto _L12
        obj = "SU";
          goto _L12
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if ("addEvent".equals(s))
        {
            mmjsresponse = addEvent(map);
        }
        return mmjsresponse;
    }

    public MMJSResponse addEvent(Map map)
    {
        MMLog.b(a, (new StringBuilder("addEvent parameters: ")).append(map).toString());
        if (android.os.Build.VERSION.SDK_INT < 14) goto _L2; else goto _L1
_L1:
        if (map == null || map.get("parameters") == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        try
        {
            obj1 = new JSONObject((String)map.get("parameters"));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            MMLog.e(a, "Unable to parse calendar addEvent parameters");
            return MMJSResponse.b("Calendar Event Creation Failed.  Invalid parameters");
        }
        s = ((JSONObject) (obj1)).getString("description");
_L14:
        s1 = ((JSONObject) (obj1)).getString("summary");
_L5:
        s2 = ((JSONObject) (obj1)).getString("transparency");
_L6:
        s3 = ((JSONObject) (obj1)).getString("reminder");
_L7:
        s4 = ((JSONObject) (obj1)).getString("location");
_L8:
        s5 = ((JSONObject) (obj1)).getString("status");
_L9:
        s6 = a(((JSONObject) (obj1)).getJSONObject("recurrence"));
_L10:
        obj = DateUtils.parseDate(((JSONObject) (obj1)).getString("start"), d);
_L11:
        obj1 = DateUtils.parseDate(((JSONObject) (obj1)).getString("end"), d);
_L12:
        MMLog.b(a, String.format("Creating calendar event: title: %s, location: %s, start: %s, end: %s, status: %s, summary: %s, rrule: %s", new Object[] {
            s, s4, obj, obj1, s5, s1, s6
        }));
        if (s == null || obj == null)
        {
            MMLog.e(a, "Description and start must be provided to create calendar event.");
            return MMJSResponse.b("Calendar Event Creation Failed.  Minimum parameters not provided");
        }
        break MISSING_BLOCK_LABEL_404;
        obj;
        MMLog.e(a, "Unable to get calendar event description");
        s = null;
        continue; /* Loop/switch isn't completed */
        obj;
        MMLog.b(a, "Unable to get calendar event description");
        s1 = null;
          goto _L5
        obj;
        MMLog.b(a, "Unable to get calendar event transparency");
        s2 = null;
          goto _L6
        obj;
        MMLog.b(a, "Unable to get calendar event reminder");
        s3 = null;
          goto _L7
        obj;
        MMLog.b(a, "Unable to get calendar event location");
        s4 = null;
          goto _L8
        obj;
        MMLog.b(a, "Unable to get calendar event status");
        s5 = null;
          goto _L9
        obj;
        MMLog.b(a, "Unable to get calendar event recurrence");
        s6 = null;
          goto _L10
        obj;
        MMLog.e(a, "Error parsing calendar event start date");
        obj = null;
          goto _L11
        obj;
        MMLog.e(a, "Unable to get calendar event start date");
        obj = null;
          goto _L11
        obj1;
        MMLog.e(a, "Error parsing calendar event end date");
        obj1 = null;
          goto _L12
        obj1;
        MMLog.b(a, "Unable to get calendar event end date");
        obj1 = null;
          goto _L12
        Intent intent = (new Intent("android.intent.action.INSERT")).setData(android.provider.CalendarContract.Events.CONTENT_URI);
        if (obj != null)
        {
            intent.putExtra("beginTime", ((Date) (obj)).getTime());
        }
        if (obj1 != null)
        {
            intent.putExtra("endTime", ((Date) (obj1)).getTime());
        }
        if (s != null)
        {
            intent.putExtra("title", s);
        }
        if (s1 != null)
        {
            intent.putExtra("description", s1);
        }
        if (s4 != null)
        {
            intent.putExtra("eventLocation", s4);
        }
        if (s6 != null)
        {
            intent.putExtra("rrule", s6);
        }
        if (s5 != null)
        {
            MMLog.d(a, "Calendar addEvent does not support status");
        }
        if (s2 != null)
        {
            MMLog.d(a, "Calendar addEvent does not support transparency");
        }
        if (s3 != null)
        {
            MMLog.d(a, "Calendar addEvent does not support reminder");
        }
        obj = (Context)b.get();
        if (obj != null)
        {
            Utils.IntentUtils.c(((Context) (obj)), intent);
            MMSDK.Event.a(((Context) (obj)), "calendar", a((String)map.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a("Calendar Event Created");
        }
_L4:
        return null;
_L2:
        return MMJSResponse.b("Not supported");
        if (true) goto _L14; else goto _L13
_L13:
    }

}
