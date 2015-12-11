// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e

class a
    implements Runnable
{

    final e a;

    public void run()
    {
        if (e.d(a).isPlaying()) goto _L2; else goto _L1
_L1:
        if (a.s)
        {
            e.n(a);
        }
_L4:
        e.h(a).postDelayed(this, 500L);
        return;
_L2:
        int i = e.d(a).getCurrentPosition();
        e.e(a, i);
        e.c(a, i);
        if (a.t)
        {
            e.h(a).a(e.o(a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
