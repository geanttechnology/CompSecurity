// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import com.j.a.a.d;
import com.j.a.d.e;
import java.lang.reflect.Field;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a.a:
//            i

class f
    implements Runnable
{

    final Object a;
    final int b;
    final String c;
    final i d;

    f(i i, Object obj, int j, String s)
    {
        d = i;
        a = obj;
        b = j;
        c = s;
        super();
    }

    public void run()
    {
        try
        {
            int i = a.getClass().getDeclaredFields()[0].getInt(a);
            if (i != b && c.split("\\.").length < 2)
            {
                e.e().n().a("flurry", c, Integer.valueOf(i), new JSONObject());
            }
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }
}
