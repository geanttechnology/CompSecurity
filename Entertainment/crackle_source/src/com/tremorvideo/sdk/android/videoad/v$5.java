// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v

class a
    implements Runnable
{

    final v a;

    public void run()
    {
        if (!v.e(a).isPlaying())
        {
            if (a.o)
            {
                v.n(a);
            }
        } else
        {
            int i = v.e(a).getCurrentPosition();
            v.e(a, i);
            v.c(a, i);
            v.i(a).a(v.o(a));
        }
        v.i(a).postDelayed(this, 500L);
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
