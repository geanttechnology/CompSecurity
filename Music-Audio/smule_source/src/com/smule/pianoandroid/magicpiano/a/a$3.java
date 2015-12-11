// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import android.support.v4.app.FragmentActivity;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            a

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        if (!a.f.isFinishing())
        {
            a.f.runOnUiThread(a.h);
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
