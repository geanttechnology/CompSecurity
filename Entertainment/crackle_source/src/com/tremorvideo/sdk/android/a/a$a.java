// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.a;

import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.a:
//            a

class a extends TimerTask
{

    final a a;

    public void run()
    {
        a.b.cancel();
        a.b.purge();
        a.b = null;
        com.tremorvideo.sdk.android.a.a.a(a);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
