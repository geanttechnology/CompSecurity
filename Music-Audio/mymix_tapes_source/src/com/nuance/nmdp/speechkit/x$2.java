// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ay;
import ba;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            x, Prompt

final class a
    implements Runnable
{

    private x a;

    public final void run()
    {
        x.b(a).a();
        int j = x.c(a).c();
        for (int i = 0; i < j; i++)
        {
            ((Prompt)x.c(a).a()).a().c();
        }

    }

    pt(x x1)
    {
        a = x1;
        super();
    }
}
