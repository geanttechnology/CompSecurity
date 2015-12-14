// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.a:
//            c

public class d
{

    final c a;
    private List b;
    private String c;

    public d(c c1, JSONObject jsonobject)
    {
        a = c1;
        super();
        b = new LinkedList();
        c1 = jsonobject.getJSONArray("lookGUID");
        int i = 0;
_L2:
        if (i >= c1.length())
        {
            break; /* Loop/switch isn't completed */
        }
        b.add(c1.getString(i));
        i++;
        if (true) goto _L2; else goto _L1
        c1;
        c1.printStackTrace();
_L1:
        c = jsonobject.optString("buttonText");
        return;
    }

    public ArrayList a()
    {
        ArrayList arraylist = new ArrayList(b.size());
        arraylist.addAll(b);
        return arraylist;
    }

    public String b()
    {
        return c;
    }
}
