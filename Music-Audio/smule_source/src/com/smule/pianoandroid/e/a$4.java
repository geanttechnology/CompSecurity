// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import com.smule.android.c.aa;
import com.smule.pianoandroid.a.v;

// Referenced classes of package com.smule.pianoandroid.e:
//            a, b

class c
    implements Runnable
{

    final v a;
    final int b;
    final b c;
    final a d;

    public void run()
    {
        com.smule.pianoandroid.a.t t = d.a(a, b);
        if (c != null)
        {
            c.a(t);
        }
_L2:
        return;
        Object obj;
        obj;
        aa.b(a.a, (new StringBuilder()).append("Exception registering game event!").append(((Exception) (obj)).toString()).toString(), ((Throwable) (obj)));
        if (c == null) goto _L2; else goto _L1
_L1:
        c.a(null);
        return;
        obj;
        if (c != null)
        {
            c.a(null);
        }
        throw obj;
    }

    (a a1, v v, int i, b b1)
    {
        d = a1;
        a = v;
        b = i;
        c = b1;
        super();
    }
}
