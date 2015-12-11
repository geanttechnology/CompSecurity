// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.groupon.util.GrouponDialogFragment;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.activity:
//            GrouponActivityDelegate, IntentFactory

class this._cls0
    implements android.widget.tener
{

    final GrouponActivityDelegate this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = (GrouponDialogFragment)GrouponActivityDelegate.access$300(GrouponActivityDelegate.this).getFragmentManager().findFragmentByTag("report_a_bug_dialog");
        if (view != null)
        {
            adapterview = view.getArguments().getString("dialog_screen_shot");
            Activity activity = GrouponActivityDelegate.access$300(GrouponActivityDelegate.this);
            if (i == 0)
            {
                adapterview = ((IntentFactory)GrouponActivityDelegate.access$400(GrouponActivityDelegate.this).get()).newCustomerServiceIntent();
            } else
            {
                adapterview = ((IntentFactory)GrouponActivityDelegate.access$400(GrouponActivityDelegate.this).get()).newBugReportIntent(GrouponActivityDelegate.access$300(GrouponActivityDelegate.this).getClass().getSimpleName(), adapterview);
            }
            activity.startActivity(adapterview);
            view.dismiss();
        }
    }

    ()
    {
        this$0 = GrouponActivityDelegate.this;
        super();
    }
}
