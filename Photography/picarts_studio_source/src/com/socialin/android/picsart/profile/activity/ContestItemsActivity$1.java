// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import java.util.List;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ContestItemsActivity

final class a extends android.support.v4.view.hangeListener
{

    private ContestItemsActivity a;

    public final void onPageSelected(int i)
    {
        super.onPageSelected(i);
        ContestItemsActivity.a(a, i);
        a.getIntent().putExtra("contestItemsOrder", ((com.socialin.android.apiv3.model.msActivity.getIntent)ContestItemsActivity.b(a).get(ContestItemsActivity.a(a))).er);
    }

    (ContestItemsActivity contestitemsactivity)
    {
        a = contestitemsactivity;
        super();
    }
}
