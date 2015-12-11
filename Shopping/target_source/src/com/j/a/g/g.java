// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import org.json.JSONArray;

// Referenced classes of package com.j.a.g:
//            ac, j, h

class g
    implements ac
{

    final j a;
    final h b;

    g(h h, j j1)
    {
        b = h;
        a = j1;
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
            a.a((JSONArray)obj, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.a(null, ((Exception) (obj)));
        }
    }
}
