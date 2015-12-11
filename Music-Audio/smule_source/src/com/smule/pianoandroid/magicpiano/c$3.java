// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            c

class a extends Handler
{

    final c a;

    public void handleMessage(Message message)
    {
        if (c.b(a) == 0)
        {
            c.a(a, (c.c(a) + 1) % 3);
        } else
        if (c.b(a) == 1)
        {
            c.b(a, 500);
            if (c.d(a) >= 2000)
            {
                if (a.isResumed())
                {
                    a.dismiss();
                    return;
                } else
                {
                    c.e(a).setVisibility(4);
                    c.f(a).setVisibility(0);
                    return;
                }
            }
        }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
