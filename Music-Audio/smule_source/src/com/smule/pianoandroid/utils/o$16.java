// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.view.ViewGroup;
import com.smule.android.network.managers.a;
import com.smule.pianoandroid.magicpiano.ap;
import com.smule.pianoandroid.magicpiano.n;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class b
    implements Runnable
{

    final Activity a;
    final n b;

    public void run()
    {
        String s = com.smule.android.network.managers.a.a().a("piandroid.offers", "free_smoola_button_offers", "tapjoy");
        ap.a(a, (ViewGroup)b.findViewById(0x7f0a0063), s);
        b.dismiss();
    }

    n(Activity activity, n n1)
    {
        a = activity;
        b = n1;
        super();
    }
}
