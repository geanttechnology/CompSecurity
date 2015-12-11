// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.support.design.widget.Snackbar;
import android.view.View;

// Referenced classes of package com.offerup.android.g:
//            am

final class an
    implements android.view.View.OnClickListener
{

    private Snackbar a;

    an(am am, Snackbar snackbar)
    {
        a = snackbar;
        super();
    }

    public final void onClick(View view)
    {
        a.b();
    }
}
