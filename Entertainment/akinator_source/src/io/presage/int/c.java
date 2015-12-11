// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import io.presage.Presage;
import io.presage.utils.do.do.b;
import io.presage.utils.e;
import java.util.Map;

// Referenced classes of package io.presage.int:
//            b, g, d

public final class c extends io.presage.int.b
    implements g
{

    public c(String s)
    {
        super(s);
    }

    public final void a(b b1)
    {
        Object obj = (Map)a().get(c());
        if (obj != null && ((Map) (obj)).containsKey("type") && ((Map) (obj)).containsKey("message"))
        {
            b1 = (String)((Map) (obj)).get("type");
            obj = (String)((Map) (obj)).get("message");
            if (b1.equals("crash"))
            {
                Presage.getInstance().runOnUiThread(new d(this, ((String) (obj))));
            } else
            if (b1.equals("error"))
            {
                e.c(new String[] {
                    b1, ":", obj
                });
                return;
            }
        }
    }
}
