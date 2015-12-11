// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            ac, k, h

class e
    implements ac
{

    final k a;
    final h b;

    e(h h, k k1)
    {
        b = h;
        a = k1;
        super();
    }

    public void a(Object obj, Exception exception)
    {
        if (exception != null)
        {
            a.a(null, exception);
            return;
        }
        if (obj == null)
        {
            a.a(null, null);
            return;
        }
        try
        {
            obj = (JSONObject)obj;
            if (((JSONObject) (obj)).has("sid"))
            {
                ((JSONObject) (obj)).remove("sid");
            }
            obj = new com.j.a.c.e(((JSONObject) (obj)));
            a.a(((com.j.a.c.e) (obj)), null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.a(null, ((Exception) (obj)));
        }
    }
}
