// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.util.s;

// Referenced classes of package com.socialin.android.ads:
//            SocialinAdView

final class a
    implements android.view.ner
{

    private Intent a;
    private SocialinAdView b;

    public final void onClick(View view)
    {
        if (!s.a(b.getContext()))
        {
            DialogUtils.showNoNetworkDialog((Activity)b.getContext(), 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
            return;
        } else
        {
            b.getContext().startActivity(a);
            return;
        }
    }

    (SocialinAdView socialinadview, Intent intent)
    {
        b = socialinadview;
        a = intent;
        super();
    }
}
