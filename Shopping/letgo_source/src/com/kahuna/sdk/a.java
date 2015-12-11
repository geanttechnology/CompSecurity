// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package com.kahuna.sdk:
//            v

public class a
{

    private List a;
    private String b;
    private List c;

    protected a(List list, String s, List list1)
    {
        a = list;
        b = s;
        c = list1;
    }

    protected List a()
    {
        return a;
    }

    protected String b()
    {
        String s = "";
        if (!v.a(b))
        {
            String s1 = b;
            s = s1;
            if (b.length() > 10000)
            {
                s = s1.substring(0, 10000);
            }
            s = v.b(s);
        }
        return s;
    }

    protected JSONArray c()
    {
        JSONArray jsonarray = new JSONArray();
        if (!v.a(c))
        {
            Iterator iterator = c.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = v.b((String)iterator.next());
                if (s != null)
                {
                    jsonarray.put(s);
                }
            } while (true);
        }
        return jsonarray;
    }
}
