// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            ChangeLocationActivity, SortAndFilterActivity

final class hp
    implements android.view.View.OnClickListener
{

    private SortAndFilterActivity a;

    hp(SortAndFilterActivity sortandfilteractivity)
    {
        a = sortandfilteractivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.a("ou_sort_filter_location", null);
        view = new Intent(a, com/offerup/android/activities/ChangeLocationActivity);
        a.startActivityForResult(view, 615);
    }
}
