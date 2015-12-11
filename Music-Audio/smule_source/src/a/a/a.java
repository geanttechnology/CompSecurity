// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            v, ew, cj, en

public final class a
{

    JSONObject a;

    private a(v v1, List list)
    {
        a = new JSONObject();
        list.size();
        JSONArray jsonarray = new JSONArray();
        JSONArray jsonarray1 = new JSONArray();
        jsonarray1.put(v1.a());
        jsonarray1.put(v1.b());
        jsonarray1.put(v1.c());
        jsonarray1.put("5.0.6");
        jsonarray1.put(v1.e());
        jsonarray.put(jsonarray1);
        jsonarray1 = new JSONArray();
        jsonarray1.put(ew.a.a());
        jsonarray1.put(v1.f());
        jsonarray1.put(v1.j());
        jsonarray1.put(v1.i());
        jsonarray1.put(v1.k());
        jsonarray1.put(v1.g());
        jsonarray1.put(v1.h());
        jsonarray.put(jsonarray1);
        v1 = new JSONArray();
        for (list = list.iterator(); list.hasNext(); v1.put(((cj)list.next()).d())) { }
        jsonarray.put(v1);
        a.put("d", jsonarray);
    }

    public static a a(v v1, List list)
    {
        try
        {
            v1 = new a(v1, list);
        }
        // Misplaced declaration of an exception variable
        catch (v v1)
        {
            en.b((new StringBuilder("Unable to generate APM request's JSON: ")).append(v1).toString());
            return null;
        }
        return v1;
    }
}
