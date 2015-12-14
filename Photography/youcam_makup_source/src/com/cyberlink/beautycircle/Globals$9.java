// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.widget.Toast;

// Referenced classes of package com.cyberlink.beautycircle:
//            Globals

final class b
    implements Runnable
{

    final CharSequence a;
    final int b;

    public void run()
    {
        if (Globals.H() != null)
        {
            Globals.H().cancel();
        }
        Globals.a(Toast.makeText(Globals.n(), a, b));
        Globals.H().show();
    }

    (CharSequence charsequence, int i)
    {
        a = charsequence;
        b = i;
        super();
    }
}
