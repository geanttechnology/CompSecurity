// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity, a

final class a
    implements android.widget.istener
{

    private SelectCalloutActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        SelectCalloutActivity.a(a, a.b[i]);
        SelectCalloutActivity.b(a, i);
        SelectCalloutActivity.h(a);
        AnalyticUtils.getInstance(a).trackLocalAction("callout:change");
    }

    (SelectCalloutActivity selectcalloutactivity)
    {
        a = selectcalloutactivity;
        super();
    }
}
