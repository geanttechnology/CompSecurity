// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.support.v4.app.t;
import android.view.View;

// Referenced classes of package com.offerup.android.g:
//            k

final class m
    implements android.view.View.OnClickListener
{

    private k a;

    m(k k1)
    {
        a = k1;
        super();
    }

    public final void onClick(View view)
    {
        a.getActivity().finish();
    }
}
