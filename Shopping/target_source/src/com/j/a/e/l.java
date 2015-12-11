// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.g.m;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            m, az

class l
    implements com.d.a.b.a.a
{

    final az a;

    l(az az)
    {
        a = az;
        super();
    }

    public transient void a(Object aobj[])
    {
        if (aobj[0] == null) goto _L2; else goto _L1
_L1:
        String s;
        JSONObject jsonobject;
        try
        {
            if (!(aobj[0] instanceof JSONObject))
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            w.b("ClientShowExperiment error", ((Exception) (aobj)));
            return;
        }
        jsonobject = (JSONObject)aobj[0];
        aobj = jsonobject.optJSONObject("experiment");
        if (aobj != null) goto _L4; else goto _L3
_L3:
        aobj = "";
_L9:
        if (!jsonobject.has("variation_name")) goto _L6; else goto _L5
_L5:
        s = jsonobject.optString("variation_name");
_L7:
        w.a((new StringBuilder()).append("Client show experiment: ").append(((String) (aobj))).append(". Variation: ").append(s).toString());
        m.a(new com.j.a.e.m(this, jsonobject, s, ((String) (aobj))));
        return;
_L4:
        aobj = ((JSONObject) (aobj)).optString("name");
        continue; /* Loop/switch isn't completed */
_L6:
        s = jsonobject.optString("variation_id");
          goto _L7
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
