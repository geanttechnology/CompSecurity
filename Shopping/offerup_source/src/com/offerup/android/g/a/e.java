// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;
import com.offerup.android.utils.ba;

// Referenced classes of package com.offerup.android.g.a:
//            a

final class e
    implements android.view.View.OnClickListener
{

    private a a;

    e(a a1)
    {
        a = a1;
        super();
    }

    public final void onClick(View view)
    {
label0:
        {
            if (com.offerup.android.g.a.a.c(a) != null)
            {
                if (!ba.a())
                {
                    break label0;
                }
                com.offerup.android.g.a.a.d(a);
            }
            return;
        }
        com.offerup.android.g.a.a.e(a);
    }
}
