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
//            b

public final class l extends io.presage.int.b
{

    public l(String s)
    {
        super(s);
    }

    public final void a(b b1)
    {
        Object obj = (Map)a().get(c());
        b1 = (Double)((Map) (obj)).get("others");
        Double double1 = (Double)((Map) (obj)).get("interstitial");
        obj = (Double)((Map) (obj)).get("postitial");
        android.content.SharedPreferences.Editor editor = Presage.getInstance().getContext().getSharedPreferences("presage", 0).edit();
        int i;
        if (double1 != null)
        {
            i = (int)Math.round(double1.doubleValue());
            Presage.getInstance().getWS().a(i);
            editor.putInt("timeout_ads_inter", i);
            i = 1;
        } else
        {
            i = 0;
        }
        if (obj != null)
        {
            i = (int)Math.round(((Double) (obj)).doubleValue());
            Presage.getInstance().getWS().b(i);
            editor.putInt("timeout_ads_post", i);
            i = 1;
        }
        if (b1 != null)
        {
            i = (int)Math.round(b1.doubleValue());
            Presage.getInstance().getWS().c(i);
            editor.putInt("timeout_requests", i);
            i = 1;
        }
        if (i != 0)
        {
            editor.commit();
        }
    }
}
