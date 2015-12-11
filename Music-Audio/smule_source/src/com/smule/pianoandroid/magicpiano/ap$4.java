// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.pianoandroid.utils.t;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap, MagicApplication

class a
    implements Runnable
{

    final String a;
    final ap b;

    public void run()
    {
        if (MagicApplication.isAdvertisingEnabled().booleanValue())
        {
            t.b();
            ap.b(b, a);
        }
    }

    Application(ap ap1, String s)
    {
        b = ap1;
        a = s;
        super();
    }
}
