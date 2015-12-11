// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.pianoandroid.e.d;
import com.smule.pianoandroid.e.e;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameStatsActivity

class a
    implements Runnable
{

    final int a;
    final GameStatsActivity b;

    public void run()
    {
        e.a().b(a);
        if (a > 0)
        {
            d.a().c();
        }
    }

    (GameStatsActivity gamestatsactivity, int i)
    {
        b = gamestatsactivity;
        a = i;
        super();
    }
}
