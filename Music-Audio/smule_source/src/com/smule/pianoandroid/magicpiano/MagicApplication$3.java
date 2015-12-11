// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.Toast;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication

class b
    implements Runnable
{

    final String a;
    final int b;
    final MagicApplication c;

    public void run()
    {
        Toast.makeText(c, a, b).show();
    }

    (MagicApplication magicapplication, String s, int i)
    {
        c = magicapplication;
        a = s;
        b = i;
        super();
    }
}
