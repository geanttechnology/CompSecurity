// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import com.offerup.android.activities.a;

// Referenced classes of package com.offerup.android.g:
//            k

final class o
    implements android.view.View.OnClickListener
{

    private k a;

    o(k k1)
    {
        a = k1;
        super();
    }

    public final void onClick(View view)
    {
        (new a(a.getActivity())).i();
    }
}
