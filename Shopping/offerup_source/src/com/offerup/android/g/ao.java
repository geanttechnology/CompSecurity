// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.ay;

// Referenced classes of package com.offerup.android.g:
//            ae

final class ao
    implements android.view.View.OnClickListener
{

    private ae a;

    ao(ae ae1)
    {
        a = ae1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("ou_invitemodal_more_click");
        com.offerup.android.g.ae.a(a).a(a.getString(0x7f0901e8), a.getString(0x7f0901ea), a.getString(0x7f0901e9));
        a.dismiss();
    }
}
