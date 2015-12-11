// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.crittercism.app.Crittercism;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.d.g;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            aq, ap

class c
    implements Runnable
{

    final String a;
    final String b;
    final String c;
    final aq d;

    public void run()
    {
        if (ap.c(d.a) > 0)
        {
            Crittercism.a((new Exception()).initCause(ap.d(d.a)));
            return;
        }
        ap.e(d.a);
        com.smule.pianoandroid.magicpiano.ap.a(d.a, new Exception());
        try
        {
            ap.f(d.a).b(a);
            com.smule.android.c.a.a(a, b, c);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            aa.b(ap.d(), (new StringBuilder()).append("Failed to purchase subscription ").append(a).toString(), illegalstateexception);
            Crittercism.a(illegalstateexception);
            return;
        }
    }

    (aq aq1, String s, String s1, String s2)
    {
        d = aq1;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
