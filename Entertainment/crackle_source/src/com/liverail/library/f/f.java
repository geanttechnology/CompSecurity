// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.widget.VideoView;
import com.liverail.library.b.a;

// Referenced classes of package com.liverail.library.f:
//            a

class f
    implements Runnable
{

    final com.liverail.library.f.a a;

    f(com.liverail.library.f.a a1)
    {
        a = a1;
        super();
    }

    public void run()
    {
        if (com.liverail.library.f.a.d(a) == null || com.liverail.library.f.a.e(a) == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        a.postDelayed(com.liverail.library.f.a.l(a), 250L);
        com.liverail.library.f.a.a(a, com.liverail.library.f.a.f(a).getCurrentPosition(), com.liverail.library.f.a.f(a).getDuration());
        return;
        Exception exception;
        exception;
        com.liverail.library.b.a.d(exception.getMessage());
        return;
    }
}
