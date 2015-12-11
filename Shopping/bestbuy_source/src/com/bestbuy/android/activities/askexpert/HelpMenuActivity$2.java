// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.askexpert;

import android.content.Intent;
import android.view.View;
import com.bestbuy.android.activities.blueassist.BlueAssistDepartmentSelectionActivity;
import java.util.HashMap;
import lu;

// Referenced classes of package com.bestbuy.android.activities.askexpert:
//            HelpMenuActivity

class a
    implements android.view.r
{

    final HelpMenuActivity a;

    public void onClick(View view)
    {
        if (HelpMenuActivity.c(a) == null || !HelpMenuActivity.c(a).equals("PurchasingProduct")) goto _L2; else goto _L1
_L1:
        view = new HashMap();
        view.put("bb.prevPageLink", lu.aV);
        view.put("bb.makeAppt", "1");
        lu.b(lu.aY, view);
_L4:
        view = new Intent(a, com/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity);
        a.startActivity(view);
        return;
_L2:
        if (HelpMenuActivity.c(a) != null && HelpMenuActivity.c(a).equals("ExistingOrder"))
        {
            view = new HashMap();
            view.put("bb.prevPageLink", "Blue Assist: Existing Order: Mobile");
            view.put("bb.makeAppt", "1");
            lu.b("Blue Assist: Existing Order: Mobile: Make Appt", view);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ntSelectionActivity(HelpMenuActivity helpmenuactivity)
    {
        a = helpmenuactivity;
        super();
    }
}
