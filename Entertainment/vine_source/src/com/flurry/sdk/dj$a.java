// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.TimerTask;

// Referenced classes of package com.flurry.sdk:
//            dj

class b extends TimerTask
{

    final dj a;
    private q b;

    public void run()
    {
        a.a();
        if (b != null)
        {
            b.q();
        }
    }

    (dj dj1,  )
    {
        a = dj1;
        super();
        b = ;
    }
}
