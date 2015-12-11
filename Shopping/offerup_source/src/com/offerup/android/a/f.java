// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.View;
import com.offerup.android.activities.MyArchivedOffersActivity;

// Referenced classes of package com.offerup.android.a:
//            e

final class f
    implements android.view.View.OnClickListener
{

    private int a;
    private e b;

    f(e e1, int i)
    {
        b = e1;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        b.a.b(a);
    }
}
