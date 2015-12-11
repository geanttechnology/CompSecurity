// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import com.facebook.b.o;
import com.facebook.b.t;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            GraphRequest, p, s

final class a
    implements a
{

    final a a;
    final GraphRequest b;

    public final void a(p p1)
    {
        Object obj = p1.a;
        JSONArray jsonarray;
        if (obj != null)
        {
            obj = ((JSONObject) (obj)).optJSONObject("__debug__");
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            jsonarray = ((JSONObject) (obj)).optJSONArray("messages");
        } else
        {
            jsonarray = null;
        }
        if (jsonarray != null)
        {
            int i = 0;
            while (i < jsonarray.length()) 
            {
                Object obj1 = jsonarray.optJSONObject(i);
                String s1;
                s s2;
                if (obj1 != null)
                {
                    obj = ((JSONObject) (obj1)).optString("message");
                } else
                {
                    obj = null;
                }
                if (obj1 != null)
                {
                    s1 = ((JSONObject) (obj1)).optString("type");
                } else
                {
                    s1 = null;
                }
                if (obj1 != null)
                {
                    obj1 = ((JSONObject) (obj1)).optString("link");
                } else
                {
                    obj1 = null;
                }
                if (obj == null || s1 == null)
                {
                    continue;
                }
                s2 = s.h;
                if (s1.equals("warning"))
                {
                    s2 = s.g;
                }
                s1 = ((String) (obj));
                if (!t.a(((String) (obj1))))
                {
                    s1 = (new StringBuilder()).append(((String) (obj))).append(" Link: ").append(((String) (obj1))).toString();
                }
                o.a(s2, GraphRequest.a, s1);
                i++;
            }
        }
        if (a != null)
        {
            a.a(p1);
        }
    }

    (GraphRequest graphrequest,  )
    {
        b = graphrequest;
        a = ;
        super();
    }
}
