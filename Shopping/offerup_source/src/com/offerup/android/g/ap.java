// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g:
//            ae

final class ap
    implements android.view.View.OnClickListener
{

    private ae a;

    ap(ae ae1)
    {
        a = ae1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("ou_invitemodal_close_click");
        a.dismiss();
    }
}
