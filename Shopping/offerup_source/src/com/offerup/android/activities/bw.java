// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.AdapterView;
import com.offerup.android.dto.Discussion;
import java.util.ArrayList;

// Referenced classes of package com.offerup.android.activities:
//            DiscussionsListActivity, a

final class bw
    implements android.widget.AdapterView.OnItemClickListener
{

    private DiscussionsListActivity a;

    bw(DiscussionsListActivity discussionslistactivity)
    {
        a = discussionslistactivity;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Discussion)a.a.get(i - 1);
        a.f.a(adapterview.getId(), a.b, false);
    }
}
