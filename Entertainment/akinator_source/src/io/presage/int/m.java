// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.Presage;
import io.presage.services.d;
import io.presage.services.e;
import io.presage.utils.do.do.b;
import java.util.Map;

// Referenced classes of package io.presage.int:
//            b, g

public final class m extends io.presage.int.b
    implements g
{

    android.content.SharedPreferences.Editor a;
    private Map b;

    public m(String s)
    {
        super(s);
        a = Presage.getInstance().getContext().getSharedPreferences("presage", 0).edit();
    }

    private void a(String s)
    {
        if (!b.containsKey(s)) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Map map;
        map = (Map)b.get(s);
        obj1 = null;
        obj = obj1;
        if (!map.containsKey("type")) goto _L4; else goto _L3
_L3:
        if (!map.get("type").equals("once")) goto _L6; else goto _L5
_L5:
        obj = e.a();
_L4:
        Presage.getInstance().getService().a(s, ((e) (obj)));
        obj = new StringBuilder("timing-type-");
        ((StringBuilder) (obj)).append(s);
        if (map.get("type") != null)
        {
            a.putString(((StringBuilder) (obj)).toString(), (String)map.get("type"));
        }
        obj = new StringBuilder("timing-value-");
        ((StringBuilder) (obj)).append(s);
        if (map.get("value") != null)
        {
            a.putLong(((StringBuilder) (obj)).toString(), Math.round(((Double)map.get("value")).doubleValue()));
        }
_L2:
        return;
_L6:
        if (map.get("type").equals("each"))
        {
            if (map.containsKey("value"))
            {
                obj = e.a(Math.round(((Double)map.get("value")).doubleValue())).e();
            } else
            {
                obj = e.b().e();
            }
        } else
        {
            obj = obj1;
            if (map.get("type").equals("eachOrGreater"))
            {
                obj = obj1;
                if (map.containsKey("value"))
                {
                    obj = e.b(Math.round(((Double)map.get("value")).doubleValue())).e();
                }
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public final void a(b b1)
    {
        b = (Map)a().get(c());
        a("check_update");
        a("profile");
        a("config");
        a("search");
        a.commit();
    }
}
