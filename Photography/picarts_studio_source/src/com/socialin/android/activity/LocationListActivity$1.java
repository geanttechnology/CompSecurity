// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.activity:
//            LocationListActivity, c

final class a
    implements android.widget.Listener
{

    private LocationListActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent();
        adapterview.putExtra("text", ((c)LocationListActivity.access$000(a).getItem(i)).a);
        adapterview.putExtra("venue_Id", ((c)LocationListActivity.access$000(a).getItem(i)).b);
        a.setResult(-1, adapterview);
        a.finish();
        AnalyticUtils.getInstance(a).trackLocalAction("location:done");
    }

    cationAdapter(LocationListActivity locationlistactivity)
    {
        a = locationlistactivity;
        super();
    }
}
