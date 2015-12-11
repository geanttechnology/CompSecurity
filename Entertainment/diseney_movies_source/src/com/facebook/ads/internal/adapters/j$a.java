// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            j

public static class a
{

    Map a;

    void a(String s)
    {
        s = (List)a.get(s);
        if (s != null && !s.isEmpty())
        {
            s = s.iterator();
            while (s.hasNext()) 
            {
                String s1 = (String)s.next();
                (new o()).execute(new String[] {
                    s1
                });
            }
        }
    }

    (JSONArray jsonarray)
    {
        a = new HashMap();
        if (jsonarray != null)
        {
            int i = 0;
            while (i < jsonarray.length()) 
            {
                Object obj = jsonarray.optJSONObject(i);
                String s = ((JSONObject) (obj)).optString("type");
                if (!r.a(s))
                {
                    obj = ((JSONObject) (obj)).optJSONArray("urls");
                    if (obj != null)
                    {
                        ArrayList arraylist = new ArrayList(((JSONArray) (obj)).length());
                        for (int k = 0; k < ((JSONArray) (obj)).length(); k++)
                        {
                            arraylist.add(((JSONArray) (obj)).optString(k));
                        }

                        a.put(s, arraylist);
                    }
                }
                i++;
            }
        }
    }
}
