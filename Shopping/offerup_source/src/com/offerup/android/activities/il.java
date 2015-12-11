// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            ik, UserDetailActivity, a

final class il
    implements android.view.View.OnClickListener
{

    private ik a;

    il(ik ik1)
    {
        a = ik1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("UserProfile:TruYouPopup_LearnMore-Button_click");
        a.a.f.a("truyou/", false, "TruYou");
    }
}
