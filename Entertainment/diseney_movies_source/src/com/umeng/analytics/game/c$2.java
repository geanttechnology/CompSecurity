// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import com.umeng.analytics.d;
import com.umeng.analytics.f;
import java.util.HashMap;
import u.aly.bj;

// Referenced classes of package com.umeng.analytics.game:
//            c, b

class c extends f
{

    final c a;
    private final String b;
    private final int c;

    public void a()
    {
        Object obj = com.umeng.analytics.game.c.a(a).b(b);
        if (obj != null)
        {
            long l = ((b) (obj)).e();
            if (l <= 0L)
            {
                bj.c("MobclickAgent", "level duration is 0");
                return;
            }
            obj = new HashMap();
            ((HashMap) (obj)).put("level", b);
            ((HashMap) (obj)).put("status", Integer.valueOf(c));
            ((HashMap) (obj)).put("duration", Long.valueOf(l));
            if (com.umeng.analytics.game.c.a(a).b != null)
            {
                ((HashMap) (obj)).put("user_level", com.umeng.analytics.game.c.a(a).b);
            }
            com.umeng.analytics.game.c.b(a).a(com.umeng.analytics.game.c.c(a), "level", ((HashMap) (obj)));
            return;
        } else
        {
            bj.e("MobclickAgent", String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
            return;
        }
    }

    (c c1, String s, int i)
    {
        a = c1;
        b = s;
        c = i;
        super();
    }
}
