// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            v

public class ai
{

    public ai()
    {
    }

    public static Object a(byte abyte0[], String s)
    {
        Object obj = null;
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        abyte0 = obj;
_L4:
        return abyte0;
_L2:
        s = b(abyte0, s);
        abyte0 = s;
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = s.trim();
        if (!s.startsWith("{"))
        {
            abyte0 = s;
            if (!s.startsWith("["))
            {
                break; /* Loop/switch isn't completed */
            }
        }
        Object obj1 = (new JSONTokener(s)).nextValue();
        abyte0 = s;
        s = ((String) (obj1));
_L5:
        if (s != null)
        {
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = null;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public static String a(JSONObject jsonobject, String s)
    {
        for (jsonobject = ((JSONObject) (jsonobject.opt(s))); jsonobject == null || JSONObject.NULL.equals(jsonobject);)
        {
            return null;
        }

        return jsonobject.toString();
    }

    public static Boolean b(JSONObject jsonobject, String s)
    {
        for (jsonobject = ((JSONObject) (jsonobject.opt(s))); jsonobject == null || JSONObject.NULL.equals(jsonobject);)
        {
            return null;
        }

        if (jsonobject instanceof Boolean)
        {
            jsonobject = (Boolean)jsonobject;
        } else
        {
            jsonobject = null;
        }
        return jsonobject;
    }

    public static String b(byte abyte0[], String s)
    {
        if (abyte0 == null)
        {
            return null;
        }
        try
        {
            abyte0 = new String(abyte0, s);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    public static Number c(JSONObject jsonobject, String s)
    {
        for (jsonobject = ((JSONObject) (jsonobject.opt(s))); jsonobject == null || JSONObject.NULL.equals(jsonobject);)
        {
            return null;
        }

        try
        {
            jsonobject = NumberFormat.getInstance(v.b).parse(jsonobject.toString().trim());
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return jsonobject;
    }

    public static JSONArray d(JSONObject jsonobject, String s)
    {
        for (jsonobject = ((JSONObject) (jsonobject.opt(s))); jsonobject == null || JSONObject.NULL.equals(jsonobject);)
        {
            return null;
        }

        if (jsonobject instanceof JSONArray)
        {
            jsonobject = (JSONArray)jsonobject;
        } else
        {
            jsonobject = null;
        }
        return jsonobject;
    }

    public static JSONObject e(JSONObject jsonobject, String s)
    {
        for (jsonobject = ((JSONObject) (jsonobject.opt(s))); jsonobject == null || JSONObject.NULL.equals(jsonobject);)
        {
            return null;
        }

        if (jsonobject instanceof JSONObject)
        {
            jsonobject = (JSONObject)jsonobject;
        } else
        {
            jsonobject = null;
        }
        return jsonobject;
    }
}
