// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.view.View;
import com.liverail.library.g.a;
import com.liverail.library.g.b;

// Referenced classes of package com.liverail.library.f:
//            a, i

class h
    implements android.view.View.OnClickListener
{

    final com.liverail.library.f.a a;

    h(com.liverail.library.f.a a1)
    {
        a = a1;
        super();
    }

    public void onClick(View view)
    {
        int j;
        if (com.liverail.library.f.a.d(a).i.d)
        {
            j = com.liverail.library.f.a.g(a) * com.liverail.library.f.a.d(a).i.c;
        } else
        {
            j = com.liverail.library.f.a.d(a).i.c * 1000;
        }
        if (j < com.liverail.library.f.a.h(a))
        {
            com.liverail.library.b.a.c((new StringBuilder("User has skipped at ")).append(com.liverail.library.f.a.h(a)).append(" ms / skippableAt=").append(j).toString());
            a.d();
            if (com.liverail.library.f.a.c(a) != null)
            {
                com.liverail.library.f.a.c(a).i();
                com.liverail.library.f.a.c(a).j();
            }
            return;
        } else
        {
            com.liverail.library.b.a.c((new StringBuilder("User has clicked but ad is not skippable yet! skippableAt=")).append(j).append(" position=").append(com.liverail.library.f.a.h(a)).toString());
            return;
        }
    }
}
