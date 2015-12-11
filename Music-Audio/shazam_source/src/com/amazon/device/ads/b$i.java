// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            b, co, cn, bc

static class  extends b
{

    private final cn C;

    private JSONObject b(String s)
    {
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            C.d("Unable to parse the following value into a JSONObject: %s", new Object[] {
                super.b
            });
            return null;
        }
        return s;
    }

    protected final Object a()
    {
        return b(bc.a().a(super.c, null));
    }

    protected final Object a(String s)
    {
        return b(s);
    }

    (String s, String s1)
    {
        super(s, s1);
        new co();
        C = co.a(b.a);
    }
}
