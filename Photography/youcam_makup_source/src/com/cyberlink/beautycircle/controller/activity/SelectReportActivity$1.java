// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.i;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SelectReportActivity

class a
    implements android.widget.Listener
{

    final SelectReportActivity a;

    public void onItemClick(AdapterView adapterview, View view, int j, long l)
    {
        SelectReportActivity.a(a, (String)SelectReportActivity.a(a).getItem(j));
        view.setSelected(true);
        a.b().d(i.bc_report_button_background);
        a.b().f(true);
        a.b().g(true);
    }

    (SelectReportActivity selectreportactivity)
    {
        a = selectreportactivity;
        super();
    }
}
