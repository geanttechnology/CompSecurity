// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            ik, UserDetailActivity

final class im
    implements android.view.View.OnClickListener
{

    private ik a;

    im(ik ik1)
    {
        a = ik1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("UserProfile:TruYouPopup_Close-Button_click");
        UserDetailActivity.j(a.a);
    }
}
