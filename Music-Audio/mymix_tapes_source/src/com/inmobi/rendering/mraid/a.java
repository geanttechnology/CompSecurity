// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.inmobi.commons.core.utilities.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class a
{

    private static final SimpleDateFormat a[];
    private static String b = com/inmobi/rendering/mraid/a.getSimpleName();

    public a()
    {
    }

    public static int a(Context context)
    {
        boolean flag = false;
        context = context.getContentResolver().query(android.provider.CalendarContract.Events.CONTENT_URI, new String[] {
            "_id", "title"
        }, null, null, null);
        int i = ((flag) ? 1 : 0);
        if (context != null)
        {
            i = ((flag) ? 1 : 0);
            if (context.moveToLast())
            {
                i = context.getColumnIndex("title");
                int j = context.getColumnIndex("_id");
                String s = context.getString(i);
                String s1 = context.getString(j);
                if (s != null)
                {
                    i = Integer.parseInt(s1);
                } else
                {
                    i = 0;
                }
                context.close();
            }
        }
        return i;
    }

    public static String a(String s)
    {
        Object obj;
        Object obj2;
        boolean flag;
        obj2 = null;
        flag = false;
        obj = obj2;
        if (s == null) goto _L2; else goto _L1
_L1:
        obj = obj2;
        if ("".equals(s)) goto _L2; else goto _L3
_L3:
        Object aobj[];
        int i;
        int j;
        aobj = a;
        j = aobj.length;
        i = 0;
_L6:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        obj = aobj[i];
        obj = ((SimpleDateFormat) (obj)).parse(s);
        s = ((String) (obj));
_L8:
        obj = obj2;
        if (s == null) goto _L2; else goto _L4
_L4:
        aobj = new DateFormat[3];
        aobj[0] = new SimpleDateFormat("yyyyMMdd'T'HHmmssZ");
        aobj[1] = new SimpleDateFormat("yyyyMMdd'T'HHmm");
        aobj[2] = new SimpleDateFormat("yyyyMMdd");
        j = aobj.length;
        i = ((flag) ? 1 : 0);
_L7:
        obj = obj2;
        if (i >= j) goto _L2; else goto _L5
_L5:
        obj = aobj[i];
        obj = ((DateFormat) (obj)).format(Long.valueOf(s.getTime()));
_L2:
        return ((String) (obj));
        Object obj1;
        obj1;
        i++;
          goto _L6
        obj1;
        i++;
          goto _L7
        s = null;
          goto _L8
    }

    public static String a(JSONArray jsonarray)
    {
        Object obj;
        int i;
        if (jsonarray == null || jsonarray.length() == 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = new StringBuilder();
        i = 0;
_L2:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = jsonarray.get(i);
        ((StringBuilder) (obj)).append((new StringBuilder()).append(obj1).append(",").toString());
        i++;
        if (true) goto _L2; else goto _L1
        jsonarray;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Could not parse day object ").append(jsonarray.toString()).toString());
        jsonarray = null;
_L4:
        return jsonarray;
_L1:
        obj = ((StringBuilder) (obj)).toString();
        i = ((String) (obj)).length();
        if (i == 0)
        {
            return null;
        }
        jsonarray = ((JSONArray) (obj));
        if (((String) (obj)).charAt(i - 1) != ',') goto _L4; else goto _L3
_L3:
        return ((String) (obj)).substring(0, i - 1);
        return null;
    }

    public static String a(JSONArray jsonarray, int i, int j)
    {
        if (jsonarray == null || jsonarray.length() == 0) goto _L2; else goto _L1
_L1:
        Object obj;
        int k;
        obj = new StringBuilder();
        k = 0;
_L11:
        if (k >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        int l = jsonarray.getInt(k);
        if (l >= i && l <= j && l != 0) goto _L6; else goto _L5
_L5:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Value not in range");
          goto _L7
_L6:
        ((StringBuilder) (obj)).append(l).append(",");
          goto _L7
        jsonarray;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Could not parse day ").append(jsonarray.getMessage()).toString());
        jsonarray = null;
_L9:
        return jsonarray;
_L4:
        obj = ((StringBuilder) (obj)).toString();
        i = ((String) (obj)).length();
        if (i == 0)
        {
            return null;
        }
        jsonarray = ((JSONArray) (obj));
        if (((String) (obj)).charAt(i - 1) != ',') goto _L9; else goto _L8
_L8:
        return ((String) (obj)).substring(0, i - 1);
_L2:
        return null;
_L7:
        k++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static GregorianCalendar b(String s)
    {
        SimpleDateFormat asimpledateformat[];
        int i;
        int j;
        asimpledateformat = a;
        j = asimpledateformat.length;
        i = 0;
_L2:
        SimpleDateFormat simpledateformat;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        simpledateformat = asimpledateformat[i];
        Object obj;
        obj = simpledateformat.parse(s);
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTime(((Date) (obj)));
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Date format: ").append(simpledateformat.toPattern()).toString());
        obj = (GregorianCalendar)gregoriancalendar;
        return ((GregorianCalendar) (obj));
        ParseException parseexception;
        parseexception;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Skipping format: ").append(simpledateformat.toPattern()).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    static 
    {
        a = (new SimpleDateFormat[] {
            new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US), new SimpleDateFormat("yyyy-MM", Locale.US), new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.US), new SimpleDateFormat("yyyyMMddHHmm", Locale.US), new SimpleDateFormat("yyyyMMdd", Locale.US), new SimpleDateFormat("yyyyMM", Locale.US), 
            new SimpleDateFormat("yyyy", Locale.US)
        });
    }
}
