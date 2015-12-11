// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;

// Referenced classes of package com.offerup.android.g.a:
//            p, ae

final class r
    implements android.view.View.OnClickListener
{

    private p a;

    r(p p1)
    {
        a = p1;
        super();
    }

    public final void onClick(View view)
    {
        if (p.b(a) != null)
        {
            p.b(a).a(p.c(a));
        }
    }
}
