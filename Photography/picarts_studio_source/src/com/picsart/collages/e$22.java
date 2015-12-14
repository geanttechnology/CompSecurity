// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.Intent;

// Referenced classes of package com.picsart.collages:
//            e

final class a
    implements Runnable
{

    private Intent a;
    private e b;

    public final void run()
    {
        e.a(b, a, a.getIntExtra("cType", 0));
    }

    (e e1, Intent intent)
    {
        b = e1;
        a = intent;
        super();
    }
}
