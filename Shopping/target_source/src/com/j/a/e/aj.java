// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.g.m;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            ak, az

class aj
    implements com.d.a.b.a.a
{

    final az a;

    aj(az az)
    {
        a = az;
        super();
    }

    public transient void a(Object aobj[])
    {
        if (aobj[0] == null)
        {
            return;
        }
        JSONObject jsonobject;
        aobj = (JSONObject)aobj[0];
        jsonobject = ((JSONObject) (aobj)).optJSONObject("experiment");
        if (jsonobject != null)
        {
            try
            {
                w.a((new StringBuilder()).append("Client updated experiment: ").append(jsonobject.optString("name")).toString());
                m.a(new ak(this, ((JSONObject) (aobj)), jsonobject));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                w.b("experimentUpdated", ((Exception) (aobj)));
            }
        }
        return;
    }
}
