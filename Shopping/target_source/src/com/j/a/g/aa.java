// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            ac, ad, h

class aa
    implements ac
{

    final ad a;
    final h b;

    aa(h h, ad ad1)
    {
        b = h;
        a = ad1;
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
            a.a((JSONObject)obj, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.a(null, ((Exception) (obj)));
        }
    }
}
