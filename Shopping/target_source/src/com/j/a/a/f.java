// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a;

import com.j.a.g.j;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a:
//            d

class f
    implements j
{

    final d a;

    f(d d1)
    {
        a = d1;
        super();
    }

    public void a(JSONArray jsonarray, Exception exception)
    {
        if (exception == null) goto _L2; else goto _L1
_L1:
        w.b("Reading Events from Disk", exception);
_L4:
        return;
_L2:
        if (jsonarray == null || jsonarray.length() <= 0) goto _L4; else goto _L3
_L3:
        int i;
        if (d.a(a) == null)
        {
            d.a(a, new ArrayList());
        }
        w.a((new StringBuilder()).append("Got TLEvents From Disk: ").append(jsonarray.length()).toString());
        i = 0;
_L10:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        try
        {
            exception = ((Exception) (jsonarray.opt(i)));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            w.b("Adding TLEvent from disk", exception);
            break MISSING_BLOCK_LABEL_149;
        }
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (!(exception instanceof JSONObject)) goto _L6; else goto _L5
_L5:
        exception = (JSONObject)exception;
_L8:
        d.a(a).add(exception);
        break MISSING_BLOCK_LABEL_149;
_L6:
        exception = JSONObjectInstrumentation.init((String)exception);
        if (true) goto _L8; else goto _L7
_L7:
        d.a(a, null);
        return;
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }
}
