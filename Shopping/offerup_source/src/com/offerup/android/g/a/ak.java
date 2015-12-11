// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;

// Referenced classes of package com.offerup.android.g.a:
//            aj, g

final class ak
    implements android.view.View.OnClickListener
{

    private aj a;

    ak(aj aj1)
    {
        a = aj1;
        super();
    }

    public final void onClick(View view)
    {
        if (aj.a(a) != null)
        {
            aj.a(a).a("fab");
        }
    }
}
