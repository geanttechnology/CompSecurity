// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.support.v4.app.FragmentActivity;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class c
    implements Runnable
{

    final FragmentActivity a;
    final Runnable b;
    final Runnable c;

    public void run()
    {
        o.a(a, b, c);
    }

    ivity(FragmentActivity fragmentactivity, Runnable runnable, Runnable runnable1)
    {
        a = fragmentactivity;
        b = runnable;
        c = runnable1;
        super();
    }
}
