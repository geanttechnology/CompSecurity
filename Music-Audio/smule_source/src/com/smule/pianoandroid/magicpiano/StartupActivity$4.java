// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.pianoandroid.e.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            StartupActivity

class a
    implements Runnable
{

    final StartupActivity a;

    public void run()
    {
        StartupActivity.b(a, true);
        StartupActivity.a(a, false);
        i.a().b();
        a.c();
    }

    _cls9(StartupActivity startupactivity)
    {
        a = startupactivity;
        super();
    }
}
