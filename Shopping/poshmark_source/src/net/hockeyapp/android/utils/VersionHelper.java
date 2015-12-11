// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.utils;

import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import net.hockeyapp.android.UpdateInfoListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VersionHelper
{

    UpdateInfoListener listener;
    JSONObject newest;
    ArrayList sortedVersions;

    public VersionHelper(String s, UpdateInfoListener updateinfolistener)
    {
        listener = updateinfolistener;
        loadVersions(s);
        sortVersions();
    }

    private static int failSafeGetIntFromJSON(JSONObject jsonobject, String s, int i)
    {
        int j;
        try
        {
            j = jsonobject.getInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return i;
        }
        return j;
    }

    private static String failSafeGetStringFromJSON(JSONObject jsonobject, String s, String s1)
    {
        try
        {
            jsonobject = jsonobject.getString(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return s1;
        }
        return jsonobject;
    }

    private String getRestoreButton(int i, JSONObject jsonobject)
    {
        StringBuilder stringbuilder = new StringBuilder();
        jsonobject = getVersionID(jsonobject);
        if (jsonobject.length() > 0)
        {
            stringbuilder.append((new StringBuilder()).append("<a href='restore:").append(jsonobject).append("'  style='background: #c8c8c8; color: #000; display: block; float: right; padding: 7px; margin: 0px 10px 10px; text-decoration: none;'>Restore</a>").toString());
        }
        return stringbuilder.toString();
    }

    private Object getSeparator()
    {
        return "<hr style='border-top: 1px solid #c8c8c8; border-bottom: 0px; margin: 40px 10px 0px 10px;' />";
    }

    private int getVersionCode(JSONObject jsonobject)
    {
        int i;
        try
        {
            i = jsonobject.getInt("version");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return 0;
        }
        return i;
    }

    private String getVersionID(JSONObject jsonobject)
    {
        try
        {
            jsonobject = jsonobject.getString("id");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return "";
        }
        return jsonobject;
    }

    private String getVersionLine(int i, JSONObject jsonobject)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = getVersionCode(jsonobject);
        jsonobject = getVersionName(jsonobject);
        stringbuilder.append("<div style='padding: 20px 10px 10px;'><strong>");
        if (i == 0)
        {
            stringbuilder.append("Newest version:");
        } else
        {
            i = listener.getCurrentVersionCode();
            StringBuilder stringbuilder1 = (new StringBuilder()).append("Version ").append(jsonobject).append(" (").append(j).append("): ");
            if (j == i)
            {
                jsonobject = "[INSTALLED]";
            } else
            {
                jsonobject = "";
            }
            stringbuilder.append(stringbuilder1.append(jsonobject).toString());
        }
        stringbuilder.append("</strong></div>");
        return stringbuilder.toString();
    }

    private String getVersionName(JSONObject jsonobject)
    {
        try
        {
            jsonobject = jsonobject.getString("shortversion");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return "";
        }
        return jsonobject;
    }

    private String getVersionNotes(int i, JSONObject jsonobject)
    {
        StringBuilder stringbuilder = new StringBuilder();
        jsonobject = failSafeGetStringFromJSON(jsonobject, "notes", "");
        stringbuilder.append("<div style='padding: 0px 10px;'>");
        if (jsonobject.trim().length() == 0)
        {
            stringbuilder.append("<em>No information.</em>");
        } else
        {
            stringbuilder.append(jsonobject);
        }
        stringbuilder.append("</div>");
        return stringbuilder.toString();
    }

    private void loadVersions(String s)
    {
        newest = new JSONObject();
        int j;
        s = JSONArrayInstrumentation.init(s);
        sortedVersions = new ArrayList();
        j = listener.getCurrentVersionCode();
        int i = 0;
_L1:
        JSONObject jsonobject;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        jsonobject = s.getJSONObject(i);
        int k = j;
        if (jsonobject.getInt("version") > j)
        {
            newest = jsonobject;
            k = jsonobject.getInt("version");
        }
        sortedVersions.add(jsonobject);
        i++;
        j = k;
          goto _L1
        s;
        return;
        s;
    }

    private void sortVersions()
    {
        Collections.sort(sortedVersions, new Comparator() {

            final VersionHelper this$0;

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((JSONObject)obj, (JSONObject)obj1);
            }

            public int compare(JSONObject jsonobject, JSONObject jsonobject1)
            {
                int i;
                int j;
                try
                {
                    i = jsonobject.getInt("version");
                    j = jsonobject1.getInt("version");
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    return 0;
                }
                if (i <= j);
                return 0;
            }

            
            {
                this$0 = VersionHelper.this;
                super();
            }
        });
    }

    public String getFileInfoString()
    {
        int i = failSafeGetIntFromJSON(newest, "appsize", 0);
        Date date = new Date(1000L * (long)failSafeGetIntFromJSON(newest, "timestamp", 0));
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy");
        return (new StringBuilder()).append(simpledateformat.format(date)).append(" - ").append(String.format("%.2f", new Object[] {
            Float.valueOf((float)i / 1024F / 1024F)
        })).append(" MB").toString();
    }

    public String getReleaseNotes(boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<html>");
        stringbuilder.append("<body style='padding: 0px 0px 20px 0px'>");
        int i = 0;
        for (Iterator iterator = sortedVersions.iterator(); iterator.hasNext();)
        {
            JSONObject jsonobject = (JSONObject)iterator.next();
            if (i > 0)
            {
                stringbuilder.append(getSeparator());
                if (flag)
                {
                    stringbuilder.append(getRestoreButton(i, jsonobject));
                }
            }
            stringbuilder.append(getVersionLine(i, jsonobject));
            stringbuilder.append(getVersionNotes(i, jsonobject));
            i++;
        }

        stringbuilder.append("</body>");
        stringbuilder.append("</html>");
        return stringbuilder.toString();
    }

    public String getVersionString()
    {
        return (new StringBuilder()).append(failSafeGetStringFromJSON(newest, "shortversion", "")).append(" (").append(failSafeGetStringFromJSON(newest, "version", "")).append(")").toString();
    }
}
