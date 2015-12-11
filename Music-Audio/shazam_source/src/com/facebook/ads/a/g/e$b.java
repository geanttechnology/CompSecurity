// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.os.Handler;
import android.widget.VideoView;
import com.facebook.ads.a.f.u;
import java.lang.ref.WeakReference;

// Referenced classes of package com.facebook.ads.a.g:
//            e

private static final class nit> extends u
{

    public final void run()
    {
        e e1 = (e)super.a.get();
        if (e1 != null)
        {
            int i = e.a(e1).getCurrentPosition();
            if (i > e.b(e1))
            {
                e.a(e1, i);
            }
            e.c(e1).postDelayed(this, 250L);
        }
    }

    public ce(e e1)
    {
        super(e1);
    }
}
