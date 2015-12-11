// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.View;
import com.offerup.android.h.a;

// Referenced classes of package com.offerup.android.a:
//            aa

final class ab
    implements android.view.View.OnClickListener
{

    private int a;
    private aa b;

    ab(aa aa1, int i)
    {
        b = aa1;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.a.aa.a(b).b(a);
    }
}
