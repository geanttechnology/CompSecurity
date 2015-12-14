// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqn
{

    public static String a(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (s.equals(""))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (jsonobject.has(s))
        {
            return jsonobject.getString(s);
        }
        return "";
        jsonobject;
        return "";
    }

    public static JSONObject a(JSONArray jsonarray, int i)
    {
        try
        {
            jsonarray = jsonarray.getJSONObject(i);
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            jsonarray.printStackTrace();
            return null;
        }
        return jsonarray;
    }

    public static void a(String s, int i, String s1)
    {
        String s2 = s;
        if (s == null)
        {
            s2 = "JSON_LOG";
        }
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        s1 = Thread.currentThread().getStackTrace()[3].getClassName();
        s1 = s1.substring(s1.lastIndexOf(".") + 1);
        int j = Thread.currentThread().getStackTrace()[3].getLineNumber();
        Log.println(i, s2, (new StringBuilder()).append("(").append(s1).append(":").append(j).append(") : ").append(s).toString());
    }

    public static JSONArray b(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (s.equals(""))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (jsonobject.has(s))
        {
            return jsonobject.getJSONArray(s);
        }
        jsonobject = new JSONArray();
        return jsonobject;
        jsonobject;
        return new JSONArray();
    }

    public static JSONObject c(JSONObject jsonobject, String s)
    {
        JSONObject jsonobject1;
        Object obj;
        obj = null;
        jsonobject1 = obj;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        jsonobject1 = obj;
        if (!s.equals(""))
        {
            jsonobject1 = obj;
            try
            {
                if (jsonobject.has(s))
                {
                    jsonobject1 = jsonobject.getJSONObject(s);
                }
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return null;
            }
        }
        return jsonobject1;
    }

    public static boolean d(JSONObject jsonobject, String s)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = false;
        flag = flag2;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        if (!jsonobject.has(s)) goto _L2; else goto _L3
_L3:
        jsonobject = jsonobject.getString(s);
        if (jsonobject.equalsIgnoreCase("true") || jsonobject.equalsIgnoreCase("yes") || jsonobject.equalsIgnoreCase("on")) goto _L5; else goto _L4
_L4:
        flag = jsonobject.equalsIgnoreCase("1");
        if (!flag) goto _L6; else goto _L5
_L5:
        flag = true;
_L11:
        if (jsonobject.equalsIgnoreCase("false") || jsonobject.equalsIgnoreCase("no") || jsonobject.equalsIgnoreCase("off")) goto _L8; else goto _L7
_L7:
        flag1 = jsonobject.equalsIgnoreCase("0");
        if (!flag1) goto _L2; else goto _L8
_L8:
        flag = false;
_L2:
        return flag;
        jsonobject;
        flag = flag1;
_L9:
        jsonobject.printStackTrace();
        return flag;
        jsonobject;
        if (true) goto _L9; else goto _L6
_L6:
        flag = false;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static int e(JSONObject jsonobject, String s)
    {
        int i;
        boolean flag;
        flag = false;
        i = ((flag) ? 1 : 0);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        i = ((flag) ? 1 : 0);
        if (!s.equals(""))
        {
            i = ((flag) ? 1 : 0);
            try
            {
                if (jsonobject.has(s))
                {
                    i = jsonobject.getInt(s);
                }
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return 0;
            }
        }
        return i;
    }

    public static float f(JSONObject jsonobject, String s)
    {
        float f2 = 0.0F;
        float f1 = f2;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        f1 = f2;
        double d1;
        try
        {
            if (s.equals(""))
            {
                break MISSING_BLOCK_LABEL_46;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return 0.0F;
        }
        f1 = f2;
        if (!jsonobject.has(s))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        d1 = jsonobject.getDouble(s);
        f1 = (float)d1;
        return f1;
    }
}
