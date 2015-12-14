// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class uv
{

    private String a;
    private String b;
    private EOnlineResType c;

    public uv()
    {
    }

    public static List a(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            Object obj = jsonarray.getJSONObject(i);
            String s = ((JSONObject) (obj)).getString("name");
            String s1 = ((JSONObject) (obj)).getString("resType");
            obj = ((JSONObject) (obj)).getString("iconUrl");
            if (s == null || s1 == null || obj == null)
            {
                continue;
            }
            uv uv1 = new uv();
            uv1.a(s);
            uv1.b(((String) (obj)));
            if (s1.compareTo("PIP_SCENE") == 0)
            {
                uv1.a(EOnlineResType.PIP_SCENE);
            }
            arraylist.add(uv1);
        }

        return arraylist;
    }

    public String a()
    {
        return a;
    }

    public void a(EOnlineResType eonlinerestype)
    {
        c = eonlinerestype;
    }

    public void a(String s)
    {
        a = s;
    }

    public EOnlineResType b()
    {
        return c;
    }

    public void b(String s)
    {
        b = s;
    }

    public String c()
    {
        return b;
    }
}
