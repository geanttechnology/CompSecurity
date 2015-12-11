// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.Presage;
import io.presage.utils.do.a;
import io.presage.utils.do.do.b;
import java.util.Map;

// Referenced classes of package io.presage.int:
//            b, g

public final class h extends io.presage.int.b
    implements g
{

    private a a;

    public h(String s)
    {
        super(s);
        a = Presage.getInstance().getWS();
    }

    public final void a(b b1)
    {
        b1 = (Boolean)a().get(c());
        boolean flag;
        if (b1 != null)
        {
            flag = b1.booleanValue();
        } else
        {
            flag = false;
        }
        b1 = Presage.getInstance().getContext().getSharedPreferences("presage", 0).edit();
        b1.putBoolean("kill_sdk", flag);
        b1.commit();
        a.a();
    }
}
