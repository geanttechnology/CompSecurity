// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity

final class a
    implements android.widget.istener
{

    private SelectCalloutActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = SelectCalloutActivity.d(a).getText().toString();
        adapterview = view;
        if (view.equals(""))
        {
            adapterview = a.getString(0x7f080604);
        }
        SelectCalloutActivity.a(a, adapterview, i, SelectCalloutActivity.f(a));
        SelectCalloutActivity.a(a, i);
        SelectCalloutActivity.a(a, adapterview);
        AnalyticUtils.getInstance(a).trackLocalAction("callout:apply");
    }

    (SelectCalloutActivity selectcalloutactivity)
    {
        a = selectcalloutactivity;
        super();
    }
}
