// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.h;

import bo.app.ep;
import com.appboy.Constants;
import com.appboy.enums.Gender;
import java.util.Collection;
import java.util.Iterator;
import myobfuscated.f.e;
import myobfuscated.i.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
    implements e
{

    private static final String a;
    private static String b = "birthday";
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final Gender i;
    private final Integer j;
    private final Collection k;
    private final String l;

    private JSONArray b()
    {
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobject;
        for (Iterator iterator = k.iterator(); iterator.hasNext(); jsonarray.put(jsonobject))
        {
            String s = (String)iterator.next();
            jsonobject = new JSONObject();
            jsonobject.put("name", s);
        }

        return jsonarray;
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (!ep.c(c))
            {
                jsonobject.put("id", c);
            }
            if (!ep.c(d))
            {
                jsonobject.put("first_name", d);
            }
            if (!ep.c(e))
            {
                jsonobject.put("last_name", e);
            }
            if (!ep.c(f))
            {
                jsonobject.put("email", f);
            }
            if (!ep.c(g))
            {
                jsonobject.put("bio", g);
            }
            if (!ep.c(l))
            {
                jsonobject.put(b, l);
            }
            if (!ep.c(h))
            {
                JSONObject jsonobject1 = new JSONObject();
                jsonobject1.put("name", h);
                jsonobject.put("location", jsonobject1);
            }
            if (i != null)
            {
                jsonobject.put("gender", i.forJsonPut());
            }
            jsonobject.put("num_friends", j);
            if (k != null && !k.isEmpty())
            {
                jsonobject.put("likes", b());
            }
        }
        catch (JSONException jsonexception)
        {
            myobfuscated.i.a.c(a, "Caught exception creating facebook user Json.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public Object forJsonPut()
    {
        return a();
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/h/d.getName()
        });
    }
}
