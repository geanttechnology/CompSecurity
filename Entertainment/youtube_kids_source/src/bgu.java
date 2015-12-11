// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public final class bgu
    implements bxr
{

    private final bxr a;
    private final bgs b;

    public bgu(bxr bxr1, SharedPreferences sharedpreferences)
    {
        a = (bxr)b.a(bxr1);
        b = new bgs(sharedpreferences);
    }

    public final void a(bxu bxu1)
    {
        a.a(bxu1);
        if (b.c())
        {
            if (b.a.getBoolean("forceWatchAdTypeEnable", true))
            {
                Object obj = bgt.valueOf(b.a.getString("forceWatchAdType", bgt.a.name()));
                String s = String.valueOf("http://gvabox.com/youtube/debug/");
                obj = String.valueOf(((bgt) (obj)).b);
                if (((String) (obj)).length() != 0)
                {
                    s = s.concat(((String) (obj)));
                } else
                {
                    s = new String(s);
                }
                bxu1.F = (new String[] {
                    s
                });
            } else
            {
                String s1 = b.d();
                if (s1 != null)
                {
                    bxu1.F = (new String[] {
                        s1
                    });
                    return;
                }
            }
        }
    }
}
