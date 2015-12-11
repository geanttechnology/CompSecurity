// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.g.m;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            o, az

class n
    implements com.d.a.b.a.a
{

    final az a;

    n(az az)
    {
        a = az;
        super();
    }

    public transient void a(Object aobj[])
    {
        JSONObject jsonobject;
        StringBuilder stringbuilder;
        jsonobject = (JSONObject)aobj[0];
        stringbuilder = (new StringBuilder()).append("foundTestDevice socket: ");
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        aobj = jsonobject.toString();
_L1:
        w.a(stringbuilder.append(((String) (aobj))).toString());
        m.a(new o(this, jsonobject));
        return;
        try
        {
            aobj = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            w.b("foundTestDevice error", ((Exception) (aobj)));
            return;
        }
          goto _L1
    }
}
