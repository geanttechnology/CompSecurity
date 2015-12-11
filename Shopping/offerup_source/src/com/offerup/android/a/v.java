// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.View;
import com.offerup.android.h.a;

// Referenced classes of package com.offerup.android.a:
//            u

final class v
    implements android.view.View.OnClickListener
{

    private int a;
    private u b;

    v(u u1, int i)
    {
        b = u1;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        b.a.b(a);
    }
}
