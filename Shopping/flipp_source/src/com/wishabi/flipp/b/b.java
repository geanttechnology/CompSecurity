// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.graphics.Point;
import android.graphics.RectF;
import java.util.HashMap;
import java.util.TimerTask;

// Referenced classes of package com.wishabi.flipp.b:
//            a

final class b extends TimerTask
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public final void run()
    {
        if (com.wishabi.flipp.b.a.a(a) != 0L && System.currentTimeMillis() - com.wishabi.flipp.b.a.a(a) > 500L)
        {
            a a1 = a;
            com.wishabi.flipp.content.Flyer.Model model = com.wishabi.flipp.b.a.b(a);
            RectF rectf = com.wishabi.flipp.b.a.c(a);
            float f = com.wishabi.flipp.b.a.d(a);
            HashMap hashmap = new HashMap();
            hashmap.put("flyer_id", String.valueOf(model.a));
            hashmap.put("analytics_payload", model.o);
            hashmap.put("flyer_run_id", String.valueOf(model.b));
            hashmap.put("flyer_type_id", String.valueOf(model.c));
            hashmap.put("merchant_id", String.valueOf(model.d));
            String s;
            if (model.e)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            hashmap.put("flipp_premium_merchant", s);
            hashmap.put("postal_code", model.f);
            hashmap.put("screen_width", Integer.toString(a1.l.x));
            hashmap.put("screen_height", Integer.toString(a1.l.y));
            hashmap.put("left", Float.toString(rectf.left));
            hashmap.put("right", Float.toString(rectf.right));
            hashmap.put("top", Float.toString(rectf.top));
            hashmap.put("bottom", Float.toString(rectf.bottom));
            if (f > 0.0F)
            {
                hashmap.put("resolution", Float.toString(1.0F / f));
            }
            a1.a("view", hashmap);
            com.wishabi.flipp.b.a.e(a);
        }
    }
}
