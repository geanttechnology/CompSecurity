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
//            ai, al, aj

class k extends ai
{

    private static final String a = com/millennialmedia/android/k.getName();
    private static final String d[] = {
        "yyyy-MM-dd'T'HH:mmZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZ"
    };
    private static final SimpleDateFormat e = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

    k()
    {
    }

    private aj a(Map map)
    {
        (new StringBuilder("addEvent parameters: ")).append(map);
        al.b();
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
            al.a(a, "Unable to parse calendar addEvent parameters");
            return aj.b("Calendar Event Creation Failed.  Invalid parameters");
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
        String.format("Creating calendar event: title: %s, location: %s, start: %s, end: %s, status: %s, summary: %s, rrule: %s", new Object[] {
            s, s4, obj, obj1, s5, s1, s6
        });
        al.b();
        if (s == null || obj == null)
        {
            al.a(a, "Description and start must be provided to create calendar event.");
            return aj.b("Calendar Event Creation Failed.  Minimum parameters not provided");
        }
        break MISSING_BLOCK_LABEL_356;
        obj;
        al.a(a, "Unable to get calendar event description");
        s = null;
        continue; /* Loop/switch isn't completed */
        obj;
        s1 = null;
        al.b();
          goto _L5
        obj;
        s2 = null;
        al.b();
          goto _L6
        obj;
        s3 = null;
        al.b();
          goto _L7
        obj;
        s4 = null;
        al.b();
          goto _L8
        obj;
        s5 = null;
        al.b();
          goto _L9
        obj;
        s6 = null;
        al.b();
          goto _L10
        obj;
        al.a(a, "Error parsing calendar event start date");
        obj = null;
          goto _L11
        obj;
        al.a(a, "Unable to get calendar event start date");
        obj = null;
          goto _L11
        obj1;
        al.a(a, "Error parsing calendar event end date");
        obj1 = null;
          goto _L12
        obj1;
        obj1 = null;
        al.b();
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
            al.d();
        }
        if (s2 != null)
        {
            al.d();
        }
        if (s3 != null)
        {
            al.d();
        }
        obj = (Context)b.get();
        if (obj != null)
        {
            au.b.b(((Context) (obj)), intent);
            an.a.a(((Context) (obj)), "calendar", a((String)map.get("PROPERTY_EXPANDING")));
            return aj.a("Calendar Event Created");
        }
_L4:
        return null;
_L2:
        return aj.b("Not supported");
        if (true) goto _L14; else goto _L13
_L13:
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
            al.b();
        }
        try
        {
            String s1 = e.format(DateUtils.parseDate(jsonobject.getString("expires"), d));
            stringbuilder.append("UNTIL=").append(s1).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            al.a(a, "Error parsing calendar event recurrence expiration date");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            al.b();
        }
        jsonarray = jsonobject.getJSONArray("daysInWeek");
        stringbuilder1 = new StringBuilder();
        i = 0;
_L11:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        jsonarray.getInt(i);
        JVM INSTR tableswitch 1 7: default 365
    //                   1 193
    //                   2 370
    //                   3 377
    //                   4 384
    //                   5 391
    //                   6 398
    //                   7 405;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_405;
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
            al.b();
        }
        try
        {
            obj = jsonobject.getString("daysInMonth").replaceAll("\\[", "").replaceAll("\\]", "");
            stringbuilder.append("BYMONTHDAY=").append(((String) (obj))).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            al.b();
        }
        try
        {
            obj = jsonobject.getString("monthsInYear:").replaceAll("\\[", "").replaceAll("\\]", "");
            stringbuilder.append("BYMONTH=").append(((String) (obj))).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            al.b();
        }
        try
        {
            jsonobject = jsonobject.getString("daysInYear");
            stringbuilder.append("BYYEARDAY=").append(jsonobject).append(";");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            al.b();
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

    final aj a(String s, Map map)
    {
        aj aj1 = null;
        if ("addEvent".equals(s))
        {
            aj1 = a(map);
        }
        return aj1;
    }

}
