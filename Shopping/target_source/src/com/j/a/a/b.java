// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a;

import android.util.Log;
import com.j.a.c.d;
import com.j.a.d.e;
import com.j.a.e.a;
import com.j.a.g.h;
import com.j.a.g.m;
import com.j.a.g.w;
import com.j.a.j;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a:
//            h, c, e

public class b
{

    private static Map c;
    private JSONObject a;
    private boolean b;
    private Boolean d;
    private Boolean e;

    public b()
    {
        b = false;
        d = Boolean.valueOf(false);
        e = Boolean.valueOf(false);
    }

    static JSONObject a(b b1, JSONObject jsonobject)
    {
        b1.a = jsonobject;
        return jsonobject;
    }

    static void a(b b1, j j1)
    {
        b1.b(j1);
    }

    private void a(String s, Object obj)
        throws JSONException
    {
        if (a.has("customData"))
        {
            JSONObject jsonobject = a.getJSONObject("customData");
            jsonobject.put(s, obj);
            s = jsonobject;
        } else
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put(s, obj);
            s = jsonobject1;
        }
        if (s.length() > 0)
        {
            a.put("customData", s);
        }
    }

    static boolean a(b b1, boolean flag)
    {
        b1.b = flag;
        return flag;
    }

    private Object b(String s, Object obj)
        throws Exception
    {
        if (s == null || obj == null)
        {
            throw new Exception("No type or value to clean attribute value");
        }
        while (s.equals("String") && (obj instanceof String) || s.equals("Number") && (obj instanceof Number) || s.equals("JSONObject") && (obj instanceof JSONObject)) 
        {
            return obj;
        }
        return null;
    }

    private void b(j j1)
    {
        if (j1 != null)
        {
            j1.a();
        }
        h.a().b(a);
        if (!b)
        {
            b = true;
            (new Timer()).schedule(new com.j.a.a.h(this), Math.round((30D + m.a(10D)) * 1000D));
        }
    }

    public void a()
    {
        h.a().a(new c(this));
    }

    public void a(j j1)
    {
        if (com.j.a.d.e.e().j() && a != null) goto _L2; else goto _L1
_L1:
        if (j1 != null)
        {
            j1.a();
        }
_L8:
        return;
_L2:
        Object obj = a;
        if (obj instanceof JSONObject) goto _L4; else goto _L3
_L3:
        obj = ((JSONObject) (obj)).toString();
_L5:
        obj = JSONObjectInstrumentation.init(((String) (obj)));
        e e1;
        Object obj1;
        e1 = com.j.a.d.e.e();
        obj1 = e1.k();
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject;
        JSONObject jsonobject1;
        if (a.length() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = new JSONObject();
        jsonobject1 = ((com.j.a.c.e) (obj1)).i();
        if (e1.f() != null)
        {
            jsonobject.put("t", e1.f());
        }
        if (((com.j.a.c.e) (obj1)).b() != null)
        {
            jsonobject.put("sid", ((com.j.a.c.e) (obj1)).b());
        }
        if (((com.j.a.c.e) (obj1)).c() != null)
        {
            jsonobject.put("pid", ((com.j.a.c.e) (obj1)).c().getString("_id"));
        }
        jsonobject.put("k", "a4cbf0842807b43a0000");
        jsonobject.put("au", a);
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        boolean flag = jsonobject1.has("_id");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        jsonobject.put("auid", jsonobject1.getString("_id"));
_L6:
        Exception exception;
        try
        {
            if (!jsonobject.equals(JSONObject.NULL) && jsonobject.length() != 0)
            {
                e1.l().c(jsonobject, new com.j.a.a.e(this, j1, ((JSONObject) (obj))));
            }
            a = null;
            h.a().c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            w.b("Copying app user attributes", ((Exception) (obj)));
        }
        break MISSING_BLOCK_LABEL_287;
        exception;
        w.b("Flushing App User Attributes", exception);
        a = ((JSONObject) (obj));
        b(j1);
        return;
        b(j1);
        return;
_L4:
        obj = JSONObjectInstrumentation.toString((JSONObject)obj);
          goto _L5
        obj1;
        w.b("Getting appUser_id", ((Exception) (obj1)));
          goto _L6
        if (obj1 != null) goto _L8; else goto _L7
_L7:
        b(j1);
        return;
    }

    public void a(JSONObject jsonobject)
    {
        Iterator iterator;
        while (!com.j.a.d.e.e().j() || jsonobject == null) 
        {
            return;
        }
        if (a == null)
        {
            a = new JSONObject();
        }
        iterator = jsonobject.keys();
_L2:
        Object obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (String)iterator.next();
        Object obj;
        if (!c.containsKey(obj1))
        {
            break MISSING_BLOCK_LABEL_176;
        }
        obj = b((String)c.get(obj1), jsonobject.get(((String) (obj1))));
        if (obj != null)
        {
            try
            {
                a.put(((String) (obj1)), obj);
            }
            catch (Exception exception)
            {
                w.b("Cleaning AppUser JSON Attribute", exception);
            }
            continue; /* Loop/switch isn't completed */
        }
        Log.w(w.b(), (new StringBuilder()).append("user attribute: ").append(((String) (obj1))).append(", must be of type: ").append((String)c.get(obj1)).toString());
        continue; /* Loop/switch isn't completed */
        if (!((String) (obj1)).equals("customData"))
        {
            break MISSING_BLOCK_LABEL_295;
        }
        if (!a.has("customData"))
        {
            break MISSING_BLOCK_LABEL_276;
        }
        exception = a.getJSONObject(((String) (obj1)));
        obj1 = jsonobject.getJSONObject(((String) (obj1)));
        String s;
        for (Iterator iterator1 = ((JSONObject) (obj1)).keys(); iterator1.hasNext(); exception.put(s, ((JSONObject) (obj1)).get(s)))
        {
            s = (String)iterator1.next();
        }

        a.put("customData", exception);
        continue; /* Loop/switch isn't completed */
        a.put(((String) (obj1)), jsonobject.getJSONObject(((String) (obj1))));
        continue; /* Loop/switch isn't completed */
        a(((String) (obj1)), jsonobject.get(((String) (obj1))));
        if (true) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder = (new StringBuilder()).append("Update App User Attributes: ");
        jsonobject = a;
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        w.a(stringbuilder.append(jsonobject).toString());
        b(null);
        return;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("user_id", "String");
        hashmap.put("email", "String");
        hashmap.put("name", "String");
        hashmap.put("gender", "String");
        hashmap.put("age", "Number");
        hashmap.put("firstName", "String");
        hashmap.put("lastName", "String");
        hashmap.put("avatarUrl", "String");
        c = Collections.unmodifiableMap(hashmap);
    }
}
