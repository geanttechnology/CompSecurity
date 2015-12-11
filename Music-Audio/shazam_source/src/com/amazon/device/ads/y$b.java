// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            y, cn, b, dq

static final class e
{

    final JSONObject a = new JSONObject();
    b b[];
    Map c;
     d;
    private final cn e;

    private void a(String s, Object obj)
    {
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        a.put(s, obj);
        return;
        JSONException jsonexception;
        jsonexception;
        e.b("Could not add parameter to JSON %s: %s", new Object[] {
            s, obj
        });
        return;
    }

    final void a()
    {
        b ab[] = b;
        int j = ab.length;
        for (int i = 0; i < j; i++)
        {
            b b1 = ab[i];
            a(b1, b1.a(d));
        }

        if (c != null)
        {
            Iterator iterator = c.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Entry entry = (java.util.Entry)iterator.next();
                if (!dq.b((String)entry.getValue()))
                {
                    a((String)entry.getKey(), entry.getValue());
                }
            } while (true);
        }
    }

    final void a(b b1, Object obj)
    {
        a(b1.b, obj);
    }

    (cn cn1)
    {
        e = cn1;
    }
}
