// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a
    implements android.view.tener
{

    final MainActivity a;

    public void onClick(View view)
    {
        long l = System.currentTimeMillis();
        if (l - MainActivity.c(a) > MainActivity.x())
        {
            MainActivity.a(a, 1);
        } else
        {
            MainActivity.d(a);
        }
        MainActivity.a(a, l);
        if (MainActivity.e(a) >= MainActivity.y())
        {
            MainActivity.a(a, 0);
            Globals.a(String.format(Locale.getDefault(), "Beauty Circle Version: (%s)", new Object[] {
                a.getString(m.BC_BUILD_NUMBER)
            }), 1);
        }
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
