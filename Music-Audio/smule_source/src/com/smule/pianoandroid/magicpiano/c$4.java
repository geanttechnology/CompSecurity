// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            c

class a extends TimerTask
{

    final c a;

    public void run()
    {
        c.g(a).sendEmptyMessage(0);
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
