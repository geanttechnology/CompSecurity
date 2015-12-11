// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.json.JSONObject;

public class cei
{

    final chs a;
    final cho b;
    final HttpClient c;
    final HttpClient d;
    final chq e;
    final Map f;

    public cei(chs chs1, cho cho1, HttpClient httpclient, HttpClient httpclient1, chq chq1, Map map)
    {
        a = (chs)b.a(chs1);
        b = (cho)b.a(cho1);
        c = (HttpClient)b.a(httpclient);
        d = (HttpClient)b.a(httpclient1);
        f = (Map)b.a(map);
        e = (chq)b.a(chq1);
    }

    public cfa a(cen cen1)
    {
        boolean flag1 = true;
        HashMap hashmap = new HashMap(f);
        if (cen1.a())
        {
            hashmap.put("method", cen1.a.toString());
            if (cen1.b())
            {
                hashmap.put("params", cez.a(cen1.b).toString());
            }
        }
        if (cen1.d)
        {
            hashmap.put("ui", "");
        }
        HashMap hashmap1;
        boolean flag;
        if (cen1.e != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            hashmap.put("pairing_type", cen1.e.toString());
        }
        hashmap1 = new HashMap();
        if (cen1.c != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            hashmap1.put("X-YouTube-LoungeId-Token", cen1.c.toString());
        }
        return new cep(a.a, b, hashmap, hashmap1, c, d, e);
    }
}
