// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class my
{

    private ArrayList a;

    public my()
    {
    }

    public my(String s, String s1)
    {
        a(s, s1);
    }

    private ArrayList a(Map map)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = (new TreeSet(map.keySet())).iterator(); iterator.hasNext(); arraylist.add((mx)map.get((String)iterator.next()))) { }
        return arraylist;
    }

    private ArrayList a(JSONArray jsonarray, String s)
    {
        HashMap hashmap = new HashMap();
        if (s.equals("Hometiles") || s.equals("Dealcards") || s.equals("StoresOutletItems"))
        {
            mx mx1 = new mx();
            mx1.a(b(jsonarray, s));
            hashmap.put(String.valueOf(mx1.c()), mx1);
        } else
        {
            int i = 0;
            while (i < jsonarray.length()) 
            {
                mx mx2 = new mx();
                JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                mx2.a(Integer.parseInt(jsonobject.optString("index", "0")));
                mx2.a(jsonobject.optString("title", ""));
                mx2.b(jsonobject.optString("type", ""));
                mx2.a(b(jsonobject.getJSONArray("items"), s));
                hashmap.put(String.valueOf(mx2.c()), mx2);
                i++;
            }
        }
        return a(((Map) (hashmap)));
    }

    private void a(String s, String s1)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = null;
        if (!jsonobject.has("sections")) goto _L2; else goto _L1
_L1:
        s = jsonobject.getJSONArray("sections");
_L4:
        a(a(((JSONArray) (s)), s1));
        return;
_L2:
        if (jsonobject.has("cards"))
        {
            s = jsonobject.getJSONArray("cards");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ArrayList b(JSONArray jsonarray, String s)
    {
        s = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            mw mw1 = new mw();
            JSONObject jsonobject = (JSONObject)jsonarray.get(i);
            mw1.d(jsonobject.optString("title"));
            mw1.q(jsonobject.optString("displayTitle"));
            mw1.n(jsonobject.optString("subTitle"));
            mw1.e(jsonobject.optString("targetView"));
            mw1.f(jsonobject.optString("targetURL"));
            mw1.g(jsonobject.optString("trackingTitle"));
            mw1.h(jsonobject.optString("displayTitle"));
            mw1.i(jsonobject.optString("jsForEvaluationString"));
            mw1.j(jsonobject.optString("conditionalVisibilityProperty"));
            mw1.k(jsonobject.optString("conditionalVisibilityPropertyValue"));
            mw1.a(jsonobject.optString("contentDescription"));
            mw1.l(jsonobject.optString("width"));
            mw1.m(jsonobject.optString("height"));
            mw1.c(jsonobject.optString("x"));
            mw1.b(jsonobject.optString("image"));
            if (mw1.c().isEmpty())
            {
                mw1.b(jsonobject.optString("icon"));
            }
            mw1.p(jsonobject.optString("selectedImage"));
            mw1.o(jsonobject.optString("key"));
            s.add(mw1);
        }

        return s;
    }

    public ArrayList a()
    {
        return a;
    }

    public void a(ArrayList arraylist)
    {
        a = arraylist;
    }
}
