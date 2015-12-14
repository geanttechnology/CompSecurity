// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.app.Activity;
import android.widget.Toast;

// Referenced classes of package com.cyberlink.you.utility:
//            d

final class b
    implements Runnable
{

    final Activity a;
    final String b;

    public void run()
    {
        if (d.h() != null)
        {
            d.h().cancel();
        }
        d.a(Toast.makeText(a, b, 0));
        d.h().show();
    }

    (Activity activity, String s)
    {
        a = activity;
        b = s;
        super();
    }
}
