// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.util.Log;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x, y, r

class a
    implements Runnable
{

    final x a;

    public void run()
    {
        if (x.d(a) != null)
        {
            int i = x.a(a).a(x.d(a).b);
            if (x.d(a).a)
            {
                Log.d("LookEffectPanel", (new StringBuilder()).append("[onFinishPromotionQuery] move ").append(x.d(a).b).append(" to first").toString());
                i = 2;
                x.a(a).a(2, x.d(a).b);
            }
            x.a(a, i, true);
            x.a(a, null);
        }
    }

    (x x1)
    {
        a = x1;
        super();
    }
}
