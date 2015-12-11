// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.smule.android.c.aa;
import com.smule.magicpiano.MagicPerformanceStats;
import java.sql.SQLException;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            g

class b
    implements Runnable
{

    final String a;
    final MagicPerformanceStats b;
    final g c;

    public void run()
    {
        try
        {
            g.a(c, a, b);
            return;
        }
        catch (SQLException sqlexception)
        {
            aa.b(g.a, "Problem setting score for song.", sqlexception);
            return;
        }
        catch (Exception exception)
        {
            aa.b(g.a, "Problem setting score for song.", exception);
        }
    }

    ts(g g1, String s, MagicPerformanceStats magicperformancestats)
    {
        c = g1;
        a = s;
        b = magicperformancestats;
        super();
    }
}
