// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.widget.Toast;
import com.jirbo.adcolony.s;
import com.jirbo.adcolony.u;

// Referenced classes of package com.smule.pianoandroid.ads:
//            g

class a
    implements u
{

    final Activity a;
    final g b;

    public void a(s s)
    {
        if (g.b(b) != null)
        {
            g.b(b).run();
        }
    }

    public void b(s s)
    {
        Toast.makeText(a.getApplicationContext(), 0x7f0c001f, 0).show();
    }

    (g g1, Activity activity)
    {
        b = g1;
        a = activity;
        super();
    }
}
