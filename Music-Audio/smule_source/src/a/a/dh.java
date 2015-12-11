// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            dp, di, ay, aw, 
//            cl, en

public final class dh
    implements dp
{

    private Map a;

    public dh()
    {
        a = new HashMap();
    }

    private JSONArray a()
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            JSONObject jsonobject = new JSONObject((Map)((java.util.Map.Entry) (obj)).getKey());
            obj = (di)((java.util.Map.Entry) (obj)).getValue();
            try
            {
                jsonarray.put((new JSONObject()).put("appLoads", jsonobject).put("count", ((di) (obj)).b).put("current", ((di) (obj)).a));
            }
            catch (JSONException jsonexception) { }
        }

        return jsonarray;
    }

    public final dp a(ay ay1)
    {
        Iterator iterator = ay1.c().iterator();
        Object obj = null;
        while (iterator.hasNext()) 
        {
            ay1 = (aw)iterator.next();
            if (!(ay1 instanceof cl))
            {
                ay1 = null;
            } else
            {
                JSONObject jsonobject = (JSONObject)ay1.a();
                if (jsonobject == null)
                {
                    ay1 = null;
                } else
                {
                    ay1 = new HashMap(jsonobject.length());
                    Iterator iterator1 = jsonobject.keys();
                    while (iterator1.hasNext()) 
                    {
                        String s = (String)iterator1.next();
                        ay1.put(s, jsonobject.opt(s));
                    }
                }
            }
            if (ay1 != null)
            {
                di di1 = (di)a.get(ay1);
                obj = di1;
                if (di1 == null)
                {
                    obj = new di();
                    a.put(ay1, obj);
                }
                obj.b = ((di) (obj)).b + 1;
            } else
            {
                ay1 = ((ay) (obj));
            }
            obj = ay1;
        }
        if (obj != null)
        {
            ((di)a.get(obj)).a = true;
        }
        return this;
    }

    public final void a(OutputStream outputstream)
    {
        outputstream.write(a().toString().getBytes("UTF8"));
    }

    public final String toString()
    {
        String s;
        try
        {
            s = a().toString(4);
        }
        catch (JSONException jsonexception)
        {
            en.a();
            return null;
        }
        return s;
    }
}
