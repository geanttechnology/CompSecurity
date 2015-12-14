// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.os.Handler;
import android.widget.VideoView;
import com.facebook.ads.internal.util.t;

// Referenced classes of package com.facebook.ads.internal.view:
//            g

final class nit> extends t
{

    public void run()
    {
        g g1 = (g)a();
        if (g1 != null)
        {
            int i = g.a(g1).getCurrentPosition();
            if (i > g.b(g1))
            {
                g.a(g1, i);
            }
            g.c(g1).postDelayed(this, 250L);
        }
    }

    public (g g1)
    {
        super(g1);
    }
}
