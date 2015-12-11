// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import com.offerup.android.activities.a;

// Referenced classes of package com.offerup.android.g:
//            i

final class j
    implements android.view.View.OnClickListener
{

    private i a;

    j(i k)
    {
        a = k;
        super();
    }

    public final void onClick(View view)
    {
        (new a(a.getActivity())).k();
    }
}
