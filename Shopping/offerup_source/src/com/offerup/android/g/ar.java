// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.net.Uri;
import android.view.View;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.ay;

// Referenced classes of package com.offerup.android.g:
//            ae

final class ar
    implements android.view.View.OnClickListener
{

    private ae a;

    ar(ae ae1)
    {
        a = ae1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("ItemShareSheet_MessageOption_click");
        com.offerup.android.g.ae.a(a).b(ae.b(a).toString());
        a.dismiss();
    }
}
