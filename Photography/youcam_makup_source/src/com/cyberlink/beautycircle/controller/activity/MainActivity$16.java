// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a
    implements android.view.ener
{

    final MainActivity a;

    public void onClick(View view)
    {
        Globals.a();
        b.a(new aq("explore", ""));
        if (MainActivity.w().equals("ycn"))
        {
            c.a(a, null, Long.valueOf(-1L), "NAILS", false, false, true);
            a.finish();
            return;
        } else
        {
            MainActivity.a(a, true);
            com.cyberlink.beautycircle.controller.activity.MainActivity.b(a, false);
            MainActivity.a(a, true, false);
            return;
        }
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
