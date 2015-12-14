// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.log.ACRALog;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONReportBuilder
{
    public static class JSONReportException extends Exception
    {

        private static final long serialVersionUID = 0xf65bfc8fa41205d5L;

        public JSONReportException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    public JSONReportBuilder()
    {
    }

    private static void addJSONFromProperty(JSONObject jsonobject, String s)
        throws JSONException
    {
        int i = s.indexOf('=');
        if (i > 0)
        {
            String s1 = s.substring(0, i).trim();
            Object obj = guessType(s.substring(i + 1).trim());
            s = ((String) (obj));
            if (obj instanceof String)
            {
                s = ((String)obj).replaceAll("\\\\n", "\n");
            }
            String as[] = s1.split("\\.");
            if (as.length > 1)
            {
                addJSONSubTree(jsonobject, as, s);
                return;
            } else
            {
                jsonobject.accumulate(s1, s);
                return;
            }
        } else
        {
            jsonobject.put(s.trim(), true);
            return;
        }
    }

    private static void addJSONSubTree(JSONObject jsonobject, String as[], Object obj)
        throws JSONException
    {
        int i = 0;
        while (i < as.length) 
        {
            String s = as[i];
            if (i < as.length - 1)
            {
                if (jsonobject.isNull(s))
                {
                    JSONObject jsonobject1 = new JSONObject();
                    jsonobject.accumulate(s, jsonobject1);
                    jsonobject = jsonobject1;
                } else
                {
                    jsonobject = jsonobject.getJSONObject(s);
                }
            } else
            {
                jsonobject.accumulate(s, obj);
            }
            i++;
        }
    }

    public static JSONObject buildJSONReport(CrashReportData crashreportdata)
        throws JSONReportException
    {
        JSONObject jsonobject;
        Iterator iterator;
        jsonobject = new JSONObject();
        iterator = crashreportdata.keySet().iterator();
_L3:
        ReportField reportfield;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        reportfield = (ReportField)iterator.next();
        JSONObject jsonobject1;
        BufferedReader bufferedreader;
        if (!reportfield.containsKeyValuePairs())
        {
            break MISSING_BLOCK_LABEL_185;
        }
        jsonobject1 = new JSONObject();
        bufferedreader = new BufferedReader(new StringReader(crashreportdata.getProperty(reportfield)), 1024);
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        addJSONFromProperty(jsonobject1, s);
          goto _L1
        IOException ioexception;
        ioexception;
        ACRA.log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Error while converting ").append(reportfield.name()).append(" to JSON.").toString(), ioexception);
        jsonobject.accumulate(reportfield.name(), jsonobject1);
        continue; /* Loop/switch isn't completed */
        try
        {
            jsonobject.accumulate(reportfield.name(), guessType(crashreportdata.getProperty(reportfield)));
        }
        // Misplaced declaration of an exception variable
        catch (CrashReportData crashreportdata)
        {
            throw new JSONReportException((new StringBuilder()).append("Could not create JSON object for key ").append(reportfield).toString(), crashreportdata);
        }
        if (true) goto _L3; else goto _L2
_L2:
        return jsonobject;
    }

    private static Object guessType(String s)
    {
        Object obj;
        if (s.equalsIgnoreCase("true"))
        {
            return Boolean.valueOf(true);
        }
        if (s.equalsIgnoreCase("false"))
        {
            return Boolean.valueOf(false);
        }
        if (!s.matches("(?:^|\\s)([1-9](?:\\d*|(?:\\d{0,2})(?:,\\d{3})*)(?:\\.\\d*[1-9])?|0?\\.\\d*[1-9]|0)(?:\\s|$)"))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        obj = NumberFormat.getInstance(Locale.US);
        obj = ((NumberFormat) (obj)).parse(s);
        return obj;
        ParseException parseexception;
        parseexception;
        return s;
    }
}
