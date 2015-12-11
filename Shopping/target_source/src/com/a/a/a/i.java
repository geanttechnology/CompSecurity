// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.j;
import com.a.a.l;
import com.a.a.o;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.a.a.a:
//            j, e

public class i extends com.a.a.a.j
{

    public i(int k, String s, JSONObject jsonobject, com.a.a.o.b b, com.a.a.o.a a)
    {
        if (jsonobject == null)
        {
            jsonobject = null;
        } else
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        super(k, s, jsonobject, b, a);
    }

    public i(String s, JSONObject jsonobject, com.a.a.o.b b, com.a.a.o.a a)
    {
        int k;
        if (jsonobject == null)
        {
            k = 0;
        } else
        {
            k = 1;
        }
        this(k, s, jsonobject, b, a);
    }

    protected o parseNetworkResponse(j j1)
    {
        try
        {
            j1 = o.a(JSONObjectInstrumentation.init(new String(j1.data, e.a(j1.headers, "utf-8"))), e.a(j1));
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            return o.a(new l(j1));
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            return o.a(new l(j1));
        }
        return j1;
    }
}
