// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameStatsActivity

class a
    implements android.app.onListener
{

    final GameStatsActivity a;

    public boolean onNavigationItemSelected(int i, long l)
    {
        GameStatsActivity gamestatsactivity = a;
        boolean flag;
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gamestatsactivity.a(flag);
        aa.a(GameStatsActivity.a, "From menu");
        GameStatsActivity.a(a);
        return true;
    }

    (GameStatsActivity gamestatsactivity)
    {
        a = gamestatsactivity;
        super();
    }
}
