// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import com.d.a.d;
import com.smule.pianoandroid.utils.n;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            b

class a
    implements Runnable
{

    final Activity a;
    final b b;

    public void run()
    {
        (new d(a, 180, 0x7f020198, 500L)).a(0.1F, 0.25F).b(45F).a(b.e, 5, 90, 2000);
        com.smule.pianoandroid.magicpiano.b.b(b, n.a(com.smule.pianoandroid.magicpiano.b.b(b), com.smule.pianoandroid.magicpiano.b.c(b)[0], 0.3F, true));
    }

    (b b1, Activity activity)
    {
        b = b1;
        a = activity;
        super();
    }
}
