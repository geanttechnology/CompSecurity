// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class mt
{

    private static final String a = mt.getSimpleName();
    private String b;
    private ArrayList c;
    private ArrayList d;
    private int e;
    private String f;
    private String g;

    public mt()
    {
    }

    public static mt a(String s)
    {
        mt mt1 = new mt();
        s = new JSONObject(s);
        mt1.b = s.optString("title", "");
        JSONArray jsonarray = s.optJSONArray("envTitles");
        mt1.c = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            mt1.c.add(jsonarray.optString(i, ""));
        }

        jsonarray = s.optJSONArray("envTitles");
        mt1.d = new ArrayList();
        for (int j = 0; j < jsonarray.length(); j++)
        {
            mt1.d.add(Integer.valueOf(jsonarray.optInt(j)));
        }

        mt1.e = s.optInt("selectedEnv", 0);
        s = s.optJSONObject("customEnv");
        if (s != null)
        {
            mt1.f = s.optString("url", "");
            mt1.g = s.optString("apiKey", "");
        }
        return mt1;
    }

    public String a()
    {
        return b;
    }

    public ArrayList b()
    {
        return c;
    }

    public ArrayList c()
    {
        return d;
    }

    public int d()
    {
        return e;
    }

}
