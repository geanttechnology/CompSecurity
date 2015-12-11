// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.j;
import com.a.a.l;
import com.a.a.o;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;

// Referenced classes of package com.a.a.a:
//            j, e

public class h extends com.a.a.a.j
{

    public h(String s, com.a.a.o.b b, com.a.a.o.a a)
    {
        super(0, s, null, b, a);
    }

    protected o parseNetworkResponse(j j1)
    {
        try
        {
            j1 = o.a(JSONArrayInstrumentation.init(new String(j1.data, e.a(j1.headers, "utf-8"))), e.a(j1));
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
