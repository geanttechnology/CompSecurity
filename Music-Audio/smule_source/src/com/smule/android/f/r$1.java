// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.smule.android.f:
//            r, s

final class f
    implements Runnable
{

    final Context a;
    final String b;
    final s c;
    final int d;
    final int e;
    final int f;

    public void run()
    {
        if (r.a != null)
        {
            r.a.cancel();
        }
        Context context = a.getApplicationContext();
        String s1 = b;
        int i;
        if (c == s.b)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        r.a = Toast.makeText(context, s1, i);
        if (d != 0)
        {
            r.a.setGravity(d, e, f);
        }
        r.a.show();
    }

    (Context context, String s1, s s2, int i, int j, int k)
    {
        a = context;
        b = s1;
        c = s2;
        d = i;
        e = j;
        f = k;
        super();
    }
}
