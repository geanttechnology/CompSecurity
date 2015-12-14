// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.app.Activity;
import com.cyberlink.youcammakeup.utility.bd;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            h

class b
    implements Runnable
{

    final Activity a;
    final String b;
    final h c;

    public void run()
    {
        bd.a(a, b, "ymk", "bigbangsharedialog");
    }

    y.bd(h h1, Activity activity, String s)
    {
        c = h1;
        a = activity;
        b = s;
        super();
    }
}
