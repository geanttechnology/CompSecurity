// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.signals:
//            d

public class c
{

    private static final String a = com/inmobi/signals/c.getSimpleName();
    private com.inmobi.commons.core.network.c b;
    private boolean c;
    private List d;
    private String e;
    private int f;

    public c(com.inmobi.commons.core.network.c c1)
    {
        c = true;
        f = 0;
        b = c1;
        d = new ArrayList();
        f();
        if (c)
        {
            com.inmobi.commons.core.c.a.a().a(new e("signals", "InvalidCarbGetResponse"));
        }
    }

    private void f()
    {
        int i;
        i = 0;
        if (b.a())
        {
            break MISSING_BLOCK_LABEL_202;
        }
        Object obj;
        obj = new JSONObject(b.b());
        if (!((JSONObject) (obj)).getBoolean("success"))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        obj = ((JSONObject) (obj)).getJSONObject("data");
        e = ((JSONObject) (obj)).getString("req_id");
        obj = ((JSONObject) (obj)).getJSONArray("p_apps");
_L1:
        Object obj1;
        Object obj2;
        if (i >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_182;
        }
        obj2 = ((JSONArray) (obj)).getJSONObject(i);
        obj1 = ((JSONObject) (obj2)).optString("bid", null);
        obj2 = ((JSONObject) (obj2)).optString("inm_id", null);
        if (obj1 == null || obj2 == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if (((String) (obj2)).trim().length() > 0)
        {
            obj1 = new d(((String) (obj1)), ((String) (obj2)));
            d.add(obj1);
        }
        f = i + 1;
        i++;
          goto _L1
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error response for Carb list received. Error code:").append(((JSONObject) (obj)).optInt("errorCode")).toString());
        c = false;
        return;
        JSONException jsonexception;
        jsonexception;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Bad response for Carb list received.", jsonexception);
        return;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error response for Carb list received. Error code:").append(b.c().a()).toString());
        return;
    }

    public boolean a()
    {
        return c;
    }

    public List b()
    {
        return d;
    }

    public String c()
    {
        return e;
    }

    public int d()
    {
        return f;
    }

    public boolean e()
    {
        return f == 0;
    }

}
