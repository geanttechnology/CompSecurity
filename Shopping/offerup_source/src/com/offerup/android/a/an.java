// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.support.v7.widget.CardView;
import android.view.View;

// Referenced classes of package com.offerup.android.a:
//            ao, al

final class an
    implements android.view.View.OnClickListener
{

    private ao a;

    an(al al, ao ao1)
    {
        a = ao1;
        super();
    }

    public final void onClick(View view)
    {
        a.d.performClick();
    }
}
