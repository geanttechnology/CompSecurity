// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.formats.a;
import com.google.android.gms.ads.internal.formats.e;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            id, fg

public final class fj
    implements fg.a
{

    private final boolean a;

    public fj(boolean flag)
    {
        a = flag;
    }

    private static id a(id id1)
    {
        id id2 = new id();
        for (int i = 0; i < id1.size(); i++)
        {
            id2.put(id1.b(i), ((Future)id1.c(i)).get());
        }

        return id2;
    }

    public final com.google.android.gms.ads.internal.formats.g.a a(fg fg1, JSONObject jsonobject)
    {
        id id1 = new id();
        id id2 = new id();
        ha ha = fg1.a(jsonobject);
        JSONArray jsonarray = jsonobject.getJSONArray("custom_assets");
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject1 = jsonarray.getJSONObject(i);
            String s = jsonobject1.getString("type");
            if ("string".equals(s))
            {
                id2.put(jsonobject1.getString("name"), jsonobject1.getString("string_value"));
            } else
            if ("image".equals(s))
            {
                String s1 = jsonobject1.getString("name");
                boolean flag = a;
                JSONObject jsonobject2 = jsonobject1.getJSONObject("image_value");
                boolean flag1 = jsonobject2.optBoolean("require", true);
                jsonobject1 = jsonobject2;
                if (jsonobject2 == null)
                {
                    jsonobject1 = new JSONObject();
                }
                id1.put(s1, fg1.a(jsonobject1, flag1, flag));
            } else
            {
                b.a(5);
            }
            i++;
        }
        return new e(jsonobject.getString("custom_template_id"), a(id1), id2, (a)ha.get());
    }
}
