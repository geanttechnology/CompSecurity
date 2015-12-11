// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import android.content.Context;
import com.j.a.a.d;
import com.j.a.d.e;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a.a:
//            g, j

public class a extends g
{

    private static a c;
    private HashSet d;

    public a()
    {
        d = new HashSet();
        a("mixpanel", 4, this);
        d = new HashSet(Arrays.asList(new String[] {
            "$android_os", "$android_model", "$android_brand", "$android_os_version", "$android_lib_version", "$android_manufacturer", "$android_app_version", "$token", "$distinct_id"
        }));
    }

    public static a a()
    {
        if (c == null)
        {
            c = new a();
        }
        return c;
    }

    public void a(ArrayList arraylist)
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        jsonobject = new JSONObject();
        jsonobject1 = new JSONObject();
        arraylist = arraylist.iterator();
_L2:
        Object obj;
        if (!arraylist.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (JSONObject)arraylist.next();
        if (((JSONObject) (obj)).has("$set"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("$set");
            Iterator iterator = ((JSONObject) (obj)).keys();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (!d.contains(s))
                {
                    jsonobject.put(s, ((JSONObject) (obj)).get(s));
                }
            } while (true);
            break MISSING_BLOCK_LABEL_195;
        }
        if (((JSONObject) (obj)).has("$add"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("$add");
            String s1;
            for (Iterator iterator1 = ((JSONObject) (obj)).keys(); iterator1.hasNext(); jsonobject.put(s1, ((JSONObject) (obj)).get(s1)))
            {
                s1 = (String)iterator1.next();
            }

        }
        try
        {
            jsonobject1.put("customData", jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            w.b("MPUA", ((Exception) (obj)));
        }
        if (true) goto _L2; else goto _L1
_L1:
        com.j.a.a.a(jsonobject1);
        return;
    }

    public void a(JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        String s;
        String s1;
        jsonobject1 = new JSONObject();
        Iterator iterator;
        try
        {
            if (jsonobject.equals(JSONObject.NULL) || jsonobject.length() == 0 || !jsonobject.has("event"))
            {
                break MISSING_BLOCK_LABEL_234;
            }
            s = jsonobject.optString("event");
            jsonobject = jsonobject.optJSONObject("properties");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            w.b("Json error", jsonobject);
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (!jsonobject.equals(JSONObject.NULL) && jsonobject.length() != 0)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        e.e().n().b("mixpanel", s);
        return;
        iterator = jsonobject.keys();
_L3:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_220;
        }
        s1 = (String)iterator.next();
        if (s1.startsWith("$") || s1.equals("distinct_id") || s1.equals("token") || s1.equals("mp_lib") || s1.equals("time")) goto _L2; else goto _L1
_L1:
        jsonobject1.put(s1, jsonobject.get(s1));
          goto _L3
_L2:
        if (!s1.equals("time") && !s1.equals("$time")) goto _L3; else goto _L4
_L4:
        jsonobject1.put("TLTime", jsonobject.get(s1));
          goto _L3
        e.e().n().a("mixpanel", s, null, jsonobject1);
    }

    public void b()
    {
        if (a(j.a.a()) <= 0)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        Object obj;
        Method method;
        method = Class.forName("com.mixpanel.android.mpmetrics.MixpanelAPI").getMethod("getInstance", new Class[] {
            android/content/Context, java/lang/String
        });
        if (e.e().p() != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        obj = e.e().o();
_L2:
        obj = method.invoke(null, new Object[] {
            obj, "taplytics"
        });
        obj.getClass().getMethod("flush", new Class[0]).invoke(obj, new Object[0]);
        return;
        obj = e.e().p();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        w.b("flush error", exception);
    }

    public void c()
    {
        Iterator iterator = a(j.a.a(), "data").iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            try
            {
                obj = JSONObjectInstrumentation.init(((String) (obj)));
                if (obj != JSONObject.NULL)
                {
                    a(((JSONObject) (obj)));
                }
            }
            catch (Exception exception)
            {
                w.a((new StringBuilder()).append("MPErr: ").append(exception.getMessage()).toString());
            }
        } while (true);
        if (a(j.b.a()) > 0)
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator1 = a(j.b.a(), "data").iterator(); iterator1.hasNext();)
            {
                String s = (String)iterator1.next();
                try
                {
                    arraylist.add(JSONObjectInstrumentation.init(s));
                }
                catch (Exception exception1)
                {
                    w.a((new StringBuilder()).append("MPErr").append(exception1.getMessage()).toString());
                }
            }

            a(arraylist);
        }
        b();
    }
}
