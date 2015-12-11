// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.e;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import net.hockeyapp.android.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.hockeyapp.android.e:
//            j

public final class i
{

    ArrayList a;
    JSONObject b;
    x c;

    public i(String s, x x1)
    {
        c = x1;
        a(s);
        Collections.sort(a, new j(this));
    }

    public static int a(String s, String s1)
    {
        byte byte0 = -1;
        if (s != null && s1 != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L6:
        return k;
_L2:
        s = new Scanner(s.replaceAll("\\-.*", ""));
        s1 = new Scanner(s1.replaceAll("\\-.*", ""));
        s.useDelimiter("\\.");
        s1.useDelimiter("\\.");
_L4:
        int l;
        int i1;
        if (!s.hasNextInt() || !s1.hasNextInt())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        l = s.nextInt();
        i1 = s1.nextInt();
        k = byte0;
        if (l < i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l <= i1) goto _L4; else goto _L3
_L3:
        return 1;
        if (s.hasNextInt())
        {
            return 1;
        }
        boolean flag;
        try
        {
            flag = s1.hasNextInt();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        k = byte0;
        if (!flag)
        {
            return 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static int a(JSONObject jsonobject)
    {
        int k;
        try
        {
            k = jsonobject.getInt("version");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return 0;
        }
        return k;
    }

    private static int a(JSONObject jsonobject, String s)
    {
        int k;
        try
        {
            k = jsonobject.getInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return 0;
        }
        return k;
    }

    private static String a(JSONObject jsonobject, String s, String s1)
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

    private void a(String s)
    {
        b = new JSONObject();
        a = new ArrayList();
        int l;
        s = new JSONArray(s);
        l = c.getCurrentVersionCode();
        int k = 0;
_L1:
        JSONObject jsonobject;
        if (k >= s.length())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        jsonobject = s.getJSONObject(k);
        int i1 = l;
        if (jsonobject.getInt("version") > l)
        {
            b = jsonobject;
            i1 = jsonobject.getInt("version");
        }
        a.add(jsonobject);
        k++;
        l = i1;
          goto _L1
        s;
        return;
        s;
    }

    private static String b(JSONObject jsonobject)
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

    public final String a()
    {
        return (new StringBuilder()).append(a(b, "shortversion", "")).append(" (").append(a(b, "version", "")).append(")").toString();
    }

    public final String b()
    {
        int k = a(b, "appsize");
        Date date = new Date((long)a(b, "timestamp") * 1000L);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy");
        return (new StringBuilder()).append(simpledateformat.format(date)).append(" - ").append(String.format("%.2f", new Object[] {
            Float.valueOf((float)k / 1024F / 1024F)
        })).append(" MB").toString();
    }

    public final String c()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<html>");
        stringbuilder.append("<body style='padding: 0px 0px 20px 0px'>");
        Iterator iterator = a.iterator();
        int k = 0;
        while (iterator.hasNext()) 
        {
            Object obj1 = (JSONObject)iterator.next();
            if (k > 0)
            {
                stringbuilder.append("<hr style='border-top: 1px solid #c8c8c8; border-bottom: 0px; margin: 40px 10px 0px 10px;' />");
            }
            StringBuilder stringbuilder1 = new StringBuilder();
            int l = a(((JSONObject) (obj1)));
            Object obj = b(((JSONObject) (obj1)));
            stringbuilder1.append("<div style='padding: 20px 10px 10px;'><strong>");
            if (k == 0)
            {
                stringbuilder1.append("Newest version:");
            } else
            {
                int i1 = c.getCurrentVersionCode();
                StringBuilder stringbuilder2 = (new StringBuilder("Version ")).append(((String) (obj))).append(" (").append(l).append("): ");
                if (l == i1)
                {
                    obj = "[INSTALLED]";
                } else
                {
                    obj = "";
                }
                stringbuilder1.append(stringbuilder2.append(((String) (obj))).toString());
            }
            stringbuilder1.append("</strong></div>");
            stringbuilder.append(stringbuilder1.toString());
            obj = new StringBuilder();
            obj1 = a(((JSONObject) (obj1)), "notes", "");
            ((StringBuilder) (obj)).append("<div style='padding: 0px 10px;'>");
            if (((String) (obj1)).trim().length() == 0)
            {
                ((StringBuilder) (obj)).append("<em>No information.</em>");
            } else
            {
                ((StringBuilder) (obj)).append(((String) (obj1)));
            }
            ((StringBuilder) (obj)).append("</div>");
            stringbuilder.append(((StringBuilder) (obj)).toString());
            k++;
        }
        stringbuilder.append("</body>");
        stringbuilder.append("</html>");
        return stringbuilder.toString();
    }
}
