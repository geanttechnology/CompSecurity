// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.do.e;
import io.presage.utils.do.a;
import java.util.HashMap;

// Referenced classes of package io.presage.actions:
//            a

public final class i extends io.presage.actions.a
{

    public i(String s, String s1, e e1)
    {
        super(s, s1, e1);
    }

    public final String k()
    {
        String s = b().b("type");
        Object obj = b().a("value");
        Object obj1 = h().getSharedPreferences("presage", 0).edit();
        ((android.content.SharedPreferences.Editor) (obj1)).putString(s, obj.toString());
        ((android.content.SharedPreferences.Editor) (obj1)).commit();
        obj1 = new HashMap();
        ((HashMap) (obj1)).put(s, obj.toString());
        i().a("presage", obj1);
        io.presage.utils.e.b(new String[] {
            "ManagePresage", s, (String)obj
        });
        n();
        return null;
    }
}
