// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

// Referenced classes of package com.cyberlink.uma.a:
//            i, f, g

class j
{

    private final f a;

    j(f f1)
    {
        a = f1;
    }

    static String a(List list)
    {
        Object obj = new JSONArray();
        for (list = list.iterator(); list.hasNext(); ((JSONArray) (obj)).put(((i)list.next()).a())) { }
        list = ((JSONArray) (obj)).toString();
        try
        {
            obj = URLEncoder.encode(list, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return list;
        }
        return ((String) (obj));
    }

    int a()
    {
        return a.b();
    }

    void a(String s, Map map, int k, double d)
    {
        a.a(s, map, k, d, new g());
    }
}
