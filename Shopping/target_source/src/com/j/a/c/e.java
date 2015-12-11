// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.c;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.c:
//            d

public class e
{

    private String a;
    private String b;
    private String c;
    private d d;
    private d e;
    private d f;
    private JSONObject g;
    private JSONArray h;
    private JSONArray i;
    private JSONArray j;
    private JSONObject k;
    private JSONArray l;
    private JSONObject m;
    private HashMap n;

    public e(JSONObject jsonobject)
        throws JSONException
    {
        n = new HashMap();
        if (jsonobject != null)
        {
            Object obj = jsonobject.opt("projectInfo");
            if (obj != null && (obj instanceof JSONObject))
            {
                d = new d((JSONObject)obj);
                obj = d.opt("name");
                if (obj != null && (obj instanceof String))
                {
                    b = (String)obj;
                }
                obj = d.opt("deviceToken");
                if (obj != null && (obj instanceof String))
                {
                    c = (String)obj;
                }
            }
            obj = jsonobject.opt("sid");
            if (obj != null && (obj instanceof String))
            {
                a = (String)obj;
            }
            obj = jsonobject.opt("as");
            if (obj != null && (obj instanceof JSONObject))
            {
                e = new d((JSONObject)obj);
            }
            obj = jsonobject.opt("codeExp");
            if (obj != null && (obj instanceof JSONObject))
            {
                f = new d((JSONObject)obj);
            }
            obj = jsonobject.opt("experiments");
            if (obj != null && (obj instanceof JSONArray))
            {
                h = (JSONArray)obj;
            }
            obj = jsonobject.opt("exp");
            if (obj != null && (obj instanceof JSONArray))
            {
                i = (JSONArray)obj;
            }
            obj = jsonobject.opt("var");
            if (obj != null && (obj instanceof JSONArray))
            {
                j = (JSONArray)obj;
            }
            obj = jsonobject.opt("au");
            if (obj != null && (obj instanceof JSONObject))
            {
                k = (JSONObject)obj;
            }
            obj = jsonobject.opt("views");
            if (obj != null && (obj instanceof JSONArray))
            {
                l = (JSONArray)obj;
            }
            obj = jsonobject.opt("images");
            if (obj != null && (obj instanceof JSONObject))
            {
                g = (JSONObject)obj;
            }
            jsonobject = ((JSONObject) (jsonobject.opt("activities")));
            if (jsonobject != null && (jsonobject instanceof JSONObject))
            {
                m = (JSONObject)jsonobject;
                jsonobject = m.keys();
                do
                {
                    if (!jsonobject.hasNext())
                    {
                        break;
                    }
                    String s = (String)jsonobject.next();
                    if (!n.containsKey(s) && (m.get(s) instanceof JSONObject))
                    {
                        String s1 = ((JSONObject)m.get(s)).optString("_id");
                        n.put(s1, s);
                    }
                } while (true);
            }
        }
    }

    public HashMap a()
    {
        return n;
    }

    public JSONObject a(JSONObject jsonobject, String s)
    {
        if (!s.equals("baseline")) goto _L2; else goto _L1
_L1:
        jsonobject = jsonobject.optJSONObject("baseline");
_L4:
        return jsonobject;
_L2:
        JSONArray jsonarray;
        int i1;
        jsonarray = jsonobject.optJSONArray("variations");
        i1 = 0;
        jsonobject = null;
_L6:
        if (i1 >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject1;
        boolean flag;
        jsonobject1 = jsonarray.getJSONObject(i1);
        flag = jsonobject1.optString("name").equals(s);
        jsonobject = jsonobject1;
        if (flag) goto _L4; else goto _L5
_L5:
        i1++;
        jsonobject = jsonobject1;
          goto _L6
        jsonobject;
        return null;
    }

    public void a(String s)
    {
        a = s;
    }

    public void a(JSONArray jsonarray)
    {
        l = jsonarray;
    }

    public void a(JSONObject jsonobject)
    {
        k = jsonobject;
    }

    public String[] a(int i1)
    {
        JSONArray jsonarray;
        String as[];
        try
        {
            jsonarray = h.getJSONObject(i1).optJSONArray("variations");
            as = new String[jsonarray.length() + 1];
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        i1 = 0;
        if (i1 >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        as[i1] = jsonarray.getJSONObject(i1).optString("name");
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_26;
_L1:
        as[jsonarray.length()] = "baseline";
        return as;
    }

    public String[] a(boolean flag)
    {
        String as[];
        int i1;
        as = new String[h.length()];
        i1 = 0;
_L2:
        Object obj = as;
        if (i1 >= h.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = h.getJSONObject(i1);
        as[i1] = ((JSONObject) (obj)).optString("name");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        as[i1] = (new StringBuilder()).append(as[i1]).append(" (").append(((JSONObject) (obj)).optString("status")).append(")").toString();
        i1++;
        if (true) goto _L2; else goto _L1
        obj;
        obj = null;
_L1:
        return ((String []) (obj));
    }

    public String b()
    {
        return a;
    }

    public JSONObject b(String s)
    {
        int i1 = 0;
        JSONObject jsonobject = null;
        do
        {
label0:
            {
label1:
                {
                    boolean flag;
                    try
                    {
                        if (i1 >= h.length())
                        {
                            break label1;
                        }
                        jsonobject = h.getJSONObject(i1);
                        flag = jsonobject.optString("name").equals(s);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return null;
                    }
                    if (!flag)
                    {
                        break label0;
                    }
                }
                return jsonobject;
            }
            i1++;
        } while (true);
    }

    public d c()
    {
        return d;
    }

    public d d()
    {
        return e;
    }

    public d e()
    {
        return f;
    }

    public JSONArray f()
    {
        return h;
    }

    public JSONArray g()
    {
        return i;
    }

    public JSONArray h()
    {
        return j;
    }

    public JSONObject i()
    {
        return k;
    }

    public JSONArray j()
    {
        return l;
    }

    public JSONObject k()
    {
        return g;
    }

    public String l()
    {
        return c;
    }
}
