// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.main;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.main:
//            DateAndTimeListActivity

final class a
    implements android.widget.tener
{

    private DateAndTimeListActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent();
        adapterview.putExtra("text", (String)DateAndTimeListActivity.a(a).get(i));
        a.setResult(-1, adapterview);
        a.finish();
        AnalyticUtils.getInstance(a).trackLocalAction("dateTime:done");
    }

    (DateAndTimeListActivity dateandtimelistactivity)
    {
        a = dateandtimelistactivity;
        super();
    }
}
