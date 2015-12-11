// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.support.v7.gh;
import android.support.v7.hh;
import com.abtnprojects.ambatana.ui.widgets.b;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            c

class a
    implements Runnable
{

    final c a;

    public void run()
    {
        if (!a.isFinishing())
        {
            hh hh1 = new hh(new gh(), ParseUser.getCurrentUser());
            c.a(a, new b(a, hh1));
            try
            {
                c.a(a).a(a);
                a.A();
            }
            catch (android.view.owManager.BadTokenException badtokenexception) { }
            c.a(a, null);
        }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
